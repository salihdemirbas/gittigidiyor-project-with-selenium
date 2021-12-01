package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe"); //chromedriver yeri
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); //ekrani büyükttük

        driver = new ChromeDriver(options);
        driver.get("https://www.gittigidiyor.com/"); //gideceğimiz adresi verdik..
    }
    @Test
    public void ilk(){
        System.out.println("deneme");
    }
}
