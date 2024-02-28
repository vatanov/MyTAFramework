package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientDashboardPage extends ParentPageWithHeader{
    public PatientDashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@href='#papt']")
    private WebElement payForAppointmentButton;

    public void checkIsPayForAppointmentButtonDisplayed() {
        checkElementDisplayed(payForAppointmentButton);
    }

    public PatientDashboardPage checkIsRedirectedToPatientDashboard() {
        //TODO check URL
        //TODO check some unique elements
        checkIsPayForAppointmentButtonDisplayed();
        return this;
    }
}
