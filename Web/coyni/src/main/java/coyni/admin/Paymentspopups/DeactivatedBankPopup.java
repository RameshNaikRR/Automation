package coyni.admin.Paymentspopups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DeactivatedBankPopup extends BrowserFunctions {

	private By lblDeactivatedBank = By.xpath("");
	private By lblDescription = By.xpath("");
	private By btnYes = By.xpath("");
	private By lnkNoAndGoBack = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyDeactivated(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDeactivatedBank, "Heading is: ", getCopiedData());
	}

	public void verifyDescription(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDescription, "Descriptipn is: ", expHeading);
	}

	public void clickYes() {
		if (getElement(btnYes, "Yes").isEnabled()) {
			click(btnYes, "Yes");
			ExtentTestManager.setPassMessageInReport("Yes Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Yes Button is Disabled");
		}
	}

	public void clickNoAndGoBack() {
		click(lnkNoAndGoBack, "No, go back");
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

}
