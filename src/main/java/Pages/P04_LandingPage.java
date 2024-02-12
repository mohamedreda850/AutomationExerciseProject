package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_LandingPage {
    private WebDriver driver;
    public P04_LandingPage(WebDriver driver){
        this.driver = driver;
    }
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public P01_HomePage clickOnContinueButton(){
        Utilities.clickingOnElement(driver,continueButton);
        return new P01_HomePage(driver);
    }
}
