package com.br.ecommercebook.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.ecommercebook.auth.models.AuthenticationRequest;
import com.br.ecommercebook.auth.models.AuthenticationResponse;
import com.br.ecommercebook.auth.models.RegisterRequest;
import com.br.ecommercebook.entity.User;
import com.br.ecommercebook.enums.Role;
import com.br.ecommercebook.exception.UserNotFoundException;
import com.br.ecommercebook.repository.UserRepository;
import com.br.ecommercebook.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    var user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(UserNotFoundException::new);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse register(RegisterRequest registerRequest) {
    var user = User.builder()
        .firstname(registerRequest.getFirstname())
        .lastname(registerRequest.getLastname())
        .email(registerRequest.getEmail())
        .password(passwordEncoder.encode(registerRequest.getPassword()))
        .role(Role.USER)
        .build();
    userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
}
