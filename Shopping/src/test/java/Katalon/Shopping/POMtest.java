package Katalon.Shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


public class POMtest {

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
			
			driver.get("http://automationpractice.com/index.php");
			
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			SearchResults results = PageFactory.initElements(driver, SearchResults.class);
			
			home.query("Dress");
			home.submission();
			assertFalse(0 == results.resultTotal());
		    
		    
		}
		
		@Test
		public void badSearch() throws Exception {
			
			driver.get("http://automationpractice.com/index.php");
			
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			SearchResults results = PageFactory.initElements(driver, SearchResults.class);
			
			home.query("garbage");
			home.submission();
			assertTrue(0 == results.nothing());
		    
		    
		}
	
}
