package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends ParentPage {

    @FindBy(xpath = "//div[contains(text(), 'See You Soon !')]")
    private WebElement seeYouSoonMessage;

    public LogoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/logout.php";
    }

    public void CheckIsSeeYouSoonMessageDisplayed() {
        isElementDisplayed(seeYouSoonMessage);
    }
}
