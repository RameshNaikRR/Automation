package coyni.apibusiness.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CompanyInfoEditPage extends BrowserFunctions {
	private By lblCompanyInfo = By
			.xpath("//div[@class='flex flex-row sm:space-x-5 CompanyInformation_sidecontainer__rKNkN'][1]");
	private By txtCompanyEmail = By.xpath("//input[@name='email']");
	private By txtphoneNumber = By.xpath("//input[@name='phoneNumber']");
	private By editIcon = By.xpath("//input[@id='Edit Phone Number']");
	private By editEmailIcon = By.xpath("//input[@id='Edit Email Address']");
	private By lblAddress = By
			.xpath("//div[@class='flex flex-row sm:space-x-5 CompanyInformation_sidecontainer__rKNkN'][2]");
	private By btnSave = By.xpath("//button[@type='submit']");
	private By lblCompanyInformation = By.xpath("(//span[text()='Company Information'])[2]");

	public void viewCompanyEmail() {
		new CommonFunctions().elementView(txtCompanyEmail, "Company Email");
	}

	public void fillCompanyEmail(String companyEmail) {
		enterText(txtCompanyEmail, companyEmail, "Company Email");
	}

	public void viewPhoneNumber() {
		new CommonFunctions().elementView(txtphoneNumber, "PhoneNumber");
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtphoneNumber, phoneNumber, "Phone Number");
	}

	public void clickEditPhone() {
		click(editIcon, "Phone");
	}

	public void verifyAddress() {
		new CommonFunctions().elementView(lblAddress, "Address");
	}

	public void verifyHeading(String companyInfo) {
		new CommonFunctions().verifyLabelText(lblCompanyInformation, "Heading", companyInfo);
	}

	public void verifyCompanyInfo() {
		new CommonFunctions().elementView(lblCompanyInfo, "CompanyInfo");
	}

	public void clickEditEmail() {
		click(editEmailIcon, "Phone");
	}

	public void clickSaveEnabled() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is in disabled mode");
		}
	}

	public void clickTab() throws AWTException {
		new CommonFunctions().clickTab();
	}

}