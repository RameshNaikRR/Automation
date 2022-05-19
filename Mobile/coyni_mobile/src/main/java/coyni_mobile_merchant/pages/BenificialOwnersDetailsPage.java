package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BenificialOwnersDetailsPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Beneficial Owners')]");
	private By lblOwnerName = MobileBy.xpath("//*[contains(@resource-id,'owner_name')]");
	private By lblOwnerType = MobileBy.xpath("//*[contains(@text,'Primary Owner')]");
	private By lblOwnerShipPer = MobileBy.xpath("//*[contains(@resource-id,'percentage')]");
	private By lblOwnerShip = MobileBy.xpath("//*[contains(@resource-id,'tx_title')]");
	private By lblDetails = MobileBy.xpath("//*[contains(@text,'Details')]");
	private By lblDob = MobileBy.xpath("//*[contains(@text,'Date of Birth')]");
	private By lblMailingAddress = MobileBy.xpath("//*[contains(@text,'Mailing Address')]");
	private By lblSSN = MobileBy.xpath("//*[contains(@text,'SSN')]");
	private By lblDOBDetails = MobileBy.xpath("//*[contains(@resource-id,'dob_bo')]");
	private By lblMailingAddressDetails = MobileBy.xpath("//*[contains(@resource-id,'address_bo')]");
	private By lblSSNDetails = MobileBy.xpath("//*[contains(@resource-id,'ssn_bo')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().elementView(lblHeading, "Benificial Owner Heading");
		new CommonFunctions().verifyLabelText(lblHeading, "Benificial Owner Heading", expHeading);
	}

	public void verifyOwnerDetails(String expHeading) {
		new CommonFunctions().elementView(lblDetails, "Owner Details Heading");
		new CommonFunctions().verifyLabelText(lblDetails, "Owner Details Heading", expHeading);
	}

	public void verifyDOB(String expHeading) {
		new CommonFunctions().elementView(lblDob, "Date of Birth Heading");
		new CommonFunctions().verifyLabelText(lblDob, "Date of Birth Heading", expHeading);
	}

	public void verifyMailingAddress(String expHeading) {
		new CommonFunctions().elementView(lblMailingAddress, "lblMailing Address");
		new CommonFunctions().verifyLabelText(lblMailingAddress, "Mailing Address Heading", expHeading);
	}

	public void verifySSN(String expHeading) {
		new CommonFunctions().elementView(lblSSN, "SSN");
		new CommonFunctions().verifyLabelText(lblSSN, "SSN Heading", expHeading);
	}

	public void getOwnerName() {
		new CommonFunctions().elementView(lblOwnerName, "Owner Name");
		String str = getText(lblOwnerName);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getOwnerType() {
		new CommonFunctions().elementView(lblOwnerType, "Owner Type");
		String str = getText(lblOwnerType);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getOwnerShipPercentage() {
		new CommonFunctions().elementView(lblOwnerShipPer, "Owner Ship Percentage");
		String str = getText(lblOwnerShipPer);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getOwnerShip() {
		new CommonFunctions().elementView(lblOwnerShip, "Owner Ship");
		String str = getText(lblOwnerShip);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getSSNDetails() {
		new CommonFunctions().elementView(lblSSNDetails, "SSN Details");
		String str = getText(lblSSNDetails);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getDOBDetails() {
		new CommonFunctions().elementView(lblDOBDetails, "DOB Details");
		String str = getText(lblDOBDetails);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getMailingAddressDetails() {
		new CommonFunctions().elementView(lblMailingAddressDetails, "Mailing Address Details");
		String str = getText(lblMailingAddressDetails);
		ExtentTestManager.setInfoMessageInReport(str);
	}

}
