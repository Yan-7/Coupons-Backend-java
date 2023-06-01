package com.example.coupons30411.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {
    private static final String SECRET_KEY = "yourSecretKey5646874678877654768765456476744867";
    private static final long EXPIRATION_TIME = 86400000; // 24 hours

    public static String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
