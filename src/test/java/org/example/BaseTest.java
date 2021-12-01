package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

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
    public void login() throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);
        //atlamak icin yonlendirme yaptık. sonra tekrar bakmalıyız
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi?s=1");
        //email girisi yaptık
        driver.findElement(By.id("L-UserNameField")).sendKeys("selenium_deneme@gmail.com");
        //araya zaman/bekleme koydum yoksa API hatası veriyordu...
        TimeUnit.SECONDS.sleep(5);
        //sifre girisi yaptık ve enterladık
        driver.findElement(By.id("L-PasswordField")).sendKeys("seleniumDeneme1"+ Keys.ENTER);

    }
}
