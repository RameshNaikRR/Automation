package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransferCompletedPopup extends BrowserFunctions {

	private By lblTransferHeading = By.xpath("");
	private By btnDone = By.xpath("");
	private By lnkViewTransaction = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyTransferCompletedHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransferHeading, "Transfer completed heading is: ", expHeading);
	}

	public void clickDone() {
		new CommonFunctions().verifyCursorAction(btnDone, "Done");
		if (getElement(btnDone, "Done").isEnabled()) {
			click(btnDone, "Done");
			ExtentTestManager.setPassMessageInReport("Done Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Done Button is Disabled");
		}
	}

	public void clickViewTransaction() {
		click(lnkViewTransaction, "View Transaction");
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

}
