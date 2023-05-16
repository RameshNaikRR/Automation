package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionDetailsComponents extends BrowserFunctions {

	private By lblTransDetails = By.xpath("");
	private By lblAmount = By.xpath("");

	public void verifyTransactionDeatils(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransDetails, "Transaction Details Heading is: ", expHeading);
	}

	public By getLabelItem(String Type) {
		return By.xpath(String.format(
				"//p[text()='%s']/following-sibling::div[1]/p  | //p[text()='%s']//following-sibling::span | //p[text()='%s']//following-sibling::p",
				Type, Type, Type));// | //p[text()='%s']//following-sibling::qqqspan
	}

	public void verifyReferenceID() {
		ExtentTestManager
				.setInfoMessageInReport("Reference ID  is " + getText(getLabelItem("Reference ID"), "Reference ID"));
	}

	public void verifyCordaID() {
		ExtentTestManager.setInfoMessageInReport("Corda ID  is " + getText(getLabelItem("Corda ID"), "Corda ID"));
	}

	public void verifyTransactionIPAddress() {
		ExtentTestManager.setInfoMessageInReport("Transaction IP Address  is "
				+ getText(getLabelItem("Transaction IP Address"), "Transaction IP Address"));
	}

	public String verifyAmount() {
		String transactionDetailsAmount = getText(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("The Amount is" + transactionDetailsAmount);
		return transactionDetailsAmount;
	}

}
