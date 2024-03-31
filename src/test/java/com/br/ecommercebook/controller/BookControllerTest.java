package com.br.ecommercebook.controller;

import com.br.ecommercebook.auth.models.AuthenticationRequest;
import com.br.ecommercebook.dto.BookDTO;
import com.br.ecommercebook.enums.BookType;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)

public class BookControllerTest {
    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
//        RestAssured.basePath = "/api/book";
    }

    @Test
    public void givenRequestPostWithRequestEntity_whenRequested_thenCreated() {
        //Arrange
        Long[] authorIds = new Long[]{1L};
        var publisherId = 1L;
        Long[] categoriesIds = new Long[]{1L};
        var request =
                BookDTO.builder().cover("cover").name("Clean Book").authors(
                authorIds).publisher(publisherId).description("Good book").isbn(
                        "333").version(BookType.DIGITAL).releaseDate("10/10" +
                        "/2010").language("ENG").pagesNumber(344).price(100.0)
                        .categories(categoriesIds).build();
        var user =
                AuthenticationRequest.builder().email("admin@email.com").password("666").build();
        String token = RestAssured.given()
                .log()
                .all()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/auth/authenticate")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
        //Act & Assert
        RestAssured.given()
                .log()
                .all()
                .contentType("application/json")
                .header("Authorization", "Bearer "
                        + token)
                .body(request)
                .when()
                .post("/api/book/")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", Matchers.equalTo(request.getName()))
                .body("isbn", Matchers.equalTo(request.getIsbn()));
    }
}
