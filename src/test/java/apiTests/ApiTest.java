package apiTests;

import api.ApiHelper;
import api.EndPoints;
import api.dto.responseDto.BookDto;
import api.dto.responseDto.UsersBooksDto;
import data.TestData;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import libs.ConfigHiddenProperties;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;

public class ApiTest {
    Logger logger = Logger.getLogger(getClass());
    ApiHelper apiHelper = new ApiHelper();
    String token = apiHelper.getToken();

    @Test
    public void getBooksTest() {
        UsersBooksDto responseAsDto = given()
                .filter(new AllureRestAssured())
                .headers(
                        "accept", ContentType.JSON,
                        "Authorization", "Bearer " + token
                )
                .log().all()
                .when()
                .get(EndPoints.BOOKS_BY_USER, ConfigProvider.configHiddenProperties.user_id())  // URL
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("username", equalTo("vova"))
                .body("books[0].title", equalTo("Git Pocket Guide"))
                // Verify field for each item in the list
                .body("books.author", everyItem(equalTo("Richard E. Silverman")))
                .extract().body().as(UsersBooksDto.class);

        // Get whole json or some fields
        logger.info(responseAsDto);
        logger.info(responseAsDto.getUsername());
        logger.info(responseAsDto.getBooks()[0].getTitle());

        // Add asserts
        // Simple assert
        Assert.assertEquals("User ID is not expected.", ConfigProvider.configHiddenProperties.user_id(), responseAsDto.getUserId());

        // Complex asserts
        BookDto[] expectedBooksDto = {
                TestData.bookGitPocketGuide

//                new BookDto(
//                        "9781449325862",
//                        "Git Pocket Guide",
//                        "A Working Introduction",
//                        "Richard E. Silverman",
//                        "O'Reilly Media",
//                        234,
//                        "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp")
        };
        UsersBooksDto expectedUserBooksDto = UsersBooksDto.builder()
                .userId(ConfigProvider.configHiddenProperties.user_id())
                .username("vova")
                .books(expectedBooksDto)
                .build();


        //new UsersBooksDto(USER_ID, "vova", expectedBooksDto);

        Assert.assertEquals("Number of books ", expectedUserBooksDto.getBooks().length, responseAsDto.getBooks().length);

        // Old manner with isEqualToIgnoringGivenFields method
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(responseAsDto.getUserId()).isEqualTo(expectedUserBooksDto.getUserId());
        softAssertions.assertThat(responseAsDto.getUsername()).isEqualTo(expectedUserBooksDto.getUsername());

//        for (int i = 0; i < expectedUserBooksDto.getBooks().length; i++) {
//            softAssertions.assertThat(responseAsDto.getBooks()[i])
//                    .isEqualToIgnoringGivenFields(expectedUserBooksDto.getBooks()[i],
//                            "publish_date", "website");
//        }

        // New method with recursion
        softAssertions.assertThat(responseAsDto)
                .usingRecursiveComparison()
                .ignoringFields("books.publish_date", "books.website")
                .isEqualTo(expectedUserBooksDto);

        softAssertions.assertAll();
    }

    @Test
    public void getBooksNegativeTest() {
//        {
//            "code": "1207",
//                "message": "User not found!"
//        }
        String actualResponse =
                given()
                        .filter(new AllureRestAssured())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get(EndPoints.BOOKS_BY_USER, "NOT_VALID_USER_ID")  // URL
                        .then()
                        .statusCode(401)
                        .log().all()
                        .extract().response().body().asString();

        Assert.assertEquals("Message in response ", "{\"code\":\"1200\",\"message\":\"User not authorized!\"}", actualResponse);
    }

    @Test
    public void getBooksPathTest() {
        Response response = given()
                .filter(new AllureRestAssured())
                .headers(
                        "accept", ContentType.JSON,
                        "Authorization", "Bearer " + token
                )
                .log().all()
                .when()
                .get(EndPoints.BOOKS_BY_USER, ConfigProvider.configHiddenProperties.user_id())  // URL
                .then()
                .statusCode(200)
                .extract().response();

        List<String> actualBooksAsStrings = response.jsonPath().getList("books.title", String.class);

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < actualBooksAsStrings.size(); i++) {
            softAssertions.assertThat(actualBooksAsStrings.get(i)).as("Item number " + i).contains("Git");

        }

        List<Map> actualBooksAsMaps = response.jsonPath().getList("books", Map.class);

        for (int i = 0; i < actualBooksAsMaps.size(); i++) {
            softAssertions.assertThat(actualBooksAsMaps.get(i).get("isbn")).as("Item number ").isEqualTo("9781449325862");
        }

        softAssertions.assertAll();
    }

    @Test
    public void getBooksSchemaTest() {
        given()
                .filter(new AllureRestAssured())
                .headers(
                        "accept", ContentType.JSON,
                        "Authorization", "Bearer " + token
                )
                .log().all()
                .when()
                .get(EndPoints.BOOKS_BY_USER, ConfigProvider.configHiddenProperties.user_id())  // URL
                .then()
                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("response.json"));
    }
}
