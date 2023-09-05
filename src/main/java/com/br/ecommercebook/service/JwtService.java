package com.br.ecommercebook.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
  
  private static final String SECRET_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY5Mzk1MTc1NywiaWF0IjoxNjkzOTUxNzU3fQ.Ch2pcO68uo5LQN9hvu33WyE_h76JPI2A7023fAenBTU";

  public String extractUserEmail(String jwtToken) {
    return extractClaim(jwtToken, Claims::getSubject);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
    final Claims claims = this.extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public String generateToken(UserDetails userdetails) {
    return this.generateToken(new HashMap<>(), userdetails);
  }

  public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
    var currentTime = System.currentTimeMillis();
    var timeToExpire = currentTime + 1000 * 60 * 24;
    return Jwts.builder()
          .setClaims(extraClaims)
          .setSubject(userDetails.getUsername())
          .setIssuedAt(new Date(currentTime))
          .setExpiration(new Date(timeToExpire))
          .signWith(this.getSignInKey(), SignatureAlgorithm.HS256)
          .compact();
  }

  private Claims extractAllClaims(String token){
    return Jwts
          .parserBuilder()
          .setSigningKey(getSignInKey())
          .build()
          .parseClaimsJws(token)
          .getBody();
  }

  private Key getSignInKey(){
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
