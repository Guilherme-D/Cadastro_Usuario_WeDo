package com.teste.md.repository;

import com.teste.md.Models.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesRepository extends JpaRepository<States,Integer> {
    States findByUf(String state);
}
