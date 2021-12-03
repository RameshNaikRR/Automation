package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SuccessFailurePopupCardComponent extends BrowserFunctions {

	private By imgSuccessFailure = By.cssSelector("");
	private By lblTransactionSuccessful = By.xpath("");

	private By lblMessage = By.className("SendReceiveModal_Pay_text__1SSJw");

	private By btnDone = By.xpath("//button[text()='Done']");

	private By heading = By.xpath("//h1[text()='Pre-Authorization Failed']");
	private By btnClose = By.xpath("//button[text()='Close']");
	private By btnAddBankAccount = By.xpath("//button[text()='Add Bank Account']");

	// DOUBT
	public void verifyImage(String expImage) {
		new CommonFunctions().verifyLabelText(imgSuccessFailure, "expImage", expImage);
	}

	public void verifyMessge(String expMessage) {
		new CommonFunctions().verifyLabelText(lblMessage, "Message", expMessage);
	}

	public void clickDone() {
		click(btnDone, "Click Done");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Autentication Heading", expHeading);
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void verifyAddBankAccountview() {
		new CommonFunctions().elementView(btnAddBankAccount, "AddBankAccount");

	}

	public void verifyheadingview() {
		new CommonFunctions().elementView(heading, "heading");

	}
}
