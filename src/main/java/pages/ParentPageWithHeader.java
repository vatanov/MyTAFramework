package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.Header;

public class ParentPageWithHeader extends ParentPage {
    Header header;
    public ParentPageWithHeader(WebDriver webDriver) {
        super(webDriver);
    }
    public Header getHeader() {
        return new Header(webDriver);
    }
}
