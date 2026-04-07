package com.zzw.travelguide.controller;

import com.zzw.travelguide.model.PlanAttraction;
import com.zzw.travelguide.model.TravelPlan;
import com.zzw.travelguide.service.PdfGenerationService;
import com.zzw.travelguide.service.TravelPlanService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/plans")
public class TravelPlanController {

    private final TravelPlanService travelPlanService;
    private final PdfGenerationService pdfGenerationService;

    public TravelPlanController(TravelPlanService travelPlanService,
                                PdfGenerationService pdfGenerationService) {
        this.travelPlanService = travelPlanService;
        this.pdfGenerationService = pdfGenerationService;
    }

    @GetMapping
    public ResponseEntity<List<TravelPlan>> getAllPlans() {
        return ResponseEntity.ok(travelPlanService.getAllPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPlan> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(travelPlanService.getPlanWithDetails(id));
    }

    @GetMapping("/{id}/attractions")
    public ResponseEntity<List<PlanAttraction>> getPlanAttractions(@PathVariable Long id) {
        return ResponseEntity.ok(travelPlanService.getPlanAttractions(id));
    }

    @PostMapping
    public ResponseEntity<TravelPlan> createPlan(@RequestBody CreatePlanRequest request) {
        TravelPlan plan = travelPlanService.createPlan(
                request.title(), request.cityId(), request.attractionIds());
        return ResponseEntity.ok(plan);
    }

    @PutMapping("/{id}/attractions")
    public ResponseEntity<TravelPlan> updatePlanAttractions(
            @PathVariable Long id,
            @RequestBody UpdateAttractionsRequest request) {
        TravelPlan plan = travelPlanService.updatePlanAttractions(id, request.attractionIds());
        return ResponseEntity.ok(plan);
    }

    @PutMapping("/attractions/{planAttractionId}/comment")
    public ResponseEntity<PlanAttraction> updateComment(
            @PathVariable Long planAttractionId,
            @RequestBody Map<String, String> body) {
        String comment = body.get("comment");
        PlanAttraction pa = travelPlanService.updatePlanAttractionComment(planAttractionId, comment);
        return ResponseEntity.ok(pa);
    }

    @PostMapping("/attractions/{planAttractionId}/photo")
    public ResponseEntity<?> uploadPhoto(
            @PathVariable Long planAttractionId,
            @RequestParam("file") MultipartFile file) {
        try {
            PlanAttraction pa = travelPlanService.uploadPhoto(planAttractionId, file);
            return ResponseEntity.ok(pa);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", "Failed to upload photo"));
        }
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> generatePdf(@PathVariable Long id) {
        try {
            byte[] pdfBytes = pdfGenerationService.generatePdf(id);
            TravelPlan plan = travelPlanService.getPlanById(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            String sanitized = plan.getTitle().replaceAll("[^a-zA-Z0-9\\u4e00-\\u9fa5]", "_");
            if (sanitized.isEmpty()) {
                sanitized = "travel_guide";
            }
            if (sanitized.length() > 100) {
                sanitized = sanitized.substring(0, 100);
            }
            headers.setContentDispositionFormData("attachment", sanitized + ".pdf");

            return ResponseEntity.ok().headers(headers).body(pdfBytes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", "Failed to generate PDF"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        travelPlanService.deletePlan(id);
        return ResponseEntity.ok().build();
    }

    public record CreatePlanRequest(String title, Long cityId, List<Long> attractionIds) {}
    public record UpdateAttractionsRequest(List<Long> attractionIds) {}
}
