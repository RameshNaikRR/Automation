package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.MailingAddressComponent;
import coyni.merchant.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewCognetAccountPopup extends BrowserFunctions {

	public By lblHeading = By.xpath("//h1[text()='Add cogent Account']");
	public By txtName = By.xpath("//input[@name='name']");
	public By lnkPaste = By.xpath("//span[text()='Withdraw Amount']");
	public By txtCognetWalletID = By.xpath("//input[@name='walletId']");
	public By btnSave = By.xpath("//button[text()='Save']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add New signet Account Heading", expHeading);
	}

	public void fillName(String message) {
		enterText(txtName, message, "Name");
	}

	public void fillCognetWalletId(String walletID) {
		enterText(txtCognetWalletID, walletID, "walletID");
	}

	public void clickSave() {
		click(btnSave, "Click on Save");
	}

	public void clickPaste() {
		click(lnkPaste, "Click on Paste");
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public SuccessFailurePopupCardComponent successFailureComponent() {
		return new SuccessFailurePopupCardComponent();
	}

}
