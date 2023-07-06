package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TransactionFailedPopup extends BrowserFunctions {
	private By failedHeading = By.xpath("");
	private By failedDescription = By.xpath("");
	private By clickTryAgain = By.xpath("");
	private By clickClose = By.xpath("");

	public void verifyFailedHeading(String Heading) {
		new CommonFunctions().verifyLabelText(failedHeading, "Heading is :", Heading);
	}

	public void verifyFailedDescription(String Description) {
		new CommonFunctions().verifyLabelText(failedDescription, "Description is:", Description);
	}

	public void clickTryAgain() {
		click(clickTryAgain, "Try Again");
	}

	public void clickClose() {
		click(clickClose, "Close");
	}
}
