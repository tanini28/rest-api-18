package tests;

import lombok.LoginBodyLombokModel;
import lombok.LoginResponseLombokModel;
import pojo.LoginBodyPojoModel;
import pojo.LoginResponsePojoModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class ReqresInExtendedTests {

    @Test
    void successfulLoginTest(){
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        given()
                .log().uri()
                .body(body)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));


    }

    @Test
    void successfulLoginWithPojoTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        LoginBodyPojoModel loginBody = new LoginBodyPojoModel();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword("cityslicka");


        LoginResponsePojoModel response = given()
                .log().uri()
                .body(loginBody)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponsePojoModel.class);

//      assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");

    }

        @Test
        void successfulLoginWithLombokTest(){
            String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

            LoginBodyLombokModel loginBody = new LoginBodyLombokModel();
            loginBody.setEmail("eve.holt@reqres.in");
            loginBody.setPassword("cityslicka");


            LoginResponseLombokModel response =  given()
                    .log().uri()
                    .body(loginBody)
                    .contentType(JSON)
                    .when()
                    .post("https://reqres.in/api/login")
                    .then()
                    .log().status()
                    .log().body()
                    .statusCode(200)
                    .extract().as(LoginResponseLombokModel.class);

            assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");



    }
}
