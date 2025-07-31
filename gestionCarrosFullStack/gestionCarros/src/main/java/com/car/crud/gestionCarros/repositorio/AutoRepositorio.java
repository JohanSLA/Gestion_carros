package com.car.crud.gestionCarros.repositorio;

import com.car.crud.gestionCarros.entidades.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepositorio extends JpaRepository<Auto,String> {
    List<Auto> findByUsuario_id(String usuarioId);
}
