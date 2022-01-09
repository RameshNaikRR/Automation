package coyni.customer.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.popups.AccountProfileImagePopup;
import coyni.customer.popups.EditEmailAddressPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UserDetailsComponent extends BrowserFunctions {

	private By lblHeading = By.cssSelector(".text-base.text-cgy4");
	private By editUserImage = By.cssSelector(".w-4");
	private By editUserImgToolTip = By.xpath("//img[@class='w-4 h-4']/../following-sibling::*[1]");
	private By lnkRemoveImage = By.cssSelector("");
	private By btnRemove = By.cssSelector("");
	private By btnUploadNewImage = By.cssSelector("");
	private By btnSave = By.cssSelector("");
	private By lblUserName = By.xpath("//span[@class='text-2xl font-bold text-cgy8']");
	private By lblAccountStatus = By.xpath("//div[@class='flex flex-row text-md text-cgy4']");
	private By lblEmail = By.cssSelector(".UserDetails_email_address__3EjH8");
	private By lblAddress = By.cssSelector("");
	private By lnkEditAccountEmail = By.xpath("//div[text()='Edit Account Email']");
	private By lnkEditAccountPhNum = By.xpath("//div[text()='Edit Account Phone']");
	private By lnkEditAccountAddress = By.xpath("//div[text()='Edit Account Address']");
	private By iconEditEmail = By.cssSelector(".UserDetails_edit_email_icon__2RuvO");
	private By iconEditPhNum = By
			.xpath("//div[@class='text-xs icon-edit cursor-pointer UserDetails_edit_Phone_icon__1iIcs']");
	private By iconEditAddress = By.xpath("//div[@id='t14bec415-7d33-4847-85c6-9e08e7b12434']");
	private By userImg = By.xpath("//div[contains(@class,'flex flex-row')]//div[contains(@class,'bg-cm3')] \" ");
	private By accountId = By.xpath("//span[@class='mt-1 text-xs text-cgy2'] ");
	private By lblPhoneNum = By.xpath(
			"//h3[@class='text-cgy4 tracking-wide Heading_heading3__3l6XX font-semibold leading-3 tracking-tightest UserDetails_phoneNumber__borc2'] ");
	private By lblEmailAuth = By.xpath("//div[@class='mt-4']");
	private By lblEmailAddress = By.xpath("//h1[text()='Edit Email Address']");
	private By lblAccountAddress = By
			.xpath("//div[contains(@class,'UserDetails_address__2XyBR UserDetails_city_field__2olcd')] ");
	private By lblEditPhoneNumber = By.xpath(
			"//h3[@class='text-cgy4 tracking-wide Heading_heading3__3l6XX font-semibold leading-3 tracking-tightest UserDetails_phoneNumber__borc2']");
	private By lblEditPhoneNumberAuthenticationDescription = By
			.xpath("//span[@class='mt-10 text-base text-center text-cgy4']");
	private By lblVerificationCodeDescription = By.cssSelector("");
	private By txtCode = By.cssSelector("input[class *= 'verification-input']");
	private By Heading = By.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading1__18f6i mt-4 text-center']");
	private By txtNewPhoneNumber = By.cssSelector("input[class='Input_form_input__3qrhS text-cgy4']");
	private By txtOldPhoneNumber = By.cssSelector("div[class='flex flex-col items-center justify-center']");
	private By btnCross = By.cssSelector("button[class='self-end']");
	private By headingUserDetais = By.xpath("//span[@class='text-base text-cgy4']");
	private By headingCurrentPhoneNumber = By.xpath("//h1[text()='Verify Current Phone Number']");
	private By lblCurrentPhoneNumberDescriptionText = By
			.xpath("//span[@class='mt-8 text-base font-normal leading-5 tracking-tight text-center text-cgy4']");
	private By btnResendVerificationCode = By.xpath("//button[@type='submit']");
	private By lblResendVerificationCodeDescription = By.cssSelector("");
	private By btnBackButton = By.xpath("//button[@class='self-start']");
	private By lblVerificationSuccesful = By.xpath(
			"//span[@class='mt-1 text-sm text-center font-semibold text-cgn5 VerificationInput_code__verification_success__8qRYN']");
	private By lblVerificationFailed = By.xpath("//span[text()='Verification Failed']");
	private By lblCurrentNumberVerficationSuccesful = By.cssSelector("");
	private By lblCurrentNumberVerificationFailed = By.cssSelector("");
	private By lblNewPhoneNumberDescriptionText = By.cssSelector("");
	private By lblNewPhoneNumberVerificationSuccesful = By.cssSelector("");
	private By lblNewPhoneNumberVerificationFailed = By.cssSelector("");
	private By headingNewPhoneNumber = By
			.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading1__18f6i mt-4 text-center']");
	private By btnNewNumberResend = By.cssSelector("");
	private By lblNewPhoneNumberResendDescription = By.cssSelector("");
	private By btnSendCode = By.xpath("//input[@id='Phone_Number']/../following-sibling::*[1]");
	private By lblAuthyEditPhone = By.xpath("//h1[text()='Edit Phone Number']");
	private By lblNewPhoneNumberHeading = By
			.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading1__18f6i mt-4 text-center']");
	private By headingEditPhoneNumber = By
			.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading1__18f6i mt-4 text-center']");

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		ExtentTestManager.setInfoMessageInReport("clicked on tab");
	}

	public void verifyUserDetailsView() {
		new CommonFunctions().elementView(lblHeading, "User Details Screen ");
	}

	public void verifyEditImageView() {
		new CommonFunctions().elementView(editUserImage, "Edit User Img icon");
		new CommonFunctions().verifyCursorAction(editUserImage, "Edit User Img icon");
	}

	public void verifyEditImageToolTip(String expToolTip) {
		new CommonFunctions().verifyCursorAction(editUserImgToolTip, "Edit User Img");
		// moveToElement(editUserImgToolTip, "Edit User Img");
		new CommonFunctions().verifyLabelText(editUserImgToolTip, "Edit User Img", expToolTip);

	}

	public void verifyUserNameView() {
		new CommonFunctions().elementView(lblUserName, "UserName");
	}

	public void verifyAccountIdView() {
		new CommonFunctions().elementView(accountId, "accountId");
	}

	public void verifyAccountStatusView() {
		new CommonFunctions().elementView(lblAccountStatus, "accountStatus");
	}

	public void verifyPhoneNumView() {
		new CommonFunctions().elementView(lblPhoneNum, "PhoneNum");
	}

	public void verifyEmailAddressView() {
		new CommonFunctions().elementView(lblEmailAddress, "EmailAddress");
	}

	public void verifyAccountAddressView() {
		new CommonFunctions().elementView(lblAccountAddress, "AccountAddress");
	}

	public void clickEditUserImage() {
		click(editUserImage, "Edit User Image");
	}

	public void clickRemoveImage() {
		click(lnkRemoveImage, "Remove Image");
	}

	public void clickRemove() {
		click(btnRemove, "Remove Button");
	}

	public void clickUploadNewImage() {
		click(btnUploadNewImage, "Upload New Image Button");
	}

	public void clickSave() {
		click(btnSave, "Save Button");
	}

	public void verifyUserName(String expUserName) {
		new CommonFunctions().verifyLabelText(lblUserName, "UserName", expUserName);
	}

	public void verifyAccountStatus(String expAccountStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", expAccountStatus);
	}

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "Email", expEmail);
	}

	public void verifyAddress(String expAddress) {
		new CommonFunctions().verifyLabelText(lblAddress, "Address", expAddress);
	}

	public void clickEditAccountEmail() {
		click(lnkEditAccountEmail, "Click Edit Email");
	}

	public void clickEditAccountPhNumber() {
		click(lnkEditAccountPhNum, "Click Edit PhoneNumber");
	}

	public void clickEditAccountAddress() {
		click(lnkEditAccountAddress, "Click Edit Address");
	}

	public void clickIconEditEmail() {
		moveToElement(lblEmail, "Edit Email");
		click(iconEditEmail, "Click Edit Email Icon");
	}

	public void clickIconEditPhNum() {
		click(iconEditPhNum, "Click Edit Phone Icon");
	}

	public void clickIconEditAddress() {
		click(iconEditAddress, "Click Edit Address Icon");
	}

	public void verifyEditEmailAddress(String expheading) {
		new CommonFunctions().verifyLabelText(lblEmailAddress, "Edit Email Address PopUp Heading", expheading);
	}

	public void verifyEditEmailAddressAuthentication(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailAuth, "Edit Email Address Authentication PopUp Heading",
				expHeading);
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public NotificationsComponent notificationsComponent() {
		return new NotificationsComponent();
	}

	public AccountProfileImagePopup accountProfileImagePopup() {
		return new AccountProfileImagePopup();
	}

	public EditEmailAddressPopup editEmailAddressPopup() {
		return new EditEmailAddressPopup();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public void verifyEditPhoneNumberIconView() {
		moveToElement(lblEditPhoneNumber, "Moved to Edit PhoneNumber");
		click(iconEditPhNum, "Clciked Edit Phone Number Icon");
	}

	public void verifyAuthyEditPhoneHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAuthyEditPhone, "Authy Edit Phone Number Headig", expHeading);
	}

	public void verifyEditPhoneNumberAuthenticationDescription(String expEditPhoneNumberAuthenticationDescription) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNumberAuthenticationDescription,
				"Edit Phone Number Description Text", expEditPhoneNumberAuthenticationDescription);
	}

	public void verifyVerificationCodeDescriptionText(String expVerificationCodeDescriptionText) {
		new CommonFunctions().verifyLabelText(lblVerificationCodeDescription, "Edit Phone Number Description Text",
				expVerificationCodeDescriptionText);
	}

	public void verifyVerificationTextCodeBoxBorderColorAndDescription(String expColor, String expVerificationmsg) {

		new CommonFunctions().verifyTextBoxBorderColor(expColor);
		new CommonFunctions().verifyLabelText(lblVerificationSuccesful, "Verificational Succesful", expVerificationmsg);
	}

//    public void verifyVerificationCodeWithNumber(String expCode) {
//    	new CommonFunctions().validateFieldWithNumber(txtCode, "Verification", expCode);
//    		
//    }
	public void verifyPageHeadingWithValidCode(String expHeding) {
		new CommonFunctions().verifyLabelText(Heading, "Edit Phone Number", expHeding);
	}

	public void verifyVerificationWithEmpty(String expCode, String expheading) {
		enterText(txtCode, "Verification Code", expCode);
		new CommonFunctions().verifyLabelText(Heading, "Edit Phone Number", expheading);
	}

	public void verifyVerificationCodeWithLessThanSixDigits(String expCode, String expHeading) {
		enterText(txtCode, "Code", expCode);
		new CommonFunctions().verifyLabelText(Heading, "Code", expHeading);
	}

//    public void verifyVerificationCodeWithAlphabets(String expCode) {
//    	new CommonFunctions().validateFieldWithalphabet(txtCode, "", expCode);
//    }
	public void enterCode(String expCode) {
		enterText(txtCode, expCode, "Verification Code");
	}

	public void verifyVerificationWithInvalid(String errMessage) {
		new CommonFunctions().verifyLabelText(lblVerificationFailed, "Verification Failed Message", errMessage);

	}

	public void verifyVerificationTextCodeBoxBorderColorWithInvalidCodeAndDescription(String expCode, String expColor,
			String expVericationMsg) {
		enterText(txtCode, "", expCode);
		new CommonFunctions().verifyTextBoxBorderColor(expColor);
		new CommonFunctions().verifyLabelText(lblVerificationFailed, "Verification Failed", expVericationMsg);
	}
//    public void verifyNewPhoneNumberFieldWithAlphabets(String expNewPhoneNumber) {
//    	new CommonFunctions().validateFieldWithalphabet(txtNewPhoneNumber, "New Phone Number", expNewPhoneNumber);
//    }
//    public void verifyNewPhoneNumberFieldWithSpecialCharacters(String expNewPhoneNumber) {
//    	new CommonFunctions().validateFieldWithSpecialchar(txtNewPhoneNumber, "", expNewPhoneNumber);
//    	
//    }

	public void verifyNewPhoneNumberFieldWithInvalidData(String expNewPhoneNumber, String input) {
		enterText(txtNewPhoneNumber, "New Phone Number", expNewPhoneNumber);
		String actNumber = getAttributeValue(txtNewPhoneNumber, "value", "New Phone Number");
		if (!actNumber.equals(expNewPhoneNumber)) {
			ExtentTestManager.setPassMessageInReport("New Phone Number Filed is Not Accepting " + input + "Charater");
		} else {
			ExtentTestManager.setFailMessageInReport("New Phone Number Filed is  Accepting " + input + "Charater");

		}
	}

	public void veriySendCodeButtonWithEmpty(String expNumber) {
		enterText(txtNewPhoneNumber, "New Phone Number With empty", expNumber);
		verifyElementDisabled(btnSendCode, "Send Code");

	}

	public void verifySendCodeButtonWithInvalidData(String expNumber) {
		enterText(txtNewPhoneNumber, "New Phone Number With invalid", expNumber);
		verifyElementDisabled(btnSendCode, "Send Code ");

	}

	public void verifySendCodeButtonEnabled() {
		verifyElementPresence(btnSendCode, "Send Code");

	}

	public void enternumber(String expNumber) {

		enterText(txtNewPhoneNumber, expNumber, "New Phone Number");
	}

	public void clickSend() {
		click(btnSendCode, "click Send Code");
	}

	public void verifyVerifyCurrentPhoneNumberDescriptionText(String expVerifyPhoneNumberDescriptionText) {
		new CommonFunctions().verifyLabelText(lblCurrentPhoneNumberDescriptionText,
				"Verify Current Phone Number Description Text", expVerifyPhoneNumberDescriptionText);

	}

	public void verifyCurrentPhoneNumberHeading(String expHeadingCurrentNumber) {
		new CommonFunctions().verifyLabelText(headingCurrentPhoneNumber, "Current Phone Number Heading is",
				expHeadingCurrentNumber);
	}

	public void verifyNewPhoneNumberHeading(String expNewPhoneNumberHeading) {
		new CommonFunctions().verifyLabelText(lblNewPhoneNumberHeading, "New Phone Number Verification",
				expNewPhoneNumberHeading);
	}

	public void verifyCurrentPhoneNumberVerificationCodeBorderColorAndDescriptionWithInvalidCode(String expColor,
			String expVerificationFailed) {
		new CommonFunctions().verifyTextBoxBorderColor(expColor);
		new CommonFunctions().verifyLabelText(lblCurrentNumberVerificationFailed, "Verification Failed",
				expVerificationFailed);
	}

	public void clickResend() {
		click(btnResendVerificationCode, "Click Resend Verification Code");
	}

	public void verifyResendVerificationCodeDescription(String expResendVerificationCodeDescription) {
		new CommonFunctions().verifyLabelText(lblResendVerificationCodeDescription,
				"Resend Verifiation Code Description", expResendVerificationCodeDescription);
	}

	public void clickBackButton() {
		click(btnBackButton, "");
	}

	public void verifyEditPhoneNumberScreen(String expHeading) {
		new CommonFunctions().verifyLabelText(headingEditPhoneNumber, "Edit Phone Number", expHeading);

	}

	public void verifyNewPhoneNumberTextWithPreviousData() {
		String str = getText(txtNewPhoneNumber, "New Phone Number");
		if (!str.isEmpty()) {

			ExtentTestManager.setPassMessageInReport("New Phone Number Field");
		} else {
			ExtentTestManager.setFailMessageInReport("New Phone Number field With Empty");
		}
	}

	public void clickCrossButton() {
		click(btnCross, "Click Cross Button");
	}

	public void verifyUserdetailsScreen(String expUserDetailsHeading) {
		new CommonFunctions().verifyLabelText(headingUserDetais, "User Details Heading", expUserDetailsHeading);

	}

	public void verifyNewPhoneNumberDescription(String expNewPhoneNumber) {
		new CommonFunctions().verifyLabelText(lblNewPhoneNumberDescriptionText, expNewPhoneNumber, expNewPhoneNumber);
	}

//    public void verifyNewPhoneNumberVerificationCodeWithNumbers(String expCode) {
//    	new CommonFunctions().validateFieldWithNumber(txtNewPhoneNumber, "New Phone Number", expCode);
//    }
	public void verifyNewPhoneNumberVerificationCodeBorderColorAndDescription(String expCode, String expColor,
			String expVerificationSuccesfulMsg) {
		enterText(txtNewPhoneNumber, "", expCode);
		new CommonFunctions().verifyTextBoxBorderColor(expColor);
		new CommonFunctions().verifyLabelText(lblNewPhoneNumberVerificationSuccesful, "Verification Succesful",
				expVerificationSuccesfulMsg);

	}

	public void verifyNewPhoneNumberScreen(String expHeadig) {
		new CommonFunctions().verifyLabelText(headingNewPhoneNumber, "Verify New Phone Number", expHeadig);
	}

	public void verifyNewPhoneNumberWithEmpty(String expCode, String expHeading) {
		enterText(txtNewPhoneNumber, "New Phone Number", expCode);
		new CommonFunctions().verifyLabelText(headingNewPhoneNumber, "New Phone Number", expHeading);
	}

	public void verifyNewPhoneNumberWithLessSixDigits(String expCode, String expHeading) {
		enterText(txtNewPhoneNumber, "New Phone Number", expCode);
		new CommonFunctions().verifyLabelText(headingNewPhoneNumber, "New Phone Number", expHeading);

	}

	public void verifyNewPhoneNumberVerificationCodeWithInvalidData(String expCode, String input) {
		enterText(txtNewPhoneNumber, "New PhoneNumber", expCode);
		String actNewPhoneNumber = getAttributeValue(txtNewPhoneNumber, "value", "New Phone Number");
		if (!actNewPhoneNumber.equals(expCode)) {
			ExtentTestManager.setPassMessageInReport("New Phone Number is Not Accepting" + input + "Character");
		} else {
			ExtentTestManager.setFailMessageInReport("New Phone Number is Accepting" + input + "Character");
		}
	}

	public void clickNewPhoneNumberResend() {
		click(btnNewNumberResend, "Click Resend");
	}

	public void verifyResendDescription(String expHeading) {
		click(btnNewNumberResend, "Click Resend");
		new CommonFunctions().verifyLabelText(lblNewPhoneNumberResendDescription,
				"New Phone Number Resend Verification", expHeading);
	}

	public void verifyResendDescriptionAppears() throws InterruptedException {
		click(btnNewNumberResend, "Click Resend");
		Thread.sleep(2900);
		boolean flag = verifyElementPresence(lblNewPhoneNumberResendDescription, "Resend Verification Appears");
		if (flag) {
			ExtentTestManager.setPassMessageInReport("New Phone Number Resend Verification is Appears Upto 3 seconds");
		} else {
			ExtentTestManager
					.setFailMessageInReport("New Phone Number Resend Verification is not Appears Upto 3 seconds");
		}
	}

	public void verifyResendDescriptionDisappears() throws InterruptedException {
		click(btnNewNumberResend, "Click Resend");
		Thread.sleep(3100);
		boolean flag = verifyElementPresence(lblNewPhoneNumberResendDescription, "Resend Verification Appears");
		if (!flag) {
			ExtentTestManager
					.setPassMessageInReport("New Phone Number Resend Verification is Disappers Upto 3 seconds");
		} else {
			ExtentTestManager
					.setFailMessageInReport("New Phone Number Resend Verification is not Disappers Upto 3 seconds");
		}
	}

	public void paste(String expCode) {
		copyDataToClipboard(expCode);
		String str = getCopiedData();

		if (str.equals(expCode)) {
			ExtentTestManager
					.setPassMessageInReport("New Phone Number Resend Verification is Disappers Upto 3 seconds");
		} else {
			ExtentTestManager
					.setFailMessageInReport("New Phone Number Resend Verification is not Disappers Upto 3 seconds");
		}
	}

}
