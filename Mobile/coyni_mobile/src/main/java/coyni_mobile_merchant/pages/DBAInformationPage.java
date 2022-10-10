package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.CurrentDetailsComponent;
import coyni_mobile_merchant.components.UploadDocumentComponent;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class DBAInformationPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'DBA Information')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'businessTypeTV')]");
	private By lblCompanyName = MobileBy.xpath("//*[contains(@resource-id,'nameTV')]");
	private By lblCustomerService = MobileBy.xpath("//*[contains(@text,'Customer Service')]");
	private By lblCurrentEmail = MobileBy.xpath("//*[contains(@resource-id,'emailIDTV')]");
	private By lblCurrentPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'phoneNumberTV')]");
	private By lblCurrentAddress = MobileBy.xpath("//*[contains(@resource-id,'addressTV')]");
	private By lblAddress = MobileBy.xpath("(//*[contains(@text,'Address')])[2]");
	private By lblEmail = MobileBy.xpath("//*[contains(@text,'Email')]");
	private By lblPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'phoneNumberTV')]");
	private By btnEmail = MobileBy.xpath("//*[contains(@resource-id,'editEmailDBALL')]");

	private By btnPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'editPhoneNumDBALL')]");
	private By btnEditProfile = MobileBy.xpath("//*[contains(@resource-id,'dba_editProfileIV')]");
	private By lnkChooseFromLibrary = MobileBy.xpath("//*[contains(@text,'Library')]");
	private By lnkTakeAPhoto = MobileBy.xpath("//*[contains(@text,'Photo')]");
	private By btnCamera = MobileBy.xpath("//*[contains(@resource-id,'shutter_button')]");
	private By btnDoneTicMark = MobileBy.xpath("//*[contains(@resource-id,'done_button')]");
	private By btnCrop = MobileBy.xpath("//*[contains(@resource-id,'crop_image_menu_crop')]");
	private By lblToastMsg = MobileBy.xpath("//*[contains(@resource-id,'toastTV')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancel_button')]");
	private By btnRetake = MobileBy.xpath("//*[contains(@resource-id,'retake_button')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "DBA Infromation Heading", expHeading);
	}

	public void verifyCustomerService(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCustomerService, "Customer Service Heading", expHeading);
	}

	public void getDescription() {
		String str = getText(lblDescription);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getCompanyName() {
		String str = getText(lblCompanyName);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyEmail() {
		new CommonFunctions().elementView(lblEmail, "Email");
	}

	public void verifyPhoneNumber() {
		new CommonFunctions().elementView(lblPhoneNumber, "Phone Number");
	}

	public void verifyAddress() {
		new CommonFunctions().elementView(lblAddress, "Address");
	}

	public void getCurrentEmail() {
		String str = getText(lblCurrentEmail);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getCurrentPhoneNumber() {
		String str = getText(lblCurrentPhoneNumber);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getCurrentAddress() {
		String str = getText(lblCurrentAddress);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickEmail() {
		click(btnEmail, "Email");
	}

	public void clickPhoneNumber() {
		click(btnPhoneNumber, "Phone Number");
	}

	public void clickEditProfile() {
		click(btnEditProfile, "Edit Profile");
	}

	public void clickChoosefromLibrary() {
		click(lnkChooseFromLibrary, "Profile Choose from Library");
	}

	public void clickTakeAPhoto() {
		click(lnkTakeAPhoto, "Take A Photo");
	}

	public void clickCamera() {
		new CommonFunctions().elementView(btnCamera, "Camera");
		click(btnCamera, "Camera");
	}

	public void clickImgDone() {
		click(btnDoneTicMark, "Image Done");
	}

	public void clickImgCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickRetake() {
		click(btnRetake, "Retake");
	}

	public void clickCrop() {
		click(btnCrop, "Crop");
	}

	public void uploadDBAProfile(String expText,String expTex) {
		clickEditProfile();
		if (uploadDocumentComponent().verifyUsingApp() == 1) {
			uploadDocumentComponent().clickUsingApp();
			uploadDocumentComponent().clickAllow();
		}
		clickTakeAPhoto();
		clickCamera();
		clickImgCancel();
		verifyPageHeading(expTex);
		clickEditProfile();
		if (uploadDocumentComponent().verifyUsingApp() == 1) {
			uploadDocumentComponent().clickUsingApp();
			uploadDocumentComponent().clickAllow();
		}
		clickTakeAPhoto();
		clickCamera();
		clickRetake();
		clickCamera();
		clickImgDone();
		clickCrop();
		verifyProfileToastMsg(expText);
	}

	public UploadDocumentComponent uploadDocumentComponent() {
		return new UploadDocumentComponent();
	}

	public void verifyProfileToastMsg(String expHeading) {
		new CommonFunctions().verifyLabelText(lblToastMsg, "DBA Infromation Profile Toast Msg", expHeading);
	}

	public CurrentDetailsComponent currentDetailsComponent() {
		return new CurrentDetailsComponent();
	}
}
