package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddBankCheckingAccountPopup extends BrowserFunctions {

	private By lblAddBankAccountHeading = By.xpath("");
	private By lblAddBankDes = By.xpath("");
	private By chkbxAddBank = By.xpath("");
	private By btnNext = By.xpath("");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyAddBankAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddBankAccountHeading, "Heading is: ", expHeading);
	}

	public void verifyAddBankAccountDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblAddBankDes, "Description is: ", expDes);
	}

	public void clickCheckBox() {
		new CommonFunctions().verifyCursorAction(chkbxAddBank, "Check Box");
		click(chkbxAddBank, "Check Box");
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public void clickBackArrow() {
		new CommonFunctions().verifyCursorAction(backArrow, "Back Arrow");
		click(backArrow, "Back Arrow");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

}
