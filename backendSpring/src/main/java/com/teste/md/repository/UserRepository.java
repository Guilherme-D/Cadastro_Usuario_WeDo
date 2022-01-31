package com.teste.md.repository;

import com.teste.md.Models.DTO.PageResponse;
import com.teste.md.Models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    Users findOneByCpf(String cpf);

    Page<Users> findAllByOrderByNomeAsc(Pageable pages);
}
