package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    // Create webDriver instance
    WebDriver webDriver;
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
        webDriver.get("http://192.168.64.3/doctorpatientportal/help.php");
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
        WebElement userMenu = webDriver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
        // Check is User menu is displayed
        Assert.assertTrue("User menu is not displayed", userMenu.isDisplayed());



        // Close whole browser (NOT only tab). webDriver.close() closes tab only.
        webDriver.quit();
    }
}
