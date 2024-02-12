package Tests;

import Listenres.IInvockedMethodListenresClass;
import Listenres.Retry;
import Pages.P01_HomePage;
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

public class T06_ContactUsFormTest {

    String path ="src/main/resources/TestData/ContactUsFormData";
    String photoPath= "C:\\Users\\USER\\OneDrive\\Desktop\\Software Testing\\automation\\selenium\\AutomationExerciseProject\\src\\main\\resources\\src\\cover.png";
    @BeforeMethod
    public void setup(){
        setupDriver();
        getDriver().manage().window().maximize();
        getDriver().get("https://automationexercise.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(retryAnalyzer = Retry.class)
    public void contactUsTest() throws IOException {
        new P01_HomePage(getDriver()).navigateToContactUsFormPage()
                .enterTheName(Utilities.getPropertyValue("Name" , path))
                .enterTheEmail(Utilities.getPropertyValue("Email",path))
                .subject(Utilities.getPropertyValue("Subject" , path))
                .enterTheMassage(Utilities.getPropertyValue("Massage" , path))
                .uploadePhoto(photoPath)
                .supmitTheForm();
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class=\"status alert alert-success\"]")).isDisplayed());
    }

    @AfterMethod
    public void quit(){
        quitDriver();
    }
}
