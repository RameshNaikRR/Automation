package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BankAccountsComponent extends BrowserFunctions {

	private By lblAccountNumber = By.cssSelector("");

	private By lblHeading = By.xpath("//h1[text()='Withdraw to Bank Account']");

	private By txtAmount = By.id("amount");

	private By btnRadio = By.id("radio-BANK-1059");

	private By btnDelete = By.xpath("//img[@class='cursor-pointer']");

	private By btnToggle = By.xpath("//div[@class='relative mt-12']//img[1]");

	private By lblAvalibleBalance = By.xpath("//span[text()='Available Balance:']");

	private By txtMessage = By.id("message");

	private By lblMSG = By.xpath("//p[text()='Please allow 3-5 business days to process this transaction.']");

	private By btnNext = By.xpath("//button[text()='Next']");

	private By btnConfirm = By.xpath("//button[text()='Confirm']");

	private By lblRemove = By.xpath("//h1[text()='Remove Payment Method']");
	private By lblRemoveSuccessHeadind = By.xpath("//h1[text()='Payment Method Removed Successfully']");

	private By btnWithdrawn = By.xpath("//button[text()='Withdraw Coyni']");

	public void removeHeading(String ecpHeading) {
		new CommonFunctions().verifyLabelText(lblRemoveSuccessHeadind, "Remove Heading", ecpHeading);
	}

	public void clickWithdrawCoyni() {
		click(btnWithdrawn, "Withdraw Coyn");
	}

	public void verifyRemoveHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblRemove, "Remove Payment Method", expHeading);
	}

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}

	public void clickRemove() {
		click(btnRemove, "Remove");
	}

	private By btnRemove = By.xpath("//button[text()='Remove']");

	private By lblSuccess = By.xpath("//h1[text()='Transaction In Progress']");

	private By lnkCopy = By.cssSelector(".icon-copy");
	private By btnDone = By.cssSelector(".w-60");

	private By lblBankName = By.cssSelector("");

	private By lblAddress = By.cssSelector("");

	private By iconDelete = By.cssSelector("");

	private By iconRelink = By.cssSelector("");

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public void clickDelete() {
		click(btnDelete, "Delete");
	}

	public void clickRadio() {
		click(btnRadio, "Radio Button");
	}

	public void clickCopy() {
		click(lnkCopy, "Copy");
	}

	public void clickToggle() {
		click(btnToggle, "Toggle");
	}

	public void verifyAvalibleBalance() {
		String str = getText(lblAvalibleBalance, "Availble Balance");
        ExtentTestManager.setPassMessageInReport(str);		
	}

	public void fillMessage(String message) {
		enterText(txtMessage, message, "Message");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void ClickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
		}
		ExtentTestManager.setInfoMessageInReport("Next Button is disable");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Withdraw to Bank Account", expHeading);
	}

	public void verifySuccessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSuccess, "Transaction in Progress", expHeading);
	}

	public void verifyAccountNumber(String last4digits) {
		new CommonFunctions().verifyLabelText(lblAccountNumber, "Last 4 Digits", last4digits);
	}

	public void verifyBankName(String bankName) {
		new CommonFunctions().verifyLabelText(lblBankName, "Bank Name", bankName);
	}

	public void verifyAddress(String address) {
		new CommonFunctions().verifyLabelText(lblAddress, "Address", address);
	}

//	public void clickDelete(String accNumber) {
//		click(iconDelete, "Delete icon");
//	}

	public void verifyMsg(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMSG, "Please allow 3-5 business days to process this transaction.",
				expHeading);
	}

	public void clickRelink(String accNumber) {
		click(iconRelink, "Relink icon");
	}

	public By getPaymentItems(String last4digits) {
		return By.xpath(String.format("//p[contains(text(),'%s')]", last4digits));
	}

	public void clickOnBank(String last4Digits) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", last4Digits)), "Bank");
		click(By.xpath(String.format("//p[contains(text(),'%s')]", last4Digits)), last4Digits);
		ExtentTestManager.setInfoMessageInReport(" clicked on Bank " + (last4Digits));
	}

	public void clickOnDelete(String last4Digits) {
		moveToElement(By.xpath(String
				.format("//p[contains(text(),'%s')]/following-sibling::button[@data-tip=\"Delete\"]", last4Digits)),
				"Delete Bank");
		click(By.xpath(String.format("//p[contains(text(),'%s')]/following-sibling::button[@data-tip=\"Delete\"]",
				last4Digits)), last4Digits);
		ExtentTestManager.setInfoMessageInReport("Clicked on delete Icon " + (last4Digits));
	}

	public void clickDelete(String last4Digits) {
		moveToElement(By.xpath(String
				.format("//span[contains(text(),'%s')]//following::img[@class='cursor-pointer']", last4Digits)),
				"Delete Bank");
		click(By.xpath(String.format("//span[contains(text(),'%s')]//following::img[@class='cursor-pointer']",
				last4Digits)), last4Digits);
		ExtentTestManager.setInfoMessageInReport("Clicked on delete Icon " + (last4Digits));
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
