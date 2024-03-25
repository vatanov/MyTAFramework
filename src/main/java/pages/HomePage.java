package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/index.php";
    }

    public HomePage openHomePageAndLogin() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginWithValidCreds();
        openHomePage();
        return this;
    }

    public HomePage openHomePage() {
        getHeader().clickHomeButton();
        checkIsRedirectedToHomePage();
        return this;
    }

    public HomePage checkIsRedirectedToHomePage() {
        checkUrl();
        //TODO check some unique elements
        getHeader().checkIsDropdownMenuDisplayed();
        return this;
    }
}
