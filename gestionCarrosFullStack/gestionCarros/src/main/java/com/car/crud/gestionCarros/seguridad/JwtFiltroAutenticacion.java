package com.car.crud.gestionCarros.seguridad;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtFiltroAutenticacion  extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UsuarioDetalleServicio usuarioDetalleServicio;

    public JwtFiltroAutenticacion(JwtUtils jwtUtils, UsuarioDetalleServicio usuarioDetalleServicio) {
        this.jwtUtils = jwtUtils;
        this.usuarioDetalleServicio = usuarioDetalleServicio;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = header.substring(7);
        if (!jwtUtils.validarToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String email = jwtUtils.obtenerEmailToken(token);

        var userDetails = usuarioDetalleServicio.loadUserByUsername(email);

        var authToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authToken);
        filterChain.doFilter(request, response);
    }
}
