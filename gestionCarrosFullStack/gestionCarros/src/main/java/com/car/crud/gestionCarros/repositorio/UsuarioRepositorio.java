package com.car.crud.gestionCarros.repositorio;

import com.car.crud.gestionCarros.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Interface que extiende de Jpa Repository el cual ya tiene los metodos para el crud implementados
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario,String> {
    // Método personalizado para buscar por email (necesario para login con JWT)
    Optional<Usuario> findByEmail(String email);
}
