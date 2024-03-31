package com.br.ecommercebook.controller;

import com.br.ecommercebook.auth.models.AuthenticationRequest;
import com.br.ecommercebook.auth.models.RegisterRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)

public class AuthControllerTest {
    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/api/auth";
    }

    @Test
    public void givenARegisterRequest_whenRequested_thenCreated() {
        //Arrange
        var request =
                RegisterRequest.builder().email("guguti@email.com").password(
                        "Hola").firstname("Gustavo").lastname("Avelar").build();
        //Act & Assert
        RestAssured.given()
                .log()
                .all()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/register")
                .then()
                .statusCode(200);
    }

    @Test
    public void givenAnAuthenticationRequest_whenRequested_thenAuthenticated() {
        //Arrange
        var user =
                AuthenticationRequest.builder().email("guguti@email.com").password("Hola").build();
        //Act & Assert
        RestAssured.given()
                .log()
                .all()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/authenticate")
                .then()
                .statusCode(200);
    }

    @Test
    public void givenAAdminRequest_whenRequested_thenAuthenticated() {
        //Arrange
        var user =
                AuthenticationRequest.builder().email("admin@email.com").password("666").build();
        //Act & Assert
        var token = RestAssured.given()
                .log()
                .all()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/authenticate")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
        System.out.println(token);
    }
}
