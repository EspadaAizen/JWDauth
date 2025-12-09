package com.projects.rbAuth.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.security.Key;
@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationsMs;

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    //Generate token
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration((new Date(System.currentTimeMillis()+ expirationsMs)))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract username
    public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    // Validate Token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;

        } catch (ExpiredJwtException e) {
            System.out.println("JWT Expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT Unsupported: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("JWT Invalid: " + e.getMessage());
        } catch (SignatureException e) {
            System.out.println("Invalid Signature: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Token: " + e.getMessage());
        }
        return false;
    }
}
