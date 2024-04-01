package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
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
        logger.info("=================================================================");
        logger.info("=====> Setup for Test " + testName.getMethodName() + " is started");
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        //webDriver = new ChromeDriver();
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
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

    // This method is used to initialize the WebDriver with the browser specified in the system property
    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || browser.equalsIgnoreCase("chrome")) { // default browser -Dbrowser=chrome
            WebDriverManager.chromedriver().clearDriverCache().setup();
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) { // -Dbrowser=firefox
            WebDriverManager.firefoxdriver().clearDriverCache().setup();
            webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) { // -Dbrowser=edge
            WebDriverManager.edgedriver().clearDriverCache().setup();
            webDriver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().clearDriverCache().setup();
            webDriver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Browser " + browser + " is not supported");
        }
        return webDriver;
    }
}
