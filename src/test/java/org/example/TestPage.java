package org.example;

import org.junit.Test;

public class TestPage extends BaseTest{
    LoginPage loginPage;
    SearchPage searchPage;
    ReturnToHomePage returnToHomePage;
    UrunArat urunArat;
    AdetArttirPage adetArttirPage;
    AdresKaydetPage adresKaydetPage;
    SepetiDuzenlePage sepetiDuzenlePage;
    NewTabPage newTabPage;
    @Test
    public void loginTest() throws InterruptedException {
        //logger.info(" Login Test başlatıldı.");
        loginPage=new LoginPage(driver);
        loginPage.login();
        // Assert.assertTrue("Login Başarısız",loginPage.checkIfLoginSuccess());
        //logger.info(" Login Test başarılı.");
    }
   @Test
    public void search() throws InterruptedException {
       loginTest();
       searchPage=new SearchPage(driver);
       searchPage.search();
       //logger.info(" Login Ve Arama Test başlatıldı.");
       //logger.info("Login Ve Arama işlemi başarılı.");

   }
   @Test
    public void anaSayfayaDon() throws InterruptedException {
        search();
        returnToHomePage=new ReturnToHomePage(driver);
        returnToHomePage.anaSayfayaDon();
       //logger.info(" Anasayfaya dönüldü.");

   }
   @Test
    public void cantaArat() throws InterruptedException {
        anaSayfayaDon();
        urunArat=new UrunArat(driver);
        urunArat.cantaArat();
       //logger.info(" Anasayfaya dönüldü.");

   }
   @Test
    public void adetArttir() throws InterruptedException {
        cantaArat();
        adetArttirPage=new AdetArttirPage(driver);
        adetArttirPage.adetArttir();
       //logger.info(" Anasayfaya dönüldü.");

   }
   @Test
    public void adresKaydet() throws InterruptedException {
        adetArttir();
        adresKaydetPage=new AdresKaydetPage(driver);
        adresKaydetPage.adresKaydet();
        //logger.info(" Adres kaydedilemedi, ilgili alanlar boş geçilemez....");

   }
   @Test
    public void sepetiDuzenle() throws InterruptedException {
        adresKaydet();
        sepetiDuzenlePage = new SepetiDuzenlePage(driver);
        sepetiDuzenlePage.sepetiDuzenle();
        //logger.info("Sepeti düzenle sayfasına dönüldü.");

   }
   @Test
    public void yeniSekmeAc() throws InterruptedException {
        sepetiDuzenle();
        newTabPage= new NewTabPage(driver);
        newTabPage.yeniSekme();
       //logger.info("Yeni sekme acildi.");

   }



}
