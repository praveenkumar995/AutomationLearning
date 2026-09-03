package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReportManager implements ITestListener
{

    WebDriver driver;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest test;

    public void onStart(ITestContext context) {


        System.out.println("Path ="+System.getProperty("user.dir")+"reports.html");
        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/repo.png");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports=new ExtentReports();
        extentReports.setSystemInfo("computer name","Windows");
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser name","Chrome");

    }
    public void onTestSuccess(ITestResult result){

//        test=extentReports.createTest(result.getName());
//        test.log(Status.PASS,"TestCase is passed is :"+result.getName());

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File des=new File("reports.html");

    }
    public void onTestFailure(ITestResult result){

        test=extentReports.createTest(result.getName());
        test.log(Status.PASS,"TestCase is failed is :"+result.getName());
        test.log(Status.PASS,"TestCase is failed is :"+result.getThrowable());


    }
    public void onTestSkipped(ITestResult result){

        test=extentReports.createTest(result.getName());
        test.log(Status.PASS,"TestCase is skipped is :"+result.getName());
        test.log(Status.PASS,"TestCase is skipped is :"+result.getThrowable());

    }

    public void onFinish(ITestContext context) {

        extentReports.flush();
    }
}
