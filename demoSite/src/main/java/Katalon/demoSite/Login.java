package Katalon.demoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	
	public String hopedFor = "**Successful Login**";
	
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement username;
	
	public void inputName(String text) {
		
		username.clear();
		username.sendKeys(text);
		
	}
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement password;
	
	public void inputPass(String text) {
		
		username.clear();
		username.sendKeys(text);
		
	}
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submit;
	
	public void login() {
		
		submit.click();
		
	}
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement status;
	
	public String checkStatus() {
		
		return status.getText();
		
	}
	
}
