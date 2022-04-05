package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.SuccessFailureComponent;
import ilabs.WebFramework.BrowserFunctions;

public class RemovePaymentMethodPopup extends BrowserFunctions {

	private By btnRemove = By.xpath("");
	
	
	public void clickOnRemove() {
		click(btnRemove,"Click Remove");
	}
	
	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent(); 	
	}
	
}
