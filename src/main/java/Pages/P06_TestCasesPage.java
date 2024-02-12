package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_TestCasesPage {
    private WebDriver driver;
    public P06_TestCasesPage(WebDriver driver){
        this.driver=driver;
    }
    private By textElementToVerify = By.xpath("//span[@style=\"color: red;\"]");

    public Boolean verifyTheText(){
        return driver.findElement(textElementToVerify).isDisplayed();
    }

}
