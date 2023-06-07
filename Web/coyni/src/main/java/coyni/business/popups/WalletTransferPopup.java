package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WalletTransferPopup extends BrowserFunctions {

	private By lblWalletTransferHeading = By.xpath("");
	private By txtAmount = By.xpath("");
	private By lblAvailableBalance = By.xpath("");
	private By drpdwnSelectWallet = By.xpath("");
	private By txtNote = By.xpath("");
	private By btnNext = By.xpath("");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyWalletTransferHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWalletTransferHeading, "Wallet Transfer Heading is: ", expHeading);
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public String verifyAvailableBalance() {
		String availableBalance = getText(lblAvailableBalance, "Available Balance");
		ExtentTestManager.setInfoMessageInReport("Available Balance is: " + availableBalance);
		return availableBalance;
	}

	public void selectWallet() {
		new CommonFunctions().verifyCursorAction(drpdwnSelectWallet, "Select a wallet");
		click(drpdwnSelectWallet, "Select a wallet");
	}

	public void fillNote(String note) {
		enterText(txtNote, note, "Note");
	}

	public void clickNext() {
		new CommonFunctions().verifyCursorAction(btnNext, "Next");
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
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

	public WalletTransferSummaryPopup walletTransferSummaryPopup() {
		return new WalletTransferSummaryPopup();
	}

}
