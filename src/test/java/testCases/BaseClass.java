package testCases;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObjects.ApplicationLoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass
{
    public WebDriver driver;
    protected static final Logger logger =LogManager.getLogger(BaseClass.class);
    public Properties p;
    ApplicationLoginPage lp;

    @BeforeClass
    @Parameters({"os","browser"})
    public void launchingBrowser(
            @Optional("windows") String os,
            @Optional("chrome") String br) throws IOException {

        //loading the properties file
        FileReader file = new FileReader("src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        switch (br.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                logger.info("Initializing the chrome Browser......");
                break;
            case "edge":
                driver = new EdgeDriver();
                logger.info("Initializing the Edge Browser......");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("Initializing the Firefox Browser......");
                break;
            default:
                System.out.println("Invalid browser");
                return;


        }
    }

        @BeforeMethod
        public void logintotheApplication() {
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("launching ORangeHRM application");
            driver.get(p.getProperty("appURL"));
            driver.manage().window().maximize();

            lp = new ApplicationLoginPage(driver);
            logger.info("Fetching the credentials from the properties file");
            System.out.println("Username:" + p.getProperty("username"));
            lp.setText_username(p.getProperty("username"));
            System.out.println("Password:" + p.getProperty("Password"));
            lp.setText_password(p.getProperty("Password"));
            logger.info("click on submit button");
            lp.setLogin_btn();

    }

    @AfterClass
    void tearDown() {

        lp = new ApplicationLoginPage(driver);
        logger.info("click on logout button");
        lp.setClickbutton();
        lp.setLogout();
        logger.info("logout application successfully.....");
        driver.quit();
        logger.info("Closed the browser successfully");
    }

//    public String randomString()
//    {
//        String  generatedString= RandomStringUtils.randomAlphabetic(6);
//        return generatedString;
//    }
    public String randomString() {
        return RandomStringUtils.secure().nextAlphabetic(6);
    }
    public String  randomNumber()
    {
        String genaratedNumber= RandomStringUtils.randomNumeric(4);
        return genaratedNumber;
    }
    /*public int randomNumber1()
    {
        String genaratedNumber1= RandomStringUtils.randomNumeric(1);
        return genaratedNumber1;
    }
*/

    public void confirm_msg() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        if (pageSource.contains("Success")) {
            System.out.println("SUCCESS: Employee details saved successfully");
        } else {
            System.out.println("FAIL: Success message not found");
        }
    }
}
