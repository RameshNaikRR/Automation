package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TokenAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Token Account']");

	private By lblTotalAvailable = By.xpath("//span[text()='Total Available']");

	private By lblTokenAccountActivity = By.xpath("//span[text()='Token Account Activity (CYN)']");

	private By lblPayOutsReceived = By.xpath("//span[text()='Payouts Received']");

	private By lblSignetWithdraw = By.xpath("//span[text()='Signet Withdraws']");

	private By lnkWithdrawToSignet = By.xpath("//span[text()='Withdraw To Signet']");

	private By btnFilter = By.xpath("//button[text()='Filter']");

	private By btnExport = By.xpath("//button[text()='Export']");

	private By lblTransactions = By.xpath("//h2[text()='Transactions']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblHeading, "Heading", expHeading);
	}

	public String getTotalAvailable() {
		return getText(lblTotalAvailable, "Total Available");
	}

	public void verifyTokenAccountActivityView(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblTokenAccountActivity, "Token Account Activity", expHeading);
	}

	public String getPayOutsReceived() {
		return getText(lblPayOutsReceived, "Pay Outs");
	}

	public void clickWithdrawToSignet() {
		click(lnkWithdrawToSignet, "WithdrawToSignet");
	}

	public String getSignetWithdraw() {
		return getText(lblSignetWithdraw, "Signet Withdraw");
	}

	public void clickFilter() {
		click(btnFilter, "Filter");
	}

	public void clickExport() {
		click(btnExport, "Export");
	}

	public void verifyTransactionView(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblTransactions, "Transactions", expHeading);
	}
}
