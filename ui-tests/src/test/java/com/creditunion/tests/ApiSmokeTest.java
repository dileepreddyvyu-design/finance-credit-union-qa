package com.creditunion.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiSmokeTest {

    @Test
    public void healthEndpointIsUp(){
        RestAssured.baseURI = "https://api.creditunion.local";
        given().when().get("/health")
                .then().statusCode(anyOf(equalTo(200), equalTo(204)));
    }
}
