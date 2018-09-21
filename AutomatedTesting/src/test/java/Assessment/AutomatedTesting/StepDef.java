package Assessment.AutomatedTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	
	//////////INITIALISATION&PREP//////////////////////////////
	
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	HomePage page;
	ManageUsers mgmnt;
	UserCreate create;
	ExcelTation xL = new ExcelTation();
	
	static int count = 0;
	
	@Before
	public void setUp() {
		
		count++;
		
		System.setProperty("webdriver.chrome.driver", Constants.DriverPath);
		
		report = TestRunner.report;
		
		test = report.startTest("JenkinsAutoTask" + count);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		page = PageFactory.initElements(driver, HomePage.class);
		mgmnt = PageFactory.initElements(driver, ManageUsers.class);
		create = PageFactory.initElements(driver, UserCreate.class);
		
		xL.setExcelFile(Constants.Path_TestData + Constants.File_TestData, 0);
		
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
		report.endTest(test);
		report.flush();
		
	}
	
	//////////////STEP DEF///////////////////////////////////////////////
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() {
		
		
		page.nav(driver);
		page.adminLogin(Constants.AdminUsername, Constants.AdminPassword);
	    test.log(LogStatus.INFO, "Successful Login!");
		
		mgmnt.navCreateUser();
		test.log(LogStatus.INFO, "Successfully navigated to 'Create User' page");
	    
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {

		create.inputs("xyz", "xyz", "xyz", "xyz", "xyz@xyz.com");
		test.log(LogStatus.INFO, "Filled info fields with generic text");
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() {

		create.submit();
		test.log(LogStatus.PASS, "New user information submitted");
		
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {

		System.out.println(driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[1]")).getText());
		
		List<WebElement> rows = driver.findElement(By.id("people")).findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		test.log(LogStatus.INFO, "Beginning search of User table for relevant username");
		
		for (int i = 2; i < rows.size()+1; i++) {
			
			if(driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]")).getText().equals("xyz")) {
				
				test.log(LogStatus.PASS, "Successfully added dummy user 'xyz', visible in user screen");
				
				if (driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]/a")).isDisplayed()) {
					
					driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]/a")).click();
					test.log(LogStatus.PASS, "Click on username to verify");
					xL.setCellData("PASS", count, 1);
				
				} else {
					
					test.log(LogStatus.FAIL, "Unable to verify by clicking on username");
					xL.setCellData("FAIL", count, 1);
					
				}
			}
		
		}
		
		test.log(LogStatus.INFO, "Iterated through table of users, checking the UserID column specifically");
		
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String user, String pass, String passCon, String name, String email) {
		
		create.inputs(user, pass, passCon, name, email);
	    
		test.log(LogStatus.INFO, "Filled info fields with example text from feature file - current example username: " + user);
	    
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {

		System.out.println(driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[1]")).getText());
		
		List<WebElement> rows = driver.findElement(By.id("people")).findElements(By.tagName("tr"));
		
		test.log(LogStatus.INFO, "Beginning search of User table for relevant username");
		
		for (int i = 2; i < rows.size()+1; i++) {
			
			if (driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]")).getText().equals(arg1)) {
				
				test.log(LogStatus.INFO, "Row " + i + " is currently " + arg1);
				test.log(LogStatus.PASS, "Successfully added dummy user, visible in user screen");
				xL.setCellData("PASS", count, 1);
			}
		
		}
		
		test.log(LogStatus.INFO, "Iterated through table of users, checking the UserID column specifically");
		
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String username) {
		
		page.nav(driver);
		page.adminLogin(Constants.AdminUsername, Constants.AdminPassword);
		test.log(LogStatus.INFO, "Successful Login!");
		
	    mgmnt.navUserPage();
	    test.log(LogStatus.INFO, "Successfully navigated to 'Manage Users' page");
		
		List<WebElement> rows = driver.findElement(By.id("people")).findElements(By.tagName("tr"));
		
		test.log(LogStatus.INFO, "Beginning search through User Screen for relevant username");
		
		for (int i = 2; i < rows.size()+1; i++) {
			
			if (driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]")).getText().equals(username)) {
				
				System.out.println("Row " + i + " is " + username);
				test.log(LogStatus.PASS, "Relevant user" + username + "is visible in user screen, at row " + i);
			}
		
		}		
		
		test.log(LogStatus.INFO, "Iterated through table of users, checking the UserID column specifically");
		
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String username) throws Throwable {
	    
		List<WebElement> rows = driver.findElement(By.id("people")).findElements(By.tagName("tr"));
		int j = 0;
		
		test.log(LogStatus.INFO, "Seeking location of relevant username in User Screen; to be clicked.");
		
		for (int i = 2; i < rows.size()+1; i++) {
			
			if (driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]")).getText().equals(username)) {
				
				System.out.println("Row " + i + " is " + username);
				j = i;
			}
		
		}
		
		test.log(LogStatus.INFO, "Iterated through table of users, checking the UserID column specifically. Table location recorded as row " + j);
		
		if (driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + j + "]/td[2]/a")).isDisplayed()) {
			
			driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + j + "]/td[2]/a")).click();
			test.log(LogStatus.PASS, "Relevant user " + username + " visibility verified by clicking and navigating to User's info page");
			
		} else {
			
			test.log(LogStatus.FAIL, "Relevant user " + username + " visibility is unverified by clicking. "
					+ "Could be a bad given username, or the link is not clickable, or it is not where it should be.");
			
		}


		
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String username) {

		if(driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[2]")).getText().equals("Jenkins User Id: " + username)) {
			
			test.log(LogStatus.PASS, "Clicking on correct username takes user to correct user info page");
			xL.setCellData("PASS", count, 1);
			
		} else if (!driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[2]")).isDisplayed()) {
			
			test.log(LogStatus.FAIL, "Wrong page, element expected but not found - bad navigation.");
			xL.setCellData("FAIL", count, 1);
			
		} else {
			
			test.log(LogStatus.FAIL, "Wrong page, wrong information. Expected: " + username);
			xL.setCellData("FAIL", count, 1);
			
		}
		
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String username) {
	    
		page.nav(driver);
		page.adminLogin(Constants.AdminUsername, Constants.AdminPassword);
		test.log(LogStatus.INFO, "Successful Login!");
		
	    mgmnt.navUserPage();
	    test.log(LogStatus.INFO, "Successfully navigated to 'Manage Users' page");
	    
	    List<WebElement> rows = driver.findElement(By.id("people")).findElements(By.tagName("tr"));
		int j = 0;
		
		test.log(LogStatus.INFO, "Seeking location of relevant username in User Screen; to be clicked.");
		
		for (int i = 2; i < rows.size()+1; i++) {
			
			if (driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]")).getText().equals(username)) {
				
				System.out.println("Row " + i + " is " + username);
				j = i;
			}
		
		}
		
		test.log(LogStatus.INFO, "Iterated through table of users, checking the UserID column specifically. Table location recorded as row " + j);
		
		if (driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + j + "]/td[2]/a")).isDisplayed()) {
			
			driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + j + "]/td[2]/a")).click();
			test.log(LogStatus.PASS, "Relevant user " + username + " visibility verified by clicking and navigating to User's info page");
			
		} else {
			
			test.log(LogStatus.FAIL, "Relevant user " + username + " visibility is unverified by clicking. "
					+ "Could be a bad given username, or the link is not clickable, or it is not where it should be.");
			
		}
		
		if(driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[2]")).getText().equals("Jenkins User Id: " + username)) {
			
			test.log(LogStatus.PASS, "Clicking on correct username takes user to correct user info page");
			
		} else if (!driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[2]")).isDisplayed()) {
			
			test.log(LogStatus.FAIL, "Wrong page, element expected but not found - bad navigation.");
			
		} else {
			
			test.log(LogStatus.FAIL, "Wrong page, wrong information.");
			
		}
		
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() {
		
		if (driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[4]/a[2]")).isDisplayed()) {
			
			driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[4]/a[2]")).click();
			test.log(LogStatus.PASS, "Successfully clicked configuration button");
			
		} else {
			
			test.log(LogStatus.FAIL, "Unable to find navigation button");
			
		}
		
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String email) {

		WebElement ema = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/table/tbody/tr[17]/td[3]/input"));
		
		
		ema.click();
		ema.clear();
		ema.sendKeys(email);
		test.log(LogStatus.INFO, "New email address inserted into email field");
		
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() {
		
		WebElement submit = driver.findElement(By.id("yui-gen5-button"));
		
		submit.click();
		test.log(LogStatus.INFO, "Changes submitted");
		
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String email) throws Throwable {

		driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[4]/a[2]")).click();
		
		WebElement ema = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/table/tbody/tr[17]/td[3]/input"));
		
		if (ema.getAttribute("value").equals(email)) {
			
			test.log(LogStatus.PASS, "Email successfully changed");
			xL.setCellData("PASS", count, 1);
			
		} else {
			
			test.log(LogStatus.FAIL, "Email not changed");
			xL.setCellData("FAIL", count, 1);
			
		}
		
	}
	
}
