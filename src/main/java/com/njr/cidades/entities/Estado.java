package com.njr.cidades.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Estado implements Comparable<Estado>{

    @Id
    private Long id;

    @Column
    private String nome;

    private String uf;

    private Integer ibge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    @Override
    public int compareTo(Estado estado) {
        return (this.nome.compareToIgnoreCase(estado.nome));
    }
}
