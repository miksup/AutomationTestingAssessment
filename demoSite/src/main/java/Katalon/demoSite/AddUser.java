package Katalon.demoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement username;
	
	public void inputName(String text) {
		
		username.clear();
		if (text.length() <= 16) {
			
			username.sendKeys(text);
		
		} else {
			
			username.sendKeys(text.substring(0, 15));
			
		}
		
	}
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement password;
	
	public void inputPass(String text) {
		
		password.clear();
		
		if (text.length() <= 8) {
			
			password.sendKeys(text);
		
		} else {
			
			password.sendKeys(text.substring(0, 7));
			
		}
		
	}
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submit;
	
	public void createUser() {
		
		submit.click();
		
	}
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginPage;
	
	public void navigate() {
		
		loginPage.click();
		
	}

	
	
}
