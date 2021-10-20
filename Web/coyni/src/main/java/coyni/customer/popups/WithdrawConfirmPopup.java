package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
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
