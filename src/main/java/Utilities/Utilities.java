package Utilities;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Utilities {
    private static final String screenshotsPath ="C:\\Users\\USER\\OneDrive\\Desktop\\Software Testing\\automation\\selenium\\AutomationExerciseProject\\src\\main\\resources\\screenshots";
    public static void clickingOnElement(WebDriver driver, By locator){
        new WebDriverWait(driver , Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    public static void sendData(WebDriver driver, By locator,String data){
        new WebDriverWait(driver , Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);

    }
public static void chooseFromDropDown(WebDriver driver , By dropDownName ,String value){
    Select select =new Select(driver.findElement(dropDownName));
    select.selectByVisibleText(value);
}
public static void pastTheEmail(WebDriver driver ,By locator){
    new WebDriverWait(driver , Duration.ofSeconds(20))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    driver.findElement(locator).sendKeys(Keys.CONTROL +"v");
}
    public static String getPropertyValue(String key ,String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        return properties.getProperty(key);
    }
    public static void tackeScreenshot(WebDriver driver,String  name) throws IOException {
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        File finalScreenShot = new File(screenshotsPath+name+getTimestamp()+".png");
        ImageIO.write(screenshot.getImage(),"png",finalScreenShot);
        Allure.addAttachment(name , Files.newInputStream(Path.of(finalScreenShot.getPath())));
    }
    public static String getTimestamp(){
        return new SimpleDateFormat("yyyy-mm-dd_h-m-ss a").format(new Date());
    }
}
