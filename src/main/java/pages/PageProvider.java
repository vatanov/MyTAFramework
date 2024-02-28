package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public LogoutPage getLogoutPage() {
        return new LogoutPage(webDriver);
    }

    public PatientDashboardPage getPatientDashboardPage() {
        return new PatientDashboardPage(webDriver);
    }

    public AlertHandler getAlertHandler() {
        return new AlertHandler(webDriver);
    }
}
