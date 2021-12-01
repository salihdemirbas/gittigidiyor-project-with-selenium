package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
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
    @Test
    public void search() throws InterruptedException {
        //search olarak searchBox'a bilgisayar yazdırıldı ve enterladık...
        login();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("input[data-cy='header-search-input']")).sendKeys("bilgisayar" + Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollBy(0,)", "");
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // sayfanın altına indi
    }
    //-------------------------------------------------------------------------
    //--------------FAVORİLERE EKLEME ATLANDI, TEKRAR BAK  --------------------
   /* @Test

    public void addFavorite() throws InterruptedException {
        login();
        search();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("input[data-cy='product-favorite']")).click();
    }*/

    @Test
    public void anaSayfayaDon() throws InterruptedException {
        search();
        TimeUnit.SECONDS.sleep(3);
        driver.navigate().to("https://www.gittigidiyor.com/");
    }
    @Test
    public void cantaArat() throws InterruptedException {
        anaSayfayaDon();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("input[data-cy='header-search-input']")).sendKeys("çanta" + Keys.ENTER);
        TimeUnit.SECONDS.sleep(3);

    }
    @Test
    public void goToCart() throws InterruptedException {
        cantaArat();
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-(document.body.scrollHeight)"); // sayfanın altına indi
       */ driver.findElement(By.className("gekhq4-4 fWiwPC")).click();


    }
}
