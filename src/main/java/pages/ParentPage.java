package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

abstract public class ParentPage extends ActionsWithElements{

    Logger logger = Logger.getLogger(getClass());
    final String BASE_URL = "http://192.168.64.4/doctorpatientportal";
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

    abstract protected String getRelativeUrl();

    //check URL
    protected void checkUrl(String relativeUrl) {
        Assert.assertEquals("URL is not expected", BASE_URL + relativeUrl, webDriver.getCurrentUrl());
    }

    protected void checkUrl() { checkUrl(getRelativeUrl()); }

        protected void checkUrlWithPattern(String relativeUrl) {
        Assert.assertTrue("URL is not expected \n"
                + "Expected result: " + BASE_URL + relativeUrl + "\n"
                + "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(BASE_URL + relativeUrl));
    }

    protected void checkUrlWithPattern() { checkUrlWithPattern(getRelativeUrl()); }

}
