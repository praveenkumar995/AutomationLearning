package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationLoginPage extends BasePage
{
    public ApplicationLoginPage(WebDriver driver)
    {
        super(driver);
    }

    By text_username = By.xpath("//input[@name='username']");
    By text_password = By.xpath("//input[@type='password']");
    By login_btn = By.xpath("//button[@type='submit']");

    By clickbutton= By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    By logout=By.xpath("//a[text()='Logout']");

    public void setText_username(String username)
    {
        driver.findElement(text_username).sendKeys(username);
    }
    public void setText_password(String pwd)
    {
        driver.findElement(text_password).sendKeys(pwd);
    }
    public void setLogin_btn()
    {
        driver.findElement(login_btn).click();
    }

    public void setClickbutton() {

        driver.findElement(clickbutton).click();
    }
    public void setLogout()
    {
        driver.findElement(logout).click();
    }
}
