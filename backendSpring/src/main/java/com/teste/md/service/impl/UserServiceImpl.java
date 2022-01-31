package com.teste.md.service.impl;

import com.google.gson.Gson;
import com.teste.md.Models.Address;
import com.teste.md.Models.Cities;
import com.teste.md.Models.DTO.ViaCep;
import com.teste.md.Models.States;
import com.teste.md.Models.Users;
import com.teste.md.Models.mapper.AddressMapper;
import com.teste.md.Models.mapper.UserMapper;
import com.teste.md.Models.DTO.requests.UserRequest;
import com.teste.md.repository.UserRepository;
import com.teste.md.service.AddressService;
import com.teste.md.service.CitiesService;
import com.teste.md.service.StatesService;
import com.teste.md.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AddressService addressService;

    @Override
    public Users createUsers(UserRequest userRequest) throws IOException {

        Address address = this.addressService.getAddressViaCep(userRequest.getCep(), userRequest.getAddress().getNumero());

        Users users = UserMapper.toUser(userRequest, address);

        Users oneByCpf = this.userRepository.findOneByCpf(userRequest.getCpf());

        if(null != oneByCpf) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }

        return  Optional.of(this.userRepository.save(users))
                .orElseThrow(() -> new IllegalArgumentException("Ocorreu um erro ao salvar usuario, verifique os dados informados e tente novamente."));

    }

    @Override
    public Page<Users> listUsersByPage(Pageable pages) {
        return this.userRepository.findAllByOrderByNomeAsc(pages);
    }

}
