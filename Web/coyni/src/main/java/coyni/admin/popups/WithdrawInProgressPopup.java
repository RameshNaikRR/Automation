package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawInProgressPopup extends BrowserFunctions {

	private By heading = By.xpath("");
	private By description = By.xpath("");
	private By requestSent = By.xpath("");
	private By depositMessage = By.xpath("");
	private By status = By.xpath("");
	private By withdrawlMessage = By.xpath("");
	private By cogentAccount = By.xpath("");
	private By clickDone = By.xpath("");
	private By lnkViewTransaction = By.xpath("");
	

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is:", Heading);
	}

	public void verifydescription(String Description) {
		new CommonFunctions().verifyLabelText(description, "Description is :", Description);
	}

	public void getRequestMessage() {
		String str = getText(requestSent, "Request Message");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getDepositMessage() {
		String str = getText(depositMessage, "Deposit Message");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getStatus() {
		String str = getText(status, "Status");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getWithdrawlMessage() {
		String str = getText(withdrawlMessage, "Withdrawl");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getCogentAccount() {
		String str = getText(cogentAccount, "Cogent Account");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void clickDone() {
		click(clickDone, "Done");
		String str = getElement(clickDone, "").getCssValue("Done");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void clickViewTransaction() {
		click(lnkViewTransaction, "View Transactions");
		String str = getElement(lnkViewTransaction, "").getCssValue("View Transactions");
		ExtentTestManager.setPassMessageInReport(str);
	}

}
