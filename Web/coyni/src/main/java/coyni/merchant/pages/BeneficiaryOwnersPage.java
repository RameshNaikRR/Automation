package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BeneficiaryOwnersPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Beneficiary Owner(s)']");
	private By lblBeneficiaryOwner1 = By
			.xpath("//summary[contains(@class,'BenificialOwnerAccordion')]/div/div[1]/p[1]");
	private By lblOwnerShip = By.xpath("//summary[contains(@class,'BenificialOwnerAccordion')]/div/div[2]/p[1]");
	private By lblOwnerName = By.xpath("//summary[contains(@class,'BenificialOwnerAccordion')]/div/div[1]/div/p");
	private By lblOwnerShipPercent = By.xpath("//summary[contains(@class,'BenificialOwnerAccordion')]/div/div[2]/p[2]");
	private By drpdwnBeneficiaryOwner = By.xpath("//button[contains(@class,'BenificialOwnerAccordion')]");
	private By lblStarMark = By.xpath("//img[contains(@class,'BenificialOwnerAccordion_star_icon__VCND6 ml-1.5')]");

	private By getSideLables(String Lables) {
		return By.xpath(String.format(
				"//div[contains(@class,'BenificialOwnerAccordion_benificialContainer')]//span[.='%s']", Lables));
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void verifyhandSymbolHighlightedBeneficialOwners(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("BeneficalOwners"), "BeneficalOwners");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "Beneficial Owners", cssProp, expValue,
				expColor);
	}

	public void verifyStarMark() {
		String mark = getText(lblStarMark, "Star Mark");
		ExtentTestManager.setInfoMessageInReport(mark + "  is displayed");

	}

	private By getBeneficialOwnerDetails(String details) {
		return By.xpath(String.format(
				"//div[contains(@class,'BenificialOwnerAccordion_benificialContainer')]//span[.='%s']/following-sibling::*[1]",
				details));
	}

	private By getAddressDetails(String AddressDetails) {
		return By.xpath(String.format(
				"//div[contains(@class,'BenificialOwnerAccordion_benificialContainer')]//span[.='Address']/following-sibling::*/span[%s]",
				AddressDetails));
	}

	CommonFunctions cf = new CommonFunctions();

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyBeneficiaryOwner1() {
		cf.elementView(lblBeneficiaryOwner1, "Beneficiary Owner 1 Label ");
	}

	public void verifyOwnerShip() {
		cf.elementView(lblOwnerShip, "OwnerShip Label ");
	}

	public void verifyOwnerName() {
		String ownerName = getText(lblOwnerName, "");
		ExtentTestManager.setInfoMessageInReport(ownerName + " Name is displayed");
	}

	public void verifyOwnerShipPercentage() {
		String ownerPercentage = getText(lblOwnerShipPercent, "");
		ExtentTestManager.setInfoMessageInReport(ownerPercentage + " percentage is displayed");
	}

	public void clickBeneficialOwnerDrpDwn() {
		click(drpdwnBeneficiaryOwner, "Beneficial Owner Drop Down ");
	}

	public void verifyBeneficialOwnernameLbl() {
		cf.elementView(getSideLables("Name"), "Name label ");
	}

	public void verifyDateOfBirthLbl() {
		cf.elementView(getSideLables("Date of Birth"), "Date of Birth label ");
	}

	public void verifySocialSecurityNumberLbl() {
		cf.elementView(getSideLables("Social Security Number"), "Social Security Number label ");
	}

	public void verifyOwnershipLbl() {
		cf.elementView(getSideLables("Ownership"), "Ownership label ");
	}

	public void verifyAddressLbl() {
		cf.elementView(getSideLables("Address"), "Address label ");
	}

	public void getOwnerName() {
		String name = getText(getBeneficialOwnerDetails("Name"), "");
		ExtentTestManager.setInfoMessageInReport(name + " is displayed");
	}

	public void getDateOfBirth() {
		String dob = getText(getBeneficialOwnerDetails("Date of Birth"), "");
		ExtentTestManager.setInfoMessageInReport(dob + "date of birth is displayed");
	}

	public void getSocialSecurityNumber() {
		String ssn = getText(getBeneficialOwnerDetails("Social Security Number"), "");
		ExtentTestManager.setInfoMessageInReport(ssn + "number is displayed");
	}

	public void getOwnerShip() {
		String ownership = getText(getBeneficialOwnerDetails("Ownership"), "");
		ExtentTestManager.setInfoMessageInReport(ownership + "number is displayed");
	}

//	public void getAddress(String Address) {
//		String text = getText(getBeneficialOwnerDetails("Address"), "");
//
//	}

	public void getAddressLine1() {
		String AddressLine1 = getText(getAddressDetails("1"), "");
		ExtentTestManager.setInfoMessageInReport("Address Line1 is : " + AddressLine1);
	}

	public void getAddressLine2() {
		String AddressLine2 = getText(getAddressDetails("2"), "");
		ExtentTestManager.setInfoMessageInReport("Address Line2 is : " + AddressLine2);
	}

	public void getState_City_Zipcode() {
		String State_City_Zipcode = getText(getAddressDetails("3"), "");
		ExtentTestManager.setInfoMessageInReport("State City And Zipcode is : " + State_City_Zipcode);
	}

	public void getCountry() {
		String Country = getText(getAddressDetails("4"), "");
		ExtentTestManager.setInfoMessageInReport("Country is : " + Country);
	}

}
