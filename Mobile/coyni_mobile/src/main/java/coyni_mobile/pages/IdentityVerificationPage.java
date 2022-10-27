package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.UploadDocumentComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class IdentityVerificationPage extends MobileFunctions{
	
	private By btnDateofBirth = MobileBy.xpath("//*[contains(@resource-id,'idveriDOBET')]");
	private By txtSSN = MobileBy.xpath("//*[contains(@resource-id,'idVeriSSNET')]");
	private By btnUpload = MobileBy.xpath("//*[contains(@resource-id,'clickBottomSheet')]");
	private By lnkContinue = MobileBy.xpath("//*[contains(@resource-id,'tv_continue')]");
	private By lnkLicense = MobileBy.xpath("//*[contains(@resource-id,'driverlicensetxt')]");
	private By lnkPassport = MobileBy.xpath("//*[contains(@resource-id,'passporttxt')]");
	private By lnkIssuedCard = MobileBy.xpath("//*[contains(@resource-id,'sictxt')]");
	private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
	private By txtAddress1 = MobileBy.xpath("//*[contains(@resource-id,'mailingAddET')]");
	private By txtAddress2 = MobileBy.xpath("//*[contains(@resource-id,'mailingAddlineoptET')]");
	private By txtCity = MobileBy.xpath("//*[contains(@resource-id,'cityET')]");
	private By btnState = MobileBy.xpath("//*[contains(@resource-id,'stateET')]");
	private By txtZipCode = MobileBy.xpath("//*[contains(@resource-id,'zipcodeET')]");
	private By btnSubmit = MobileBy.xpath("//*[contains(@text,'Submit')]");
	private By lblIdentitySuccess = MobileBy.xpath("//*[contains(@text,'Successful')]");
	private By btnDone = MobileBy.xpath("//*[@text='Done']");
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'tvUserName')]");
	private By btnVerifyNext= MobileBy.xpath("//*[@text='Next']");
	private By lblVerifyHeading = MobileBy.xpath("//*[contains(@text,'Please Verify')]");
	private By lblIdentityHeading = MobileBy.xpath("//*[@text='Identity Verification']");
	
	
	
	public void fillSSN(String expText) {
		enterText(txtSSN, expText, "SSN");
	}

	public void clickDateofBirth() {
		click(btnDateofBirth, "Date of Birth");
	}

	public void clickUpload() {
		click(btnUpload, "Upload");
	}
	
	public void clickContinue() {
		click(lnkContinue, "Continue");
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
	
	public void clickNext() {
		scrollDownToElement(btnNext, "Next");
		click(btnNext, "Next");
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

	public void clickSubmit() {
		scrollDownToElement(btnSubmit, "Submit");
		click(btnSubmit, "Submit");
	}

	public int verifyIdentityHeading(String expHeading) throws InterruptedException {
		Thread.sleep(2000);
		int a=DriverFactory.getDriver().findElements(lblVerifyHeading).size();
		if(a==1) {
		new CommonFunctions().verifyLabelText(lblVerifyHeading, " Verify your Identity Heading ", expHeading);
		click(btnVerifyNext, "Verify Next");
		}
		return a;
	}

	public void verifyTransactionHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblIdentitySuccess, "Identity Verification Successful Heading ", expHeading);
	}
	
	public void verifyIdentityVerificationHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblIdentityHeading, "Identity Verification  Heading ", expHeading);
	}
	
	public void getUserName() {
		ExtentTestManager.setInfoMessageInReport(" User Name is : "+getText(lblUserName));
	}
	
	public void clickDone() {
		click(btnDone, "Done");
	}
	
	public void verifyIdentity(String expHeading,String expIdentityHeading,String expSSN,String expAddress1,String expAddress2,String expCity,String expState,String expZipCode,String expSuccessHeading) throws InterruptedException {
		
		verifyIdentityHeading(expHeading);
		verifyIdentityVerificationHeading(expIdentityHeading);
		clickDateofBirth();
		clickContinue();
		fillSSN(expSSN);
		DriverFactory.getDriver().hideKeyboard();
		clickUpload();
		clickLicense();
		if(uploadDocumentComponent().verifyUsingApp()==1 ) {	
			uploadDocumentComponent().clickUsingApp();
			uploadDocumentComponent().clickAllow();
			}
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
		clickSubmit();
		clickDone();
//		verifyTransactionHeading(expSuccessHeading);
//		getUserName();
		
		
	}
	public UploadDocumentComponent uploadDocumentComponent() {
		return new UploadDocumentComponent();
	}

}
