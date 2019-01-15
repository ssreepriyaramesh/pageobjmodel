package org.pluralsight.pageobjectprojecttests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.pluralsight.pageobjectproject.ReceiptPage;
import org.pluralsight.pageobjectproject.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//(Ref Website for Page Object Model: https://www.pluralsight.com/guides/getting-started-with-page-object-pattern-for-your-selenium-tests)

public class SignUpFormTest extends TestBase{
	
	/*@BeforeTest
	public void setUpBrowserType()
	{
		super.strBrowserType = "Firefox";
	}*/
	
	@Test
	public void SignUp(){
		
		driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");
		
		SignUpPage signUpPage = new SignUpPage(driver);
		assertTrue(signUpPage.isInitialized());
		
		String strFirstName = "ufname" + (int)(Math.random()*100);
		String strLastName = "ulname" + (int)(Math.random()*100);
		signUpPage.enterName(strFirstName, strLastName);
		
		String strAddress = "12, chipmunk crossing";
		String strZipCode = "98120";
		signUpPage.enterAddress(strAddress, strZipCode);
		
		ReceiptPage receiptPage = signUpPage.submitInfo();
		assertTrue(receiptPage.isInitialized());
		
		assertEquals("Thank you!", receiptPage.getHeaderText());
	
	}

}