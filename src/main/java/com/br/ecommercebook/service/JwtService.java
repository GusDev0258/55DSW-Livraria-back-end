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
  
  private static final String SECRET_KEY = "HO6Oz1a2UISH0J5Lp2X9Z7nqdHnu7TZPOPedmplUjNmhbOuLOEmRMn9pNDi46PEm4FSU3m2IiT5kUxrWwCM36OMQjPoFE/3IUP1pCsGdkmOsNIE3XmXFJauoR8mjakaw+bUCoivWBVg4BRmzP3i946nNgV81EDtP76sfwILdn3gzND4lnnSf4PmNebMMk+9FMIA9V2z5WQ+xGyv4TjYXFRVG7GP0PS82Na8lbyy/9gihgwQMm3qIWlp9gCIUCocMYWBfhqQEYOzXK7v8a3Sb2hGd36Tqe1Z0ktTeabnV6g/oq+Nm8kv29h5ZbuVLcsK9XY9w6CD+5O7nOYfYpPqABrW5yBivGpxuUf8OwcLCYTc=";

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

  public boolean isTokenValid(String token, UserDetails userDetails){
    final String userEmail = this.extractUserEmail(token);
    return (userEmail == userDetails.getUsername()) && !this.isTokenExpired(token);
  }
  
  public boolean isTokenExpired(String token){
    final Date expiration = this.extractExpiration(token);
    return expiration.before(new Date());
  }

  public Date extractExpiration(String token){
    return this.extractClaim(token, Claims::getExpiration);
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
