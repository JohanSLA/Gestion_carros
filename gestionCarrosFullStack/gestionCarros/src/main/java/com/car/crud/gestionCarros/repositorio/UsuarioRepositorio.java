package com.car.crud.gestionCarros.repositorio;

import com.car.crud.gestionCarros.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que extiende de Jpa Repository el cual ya tiene los metodos para el crud implementados
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario,String> {
}
