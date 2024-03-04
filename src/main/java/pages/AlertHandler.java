package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandler extends ActionsWithElements {
    Alert alert;
    public AlertHandler(WebDriver webDriver) {
        super(webDriver);
        try {
            this.alert = webDriver.switchTo().alert();
            logger.info("Alert was caught");
        } catch (Exception e) {
            logger.error("There is no alert. " + e);
            this.alert = null;
        }
    }

    public String getAlertText() {
        if (this.alert == null) {
            return "";
        } else {
            String text = this.alert.getText();
            logger.info("Text of alert is " + text);
            return text;
        }
    }

    public void acceptAlert() {
        if (this.alert != null) {
            this.alert.accept();
            logger.info("Alert was accepted");
        }
    }

    public void dismissAlert() {
        if (this.alert != null) {
            this.alert.dismiss();
            logger.info("Alert was dismissed");
        }
    }

    public boolean isAlertPresent() {
        return this.alert != null;
    }

    public boolean isAlertTextPresent(String text) {
        return this.getAlertText().contains(text);
    }

    public AlertHandler checkAlertPresent() {
        Assert.assertTrue("Alert is not present.", this.isAlertPresent());
        return this;
    }

    public AlertHandler checkTextInAlert(String text) {
        Assert.assertEquals("Alert text is not as expected.", text, this.getAlertText());
        return this;
    }
}
