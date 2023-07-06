package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.business.components.MailingAddressComponent;
import ilabs.WebFramework.BrowserFunctions;

public class RegistrationDBAPage extends BrowserFunctions {

	private By txtDBAName = By.xpath("//input[@id='dba-name']");
	private By checkbox = By.xpath("");

	public void fillDBAName(String dbaName) {
		enterText(txtDBAName, dbaName, "DBA Name");
	}

	public void clickCheckBox() {
		click(checkbox, "Checkbox");
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

}
