package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class InstantPayPageSourcePopup extends BrowserFunctions{
	
	private By radBtnVisaDebit = By.cssSelector("");
	private By radBtnMasterCard = By.cssSelector("");
	
	public void cilckOnVisaDebit() {
		click(radBtnVisaDebit, "Click VisaDebit");
	}
	public void clickOnMasterCard() {
		click(radBtnMasterCard, "click MasterCard");
	}

}
