package Assessment.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCreate {

	@FindBy(id="username")
	private WebElement userField;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement userPass;

	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement passCon;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement named;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement emails;
	
	public void inputs(String user, String pass, String passc, String name, String email) {
		
		userField.clear();
		userField.sendKeys(user);
		
		userPass.clear();
		userPass.sendKeys(pass);
		
		passCon.clear();
		passCon.sendKeys(passc);
		
		named.clear();
		named.sendKeys(name);
		
		emails.clear();
		emails.sendKeys(email);
		
	}
	
	@FindBy(id="yui-gen3-button")
	private WebElement sub;
	
	public void submit() {
		
		sub.click();
		
	}
	
}
