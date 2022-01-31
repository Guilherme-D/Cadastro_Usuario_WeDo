package com.teste.md.service;

import com.teste.md.Models.Users;
import com.teste.md.Models.DTO.requests.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface UserService {
    Users createUsers(UserRequest userRequest) throws IOException;

    Page<Users> listUsersByPage(Pageable pages);
}
