package com.sysmap.api.service.client.security;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Service
public class JwtService implements IJwtService{
    
    private final String SECRET = "3777217A25432646294A404E635266556A586E3272357538782F413F4428472D";
    
    private final long EXPIRATION_TIME = 3600000; // 1 hour
    public String generateToken(UUID userId) {
        return Jwts
        .builder()
        .setSubject(userId.toString())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 1 hour
        .signWith( genSinKey(),SignatureAlgorithm.HS256)
        .compact();   
    }
    private Key genSinKey() {
        var bytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(bytes);
    }
    public boolean isvalidToken(String token, UUID userId) {
        var claims = Jwts.parserBuilder().setSigningKey(genSinKey()).build().parseClaimsJws(token).getBody();
        var subject = claims.getSubject();
        var expiration = claims.getExpiration();
        return (userId.toString().equals(subject) && !expiration.before(new Date()));

    }
   
    
}
