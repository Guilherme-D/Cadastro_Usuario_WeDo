package com.teste.md.Models.DTO.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotNull(message = "Campo nome não pode ser nulo")
    @NotEmpty(message = "Campo nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Campo cpf não pode ser nulo")
    @NotEmpty(message = "Campo cpf não pode ser vazio")
    private String cpf;

    @NotNull(message = "Campo telefone não pode ser nulo")
    @NotEmpty(message = "Campo telefone não pode ser vazio")
    private String telefone;

    @NotNull(message = "Campo cep não pode ser nulo")
    @NotEmpty(message = "Campo cep não pode ser vazio")
    private String cep;

    @NotNull(message = "Campo address não pode ser nulo")
    private AddressRequest address;

    public UserRequest() {
    }

    public UserRequest(String nome, String cpf, String telefone, String cep, AddressRequest address) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.address = address;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }
}
