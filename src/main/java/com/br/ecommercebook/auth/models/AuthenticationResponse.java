package com.br.ecommercebook.auth.models;

import com.br.ecommercebook.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class AuthenticationResponse {
    String token;
    String email;
    String firstname;
    Role role;
}
