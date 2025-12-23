package com.aysekoc.order_service.service;

import com.aysekoc.order_service.model.Cities;
import com.aysekoc.order_service.repository.CitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {
    private final CitiesRepository citiesRepository;

    public CitiesService(CitiesRepository citiesRepository){
        this.citiesRepository = citiesRepository;
        System.out.println("kdjfhf");
    }

    public List<Cities> getAllCities(){
        return (List<Cities>) citiesRepository.findAll();
    }

    public Cities getCitiesById(Long id){
        return citiesRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldnt find city by id:" + id));
    }

    public Cities createCities(Cities cities){
        return citiesRepository.save(cities);
    }
    public Cities updateCities(Long id, Cities cities){
        Cities oldCity = getCitiesById(id);

        oldCity.setName(cities.getName());
        oldCity.setPlateCode(cities.getPlateCode());

        return citiesRepository.save(oldCity);
    }

    public void delete(Long id){
        Cities cities = getCitiesById(id);
        citiesRepository.delete(cities);
    }
}
