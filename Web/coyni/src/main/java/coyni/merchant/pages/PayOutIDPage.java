package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.admin.components.ExportComponent;
import coyni.admin.components.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PayOutIDPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[contains(text(),'Payout ID')]");

	private By lblPayOutDate = By.xpath("//p[contains(text(),'Payout Date:')]/following-sibling::*[1]");

	private By lblPayOutAmount = By.xpath("//h3[contains(text(),'Payout Amount')]/following-sibling::*[1]");

	private By lblTransactionReferenceID = By
			.xpath("//p[contains(text(),'Transaction Reference ID:')]/following-sibling::*[1]/p");

	private By lblPaidToTokenAccount = By
			.xpath("//p[contains(text(),'Paid to Token Account:')]/following-sibling::*[1]/p");

	private By lblReserveID = By.xpath("//p[contains(text(),'Reserve ID:')]/following-sibling::*[1]/p");

	private By btnDownloadPDF = By.xpath("//div[contains(text(),'Download PDF')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPayOutHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutDate, "Pay Out Date", expHeading);
	}

	public void verifyDownloadPDF() {
		new CommonFunctions().elementView(btnDownloadPDF, "Download PDF");

	}

	public void getPayOutDate() {
		String payout = getText(lblPayOutDate, "Payout Date");
		ExtentTestManager.setInfoMessageInReport("PayOut Date: " + payout);
	}

	public void getPayOutAmount() {
		String payoutAmount = getText(lblPayOutAmount, "Payout Amount");
		ExtentTestManager.setInfoMessageInReport("PayOut Amount: " + payoutAmount);
	}

	public void getTransactionReference() {
		String reference = getText(lblTransactionReferenceID, "Transaction Reference");
		ExtentTestManager.setInfoMessageInReport("Transaction Reference: " + reference);
	}

	public void getToTokenAccount() {
		String tokenAccount = getText(lblPaidToTokenAccount, "Paid To Token Account");
		ExtentTestManager.setInfoMessageInReport("To Token Account: " + tokenAccount);
	}

	public void getReserveID() {
		String reserveID = getText(lblReserveID, "Reserve ID");
		ExtentTestManager.setInfoMessageInReport("To Token Account: " + reserveID);
	}
}
