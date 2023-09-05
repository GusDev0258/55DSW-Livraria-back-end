package com.br.ecommercebook.service;

import java.security.Key;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
  
  private static final String SECRET_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY5Mzk1MTc1NywiaWF0IjoxNjkzOTUxNzU3fQ.Ch2pcO68uo5LQN9hvu33WyE_h76JPI2A7023fAenBTU";

  public String extractUserEmail(String jwtToken) {
    return null;
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
