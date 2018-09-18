package Katalon.Shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


public class navTest {

		private WebDriver driver;
		
		@Before
		public void setup() {
			
			System.setProperty("webdriver.chrome.driver","C:\\Testing\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		
		@After
		public void teardown() {
			
			driver.close();
			
		}
		
		@Test
		public void goodSearch() throws Exception {
			
			String verify = "";
			int results = 0;
			
			driver.get("http://automationpractice.com/index.php");
			driver.findElement(By.id("search_query_top")).click();
		    driver.findElement(By.id("search_query_top")).clear();
		    driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		    driver.findElement(By.id("searchbox")).submit();
		    
		    verify = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText();
		    System.out.println(verify.charAt(0));
		    results = Integer.parseInt(String.valueOf(verify.charAt(0)));
		    System.out.println(results);
		    assertFalse((0 == results));
		    
		    
		}
		
		@Test
		public void badSearch() throws Exception {
			
			String verify = "";
			int results = 0;
			
			driver.get("http://automationpractice.com/index.php");
			driver.findElement(By.id("search_query_top")).click();
		    driver.findElement(By.id("search_query_top")).clear();
		    driver.findElement(By.id("search_query_top")).sendKeys("garbage");
		    driver.findElement(By.id("searchbox")).submit();
		    
		    verify = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
		    System.out.println(verify.charAt(0));
		    results = Integer.parseInt(String.valueOf(verify.charAt(0)));;
		    System.out.println(results);
		    assertTrue(0 == results);
		    
		    
		}
	
}
