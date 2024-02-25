package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage extends ActionsWithElements{
    final String BASE_URL = "http://192.168.64.3/doctorpatientportal/help.php";
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
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
}
