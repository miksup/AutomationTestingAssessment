package Assessment.AutomatedTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	public void nav(WebDriver driver) {
		
		driver.get(Constants.Homepage);
		
	}
	
	@FindBy(id="j_username")
	private WebElement userField;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement passField;
	
	@FindBy(id="yui-gen1-button")
	private WebElement sub;
	
	public void adminLogin(String user, String pass) {
		
		userField.click();
		userField.clear();
		userField.sendKeys(user);
		
		passField.click();
		passField.clear();
		passField.sendKeys(pass);
		
		sub.click();
		
	}
	
	
}
