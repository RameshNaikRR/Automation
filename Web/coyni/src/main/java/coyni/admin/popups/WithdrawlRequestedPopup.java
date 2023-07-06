package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawlRequestedPopup extends BrowserFunctions {

	private By heading = By.xpath("");
	private By description = By.xpath("");
	private By status = By.xpath("");
	private By withdrawlAmount = By.xpath("");
	private By bankAccount = By.xpath("");
	private By msg = By.xpath("");
	private By clickDone = By.xpath("");
	private By lnkViewTransaction = By.xpath("");
	private By clickClose=By.xpath("");

	public void verifyHeading(String bankHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is :", bankHeading);
	}

	public void verifyDescription(String bankDesription) {
		new CommonFunctions().verifyLabelText(description, "Description is :", bankDesription);
	}

	public void getStatus() {
		String str = getText(status, "Status");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getWithdrawlAmount() {
		String str = getText(withdrawlAmount, "Withdrawl Amount");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getBankAccountDetails() {
		String str = getText(bankAccount, "Bank Account");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void message(String message) {
		new CommonFunctions().verifyLabelText(msg, "Message is :", message);
	}

	public void clickDone() {
		click(clickDone, "Done");
	}

	public void viewTransaction() {
		click(lnkViewTransaction, "View Transaction");
	}
	public void clickClose() {
		click(clickClose, "Close");
	}
}
