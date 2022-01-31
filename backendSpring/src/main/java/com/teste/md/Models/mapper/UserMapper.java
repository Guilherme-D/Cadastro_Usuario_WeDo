package com.teste.md.Models.mapper;

import com.teste.md.Models.Address;
import com.teste.md.Models.Users;
import com.teste.md.Models.DTO.requests.UserRequest;

public class UserMapper {
    public static Users toUser(UserRequest request, Address address){

        return new Users(request.getNome(), request.getCpf(), request.getTelefone(), address, request.getCep());
    }
}
