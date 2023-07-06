package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class B2BTransferPopup extends BrowserFunctions {

	private By lblB2BTransferHeading = By.xpath("");
	private By txtAmount = By.xpath("");
	private By lblAvailableBalance = By.xpath("");
	private By txtRecipientWalletNumber = By.xpath("");
	private By txtNote = By.xpath("");
	private By lnkUpload = By.xpath("");
	private By btnNext = By.xpath("");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyB2BTransferHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblB2BTransferHeading, "B2B Transfer Hedaing is: ", expHeading);
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public String verifyAvailableBalance() {
		String availableBalance = getText(lblAvailableBalance, "Available Balance");
		ExtentTestManager.setInfoMessageInReport("Available Balance is: " + availableBalance);
		return availableBalance;
	}

	public void fillRecipientWalletNumber(String recipientWalletNumber) {
		new CommonFunctions().verifyCursorAction(txtRecipientWalletNumber, "Recipient's Wallet Number");
		enterText(txtRecipientWalletNumber, recipientWalletNumber, "Recipient's Wallet Number");
	}

	public void fillNote(String note) {
		enterText(txtNote, note, "Note");
	}

	public void clickUpload() {
		new CommonFunctions().verifyCursorAction(lnkUpload, "Upload");
		click(lnkUpload, "Upload");
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

	public B2BTransferSummaryPopup b2bTransferSummaryPopup() {
		return new B2BTransferSummaryPopup();
	}

}
