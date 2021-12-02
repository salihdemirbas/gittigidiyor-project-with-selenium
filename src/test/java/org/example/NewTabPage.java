package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NewTabPage extends BasePage{
    public NewTabPage(WebDriver driver) {
        super(driver);
    }
    public void yeniSekme() throws InterruptedException {
        zaman();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");
        zaman();
        driver.get("https://www.gittigidiyor.com/cikis-yap");
        driver.switchTo().window(tabs.get(0));
        driver.close();// sekme kapatıldı
        zaman();
    }
}
