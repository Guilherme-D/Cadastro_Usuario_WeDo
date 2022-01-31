package com.teste.md.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @NotNull(message = "Campo nome não pode ser nulo")
    @NotEmpty(message = "Campo nome não pode ser vazio")
    private  String nome;

    @NotNull(message = "Campo cpf não pode ser nulo")
    @NotEmpty(message = "Campo cpf não pode ser vazio")
    private  String cpf;

    @NotNull(message = "Campo telefone não pode ser nulo")
    @NotEmpty(message = "Campo telefone não pode ser vazio")
    private  String telefone;

    @NotNull(message = "Campo cep não pode ser nulo")
    @NotEmpty(message = "Campo cep não pode ser vazio")
    private  String cep;

    @NotNull(message = "Campo endereco não pode ser nulo")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Address endereco;

    public Users(){};

    public Users(String nome, String cpf, String telefone, Address endereco, String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Address getEndereco() {
        return endereco;
    }

    public void setEndereco(Address endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equal(id, users.id) && Objects.equal(nome, users.nome) && Objects.equal(cpf, users.cpf) && Objects.equal(telefone, users.telefone) && Objects.equal(cep, users.cep) && Objects.equal(endereco, users.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, nome, cpf, telefone, cep, endereco);
    }
}

