package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ContactInformation extends BrowserFunctions {
	private By heading = By.xpath("");
	private By viewBeneficailOwner = By.xpath("");
	private By viewbusinessContact = By.xpath("");
	private By editEmail = By.xpath("");
	private By editName = By.xpath("");

	public void verifyHeading(String benefecialOwnerHeading) {
		new CommonFunctions().verifyLabelText(heading, benefecialOwnerHeading, "Heading is");
	}

	public void viewAuthorizedSigners() {
		String getData = getText(viewBeneficailOwner, "Authorized Signers");
		ExtentTestManager.setPassMessageInReport(getData);
	}

	public void viewBusinessContacts() {
		String getData = getText(viewbusinessContact, "Business Contacts");
		ExtentTestManager.setPassMessageInReport(getData);
	}

	public void verifyEditEmail(String email) {
		click(editEmail, "Edit Email");
		enterText(editEmail, "Edit  Email", email);
	}
	public void verifyEditName(String name) {
		click(editName, "Edit Name");
		enterText(editName, "Edit Name", name);
	}
}
