package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RemoveBankAccountPopup extends BrowserFunctions {
	private By heading = By.xpath("");
	private By description = By.xpath("");
	private By bankAccount = By.xpath("");
	private By clickRemove = By.xpath("");
	private By clickback = By.xpath("");
	private By clickClose = By.xpath("");

	public void verifyHeading(String bankHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is :", bankHeading);
	}

	public void verifyDescription(String bankDesription) {
		new CommonFunctions().verifyLabelText(description, "Description is :", bankDesription);
	}

	public void getBankAccount() {
		String str = getText(bankAccount, "Bank Account");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void clickRemove() {
		click(clickRemove, "Remove");
	}

	public void clickBack() {
		click(clickback, "Back");
	}

	public void clickClose() {
		click(clickClose, "Close");
	}
}
