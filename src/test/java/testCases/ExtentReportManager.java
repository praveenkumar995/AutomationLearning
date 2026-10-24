package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager  implements ITestListener {


    public ExtentSparkReporter sparkReporter;//UI of the report
    public ExtentReports extentReports;//populate the common info of the report
    public ExtentTest test;//updating the status of the report
    public String reportFilePath;

    private static final String TIMESTAMP = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

    public void onStart(ITestContext context) {
        try {

            String reportFolderPath = System.getProperty("user.dir")+ "/test-output/Reports/Run_" + TIMESTAMP;

            Path reportFolder = Paths.get(reportFolderPath);
            Files.createDirectories(reportFolder);

            String reportFilePath = reportFolderPath + "/report.html";

            System.out.println("Report will be generated at: " + reportFilePath);
        /*System.out.println("Path ="+System.getProperty("user.dir")+"/test-output/Reports.html");
        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"test-output/Reports/report.html");*/
            sparkReporter = new ExtentSparkReporter(reportFilePath);
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Functional testing");
            sparkReporter.config().setTheme(Theme.DARK);

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("computer name", "Windows");
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("Testername", "Praveen");
            extentReports.setSystemInfo("Browser name", "Chrome");
        } catch (IOException e) {
            throw new RuntimeException("Failed to create Extent report folder",e);
        }
    }
    public void onTestSuccess(ITestResult result){

        test=extentReports.createTest(result.getName());
        test.log(Status.PASS,"TestCase is passed is :"+result.getName());

//        TakesScreenshot ts=(TakesScreenshot)OrangeHRM.driver;
//        File src=ts.getScreenshotAs(OutputType.FILE);
//        File des=new File("/target/reports.html");

    }
    public void onTestFailure(ITestResult result){

        test=extentReports.createTest(result.getName());
        test.log(Status.FAIL,"TestCase is failed is :"+result.getName());
        test.log(Status.FAIL,"TestCase is failed is :"+result.getThrowable());

    }
    public void onTestSkipped(ITestResult result){

        test=extentReports.createTest(result.getName());
        test.log(Status.SKIP,"TestCase is skipped is :"+result.getName());
        test.log(Status.SKIP,"TestCase is skipped is :"+result.getThrowable());

    }

    public void onFinish(ITestContext context) {

        extentReports.flush();

    }



}
