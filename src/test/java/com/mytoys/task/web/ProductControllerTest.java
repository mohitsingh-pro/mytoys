package com.mytoys.task.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private int port;

    private RequestSpecification defaultGiven;

    @BeforeEach
    void setUp() {
        defaultGiven = RestAssured.given()
                .port(port);
        RestAssured.port = port;
    }


    @Test
    public void testProductApi() {
        defaultGiven.get("/product")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body(".", Matchers.notNullValue())
                .body("products", Matchers.notNullValue())
                .body("products[0].id", Matchers.notNullValue())
                .body("products[0].name", Matchers.notNullValue())
                .body("products[0].price", Matchers.notNullValue())
                .body("products[0].oldPrice", Matchers.notNullValue())
                .body("products[0].stock", Matchers.notNullValue())
                .body("products[0].brand", Matchers.notNullValue());
    }
}