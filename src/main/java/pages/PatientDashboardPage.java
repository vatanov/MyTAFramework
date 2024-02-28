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

    @FindBy(xpath = "//a[@href='#makeap']")
    private WebElement makeAppointmentButton;

    @FindBy(xpath = "//a[@href='#msger']")
    private WebElement messengerButton;

    @FindBy(xpath = "//a[@href='#compose']")
    private WebElement msgrComposeButton;

    // Messenger elements:
    @FindBy(xpath = "//select[@name='doccat2']")
    private WebElement msgrDoctorTypeDropdown;

    @FindBy(xpath = "//select[@name='docho2']")
    private WebElement msgrDoctorNameDropdown;

    @FindBy(xpath = "//input[@name='sub']")
    private WebElement msgrSubjectInput;

    @FindBy(xpath = "//textarea[@name='msg']")
    private WebElement msgrMessageInput;

    @FindBy(xpath = "//input[@value='Send']")
    private WebElement msgrSendButton;

    public PatientDashboardPage checkIsPayForAppointmentButtonDisplayed() {
        checkElementDisplayed(payForAppointmentButton);
        return this;
    }

    public PatientDashboardPage clickMakeAppointmentButton() {
        clickOnElement(makeAppointmentButton);
        return this;
    }

    public PatientDashboardPage clickMessengerButton() {
        clickOnElement(messengerButton);
        return this;
    }

    public PatientDashboardPage msgrClickComposeButton() {
        clickOnElement(msgrComposeButton);
        return this;
    }

    public PatientDashboardPage msgrSetDoctorTypeDropdown(String doctorType) {
        selectByValueInDropdown(msgrDoctorTypeDropdown, doctorType);
        return this;
    }

    public PatientDashboardPage msgrSetDoctorNameDropdown(String doctorName) {
        selectByVisibleTextInDropdown(msgrDoctorNameDropdown, doctorName);
        return this;
    }

    public PatientDashboardPage msgrTypeSubject(String subject) {
        enterTextIntoInput(msgrSubjectInput, subject);
        return this;
    }

    public PatientDashboardPage msgrTypeMessage(String message) {
        enterTextIntoInput(msgrMessageInput, message);
        return this;
    }

    public void msgrClickSendButton() {
        clickOnElement(msgrSendButton);
    }

    public PatientDashboardPage checkIsRedirectedToPatientDashboard() {
        //TODO check URL
        //TODO check some unique elements
        checkIsPayForAppointmentButtonDisplayed();
        return this;
    }
}
