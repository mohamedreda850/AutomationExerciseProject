package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P07_ProductsPage {

    private WebDriver driver;
    public P07_ProductsPage(WebDriver driver){
        this.driver=driver;
    }
    private final By searchBar = By.xpath("//input[@id=\"search_product\"]");
    private final By searchIcon = By.xpath("//button[@id=\"submit_search\"]");

    public boolean checkAllElements(){
        List<WebElement> productsElements = driver.findElements(By.cssSelector("div.col-sm-4 div.product-image-wrapper"));
        for (WebElement productsElement :productsElements){
            if (!productsElement.isDisplayed()){
                return true;
            }
        }
        return true;
    }

    public P07_ProductsPage sendItemToSearchFor(String searchData){
        Utilities.sendData(driver,searchBar,searchData);
        return this;
    }
    public P07_ProductsPage clickOnSearchIcon(){
        Utilities.clickingOnElement(driver ,searchIcon);
        return this;
    }
    public boolean isItemDesplayed(){
        return driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/p")).isDisplayed();
    }


}
