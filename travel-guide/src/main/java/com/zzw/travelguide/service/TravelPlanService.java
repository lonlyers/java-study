package com.zzw.travelguide.service;

import com.zzw.travelguide.model.*;
import com.zzw.travelguide.repository.AttractionRepository;
import com.zzw.travelguide.repository.PlanAttractionRepository;
import com.zzw.travelguide.repository.TravelPlanRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class TravelPlanService {

    private final TravelPlanRepository travelPlanRepository;
    private final PlanAttractionRepository planAttractionRepository;
    private final AttractionRepository attractionRepository;
    private final CityService cityService;

    @Value("${travel-guide.upload-dir:./uploads/photos}")
    private String uploadDir;

    public TravelPlanService(TravelPlanRepository travelPlanRepository,
                             PlanAttractionRepository planAttractionRepository,
                             AttractionRepository attractionRepository,
                             CityService cityService) {
        this.travelPlanRepository = travelPlanRepository;
        this.planAttractionRepository = planAttractionRepository;
        this.attractionRepository = attractionRepository;
        this.cityService = cityService;
    }

    @Transactional(readOnly = true)
    public List<TravelPlan> getAllPlans() {
        return travelPlanRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional(readOnly = true)
    public TravelPlan getPlanById(Long id) {
        return travelPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("旅游攻略不存在，ID: " + id));
    }

    @Transactional(readOnly = true)
    public TravelPlan getPlanWithDetails(Long id) {
        TravelPlan plan = getPlanById(id);
        // Force load lazy associations
        plan.getPlanAttractions().size();
        plan.getCity().getName();
        return plan;
    }

    public TravelPlan createPlan(String title, Long cityId, List<Long> attractionIds) {
        City city = cityService.getCityById(cityId);
        TravelPlan plan = new TravelPlan(title, city);
        plan = travelPlanRepository.save(plan);

        for (int i = 0; i < attractionIds.size(); i++) {
            Attraction attraction = attractionRepository.findById(attractionIds.get(i))
                    .orElseThrow(() -> new RuntimeException("景点不存在"));
            PlanAttraction pa = new PlanAttraction(plan, attraction, i + 1);
            planAttractionRepository.save(pa);
            plan.getPlanAttractions().add(pa);
        }

        return plan;
    }

    public TravelPlan updatePlanAttractions(Long planId, List<Long> attractionIds) {
        TravelPlan plan = getPlanById(planId);
        travelPlanRepository.flush();
        plan.getPlanAttractions().clear();

        for (int i = 0; i < attractionIds.size(); i++) {
            Attraction attraction = attractionRepository.findById(attractionIds.get(i))
                    .orElseThrow(() -> new RuntimeException("景点不存在"));
            PlanAttraction pa = new PlanAttraction(plan, attraction, i + 1);
            planAttractionRepository.save(pa);
            plan.getPlanAttractions().add(pa);
        }

        return plan;
    }

    public PlanAttraction updatePlanAttractionComment(Long planAttractionId, String comment) {
        PlanAttraction pa = planAttractionRepository.findById(planAttractionId)
                .orElseThrow(() -> new RuntimeException("攻略景点节点不存在，ID: " + planAttractionId));
        pa.setComment(comment);
        return planAttractionRepository.save(pa);
    }

    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp"
    );

    public PlanAttraction uploadPhoto(Long planAttractionId, MultipartFile file) throws IOException {
        PlanAttraction pa = planAttractionRepository.findById(planAttractionId)
                .orElseThrow(() -> new RuntimeException("攻略景点节点不存在，ID: " + planAttractionId));

        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String originalFilename = file.getOriginalFilename();
        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        }

        if (!extension.isEmpty() && !ALLOWED_EXTENSIONS.contains(extension)) {
            throw new IllegalArgumentException("不支持的图片格式: " + extension);
        }

        // Generate a safe filename using UUID to prevent path traversal
        String filename = UUID.randomUUID() + extension;
        Path filePath = uploadPath.resolve(filename).normalize();

        // Validate the resolved path is still within the upload directory
        if (!filePath.startsWith(uploadPath)) {
            throw new IllegalArgumentException("Invalid file path");
        }

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        pa.setPhotoPath(filename);
        return planAttractionRepository.save(pa);
    }

    public void deletePlan(Long id) {
        travelPlanRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PlanAttraction> getPlanAttractions(Long planId) {
        return planAttractionRepository.findByTravelPlanIdOrderBySortOrderAsc(planId);
    }
}
