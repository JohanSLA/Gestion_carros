package com.car.crud.gestionCarros.seguridad;

import com.car.crud.gestionCarros.entidades.Usuario;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * clase de utilidad (utility class) que se encarga de crear, validar y leer JWTs (JSON Web Tokens).
 * Se marca como @Component para que Spring pueda inyectarla automáticamente donde la necesites.
 */
@Component
public class JwtUtils {
    private final String JWT_SECRET = "12345678901234567890123456789012"; //Palabra secreta
    private final long JWT_EXPIRATION_TIME = 864_000_000; //Expiracion del token (1dia) esta en milisegundos

    private final Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes()); //Generqa la clave HMac con base al secreto (firmar token)

    /**
     * Metodo para crear el tokenb con base a datos del usuario
     * @param email
     * @return
     */
    public String generarToken(String email) {
        return Jwts.builder()
                .setSubject(email) //email del usuario
                .setIssuedAt(new Date()) //fecha de creacion del token
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME)) //Fecha de expiraciòn
                .signWith(key) //Clave secreta para firmar el token
                .compact();
    }


    /**
     * Metodo para obtener(extraer) el email dado el token
     * @param token
     * @return
     */
    public String obtenerEmailToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Metodo usado para verificar el token cuando entra una solicitud
     * @param token
     * @return
     */
    public boolean validarToken(String token) {
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);//Verifica firma y validez
            return true;
        }catch (JwtException e){
            return false;
        }
    }

}
