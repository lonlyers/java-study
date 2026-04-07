package com.zzw.travelguide.service;

import com.zzw.travelguide.model.Attraction;
import com.zzw.travelguide.model.City;
import com.zzw.travelguide.repository.AttractionRepository;
import com.zzw.travelguide.repository.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CityService {

    private final CityRepository cityRepository;
    private final AttractionRepository attractionRepository;

    public CityService(CityRepository cityRepository, AttractionRepository attractionRepository) {
        this.cityRepository = cityRepository;
        this.attractionRepository = attractionRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("城市不存在，ID: " + id));
    }

    public List<Attraction> getAttractionsByCityId(Long cityId) {
        getCityById(cityId);
        return attractionRepository.findByCityIdOrderByNameAsc(cityId);
    }

    public Attraction getAttractionById(Long id) {
        return attractionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("景点不存在，ID: " + id));
    }
}
