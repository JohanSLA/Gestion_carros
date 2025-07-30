package com.car.crud.gestionCarros.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Auto {
    private String id;

    @Id
    private String marca;
    private String modelo;
    private String ano;

    @Column(nullable = false, unique = true)
    private String placa;
    private String color;


    /*
    Metodos contructores para la clase auto
     */

    /**
     * Metodo vaciio de la clase
     */
    public Auto() {
    }

    /**
     * Metodo contructor con parametros
     * @param marca
     * @param modelo
     * @param ano
     * @param placa
     * @param color
     */
    public Auto(String marca, String modelo, String ano, String placa, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.color = color;
    }


    /**
     * Metodos getter y setter de la clase auto
     */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


