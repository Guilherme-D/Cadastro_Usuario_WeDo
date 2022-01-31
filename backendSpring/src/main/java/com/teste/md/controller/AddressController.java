package com.teste.md.controller;

import com.google.gson.Gson;
import com.teste.md.Models.Address;
import com.teste.md.Models.DTO.ViaCep;
import com.teste.md.Models.DTO.requests.UserRequest;
import com.teste.md.Models.Users;
import com.teste.md.service.AddressService;
import com.teste.md.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/byCep/{cep}")
    @ResponseBody
    public ResponseEntity<ViaCep> check(
            @PathVariable(value="cep") String cep
    ) throws IOException {
        return ResponseEntity.ok().body(this.addressService.getViaCepInfo(cep));
    }
}
