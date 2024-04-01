package loginTest;

import libs.ConfigProperties;
import libs.ConfigProvider;
import libs.ExcelDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTestV2 extends baseTest.BaseTest{
    @Test
    public void validLoginTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().getHeader().clickLoginButton();
        pageProvider.getLoginPage().enterEmail(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickLoginButtonInModal();

        pageProvider.getHomePage().openHomePage();
        pageProvider.getHomePage().getHeader().checkIsLogoDisplayed();
        pageProvider.getHomePage().getHeader().checkIsHomeButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsAboutButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsContactButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsHelpButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsDropdownMenuDisplayed();

        pageProvider.getHomePage().getHeader().checkIsLoginButtonNotDisplayed();
    }

    @Test
    public void validLoginWithExcelTest() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(
                ConfigProvider.configProperties.DATA_FILE(), "validLogOn");

        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().getHeader().clickLoginButton();
        pageProvider.getLoginPage().enterEmail(dataForValidLogin.get("login"));
        pageProvider.getLoginPage().enterPassword(dataForValidLogin.get("pass"));
        pageProvider.getLoginPage().clickLoginButtonInModal();

        pageProvider.getHomePage().openHomePage();
        pageProvider.getHomePage().getHeader().checkIsLogoDisplayed();
        pageProvider.getHomePage().getHeader().checkIsHomeButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsAboutButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsContactButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsHelpButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsDropdownMenuDisplayed();

        pageProvider.getHomePage().getHeader().checkIsLoginButtonNotDisplayed();
    }
}
