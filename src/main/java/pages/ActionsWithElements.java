package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsWithElements {
    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait5, webDriverWait10;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        // Initialize all web elements in this and child classes
        PageFactory.initElements(webDriver, this); // elements with @FindBy annotation will be initialized here
        // Initialize webDriverWaits to wait for element if it is not immediately available
        webDriverWait5 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input");
        } catch (Exception e) {
            logger.error("Cannot input text into input. " + e);
        }
    }

    public void selectByVisibleTextInDropdown(WebElement element, String text) {
        try {
            Thread.sleep(500);
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectByValueInDropdown(WebElement element, String value) {
        try {
            webDriverWait5.until(ExpectedConditions.elementToBeClickable(element));
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + " was selected in dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            if (state) {
                logger.info("Element is displayed");
            } else {
                logger.info("Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    public void checkElementNotDisplayed(WebElement element) {
        Assert.assertFalse("Element is displayed", isElementDisplayed(element));
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element. " + e);
        // If we can not work with element, we do not need to continue our test
        Assert.fail("Can not work with element. " + e);
    }

    public void checkIfElementContainsText(WebElement element, String text) {
        try {
            Assert.assertTrue("Text is not found", element.getText().contains(text));
            logger.info("Text is found");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
