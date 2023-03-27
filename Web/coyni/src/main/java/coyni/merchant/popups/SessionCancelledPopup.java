package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.customer.popups.AddExternalBankAccountPopup;
import coyni.merchant.components.NavigationComponent;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class SessionCancelledPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[contains(text(),'Session Cancelled')]");
	private By btnTryAgain = By.xpath("//button[text()='Try Again']");

	public void verifyHeading() {
		String text = getText(lblHeading, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickTryAgain() {
		click(btnTryAgain, "Try Again");
	}

	public BankAccountAddedPopup bankAccountAddedPopup() {
		return new BankAccountAddedPopup();
	}

	public AddExternalBankAccountPopup addExternalBankAccountPopup() {
		return new AddExternalBankAccountPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
