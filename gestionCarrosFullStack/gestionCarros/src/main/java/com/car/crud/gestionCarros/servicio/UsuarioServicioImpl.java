package com.car.crud.gestionCarros.servicio;

import com.car.crud.gestionCarros.entidades.Usuario;
import com.car.crud.gestionCarros.exepciones.RecursoNoEncontradoExepcion;
import com.car.crud.gestionCarros.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    //Inyeccion del usuario repositorio
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    //GuardarUsuario
    @Override
    public Usuario save(Usuario usuario) {
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
