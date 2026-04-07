package com.zzw.travelguide.repository;

import com.zzw.travelguide.model.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {

    List<TravelPlan> findAllByOrderByCreatedAtDesc();

    List<TravelPlan> findByCityIdOrderByCreatedAtDesc(Long cityId);
}
