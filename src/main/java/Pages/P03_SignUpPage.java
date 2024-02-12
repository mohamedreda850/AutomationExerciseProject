package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_SignUpPage {
    WebDriver driver;
    public P03_SignUpPage(WebDriver driver){
        this.driver = driver;
    }
    private By titleButton = By.xpath("//input[@id=\"id_gender1\"]");
    private  By passwordFeild = By.xpath("//input[@type=\"password\"]");
    private By dayDropDown = By.xpath("//select[@data-qa=\"days\"]");
    private By monthDropDown = By.xpath("//select[@data-qa=\"months\"]");
    private By yearDropDown = By.xpath("//select[@data-qa=\"years\"]");
    private By newsletterCheckBox = By.xpath("//input[@name=\"newsletter\"]");
    private By spicialOffersCheckBox = By.xpath("//input[@name=\"optin\"]");
    private By firstNameField = By.xpath("//input[@data-qa=\"first_name\"]");
    private By lastNameField = By.xpath("//input[@data-qa=\"last_name\"]");
    private By companyNameField = By.xpath("//input[@data-qa=\"company\"]");
    private By addressField = By.xpath("//input[@data-qa=\"address\"]");
    private By countryDropDown = By.xpath("//select[@data-qa=\"country\"]");
    private By stateField = By.xpath("//input[@data-qa=\"state\"]");
    private By cityField = By.xpath("//input[@data-qa=\"city\"]");
    private By zipcodeField = By.xpath("//input[@data-qa=\"zipcode\"]");
    private By mobileNumberField = By.xpath("//input[@data-qa=\"mobile_number\"]");
    private By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    public P03_SignUpPage clickOnTitleMR_MRS(){
        Utilities.clickingOnElement(driver,titleButton);
        return this;
    }
    public P03_SignUpPage fillPassword(String password){
        Utilities.sendData(driver,passwordFeild,password);
        return this;
    }
    public P03_SignUpPage chooseBirthDay(String dayValue){
        Utilities.chooseFromDropDown(driver,dayDropDown,dayValue);
        return this;
    }
    public P03_SignUpPage chooseBirthMonth(String monthValue){
        Utilities.chooseFromDropDown(driver,monthDropDown,monthValue);
        return this;
    }
    public P03_SignUpPage chooseBirthYear(String yearValue){
        Utilities.chooseFromDropDown(driver,yearDropDown,yearValue);
        return this;
    }
    public P03_SignUpPage ClickOnNewsletter(){
        Utilities.clickingOnElement(driver,newsletterCheckBox);
        return this;
    }
    public P03_SignUpPage ClickOnSpecialOffers(){
        Utilities.clickingOnElement(driver,spicialOffersCheckBox);
        return this;
    }
    public P03_SignUpPage fillFirstName(String firstName){
        Utilities.sendData(driver,firstNameField,firstName);
        return this;
    }
    public P03_SignUpPage fillLastName(String lasttName){
        Utilities.sendData(driver,lastNameField,lasttName);
        return this;
    }
    public P03_SignUpPage fillCompanyName(String companyName){
        Utilities.sendData(driver,companyNameField,companyName);
        return this;
    }
    public P03_SignUpPage fillAddress(String address){
        Utilities.sendData(driver,addressField,address);
        return this;
    }
    public P03_SignUpPage chooseCountry(String countryName){
        Utilities.chooseFromDropDown(driver,countryDropDown,countryName);
        return this;
    }
    public P03_SignUpPage fillStateName(String stateName){
        Utilities.sendData(driver,stateField,stateName);
        return this;
    }
    public P03_SignUpPage fillCityName(String cityName){
        Utilities.sendData(driver,cityField,cityName);
        return this;
    }
    public P03_SignUpPage fillZipcode(String zipcode){
        Utilities.sendData(driver,zipcodeField,zipcode);
        return this;
    }
    public P03_SignUpPage fillMopileNumber(String mobileNumber){
        Utilities.sendData(driver,mobileNumberField,mobileNumber);
        return this;
    }
    public P04_LandingPage ClickOnCreateAccount(){
        Utilities.clickingOnElement(driver,createAccountButton);
        return new P04_LandingPage(driver);
    }
}
