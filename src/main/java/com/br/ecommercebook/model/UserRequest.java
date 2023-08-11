package com.br.ecommercebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String phone;
    private String userName;
    private String email;
    private String password;
    private LocalDate birthdate;
}