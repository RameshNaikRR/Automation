package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewBankAccountPopup extends BrowserFunctions {

	private By heading = By.xpath("");
	private By txtBankName = By.xpath("");
	private By txtRoutingNum = By.xpath("");
	private By txtConfirmRoutingNum = By.xpath("");
	private By txtAccountNum = By.xpath("");
	private By txtConfirmAccNum = By.xpath("");
	private By btnSave = By.xpath("");
	private By clickback = By.xpath("");
	private By clickClose = By.xpath("");

	public void VerifybankHeading(String bankHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is:", bankHeading);
	}

	public void verifyNameOnBank(String txtName) {
		enterText(txtBankName, "Name on Bank Account :", txtName);
	}

	public void verifyRoutingNum(String routingNum) {
		enterText(txtRoutingNum, "Routing Number:", routingNum);
	}

	public void verifyConfirmRoutingNum(String ConfirmRoutingNum) {
		enterText(txtConfirmRoutingNum, "Confirm Routing Num:", ConfirmRoutingNum);
	}

	public void verifyAccountNum(String accNum) {
		enterText(txtAccountNum, "Account Number :", accNum);
	}

	public void verifyConfirmAccountNum(String confirmAccNum) {
		enterText(txtConfirmAccNum, "Confirm Account Number :", confirmAccNum);
	}

	public void clickBack() {
		click(clickback, "Back");
	}

	public void clickClose() {
		click(clickClose, "Close");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}
}
