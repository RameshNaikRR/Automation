package coyni.checkout;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CancelTransaction extends BrowserFunctions {

	private By headingCancel = By.xpath("//h6[text()='Cancel Transaction']");
	private By lblCancelContent = By.xpath("//p[text()='Are you sure you want to cancel checkout transaction ?']");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By btnGoBack = By.xpath("//button[text()='No, go back']");

	private By lblContent = By.xpath("//p[text()='Checkout is cancelled.']");

	private By btnBackToMerchant = By.xpath("//button[text()='Back to Merchant']");

	public void verifyCancelHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingCancel, "", expHeading);
	}

	public void verifyCancelContent(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCancelContent, "", expHeading);
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}
	public void clickGoBack() {
		click(btnGoBack, "Go Back");
	}
	
	public void verifyCheckOutContent(String expHeading) {
		new CommonFunctions().verifyLabelText(lblContent, "Content", expHeading);
	}
	public void clickGoBackMerchant() {
		click(btnBackToMerchant, "Go Back");
	}

}
