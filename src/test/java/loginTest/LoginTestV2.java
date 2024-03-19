package loginTest;

import libs.ConfigProvider;
import org.junit.Test;

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

        pageProvider.getHomePage().getHeader().checkIsLogoDisplayed();
        pageProvider.getHomePage().getHeader().checkIsHomeButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsAboutButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsContactButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsHelpButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsDropdownMenuDisplayed();

        pageProvider.getHomePage().getHeader().checkIsLoginButtonNotDisplayed();
    }
}
