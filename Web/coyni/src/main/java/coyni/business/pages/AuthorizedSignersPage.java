package coyni.business.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.business.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class AuthorizedSignersPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[@data-ui-auto='authorized_signer']");
	private By lblDes = By.xpath("//p[@data-ui-auto='please_add_all_beneficial_owners']");
	private By btnBeneficialOwners = By.xpath("");
	private By btnControlProng = By.xpath("");
	private By lnkBack = By.xpath("//button[@data-ui-auto='back_button']");
	private By lnkExit = By.xpath("//button[@data-ui-auto='exit']");
	private By lnkControlProng = By.xpath("");
	private By txtBeneficialOwners = By.xpath("//span[@data-ui-auto='Beneficial_Owner']");
	private By txtFirstName = By.xpath("//input[@data-ui-auto='first_name']");
	private By txtLastName = By.xpath("//input[@data-ui-auto='last_name']");
	private By txtDateofBirth = By.xpath("//input[@data-ui-auto='date_Of_Birth']");
	private By txtSSN = By.xpath("//input[@data-ui-auto='ssn_last_4']");
	private By txtOwnership = By.xpath("//input[@data-ui-auto='ownership_%']");
	private By txtEmailAddress = By.xpath("//input[@data-ui-auto='email']");
	private By txtPhoneNumber = By.xpath("//input[@data-ui_auto='phon_number']");
	private By txtMailingAddressLine1 = By.xpath("//input[@data-ui-auto='mailing_address_Line_1']");
	private By txtMailingAddressLine2 = By.xpath("//input[@data-ui-auto='mailing_address_Line_2']");
	private By txtCity = By.xpath("//input[@data-ui-auto='city']");
	private By drpDwnState = By.xpath("//div[text()='State']/parent::div");
//	private By radioBtnDriversLicense = By.xpath("");
//	private By radioBtnStateIssuedId = By.xpath("");
	private By radioIdentificaton = By.xpath("//p[starts-with(.,'Select')]/following-sibling::div/label/input");
	private By getUploadDocumentElement = By
			.xpath(String.format("//div[@class='flex items-center justify-center']/../input"));
//	private By radioPassport = By.xpath("");
	private By lnkAddAdditionalBeneficialOwners = By.xpath("//button[@data-ui-auto='add_additional_beneficial_owner']");
	private By btnSelectAnIdentificationType = By.cssSelector("");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By btnNext = By.xpath("//button[@data-ui-auto='next_button']");
	private By drpdwnBeneficialOwner1 = By.xpath("");
	private By drpdwnPrimaryContact = By.xpath(
			"//div[contains(@class,'FormField_form_select__xDxV1')]//div[contains(text(),'Select your Primary Contact')]");
	private By selectionPrimaryTechnicalFinancialContact = By
			.xpath("//span[@data-ui-auto='Beneficiary: Manikanth Reddy']");
	private By drpdwnTechnicalContact = By.xpath(
			"//div[contains(@class,'FormField_form_select__xDxV1')]//div[contains(text(),'Select your Technical Contact')]");
	private By drpdwnFinancialorBillingContact = By.xpath(
			"//div[contains(@class,'FormField_form_select__xDxV1')]//div[contains(text(),'Select your Financial/Billing Contact')]");

	public void verifyHeading(String expHedaing) {
		new CommonFunctions().verifyLabelText(lblHeading, "Hedaing is: ", expHedaing);
	}

	public void verifyDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);

	}

	public void clickPrmaryContact() throws Exception {
		Thread.sleep(3000);
		click(drpdwnPrimaryContact, "Primary Contact");
		// click(ddAssignTerminalLocationDD, "select Terminal");
		click(selectionPrimaryTechnicalFinancialContact, "Primary Contact");
	}

	public void clickTechnicalContact() throws Exception {
		Thread.sleep(3000);
		click(drpdwnTechnicalContact, "Technical Contact");
		// click(ddAssignTerminalLocationDD, "select Terminal");
		click(selectionPrimaryTechnicalFinancialContact, "Primary Contact");
	}

	public void clickFinancialContact() throws Exception {
		Thread.sleep(3000);
		click(drpdwnFinancialorBillingContact, "Financial Contact");
		// click(ddAssignTerminalLocationDD, "select Terminal");
		click(selectionPrimaryTechnicalFinancialContact, "Primary Contact");
	}

	public void selectID() {
		List<WebElement> list = getElementsList(radioIdentificaton, "");
		list.get(0).click();
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
		click(txtBeneficialOwners, "Beneficial Owners");
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

//	public void clickDriversLicense() {
//		click(radioBtnDriversLicense, "Driver's License");
//	}
//
//	public void clickStateissuedID() {
//		click(radioBtnStateIssuedId, "State-Issued ID");
//	}

//	public void clickPassport() {
//		click(radioPassport, "Passport");
//	}

	public void uploadSelectImage(String folderName, String fileName) {
		getElement(getUploadDocumentElement, "select Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
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

	public void selectState(String state) {
		click(drpDwnState, "State DropDown");
		By stateName = By.xpath(String.format("(//*[text()='%s'])[1]", state));
		click(stateName, state);
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

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage() {
		return new RegistrationBeneficialOwnersPage();
	}
//	public DocumentUploadPage documentUploadPage() {
//		return new DocumentUploadPage();
//	}
}
