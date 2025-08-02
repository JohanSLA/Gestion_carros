package com.car.crud.gestionCarros.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Auto {

    //Declaracion de atributos
    private String marca;
    private String modelo;
    private String ano;

    @Id
    @Column(nullable = false, unique = true)
    private String placa;
    private String color;

    @ManyToOne
    @JoinColumn(name = "usuario_id")//LLave foranea
    @JsonBackReference
    private Usuario usuario;


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
     * @param usuario
     */
    public Auto(String marca, String modelo, String ano, String placa, String color, Usuario usuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.color = color;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


