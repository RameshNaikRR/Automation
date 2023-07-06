package coyni.business.popups;

import org.openqa.selenium.By;


import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawToBankAccountPopup extends BrowserFunctions {

	private By lblWithdrawBankHeading = By.xpath("");
	private By radioBtnBankAccount = By.xpath("");
	private By txtAmount = By.xpath("");
	private By btnDelete = By.xpath("");
	private By btnAddBankAccount = By.xpath("");
	private By crossClose = By.xpath("");
	private By backArrow = By.xpath("");
	private By btnNext = By.xpath("");
	private By lnkChange = By.xpath("");
	private By txtNote = By.xpath("");
	private By iconRelink = By.xpath("");
	private By availableBalance = By.xpath("");

	public void verifyWithdrawBankAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawBankHeading, "Heading is: ", expHeading);
	}

	public void clickBankAccount() {
		new CommonFunctions().verifyCursorAction(radioBtnBankAccount, "Bank Account");
		click(radioBtnBankAccount, "Bank Account");
	}

	public void clickDeleteBankAccount() {
		new CommonFunctions().verifyCursorAction(btnDelete, "Delete");
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]")), "Delete Bank Account");
		click(btnDelete, "Delete Bank Account");
	}

	public void clickAddBankAccount() {
		new CommonFunctions().verifyCursorAction(btnAddBankAccount, "Add Bank Account");
		click(btnAddBankAccount, "Add Bank Account");
	}

	public void clickBackArrow() {
		new CommonFunctions().verifyCursorAction(backArrow, "Back Arrow");
		click(backArrow, "Back Arrow");
	}

	public void verifyAvailableBalance() {
		String str = getText(availableBalance, "Available Balance");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
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

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public void clickChange() {
		click(lnkChange, "Change");
	}

	public void fillNote(String note) {
		enterText(txtNote, note, "Note");
	}

	public void clickRelink() {
		click(iconRelink, "Relink");
	}

	public WithdrawSummaryPopup withdrawSummaryPopup() {
		return new WithdrawSummaryPopup();
	}

}
