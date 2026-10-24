package testCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner  implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("********* onStart method is executed *********  ");
    }

    public void onTestStart(ITestResult result) {

        System.out.println(" ********* on Teststart method is executed ********* ");
    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("*********  on onTestSuccess method is executed ********* ");
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("*********  on onTestFailure method is executed ********* ");
    }
    public void onTestSkipped(ITestResult result) {

        System.out.println(" ********* on onTestSkipped method is executed ********* ");
    }
    public void onFinish(ITestContext context) {

        System.out.println(" ********* onFinish method is executed ********* ");
    }


}
