package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    // Create webDriver instance
    WebDriver webDriver;
    String url = "http://192.168.64.3/doctorpatientportal/help.php";

    @Ignore
    @Test
    public void validLogin() {
        // Set up Chrome
        WebDriverManager.chromedriver().clearDriverCache().setup();
        // Set webdriver to work with Chrome
        webDriver = new ChromeDriver();
        // Maximize Chrome window
        webDriver.manage().window().maximize();
        // Set waiting for 5 seconds
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Browser is opened");
        // open link
        webDriver.get(url);
        System.out.println("Site is opened");

        // Find Login button and click it
        webDriver.findElement(By.xpath("//a[@data-target='#login']")).click();

        // Find email field and save it in variable
        WebElement inputEmail = webDriver.findElement
                (By.xpath("//div[@class='modal fade in']//input[@placeholder='Enter your email']"));
        // Clear field in case if some text is there
        inputEmail.clear();
        // Type required email in the fielf
        inputEmail.sendKeys("j.doe@mail.com");
        System.out.println("Email is typed");

        // Find password field
        WebElement inputPassword = webDriver.findElement
                (By.xpath("//div[@class='modal fade in']//input[@placeholder='Enter your password']"));
        inputPassword.clear();
        inputPassword.sendKeys("qwerty");
        System.out.println("Password is typed");

        // Click Login button
        webDriver.findElement(By.xpath("//div[@class='modal fade in']//input[@value='Login']")).click();
        System.out.println("Button is pressed");

        // Find drop-down
        //WebElement userMenu = webDriver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
        // Check if User menu is displayed
        Assert.assertTrue("User menu is not displayed", isUserMenuDisplayed());
        System.out.println("User menu is displayed");
    }

    @Ignore
    @Test
    public void invalidLogin() {
        // Set up Chrome
        WebDriverManager.chromedriver().clearDriverCache().setup();
        // Set webdriver to work with Chrome
        webDriver = new ChromeDriver();
        // Maximize Chrome window
        webDriver.manage().window().maximize();
        // Set waiting for 5 seconds
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Browser is opened");
        // open link
        webDriver.get(url);
        System.out.println("Site is opened");

        // Find Login button and click it
        webDriver.findElement(By.xpath("//a[@data-target='#login']")).click();

        // Find email field and save it in variable
        WebElement inputEmail = webDriver.findElement
                (By.xpath("//div[@class='modal fade in']//input[@placeholder='Enter your email']"));
        // Clear field in case if some text is there
        inputEmail.clear();
        // Type required email in the fielf
        inputEmail.sendKeys("j.doe@mail.com");
        System.out.println("Email is typed");

        // Find password field
        WebElement inputPassword = webDriver.findElement
                (By.xpath("//div[@class='modal fade in']//input[@placeholder='Enter your password']"));
        inputPassword.clear();
        inputPassword.sendKeys("wrong_password");
        System.out.println("Password is typed");

        // Click Login button
        webDriver.findElement(By.xpath("//div[@class='modal fade in']//input[@value='Login']")).click();
        System.out.println("Button is pressed");

        // Find drop-down
        //WebElement userMenu = webDriver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
        // Check if Wrong password message is displayed
        Assert.assertTrue("Wrong password message is not displayed", isWrongPasswordMessageDisplayed());
        System.out.println("Wrong password message is displayed");
        // Check if URL is correct
        Assert.assertEquals("URL is not correct", webDriver.getCurrentUrl(), url);
        System.out.println("URL is correct");
        // Check if Login button is displayed
        Assert.assertTrue("Login button is not displayed", isLoginBtnDisplayed());
        System.out.println("Login button is displayed");
    }

    @After // Method to close browser
    public void tearDown() {
        // Close whole browser (NOT only tab). webDriver.close() closes tab only.
        webDriver.quit();
    }

    // Method to check is User menu is displayed
    private boolean isUserMenuDisplayed() {
        try {
            webDriver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isWrongPasswordMessageDisplayed() {
        try {
            // Webdriver finds alert window, gets text from and accepts it
            String alertText = webDriver.switchTo().alert().getText();
            webDriver.switchTo().alert().accept();
            return alertText.equals("Wrong Patient Email or Password");
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isLoginBtnDisplayed() {
        try {
            webDriver.findElement(By.xpath("//a[@data-target='#login']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
