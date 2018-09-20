package BDD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Webpage {
	
	public final String Homepage = "http://www.practiceselenium.com/welcome.html";
	
	//MENU
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menu;
	
	public WebElement getMenu() {
		return menu;
	}
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p")
	private WebElement redTea;

	public WebElement getRedTea() {
		return redTea;
	}
	
	//CHECKOUT
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkOut;
	
	public WebElement getCheckOut() {
		return checkOut;
	}
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[1]")
	private WebElement checkOutField;
	
	public WebElement getCheckOutField() {
		return checkOutField;
	}
	
}
