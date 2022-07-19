package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.customer.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddNewSignetAccountPopup extends BrowserFunctions {
	public By lblHeading = By.xpath("//label[text()='Name On Signet Account']");
	public By txtName = By.xpath("//input[@id='name-on-signet']");
	public By lnkPaste = By.xpath("//span[text()='Withdraw Amount']");
	public By txtSignetWalletID = By.xpath("//input[@id='wallet-id']");
	public By btnSave = By.xpath("//button[text()='Save']");
	public By lblAddSignet = By.xpath("//h1[text()='Add New Signet Account']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddSignet, "Add New signet Account Heading", expHeading);
	}

	public void fillName(String message) {
		enterText(txtName, message, "Name");
	}

	public void fillSignetWalletId(String walletID) {
		enterText(txtSignetWalletID, walletID, "walletID");
	}

	public void clickSave() {
		if (getElement(btnSave, "save").isEnabled()) {

			click(btnSave, "Click on Save");
		} else {
			ExtentTestManager.setInfoMessageInReport("Save button is disble");
		}
	}

	public void clickPaste() {
		click(lnkPaste, "Click on Paste");
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

}
