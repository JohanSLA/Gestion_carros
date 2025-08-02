package com.car.crud.gestionCarros.controlador;

import com.car.crud.gestionCarros.dto.LoginRequest;
import com.car.crud.gestionCarros.entidades.Usuario;
import com.car.crud.gestionCarros.repositorio.UsuarioRepositorio;
import com.car.crud.gestionCarros.seguridad.JwtUtils;
import com.car.crud.gestionCarros.seguridad.UsuarioDetalleServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthControlador {

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;
    private final UsuarioDetalleServicio userDetailsService;
    private final PasswordEncoder passwordEncoder; //  Prueba


    // Agrega el repositorio como dependencia
    private final UsuarioRepositorio usuarioRepositorio;


    public AuthControlador(AuthenticationManager authManager, JwtUtils jwtUtils, UsuarioDetalleServicio userDetailsService , PasswordEncoder passwordEncoder, UsuarioRepositorio usuarioRepositorio) {
        this.authManager = authManager;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepositorio = usuarioRepositorio;
    }


    //lcoalhost:8080/api/auth/login
    //se debe enviar el token suministrado por la app
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {

        System.out.println("Este correo se esta intentando loguear: " + loginRequest.getEmail()); //prueba para ssaber si es el correo suminitrado

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        //Verifica si la contraseña enviada coincide con la encriptada
        boolean coincide = passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword());
        System.out.println("¿Contraseña válida?: " + coincide);

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );


        String token= jwtUtils.generarToken(userDetails.getUsername());

        // Buscar el usuario para enviarlo
        Usuario usuario = usuarioRepositorio.findByEmail(loginRequest.getEmail()).orElse(null);


        //Empaquetamiento en un JSON {"token": "eyJ..."}
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);

        //Verifica si hay usuario
        if (usuario != null) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("id", usuario.getId());
            response.put("usuario", userMap);
            System.out.println("Usuario Logueado: " + userMap.toString());//pruebaaa
        }
        else{
            System.out.println("Usuario no encontrado");
        }

        return ResponseEntity.ok(response);
    }
}
