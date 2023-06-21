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


public class EditProfilePage extends MobileFunctions{
//	private By heading =MobileBy.xpath("//*[@name='Edit Address']");
//	private By heading =MobileBy.AccessibilityId("Edit Address");
	
	private By lblEditAddress = MobileBy.AccessibilityId("");
//	private By txtCountryDropdown = MobileBy.AccessibilityId("");
//	private By txtSearch = MobileBy.AccessibilityId("");
//	
	
	
	/****
	 * Edit Image
	 */
	
	private By btnChooseFromLibrary = MobileBy.AccessibilityId("");
	private By btnTakeaPhoto = MobileBy.AccessibilityId("");
	private By img1 = MobileBy.AccessibilityId("");
	private By btnDone = MobileBy.AccessibilityId("");
	
	
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
	
	private By lblEmail = MobileBy.AccessibilityId("");
	private By lblCurrentEmail = MobileBy.AccessibilityId("");
	private By lblExistingEmail = MobileBy.AccessibilityId("");
	private By btnChange = MobileBy.AccessibilityId("");
	private By lblEditEmail = MobileBy.AccessibilityId("");
	private By txtCurrentEmail = MobileBy.AccessibilityId("");
	private By txtEnterNewEmail = MobileBy.AccessibilityId("");
	private By lblNeedHelp = MobileBy.AccessibilityId("");
	
	
	public void verifyEditEmailHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblEditEmail, "Edit Email", hdg);
	}
	public void verifycurrentEmail(String email) {
		new CommonFunctions().verifyLabelText(txtCurrentEmail, "Current Email", email);
	}
	public void fillNewEmail(String email) {
		enterText(txtEnterNewEmail, email, "Enter New Email");
	}
	
	public void verifyEmailHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblEmail, "Email", hdg);
	}
	
	public void verifyCurrentEmailHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblCurrentEmail, "Current Email", hdg);
	}
	
	public void verifyExistEmail(String hdg) {
		new CommonFunctions().verifyLabelText(lblExistingEmail, "Exist Email", hdg);
	}
	public void clickChange() {
		if(getElement(btnChange, "Change").isEnabled()) {
			click(btnChange, "Change");
		}else {
			ExtentTestManager.setInfoMessageInReport("The change button is disabled");
		}
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
	
	
	
	private By btnSave =MobileBy.xpath("(//*[@name='Save'])[1]");
	public int verifySave() {
		return getElementList(btnSave, "SaveS").size();
	}
	
	
	public void clickSave() {
		
		if(getElement(btnSave, "Save").isEnabled()) {
		click(btnSave, "Click Save");
		}else {
			ExtentTestManager.setInfoMessageInReport("Save Button is disabled");
		}
	}
	
	/***
	 * Edit Phone Number
	 * @return
	 */
	
	private By lblPhoneNumber = MobileBy.AccessibilityId("");
	private By lblCurrentPhoneNumber = MobileBy.AccessibilityId("");
	private By lblExistingPhoneNumber = MobileBy.AccessibilityId("");
	private By lblEditPhoneNumber = MobileBy.AccessibilityId("");
	private By txtCurrentPhoneNumber = MobileBy.AccessibilityId("");
	private By arwPhoneNumber = MobileBy.AccessibilityId("");
	private By txtSearch = MobileBy.AccessibilityId("");
	private By iconSearch = MobileBy.AccessibilityId("");
	private By txtPhoneNumber = MobileBy.AccessibilityId("");
	private By btnContinue = MobileBy.AccessibilityId("");
	
	
	
	
	
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
		if(getElement(btnContinue, "Continue").isEnabled()) {
			click(btnContinue, "Continue");
		}else {
			ExtentTestManager.setInfoMessageInReport("Continue button is disabled");
		}
	}
	
	/**
	 * 
	 * Edit Address
	 * @return
	 */
	
	private By lbladdress = MobileBy.AccessibilityId("");
	private By lblCurrentAddress = MobileBy.AccessibilityId("");
	private By lblExistingAddress = MobileBy.AccessibilityId("");
	private By lblEditAddresshdg = MobileBy.AccessibilityId("");

	
	
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
