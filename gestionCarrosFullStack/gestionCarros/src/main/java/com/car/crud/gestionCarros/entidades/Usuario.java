package com.car.crud.gestionCarros.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class Usuario {

    @Id
    private String id; //Identificacion del usuario
    private String nombre; // Nombre completo del usuario
    private String apellido; //Apellidos completos de los usarios
    @Column(unique = true, nullable = false)
    private String email; //email asociado al usuario
    @Column(nullable = false)
    private String password; //contraseña del usuario

    //cascade permite que al eliminar el usuario se eleiminen sus autos tambien
    //cascade = CascadeType.ALL: hace que al guardar/eliminar un usuario también se guarden o eliminen sus autos.
    //orphanRemoval = true: si se quita un Auto de la lista, también se elimina de la base de datos.
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Auto> listaAutos;

    /*
    Metodos contructor de la clase
     */

    //Metodo contructor con parametros
    public Usuario(String id, String nombre, String apellido, String email, String password, List<Auto> listaAuto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.listaAutos = listaAuto;
    }

    //Metodo contructor vacio
    public Usuario() {
    }


    /*
    Metodos getter de la clase
     */

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {return password;}

    public List<Auto> getListaAutos() {
        return listaAutos;
    }

    /*
    Metodos setter de la clase
     */

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {this.password = password;}

    public void setListaAutos(List<Auto> listaAutos) {
        this.listaAutos = listaAutos;
    }
}
