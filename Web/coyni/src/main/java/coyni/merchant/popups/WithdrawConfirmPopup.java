package coyni.merchant.popups;

import org.openqa.selenium.By;


import coyni.merchant.components.AuthyComponent;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawConfirmPopup extends BrowserFunctions {
	
	private By btnConfirm = By.cssSelector("");
	
	public void clickConfirm() {
		click(btnConfirm, "Click Confirm");
	}
	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
	public TransactionInProgessPopup transactionInProgessPopup() {
		return new TransactionInProgessPopup();
		
	}
}
