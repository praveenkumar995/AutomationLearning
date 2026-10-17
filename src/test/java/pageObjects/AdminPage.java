package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage
{
    AdminPage(WebDriver driver)
    {
        super(driver);

    }

    By adminicon= By.xpath("//span[text()='Admin']");
    By addbtn=By.xpath("//button[normalize-space()='Add']");
    

}
