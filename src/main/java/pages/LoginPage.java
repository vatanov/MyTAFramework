package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.Header;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

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

    @Override
    protected String getRelativeUrl() {
        return "/index.php";
    }
    public void openLoginPage() {
        openPage(BASE_URL + "/index.php");
        checkUrl();
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

    public void loginWithValidCreds() {
        openLoginPage();
        getHeader().clickLoginButton();
        enterEmail(LOGIN_DEFAULT);
        enterPassword(PASSWORD_DEFAULT);
        clickLoginButtonInModal();
    }
}
