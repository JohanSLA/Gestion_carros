package com.car.crud.gestionCarros.seguridad;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.car.crud.gestionCarros.repositorio.UsuarioRepositorio;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetalleServicio implements UserDetailsService {
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioDetalleServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        var usuario = usuarioRepositorio.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
