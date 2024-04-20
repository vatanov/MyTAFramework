package apiTests;

import api.ApiHelper;
import api.EndPoints;
import api.dto.requestDto.AddBookDto;
import api.dto.requestDto.IsbnDto;
import api.dto.responseDto.BookDto;
import data.TestData;
import io.restassured.http.ContentType;
import libs.ConfigProvider;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AddBookByApiTest {
    ApiHelper apiHelper = new ApiHelper();

    @Test
    public void addBookByApiTest() {
        String token = apiHelper.getToken();

        IsbnDto[] collectionOfIsbns = {IsbnDto.builder()
                .isbn(TestData.bookLearningJavaScriptDesignPatterns.getIsbn())
                .build()};

        AddBookDto addBookBody =
                AddBookDto.builder()
                        .userId(ConfigProvider.configHiddenProperties.user_id())
                        .collectionOfIsbns(collectionOfIsbns)
                        .build();

        String response =
                given()
                        .headers(
                                "accept", ContentType.JSON,
                                "Authorization", "Bearer " + token
                        )
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(addBookBody)
                        .when()
                        .post(EndPoints.ADD_BOOKS)
                        .then()
                        .statusCode(201)
                        .log().all()
                        .extract().response().getBody().asString();

        Assert.assertTrue(response.contains(collectionOfIsbns[0].getIsbn()));

        BookDto[] expectedBooks = {TestData.bookGitPocketGuide, TestData.bookLearningJavaScriptDesignPatterns};
        BookDto[] actualBooks = apiHelper.getAllBooksByUser();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualBooks)
                .usingRecursiveComparison()
                .ignoringFields("publish_date", "website")
                .isEqualTo(expectedBooks);

        softAssertions.assertAll();
    }

    @After
    public void cleanUp() {
        apiHelper.deleteBookByUser(TestData.bookLearningJavaScriptDesignPatterns.getIsbn());
    }
}
