package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//a[@data-toggle='dropdown']")
    private WebElement dropdownMenu;
    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsDropdownMenuDisplayed() {
        checkElementDisplayed(dropdownMenu);
    }
}
