package Katalon.demoSite;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class POMtest {
	
	private WebDriver driver;
	public static ExtentReports report;
	public ExtentTest test;
	
	@BeforeClass
	public static void initial() {
		
		report = new ExtentReports(Constants.ReportLoc, true);
		
	}

	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", Constants.DriverPath);
		
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
	public void method() throws Exception {
		
		test = report.startTest("Simple User");
		driver.get(Constants.Homepage);
		test.log(LogStatus.INFO, "Site Opened");
		
		Index ind = PageFactory.initElements(driver, Index.class);
		AddUser newUser = PageFactory.initElements(driver, AddUser.class);
		Login log = PageFactory.initElements(driver, Login.class);
		
		ind.navigate();
		test.log(LogStatus.INFO, "Navigate to 'Add Users' page");
		
		newUser.inputName("hello");
		newUser.inputPass("hello");
		test.log(LogStatus.INFO, "Input username and password");
		newUser.createUser();
		test.log(LogStatus.INFO, "Creates user");
		newUser.navigate();
		test.log(LogStatus.INFO, "Navigate to 'Login' page");
		log.inputName("hello");
		log.inputPass("hello");
		log.login();
		
		if (log.hopedFor.equals(log.checkStatus())) {
			
			test.log(LogStatus.PASS, "Successful Login");
			
		}	else {
			
			test.log(LogStatus.FAIL, "Unsuccessful Login");
		}
		
		report.endTest(test);
		assertEquals (log.hopedFor, log.checkStatus());
		
	}
	
	
	@Test
	public void methDDT() throws Exception {
		

		
		Index ind = PageFactory.initElements(driver, Index.class);
		AddUser newUser = PageFactory.initElements(driver, AddUser.class);
		Login log = PageFactory.initElements(driver, Login.class);
		
		Exceltation xL = new Exceltation();
		xL.setExcelFile(Constants.Path_TestData + Constants.File_TestData, 0);

		//		FileInputStream file = null;
//		try {
//			
//			file = new FileInputStream(Constants.Path_TestData + Constants.File_TestData); 
//		
//		} catch (FileNotFoundException e) {}
//			
//		XSSFWorkbook workbook = null;
//		try {
//			
//			workbook = new XSSFWorkbook(file);
//			
//		} catch (IOException e) {}
//		
//		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFSheet sheet = xL.getExcelWSheet();
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
		
			test = report.startTest("DDT" + i);
			driver.get(Constants.Homepage);
			test.log(LogStatus.INFO, "Site Opened");
			
			String user = xL.getCellData(i, 0);
			String pass = xL.getCellData(i, 1);
			
			ind.navigate();
			test.log(LogStatus.INFO, "Navigate to 'Add Users' page");
			
			newUser.inputName(user);Thread.sleep(1000);
			newUser.inputPass(pass);Thread.sleep(1000);
			test.log(LogStatus.INFO, "Input Username and Password from row" + i);
			
			newUser.createUser();Thread.sleep(1000);
			test.log(LogStatus.INFO, "User creation successful");
			
			newUser.navigate();
			test.log(LogStatus.INFO, "Navigate to 'Login' page");
			
			log.inputName(user);Thread.sleep(1000);
			log.inputPass(pass);Thread.sleep(1000);
			test.log(LogStatus.INFO, "Input Username and Password from row" + i);
			
			log.login();Thread.sleep(1000);
			
			if (log.hopedFor.equals(log.checkStatus())) {
				
				test.log(LogStatus.PASS, "Successful Login");
				xL.setCellData("PASS", i, 2);
			}	else {
				
				test.log(LogStatus.FAIL, "Unsuccessful Login");
				xL.setCellData("FAIL", i, 2);
			}
			
			
			report.endTest(test);
			//assertEquals (log.hopedFor, log.checkStatus());
			
		}
	}
	
	
}

