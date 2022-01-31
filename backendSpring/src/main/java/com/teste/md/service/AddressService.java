package com.teste.md.service;

import com.teste.md.Models.Address;
import com.teste.md.Models.DTO.ViaCep;
import com.teste.md.Models.DTO.requests.UserRequest;

import java.io.IOException;

public interface AddressService {
    ViaCep getViaCepInfo(String cep) throws IOException;

    Address getAddressViaCep(String cep, Integer numero) throws IOException;
}
