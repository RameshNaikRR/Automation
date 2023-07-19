package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.FieldValidationsComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.PhoneAndEmailVerificationComponent;
import coyni_mobile.components.ToastComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;

public class LoginPage extends MobileFunctions {
	private By imgCoyni = MobileBy.AccessibilityId("coyni Logo");
	private By txtEmail = MobileBy.id("com.coyni.mapp:id/emailET");
	private By txtPassword = MobileBy.AccessibilityId("Password");
	private By chkBxRememberMe = MobileBy.AccessibilityId("Remember Me");
	private By lnkForgotPassword = MobileBy.AccessibilityId("Forgot Password");
	private By lnkRetrieveEmail = MobileBy.AccessibilityId("Retrieve Email");
	private By btnLogin = MobileBy.id("com.coyni.mapp:id/loginButton");
	private By btnEyeIcon = MobileBy.id("com.coyni.mapp:id/endIconIV");
//	Login Error PopUp Details
	private By lblIncorrectHeading = MobileBy.xpath("//*[contains(@text,'incorrect')]");
	private By lblIncorrectDesc = MobileBy.xpath("//*[contains(@text,'Please try again')]");
	private By lblDataNotFoundHeading = MobileBy.id("com.coyni.mapp:id/tvHead");
	private By lblDataNotFoundDesc = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By btnOkay = MobileBy.xpath("//*[contains(@text,'Ok')]");

//	Forgot Password Details
	private By lblForgotYourPassword = MobileBy.AccessibilityId("Forgot Your Password?");
	private By lblForgotPwdDesc = MobileBy.AccessibilityId("Enter your registered email.");
	private By btnNext = MobileBy.id("com.coyni.mapp:id/tvButton");

//	Retrieve Email Details
	private By lblRetrieveEmail = MobileBy.id("com.coyni.mapp:id/heading");
	private By lblRetrieveEmailDesc = MobileBy.id("com.coyni.mapp:id/description");
	private By txtPhoneNumber = MobileBy.id("com.coyni.mapp:id/etPhoneNo");
	private By txtFirstName = MobileBy
			.xpath("//*[contains(@resource-id,'etFName')]/descendant::android.widget.EditText");
	private By txtLastName = MobileBy
			.xpath("//*[contains(@resource-id,'etLName')]/descendant::android.widget.EditText");
	private By drpPhNum = MobileBy.id("com.coyni.mapp:id/tvCountryCode");
	private By txtCountry = MobileBy.id("com.coyni.mapp:id/searchET");
	private By noUserDesc = MobileBy.id("com.coyni.mapp:id/description");
	private By btnTryAgain = MobileBy.xpath("//*[@text='Try Again']");
	private By btnCancel = MobileBy.id("com.coyni.mapp:id/tvCancel");
	private By lblWeFoundAccount = MobileBy.xpath("//*[@text='We Found Your Account']|//*[@text='No User Found']");
	private By imgWeFoundAccounnt = MobileBy.AccessibilityId("We Found Your Account");
	private By lblUserName = MobileBy.id("com.coyni.mapp:id/tvName");
	private By lblEmail = MobileBy.id("com.coyni.mapp:id/tvEmail");
	private By btnRetrieveLogin = MobileBy.id("com.coyni.mapp:id/tvLogin");
	private By btnArrow = MobileBy.id("com.coyni.mapp:id/ivArrow");
	private By lblUserLogo = MobileBy.id("com.coyni.mapp:id/profileIV");
	private By btnThisisNotMe = MobileBy.xpath("//*[@text='This is not me']");
	private By btnSearchClearTxt = MobileBy.id("com.coyni.mapp:id/clearTextLL");

////	PIN disabled popup
	private By lblPINDisHead = MobileBy.id("com.coyni.mapp:id/tvHead");
	private By lblPINDisDes = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By btnPINDisOk = MobileBy.id("com.coyni.mapp:id/cvAction");

	public void verifyImageCoyniView() {
		new CommonFunctions().elementView(imgCoyni, "Coyni");
//		SimilarityMatchingOptions opts = new SimilarityMatchingOptions();
//		opts.withEnabledVisualization();
//		SimilarityMatchingResult res = DriverFactory.getDriver().getImagesSimilarity(baselineImg,  DriverFactory.getDriver().getScreenshotAs(OutputType.FILE), opts);
	}

	public void verifyLoginEmail(String email) {
		new CommonFunctions().verifyLabelText(txtEmail, "email", email);
	}

	public void clickEmail() {
		click(txtEmail, "Email");
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "email");
	}

	public void verifyEmailAutoFocus(String email) {
		new CommonFunctions().verifyAutoFocusElement(txtEmail, "email");
	}

	public void clcikPassword() {
		click(txtPassword, "password");
	}

	public void clcikEyeIcon() {
		click(btnEyeIcon, "Eye Icon");
	}

	public void verifyLogin(String email, String password) {
		if (getElement(imgCoyni, "coyni image").isDisplayed()) {
			fillEmail(email);
			fillPassword(password);
			clickLogin();
		}
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "password ");
	}

	public void clickRememberMe() {
		click(chkBxRememberMe, "Remember");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "Forgot Password ");
	}

	public void clickRetrieveEmail() {
		click(lnkRetrieveEmail, "Retrieve Email ");
	}

	public void verifyLoginScreenView() {
		new CommonFunctions().elementView(imgCoyni, "Coyni");
		new CommonFunctions().elementView(chkBxRememberMe, "Rememeber Me");
		new CommonFunctions().elementView(lnkForgotPassword, "Forgot Password");
		new CommonFunctions().elementView(lnkRetrieveEmail, "Retrieve Email");
	}

	/**
	 * Order - minChar, max, MaxiPlus
	 * 
	 * @throws InterruptedException
	 */
	public void validateCreatePasswordfields(String password) {
		String[] field = password.split(",");
		for (int i = 0; i < 2; i++) {
//			new CommonFunctions().validateTextFeild(txtPassword, "password", field[i]);
//		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
		}
		new CommonFunctions().validateFieldMaxichar(txtPassword, "password", field[2]);
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public void clickLogin() {
		click(btnLogin, "login button");
	}

	private void minimizePopup() {
		if (DriverFactory.getDriver().findElement(btnLogin).isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Invalid credentials error popup closed");
		} else {
			ExtentTestManager.setFailMessageInReport("Invalid credentilas error popup not closed");
		}
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}

	public void selectCountry(String country) {
		enterText(txtCountry, country, "Country Search");
		new CommonFunctions().clickEnter();
		new CommonFunctions().clickEnter();
	}

	public void validateSelectCountry(String country) {
		enterText(txtCountry, country, "Country Search");
		click(btnSearchClearTxt, "Clear Text");
		String search = getText(txtCountry);
		if (search.length() == 0 || search.equals("Country / Country Code")) {
			ExtentTestManager
					.setPassMessageInReport("Search bar is clearing the text, after clicked on clear text button");
		} else {
			ExtentTestManager
					.setFailMessageInReport("Search bar is not clearing the text, after clicked on clear text button");
		}
		enterText(txtCountry, country, "Country Search");
		new CommonFunctions().clickEnter();
		new CommonFunctions().clickEnter();
	}
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public SignUpPage signUpPage() {
		return new SignUpPage();
	}

	public void verifyIncorrectPopupDescription(String expHeading, String expDescription) {
		new CommonFunctions().verifyLabelText(lblIncorrectHeading, "Email or Password incorrect heading", expHeading);
		new CommonFunctions().verifyLabelText(lblIncorrectDesc, "Email or Password incorrect description",
				expDescription);
	}

	public void verifyDataNotFoundPopupDescription(String expDescription) {
		new CommonFunctions().elementView(lblDataNotFoundHeading, "Popup heading");
		ExtentTestManager.setPassMessageInReport(getText(lblDataNotFoundHeading));
		new CommonFunctions().verifyLabelText(lblDataNotFoundDesc, "User Data Not Found description", expDescription);
	}

//
//	public void minimizePopupBySwipeDown() {
//		swipeOnElement(popUperror, "popUp", SwipeDirection.DOWN);
//		minimizePopup();
//	}

	public void minimizePopupByClikingOK() {
		click(btnOkay, "OK button");
		minimizePopup();
	}

//Retrieve Email Details
	public void verifyRetrievEmailDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblRetrieveEmailDesc, "retrieve Email desc", desc);
	}

	public void verifyRetrievEmailHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblRetrieveEmail, "RetrieveEmail", heading);
	}

	public void validateThisIsNotMe() {
		DriverFactory.getDriver().hideKeyboard();
		String fstName = getText(txtFirstName);
		String lstName = getText(txtLastName);
		String PhNum = getText(txtPhoneNumber);
		if ((fstName.equals("") || fstName.equals("First Name")) && (lstName.equals("") || lstName.equals("Last Name"))
				&& (PhNum.equals("") || PhNum.equals("Phone Number"))) {
			ExtentTestManager.setPassMessageInReport(
					"After clicking on 'This is not me' its erased all the information in 'Retrieve Email' screen");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"After clicking on 'This is not me' its not erased all the information in 'Retrieve Email' screen");
		}
	}

	public void fillPhoneNumber(String phoneNum) {
		click(txtPhoneNumber, "Phone Number");
		enterText(txtPhoneNumber, phoneNum, "Phone Number");
	}

	public void fillFirstName(String firstName) {
		click(txtFirstName, "First Name");
		enterText(txtFirstName, firstName, "First Name");
	}

	public void clickFirstName() {
		click(txtFirstName, "First Name");
	}

	public void clickLastName() {
		click(txtLastName, "Last Name");
	}

	public String validateRetrieveEmail() {
		return getText(lblEmail);
	}

	public String validateLoginEmail() {
		return getText(txtEmail);
	}

	public void fillLastName(String lastName) {
		DriverFactory.getDriver().hideKeyboard();
		click(txtLastName, "Last Name");
		enterText(txtLastName, lastName, "Last Name");
	}

	public void clickDrpDwPhNum() {
		click(drpPhNum, "Country Drop Down");
	}

	public void fillCountry(String country) {
		enterText(txtCountry, country, "Country Search");
	}

	public void verifyNoUserFound(String desc) {
		new CommonFunctions().elementView(imgWeFoundAccounnt, "No User found image");
		new CommonFunctions().elementView(lblWeFoundAccount, "No user Found");
		ExtentTestManager.setPassMessageInReport(getText(lblWeFoundAccount));
		new CommonFunctions().verifyLabelText(noUserDesc, "No user found desc", desc);
	}

	public void viewNoUserFound() {
		new CommonFunctions().elementView(lblWeFoundAccount, "No user Found");
		ExtentTestManager.setPassMessageInReport(getText(lblWeFoundAccount));
	}

	public void verifyWeFoundYourAccount(String firstName, String lastName) {
		new CommonFunctions().elementView(imgWeFoundAccounnt, "image");
		new CommonFunctions().elementView(lblWeFoundAccount, "We Found Your Account");
		ExtentTestManager.setPassMessageInReport(getText(lblWeFoundAccount));
		String[] name = getText(lblUserName).split(" ");
		String firstNam = name[0];
		String lastNam = name[1];
		if (firstNam.equals(firstName) && lastNam.equals(lastName)) {
			ExtentTestManager.setPassMessageInReport("Its showing the valid First Name and Last Name");
		} else {
			ExtentTestManager.setFailMessageInReport("Its not showing the valid First Name and Last Name");
		}
		new CommonFunctions().elementView(lblEmail, "Email");
		ExtentTestManager.setPassMessageInReport(getText(lblEmail));
		new CommonFunctions().elementView(lblUserLogo, "User Logo");
		new CommonFunctions().elementView(btnArrow, "Login Arrow");
	}

	public void clickRetrieveLogin() {
		click(btnRetrieveLogin, "Login");
	}

	public void viewWeFoundYourAccount() {
		new CommonFunctions().elementView(lblWeFoundAccount, "We Found Your Account");
		ExtentTestManager.setPassMessageInReport(getText(lblWeFoundAccount));
	}

	public void clickThisisNotMe() {
		click(btnThisisNotMe, "ThisisNotMe");
	}

	public void clickTryAgain() {
		click(btnTryAgain, "Try Again");
	}

	public void clickcancel() {
		click(btnCancel, "Cancel");
	}

	public void validateClearTextOfSearch() {
		click(btnSearchClearTxt, "Clear Text");
		String search = getText(txtCountry);
		if (search.length() == 0 || search.equals("Country / Country Code")) {
			ExtentTestManager
					.setPassMessageInReport("Search bar is clearing the text, after clicked on clear text button");
		} else {
			ExtentTestManager
					.setFailMessageInReport("Search bar is not clearing the text, after clicked on clear text button");
		}
	}

	public void verifyForgotYourPasswordDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblForgotPwdDesc, "Description", desc);
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next button is disabled");
		}
	}

	public void verifyDisabledStateNext() {
		new CommonFunctions().verifyDisabledElement(btnNext, "Next");
	}

//Forgot Password Details
	public void verifyForgotYourPWdHeading(String hdg) {
		new CommonFunctions().elementView(lblForgotYourPassword, "Forgot Your Password");
	}

//	PIN Disabled popup details
	public void viewDisabledPINPopup() {
		new CommonFunctions().elementView(lblPINDisHead, "Disabled popup heading");
		new CommonFunctions().elementView(lblPINDisDes, "Disabled popup description");
	}

	public void clickDisPINOk() {
		click(btnPINDisOk, "Ok");
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}