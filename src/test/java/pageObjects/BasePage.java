package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BasePage
{
    WebDriver driver;

    BasePage(WebDriver driver)
    {
        this.driver=driver;

    }

//    @BeforeSuite
//    void setup() {
//        System.out.println("BaseClass opened the application");
//        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//    }
//
//   @AfterSuite
//    void tearDown()
//    {
//       // driver.quit();
//    }
}
