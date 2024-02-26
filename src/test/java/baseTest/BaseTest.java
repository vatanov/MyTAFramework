package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    protected PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        logger.info("\n");
        logger.info("=====> Setup for Test " + testName.getMethodName() + " is started");
        WebDriverManager.chromedriver().clearDriverCache().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Browser is opened");
        pageProvider = new PageProvider(webDriver);
        logger.info("=====> Setup for Test " + testName.getMethodName() + " is finished");
        logger.info("=====> Test " + testName.getMethodName() + " is started");
    }

    @After
    public void tearDown() {
        logger.info("=====> Test " + testName.getMethodName() + " is finished");
        logger.info("=====> Tear down for Test " + testName.getMethodName() + " is started");
        webDriver.quit();
        logger.info("Browser is closed");
        logger.info("=====> Tear down for Test " + testName.getMethodName() + " is finished");
    }
}
