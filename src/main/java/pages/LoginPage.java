package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPageWithHeader{

    @FindBy(xpath = "//div[@class='modal fade in']//input[@placeholder='Enter your email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//div[@class='modal fade in']//input[@placeholder='Enter your password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@class='modal fade in']//input[@value='Login']")
    private WebElement loginButtonInModal;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterEmail(String email) {
        enterTextIntoInput(inputEmail, email);
    }

    public void enterPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickLoginButtonInModal() {
        clickOnElement(loginButtonInModal);
    }
}
