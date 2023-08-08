package coyni_mobile.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni_mobile.components.AddCardComponent;
import coyni_mobile.components.FieldValidationsComponent;
import coyni_mobile.components.MailingAddressComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.PhoneAndEmailVerificationComponent;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SignUpPage extends MobileFunctions {
//
//	private By btnGetStarted = MobileBy
//			.xpath("//*[contains(@resource-id,'getStartedLL')]|(//*[@name='Get Started'])[1]");
//
////	private By lblCreateAccount = MobileBy.xpath("//*[@text='Create Account']|//*[@name='Create Account']");
//	private By lblCreateAccount = MobileBy.AccessibilityId("Create Account");
////private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id,'firstNameET')]|(//*[@name='First Name'])[1]");
////	private By txtFirstName = MobileBy.AccessibilityId("First Name");
////	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'lastNameET')]|(//*[@name='Last Name'])[1]");
////	private By txtLastName = MobileBy.AccessibilityId("Last Name");
////	private By txtEmail = MobileBy.xpath("(//*[@name='Email'])[1] | (//*[contains(@name,'Email')])[1]");
////	private By txtEmail = MobileBy.AccessibilityId("Email");
//	private By txtEmailField = MobileBy.AccessibilityId("Email Text Field");
////	private By txtPhoneNumber = MobileBy.xpath("//*[@name='Phone Number']");
//	private By txtPhoneNumber = MobileBy.AccessibilityId("Phone Number");
////	private By txtPassword = MobileBy.xpath("(//*[contains(@name,'Password')])[1]");
////	private By txtPassword = MobileBy.AccessibilityId("Password");
////	private By txtConfirmPassword = MobileBy
////			.xpath("//*[contains(@resource-id,'confirmPasswordET')]|(//*[@name='Confirm Password'])[1]");
//	private By txtConfirmPassword = MobileBy.AccessibilityId("Confirm Password");
//	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'nextCV')]|(//*[@name='Next'])[1]");
//	private By lblPasswordReq = MobileBy.xpath("//*[contains(@name,'Must')]");
//	private By headingPhoneNumber = MobileBy.xpath("//*[@text='Please Verify Your Phone Number']");
//	private By lnkResend = MobileBy.xpath("//*[contains(@resource-id,'resendTV')]");
//	private By btnDone = MobileBy.xpath("//*[@name='Done']");
//	private By chckbx = MobileBy.xpath("//*[@name='I agree to']/preceding-sibling::*[1]");
//    private By lblPhnNumErrMsg = MobileBy.xpath("//*[contains(@name,'Entered phone number already')]");
//    private By btnOk = MobileBy.xpath("//XCUIElementTypeButton[@name='OK']");
//    
//    private By lblPwdDoesnotErrMsg = MobileBy.AccessibilityId("Password doesn’t match");
//    
//    
//    public void verifyPhnNumErrorMsg(String expHeading) {
//    	new CommonFunctions().verifyLabelText(lblPhnNumErrMsg, "Error Msg", expHeading);
//    }
//    public void clickOk() {
//    	click(btnOk, "Ok");
//    }
//    
//	public void clickDone() {
//	//	Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
//		if (getElementList(btnDone, "").size() > 0) {
//			click(btnDone, "Done");
////			DriverFactory.getDriver().findElement(btnDone).click();
//		}
//	//	click(btnDone, "Done");
//	}
//
//	
//	public void clickCheckBox() {
//		click(chckbx, "Check box");
//	}
//
//	public void verifyCreateAccount(String createAccount) {
//		new CommonFunctions().verifyLabelText(lblCreateAccount, createAccount, "Create Account");
//	}
//    public void verifyPasswordREquirementError(String errMSg) {
//    	if(getElementList(lblPasswordReq, "Password error").size()>0) {
//    	new CommonFunctions().verifyLabelText(lblPasswordReq, "Password error",  errMSg);
//    }
//    }
//	
//    public void verifyPwdNotMatched(String expErr) {
//    new CommonFunctions().verifyLabelText(lblPwdDoesnotErrMsg, "Confirm Password error message ", expErr);	
//    }
//    
//	
//
//	public void fillEmail(String email) {
//		click(txtEmail, "email");
//		enterText(txtEmail, email, "Email");
//	//	clickDone();
//	}
//
//	public void fillPhoneNumber(String phoneNumber) {
//		scrollDownToElement(txtPhoneNumber, "Password");
//	//	click(txtPhoneNumber, "Phone Number");
//		enterText(txtPhoneNumber, phoneNumber, "PhoneNumber");
//	//	clickDone();
//	}
//
//	
//	public void fillConfirmPassword(String confirmPassword) {
//		scrollDownToElement(txtConfirmPassword, "Confirm Password");
//		click(txtConfirmPassword, "Confirm Password");
//		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
//		if (!new CommonFunctions().isPlatformiOS()) {
//			pressBack();
//		}
//		clickDone();
//	}
//
//	public void clickNext() {
//		scrollDownToElement(btnNext, "Next");
//		click(btnNext, "Next");
//	}
//
//	public void validateCreatePassword() {
//		if (getElementList(lblPasswordReq, "Password Requirement").size() > 0) {
//			ExtentTestManager.setInfoMessageInReport("Password is invalid");
//		} else {
//			ExtentTestManager.setInfoMessageInReport("password is valid");
//		}
//	}
//
//	public void validatePhoneErrorMsg(String errMessage, String elementName) {
//		new CommonFunctions().validateFormErrMsg(errMessage, elementName);
//	}
//
//	public void verifyPhoneHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(headingPhoneNumber, "Phone Heading", expHeading);
//	}
//
//	public void verifyPhoneNumberText(String phoneNumber) {
//		new CommonFunctions().verifyLabelText(headingPhoneNumber, phoneNumber, phoneNumber);
//	}
//
//	public void clickResend() {
//		click(lnkResend, "Resend");
//	}
//
//	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
//		return new PhoneAndEmailVerificationComponent();
//	}
//

//	/**
//	 * Order -minChar, maxChar,maxiPlus
//	 */
//	public void validateEmailFields(String email) {
//		String[] field = email.split(",");
//		for (int i = 0; i < 2; i++) {
//			new CommonFunctions().validateField(txtEmailField, "Email", field[i]);
//		}
//		new CommonFunctions().validateFieldMaxichar(txtEmailField, "Email", field[2]);
//	}
//
//	
//	/**
//	 * Order - minChar, max, MaxiPlus
//	 * @throws InterruptedException 
//	 */
//	public void validateCreatePasswordfields(String password) {
//		String[] field = password.split(",");
//		for(int i=0;i<2;i++) {
//		new CommonFunctions().validateTextFeild(txtPassword, "password", field[i]);
////		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
//		}
//		new CommonFunctions().validateFieldMaxichar(txtPassword, "password", field[2]);	
//	}
//	
//	/**
//	 * Order - minChar, max, MaxiPlus
//	 * @throws InterruptedException 
//	 */
//	public void CreatePasswordfields(String password) {
//		String[] field = password.split(",");
//	//	for(int i=0;i<2;i++) {
//		new CommonFunctions().validateTextFeild(txtPassword, "password", field[0]);
//		new CommonFunctions().validateTextFeild(txtPassword, "password", field[1]);
////		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
//	//	}
//		new CommonFunctions().validateFieldMaxichar(txtPassword, "password", field[2]);	
//	}
//	
//	
//	
//	public void validateConfirmPasswordfields(String password) throws InterruptedException {
//		String[] field = password.split(",");
//		for(int i=0;i<2;i++) {
//		new CommonFunctions().validateTextFeild(txtConfirmPassword, "password", field[i]);
//	//	Thread.sleep(1000);
//	//	new CommonFunctions().validateField(txtPassword, "password", field[1]);
//		}
//		new CommonFunctions().validateFieldMaxichar(txtConfirmPassword, "password", field[2]);	
//	}
//	
//

//	
//	public void validateAddressField(By ele, String eleName, String textField) {
//		String[] field = textField.split(",");
//		new CommonFunctions().validateField(ele, eleName, field[0]);
//		new CommonFunctions().validateField(ele, eleName, field[1]);
//		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[2]);
//	}
//	
//	
//	
//
//	public void validateFirstNameField(String firstName) {
//		validateNameField(txtFirstName, "First Name", firstName);
//	//	clickDone();
//	}
//
//	public void validateLastNameField(String LastName) {
//		validateNameField(txtLastName, "Last Name", LastName);
//	//	clickDone();
//	}
//
//	public NavigationComponent navigationComponent() {
//		return new NavigationComponent();
//	}
//

//
//	public MailingAddressComponent mailingAddressComponent() {
//		return new MailingAddressComponent();
//	}
//	

//    

//	public TokenAccountPage tokenAccountPage() {
//		return new TokenAccountPage();
//	}
//	public void companyInfoComponent() {
//		// TODO Auto-generated method stub
//
//	}

	/**************
	 * 
	 */
	private By lblPhoneNumber = MobileBy.AccessibilityId("Phone Number Heading");
	private By txtPhoneNumber = MobileBy.AccessibilityId("Phone Number");
	private By lblPhoneDesc = MobileBy.AccessibilityId("Enter Phone");
	private By drpdwnPhNum = MobileBy.id("com.coyni.mapp:id/tvCountryCode");
	private By txtSearchField = MobileBy.AccessibilityId("Country Search");
	private By btnSearchCross = MobileBy.AccessibilityId("Clear text");
	private By btnContinue = MobileBy.id("com.coyni.mapp:id/tvButton");
	private By lblEmail = MobileBy.xpath("//*[@text='Email']");
	private By lblEmailDesc = MobileBy.AccessibilityId("Email Verification Text");
	private By txtEmail = MobileBy.id("com.coyni.mapp:id/emailET");
	private By lblName = MobileBy.AccessibilityId("Name");
	private By lblNameDesc = MobileBy.AccessibilityId("Enter Your Full Name");
	private By txtFirstName = MobileBy.id("com.coyni.mapp:id/etName");
	private By txtLastName = MobileBy.AccessibilityId("Last Name");
	private By lblPassword = MobileBy.AccessibilityId("Password Heading");
	private By lblPasswordDesc = MobileBy.AccessibilityId("Keep Your Account Secure");
	private By txtPassword = MobileBy.AccessibilityId("Password");
	private By btnEye = MobileBy.id("com.coyni.mapp:id/text_input_end_icon");
//	private By txtPwdErrMSg = MobileBy.id("8 to 32");
	private By lblPasswordReq = MobileBy.xpath("8 to 32");

	public void VerifyPhoneNumberHeading(String phoneNumDesc) {
		new CommonFunctions().elementView(lblPhoneNumber, "Phone Number Heading");
		new CommonFunctions().verifyLabelText(lblPhoneDesc, "Phone Number Description is", phoneNumDesc);
	}

	public void viewPhoneNumberHeading() {
		new CommonFunctions().elementView(lblPhoneNumber, "Phone Number Heading");
		ExtentTestManager.setPassMessageInReport(getText(lblPhoneNumber));
	}

	public void fillPhoneNumbers(String PhoneNumber) {
		enterText(txtPhoneNumber, PhoneNumber, "Phone Number");
	}

	public void verifyPhoneNumber() {
		if (getText(txtPhoneNumber).equals("")) {
			ExtentTestManager.setPassMessageInReport("After changing the country Phone Number field is refreshing");
		} else {
			ExtentTestManager.setFailMessageInReport("After changing the country Phone Number field is not refreshing");
		}
	}

	public void clickDopdown() {
		click(drpdwnPhNum, "Country Dropdown ");
	}

	public void fillSearch(String country) {
		enterText(txtSearchField, country, "country");
		new CommonFunctions().clickEnter();
		new CommonFunctions().clickEnter();
	}

	public void clickSearchCross() {
		click(btnSearchCross, "Cross");
	}

	public void clickContinue() {
		click(btnContinue, "Contiue");
	}

	public void verifyContinue() {
		new CommonFunctions().verifyDisabledElement(btnContinue, "Contiue");
	}

	public void verifyEmailHeading(String emailDesc) {
		new CommonFunctions().elementView(lblEmail, "Email heading");
		ExtentTestManager.setPassMessageInReport(getText(lblEmail));
		new CommonFunctions().verifyLabelText(lblEmailDesc, "Description", emailDesc);
	}

	public void viewEmailHeading() {
		new CommonFunctions().elementView(lblEmail, "Email heading");
		ExtentTestManager.setPassMessageInReport(getText(lblPhoneNumber));
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void verifyNameView(String nameDesc) {
		new CommonFunctions().elementView(lblName, "Email");
		ExtentTestManager.setPassMessageInReport(getText(lblName));
		new CommonFunctions().verifyLabelText(lblNameDesc, "Description", nameDesc);
	}

	public void fillFirstName(String firstName) {
		click(txtFirstName, "firstName");
		enterText(txtFirstName, firstName, "FirstName");
	}

	public void fillLastName(String lastName) {
		click(txtLastName, "lastName");
		enterText(txtLastName, lastName, "LastName");
	}

	public void clickFirstName() {
		click(txtFirstName, "First Name");
	}

	public void clickLastName() {
		click(txtLastName, "Last Name");
	}

	public void verifyPasswordView(String passwordDesc) {
		new CommonFunctions().elementView(lblPassword, "Password");
		new CommonFunctions().verifyLabelText(lblPasswordDesc, "Description", passwordDesc);
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
		click(txtPassword, "Password");
	}

	public void clickEyeIcon() {
		click(btnEye, "Password Eye Icon");
	}

//	public void verifyPasswordErrorMSg(String errMsg) {
//		new CommonFunctions().verifyLabelText(txtPwdErrMSg, "errMsg", errMsg);
//	}

	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
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

	/**
	 * Order -minChar, maxChar,maxiPlus
	 */
	public void validateEmail(String email) {
		String[] field = email.split(",");
		for (int i = 0; i < 2; i++) {
			new CommonFunctions().validateField(txtEmail, "Email", field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(txtEmail, "Email", field[2]);
	}

	/**
	 * // Order -minChar, maxChar, specialChar, Number, maxiPlus
	 */
	public void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 2; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 2; j < 4; j++) {
			System.out.println(field[j]);
//			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
	}

	public void validateFirstNameField(String firstName) {
		validateNameField(txtFirstName, "First Name", firstName);
		// clickDone();
	}

	public void validateLastNameField(String LastName) {
		validateNameField(txtLastName, "Last Name", LastName);
		// clickDone();
	}

	/**
	 * Order - minChar, max, MaxiPlus
	 * 
	 * @throws InterruptedException
	 */
	public void CreatePasswordfields(String password) {
		String[] field = password.split(",");
		// for(int i=0;i<2;i++) {
//		new CommonFunctions().validateTextFeild(txtPassword, "password", field[0]);
//		new CommonFunctions().validateTextFeild(txtPassword, "password", field[1]);
//		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
		// }
		new CommonFunctions().validateFieldMaxichar(txtPassword, "password", field[2]);
	}

	public void verifyPasswordREquirementError(String errMSg) {
		if (getElementList(lblPasswordReq, "Password error").size() > 0) {
			new CommonFunctions().verifyLabelText(lblPasswordReq, "Password error", errMSg);
		}
	}

	public DashboardPage dashboardPage() {
		return new DashboardPage();
	}

	public CustomerProfilePage customerProfilePage() {
		return new CustomerProfilePage();
	}

	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public LoginPage loginPage() {
		return new LoginPage();
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}
