package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddVendorComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Add New Vendor']");
	private By txtVendorName = By.id("vendorName");
	private By txtPrimaryEmail = By.id("primaryEmail");
	private By txtPrimaryPhoneNumber = By.id("primaryPhone");
	private By txtTechnicalEmail = By.id("technicalEmail");
	private By txtTechnicalPhoneNumber = By.id("technicalPhone");
	private By btnAddVendor = By.xpath("//button[text()='Add Vendor']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add New Vendor", expHeading);
	}

	public void fillVendorName(String name) {
		enterText(txtVendorName, name, "vendorName");
	}

	public void fillPrimaryEmail(String name) {
		enterText(txtPrimaryEmail, name, "primaryEmail");
	}

	public void fillTechnicalEmail(String name) {
		enterText(txtTechnicalEmail, name, "TechnicalEmail");
	}

	public void fillTechnicalPhoneNumber(String name) {
		enterText(txtTechnicalPhoneNumber, name, "TechnicalPhoneNumber");
	}

	public void fillprimaryPhoneNumber(String name) {
		enterText(txtPrimaryPhoneNumber, name, "TechnicalPhoneNumber");
	}

	public void clickAddVendor() {
		click(btnAddVendor, "AddVendor");
	}

}
