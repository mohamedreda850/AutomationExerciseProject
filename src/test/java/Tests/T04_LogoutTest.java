package Tests;

import Listenres.IInvockedMethodListenresClass;
import Listenres.Retry;
import Pages.P02_RegisterAndLoginPage;
import Utilities.Utilities;
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

public class T04_LogoutTest {

    String path = "src/main/resources/TestData/ValidLoginData.poroerties";
    @BeforeMethod
    public void setup(){
        setupDriver();
        getDriver().manage().window().maximize();
        getDriver().get("https://automationexercise.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(retryAnalyzer = Retry.class)
    public void logoutTestCase() throws IOException {
        new P02_RegisterAndLoginPage(getDriver()).loginSteps(Utilities.getPropertyValue("email",path)
                ,Utilities.getPropertyValue("password",path)).clickOnLogoutButton();
        Assert.assertEquals(getDriver().getCurrentUrl() , "https://automationexercise.com/login");
    }
    @AfterMethod
    public void quit(){
        quitDriver();
    }
}
