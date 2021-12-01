package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.ArrayList;
import java.util.Random;
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
        Random rnd = new Random();
        int fav1= 1+ rnd.nextInt(5);
        int fav2= 6+ rnd.nextInt(5);
        int fav3= 11+ rnd.nextInt(5);
        int fav4= 16+ rnd.nextInt(5);
       TimeUnit.SECONDS.sleep(1);
       // js.executeScript("window.scrollTo(0,-2000)");
       // js.executeScript("window.scrollTo(0,350)");
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



        // fav className:  sc-1n49x8z-14 fIkZfb
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
        //7.ürün ekletildi...
        driver.findElements(By.cssSelector("div[class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl']")).get(6).click();
        //buraya scrol gerekiyor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,400)");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("add-to-basket")).click();
        //

        TimeUnit.SECONDS.sleep(3);

    }
    @Test
    public void goToCart() throws InterruptedException {
        cantaArat();
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-(document.body.scrollHeight)"); // sayfanın altına indi
       */// driver.findElement(By.className("sc-84am1q-0 sc-1r48nyr-0 WZTpV kEgEYI")).click();
       //driver.findElement(By.className("gekhq4-6 ojrwK")).click();
       // title=Sepetim
        driver.navigate().to("https://www.gittigidiyor.com/sepetim");
              //  driver.findElement(By.cssSelector("input[title='Sepetim']")).click();


    }
    @Test
    public void adetArttir() throws InterruptedException {
        goToCart();
   driver.findElement(By.cssSelector("select[class='amount']")).click();

        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.cssSelector("option[value='2']")).click();
        TimeUnit.SECONDS.sleep(2);
       // select.selectByVisibleText("2");
        TimeUnit.SECONDS.sleep(2); //5 sn bekleme süresi ayarladık.*/
    }
    @Test
    public void odemeyeGit() throws InterruptedException {
        adetArttir();
        //driver.findElement(By.className("gg-d-24 gg-ui-btn-primary gg-ui-btn-lg btn-pay")).click();
        driver.findElement(By.cssSelector("input[value='Alışverişi Tamamla']")).click();
    }
    @Test
    public void adresKaydet() throws InterruptedException {
        odemeyeGit();
        driver.findElement(By.cssSelector("button[value='Kaydet']")).click();
        TimeUnit.SECONDS.sleep(5);
    }
    @Test
    public void sepetiDuzenle() throws InterruptedException {
        adresKaydet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // sayfanın altına indi
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("a[title='Sepeti Düzenle']")).click();
    }
    @Test
    public void yeniSekme() throws InterruptedException {
        sepetiDuzenle();
        TimeUnit.SECONDS.sleep(2);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");
        TimeUnit.SECONDS.sleep(2);
        driver.get("https://www.gittigidiyor.com/cikis-yap");
        driver.switchTo().window(tabs.get(0));
       // TimeUnit.SECONDS.sleep(2);

    }
    @Test
    public void cikisYap() throws InterruptedException {
        //burada cikis yap için locator bulamadım :( o sebeple link yonlendirme verdim.
        yeniSekme();

        //yeni sekme kapat
        /*ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        ((JavascriptExecutor)driver).executeScript("window.close()");*/
        TimeUnit.SECONDS.sleep(3);
        //driver.close();
        driver.quit();



    }


}
