package BDD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	Webpage page;
	
	static int count = 0;
	
	
	
	@Before
	public void setUp() {
		
		count++;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver.exe");
		
		report = TestRunner.report;
		
		test = report.startTest("BDD" + count);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		page = PageFactory.initElements(driver, Webpage.class);
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
		report.endTest(test);
		report.flush();
		
	}
	
	
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {

		
		driver.get(page.Homepage);
		test.log(LogStatus.PASS, "Site Opened");
		
		
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
	    
		test.log(LogStatus.INFO, "Scenario 1: Browse the items available on the website");
	    page.getMenu().click();
	    test.log(LogStatus.INFO, "Navigated to 'Menu'");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {

		if (page.getRedTea().getText().equals("Red Tea")) {
			
			test.log(LogStatus.PASS, "Items to browse exist!");
			
		} else {
			
			test.log(LogStatus.FAIL, "Nothing to browse...");
			
		}
		
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
	    
		test.log(LogStatus.INFO, "Scenario 2: Add an item to the checkout");
		page.getCheckOut().click();
		test.log(LogStatus.INFO, "Navigated to 'Checkout'");
		
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {

		if (page.getCheckOutField().isDisplayed()) {
			
			test.log(LogStatus.PASS, "Checkout page intact!");
			
		} else {
			
			test.log(LogStatus.FAIL, "Field expected but not found...");
			
		}
		
	}


}
