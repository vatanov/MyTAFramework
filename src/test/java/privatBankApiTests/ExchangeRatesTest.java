package privatBankApiTests;

import api.EndPoints;
import api.privatBankApi.PBEndPoints;
import api.privatBankApi.PBTestData;
import api.privatBankApi.pbResponseDto.ExchangeRatesDto;
import io.restassured.http.ContentType;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ExchangeRatesTest {
    public Map<String, String> dateParam = new HashMap<String, String>();
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getExchangeRates() {
    dateParam.put("date",PBTestData.DATE);
        ExchangeRatesDto responseAsDto = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .queryParams(dateParam)
                .get(PBEndPoints.EXCHANGE_RATES)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(ExchangeRatesDto.class)
        ;
        logger.info(responseAsDto);

        ExchangeRatesDto expectedExchangeRatesDto = PBTestData.getExchangeRatesDto();

        Assert.assertEquals("Number of currencies: ",
                expectedExchangeRatesDto.getExchangeRate().length,
                responseAsDto.getExchangeRate().length);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(responseAsDto.getDate()).isEqualTo(expectedExchangeRatesDto.getDate());
        softAssertions.assertThat(responseAsDto.getBank()).isEqualTo(expectedExchangeRatesDto.getBank());
        softAssertions.assertThat(responseAsDto.getBaseCurrency()).isEqualTo(expectedExchangeRatesDto.getBaseCurrency());
        softAssertions.assertThat(responseAsDto.getBaseCurrencyLit()).isEqualTo(expectedExchangeRatesDto.getBaseCurrencyLit());

        for (int i = 0; i < expectedExchangeRatesDto.getExchangeRate().length; i++) {
            softAssertions.assertThat(responseAsDto.getExchangeRate()[i])
                    .isEqualToIgnoringGivenFields(expectedExchangeRatesDto.getExchangeRate()[i],
                            "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");
        }

        softAssertions.assertAll();
    }

    @Test
    public void getExchangeRatesSchemaTest() {
        dateParam.put("date",PBTestData.DATE);
        given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .queryParams(dateParam)
                .get(PBEndPoints.EXCHANGE_RATES)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("pbResponse.json"));
    }

}
