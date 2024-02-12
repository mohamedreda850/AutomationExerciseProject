package Tests;

import Listenres.IInvockedMethodListenresClass;
import Listenres.Retry;
import Pages.P01_HomePage;
import Pages.P02_RegisterAndLoginPage;
import Utilities.Utilities;
import org.openqa.selenium.By;
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

public class T05_RegisterUserWithExixtingEmail {

    String path = "src/main/resources/TestData/SignUpWithExistingEmail";
    @BeforeMethod
    public void setup(){
        setupDriver();
        getDriver().manage().window().maximize();
        getDriver().get("https://automationexercise.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(retryAnalyzer = Retry.class)
    public void registerWitheExisitingEmail() throws IOException {
        new P01_HomePage(getDriver()).navigateToRegisterAndLoginPage().enterUserName(Utilities.getPropertyValue("name" ,path))
                .enterExistingEmailAddress(Utilities.getPropertyValue("email",path)).clickOnSignupButton();
        Assert.assertTrue(getDriver().findElement(By.xpath("//p[@style]")).isDisplayed());
    }

    @AfterMethod
    public void quit(){
        quitDriver();
    }
}
