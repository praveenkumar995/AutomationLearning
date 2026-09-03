package testCases;

import org.testng.annotations.Test;
import pageObjects.ApplicationLoginPage;
import pageObjects.HomePage;

public class TC002 extends BaseClass
{

    @Test
    public void ApplicationHomePage() throws InterruptedException
    {
        logger.info("started running TC002....");

        HomePage hm=new HomePage(driver);
        logger.info("OrangeHRM image validation on the homepage....");
        hm.setImg();
        logger.info("completed the TC002 execution successfully.........");

    }
}
