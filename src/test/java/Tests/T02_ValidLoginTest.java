package Tests;

import Listenres.IInvockedMethodListenresClass;
import Listenres.Retry;
import Pages.P01_HomePage;
import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class T02_ValidLoginTest {

    String path = "src/main/resources/TestData/ValidLoginData.poroerties";
    @BeforeMethod
    public void setup(){
        setupDriver();
        getDriver().manage().window().maximize();
        getDriver().get("https://automationexercise.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(retryAnalyzer = Retry.class)
    public void validLogin() throws IOException {
        new P01_HomePage(getDriver()).navigateToRegisterAndLoginPage()
                .enterLoginEmailAddress(Utilities.getPropertyValue("email",path))
                .enterLoginPassword(Utilities.getPropertyValue("password",path)).clickOnLoginButton();
        Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href=\"/logout\"]")).isDisplayed());
    }
    @AfterMethod
    public void quit(){
        quitDriver();
    }
}
