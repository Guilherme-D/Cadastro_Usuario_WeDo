package com.teste.md.Models.DTO.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddressRequest {

    @NotNull(message = "Campo rua não pode ser nulo")
    @NotEmpty(message = "Campo rua não pode ser vazio")
    private String logradouro;

    @NotNull(message = "Campo número não pode ser nulo")
    private Integer numero;

    @NotNull(message = "Campo bairro não pode ser nulo")
    @NotEmpty(message = "Campo bairro não pode ser vazio")
    private String bairro;

    @NotNull(message = "Campo cidade não pode ser nulo")
    @NotEmpty(message = "Campo cidade não pode ser vazio")
    private String localidade;

    @NotNull(message = "Campo Estado não pode ser nulo")
    @NotEmpty(message = "Campo Estado não pode ser vazio")
    private String uf;


    public AddressRequest(){}

    public AddressRequest(String logradouro, Integer numero, String bairro, String localidade, String uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
