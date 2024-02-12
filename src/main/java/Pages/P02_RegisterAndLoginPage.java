package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_RegisterAndLoginPage {
    private WebDriver driver;
    public P02_RegisterAndLoginPage(WebDriver driver){
        this.driver=driver;
    }
    private final By nameFaild= By.xpath("//input[@type=\"text\"]");
    private final By emailAddres = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signupButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By loginEmailAddress = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    private final By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");


    public P02_RegisterAndLoginPage enterUserName (String userName){
        Utilities.sendData(driver , nameFaild , userName);
        return this;
    }
    public P02_RegisterAndLoginPage enterExistingEmailAddress(String emailAddress){
        Utilities.sendData(driver , emailAddres ,emailAddress );
        return new P02_RegisterAndLoginPage(driver);
    }
    public P02_RegisterAndLoginPage enterEmailAddress (){
        Utilities.pastTheEmail(driver ,emailAddres );
        return this;
    }
    public P03_SignUpPage navigateToSignUpPage(){
        Utilities.clickingOnElement(driver , signupButton);
        return new P03_SignUpPage(driver);
    }
    public P02_RegisterAndLoginPage clickOnSignupButton(){
        Utilities.clickingOnElement(driver , signupButton);
        return this;
    }

    public P02_RegisterAndLoginPage enterLoginEmailAddress(String emailAddress){
        Utilities.sendData(driver , loginEmailAddress ,emailAddress );
        return new P02_RegisterAndLoginPage(driver);
    }
    public P02_RegisterAndLoginPage enterLoginPassword(String password){
        Utilities.sendData(driver , loginPassword , password);
        return new P02_RegisterAndLoginPage(driver);
    }
    public P01_HomePage clickOnLoginButton(){
        Utilities.clickingOnElement(driver , loginButton);
        return new P01_HomePage(driver);
    }
    public P02_RegisterAndLoginPage clickOnLoginButtonForInvalidLogin(){
        Utilities.clickingOnElement(driver , loginButton);
        return new P02_RegisterAndLoginPage(driver);
    }
    public P01_HomePage loginSteps(String email , String password){

        return  new P01_HomePage(driver).navigateToRegisterAndLoginPage().enterLoginEmailAddress(email).enterLoginPassword(password).clickOnLoginButton();
    }
}
