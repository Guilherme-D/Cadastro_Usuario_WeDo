package com.teste.md.repository;

import com.teste.md.Models.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository  extends JpaRepository<Cities,Integer> {
    Cities findByCidade(String cidade);
}
