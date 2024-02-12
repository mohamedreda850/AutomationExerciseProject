package Listenres;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int retryAttempts = 0;
    @Override
    public boolean retry(ITestResult Result) {
        if (Result.getStatus() ==ITestResult.FAILURE){
            retryAttempts++;
            if (retryAttempts == 1){
                System.out.println("first attempt");
                return true;
            }else if(retryAttempts > 1){
                System.out.println("stop");
            }
        }
        return false;
    }
}
