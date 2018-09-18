package Katalon.bleach;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		
	System.setProperty("webdriver.chrome.driver","C:\\Testing\\chromedriver.exe");
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test
	public void meth() throws Exception {
		
		driver.get("https://www.google.co.uk/search?q=google&rlz=1C1CHBF_en-GBGB815GB815&oq=goog&aqs=chrome.0.69i59j0l2j69i57j69i60l2.1264j0j9&sourceid=chrome&ie=UTF-8");
		driver.findElement(By.linkText("Google")).click();
		driver.findElement(By.id("lst-ib")).click();
	    driver.findElement(By.id("lst-ib")).clear();
	    driver.findElement(By.id("lst-ib")).sendKeys("bleach");
	    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	    driver.findElement(By.id("center_col")).click();
	    driver.findElement(By.linkText("Bleach (TV series) - Wikipedia")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reception'])[1]/following::span[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Tatsuya Isaka'])[1]/following::a[1]")).click();
	    
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
	
}
