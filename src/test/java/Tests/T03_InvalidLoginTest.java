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

public class T03_InvalidLoginTest {


    String path = "src/main/resources/TestData/InvalidLoginData.poroerties";
    @BeforeMethod
    public void setup(){
        setupDriver();
        getDriver().manage().window().maximize();
        getDriver().get("https://automationexercise.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(retryAnalyzer = Retry.class)
    public void invalidLogin() throws IOException {
        new P01_HomePage(getDriver()).navigateToRegisterAndLoginPage()
                .enterLoginEmailAddress(Utilities.getPropertyValue("email",path))
                .enterLoginPassword(Utilities.getPropertyValue("password",path))
                .clickOnLoginButtonForInvalidLogin();
      Assert.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).isDisplayed());
    }
    @AfterMethod
    public void quit(){
        quitDriver();
    }
}
