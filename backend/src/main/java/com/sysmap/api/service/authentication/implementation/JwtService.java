package com.sysmap.api.service.authentication.implementation;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.sysmap.api.service.authentication.IJwtService;

@Service
public class JwtService implements IJwtService {

  private final String SECRET ="66546A576E5A7234753778214125432A462D4A614E645267556B587032733576";
  
  private final long EXPIRATION_TIME = 28000000; 

  public String generateToken(UUID userId) {
    return Jwts
      .builder()
      .setSubject(userId.toString())
      .claim(SECRET, userId)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) 
      .signWith(genSinKey(), SignatureAlgorithm.HS256)
      .compact();
  }

  

  public boolean isValidToken(String token, String userId) {
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