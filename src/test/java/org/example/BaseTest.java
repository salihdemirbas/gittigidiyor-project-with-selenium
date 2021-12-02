package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); //chromedriver yeri
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); //ekrani büyükttük
        driver = new ChromeDriver(options);
        driver.get("https://www.gittigidiyor.com/"); //gideceğimiz adresi verdik..
    }

    @Test
    public void login() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        //atlamak icin yonlendirme yaptık. sonra tekrar bakmalıyız
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi?s=1");
        driver.findElement(By.id("L-UserNameField")).sendKeys("selenium_deneme@gmail.com");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("L-PasswordField")).sendKeys("seleniumDeneme1" + Keys.ENTER);
    }
    @Test
    public void search() throws InterruptedException {
        login();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("input[data-cy='header-search-input']")).sendKeys("bilgisayar" + Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // sayfanın altına indi
        TimeUnit.SECONDS.sleep(1);
        driver.findElements(By.cssSelector("div[class='sc-1n49x8z-14 fIkZfb']")).get(0).click();
        TimeUnit.SECONDS.sleep(1);
        js.executeScript("window.scrollTo(0,350)");
        driver.findElements(By.cssSelector("div[class='sc-1n49x8z-14 fIkZfb']")).get(1).click();
        TimeUnit.SECONDS.sleep(1);
        js.executeScript("window.scrollTo(0,350)");
        driver.findElements(By.cssSelector("div[class='sc-1n49x8z-14 fIkZfb']")).get(2).click();
        TimeUnit.SECONDS.sleep(1);
        js.executeScript("window.scrollTo(0,350)");
        driver.findElements(By.cssSelector("div[class='sc-1n49x8z-14 fIkZfb']")).get(3).click();
        TimeUnit.SECONDS.sleep(1);

    }
   @Test
    public void anaSayfayaDon() throws InterruptedException {
        search();
        TimeUnit.SECONDS.sleep(3);
        driver.navigate().to("https://www.gittigidiyor.com/");
    }
    @Test
    public void cantaArat() throws InterruptedException {
        anaSayfayaDon();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("input[data-cy='header-search-input']")).sendKeys("çanta" + Keys.ENTER);
        driver.findElements(By.cssSelector("div[class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl']")).get(4).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,400)");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("add-to-basket")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void goToCart() throws InterruptedException {
        cantaArat();
        driver.navigate().to("https://www.gittigidiyor.com/sepetim");
    }

    @Test
    public void adetArttir() throws InterruptedException {
        goToCart();
        driver.findElement(By.cssSelector("select[class='amount']")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("option[value='2']")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void odemeyeGit() throws InterruptedException {
        adetArttir();
        driver.findElement(By.cssSelector("input[value='Alışverişi Tamamla']")).click();
    }

    @Test
    public void adresKaydet() throws InterruptedException {
        odemeyeGit();
        driver.findElement(By.cssSelector("button[value='Kaydet']")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void sepetiDuzenle() throws InterruptedException {
        adresKaydet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // sayfanın altına indi
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("a[title='Sepeti Düzenle']")).click();
        js.executeScript("window.scrollTo(0,400)");
        driver.findElements(By.cssSelector("a[class='gg-ui-btn-default btn-add-to-basket']")).get(4).click();
        TimeUnit.SECONDS.sleep(2);
        js.executeScript("window.scrollTo(0,400)");
        driver.findElements(By.cssSelector("i[class='gg-icon gg-icon-close']")).get(2).click();
    }

    @Test
    public void yeniSekme() throws InterruptedException {
        sepetiDuzenle();
        TimeUnit.SECONDS.sleep(2);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");
        TimeUnit.SECONDS.sleep(2);
        driver.get("https://www.gittigidiyor.com/cikis-yap");
        driver.switchTo().window(tabs.get(0));
        driver.close();// sekme kapatıldı
        TimeUnit.SECONDS.sleep(3);
    }

    @After
    public void cikisYap() throws InterruptedException {

        driver.quit(); //islem sonlandirildi...


    }


}
