import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MyTestCase {

	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.n11.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testValidtest2() throws Exception {
	    driver.get(baseUrl + "/");
	    try {
	      assertEquals("n11.com - Alýþveriþin Uðurlu Adresi", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("Giriþ Yap")).click();
	    try {
	      assertEquals("Giriþ Yap - n11.com", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("didem1614@hotmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123456789d");
	    driver.findElement(By.id("loginButton")).click();
	    driver.findElement(By.id("searchData")).click();
	    driver.findElement(By.id("searchData")).clear();
	    driver.findElement(By.id("searchData")).sendKeys("samsung");
	    driver.findElement(By.cssSelector("span.icon.iconSearch")).click();
	    try {
	      assertEquals("Samsung - n11.com", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("2")).click();
	    try {
	      assertEquals("2", driver.findElement(By.name("currentPage")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("Hesabým")).click();
	    try {
	      assertEquals("Hesabým - n11.com", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(//a[contains(text(),'Favorilerim')])[2]")).click();
	    try {
	      assertEquals("Favorilerim - n11.com", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("Kaldýr")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}

