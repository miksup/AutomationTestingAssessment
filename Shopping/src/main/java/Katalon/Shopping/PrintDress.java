package Katalon.Shopping;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PrintDress {

		@FindBy(xpath = "//*[@id=\"short_description_content\"]/p")
		private WebElement info;
		
		@FindBy(xpath = "//*[@id=\"search_query_top\"]")
		private WebElement search;
		
		public void selecting(WebDriver driver) throws InterruptedException {

			Actions select = new Actions(driver);
			select.moveToElement(info).moveByOffset(-180, -10).clickAndHold().moveByOffset(340, 20).release().perform();
			Thread.sleep(3000);
			
			select.sendKeys(Keys.chord(Keys.CONTROL,"c")).perform();
			//select.keyUp(Keys.CONTROL).keyUp("c");
			select.moveToElement(search).click().sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.BACK_SPACE);
			select.moveToElement(search).click().sendKeys(Keys.chord(Keys.CONTROL,"v"),Keys.ENTER).perform();
			Thread.sleep(3000);
			
		}
	
}
