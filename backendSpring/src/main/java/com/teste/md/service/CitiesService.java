package com.teste.md.service;

import com.teste.md.Models.Cities;

public interface CitiesService {
    Cities findByCity(String city);
    Cities createCity(Cities city);
}
