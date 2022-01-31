package com.teste.md.service.impl;

import com.google.gson.Gson;
import com.teste.md.Models.Address;
import com.teste.md.Models.Cities;
import com.teste.md.Models.DTO.ViaCep;
import com.teste.md.Models.States;
import com.teste.md.Models.mapper.AddressMapper;
import com.teste.md.service.AddressService;
import com.teste.md.service.CitiesService;
import com.teste.md.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    CitiesService citiesService;

    @Autowired
    StatesService statesService;

    public static String jsonToString(BufferedReader buffereReader) throws IOException {
        String resposta;
        StringBuilder jsonEmString = new StringBuilder();
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString.append(resposta);
        }
        return jsonEmString.toString();
    }

    @Override
    public ViaCep getViaCepInfo(String cep) throws IOException {
        URL url = new URL("https://viacep.com.br/ws/"+cep+"/json");

        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

        if(conexao.getResponseCode() != 200) {
            if (conexao.getResponseCode() == 400) {
                throw new RuntimeException("Cep informado é invalido.");
            }
            throw new RuntimeException("Ocorreu um erro ao comunicar com ViaCep.");
        }
        BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
        String jsonEmString = jsonToString(resposta);
        Gson gson = new Gson();
        return gson.fromJson(jsonEmString, ViaCep.class);
    }

    @Override
    public Address getAddressViaCep(String cep, Integer numero) throws IOException {
        ViaCep viaCep = this.getViaCepInfo(cep);

        States state = Optional.of(this.statesService.findByUf(viaCep.getUf()))
                .orElseThrow(() -> new IllegalArgumentException("UF informado é inválido."));

        Cities city = Optional.ofNullable(this.citiesService.findByCity(viaCep.getLocalidade()))
                .orElseGet(() -> this.citiesService.createCity(new Cities(viaCep.getLocalidade())));


        return AddressMapper.toAddress(viaCep, numero, state, city);

    }
}
