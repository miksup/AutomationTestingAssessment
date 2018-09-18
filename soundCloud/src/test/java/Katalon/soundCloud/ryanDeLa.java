package Katalon.soundCloud;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ryanDeLa {
	  
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    
		System.setProperty("webdriver.chrome.driver","C:\\Testing\\chromedriver.exe");
		  
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	  }

	  @Test
	  public void ryanDeLa() throws Exception {
	    driver.get("https://www.google.co.uk/search?q=google&rlz=1C1CHBF_en-GBGB815GB815&oq=goog&aqs=chrome.0.69i59j69i60j0l2j69i60l2.1263j0j4&sourceid=chrome&ie=UTF-8");
	    driver.findElement(By.linkText("Google")).click();
	    driver.findElement(By.id("lst-ib")).clear();
	    driver.findElement(By.id("lst-ib")).sendKeys("ryan de la cruz");
	    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	    driver.findElement(By.linkText("Ryan De La Cruz | Free Listening on SoundCloud")).click();
	    driver.findElement(By.linkText("Play")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skip to previous'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skip to previous'])[1]/following::button[1]")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    
		  //driver.quit();
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
