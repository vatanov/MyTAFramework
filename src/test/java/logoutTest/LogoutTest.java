package logoutTest;

import baseTest.BaseTest;
import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class LogoutTest extends BaseTest {
    @Test
    public void logoutTest() {
        // Login user
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().getHeader().clickLoginButton();
        pageProvider.getLoginPage().enterEmail(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickLoginButtonInModal();

        // Logout user
        pageProvider.getHomePage().getHeader().clickDropdownMenu();
        pageProvider.getHomePage().getHeader().clickLogout();

        pageProvider.getLogoutPage().CheckIsSeeYouSoonMessageDisplayed();

        // Check Home page Header
        pageProvider.getHomePage().getHeader().checkIsLogoDisplayed();
        pageProvider.getHomePage().getHeader().checkIsHomeButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsAboutButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsContactButtonDisplayed();
        pageProvider.getHomePage().getHeader().checkIsHelpButtonDisplayed();

        pageProvider.getHomePage().getHeader().checkIsLoginButtonDisplayed();
    }
}