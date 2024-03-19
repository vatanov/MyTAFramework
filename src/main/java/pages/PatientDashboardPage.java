package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PatientDashboardPage extends ParentPageWithHeader{
    public PatientDashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/patient.php";
    }

    @FindBy(xpath = "//a[@href='#papt']")
    private WebElement payForAppointmentButton;

    @FindBy(xpath = "//a[@href='#makeap']")
    private WebElement makeAppointmentButton;

    @FindBy(xpath = "//a[@href='#msger']")
    private WebElement messengerButton;

    @FindBy(xpath = "//a[@href='#compose']")
    private WebElement msgrComposeButton;

    @FindBy(xpath = "//a[@href='#sent']")
    private WebElement msgrSentButton;

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

    /**
     * Defines the locator for the message subject in the sent messages list if text is changeable each time
     * Unique text should be passed to the method as a parameter and will be replaced with %s in the locator
     */
    private String msgrSubjectLocator = "//*[text()='%s']";

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

    public PatientDashboardPage msgrClickSentButton() {
        clickOnElement(msgrSentButton);
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
        checkUrl();
        //TODO check some unique elements
        checkIsPayForAppointmentButtonDisplayed();
        return this;
    }

    /**
     * Returns list of sent messages with the same subject
     */
    private List<WebElement> msgrGetSentMessagesList(String subject) {
        return webDriver.findElements(By.xpath(String.format(msgrSubjectLocator, subject))); // subjectLocator.replace("%s", subject)
    }

    /**
     * Verifies that sent message is present in the list and only one message is present
     */
    public PatientDashboardPage msgrCheckSentMsgIsPresent(String subject) {
        Assert.assertEquals("Count of sent messages is " + subject, 1,
                msgrGetSentMessagesList(subject).size());

        return this;
    }
}
