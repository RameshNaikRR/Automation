package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.SuccessFailurePopupCardComponent;
import ilabs.WebFramework.BrowserFunctions;

public class RequestingAccountHolderPopup extends BrowserFunctions{
	
	private By lnkcopy = By.cssSelector("");
	private By btnRequest = By.cssSelector("");
	
	public void clickCopyLink() {
		click(lnkcopy, "Click Copy");
	}
	public void clickRequest() {
		click(btnRequest, "Click Request" );
	}
	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

}