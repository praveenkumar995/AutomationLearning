package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.devtools.v138.runtime.model.Timestamp;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.awt.event.TextEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManger2 implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports reports;
    public ExtentTest test;

    public String reportFilePath;

    public static final String TIMESTAMP= LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD-HH-MM-SS"));
    public void onStart(ITestContext context) {

        String FolderPath=System.getProperty("User.dir")+"./test-output/Reports/Run_"+TIMESTAMP;

       Path Filepath=Paths.get(FolderPath);
        try {
            Files.createDirectories(Filepath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        reportFilePath=reportFilePath+"/reports.html";
        sparkReporter=new ExtentSparkReporter(reportFilePath);

        sparkReporter.config().setDocumentTitle("Automtion Testing");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        reports=new ExtentReports();
        reports.attachReporter(sparkReporter);

        reports.setSystemInfo("Name","value");
        reports.setSystemInfo("os","windows");
        reports.setSystemInfo("browser","Chrome");
        reports.setSystemInfo("Tester","Praveen");


    }

    public void onTestSuccess(ITestResult result) {

        test=reports.createTest(result.getName());
        test.log(Status.PASS,"TestCase is paased"+result.getName());

    }

    public void onTestFailure(ITestResult result) {

        test=reports.createTest(result.getName());
        test.log(Status.FAIL,"Testcase is failed"+result.getName());
        test.log(Status.FAIL,"Testcase is failed"+result.getThrowable());

    }


    public void onTestSkipped(ITestResult result) {

        test=reports.createTest(result.getName());
        test.log(Status.SKIP,"Testcase is skipped"+result.getName());
        test.log(Status.SKIP,"Testcase is skipped"+result.getThrowable());

    }

    public void onFinish(ITestContext context) {

        reports.flush();
    }


}
