package com.car.crud.gestionCarros.controlador;

import com.car.crud.gestionCarros.entidades.Usuario;
import com.car.crud.gestionCarros.servicio.UsuarioServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {

    //Inyeccion del objeto usuarioServicio a la clase UsuarioControlador para no hacer la operacion de new
    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    //Creacion de endpoints


    //localhost:8080/api/usuario/agregar
    //@PostMapping() seria mejor?
    @PostMapping("/agregar")
    @CrossOrigin(origins = "http://localhost:4200")
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioServicio.save(usuario);
    }

    //localhost:8080/api/usuario/listar
    @GetMapping("/listar")
    public List<Usuario> findAll() {
        return usuarioServicio.findAll();
    }

    //localhost:8080/api/usuario/idUsuario
    @GetMapping("/{id}")
    public Usuario findbyId(@PathVariable String id) {
        return usuarioServicio.findById(id);
    }

    //localhost:8080/api/usuario/idUsuarioEliminar
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        usuarioServicio.deleteById(id);
    }

    //Nota: realizar la verificacion para saber si hay un valor que no se envia para que no lo cambie a null
    //localhost:8080/api/usuario
    @PatchMapping
    public Usuario update(@RequestBody Usuario usuario) {
        Usuario usuarioActualizar = usuarioServicio.findById(usuario.getId());

        //Seteo de los datos  nuevos al usuario que esta en la base de datos
        usuarioActualizar.setNombre(usuario.getNombre());
        usuarioActualizar.setApellido(usuario.getApellido());
        usuarioActualizar.setEmail(usuario.getEmail());
        usuarioActualizar.setPassword(usuario.getPassword());

        //Retornamos el usuario actualizado
        return usuarioServicio.save(usuarioActualizar);
    }


}
