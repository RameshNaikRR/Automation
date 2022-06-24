package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.ExportComponent;
import coyni.admin.components.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PayOutIDPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[contains(text(),'Payout ID')]");

	private By lblPayOutDate = By.xpath("//span[contains(text(),'Payout Date:')]/following-sibling::*[1]");

	private By lblPayOutAmount = By.xpath("//span[contains(text(),'Payout Amount:')]/following-sibling::*[1]");

	private By lblTransactionReference = By
			.xpath("//span[contains(text(),'Transaction Reference ID:')]/following-sibling::*[1]");

	private By lblToTokenAccount = By.xpath("//span[contains(text(),'To Token Account:')]/following-sibling::*[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPayOutHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutDate, "Pay Out Date", expHeading);
	}

	public void getPayOutDate() {
		ExtentTestManager.setInfoMessageInReport("PayOut Date: " + getText(lblPayOutDate, "Payout Date"));
	}

	public void getPayOutAmount() {
		ExtentTestManager.setInfoMessageInReport("PayOut Amount: " + getText(lblPayOutAmount, "Payout Amount"));
	}
	
	public void getTransactionReference() {
		ExtentTestManager.setInfoMessageInReport("Transaction Reference: " + getText(lblTransactionReference, "Transaction Reference"));
	}
	
	public void getToTokenAccount() {
		ExtentTestManager.setInfoMessageInReport("To Token Account: " + getText(lblToTokenAccount, "To Token Account"));
	}

}
