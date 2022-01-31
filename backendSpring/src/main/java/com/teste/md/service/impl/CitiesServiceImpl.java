package com.teste.md.service.impl;

import com.teste.md.Models.Cities;
import com.teste.md.repository.CitiesRepository;
import com.teste.md.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    CitiesRepository citiesRepository;
    @Override
    public Cities findByCity(String city) {
        return this.citiesRepository.findByCidade(city);
    }

    @Override
    public Cities createCity(Cities city) {
        return this.citiesRepository.save(city);
    }
}
