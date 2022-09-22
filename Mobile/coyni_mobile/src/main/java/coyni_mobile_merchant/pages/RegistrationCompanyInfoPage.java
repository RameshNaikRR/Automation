package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.UploadDocumentComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class RegistrationCompanyInfoPage extends MobileFunctions {

	private By btnGetStarted = MobileBy.xpath("//*[contains(@resource-id,'cv_app_get_started')]");
	private By btnCompanyInfo = MobileBy.xpath("//*[contains(@resource-id,'caIncompleteLL')]");
	private By btnCompanyInfoHeading = MobileBy.xpath("//*[contains(@text,'Company Information')]");
	private By txtCompanyName = MobileBy.xpath("//*[contains(@resource-id,'companynameET')]");
	private By txtCompanyEmail = MobileBy.xpath("//*[contains(@resource-id,'companyemailET')]");
	private By txtCompanyPhNum = MobileBy.xpath("//*[contains(@resource-id,'companypnET')]");
	private By drpBusiness = MobileBy.xpath("//*[contains(@resource-id,'businessET')]");
	private By lnksole = MobileBy.xpath("//*[contains(@resource-id,'soleLLCTV')]");
	private By txtSSN = MobileBy.xpath("//*[contains(@resource-id,'ssnET')]");
	private By txtAddress1 = MobileBy.xpath("//*[contains(@resource-id,'companyaddressET')]");
	private By txtAddress2 = MobileBy.xpath("//*[contains(@resource-id,'companyaddress2ET')]");
	private By txtCity = MobileBy.xpath("//*[contains(@resource-id,'cityET')]");
	private By btnState = MobileBy.xpath("//*[contains(@resource-id,'stateET')]");
	private By txtZipCode = MobileBy.xpath("//*[contains(@resource-id,'zipcodeET')]");

	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'Next')]");
	private By btnArticles = MobileBy.xpath("//*[contains(@resource-id,'aoiLL')]");
	private By btnEIN = MobileBy.xpath("//*[contains(@resource-id,'einLetterLL')]");
	private By btnW9 = MobileBy.xpath("//*[contains(@resource-id,'w9FormLL')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneCV')]");
	private By lnkTakePhoto = MobileBy.xpath("//*[contains(@resource-id,'takePhotoTV')]");
	private By lnkBrowseFiles = MobileBy.xpath("//*[contains(@resource-id,'browseFileTV')]");
	private By lnkLibrary = MobileBy.xpath("//*[contains(@resource-id,'libraryTV')]");
	private By btnCapture = MobileBy.xpath("//*[contains(@resource-id,'capture_image_button')]");
	private By btnSelectFile = MobileBy.xpath("//*[contains(@resource-id,'icon_thumb')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'saveLL')]");
	private By btnUsingApp = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_foreground_only_button')]");
	private By btnAllow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");

	public void clickGetStarted() {
		click(btnGetStarted, "Get Started");
	}

	public void fillCompanyName(String expText) {
		enterText(txtCompanyName, expText, "Company Name");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(btnCompanyInfoHeading, "Company Info Heading", expHeading);
	}

	public void fillCompanyEmail(String expCompanyEmail) {
		enterText(txtCompanyEmail, expCompanyEmail, "Company Email");
	}

	public void fillCompanyPhoneNumber(String expText) {
		enterText(txtCompanyPhNum, expText, "Company Phone Number");
	}

	public void clickdrpdwnBusiness() {
		click(drpBusiness, "Business Dropdown");
	}

	public void selectBusinessType() {
		click(lnksole, "Select Business Type");
	}

	public void fillSSN(String expText) {
		enterText(txtSSN, expText, "SSN");
	}

	public void clickCompanyInfo() {
		click(btnCompanyInfo, "Company Information");
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

	public void clickArticles() {
		click(btnArticles, "Articles of Incorporation");
	}

	public void clickbtnEIN() {
		click(btnEIN, "EIN Letter");
	}

	public void clickbtnW9() {
		click(btnW9, "W-9 Form");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void clickTakePhoto() {
		click(lnkTakePhoto, "Take a Photo");
	}

	public void clickBrowseFiles() {
		click(lnkBrowseFiles, "Browse Files");
	}

	public void clicklnkLibrary() {
		click(lnkLibrary, "Choose From Library");
	}

	public void clickCapture() {
		click(btnCapture, "Capture Image");
	}

	public void clickSelectFile() {
		click(btnSelectFile, "Select File through browse files");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void clickUsingApp() {
		click(btnUsingApp, "Using App");
	}

	public void clickAllow() {
		click(btnAllow, "Allow");
	}

	public void AddCompanyInfo(String expHeading, String expName, String expEmail, String expNum, String expSSN,
			String expAddress1, String expAddress2, String expCity, String expState, String expZipcode)
			throws InterruptedException {
		verifyHeading(expHeading);
		fillCompanyName(expName);
		fillCompanyEmail(expEmail);
		fillCompanyPhoneNumber(expNum);
		DriverFactory.getDriver().hideKeyboard();
		clickdrpdwnBusiness();
		selectBusinessType();
		fillSSN(expSSN);
		DriverFactory.getDriver().hideKeyboard();
		clickNext();
		fillAddress1(expAddress1);
		fillAddress2(expAddress2);
		fillCity(expCity);
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().selectState(expState);
		fillZipCode(expZipcode);
		clickNext();
		clickbtnW9();
		if (uploadDocumentComponent().verifyUsingApp() == 1) {
			uploadDocumentComponent().clickUsingApp();
			uploadDocumentComponent().clickAllow();
		}
		clickTakePhoto();
		clickCapture();
		clickSave();
		clickDone();
	}

	public UploadDocumentComponent uploadDocumentComponent() {
		return new UploadDocumentComponent();
	}

}
