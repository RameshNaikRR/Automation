package coyni.business.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.business.components.AddBeneficialOwnersComponent;
import coyni.business.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class RegistrationBeneficialOwnersPage extends BrowserFunctions {

	private By lblBeneficialOwners = By.xpath("");
	private By BeneficialOwnersDesc = By.xpath("");
	private By lblUploadDocumentsHdg = By.xpath("");
	private By lblSelectIdentification = By.xpath("");
	private By lnkSelectAnIdentificationType = By.xpath("");
	private By drpDownState = By.xpath("//div[text()='State']/parent::div");
	private By btnSave = By.xpath("");
	private By lnkAddBtn = By.xpath("");
	private By btnBack = By.xpath("");
	private By btnNext = By.xpath("");
	private By lnkExit = By.xpath("");
	private By lblPrimaryContact = By.xpath("");
	private By drpDownContact = By.xpath("");
	private By firstName = By.xpath("");
	private By lastName = By.xpath("");
	private By emailAddress = By.xpath("");
	private By phoneNumber = By.xpath("");
	private By txtDateOfBirth = By.name("dateOfBirth");
	private By lblTechnicalContact = By.xpath("");
	private By lblFinancialBilling = By.xpath("");
	private By lnkUploadImg = By.xpath(
			"(//div[contains(@class,'BeneficialOwners_owners_wrap')]/details)[1]//p[text()='Select Identification to Upload:']/../following-sibling::*[1]/input");
	private By lblBeneficialOwner1 = By.xpath("(//summary[contains(@class,'BeneficialOwners_summary')])[1]//p");

	private By getUploadDocument(String num) {
		return By.xpath(String.format(
				"(//div[contains(@class,'BeneficialOwners_owners_wrap')]/details)[%s]//p[text()='Select Identification to Upload:']/../following-sibling::*[1]/input",
				num));
	}

	private By getBeneficialOwnerLabel(String num) {
		return By.xpath(String.format("((//summary[contains(@class,'BeneficialOwners_summary')])[%s]//p)[1]", num));
	}

	private By getBeneficialOwnerName(String num) {
		return By.xpath(String.format("((//summary[contains(@class,'BeneficialOwners_summary')])[%s]//p)[2]", num));
	}

	private By getOwnershiplabel(String num) {
		return By.xpath(String.format("((//summary[contains(@class,'BeneficialOwners_summary')])[%s]//p)[3]", num));
	}

	private By getOwnershipValue(String num) {
		return By.xpath(String.format("((//summary[contains(@class,'BeneficialOwners_summary')])[%s]//p)[4]", num));
	}

	public void verifyBeneficialOwnerDetails(String num, String expOwnerlabel, String ownerName, String ownerShipLabel,
			String ownerShipValue) {
		new CommonFunctions().verifyLabelText(getBeneficialOwnerLabel(num), "Beneifical" + num, expOwnerlabel);
		new CommonFunctions().verifyLabelText(getBeneficialOwnerName(num), "Name", ownerName);
		new CommonFunctions().verifyLabelText(getOwnershiplabel(num), "label", ownerShipLabel);
		new CommonFunctions().verifyLabelText(getOwnershipValue(num), "ownership value", ownerShipValue);
	}

	public By getID(String id) {
		return By.cssSelector(String.format("#%s", id));
	}

	public void fillDateOfBirth(String dateOfBirth) throws InterruptedException {
		// clearText(txtDateOfBirth, "Date of Birth");
		enterText(txtDateOfBirth, dateOfBirth, "Date of Birth");
		// getTextField(txtDateOfBirth, dateOfBirth, "Date of Birth", i);
	}

	public void selectID(String id, int num1) {
		String i = Integer.toString(num1);
		if (id.equalsIgnoreCase("drivers license")) {
			click(getID(String.format("drivers-license-%s", i)), id);
		} else if (id.equalsIgnoreCase("state issued id")) {
			click(getID(String.format("state-id-%s", i)), id);
		} else {
			click(getID(String.format("passport-%s", i)), id);
		}
	}

	public void clickUploadImg() {
		click(lnkUploadImg, "upload Image");
	}

//	  public void clickDriverLicenseRadBtn() {
//		  click(getRadioBtn("Driver's License"), "Driver License");
//	  }
//	  public void clickPassportRadBtn() {
//		  click(getRadioBtn("Passport"), "Passport");
//	  }
//	  public void clickStateIssueRadBtn() {
//		  click(getRadioBtn("State-Issued ID"), "State Issue ID");
//	  }
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public AddBeneficialOwnersComponent addBeneficialOwnersComponent() {
		return new AddBeneficialOwnersComponent();
	}

	public void VerifyHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblBeneficialOwners, "BeneficialOwners", heading);
	}

	public void verifyBeneficialOwnersDesc(String BeneficialDesc) {
		new CommonFunctions().verifyLabelText(BeneficialOwnersDesc, "Beneficial Owners Description", BeneficialDesc);
	}

	public void verifyUploadDocumentsHdg(String UploadDocumentHdg) {
		new CommonFunctions().verifyLabelText(lblUploadDocumentsHdg, "UploadDocument", UploadDocumentHdg);
	}

	public void verifySelectIdentification(String SelectIdentification) {
		new CommonFunctions().verifyLabelText(lblSelectIdentification, "SelectIdentification", "SelectIdentification");
	}

	public void clickSlectAnIdentificationType() {
		click(lnkSelectAnIdentificationType, "Select An Identification Type");
	}

	public void ClickDrpDwn() {
		click(drpDownState, "beneficial dropdown");
	}

	public void ClickDrpDown() {
		click(drpDownContact, "Contact dropdown");
	}

	public void clickBeneficialOwners() {
		click(lblBeneficialOwner1, "Beneficial Owners");
	}

	public void clickSave(int i) {
		List<WebElement> list = DriverFactory.getDriver().findElements(btnSave);
		list.get(i).click();
	}

	public void clickAddBtn() {
		click(lnkAddBtn, "Add Additional Beneficial Owner");
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is in disabled mode");
		}
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}

	public void validateBeneificalOwnersError(String expMsg, String elementName) {
		By error = By.cssSelector("span.text-cor5");
		String errormsg = getText(error, "");
		if (expMsg.equals(errormsg)) {
			ExtentTestManager.setPassMessageInReport("Error Message " + errormsg + " is displayed for " + elementName);
		} else {
			ExtentTestManager
					.setFailMessageInReport("Error Message " + errormsg + " is not displayed for " + elementName);
		}
	}

	public void verifyUploadRequiredDocumentsView() {
		new CommonFunctions().elementView(lblUploadDocumentsHdg, "Upload Required Documents");
	}

	private By getUploadDocumentElement = By
			.xpath(String.format("//div[@class='flex items-center justify-center']/../input"));

	public void uploadSelectImage(String folderName, String fileName) {
//         getElement(getUploadDocumentElement, "select Image").click();
		getElement(getUploadDocumentElement, "Upload Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
	}

	public void verifyPrimaryContact(String primaryContact) {
		new CommonFunctions().verifyLabelText(lblPrimaryContact, "Primary Contact :", primaryContact);
	}

	public void verifyTechnicalContact(String technicalContact) {
		new CommonFunctions().verifyLabelText(lblTechnicalContact, "Primary Contact :", technicalContact);
	}

	public void verifyFinancialContact(String billingContact) {
		new CommonFunctions().verifyLabelText(lblFinancialBilling, "Primary Contact :", billingContact);
	}

	public void fillFirstName(String enterFName) {
		enterText(firstName, "First Name :", enterFName);
	}

	public void fillLastName(String enterLName) {
		enterText(lastName, "Last Name :", enterLName);
	}

	public void fillemail(String email) {
		enterText(emailAddress, "Email Address:", email);
	}

	public void fillPhone(String phone) {
		enterText(phoneNumber, "Phone Number:", phone);
	}

}
