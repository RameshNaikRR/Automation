package coyni.apibusiness.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DBAInfoEditPage extends BrowserFunctions {
	private By txtDBAEmail = By.xpath("//input[@name='email']");
	private By txtphoneNumber = By.xpath("//input[@name='phoneNumber']");
	private By editIcon = By.xpath("//input[@id='Edit Phone Number']");
	private By editEmailIcon = By.xpath("//input[@id='Edit Email Address']");
	private By btnSave = By.xpath("//button[@type='submit']");
	private By lblDBAInformation = By.xpath("(//span[text()='DBA Information'])[2]");
	private By website = By.xpath("//div[@class='flex flex-row DbaInformation_sidecontainer__hoW+o'][1]");
	private By businessType = By.xpath("//div[@class='flex flex-row DbaInformation_sidecontainer__hoW+o'][2]");
	private By address = By.xpath("//div[@class='flex flex-row DbaInformation_sidecontainer__hoW+o'][3]");
	private By editImage = By.xpath("//img[@data-tip='Edit Image']");
	private By businessLogo = By.xpath("//h1[text()='Business Logo']");
	private By cross = By.xpath("//img[@src='/static/media/x.85c835f41baf2a064acc5c6ba4aa0e89.svg']");

	public void clickEditDBA() {
		moveToElement(editImage, "Edit Image");
		new CommonFunctions().verifyCursorAction(editImage, "Edit Image");
		String str = getElement(editImage, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(editImage, "EditDBAImage");
		new CommonFunctions().elementView(businessLogo, "Business Logo");
		String str1 = getElement(businessLogo, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str1);

	}

	public void clickCross() {
		new CommonFunctions().verifyCursorAction(cross, "Close");
		click(cross, "Close");
	}

	public void viewDBAEmail() {
		moveToElement(editEmailIcon, "Edit Email");
		new CommonFunctions().verifyCursorAction(editEmailIcon, "Edit Email");
		new CommonFunctions().elementView(txtDBAEmail, "Company Email");
	}

	public void fillCompanyEmail(String companyEmail) {
		enterText(txtDBAEmail, companyEmail, "Company Email");
	}

	public void viewPhoneNumber() {
		moveToElement(editIcon, "Edit Phone");
		new CommonFunctions().verifyCursorAction(editIcon, "Edit Phone");
		new CommonFunctions().elementView(txtphoneNumber, "PhoneNumber");
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtphoneNumber, phoneNumber, "Phone Number");
	}

	public void clickEditPhone() {
		click(editIcon, "Phone");
	}

	public void verifyHeading(String DBAInfo) {
		new CommonFunctions().verifyLabelText(lblDBAInformation, "Heading", DBAInfo);
		new CommonFunctions().verifyCursorAction(lblDBAInformation, DBAInfo);
		String str = getElement(lblDBAInformation, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifywebsiteInfo() {
		new CommonFunctions().elementView(website, "website");
	}

	public void verifybusinessTypeInfo() {
		new CommonFunctions().elementView(businessType, "BusinessType");
	}

	public void verifyAddressInfo() {
		new CommonFunctions().elementView(address, "Address");
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
