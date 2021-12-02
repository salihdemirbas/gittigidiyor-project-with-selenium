package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class BasePage extends BaseTest {

    WebDriver driver;

    public WebElement findElement(By by){

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public WebElement find(By locator){

        return driver.findElement(locator);
    }

    public BasePage(WebDriver driver){
        this.driver=driver;
    }
    public void zaman() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }




}
