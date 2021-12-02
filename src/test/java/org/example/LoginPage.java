package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login() throws InterruptedException {

        TimeUnit.SECONDS.sleep(2);
        //atlamak icin yonlendirme yaptık. sonra tekrar bakmalıyız
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi?s=1");
        driver.findElement(By.id("L-UserNameField")).sendKeys("selenium_deneme@gmail.com");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("L-PasswordField")).sendKeys("seleniumDeneme1" + Keys.ENTER);
    }
    public boolean checkIfLoginSuccess() {

        return getName().contains("Hesabım");
    }

    private String getName(){
        return driver.findElement(By.cssSelector("div[title='Hesabım']")).getText();
    }

}
