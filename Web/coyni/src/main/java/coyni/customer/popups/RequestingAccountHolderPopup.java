package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class RequestingAccountHolderPopup extends BrowserFunctions{
	
	private By lnkcopy = By.cssSelector("");
	private By btnRequest = By.cssSelector("");
	
	public void clickOnCopyLink() {
		click(lnkcopy, "Click Copy");
	}
	public void clickOnRequest() {
		click(btnRequest, "Click Request" );
	}

}