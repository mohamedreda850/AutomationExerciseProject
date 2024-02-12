package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
public BaseTest(WebDriver driver){
    this.driver = driver;
}
private By copyButton = By.xpath("//button[@id=\"click-to-copy\"]");


public void temporaryEmail(WebDriver driver   ) throws AWTException {

    new WebDriverWait(driver , Duration.ofSeconds(20))
            .until(ExpectedConditions.elementToBeClickable(copyButton));
    driver.findElement(copyButton).click();


}

}
