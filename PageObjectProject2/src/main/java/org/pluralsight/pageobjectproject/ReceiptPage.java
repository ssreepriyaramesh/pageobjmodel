package org.pluralsight.pageobjectproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptPage extends PageObject{

	public ReceiptPage(WebDriver driver)
	{
		super(driver); 
	}
	
	@FindBy(xpath="//h1[contains(text(),'Thank you!')]")
	private WebElement header1;
	
	public boolean isInitialized()
	{
		return header1.isDisplayed();
	}
	
	public String getHeaderText()
	{
		return header1.getText();
	}

}