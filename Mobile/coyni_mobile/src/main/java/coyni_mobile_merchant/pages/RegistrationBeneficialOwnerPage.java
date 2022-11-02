package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.UploadDocumentComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class RegistrationBeneficialOwnerPage extends MobileFunctions {

	private By lblAddBeneficial = MobileBy.xpath("//*[contains(@text,'Add Beneficial ')]");
	private By txtFirstName = MobileBy.id("com.coyni.mapp:id/FirstNameET");
	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'LastNameET')]");
	private By btnDateofBirth = MobileBy.xpath("//*[contains(@resource-id,'IdveriDOBET')]");
	private By txtSSN = MobileBy.xpath("//*[contains(@resource-id,'ssnET')]");
	private By txtOwnership = MobileBy.xpath("//*[contains(@resource-id,'OwnershipET')]");
	private By lnkContinue = MobileBy.xpath("//*[contains(@resource-id,'tv_continue')]");
	private By btnUpload = MobileBy.xpath("//*[contains(@resource-id,'UploadIV')]");
	private By lnkLicense = MobileBy.xpath("//*[contains(@resource-id,'driverlicensetxt')]");
	private By lnkPassport = MobileBy.xpath("//*[contains(@resource-id,'passporttxt')]");
	private By lnkIssuedCard = MobileBy.xpath("//*[contains(@resource-id,'sictxt')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'nextcv')]");
	private By btnOnlyThisTime = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_one_time_button')]");
	private By btnAllow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	private By txtAddress1 = MobileBy.xpath("//*[contains(@resource-id,'mailing_address_ET')]");
	private By txtAddress2 = MobileBy.xpath("//*[contains(@resource-id,'m_a_optionalET')]");
	private By txtCity = MobileBy.xpath("//*[contains(@resource-id,'City_ET')]");
	private By btnState = MobileBy.xpath("//*[contains(@resource-id,'stateET')]");
	private By txtZipCode = MobileBy.xpath("//*[contains(@resource-id,'Zip_ET')]");
	private By btnDone = MobileBy.xpath("//*[contains(@text,'Done')]");
	private By lblAdditionalBeneficialHeading = MobileBy.xpath("//*[contains(@text,'Additional Beneficial')]");
	private By btnBeneficialOwners = MobileBy.xpath("//*[contains(@resource-id,'moreIV')]");
	private By btnBeneficialOwnerMore1 = MobileBy.xpath("(//*[contains(@resource-id,'moreIV')])[1]");
	private By btnBeneficialOwnerMore2 = MobileBy.xpath("(//*[contains(@resource-id,'moreIV')])[2]");
	private By btnAddBeneficial = MobileBy.xpath("//*[contains(@resource-id,'addNewBOLL')]");
	private By lnkViewEdit = MobileBy.xpath("//*[contains(@text,'View/Edit')]");
	private By lnkDelete = MobileBy.xpath("//*[contains(@text,'Delete')]");
	private By lblAdditionalDescription = MobileBy.xpath("//*[contains(@resource-id,'boDescTV')]");

	public void fillFirstName(String expText) {
		enterText(txtFirstName, expText, "First Name");
	}

	public void fillSSN(String expText) {
		enterText(txtSSN, expText, "SSN");
	}

	public void fillOwnership(String expText) {
		enterText(txtOwnership, expText, "Ownership Percentage");
	}

	public void clickDateofBirth() {
		click(btnDateofBirth, "Date of Birth");
	}

	public void fillLastName(String expText) {
		enterText(txtLastName, expText, "Last Name");
	}

	public void clickContinue() {
		click(lnkContinue, "Continue");
	}

	public void clickUpload() {
		click(btnUpload, "Upload");
	}

	public void clickLicense() {
		click(lnkLicense, "Driver's License");
	}

	public void clickPassport() {
		click(lnkPassport, "Passport");
	}

	public void clickIssuedCard() {
		click(lnkIssuedCard, "State Issued Card");
	}

	public void clickOnlyThisTime() {
		click(btnOnlyThisTime, "Only This Time");
	}

	public void clickAllow() {
		click(btnAllow, "Allow");
	}

	public void clickNext() {
		scrollDownToElement(btnNext, "Next");
		click(btnNext, "Next");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddBeneficial, "Add Beneficial Owner", expHeading);
	}
	
	public void fillAddress1(String expText) {
		enterText(txtAddress1, expText, " Mailling Address Line 1");
	}

	public void fillAddress2(String expText) {
		enterText(txtAddress2, expText, "Mailing Address Line 2");
	}

	public void fillCity(String expText) {
		enterText(txtCity, expText, "City");
	}

	public void clickState() {
		click(btnState, "State");
	}

	public void fillZipCode(String expText) {
		enterText(txtZipCode, expText, "Zip Code");
	}

	public void clickDone() throws InterruptedException {
		Thread.sleep(2000);
		scrollDownToElement(btnDone, "Done");
		click(btnDone, "Done");
	}

	
	
	public void clickBeneficialOwnerMore1() {
		click(btnBeneficialOwnerMore1, "Beneficial Owner 1");
	}
	
	public void clickBeneficialOwnerMore2() {
		click(btnBeneficialOwnerMore2, "Beneficial Owner 2");
	}

	public void clickAddBeneficial() {
		click(btnAddBeneficial, "btnAddBeneficial");
	}

	public void clickViewEdit() {
		click(lnkViewEdit, "View/Edit");
	}

	public void clickDelete() {
		click(lnkDelete, "Delete");
	}

	public void clickAdditionalDescription() {
		ExtentTestManager.setInfoMessageInReport("Beneficial Owners Description :"+getText(lblAdditionalDescription));
	}

	public int getElementsSize() {
		return getElementList(btnBeneficialOwners,"").size();
	}
	
	public void verifyAdditionalBeneficialHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAdditionalBeneficialHeading, "Additional Beneficial Owner's Heading", expHeading);
	}
	
	public void BeneficialOwner(String heading, String expFirstName, String expLastName, String expSSN,
			String expOwnership,String expAddress1, String expAddress2,String expCity,String expZipCode, String expState) throws InterruptedException {
		Thread.sleep(2000);	
		verifyHeading(heading);
		fillFirstName(expFirstName);
		fillLastName(expLastName);
		clickDateofBirth();
		clickContinue();
		fillSSN(expSSN);
		DriverFactory.getDriver().hideKeyboard();
		fillOwnership(expOwnership);
		DriverFactory.getDriver().hideKeyboard();
		clickUpload();
		if(uploadDocumentComponent().verifyUsingApp()==1 ) {	
			uploadDocumentComponent().clickUsingApp();
			uploadDocumentComponent().clickAllow();
			}
		clickLicense();
		uploadDocumentComponent().clickCapture();
		uploadDocumentComponent().clickSave();
		clickNext();
		fillAddress1(expAddress1);
		fillAddress2(expAddress2);
		fillCity(expCity);
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().selectState(expState);
		fillZipCode(expZipCode);
		DriverFactory.getDriver().hideKeyboard();
		clickDone();
//		Thread.sleep(3000);	
		}
	
	
	public void AddEditBeneficialOwner(String heading, String expFirstName, String expLastName, String expSSN,
			String expOwnership,String expAddress1, String expAddress2,String expCity,String expZipCode, String expState) throws InterruptedException {
        BeneficialOwner(heading, expFirstName, expLastName, expSSN, expOwnership, expAddress1, expAddress2, expCity, expZipCode, expState);
		Thread.sleep(3000);
		clickAddBeneficial();
		BeneficialOwner(heading, expFirstName, expLastName, expSSN, expOwnership, expAddress1, expAddress2, expCity, expZipCode, expState);		
		if (getElementsSize()>0){
		clickBeneficialOwnerMore1();
		clickViewEdit();
		BeneficialOwner(heading, expFirstName, expLastName, expSSN, expOwnership, expAddress1, expAddress2, expCity, expZipCode, expState);
		clickBeneficialOwnerMore2();
		clickDelete();
		Thread.sleep(3000);
		clickAddBeneficial();
		BeneficialOwner(heading, expFirstName, expLastName, expSSN, expOwnership, expAddress1, expAddress2, expCity, expZipCode, expState);		
		}
		Thread.sleep(2000);
		clickDone();
	}
	
	public UploadDocumentComponent uploadDocumentComponent() {
		return new UploadDocumentComponent();
	}

}
