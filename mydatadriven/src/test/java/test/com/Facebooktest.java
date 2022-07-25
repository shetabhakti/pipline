/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author virad
 */
public class Facebooktest {
    private WebDriver driver;
   private String baseUrl;
    private static Login login;
    public Facebooktest() {
    }

   

    @BeforeClass
    public static void setUpClass() throws Exception {
        login = FileUtil.getLoginData();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    @Test
  public void testFacebook() throws Exception {
    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(login.getUsername());
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys(login.getPassword());
   // driver.findElement(By.id("u_0_2")).click();
    //driver.findElement(By.name("login")).click();
    try {
      assertEquals("Log Into Facebook", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create New Account'])[1]/following::span[3]")).getText());
    } catch (Error e) {
      fail(e.toString());
    }
  }
}
