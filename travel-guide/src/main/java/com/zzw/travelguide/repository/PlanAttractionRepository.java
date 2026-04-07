package com.zzw.travelguide.repository;

import com.zzw.travelguide.model.PlanAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanAttractionRepository extends JpaRepository<PlanAttraction, Long> {

    List<PlanAttraction> findByTravelPlanIdOrderBySortOrderAsc(Long travelPlanId);
}
