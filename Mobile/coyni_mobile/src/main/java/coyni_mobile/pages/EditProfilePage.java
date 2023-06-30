package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.MailingAddressComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.PhoneAndEmailVerificationComponent;
import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditProfilePage extends MobileFunctions {
//	private By heading =MobileBy.xpath("//*[@name='Edit Address']");
//	private By heading =MobileBy.AccessibilityId("Edit Address");

	private By lblEditAddress = MobileBy.xpath("//*[@text='Edit Address']");
//	private By txtCountryDropdown = MobileBy.id("");
//	private By txtSearch = MobileBy.id("");
//	

	/****
	 * Edit Image
	 */

	private By btnChooseFromLibrary = MobileBy.id("");
	private By btnTakeaPhoto = MobileBy.id("");
	private By img1 = MobileBy.id("");
	private By btnDone = MobileBy.id("");

	public void clickChooseFromLibrary() {
		click(btnChooseFromLibrary, "ChooseFrom Library");
	}

	public void verifyTakeaPhotView() {
		new CommonFunctions().elementView(btnTakeaPhoto, "Take a photo");
	}

	public void clickPhoto() {
		click(img1, "Image");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	/***
	 * Edit Email
	 */

	private By lblEmail = MobileBy.id("com.coyni.mapp:id/intentNameTV");
	private By lblCurrentEmail = MobileBy.id("com.coyni.mapp:id/titleTV");
	private By lblExistingEmail = MobileBy.id("com.coyni.mapp:id/contentTV");
	private By btnChange = MobileBy.xpath("//*[@text='Change']");
	private By lblEditEmail = MobileBy.xpath("//*[@text='Edit Email']");
	private By lblCurrExistingEmail = MobileBy.id("com.coyni.mapp:id/currentET");
	private By txtEnterNewEmail = MobileBy.id("com.coyni.mapp:id/emailET");
	private By lblNeedHelp = MobileBy.id("");
	private By btnSave = MobileBy.id("com.coyni.mapp:id/saveButton");

	public void verifyEditEmailHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblEditEmail, "Edit Email", hdg);
	}

	public void verifycurrentEmail(String email) {
		new CommonFunctions().verifyLabelText(lblCurrExistingEmail, "Current Email", email);
	}

	public void fillNewEmail(String email) {
		enterText(txtEnterNewEmail, email, "Enter New Email");
	}

	public void verifyEmailHeading() {
		new CommonFunctions().elementView(lblEmail, "Email");
		ExtentTestManager.setPassMessageInReport(getText(lblEmail));
	}

	public void verifyCurrentEmailHeading() {
		new CommonFunctions().elementView(lblCurrentEmail, "Current Email");
		ExtentTestManager.setPassMessageInReport(getText(lblCurrentEmail));
	}

	public void verifyExistEmail(String email) {
		new CommonFunctions().verifyLabelText(lblExistingEmail, "Exist Email", email);
	}

	public void clickChange() {
		click(btnChange, "Change");
	}

	public void verifyNeedHelpView() {
		new CommonFunctions().elementView(lblNeedHelp, "Need Help With Coyni");
	}

	/**
	 * Order -minChar, maxChar,maxiPlus
	 */
	public void validateEmail(String email) {
		String[] field = email.split(",");
		for (int i = 0; i < 2; i++) {
			new CommonFunctions().validateField(txtEnterNewEmail, "Email", field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(txtEnterNewEmail, "Email", field[2]);
	}

	/**
	 * Order -minChar, MaxiPlus
	 */
	public void validatePhoneNumber(String phoneNumber) {
		String[] field = phoneNumber.split(",");
		for (int i = 0; i < 1; i++) {
			new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", field[0]);
		}
		new CommonFunctions().validateFieldMaxichar(txtPhoneNumber, "Phone Number", field[1]);
	}

	public int verifySave() {
		return getElementList(btnSave, "SaveS").size();
	}

	public void clickSave() {
		new CommonFunctions().clickEnabledElement(btnSave, "Save");
	}

	/***
	 * Edit Phone Number
	 * 
	 * @return
	 */

	private By lblPhoneNumber = MobileBy.id("");
	private By lblCurrentPhoneNumber = MobileBy.id("");
	private By lblExistingPhoneNumber = MobileBy.id("");
	private By lblEditPhoneNumber = MobileBy.id("");
	private By txtCurrentPhoneNumber = MobileBy.id("");
	private By arwPhoneNumber = MobileBy.id("");
	private By txtSearch = MobileBy.id("");
	private By iconSearch = MobileBy.id("");
	private By txtPhoneNumber = MobileBy.id("");
	private By btnContinue = MobileBy.id("");

	public void verifyPhoneNumberHdg(String hdg) {
		new CommonFunctions().verifyLabelText(lblPhoneNumber, "Phone Number", hdg);
	}

	public void verifyCurrentPhoneNumberhdg(String phNumhdg) {
		new CommonFunctions().verifyLabelText(lblCurrentPhoneNumber, "Current Phone Number", phNumhdg);
	}

	public void verifyExistingPhoneNUmber(String phNum) {
		new CommonFunctions().verifyLabelText(lblExistingPhoneNumber, "Current Phone Number", phNum);
	}

	public void verifyEditPhoneNUmber(String phNum) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNumber, "Edit Phone Number", phNum);
	}

	public void verifyCurrentPhoneNUmber(String phNum) {
		new CommonFunctions().verifyLabelText(txtCurrentPhoneNumber, "Current Phone Number", phNum);
	}

	public void clickArrow(String country) {
		new CommonFunctions().elementView(arwPhoneNumber, "arrow");
		new CommonFunctions().elementView(iconSearch, "Search icon");
		enterText(txtSearch, country, "country");
	}

	public void fillPhoneNumber(String phNum) {
		enterText(txtPhoneNumber, phNum, "Phone Number");
	}

	public void clickContinue() {
		if (getElement(btnContinue, "Continue").isEnabled()) {
			click(btnContinue, "Continue");
		} else {
			ExtentTestManager.setFailMessageInReport("Continue button is disabled");
		}
	}

	/**
	 * 
	 * Edit Address
	 * 
	 * @return
	 */

	private By lbladdress = MobileBy.id("");
	private By lblCurrentAddress = MobileBy.id("com.coyni.mapp:id/titleTV");
	private By lblExistingAddress = MobileBy.id("com.coyni.mapp:id/contentTV");
	private By lblEditAddresshdg = MobileBy.id("");

	public void validateAddress() {
		if (getElement(lblCurrentAddress, "Current Address").isDisplayed()
				&& getElement(lblExistingAddress, "Existing Address").isDisplayed()
				&& getElement(btnChange, "Change").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Address added and reflected in Current Address screen");
		} else {
			ExtentTestManager.setFailMessageInReport("Address not added and not reflected in Current Address screen");
		}
	}

	public void verifyAddressheading(String hdg) {
		new CommonFunctions().verifyLabelText(lbladdress, "address", hdg);
	}

	public void verifyCurrentAddres(String hdg) {
		new CommonFunctions().verifyLabelText(lblCurrentAddress, "address", hdg);
	}

	public void verifyExistingAddres(String hdg) {
		new CommonFunctions().verifyLabelText(lblExistingAddress, "address", hdg);
	}

	public void verifyEditAddres(String hdg) {
		new CommonFunctions().verifyLabelText(lblEditAddress, "address", hdg);
	}

//	public void verifyHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
//	}
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

}
