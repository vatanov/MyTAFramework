package pages;

import org.openqa.selenium.WebDriver;

public class ParentPage extends ActionsWithElements{
    final String BASE_URL = "http://192.168.64.3/doctorpatientportal/help.php";
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
}
