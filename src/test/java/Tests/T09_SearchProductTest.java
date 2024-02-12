package Tests;

import Listenres.IInvockedMethodListenresClass;
import Listenres.Retry;
import Pages.P01_HomePage;
import Utilities.Utilities;
import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverManger.DriverManger.*;
@Listeners(IInvockedMethodListenresClass.class)

public class T09_SearchProductTest {

    String path ="src/main/resources/TestData/SearchProductData";
    @BeforeMethod
    public void setup(){
        setupDriver();
        getDriver().manage().window().maximize();
        getDriver().get("https://automationexercise.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(retryAnalyzer = Retry.class)
    public void searchProductTest() throws IOException {
       Assert.assertTrue( new P01_HomePage(getDriver()).navigateToProductsPage()
                .sendItemToSearchFor(Utilities.getPropertyValue("searchItem",path))
                .clickOnSearchIcon().isItemDesplayed());

    }

    @AfterMethod
    public void quit(){
        quitDriver();
    }

}
