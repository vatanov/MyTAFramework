package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

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

    @FindBy(xpath = "//a[@href='logout.php']")
    private WebElement logoutButton;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsLogoDisplayed() {
        checkElementDisplayed(logo);
    }

    public void checkIsHomeButtonDisplayed() {
        checkElementDisplayed(homeButton);
    }

    public void checkIsAboutButtonDisplayed() {
        checkElementDisplayed(aboutButton);
    }

    public void checkIsContactButtonDisplayed() {
        checkElementDisplayed(contactButton);
    }

    public void checkIsHelpButtonDisplayed() {
        checkElementDisplayed(helpButton);
    }

    public void checkIsLoginButtonDisplayed() {
        checkElementDisplayed(loginButton);
    }

    public void checkIsLoginButtonNotDisplayed() {
       checkElementNotDisplayed(loginButton);
    }

    public void checkIsRegisterButtonDisplayed() {
        checkElementDisplayed(registerButton);
    }

    public void checkIsDropdownMenuDisplayed() {
        checkElementDisplayed(dropdownMenu);
    }

    public void clickHomeButton() {
        clickOnElement(homeButton);
    }

    public void clickAboutButton() {
        clickOnElement(aboutButton);
    }

    public void clickContactButton() {
        clickOnElement(contactButton);
    }

    public void clickHelpButton() {
        clickOnElement(helpButton);
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    public void clickRegisterButton() {
        clickOnElement(registerButton);
    }

    public void clickDropdownMenu() {
        clickOnElement(dropdownMenu);
    }

    public void clickLogout() {
        clickOnElement(logoutButton);
    }
}
