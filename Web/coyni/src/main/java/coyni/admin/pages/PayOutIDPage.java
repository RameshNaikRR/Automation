package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.ExportComponent;
import coyni.admin.components.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PayOutIDPage extends BrowserFunctions {

	private By lblCommission = By.xpath("//span[contains(@class,'text-lg font-bold text-right w-52 text-cgy4')]");

	private By lblHeading = By.xpath("//span[contains(text(),'Payout ID')]");

	private By lblPayOutDate = By.xpath("//span[contains(text(),'Payout Date:')]/following-sibling::*[1]");

	private By lblPayOutAmount = By.xpath("//span[contains(text(),'Payout Amount:')]/following-sibling::*[1]");
	private By lblvolume = By.xpath("//span[contains(@class,'text-lg font-bold text-right w-52 text-cgy4')]");
	private By lblTransactionReference = By
			.xpath("//span[contains(text(),'Transaction Reference ID:')]/following-sibling::*[1]");
	private By lblPayoutCommission = By.xpath("(//span[contains(@class,'text-xl font-bold text-cgy4')])[2]");
	private By lblTransactionCount = By.xpath("//span[contains(@class,'text-lg font-bold text-right w-52 text-cgy4')]");

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
		ExtentTestManager.setInfoMessageInReport(
				"Transaction Reference: " + getText(lblTransactionReference, "Transaction Reference"));
	}

	public void getToTokenAccount() {
		ExtentTestManager.setInfoMessageInReport("To Token Account: " + getText(lblToTokenAccount, "To Token Account"));
	}

	public void getTransactionCount() {
		String text = getText(lblTransactionCount, "Transaction Count");
		ExtentTestManager.setInfoMessageInReport("Total Transaction Count is " + text);
	}
	// span[contains(@class,'w-56 text-lg font-bold text-right text-cgy4')]

	public void getVolumeCount() {
		String text = getText(lblvolume, "Volume Processed");
		ExtentTestManager.setInfoMessageInReport("Volume Processed is " + text);
	}
	// span[contains(@class,'text-lg font-bold text-right w-44 text-cgy4')]

	public String getCommission() {
		String text = getText(lblCommission, "Total Commisssion");
		ExtentTestManager.setInfoMessageInReport("Total Commisssion is " + text);
		return text;
	}

	public String getPayoutCommission() {
		String text = getText(lblPayoutCommission, "Payout Commisssion");
		ExtentTestManager.setInfoMessageInReport("Payout Commisssion is " + text);
		return text;
	}
}
