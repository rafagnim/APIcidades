package com.njr.cidades.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Pais")
@Table(name = "pais")
public class Pais implements Comparable<Pais>{
    @Id
    private Long id;

    @Column
    private String nome;

    @Column
    private String nome_pt;

    @Column
    private String sigla;

    private Integer bacen;

    public Pais() {

    }

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

    public String getNome_pt() {
        return nome_pt;
    }

    public void setNome_pt(String nome_pt) {
        this.nome_pt = nome_pt;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getBacen() {
        return bacen;
    }

    public void setBacen(Integer bacen) {
        this.bacen = bacen;
    }

    @Override
    public int compareTo(Pais pais) {
        return (this.nome.compareToIgnoreCase(pais.nome));
    }
}
