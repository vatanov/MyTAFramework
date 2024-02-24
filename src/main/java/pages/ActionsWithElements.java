package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionsWithElements {
    protected WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        // Initialize all web elements in this and child classes
        PageFactory.initElements(webDriver, this); // elements with @FindBy annotation
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            System.out.println("Page is opened" + url);
        } catch (Exception e) {
            System.out.println("Can not open URL" + url);
            // If we can not open page, we do not need to continue our test
            Assert.fail("Can not open URL" + url);
        }
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            System.out.println(text + " was inputted into input");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            System.out.println("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return false;
        }
    }

    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    private void printErrorAndStopTest(Exception e) {
        System.out.println("Can not work with element" + e);
        // If we can not work with element, we do not need to continue our test
        Assert.fail("Can not work with element" + e);
    }
}
