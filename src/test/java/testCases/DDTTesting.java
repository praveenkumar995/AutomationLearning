package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ApplicationLoginPage;
import pageObjects.HomePage;
import utilities.DataProviders;

public class DDTTesting extends BaseClass
{

    @Test(dataProvider="LoginData",dataProviderClass= DataProviders.class)
    public void verify_loginDDT(String username, String password, String result) {
        logger.info("**** Starting TC_003_LoginDDT *****");

        try {

            ApplicationLoginPage ap = new ApplicationLoginPage(driver);
            ap.setText_username(username);
            ap.setText_password(password);
            ap.setClickbutton();

            //My Account Page
            HomePage hm = new HomePage(driver);
            boolean targetPage = hm.setDashboard();

            if (result.equalsIgnoreCase("Valid")) {
                if (targetPage==true) {
                   // ap.se();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (result.equalsIgnoreCase("Invalid")) {
                if (targetPage) {
                    ap.setLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail("An exception occurred: " + e.getMessage());
        }

        logger.info("**** Finished TC_003_LoginDDT *****");

    }
}
