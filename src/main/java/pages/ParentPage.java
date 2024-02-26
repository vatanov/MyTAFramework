package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

public class ParentPage extends ActionsWithElements{

    Logger logger = Logger.getLogger(getClass());
    final String BASE_URL = "http://192.168.64.3/doctorpatientportal/help.php";
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page is opened " + url);
        } catch (Exception e) {
            logger.error("Can not open URL " + url);
            // If we can not open page, we do not need to continue our test
            Assert.fail("Can not open URL " + url);
        }
    }
}
