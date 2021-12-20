package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SignUpPage extends MobileFunctions {

	private By lnkPersonalAccount = MobileBy.xpath("//*[contains(@resource-id,'personalAccontLL')]|//*[@name='Personal']/preceding-sibling::*[2]");
	private By lnKBusinessAccount = MobileBy.xpath("");
	private By lblCreateAccount = MobileBy.xpath("//*[@text='Create Account']|//*[@name='Create Account']");
	private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id,'firstNameET')]|(//*[@name='First Name'])[1]");
	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'lastNameET')]|(//*[@name='Last Name'])[1]");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'emailET')]|(//*[@name='Email'])[1]");
	private By txtPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]|(//*[@name='usa'])/preceding-sibling::*[1]");
	private By txtPassword = MobileBy.xpath("//*[contains(@resource-id,'passwordET')]|(//*[@name='Password'])[1]");
	private By txtConfirmPassword = MobileBy.xpath("//*[contains(@resource-id,'confirmPasswordET')]|(//*[@name='Confirm Password'])[1]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'nextCV')]|(//*[@name='Next'])[1]");
	private By fieldBar = MobileBy.xpath("//*[contains(@resource-id, 'stregnthViewLL')]/*|(//*[@name='Password'])[1]/following-sibling::*[1]/descendant::*");
	private By headingPhoneNumber = MobileBy.xpath("//*[@text='Please Verify Your Phone Number']");
	private By lnkResend = MobileBy.xpath("//*[contains(@resource-id,'resendTV')]");
	private By iconBackArrow = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By iconCrossMark = MobileBy.xpath("//*[contains(@resource-id,'imgClose')]");
    private By btnDone =MobileBy.xpath("//*[@name='Done']");


	public void clickPersonalAccount() {
		click(lnkPersonalAccount, "Personal Account");
	}

	public void clickBusinessAccount() {
		click(lnKBusinessAccount, "Business Account");
	}

	public void verifyCreateAccount(String createAccount) {
		new CommonFunctions().verifyLabelText(lblCreateAccount, createAccount, "Create Account");
	}

	public void fillFirstName(String firstName) {
		click(txtFirstName, "firstName");
		enterText(txtFirstName, firstName, "FirstName");
	}

	public void fillLastName(String lastName) {
		click(txtLastName, "lastName");
		enterText(txtLastName, lastName, "LastName");
	}

	public void fillEmail(String email) {
		click(txtEmail, "email");
		enterText(txtEmail, email, "Email");
	}

	public void fillPhoneNumber(String phoneNumber) {
		//scrollDownToElement(txtPassword, "Password");
		enterText(txtPhoneNumber, phoneNumber, "PhoneNumber");
        click(btnDone, "Done");
	}

	public void fillPassword(String password) {
		click(txtPassword, "Password");
		enterText(txtPassword, password, "Password");
		click(btnDone, "Done");
	}

	public void fillConfirmPassword(String confirmPassword) {
	//scrollDownToElement(txtConfirmPassword, "Confirm Password");
		click(txtConfirmPassword, "Confirm Password");
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
	
	}

	public void clickNext() {
		//scrollDownToElement(btnNext, "Next");
		click(btnNext, "Next");
	}

	public int fieldBarCount() {
		return getElementList(fieldBar, "field bar").size();

	}

	public void verifyPhoneHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingPhoneNumber, "Phone Heading", expHeading);
	}

	public void verifyPhoneNumberText(String phoneNumber) {
		new CommonFunctions().verifyLabelText(headingPhoneNumber, phoneNumber, phoneNumber);
	}
	public void clickResend() {
		click(lnkResend, "Resend");
	}
	public void clickBackArrow() {
		click(iconBackArrow, "Back Arrow");
	}
	public void clickCrossMark() {
		click(iconCrossMark, "Cross Mark");
	}

	public void fieldValidations() {
		WebElement numberField = DriverFactory.getDriver()
				.findElement(By.xpath("//*[contains(@resource-id,'firstNameET')]"));
		numberField.sendKeys("1234");
		// Retrieve typed value
		String typedValue1 = numberField.getAttribute("value");
		// Get the length of typed value
		int size1 = typedValue1.length();

		if (size1 == 0) {
			System.out.println("Special characters are not allowed");
		} else {
			System.out.println("Characters are allowed");
		}

	}

	public void validateFirstName(String singleChar, String maxChar, String moreThanMax) {
//		new CommonFunctions().validateFieldWithSpecialchar(txtFirstName, "First Name", specialChar);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateFieldWithNumber(txtFirstName, "First Name", number);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().validateFieldMaxichar(txtFirstName, "First Name", moreThanMax);
		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().validateField(txtFirstName, "First Name", singleChar);
		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().validateField(txtFirstName, "First Name", maxChar);
	}

	public void validateLastName(String singleChar, String maxChar, String moreThanMax) {
//		new CommonFunctions().validateFieldWithSpecialchar(txtLastName, "Last Name", specialChar);
//		new CommonFunctions().clearText(txtLastName, "Last Name");
//		new CommonFunctions().validateFieldWithalphabet(txtLastName, "Last Name", number);
//		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateFieldMaxichar(txtLastName, "Last Name", moreThanMax);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateField(txtLastName, "Last Name", singleChar);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateField(txtLastName, "Last Name", maxChar);
	}

	public void validateEmailField(String minChar, String maxChar, String moreThanMax) {
		new CommonFunctions().validateFieldMaxichar(txtEmail, "Email", moreThanMax);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", minChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxChar);

	}

	public void validatePhoneNumber(String maxChar, String moreThanMax) {
		new CommonFunctions().validateFieldMaxichar(txtPhoneNumber, "Phone Number", moreThanMax);
		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
		new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", maxChar);
	}

}
