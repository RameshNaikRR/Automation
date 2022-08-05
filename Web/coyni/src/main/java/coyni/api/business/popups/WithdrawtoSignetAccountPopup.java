package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawtoSignetAccountPopup extends BrowserFunctions {
	
	private By lblHeading = By.xpath("//h1[text()='Withdraw to Signet Account']");
	
	
	
	private By lnkAddNewSignetAccount = By.xpath("//span[text()='Add New Signet Account']");
	private By rdbtnBankAccount = By.xpath("(//input[@name='buy-token-radio'])[1]");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By txtAmount = By.xpath("//input[@name='amount']");
	private By lnkConverter = By.xpath("//button[@id='flip-button']");
	private By txtTransactionDesc = By.xpath("//label[text()='Transaction Description (Optional)']");
	private By lblErrMsg = By.xpath("//p[text()='Amount is required']");
	private By lblWithdrawAmount = By.xpath("//span[text()='Withdraw Amount']");
	private By lblProcessingFee = By.xpath("//span[text()='Processing Fee']");
	private By lblTotal = By.xpath("//span[text()='Total']");
	private By btnConfirm = By.xpath("//button[text()='Confirm']");
	private By iconDelete = By.xpath("(//button[@data-tip='Delete'])[1]");
	private By btnCross = By.xpath("//button[@class='self-end']");
	
	private By lblNote = By.xpath("//p[@class='mt-4 text-xs text-center text-cgy4'] ");
	
	public void clickDelete() {
		click(iconDelete, "delete");
	}
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading" , expHeading);
	}
	
	public void clickfirstSignet() {
		click(rdbtnBankAccount, "BankAccount");
	}
	public void clickAddNewSignetAccount() {
		click(lnkAddNewSignetAccount, "AddNewSignetAccoungt");
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
	public void fillAmount(String amount) {
		enterText(txtAmount, "amount", amount);
	}
	public void clickConverter() {
		click(lnkConverter, "Converter");
	}
	public void fillTransactionDesc(String desc) {
		enterText(txtTransactionDesc, "desc", desc);
	}
	public void verifyNote(String expNote) {
		new CommonFunctions().verifyLabelText(lblNote, "Note", expNote);
	}
	public void verifyWithdrawAmountView() {
		new CommonFunctions().elementView(lblWithdrawAmount, "WithdrawAmount");
	}
	public void verifyProcessingFeeView() {
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
	}
	public void verifyTotalView() {
		new CommonFunctions().elementView(lblTotal, "Total");
	}
	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}
	public void clickClose() {
		click(btnCross, "Close");
	}
	

}
