package Pages;

import Utilities.Utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P05_ContactUsFormPage {
    private WebDriver driver ;
    public P05_ContactUsFormPage (WebDriver driver){
        this.driver = driver;
    }
    private By nameFaild =By.xpath("//input[@data-qa=\"name\"]");
    private By emailFaild = By.xpath("//input[@data-qa=\"email\"]");
    private By subjectFaild = By.xpath("//input[@data-qa=\"subject\"]");
    private By yourMassageFaild = By.xpath("//textarea[@data-qa=\"message\"]");
    private By uploader = By.xpath("//input[@name=\"upload_file\"]");
    private By submitButton = By.xpath("//input[@data-qa=\"submit-button\"]");
    public P05_ContactUsFormPage enterTheName(String name){
        Utilities.sendData(driver , nameFaild ,name);
        return this;
    }
    public P05_ContactUsFormPage enterTheEmail(String email){
        Utilities.sendData(driver , emailFaild , email);
        return this;
    }
    public P05_ContactUsFormPage subject(String theSubject){
        Utilities.sendData(driver , subjectFaild , theSubject);
        return this;
    }
    public P05_ContactUsFormPage enterTheMassage(String theMassage){
        Utilities.sendData(driver , yourMassageFaild , theMassage);
        return this;
    }
    public P05_ContactUsFormPage uploadePhoto(String path){
        driver.findElement(uploader).sendKeys(path);
        return this;
    }
    public P05_ContactUsFormPage supmitTheForm(){
        Utilities.clickingOnElement(driver,submitButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
}
