package Katalon.Shopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults {

	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[2]")
	private WebElement goodResult;
	
	public int resultTotal() {
		
		int res = 0;
		res = Integer.parseInt(String.valueOf(goodResult.getText().charAt(0)));
		
		return res;
		
	}
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span")
	private WebElement badResult;
	
	public int nothing() {
		
		int res = 0;
		res = Integer.parseInt(String.valueOf(badResult.getText().charAt(0)));
		
		return res;
		
	}

}
