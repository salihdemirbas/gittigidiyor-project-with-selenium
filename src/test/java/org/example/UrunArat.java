package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class UrunArat extends BasePage{

    public UrunArat(WebDriver driver) {
        super(driver);
    }

    public void cantaArat() throws InterruptedException {
        zaman();
        driver.findElement(By.cssSelector("input[data-cy='header-search-input']")).sendKeys("çanta" + Keys.ENTER);
        driver.findElements(By.cssSelector("div[class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl']")).get(4).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,400)");
        zaman();
        driver.findElement(By.id("add-to-basket")).click();
        zaman();
        driver.navigate().to("https://www.gittigidiyor.com/sepetim");
        zaman();
    }
}
