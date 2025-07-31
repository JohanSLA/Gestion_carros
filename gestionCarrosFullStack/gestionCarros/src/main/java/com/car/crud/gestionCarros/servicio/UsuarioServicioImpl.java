package com.car.crud.gestionCarros.servicio;

import com.car.crud.gestionCarros.entidades.Usuario;
import com.car.crud.gestionCarros.exepciones.RecursoNoEncontradoExepcion;
import com.car.crud.gestionCarros.repositorio.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    //Inyeccion del usuario repositorio
    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder; // Inyección de BCrypt

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    
    // Guardar usuario con contraseña encriptada
    @Override
    public Usuario save(Usuario usuario) {
        // Verificamos que la contraseña no esté ya encriptada (solo si es necesario)
        if (!usuario.getPassword().startsWith("$2a$")) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuarioRepositorio.save(usuario);
    }

    //Listar todos los usuarios
    @Override
    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    //listar un usuario dado su id
    @Override
    public Usuario findById(String id) {

        //Lanza una nueva exepcion si no encuentra un usuario con el id especificado
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(
                () -> {
                    throw new RecursoNoEncontradoExepcion("Usuario con el id " + id + " no encontrado");
                }
        );
        //return usuarioRepositorio.findById(id).get();
        return usuario;
    }

    //Eliminar usuario dado su id
    @Override
    public void deleteById(String id) {
        usuarioRepositorio.deleteById(id);
    }

    //Actualizar usuario
    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }


}
