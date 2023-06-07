package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class NewWalletPopup extends BrowserFunctions {

	private By lblNewWalletHedaing = By.xpath("");
	private By txtWalletName = By.xpath("");
	private By btnAdd = By.xpath("");
	private By crossClose = By.xpath("");
	private By chkBox = By.xpath("");

	public void verifyNewWalletHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblNewWalletHedaing, "New Wallet Hedaing is: ", expHeading);
	}

	public void fillWalletName(String walletName) {
		new CommonFunctions().verifyCursorAction(txtWalletName, "Wallet Name");
		enterText(txtWalletName, walletName, "Wallet Name");
	}

	public void clickCheckBox() {
		new CommonFunctions().verifyCursorAction(chkBox, "Check Box");
		click(chkBox, "Check Box");
	}

	public void clickAdd() {
		new CommonFunctions().verifyCursorAction(btnAdd, "Add");
		if (getElement(btnAdd, "Add").isEnabled()) {
			click(btnAdd, "Add");
			ExtentTestManager.setPassMessageInReport("Add Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Add Button is Disabled");
		}
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

}
