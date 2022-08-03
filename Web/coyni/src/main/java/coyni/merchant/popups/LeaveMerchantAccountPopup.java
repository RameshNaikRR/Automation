package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class LeaveMerchantAccountPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//p[text()='Leave Merchant Account?']");

	private By btnLeaveAccount = By.xpath("//button[text()='Leave Account']");

	private By btnNoGoBack = By.xpath("//p[text()='No, go back']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Leave Merchant Account", expHeading);
	}

	public void clickLeaveAccount() {
		click(btnLeaveAccount, "Leave Account");
	}

	public void clickNoGoBack() {
		click(btnNoGoBack, "No Go Back");
	}

}
