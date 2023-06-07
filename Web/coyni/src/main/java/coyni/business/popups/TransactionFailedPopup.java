package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionFailedPopup extends BrowserFunctions {

	private By lblTransactionFailedHeading = By.xpath("");
	private By lblDes = By.xpath("");
	private By btnTryAgain = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyFailedTransactionHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionFailedHeading, "Heading is: ", expHeading);
	}

	public void verifyFailedTransactionDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public void clickTryAgain() {
		new CommonFunctions().verifyCursorAction(btnTryAgain, "Try Again");
		if (getElement(btnTryAgain, "Try Again").isEnabled()) {
			click(btnTryAgain, "Try Again");
			ExtentTestManager.setPassMessageInReport("Try Again Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Try Again Button is Disabled");
		}
	}

}
