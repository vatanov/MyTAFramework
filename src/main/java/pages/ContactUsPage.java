package pages;

import libs.DateTimeUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ContactUsPage extends ParentPageWithHeader {

    public ContactUsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//td[contains(text(), 'Email')]")
    private WebElement emailLabel;

    @FindBy(xpath = "//tr[1]//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//td[contains(text(), 'Subject')]")
    private WebElement subjectLabel;

    @FindBy(xpath = "//tr[2]//input[@type='text']")
    private WebElement subjectInput;

    @FindBy(xpath = "//td[contains(text(), 'Message')]")
    private WebElement messageLabel;

    @FindBy(xpath = "//tr[3]//textarea[@name='message']")
    private WebElement messageInput;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;

    private final String alertMessageXpath = "//div[@class='alert alert-danger']";

    @FindBy(xpath = alertMessageXpath)
    private WebElement alertMessage;

    public ContactUsPage openContactUsPage() {
        openPage(BASE_URL);
        getHeader().clickContactButton();
        checkIsRedirectedToContactUsPage();
        return this;
    }

    private ContactUsPage checkIsRedirectedToContactUsPage() {
        checkIsContactUsPageDisplayed();
        return this;
    }

    private void checkIsContactUsPageDisplayed() {
        checkElementDisplayed(emailLabel);
        checkElementDisplayed(subjectLabel);
        checkElementDisplayed(messageLabel);
    }


    public ContactUsPage typeEmail(String email) {
        enterTextIntoInput(emailInput, email);
        return this;
    }

    public ContactUsPage typeSubject(String subject) {
        enterTextIntoInput(subjectInput, subject);
        return this;
    }

    public ContactUsPage typeMessage(String message) {
        enterTextIntoInput(messageInput, message);
        return this;
    }

    public ContactUsPage clickSubmitButton() {
        clickOnElement(submitButton);
        return this;
    }

    public ContactUsPage checkIsAlertMessageDisplayed() {
        checkElementDisplayed(alertMessage);
        return this;
    }

    public ContactUsPage checkTextInAlertMessage(String text) {
        checkIfElementContainsText(alertMessage, text);
        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(alertMessageXpath));
    }

    public ContactUsPage checkAllAlertMessages(String expectedMessages) {

        // error1; error2 -> [error1, error2]
        String[] errors = expectedMessages.split(";");

        // wait until number of errors will be excepted
        webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(By.xpath(alertMessageXpath), errors.length));
        DateTimeUtils.waitABit(1); // wait until EXTRA errors will be displayed
        Assert.assertEquals("Number of elements ", errors.length, getListOfErrors().size());

        // get texts from all messages
        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }

        // add soft assert to execute several asserts “in one”
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Error " + i)
                    .isIn(actualTextFromErrors);
        }
        softAssertions.assertAll(); // check all soft assertions

        return this;
    }
}
