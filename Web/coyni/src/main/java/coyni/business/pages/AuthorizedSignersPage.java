package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AuthorizedSignersPage extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lblDes = By.xpath("");
	private By btnBeneficialOwners = By.xpath("");
	private By btnControlProng = By.xpath("");
	private By lnkBack = By.xpath("");
	private By lnkExit = By.xpath("");
	private By lnkControlProng = By.xpath("");
	private By lnkBeneficialOwners = By.xpath("");
	private By txtFirstName = By.xpath("");
	private By txtLastName = By.xpath("");
	private By txtDateofBirth = By.xpath("");
	private By txtSSN = By.xpath("");
	private By txtOwnership = By.xpath("");
	private By txtEmailAddress = By.xpath("");
	private By txtPhoneNumber = By.xpath("");
	private By radioBtnDriversLicense = By.xpath("");
	private By radioBtnStateIssuedId = By.xpath("");
	private By radioPassport = By.xpath("");
	private By lnkAddAdditionalBeneficialOwners = By.xpath("");
	private By btnSelectAnIdentificationType = By.cssSelector("");
	private By btnSave = By.xpath("");
	private By btnNext = By.xpath("");
	private By drpdwnBeneficialOwner1 = By.xpath("");
	private By drpdwnPrimaryContact = By.xpath("");
	private By drpdwnTechnicalContact = By.xpath("");
	private By drpdwnFinancialorBillingContact = By.xpath("");

	public void verifyHedaing(String expHedaing) {
		new CommonFunctions().verifyLabelText(lblHeading, "Hedaing is: ", expHedaing);
	}

	public void verifyDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);

	}

	public void clickBeneficialOwners() {
		click(btnBeneficialOwners, "Beneficial Owners");
	}

	public void clickControlProng() {
		click(btnControlProng, "Control Prong");
	}

	public void clickBack() {
		click(lnkBack, "Back");
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}

	public void clickControlProngLink() {
		click(lnkControlProng, "Control Prong");
	}

	public void clickBeneficialOwnersLink() {
		click(lnkBeneficialOwners, "Beneficial Owners");
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "First Name");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "Last Name");
	}

	public void fillDateofBirth(String dateOfBirth) {
		enterText(txtDateofBirth, dateOfBirth, "Date of Birth");
	}

	public void fillSSNLast4(String ssnLast4) {
		enterText(txtSSN, ssnLast4, "SSN Last 4");
	}

	public void fillOwnership(String ownerShip) {
		enterText(txtOwnership, ownerShip, "Ownership");
	}

	public void fillEmailAddress(String emailAddress) {
		enterText(txtEmailAddress, emailAddress, "Email Address");
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtPhoneNumber, phoneNumber, "Phone Number");
	}

	public void clickDriversLicense() {
		click(radioBtnDriversLicense, "Driver's License");
	}

	public void clickStateissuedID() {
		click(radioBtnStateIssuedId, "State-Issued ID");
	}

	public void clickPassport() {
		click(radioPassport, "Passport");
	}

	public void clickAddAdditionalBeneficialOwner() {
		click(lnkAddAdditionalBeneficialOwners, "Add Additional Beneficial Owner");
	}

	public void clickSelectAnIdentificationType() {
		click(btnSelectAnIdentificationType, "Select An Identification Type");
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setPassMessageInReport("Save Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Save Button is Disabled");
		}
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

	public void selectBeneficialOwner1(String beneficialOwner1) {
		click(drpdwnBeneficialOwner1, "Beneficial Owner 1");
//	    click(getElement(drpdwnBeneficialOwner1, "Beneficial Owner 1"), beneficialOwner1);	
	}

	public void selectPrimaryContact() {
		click(drpdwnPrimaryContact, "Select your Primary Contact");
	}

	public void selectTechnicalContact() {
		click(drpdwnTechnicalContact, "Select your Technical Contact");
	}

	public void selectFinancialorBillingContact() {
		click(drpdwnFinancialorBillingContact, "Select your Financial/Billing Contact");
	}
	public DocumentUploadPage documentUploadPage() {
		return new DocumentUploadPage();
	}
}
