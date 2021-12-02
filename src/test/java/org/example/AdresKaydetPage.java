package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AdresKaydetPage extends BasePage{
    public AdresKaydetPage(WebDriver driver) {
        super(driver);
    }
    public void adresKaydet() throws InterruptedException {
        driver.findElement(By.cssSelector("button[value='Kaydet']")).click();
        TimeUnit.SECONDS.sleep(2);
    }
}
