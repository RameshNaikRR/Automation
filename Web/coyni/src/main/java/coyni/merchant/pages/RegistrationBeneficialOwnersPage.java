package coyni.merchant.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.merchant.components.AddBeneficialOwnersComponent;
import coyni.merchant.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class RegistrationBeneficialOwnersPage extends BrowserFunctions{
	
	private By lblBeneficialOwners = By.xpath("//h4[text()='Beneficial Owner(s)']");
	private By BeneficialOwnersDesc = By.xpath("//h4[text()='Beneficial Owner(s)']/following-sibling::p");
	private By lblUploadDocumentsHdg = By.xpath("//span[text()='Upload Required Documents']");
	private By lblSelectIdentification = By.xpath("//p[text()='Select Identification to Upload:']");
	private By lnkSelectAnIdentificationType = By.xpath("//span[text()='Select An Identification Type']");
	private By drpdwn = By
			.xpath("//button[@class='p-0.5 BeneficialOwners_accordion_caret__2E3Hb transform rotate-90']");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By lnkAddBtn = By.xpath("//button[text()='Add Additional Beneficial Owner']");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkExit = By.xpath("//button[text()='Exit']");
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

	public void clickBeneficialOwners() {
		click(lblBeneficialOwners, "Beneficial OWners");
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
		click(drpdwn, "beneficial dropdown");
	}

	public void clickSave(int i) {
		List<WebElement> list = DriverFactory.getDriver().findElements(btnSave);
		list.get(i).click();
	}

	public void clickAddBtn() {
		click(lnkAddBtn, "Add Additional Beneficial Owner");
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

	public void uploadSelectImage(String folderName, String fileName, String num) {
		getElement(getUploadDocument(num), "Upload Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
	}
}
