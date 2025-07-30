package com.car.crud.gestionCarros.servicio;

import com.car.crud.gestionCarros.entidades.Usuario;

import java.util.List;

/**
 * Interfaz donde estan todos los metodos a usar ppor el usuario
 */
public interface UsuarioServicio {
    Usuario save(Usuario usuario); //Para Guardar usaurios
    List<Usuario> findAll(); //Lista todos los usuarios
    Usuario findById(String id); //Busca un usuario dado su id
    void deleteById(String id);//Elimina un usuario dado se Id
    Usuario update(Usuario usuario); //Actualiza un usuario

}
