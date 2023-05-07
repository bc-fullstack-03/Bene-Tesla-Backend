package com.sysmap.api.service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class JwtService implements IJwtService {

  private final String SECRET ="3777217A25432646294A404E635266556A586E3272357538782F413F4428472D";
  //6 horas
  private final long EXPIRATION_TIME = 18000000; //6 horas

  public String generateToken(UUID userId) {
    return Jwts
      .builder()
      .setSubject(userId.toString())
      .claim(SECRET, userId)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 1 hour
      .signWith(genSinKey(), SignatureAlgorithm.HS256)
      .compact();
  }

  

  public boolean isvalidToken(String token, String userId) {
    var claims = Jwts
      .parserBuilder()
      .setSigningKey(genSinKey())
      .build()
      .parseClaimsJws(token)
      .getBody();
    var subject = claims.getSubject();
    var expiration = claims.getExpiration();
    return (subject.equals(userId) && !expiration.before(new Date()));
  }

  private Key genSinKey() {
    var bytes = Decoders.BASE64.decode(SECRET);
    return Keys.hmacShaKeyFor(bytes);
  }
}
