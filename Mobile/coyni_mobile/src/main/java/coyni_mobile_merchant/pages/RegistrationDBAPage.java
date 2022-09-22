package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.MailingAddressComponent;
import coyni_mobile_merchant.components.UploadDocumentComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class RegistrationDBAPage extends MobileFunctions {

	private By lblDBAHeading = MobileBy.xpath("//*[contains(@text,'DBA Info')]");
	private By btnDifferent = MobileBy.xpath("//*[contains(@text,'Different')]");
	private By btnSame = MobileBy.xpath("//*[contains(@resource-id,'sameLL')]");
	private By txtDBAName = MobileBy.xpath("//*[contains(@resource-id,'DBAnameET')]");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'DBAemailET')]");
	private By txtNum = MobileBy.xpath("//*[contains(@resource-id,'companypnET')]");
	private By drpdwnBusinessType = MobileBy.xpath("//*[contains(@resource-id,'businessTypeET')]");
	private By txtBusinessType = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");
	private By btneCommerce = MobileBy.xpath("//*[contains(@resource-id,'eCommerceIV')]");
	private By btnRetailLocation = MobileBy.xpath("//*[contains(@resource-id,'retailIV')]");
	private By txtProcessingVolume = MobileBy.xpath("//*[contains(@resource-id,'mpvOET')]//*[contains(@resource-id,'volET')]");
	private By txtHighTicket = MobileBy.xpath("//*[contains(@resource-id,'highTicketOET')]//*[contains(@resource-id,'volET')]");
	private By txtAvgHighTicket = MobileBy.xpath("//*[contains(@resource-id,'avgTicketOET')]//*[contains(@resource-id,'volET')]");
	private By drpdwnTimeZone = MobileBy.xpath("//*[contains(@resource-id,'timeZoneET')]");
	private By lnkSelectTimeZone = MobileBy.xpath("//*[contains(@text,'Eastern')]");
	private By btnUpload = MobileBy.xpath("//*[contains(@resource-id,'dbaFillingLL')]");
	private By txtWebsite = MobileBy.xpath("//*[contains(@resource-id,'websiteET')]");
	private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
	private By btnDone = MobileBy.xpath("//*[contains(@text,'Done')]");
	private By lblDBADescription = MobileBy.xpath("//*[contains(@text,' the same as your co')]");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDBAHeading, "DBA  Info Heading", expHeading);
	}

	public void clickDifferent() {
		click(btnDifferent, "Different");
	}

	public void clickSame() {
		click(btnSame, "Same");
	}

	public void fillDBAName(String expDBAName) {
		enterText(txtDBAName, expDBAName, "DBA Name");
	}

	public void fillEmail(String expEmail) {
		enterText(txtEmail, expEmail, "Customer Service Email");
	}

	public void fillNum(String expNum) {
		enterText(txtNum, expNum, "Customer Service Phone Number");
	}

	public void fillProcessingVolume(String expVolume) {
		enterText(txtProcessingVolume, expVolume, "Monthly Processing Volume");
	}

	public void fillHighTicket(String expHighTicket) {
		scrollDownToElement(txtHighTicket, "High Ticket");
		enterText(txtHighTicket, expHighTicket, "High Ticket");
	}

	public void verifyDBADescription() {	
		ExtentTestManager.setInfoMessageInReport("DBA Description is : "+getText(lblDBADescription));
	}

	public void fillWebsite(String expWebsite) {
		enterText(txtWebsite, expWebsite, "Website");
	}

	public void clickNext() {
		scrollDownToElement(btnNext, "Next");
		click(btnNext, "Next");
	}

	public void clickUpload() {
		scrollDownToElement(btnUpload, "Upload DBA filling");
		click(btnUpload, "Upload DBA filling");
	}

	public void clickTimeZone() {
		scrollDownToElement(btnUpload, "Upload DBA filling");
		click(drpdwnTimeZone, "Time Zone Dropdown");
		click(lnkSelectTimeZone, "Eastern (EST)");
	}

	public void selectBusinessType(String exptype) throws InterruptedException {
		DriverFactory.getDriver().hideKeyboard();
		click(drpdwnBusinessType, "Business Dropdown");
		enterText(txtBusinessType, exptype, "Business Type");
		new CommonFunctions().clickEnter();
		new CommonFunctions().clickEnter();
	}

	public void clickRetailLocation() {
		click(btnRetailLocation, "Retail Location");
	}
	
	public void clickeCommerce() {
		click(btneCommerce, "eCommerce");
	}
	
	public void clickDone() {
		click(btnDone, "Done");
	}
	
	public void fillAvgHighTicket(String expAvgHighTicket) {	
		enterText(txtAvgHighTicket, expAvgHighTicket, "Average Ticket");
	}
	
	public void AddDBAInfo(String expHeading, String expName, String expEmail, String expNum, String expBusinessType,String expWebsite, String expVolume, String expHighTicket, String expAvgTicket,
			String expAddress1, String expAddress2, String expCity, String expState, String expZipcode)
			throws InterruptedException {
		
		verifyHeading(expHeading);
		verifyDBADescription();
		clickDifferent();
		verifyHeading(expHeading);
		fillDBAName(expName);
		fillEmail(expEmail);
		DriverFactory.getDriver().hideKeyboard();
		fillNum(expNum);
		DriverFactory.getDriver().hideKeyboard();
		selectBusinessType(expBusinessType);
		clickRetailLocation();
		fillWebsite(expWebsite);
		DriverFactory.getDriver().hideKeyboard();
		fillProcessingVolume(expVolume);
		DriverFactory.getDriver().hideKeyboard();
		fillHighTicket(expHighTicket);
		DriverFactory.getDriver().hideKeyboard();
		fillAvgHighTicket(expAvgTicket);
		DriverFactory.getDriver().hideKeyboard();
		clickTimeZone();
		Thread.sleep(2000);
		clickUpload();
		if(uploadDocumentComponent().verifyUsingApp()==1 ) {	
		uploadDocumentComponent().clickUsingApp();
		uploadDocumentComponent().clickAllow();
		}
		uploadDocumentComponent().clickTakePhoto();
		uploadDocumentComponent().clickCapture();
		uploadDocumentComponent().clickSave();
		Thread.sleep(2000);
	    clickNext();
		mailingAddressComponent().fillAddressLine1(expAddress1);
		mailingAddressComponent().fillAddressLine2(expAddress2);
		mailingAddressComponent().fillCity(expCity);
		mailingAddressComponent().selectState(expState);
		mailingAddressComponent().fillZipCode(expZipcode);
        clickDone();
	}

	public UploadDocumentComponent uploadDocumentComponent() {
		return new UploadDocumentComponent();
	}
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

}
