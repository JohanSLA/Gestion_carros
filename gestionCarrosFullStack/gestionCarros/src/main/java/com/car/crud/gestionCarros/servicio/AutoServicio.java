package com.car.crud.gestionCarros.servicio;

import com.car.crud.gestionCarros.entidades.Auto;
import com.car.crud.gestionCarros.entidades.Usuario;

import java.util.List;

public interface AutoServicio {
    Auto save(Auto auto); //Guardar auto
    List<Auto> findAll();//listar todos los autos
    List<Auto> findByUsuario(String idUsuario); //Listar todos los autos de un usaurio
    Auto findById(String id);
    void deleteById(String id);
    Auto update(Auto auto);
}
