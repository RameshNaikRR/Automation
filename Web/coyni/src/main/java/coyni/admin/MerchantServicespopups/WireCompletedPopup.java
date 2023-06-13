package coyni.admin.MerchantServicespopups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WireCompletedPopup extends BrowserFunctions {

	private By lblWireCompleted = By.xpath("");
	private By crossClose = By.xpath("");
	private By btnDone = By.xpath("");
	private By lnkViewTransaction = By.xpath("");

	public void verifyWireCompleted(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWireCompleted, "Heading is: ", expHeading);
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

	public void clickDone() {
		if (getElement(btnDone, "Done").isEnabled()) {
			click(btnDone, "Done");
			ExtentTestManager.setPassMessageInReport("Done Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Done Button is Disabled");
		}
	}

	public void clickViewTransactions() {
		click(lnkViewTransaction, "View Transaction");
	}
}
