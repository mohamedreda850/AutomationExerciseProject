package DriverManger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManger {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>() ;
    public static void setupDriver (){
        driverThreadLocal.set(new ChromeDriver());
    }
    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public static void quitDriver(){
        getDriver().quit();
        driverThreadLocal.remove();
    }
}
