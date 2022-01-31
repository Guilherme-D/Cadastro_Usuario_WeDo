package com.teste.md.service.impl;

import com.teste.md.Models.States;
import com.teste.md.repository.StatesRepository;
import com.teste.md.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatesServiceImpl implements StatesService {

    @Autowired
    StatesRepository statesRepository;
    @Override
    public States findByUf(String state) {
        return this.statesRepository.findByUf(state);
    }

}
