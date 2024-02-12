package Listenres;

import Utilities.Utilities;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;

import static DriverManger.DriverManger.getDriver;

public class IInvockedMethodListenresClass implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            try {
                Utilities.tackeScreenshot(getDriver(),result.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
