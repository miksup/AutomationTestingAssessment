package Assessment.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUsers {

	@FindBy(xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement menuManage;
	
	@FindBy(xpath="//*[@id=\"management-links\"]/tbody/tr[16]/td[2]/div[1]/a")
	private WebElement manageUsers;
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUser;
	
	public void navUserPage() {
		
		menuManage.click();
		manageUsers.click();
		
	}
	
	public void navCreateUser() {
		
		menuManage.click();
		manageUsers.click();
		createUser.click();
		
	}
	
}
