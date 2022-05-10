package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.SuccessFailureComponent;
import coyni.customer.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewSignetAccountPopup extends BrowserFunctions {
	public By lblHeading = By.xpath("//h1[text()='Add New Signet Account']");
	public By txtName = By.xpath("//input[@name='name']");
	public By lnkPaste = By.xpath("//span[text()='Withdraw Amount']");
	public By txtSignetWalletID = By.xpath("//input[@name='walletId']");
	public By btnSave = By.xpath("//button[text()='Save']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add New signet Account Heading", expHeading);
	}

	public void fillName(String message) {
		enterText(txtName, message, "Name");
	}

	public void fillSignetWalletId(String walletID) {
		enterText(txtSignetWalletID, walletID, "walletID");
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

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

}
