package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class OrderPreviewPopup extends BrowserFunctions {
	
	private By btnConfirm = By.cssSelector("");
	
	public void clickConfirm() {
		click(btnConfirm, "Click Confirm");
	}
	public TransactionInProgessPopup transactionInProgessPopup() {
		return new TransactionInProgessPopup();
	}

}
