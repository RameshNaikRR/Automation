package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.apibusiness.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.utilities.FileHelper;

public class RegistrationBeneficialOwnersPage extends BrowserFunctions{
	private By lblBeneficialOwners = By.xpath("//h4[@class='mb-5 text-2xl font-bold text-cm4']");
	private By BeneficialOwnersDesc = 	By.xpath("//p[@class='mb-6 text-sm text-cgy3']");
	private By lblUploadDocumentsHdg = By.xpath("//span[text()='Upload Required Documents']");
	private By lblSelectIdentification = By.xpath("//p[text()='Select Identification to Upload:']");
	private By lnkSelectAnIdentificationType = By.xpath("//span[text()='Select An Identification Type']");
	private By drpdwn = By.xpath("//div[@class='BeneficialOwners_accordion_caret__yVW04 transform -rotate-90']");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By lnkAddBtn = By.xpath("//button[text()='Add Additional Beneficial Owner']");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkExit = By.xpath("//span[text()='Exit']");
	private By lnkUploadImg = By.xpath("//div[@class='flex items-center justify-center']//img");
	
	  public void clickRadioBtn(String radioButton) {
	    By radioButtons	=   By.xpath(String.format("//input[@type='radio']/following::span[text()='%s']/preceding-sibling::input", radioButton));
	    click(radioButtons, radioButton + "Radio Buttons");
	    }
	  private By getRadioBtntextsView(String elementName) {
			return By.xpath(String.format("//input[@type='radio']/following::span[text()='Passport']", elementName));
		}

		public void verifyDriverLicenseView(String elementName) {
			new CommonFunctions().elementView(getRadioBtntextsView("Driver's License"), "Driver's License");
		}

		public void verifyPassportView(String elementName) {
			new CommonFunctions().elementView(getRadioBtntextsView("Passport"), "Passport");
		}

		public void verifyStateIssueIDView(String elementName) {
			new CommonFunctions().elementView(getRadioBtntextsView("State-Issued ID"), "State-Issued ID");
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
	
	public void VerifyBeneficialOwners(String beneficialOwners) {
		new CommonFunctions().verifyLabelText(lblBeneficialOwners, beneficialOwners, "BeneficialOwners");
	}
	public void verifyBeneficialOwnersDesc(String BeneficialDesc) {
		new CommonFunctions().verifyLabelText(BeneficialOwnersDesc, BeneficialDesc, " Beneficial Owners Description");
	}
	public void verifyUploadDocumentsHdg(String UploadDocumentHdg) {
		new CommonFunctions().verifyLabelText(lblUploadDocumentsHdg, UploadDocumentHdg, "UploadDocument");
	}
    public void verifySelectIdentification(String SelectIdentification) {
    	new CommonFunctions().verifyLabelText(lblSelectIdentification, SelectIdentification, "SelectIdentification");
    }
    public void clickSlectAnIdentificationType()  {
    	click(lnkSelectAnIdentificationType, "Select An Identification Type");
    }
    public void ClickDrpDwn() {
    	click(drpdwn, "beneficial dropdown");
    }
    public void clickSave() {
    	click(btnSave, "Save");
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
    	click(lnkExit,"Exit");
    }
    public void verifyUploadRequiredDocumentsView() {
		new CommonFunctions().elementView(lblUploadDocumentsHdg, "Upload Required Documents");
	}
//    public void uploadSelectImage(String folderName,String fileName) {
//		getElement(btnSelectImage, "select Image").sendKeys(FileHelper.getFilePath(folderName,fileName));
//	}
}
