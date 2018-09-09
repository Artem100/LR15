package tests;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ITestListener extends TestListenerAdapter {

    public void onTestSuccess(ITestResult tr){
        System.out.println("Test passed");
    }

    public void onTestFailure(ITestResult tr){
        System.out.println("Test failed");
    }

}
