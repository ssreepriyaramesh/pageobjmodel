package org.pluralsight.pageobjectproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageObject {
	
	public SignUpPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='firstname']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='address']")
	private WebElement txtAddress;
	
	@FindBy(xpath="//input[@id='zipcode']")
	private WebElement txtZipCode;
	
	@FindBy(xpath="//input[@id='signup']")
	private WebElement btnSubmit;
	
	public boolean isInitialized()
	{
		return txtFirstName.isDisplayed();
	}
	
	public void enterName(String strFirstName, String strLastName)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(strFirstName);
		
		txtLastName.clear();
		txtLastName.sendKeys(strLastName);
	}
	
	public void enterAddress(String strAddress, String strZipCode)
	{
		txtAddress.clear();
		txtAddress.sendKeys(strAddress);
		
		txtZipCode.clear();
		txtZipCode.sendKeys(strZipCode);
	}
	
	public ReceiptPage submitInfo()
	{
		btnSubmit.click();
		return new ReceiptPage(driver);
	}

}