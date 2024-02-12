package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    private WebDriver driver;
    public P01_HomePage(WebDriver driver){
        this.driver =driver;
    }
    private  final By signinAndLoginIcon = By.xpath("//a[@href=\"/login\"]");
    private final By logoutButton =By.xpath("//a[@href=\"/logout\"]");
    private final By contactUsButton = By.xpath("//a[@href=\"/contact_us\"]");
    private final By testCasesPageButton =By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a");
    private final By productPageButton = By.xpath("//a[@href=\"/products\"]");
    private final By emailSubscriptionFailed = By.xpath("//input[@type=\"email\"]");
    private final By emailSubmitButton =By.xpath("//button[@type=\"submit\"]");
    private final By succsefullMassage =By.xpath("//div[@class=\"alert-success alert\"]");
    public P02_RegisterAndLoginPage navigateToRegisterAndLoginPage(){
        Utilities.clickingOnElement(driver , signinAndLoginIcon);
        return new P02_RegisterAndLoginPage(driver);
    }
    public void clickOnLogoutButton(){
        Utilities.clickingOnElement(driver,logoutButton);
    }

    public P05_ContactUsFormPage navigateToContactUsFormPage(){
        Utilities.clickingOnElement(driver,contactUsButton);
      return new P05_ContactUsFormPage(driver);
    }
    public P06_TestCasesPage navigateToTestCasesPage(){
        Utilities.clickingOnElement(driver , testCasesPageButton);
        return new P06_TestCasesPage(driver);
    }
    public P07_ProductsPage navigateToProductsPage(){
        Utilities.clickingOnElement(driver,productPageButton);
        return new P07_ProductsPage(driver);
    }
    public P01_HomePage enterEmailSubscription(String email){
        Utilities.sendData(driver,emailSubscriptionFailed,email);
    return this;
    }
    public P01_HomePage submitTheEmailSubsecribtion(){
        Utilities.clickingOnElement(driver ,emailSubmitButton);
        return this;
    }
    public boolean verifyTheSubscription(){
        return driver.findElement(succsefullMassage).isDisplayed();
    }
}
