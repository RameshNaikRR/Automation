package coyni.admin.components;

import java.util.Random;

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
	private By txtTechnicalPhoneNumberdo = By.name("technicalPhone");
	private By btnAddVendor = By.xpath("//button[text()='Add Vendor']");
	private By btnAddVendors = By.xpath("(//button[text()='Add Vendor'])[2]");
	private By btnParticularVendor = By.xpath("(//div[contains(@class,'p-4 ')])[1]");

	public void clickParticularVendor() {
		click(btnParticularVendor, "Particular Vendor");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add New Vendor", expHeading);
	}

	public void fillVendorName() {
		enterText(txtVendorName, randomString(), "vendorName");
	}

	public String randomString() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

	public String generateEmail() {
		String email = randomString() + "@gmail.com";
		return email;

	}

	public void fillPrimaryEmail() {
		enterText(txtPrimaryEmail, generateEmail(), "primaryEmail");
	}

	public void fillTechnicalEmail() {
		enterText(txtTechnicalEmail, generateEmail(), "TechnicalEmail");
	}

	public void fillTechnicalPhoneNumber() {
		click(txtTechnicalPhoneNumberdo, "TechnicalPhoneNumber");
		enterText(txtTechnicalPhoneNumberdo, generateNumber(), "TechnicalPhoneNumber");
	}

	public void fillprimaryPhoneNumber() {
		enterText(txtPrimaryPhoneNumber, generateNumber(), "TechnicalPhoneNumber");
	}

	public String generateNumber() {
		Random random = new Random();
		int nextInt = random.nextInt(100000);
		String i = "630132" + String.valueOf(nextInt);
		return i;
	}

	public void clickAddVendor() {
		click(btnAddVendor, "AddVendor");
	}

	public void clickAddVendors() {
		click(btnAddVendors, "AddVendor");
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
