package Tests;

import BaseTest.BaseTest;
import DriverManger.DriverManger;
import Listenres.IInvockedMethodListenresClass;
import Listenres.Retry;
import Pages.P01_HomePage;
import Utilities.Utilities;
import com.sun.net.httpserver.Authenticator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static DriverManger.DriverManger.*;
@Listeners(IInvockedMethodListenresClass.class)
public class T01_RegisterTest {

    String path = "src/main/resources/TestData/RegisterData";

    @BeforeClass
    public void getingTheEmail() throws AWTException {
        setupDriver();
        getDriver().get("https://temp-mail.org/");
        new BaseTest(getDriver()).temporaryEmail(getDriver());
        getDriver().quit();
    }
    @BeforeMethod
    public void setup(){
        setupDriver();
        getDriver().manage().window().maximize();
        getDriver().get("https://automationexercise.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test(retryAnalyzer = Retry.class)
    public void register() throws IOException {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        new P01_HomePage(getDriver()).navigateToRegisterAndLoginPage()
                .enterUserName(Utilities.getPropertyValue("username",path))
                .enterEmailAddress().navigateToSignUpPage()
                .clickOnTitleMR_MRS().fillPassword(Utilities.getPropertyValue("password",path))
                .chooseBirthDay(Utilities.getPropertyValue("birthDay",path))
                .chooseBirthMonth(Utilities.getPropertyValue("birthMonth",path))
                .chooseBirthYear(Utilities.getPropertyValue("birthYear",path))
                .ClickOnNewsletter().ClickOnSpecialOffers().fillFirstName(Utilities.getPropertyValue("firstName",path))
                .fillLastName(Utilities.getPropertyValue("lastname",path))
                .fillCompanyName(Utilities.getPropertyValue("companyName",path))
                .fillAddress(Utilities.getPropertyValue("address",path))
                .chooseCountry(Utilities.getPropertyValue("country",path))
                .fillStateName(Utilities.getPropertyValue("stateName",path))
                .fillCityName(Utilities.getPropertyValue("cityName",path))
                .fillZipcode(Utilities.getPropertyValue("zipCode",path))
                .fillMopileNumber(Utilities.getPropertyValue("mobileNumber",path))
                .ClickOnCreateAccount().clickOnContinueButton();
       // Utilities.tackeScreenshot(driver, );
        Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href=\"/logout\"]")).isDisplayed());
    }
    @AfterMethod
    public void quit(){
        quitDriver();
    }
}
