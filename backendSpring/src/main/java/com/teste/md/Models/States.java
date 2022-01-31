package com.teste.md.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "states")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Campo estado não pode ser nulo")
    @NotEmpty(message = "Campo estado não pode ser vazio")
    private String estado;

    @NotNull(message = "Campo uf não pode ser nulo")
    @NotEmpty(message = "Campo uf não pode ser vazio")
    private String uf;

    public States(){}

    public States(
            @NotNull(message = "Campo estado não pode ser nulo")
            @NotEmpty(message = "Campo estado não pode ser vazio")
            String estado,
            @NotNull(message = "Campo ud não pode ser nulo")
            @NotEmpty(message = "Campo uf não pode ser vazio")
            String uf) {
        this.estado = estado;
        this.uf = uf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        States states = (States) o;
        return Objects.equal(id, states.id) && Objects.equal(estado, states.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, estado);
    }
}
