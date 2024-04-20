package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import api.dto.responseDto.BookDto;
import api.dto.responseDto.UsersBooksDto;
import io.restassured.http.ContentType;
import libs.ConfigProvider;

import static io.restassured.RestAssured.given;
import io.restassured.response.ResponseBody;

public class ApiHelper {

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    /**
     * Token for LOGIN_DEFAULT
     * @return
     */
    public String getToken() {
        return getToken(ConfigProvider.configHiddenProperties.login_api_default(),
                ConfigProvider.configHiddenProperties.password_api_default());
    }

    public String getToken(String username, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", username);
        requestBody.put("password", password);

        ResponseBody responseBody =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(requestBody.toMap())
                        .when()
                        .post(EndPoints.GENERATE_TOKEN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody();
        return responseBody.jsonPath().get("token").toString();
    }

    /**
     * Get books for LOGIN_DEFAULT
     * @return
     */
    public BookDto[] getAllBooksByUser() {
        return getAllBooksByUser(ConfigProvider.configHiddenProperties.login_api_default(),
                ConfigProvider.configHiddenProperties.password_api_default(),
                ConfigProvider.configHiddenProperties.user_id());
    }

    public BookDto[] getAllBooksByUser(String username, String password, String userId) {
        String token = getToken(username, password);

        UsersBooksDto response =
                given()
                        .headers(
                                "accept", ContentType.JSON,
                                "Authorization", "Bearer " + token
                        )
                        .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.BOOKS_BY_USER, userId)  // URL
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().as(UsersBooksDto.class);

        return response.getBooks();
    }

    /**
     * Delete book for LOGIN_DEFAULT
     * @return
     */
    public Integer deleteBookByUser(String isbn) {
        return deleteBookByUser(ConfigProvider.configHiddenProperties.login_api_default(),
                ConfigProvider.configHiddenProperties.password_api_default(),
                ConfigProvider.configHiddenProperties.user_id(),
                isbn
        );
    }

    public Integer deleteBookByUser(String username, String password, String userId, String isbn) {
        String token = getToken(username, password);

        JSONObject requestBody = new JSONObject();
        requestBody.put("isbn", isbn);
        requestBody.put("userId", userId);

                return given()
                        .headers(
                                "accept", ContentType.JSON,
                                "Authorization", "Bearer " + token
                        )
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(requestBody.toMap())
                        .log().all()
                        .when()
                        .delete(EndPoints.DELETE_BOOK)  // URL
                        .then()
                        .statusCode(204)
                        .log().all()
                        .extract().response().getStatusCode();
    }
}
