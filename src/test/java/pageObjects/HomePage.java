package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By img = By.xpath("//div[@class=\"oxd-brand-banner\"]/img[@alt=\"client brand banner\"]");
    By Dashboard = By.xpath("//h6[text()='Dashboard']");


    public boolean setDashboard() {

        boolean status = driver.findElement(Dashboard).isDisplayed();

        try {
            Assert.assertSame(status, true);
        } catch (Exception e) {
            Assert.fail();
        }
        return false;
    }

    public void setImg() {
        System.out.println("Entered in the image validation method");
        String value = driver.findElement(img).getAttribute("src");
        System.out.println(value);
        assert value != null;
        if (value.equals("OrangeHRM")) {
            System.out.println("Orange HRM image is displayed....");

        } else {
            System.out.println("In HomePage,Orange HRM image is not displayed....");
        }

    }


}
