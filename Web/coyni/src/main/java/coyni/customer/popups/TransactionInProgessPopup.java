package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TransactionInProgessPopup extends BrowserFunctions {

	private By lnkCopy = By.cssSelector("");
	private By btnDone = By.cssSelector("");
	private By lnkLearnmore = By.cssSelector("");
	
	public void clickCopyLink() {
		click(lnkCopy, "Click Copy");
	}
	public void clickDone() {
		click(btnDone, "Click Done");
	}
	public void lnkLearnmore() {
		click(lnkLearnmore, "Click LearnMore");
	}
}
