package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DBAInfoEditPage extends BrowserFunctions {
	private By txtCompanyEmail = By.xpath("//input[@name='email']");
	private By txtphoneNumber = By.xpath("//input[@name='phoneNumber']");
	private By editIcon = By.xpath("//input[@id='Edit Phone Number']");
	private By editEmailIcon = By.xpath("//input[@id='Edit Email Address']");
	private By btnSave = By.xpath("//button[@type='submit']");

	public void fillCompanyEmail(String companyName) {
		new CommonFunctions().elementView(txtCompanyEmail, "CompanyName");
		enterText(txtCompanyEmail, companyName, "Company Name");
	}

	public void fillPhoneNumber(String phoneNumber) {
		new CommonFunctions().elementView(txtphoneNumber, "PhoneNumber");
		enterText(txtphoneNumber, phoneNumber, "Phone Number");
	}

	public void clickEditPhone() {
		click(editIcon, "Phone");
	}

	public void clickEditEmail() {
		click(editEmailIcon, "Phone");
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is in disabled mode");
		}
	}

}