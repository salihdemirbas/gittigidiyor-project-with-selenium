package org.example;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    //WebDriver driver;
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); //chromedriver yeri
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); //ekrani büyükttük
        driver = new ChromeDriver(options);
        driver.get("https://www.gittigidiyor.com/"); //gideceğimiz adresi verdik..
        TimeUnit.SECONDS.sleep(5);

    }


    @After
    public void cikisYap() throws InterruptedException {

        driver.quit(); //islem sonlandirildi...


    }


}
