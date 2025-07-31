package com.car.crud.gestionCarros.controlador;

import com.car.crud.gestionCarros.dto.LoginRequest;
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

    public AuthControlador(AuthenticationManager authManager, JwtUtils jwtUtils, UsuarioDetalleServicio userDetailsService , PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    //lcoalhost:8080/api/auth/login
    //se debe enviar el token suministrado por la app
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {

        System.out.println("Este correo se esta intentando loguear: " + loginRequest.getEmail()); //prueba para ssaber si es el correo suminitrado

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        // 🔎 Verifica si la contraseña enviada coincide con la encriptada
        boolean coincide = passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword());
        System.out.println("¿Contraseña válida?: " + coincide);

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );


        String token= jwtUtils.generarToken(userDetails.getUsername());

        //Empaquetamiento en un JSON {"token": "eyJ..."}
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}
