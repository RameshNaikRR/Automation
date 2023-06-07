package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WalletTransferSummaryPopup extends BrowserFunctions {

	private By lblWalletTransferHedaing = By.xpath("");
	private By lblAmount = By.xpath("");
	private By lblTransferAmount = By.xpath("");
	private By btnConfirm = By.xpath("");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyWalletTransferHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWalletTransferHedaing, "Wallet Transfer Hedaing is: ", expHeading);
	}

	public String verifyAmount() {
		String amount = getText(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Amount is: " + amount);
		return amount;
	}

	public String verifyTransferAmount() {
		String transferAmount = getText(lblTransferAmount, "Transfer amount");
		ExtentTestManager.setInfoMessageInReport("Transfer amount is: " + transferAmount);
		return transferAmount;
	}

	public void clickConfirm() {
		new CommonFunctions().verifyCursorAction(btnConfirm, "Confirm");
		if (getElement(btnConfirm, "Confirm").isEnabled()) {
			click(btnConfirm, "Confirm");
			ExtentTestManager.setPassMessageInReport("Confirm Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Confirm Button is Disabled");
		}
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public void clickBackArrow() {
		new CommonFunctions().verifyCursorAction(backArrow, "Back Arrow");
		click(backArrow, "Back Arrow");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}
