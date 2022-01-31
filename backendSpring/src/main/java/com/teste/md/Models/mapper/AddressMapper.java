package com.teste.md.Models.mapper;

import com.teste.md.Models.Address;
import com.teste.md.Models.Cities;
import com.teste.md.Models.DTO.ViaCep;
import com.teste.md.Models.States;
import com.teste.md.Models.DTO.requests.AddressRequest;


public class AddressMapper {
    public static Address toAddress(ViaCep request, Integer numero, States state, Cities city){
        return new Address(request.getLogradouro(), numero, request.getBairro(), city, state);
    }
}
