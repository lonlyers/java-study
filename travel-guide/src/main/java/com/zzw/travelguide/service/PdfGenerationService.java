package com.zzw.travelguide.service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.zzw.travelguide.model.PlanAttraction;
import com.zzw.travelguide.model.TravelPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

@Service
public class PdfGenerationService {

    private static final Logger log = LoggerFactory.getLogger(PdfGenerationService.class);

    @Value("${travel-guide.upload-dir:./uploads/photos}")
    private String uploadDir;

    private final TravelPlanService travelPlanService;

    public PdfGenerationService(TravelPlanService travelPlanService) {
        this.travelPlanService = travelPlanService;
    }

    public byte[] generatePdf(Long planId) throws IOException, DocumentException {
        TravelPlan plan = travelPlanService.getPlanWithDetails(planId);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter.getInstance(document, baos);
        document.open();

        BaseFont baseFont = getBaseFont();
        Font titleFont = new Font(baseFont, 24, Font.BOLD, new Color(44, 62, 80));
        Font subtitleFont = new Font(baseFont, 14, Font.NORMAL, new Color(127, 140, 141));
        Font sectionFont = new Font(baseFont, 18, Font.BOLD, new Color(41, 128, 185));
        Font bodyFont = new Font(baseFont, 12, Font.NORMAL, new Color(52, 73, 94));
        Font labelFont = new Font(baseFont, 12, Font.BOLD, new Color(44, 62, 80));
        Font orderFont = new Font(baseFont, 16, Font.BOLD, Color.WHITE);

        // Title
        Paragraph title = new Paragraph(plan.getTitle(), titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(10);
        document.add(title);

        // City and date info
        String cityInfo = "City: " + plan.getCity().getName();
        Paragraph cityParagraph = new Paragraph(cityInfo, subtitleFont);
        cityParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(cityParagraph);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateInfo = "Created: " + plan.getCreatedAt().format(formatter);
        Paragraph dateParagraph = new Paragraph(dateInfo, subtitleFont);
        dateParagraph.setAlignment(Element.ALIGN_CENTER);
        dateParagraph.setSpacingAfter(30);
        document.add(dateParagraph);

        // Divider
        addDivider(document);

        // Attractions
        for (PlanAttraction pa : plan.getPlanAttractions()) {
            document.add(new Paragraph(" "));

            // Attraction header with order number
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[]{1, 9});

            // Order number circle
            PdfPCell orderCell = new PdfPCell();
            Paragraph orderText = new Paragraph(String.valueOf(pa.getSortOrder()), orderFont);
            orderText.setAlignment(Element.ALIGN_CENTER);
            orderCell.addElement(orderText);
            orderCell.setBackgroundColor(new Color(41, 128, 185));
            orderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            orderCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            orderCell.setBorder(0);
            orderCell.setPadding(8);
            headerTable.addCell(orderCell);

            // Attraction name
            PdfPCell nameCell = new PdfPCell();
            nameCell.addElement(new Paragraph(pa.getAttraction().getName(), sectionFont));
            if (pa.getAttraction().getAddress() != null) {
                Paragraph addrParagraph = new Paragraph(pa.getAttraction().getAddress(), subtitleFont);
                nameCell.addElement(addrParagraph);
            }
            nameCell.setBorder(0);
            nameCell.setPaddingLeft(10);
            nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            headerTable.addCell(nameCell);

            document.add(headerTable);

            // Attraction description
            if (pa.getAttraction().getDescription() != null
                    && !pa.getAttraction().getDescription().isEmpty()) {
                Paragraph desc = new Paragraph(pa.getAttraction().getDescription(), bodyFont);
                desc.setIndentationLeft(50);
                desc.setSpacingBefore(5);
                document.add(desc);
            }

            // User comment
            if (pa.getComment() != null && !pa.getComment().isEmpty()) {
                Paragraph commentLabel = new Paragraph("Notes:", labelFont);
                commentLabel.setIndentationLeft(50);
                commentLabel.setSpacingBefore(10);
                document.add(commentLabel);

                Paragraph comment = new Paragraph(pa.getComment(), bodyFont);
                comment.setIndentationLeft(50);
                document.add(comment);
            }

            // Photo
            if (pa.getPhotoPath() != null && !pa.getPhotoPath().isEmpty()) {
                try {
                    Path photoFile = Paths.get(uploadDir, pa.getPhotoPath());
                    File file = photoFile.toFile();
                    if (file.exists()) {
                        Image img = Image.getInstance(file.getAbsolutePath());
                        float maxWidth = 400;
                        float maxHeight = 300;
                        float imgWidth = img.getWidth();
                        float imgHeight = img.getHeight();

                        if (imgWidth > maxWidth || imgHeight > maxHeight) {
                            float ratio = Math.min(maxWidth / imgWidth, maxHeight / imgHeight);
                            img.scalePercent(ratio * 100);
                        }

                        img.setAlignment(Element.ALIGN_CENTER);
                        img.setSpacingBefore(10);
                        img.setSpacingAfter(10);
                        document.add(img);
                    }
                } catch (Exception e) {
                    Paragraph errorMsg = new Paragraph("[Photo unavailable]", subtitleFont);
                    errorMsg.setIndentationLeft(50);
                    document.add(errorMsg);
                }
            }

            addDivider(document);
        }

        // Footer
        document.add(new Paragraph(" "));
        Paragraph footer = new Paragraph("-- Generated by Travel Guide System --", subtitleFont);
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);

        document.close();
        return baos.toByteArray();
    }

    private BaseFont getBaseFont() {
        // Try common Chinese font paths on different OS
        String[] fontPaths = {
                "/usr/share/fonts/truetype/wqy/wqy-zenhei.ttc,0",
                "/usr/share/fonts/truetype/wqy/wqy-microhei.ttc,0",
                "/usr/share/fonts/opentype/noto/NotoSansCJK-Regular.ttc,0",
                "/usr/share/fonts/truetype/noto/NotoSansCJK-Regular.ttc,0",
                "/usr/share/fonts/noto-cjk/NotoSansCJK-Regular.ttc,0",
                "C:\\Windows\\Fonts\\simsun.ttc,0",
                "C:\\Windows\\Fonts\\msyh.ttc,0",
                "/System/Library/Fonts/STHeiti Light.ttc,0",
                "/System/Library/Fonts/PingFang.ttc,0",
        };

        for (String fontPath : fontPaths) {
            try {
                String filePath = fontPath.contains(",") ? fontPath.substring(0, fontPath.lastIndexOf(",")) : fontPath;
                if (new File(filePath).exists()) {
                    return BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                }
            } catch (Exception e) {
                log.debug("Failed to load font from path: {}", fontPath, e);
                // Continue to next font
            }
        }

        // Fallback to Helvetica
        try {
            return BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create font", e);
        }
    }

    private void addDivider(Document document) throws DocumentException {
        PdfPTable divider = new PdfPTable(1);
        divider.setWidthPercentage(90);
        PdfPCell cell = new PdfPCell();
        cell.setBorderWidthBottom(1);
        cell.setBorderColorBottom(new Color(189, 195, 199));
        cell.setBorderWidthTop(0);
        cell.setBorderWidthLeft(0);
        cell.setBorderWidthRight(0);
        cell.setFixedHeight(1);
        divider.addCell(cell);
        divider.setSpacingBefore(10);
        divider.setSpacingAfter(10);
        document.add(divider);
    }
}
