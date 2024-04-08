package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/index.php";
    }

    @Step
    public HomePage openHomePageAndLogin() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginWithValidCreds();
        openHomePage();
        return this;
    }

    @Step
    public HomePage openHomePage() {
        getHeader().clickHomeButton();
        checkIsRedirectedToHomePage();
        return this;
    }

    @Step
    public HomePage checkIsRedirectedToHomePage() {
        checkUrl();
        //TODO check some unique elements
        getHeader().checkIsDropdownMenuDisplayed();
        return this;
    }
}
