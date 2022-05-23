package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawToBankAccountPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Withdraw to Bank Account']");
	private By lblchAccount = By.xpath("//h2[text()='Choose Your Payment Method:");
	private By rdbtnBankAccount = By.id("//input[@id='radio-BANK-128']");
	private By rdbtnBankAccount1 = By.id("//input[@id='radio-BANK-110']");
	private By lnkBnkAccount = By.xpath("");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By txtamount = By.xpath("");
	private By txtDescription = By.xpath("//textarea[@id='message']");
	private By wtdAmount = By.xpath("");
	private By processingfee = By.xpath("");
	private By total = By.xpath("");
	private By btnConfirm = By.xpath("");
	private By lnkAddNewBankAccount = By.xpath("//span[text()='Add New Bank Account']");

//	public void veriyHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
//	}
	public void verifyWithdrawToBankAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "heading", expHeading);
	}

	public void verifychooseAccount(String subHeading) {
		new CommonFunctions().verifyLabelText(lblchAccount, "Choose Account", subHeading);
	}

	public void verifyBankAccount(String BankAccount) {
		new CommonFunctions().verifyLabelText(rdbtnBankAccount, "Bank Account Name", BankAccount);
	}

	public void verifyBankAccount1(String BankAccount1) {
		new CommonFunctions().verifyLabelText(rdbtnBankAccount1, "Bank Account", BankAccount1);
	}
    public void clickAddNewBankAccount() {
    	click(lnkAddNewBankAccount, "Add New BankAccount");
    }
	public void clickNext() {
		click(btnNext, "Next");
	}

	public void fillAmount(String Amount) {
		enterText(txtamount, "Amount", Amount);
	}

	public void verifyDescription(String description) {
		new CommonFunctions().verifyLabelText(txtDescription, "Transaction Description", description);
	}

	public void verifyProcessingFee(String processingFee) {
		new CommonFunctions().verifyLabelText(processingfee, "processing Fee", processingFee);
	}

	public void verifyTotal(String total) {
		new CommonFunctions().verifyLabelText(txtamount, "Total", total);
	}

	public void clickConfirm() {
		click(btnConfirm, "Next");
	}
}