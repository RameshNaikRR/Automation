package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.customer.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewSignetAccountPopup extends BrowserFunctions {
	public By lblHeading = By.xpath("//label[text()='Name On Signet Account']");
	public By txtName = By.xpath("//input[@id='name-on-signet']");
	public By lnkPaste = By.xpath("//span[text()='Withdraw Amount']");
	public By txtSignetWalletID = By.xpath("//input[@id='wallet-id']");
	public By btnSave = By.xpath("//button[text()='Save']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add New signet Account Heading", expHeading);
	}

	public void fillName(String message) {
		new CommonFunctions().verifyLabelText(txtName, message, "Name");
	}

	public void fillSignetWalletId(String walletID) {
		new CommonFunctions().verifyLabelText(txtSignetWalletID, walletID, "walletID");
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

}
