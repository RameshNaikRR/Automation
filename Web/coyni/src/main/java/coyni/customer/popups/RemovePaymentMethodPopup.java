package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.SuccessFailurePopupCardComponent;
import ilabs.WebFramework.BrowserFunctions;

public class RemovePaymentMethodPopup extends BrowserFunctions {
	
	private By lblmsg = By.cssSelector("");
	private By btnRemove = By.xpath("//button[text()='Remove']");
	
	public void clickOnRemove() {
		click(btnRemove,"click Remove");
	}
    public String getRemoveMessage() {
     return	getText(lblmsg, "Succesfully Removed");
    }
    public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return  new SuccessFailurePopupCardComponent();
	}

}


