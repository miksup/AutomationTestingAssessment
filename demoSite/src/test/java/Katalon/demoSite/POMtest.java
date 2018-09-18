package Katalon.demoSite;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class POMtest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Testing\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void method() throws Exception {
		
		driver.get("http://thedemosite.co.uk/index.php");
		
		Index ind = PageFactory.initElements(driver, Index.class);
		AddUser newUser = PageFactory.initElements(driver, AddUser.class);
		Login log = PageFactory.initElements(driver, Login.class);
		
		ind.navigate();
		
		newUser.inputName("hello");
		newUser.inputPass("hello");
		newUser.createUser();
		newUser.navigate();
		
		log.inputName("hello");
		log.inputPass("hello");
		log.login();
		
		assertEquals (log.hopedFor, log.checkStatus());
		
	}
	
	@After
	public void tearDown() {
		
		//driver.close();
		
	}
	
}

