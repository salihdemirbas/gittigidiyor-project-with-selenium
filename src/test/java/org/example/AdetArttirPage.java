package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AdetArttirPage extends BasePage{

    public AdetArttirPage(WebDriver driver) {
        super(driver);
    }
    public void adetArttir() throws InterruptedException {
        driver.findElement(By.cssSelector("select[class='amount']")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("option[value='2']")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("input[value='Alışverişi Tamamla']")).click();
        TimeUnit.SECONDS.sleep(2);
    }
}
