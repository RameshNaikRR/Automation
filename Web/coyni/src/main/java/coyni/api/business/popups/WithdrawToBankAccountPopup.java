package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawToBankAccountPopup extends BrowserFunctions {

	public By lblHeading = By.xpath("//h1[text()='Withdraw to Bank Account']");
	public By lblchAccount = By.xpath("//h2[text()='Choose Your Payment Method:");
	public By rdbtnBankAccount = By.id("//input[@id='radio-BANK-128']");
	public By rdbtnBankAccount1 = By.id("//input[@id='radio-BANK-110']");
	public By lnkBnkAccount = By.xpath("");
	public By btnNext = By.xpath("//button[text()='Next']");
	public By txtamount = By.xpath("");
	public By txtDescription = By.xpath("//textarea[@id='message']");
	public By wtdAmount = By.xpath("");
	public By processingfee = By.xpath("");
	public By total = By.xpath("");
	public By btnConfirm = By.xpath("");

	public void veriyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
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