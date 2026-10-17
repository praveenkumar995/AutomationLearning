package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage extends ApplicationLoginPage {
    private Object val;

    public PIMPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver,this);
    }

    By P = By.xpath("//span[text()='PIM']");
    By addtbn = By.xpath("(//button[@type='button'])[5]");
    By firstname = By.xpath("//input[@name='firstName']");
    By lastneme = By.xpath("//input[@name='lastName']");
    By empid = By.xpath("//input[contains(@class,'oxd-input')]");
    By savebtn = By.xpath("//button[@type='submit']");
    By otherid=By.xpath("//label[text()='Other Id']/following::input[1]");
    By driving_Lcn = By.xpath("//label[normalize-space()='Other Id']/parent::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input");
//    By driving_Lcn = By.xpath("//label[normalize-space()='Other Id']/parent::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input");
    //By lcns_expiry = By.xpath("(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[1]");
    By nationalty = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    By Maritalstatus = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
    By DOB = By.xpath("(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[2]");
    By geneder = By.xpath("//label[normalize-space()='Male']");
    By clik_save = By.xpath("(//button[@type='submit'])[1]");

    public void PIMmethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // driver.findElement(P)
        WebElement pim =wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(P)));
        // store the webelement variable and then move to that element
        Actions actions = new Actions(driver);
        actions.moveToElement(pim).click().perform();
    }

    public void setAddtbn() {
        driver.findElement(addtbn).click();
    }

    public void setFirstname(String Fname) {
        driver.findElement(lastneme).sendKeys(Fname);
    }

    public void setLastneme(String Lname) {
        driver.findElement(firstname).sendKeys(Lname);
    }

    public void setEmpid(String ed) {
        driver.findElement(empid).sendKeys(ed);
    }

    public void setSavebtn() {
        WebElement save = driver.findElement(savebtn);

        Actions act = new Actions(driver);
        act.moveToElement(save).click().perform();
    }

    public void setOtherid(String o_id)
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement others_id = wait.until(ExpectedConditions.visibilityOfElementLocated(otherid));
        others_id.clear();
        others_id.sendKeys(o_id);

    }
    public void setDriving_Lcn(String licence_number) {
       // driver.findElement(driving_Lcn).sendKeys(licence_number);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement licnNum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Other Id']/parent::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input")));
        WebElement licenseField = driver.findElement(driving_Lcn);
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].value = arguments[1];", licenseField, licence_number);

//        licenseField.clear();
//        licenseField.sendKeys(licence_number);
    }

//    public void setLcns_expiry(String LIC_expiry) {
//        driver.findElement(lcns_expiry).sendKeys(LIC_expiry);
//    }

    public void setNationalty()
    {
       WebElement value= driver.findElement(nationalty);
       Select sel=new Select(value);
       sel.selectByIndex(1);

    }

    public void setMaritalstatus(String maritalstatus) {
        driver.findElement(Maritalstatus).sendKeys(maritalstatus);
    }

    public void setDOB(String dob) {
        driver.findElement(DOB).sendKeys(dob);
    }

    public void setGeneder()
    {
        driver.findElement(geneder).click();
    }
    public void setSavebtton()
    {
        driver.findElement(clik_save).click();
    }

}
