package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DepositFundsPopup extends BrowserFunctions {

	private By lblDepositFunds = By.xpath("");
	private By lblDes = By.xpath("");
	private By radioBtnBankAccount = By.xpath("");
	private By txtAmount = By.xpath("");
	private By btnDelete = By.xpath("");
	private By btnAddBankAccount = By.xpath("");
	private By crossClose = By.xpath("");
	private By btnNext = By.xpath("");
	private By lnkChange = By.xpath("");
	private By btnDone = By.xpath("");
	private By lnkViewTrnsaction = By.xpath("");

	public void verifyDepositFunds(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDepositFunds, "Heading is: ", expHeading);
	}

	public void verifyDepositFundsDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);
	}

	public void clickRadioButton() {
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
		if (getElement(btnAddBankAccount, "Next").isEnabled()) {
			click(btnAddBankAccount, "Add Bank Account");
		} else {
			ExtentTestManager.setPassMessageInReport("Already Bank Account added proceed with added bank account");
		}
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
		click(lnkViewTrnsaction, "View Transaction");
	}

	public DepositSummaryPopup depositSummaryPopup() {
		return new DepositSummaryPopup();
	}

	public TransactionFailedPopup transactionFailedPopup() {
		return new TransactionFailedPopup();
	}

}
