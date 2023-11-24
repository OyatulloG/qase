package com.vention.automation.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import com.vention.automation.test.CommonConditions;
import org.testng.annotations.Test;

public class CreateProjectApiTest extends CommonConditions {
    @Test
    public void createProjectApiTest() {
//        RestAssured.baseURI = "https://app.qase.io";
//
//        //Login endpoint and user credentials
//        String loginEndpoint = "/v1/auth/login/regular";
//        String email = "gulomjonovoyatullo@gmail.com";
//        String password = "QaseIO@202311";
//
//        //Login request
//        Response response = RestAssured.given().contentType("application/json")
//                .body("{email: gulomjonovoyatullo@gmail.com, password: QaseIO@202311, remember: true}").post(loginEndpoint);
//
//        String authToken = response.jsonPath().getString("token");
//        System.out.println("=============== authToken = " + authToken);
//        System.out.println("=============== response = " + response.asString());

        Response response = RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());

//        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");

//        response.then().statusCode(200);

//        Response response = RestAssured.given().post("https://app.qase.io/v1/auth/login/regular")
    }
}
