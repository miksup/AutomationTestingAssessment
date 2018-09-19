package Katalon.Shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


public class POMtest {

		private WebDriver driver;
		public static ExtentReports report;
		public ExtentTest test;
		private static HelperMethod help = new HelperMethod();
		
		@BeforeClass
		public static void initial() {
			
			report = new ExtentReports("C:\\Testing\\shoppingWebpageTest.html", true);
			
		}
		
		@Before
		public void setup() {
			
			System.setProperty("webdriver.chrome.driver","C:\\Testing\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		
		@After
		public void teardown() throws InterruptedException {
			
			Thread.sleep(3000);
			driver.close();
			
		}
		
		@AfterClass
		public static void end() {
			
			report.flush();
			
		}

		@Test
		public void goodSearch() throws Exception {
			
			test = report.startTest("Good Query");
			driver.get("http://automationpractice.com/index.php");
			test.log(LogStatus.INFO, "Site Opened");
			
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			SearchResults results = PageFactory.initElements(driver, SearchResults.class);
			
			home.query("Dress");
			home.submission();
			test.log(LogStatus.INFO, "Good query inserted and submitted");
		    
			if (0 != results.resultTotal()) {
				
				test.log(LogStatus.PASS, "Test Passed - Query recognised; Returns some results");
				help.screenshot(driver);
				
			} else {
				
				test.log(LogStatus.FAIL, "Test Failed");
				
			}
			
			report.endTest(test);
			assertFalse(0 == results.resultTotal());
			
		}

		@Test
		public void badSearch() throws Exception {
			
			test = report.startTest("Bad Query");
			driver.get("http://automationpractice.com/index.php");
			test.log(LogStatus.INFO, "Site Opened");
			
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			SearchResults results = PageFactory.initElements(driver, SearchResults.class);
			
			home.query("garbage");
			home.submission();
			test.log(LogStatus.INFO, "Bad query inserted and submitted");
			
			if (0 == results.nothing()) {
				
				test.log(LogStatus.PASS, "Test Passed - Bad query, no results returned");
				help.screenshot(driver);
				
			} else {
				
				test.log(LogStatus.FAIL, "Test Failed");
				
			}
			
			report.endTest(test);
			assertTrue(0 == results.nothing());
			
		}

		@Test
		public void byListGood() throws Exception {
			
			test = report.startTest("By List - Good Query");
			driver.get("http://automationpractice.com/index.php");
			test.log(LogStatus.INFO, "Site Opened");
			
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			SearchResults results = PageFactory.initElements(driver, SearchResults.class);
			
			home.query("Dress");
			home.submission();
			test.log(LogStatus.INFO, "Good query inserted and submitted");
						
			if(!results.listElements.isEmpty()) {
				
				test.log(LogStatus.PASS, "Test Passed - Query recognised; Returns some results");
				test.log(LogStatus.INFO, "number of clothing items: " + results.listElements.size());
				help.screenshot(driver);
				
			} else {
				
				test.log(LogStatus.FAIL, "");
				
			}
			
			report.endTest(test);
			assertFalse(results.listElements.isEmpty());
			
		}
		
		@Test public void copyAndPaste() throws Exception {
			
			test = report.startTest("Copy and Paste");
			driver.get("http://automationpractice.com/index.php");
			test.log(LogStatus.INFO, "Site Opened");
			
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			SearchResults results = PageFactory.initElements(driver, SearchResults.class);
			PrintDress page = PageFactory.initElements(driver, PrintDress.class);
			
			home.query("Dress");
			home.submission();
			test.log(LogStatus.INFO, "Good query inserted and submitted");
			
			String compare = results.listElements.get(0).getText();
			results.hovering(driver);
			test.log(LogStatus.INFO, "Hovers over specified web element which reveals additional webelements and options; "
					+ "clicks previously hidden object 'more' and loads next page");
			
			page.selecting(driver);
			test.log(LogStatus.INFO, "Selects information about product; copies it;"
					+ "pastes in search bar and searches for it");
			
			
			if (compare.equals(results.listElements.get(0).getText())) {
				
				test.log(LogStatus.PASS, "Search returned expected result");
				
			} else {
				
				test.log(LogStatus.FAIL, "Search returned unexpected result");
				
			}
			
			report.endTest(test);
			assertTrue(compare.equals(results.listElements.get(0).getText()));
		}
	
}
