package com.zzw.travelguide.controller;

import com.zzw.travelguide.model.Attraction;
import com.zzw.travelguide.model.City;
import com.zzw.travelguide.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @GetMapping("/{id}/attractions")
    public ResponseEntity<List<Attraction>> getAttractionsByCityId(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getAttractionsByCityId(id));
    }
}
