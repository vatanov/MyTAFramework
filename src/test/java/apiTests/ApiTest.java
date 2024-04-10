package apiTests;

import api.EndPoints;
import api.dto.responseDto.BookDto;
import api.dto.responseDto.UsersBooksDto;
import io.restassured.http.ContentType;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;

public class ApiTest {
    final String USER_ID = "e7faf904-e52e-43bd-b4d1-17c2eeb39a6d";
    Logger logger = Logger.getLogger(getClass());
    @Test
    public void getBooksTest() {
        UsersBooksDto responseAsDto = given()
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
        Assert.assertEquals("User ID is not expected.", USER_ID, responseAsDto.getUserId());

        // Complex asserts
        BookDto[] expectedBooksDto = {
                new BookDto(
                        "9781449325862",
                        "Git Pocket Guide",
                        "A Working Introduction",
                        "Richard E. Silverman",
                        "O'Reilly Media",
                        234,
                        "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp")
        };
        UsersBooksDto expectedUserBooksDto = new UsersBooksDto(USER_ID, "vova", expectedBooksDto);

        Assert.assertEquals("Number of books ", expectedUserBooksDto.getBooks().length, responseAsDto.getBooks().length);

        // Old manner with isEqualToIgnoringGivenFields method
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(responseAsDto.getUserId()).isEqualTo(expectedUserBooksDto.getUserId());
        softAssertions.assertThat(responseAsDto.getUsername()).isEqualTo(expectedUserBooksDto.getUsername());

        for (int i = 0; i < expectedUserBooksDto.getBooks().length; i++) {
            softAssertions.assertThat(responseAsDto.getBooks()[i])
                    .isEqualToIgnoringGivenFields(expectedUserBooksDto.getBooks()[i],
                            "publish_date", "website");
        }

        softAssertions.assertAll();
    }
}
