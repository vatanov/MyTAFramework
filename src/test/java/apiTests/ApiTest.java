package apiTests;

import api.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import libs.ConfigProvider;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth;

public class ApiTest {
    final String USER_ID = "e7faf904-e52e-43bd-b4d1-17c2eeb39a6d";
    @Test
    public void getBooksTest() {
        given()
                .headers(
                        "accept", ContentType.JSON,
                        "Authorization", "Bearer " + ConfigProvider.configHiddenProperties.api_token()
                )
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.BOOKS_BY_USER, USER_ID)  // URL
                .then()
                .statusCode(200)
                .log().all()
        ;
    }
}
