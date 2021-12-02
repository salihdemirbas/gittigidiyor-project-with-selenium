package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SepetiDuzenlePage extends BasePage{
    public SepetiDuzenlePage(WebDriver driver) {
        super(driver);
    }
    public void sepetiDuzenle() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // sayfanın altına indi
        zaman();
        driver.findElement(By.cssSelector("a[title='Sepeti Düzenle']")).click();
        js.executeScript("window.scrollTo(0,400)");
        driver.findElements(By.cssSelector("a[class='gg-ui-btn-default btn-add-to-basket']")).get(4).click();
        zaman();
        js.executeScript("window.scrollTo(0,400)");
        driver.findElements(By.cssSelector("i[class='gg-icon gg-icon-close']")).get(2).click();
    }
}
