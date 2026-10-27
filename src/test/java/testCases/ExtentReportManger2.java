package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.devtools.v138.runtime.model.Timestamp;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


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
    public String reportFolerPath;
    public static final String Timestamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-NN_HH-mm=-ss"));

    public void onStart(ITestContext context) {

        String Folderpath= System.getProperty("user.dir")+"./logs/Reports/report_"+Timestamp;

        Path reportFolderpath=Paths.get(Folderpath);
        try {
            Files.createDirectories(reportFolderpath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        reportFolerPath=reportFolerPath+"report.html";
    }

    public void onTestStart(ITestResult result) {
        // not implemented
    }

    public void onTestSuccess(ITestResult result) {
        // not implemented
    }

    public void onTestFailure(ITestResult result) {
        // not implemented
    }


    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    public void onFinish(ITestContext context) {
        // not implemented
    }


}
