package com.njr.cidades.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cidade {

    @Id
    private Long id;

    @Column
    private String nome;

    private Integer uf;

    private Integer ibge;

    @Column
    private String lat_lon;

    private double latitude;

    private double longitude;

    private int cod_tom;

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

    public Integer getUf() {
        return uf;
    }

    public void setUf(Integer uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public String getLat_lon() {
        return lat_lon;
    }

    public void setLat_lon(String lat_lon) {
        this.lat_lon = lat_lon;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCod_tom() {
        return cod_tom;
    }

    public void setCod_tom(int cod_tom) {
        this.cod_tom = cod_tom;
    }
}
