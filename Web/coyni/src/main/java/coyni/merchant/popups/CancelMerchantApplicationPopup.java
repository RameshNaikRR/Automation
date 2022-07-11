package coyni.merchant.popups;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CancelMerchantApplicationPopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[text()='Cancel Merchant Application?']");
	private By btnCancelApplication = By.xpath("//button[text()='Cancel Application']");
	private By btnGoBack = By.xpath("//button[text()='No, go back.']");

	public void clickCancelApplication() {
		click(btnCancelApplication, "Cancel Application");
	}

	public void clickBack() {
		click(btnGoBack, "Go Back");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

}
