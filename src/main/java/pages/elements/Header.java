package pages.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.PatientDashboardPage;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//img[@class='logomain']")
    private WebElement logo;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-home']")
    private WebElement homeButton;

    @FindBy(xpath = "//a[@href='about.php']")
    private WebElement aboutButton;

    @FindBy(xpath = "//a[@href='contact.php']")
    private WebElement contactButton;

    @FindBy(xpath = "//a[@href='help.php']")
    private WebElement helpButton;

    @FindBy(xpath = "//a[@data-target='#login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@data-target='#register']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[@data-toggle='dropdown']")
    private WebElement dropdownMenu;

    @FindBy(xpath = "//a[@href='patient.php']")
    private WebElement yourDashboard;

    @FindBy(xpath = "//a[@href='logout.php']")
    private WebElement logoutButton;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void checkIsLogoDisplayed() {
        checkElementDisplayed(logo);
    }

    @Step
    public void checkIsHomeButtonDisplayed() {
        checkElementDisplayed(homeButton);
    }

    @Step
    public void checkIsAboutButtonDisplayed() {
        checkElementDisplayed(aboutButton);
    }

    @Step
    public void checkIsContactButtonDisplayed() {
        checkElementDisplayed(contactButton);
    }

    @Step
    public void checkIsHelpButtonDisplayed() {
        checkElementDisplayed(helpButton);
    }

    @Step
    public void checkIsLoginButtonDisplayed() {
        checkElementDisplayed(loginButton);
    }

    @Step
    public void checkIsLoginButtonNotDisplayed() {
       checkElementNotDisplayed(loginButton);
    }

    @Step
    public void checkIsRegisterButtonDisplayed() {
        checkElementDisplayed(registerButton);
    }

    @Step
    public void checkIsDropdownMenuDisplayed() {
        checkElementDisplayed(dropdownMenu);
    }

    @Step
    public void clickHomeButton() {
        clickOnElement(homeButton);
    }

    @Step
    public void clickAboutButton() {
        clickOnElement(aboutButton);
    }

    @Step
    public void clickContactButton() {
        clickOnElement(contactButton);
    }

    @Step
    public void clickHelpButton() {
        clickOnElement(helpButton);
    }

    @Step
    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    public void clickRegisterButton() {
        clickOnElement(registerButton);
    }

    @Step
    public Header clickDropdownMenu() {
        clickOnElement(dropdownMenu);
        return this;
    }

    @Step
    public PatientDashboardPage clickYourDashboard() {
        clickOnElement(yourDashboard);
        return new PatientDashboardPage(webDriver);
    }

    @Step
    public void clickLogout() {
        clickOnElement(logoutButton);
    }
}
