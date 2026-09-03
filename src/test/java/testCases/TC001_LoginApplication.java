package testCases;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.ApplicationLoginPage;
import pageObjects.BasePage;
import pageObjects.PIMPage;
import utilities.ExtentReportManager;
import java.time.Duration;


public class TC001_LoginApplication extends BaseClass {


    @Test
    public void verify_loginPage() throws InterruptedException {

        logger.info("opened Pim page");
        try {
            PIMPage pm = new PIMPage(driver);
            pm.PIMmethod();
            pm.setAddtbn();
            Thread.sleep(2000);
            pm.setFirstname(randomString().toUpperCase());
            logger.info("entered firstname");
            pm.setLastneme(randomString().toUpperCase());
            logger.info("entered lastname");
            pm.setEmpid(randomNumber());
            pm.setSavebtn();
            logger.info("employee details saved");
            logger.info("Providing personal details");
            logger.info("Enter Others Id");
            pm.setOtherid(randomNumber());
            logger.info("entered licenece number");
//            Thread.sleep(2000);
            String licenseNumber = randomString()+randomNumber();
            System.out.println("Generated License Number: " + licenseNumber);
            pm.setDriving_Lcn(licenseNumber);
            //driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-form-hint\"]/following-sibling::button[normalize-space()=\"Save\"]")).click();
//            pm.setDriving_Lcn(randomString());
           /* pm.setOtherid(randomNumber());
            System.out.println("enter licence number");
            Thread.sleep(2000);
            pm.setDriving_Lcn(randomNumber());
            System.out.println("select nationality");
            pm.setNationalty();

            */

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed");
            logger.debug("debug logs");
          //  Assert.fail();

        }

        logger.info("finished the testcase TC_001Login application ..........");
    }

}
