package Katalon.Shopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(id="search_query_top")
	private WebElement search;
	
	public void query(String text) {
		
		search.click();
		search.clear();
		search.sendKeys(text);
		
	}
	
	
	@FindBy(id="searchbox")
	private WebElement submit;
	
	public void submission() {
		
		submit.submit();
		
	}
	
	
}
