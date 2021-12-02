package org.example;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ReturnToHomePage extends BasePage {
    public ReturnToHomePage(WebDriver driver) {
        super(driver);
    }
    public void anaSayfayaDon() throws InterruptedException {
        zaman();
        driver.navigate().to("https://www.gittigidiyor.com/");
    }
}
