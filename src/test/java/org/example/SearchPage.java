package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void search() throws InterruptedException {

        zaman();
        driver.findElement(By.cssSelector("input[data-cy='header-search-input']")).sendKeys("bilgisayar" + Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // sayfanın altına indi
        zaman();
        driver.findElements(By.cssSelector("div[class='sc-1n49x8z-14 fIkZfb']")).get(0).click();
        zaman();
        js.executeScript("window.scrollTo(0,350)");
        driver.findElements(By.cssSelector("div[class='sc-1n49x8z-14 fIkZfb']")).get(1).click();
        zaman();
        js.executeScript("window.scrollTo(0,350)");
        driver.findElements(By.cssSelector("div[class='sc-1n49x8z-14 fIkZfb']")).get(2).click();
        zaman();
        js.executeScript("window.scrollTo(0,350)");
        driver.findElements(By.cssSelector("div[class='sc-1n49x8z-14 fIkZfb']")).get(3).click();
        zaman();
    }
}
