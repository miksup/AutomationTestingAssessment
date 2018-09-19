package Katalon.Shopping;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(className="ajax_block_product")
	List<WebElement> listElements;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]")
	private WebElement selection;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]/span")
	private WebElement more;
	
	public void hovering(WebDriver driver) throws InterruptedException {

		Actions select = new Actions(driver);
		select.moveToElement(selection).perform();
		Thread.sleep(3000);
		select.moveToElement(more).click().perform();
	}

}
