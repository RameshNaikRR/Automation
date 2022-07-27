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
			.xpath("//p[contains(text(),'Transaction Reference ID:')]/following-sibling::*[1]");

	private By lblPaidToTokenAccount = By
			.xpath("//p[contains(text(),'Paid to Token Account:')]/following-sibling::*[1]");

	private By lblReserveID = By.xpath("//p[contains(text(),'Reserve ID:')]/following-sibling::*[1]");

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
		ExtentTestManager.setInfoMessageInReport("PayOut Date: " + getText(lblPayOutDate, "Payout Date"));
	}

	public void getPayOutAmount() {
		ExtentTestManager.setInfoMessageInReport("PayOut Amount: " + getText(lblPayOutAmount, "Payout Amount"));
	}

	public void getTransactionReference() {
		ExtentTestManager.setInfoMessageInReport(
				"Transaction Reference: " + getText(lblTransactionReferenceID, "Transaction Reference"));
	}

	public void getToTokenAccount() {
		ExtentTestManager
				.setInfoMessageInReport("To Token Account: " + getText(lblPaidToTokenAccount, "Paid To Token Account"));
	}

	public void getReserveID() {
		ExtentTestManager.setInfoMessageInReport("To Token Account: " + getText(lblReserveID, "Reserve ID"));
	}

}
