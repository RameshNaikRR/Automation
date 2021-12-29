package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.ForgotEmailComponent;
import coyni.customer.components.PhoneVerificationComponent;
import coyni.customer.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class HomePage extends BrowserFunctions {
	private By lnkPersonalAccount = By.xpath("//div[text()='Personal Account']");
	private By landingPageHeading = By.xpath("//span[text()='Create a Coyni Account']");
	private By lnkpersonalAccount = By.xpath("//div[contains(text(),'Personal Account')]");
	private By lnkBusinessAccount =By.xpath("//div[contains(text(),'Business Account')]");
	private By lnkLogin = By.xpath("//span[contains(text(),'Log In')]");
	private By lblCreateAccount =By.cssSelector(".disclaimer");
	private By lblPersonalAccount =By.xpath("//div[contains(text(),'Personal Account')]/following-sibling::*[1]");
	private By lblBusinessAccount =By.xpath("//div[contains(text(),'Business Account')]/following-sibling::*[1]");
	private By lblBusinessAccountTooltip =By.xpath("//*[@id='businessAccount']/text()");
	
	private By lblLastName = By.xpath("//label[text()='Last Name']");
	private By lblEmail = By.xpath("//input[@id='email-address']/preceding-sibling::*[1]");
	private By lblPhoneNumber = By.xpath("//input[@id='phone-number']/preceding-sibling::*[1]");
	private By lblCreatePassword = By.xpath("//input[@id='create-password']/preceding-sibling::*[1]");
	private By lblConfirmPassword = By.xpath("//input[@id='confirm-password']/preceding-sibling::*[1]");
	
	private By createHeading = By.xpath("//span[contains(text(),'Create a Personal Account')]");
	private By txtFirstName = By.id("first-name");
	private By txtLastName = By.id("last-name");
	private By txtEmail = By.id("email-address");
	private By txtPhoneNumber = By.id("Phone_Number");
	private By txtCreatePassword = By.id("create-password");
	private By txtConfirmPassword = By.id("confirm-password");
	private By lnkprivacyPolicy = By.xpath("//span[contains(text(),'Privacy Policy')]");
	private By lnkTermsOfService = By.xpath("//span[contains(text(),'Terms of Services.')]");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By iconCreatePassword = By.cssSelector(".icon-button");
	private By iconConfirmPassword = By.cssSelector(".icon-button");
	private By reddot = By.cssSelector(".red-dot");
	private By greendot = By.xpath("//span[@class='green-dot']/parent::span");
	private By greendot1 = By.xpath("(//span[@class='green-dot']/parent::span)[2]");
	private By chkBox = By.cssSelector(".custom-checkbox ");
	
    public void clickCheckBox() {
    	click(chkBox, "CheckBox");
    }
	public void verifyPersonalAccountView() {
		new CommonFunctions().elementView(lnkpersonalAccount, "Personal Account link");
		new CommonFunctions().verifyCursorAction(lnkpersonalAccount, "Personal Account");
	}
	public void verifyBusinessAccountView() {
		new CommonFunctions().elementView(lnkBusinessAccount, "Business Account link");
		moveToElement(lnkBusinessAccount, "Business Account");
	//	verifyElementDisabled(lnkBusinessAccount, "Business Account");
	//	verifyElementPresence(lblBusinessAccountTooltip, "Tool tip");
	}
	
	public void verifyLoginView() {
		new CommonFunctions().elementView(lnkLogin, "Login link");
		new CommonFunctions().verifyCursorAction(lnkLogin, "Login");
	}
	public void verifyCreateAccountSubTitleView() {
		new CommonFunctions().elementView(lblCreateAccount, "Create Account disclaimer ");
	}
	public void verifyPersonalAccountSubTitleView() {
		new CommonFunctions().elementView(lblPersonalAccount, "Personal Account subtitle ");
	}
	public void verifyBusinessAccountSubTitleView() {
		new CommonFunctions().elementView(lblBusinessAccount, "Business Account subtitle ");
	}
	public void verifyFirstNameAutoFocus() {
		new CommonFunctions().verifyAutoFocus(txtFirstName, "First Name");
	}
//	public void verifyElementOpacity() {
//		new CommonFunctions().verifyElementOpacity(lblLastName, "Last Name");
//	}
	public void fillCreatePassword1(String createPassword) {
		enterText(txtCreatePassword, createPassword, "Create Password");
	}
	
	public void verifyLandingPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(landingPageHeading, "Langing Page heading", expHeading);
	}

	public void clickPersonalAccount() {
		click(lnkpersonalAccount, "Link Personal ");
	}

	public void clickLogin() {
		click(lnkLogin, "Click Login");
	}

	public void verifyCreateAccountPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(createHeading, "Create Personal account Heading", expHeading);
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
	}

	public void fillEmail(String userName) {
		enterText(txtEmail, userName, "Email");
	}

	public void fillPhoneNumber(String PhoneNumber) {
		enterText(txtPhoneNumber, PhoneNumber, "PhoneNumber");
	}

	public void fillCreatePassword(String createPassword) throws InterruptedException {
		String[] inputs = { "H", "h", "qazwsxeh", "qazwsxedcrfv", "@", "1" };
		String[] messages = { "uppercase", "lowercase", "total characters", "total characters", "special character", "number" };
		for (int i = 0; i < inputs.length; i++) {
			enterText(txtCreatePassword, inputs[i], "Create Password");
			String text = "";
			if (inputs[i].length() >= 8) {
				 text = getText(greendot1, "Validation Dot");
			}else {
				text = getText(greendot, "Validation Dot");
			}
			if (text.toLowerCase().contains(messages[i])) {
				ExtentTestManager.setPassMessageInReport("Password field satisifies strength condition : " + text);
			} else {
				ExtentTestManager
						.setFailMessageInReport("Password field does not satisifies strength condition : " + text);
			}
//			new CommonFunctions().clearText(txtCreatePassword, "Create Password");
			clearText(txtCreatePassword, "Create Password");
		}
		int initialRedDot = getElementsList(reddot, "red dot").size();
		Thread.sleep(100);
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		Thread.sleep(100);
		enterText(txtCreatePassword, createPassword, "Create Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		System.out.println("value: "+initialRedDot+" "+initialGreenDot+" "+finalRedDot+" "+finalGreenDot);
		if (initialGreenDot == finalRedDot && initialRedDot == finalGreenDot && finalRedDot == initialGreenDot
				&& finalGreenDot == initialRedDot) {
			ExtentTestManager.setPassMessageInReport("password is valid");
		} else {
			ExtentTestManager.setFailMessageInReport("password is invalid");
		}
	}

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
	}

	public void clickprivacyPolicy() {
		click(lnkprivacyPolicy, "Privacy Policy");
	}

	public void clickTermsOfService() {
		click(lnkTermsOfService, "Privacy Policy");
	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickCreateIcon() {
		click(iconCreatePassword, "Create Icon");
	}

	public void clickConfirmIcon() {
		click(iconConfirmPassword, "Confirm Icon");
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}
	public void validateFirstNameField(String minChar,String minCharPlus,  String maxLessChar, String maxChar, String moreThanMaxChar, String number,
			String specialChar) {
		new ForgotEmailComponent().validateFirstName(minChar,minCharPlus,maxLessChar,maxChar,moreThanMaxChar,number,specialChar);
	}
	public void validateLastNameField(String minChar,String minCharPlus,  String maxLessChar, String maxChar, String moreThanMaxChar, String number,
			String specialChar) {
		new ForgotEmailComponent().validateLastName(minChar,minCharPlus,maxLessChar,maxChar,moreThanMaxChar,number,specialChar);
	}
	public void validatePhoneNumberField(String maxChar, String moreThanMaxChar, String alphabets, String specialChar) {
		new ForgotEmailComponent().validatePhoneNumber(maxChar,moreThanMaxChar,alphabets,specialChar);
	}
	
    public void validateEmailField(String minChar,String minCharPlus,String maxLessChar, String maxChar, String moreThanMax) {
		
		new CommonFunctions().validateFieldMaxichar(txtEmail, "Email", moreThanMax);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", minChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", minCharPlus);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxLessChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxChar);
		
		
	}

//	public void validateFirstNameField(String singleChar, String maxChar, String moreThanMax, String specialChar,
//			String number) {
//		
//		new CommonFunctions().validateFieldWithSpecialchar(txtFirstName, "First Name", specialChar);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateFieldWithNumber(txtFirstName, "First Name", number);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateFieldMaxichar(txtFirstName, "First Name", moreThanMax);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateField(txtFirstName, "First Name", singleChar);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateField(txtFirstName, "First Name", maxChar);
//	}

//	public void validateLastNameField(String singleChar, String maxChar, String moreThanMax, String specialChar,
//			String number) {
//		
//		new CommonFunctions().validateFieldWithSpecialchar(txtLastName, "Last Name", specialChar);
//		new CommonFunctions().clearText(txtLastName, "Last Name");
//		new CommonFunctions().validateFieldWithNumber(txtLastName, "Last Name", number);
//		new CommonFunctions().clearText(txtLastName, "Last Name");
//		new CommonFunctions().validateFieldMaxichar(txtLastName, "Last Name", moreThanMax);
//		new CommonFunctions().clearText(txtLastName, "Last Name");
//		new CommonFunctions().validateField(txtLastName, "Last Name", singleChar);
//		new CommonFunctions().clearText(txtLastName, "Last Name");
//		new CommonFunctions().validateField(txtLastName, "Last Name", maxChar);
//
//	}

//	public void validatePhoneNumberField(String minChar, String moreThanMax, String alphabets,
//			String specialCharacters) {
//		
//		new CommonFunctions().validateFieldWithSpecialchar(txtPhoneNumber, "Phone Number", alphabets);
//		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
//		new CommonFunctions().validateFieldWithNumber(txtPhoneNumber, "Phone Number", specialCharacters);
//		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
//		new CommonFunctions().validateFieldMaxichar(txtPhoneNumber, "Phone Number", moreThanMax);
//		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
//		new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", minChar);
//		
//	}

	

//	public void validateCreatePasswordField(String minChar, String maxChar, String moreThanMax) {
//		
//		
//		new CommonFunctions().validateFieldMaxichar(txtCreatePassword, "Create password", moreThanMax);
//		new CommonFunctions().clearText(txtCreatePassword, "Create password");
//		new CommonFunctions().validateField(txtCreatePassword, "Create password", maxChar);
//		new CommonFunctions().clearText(txtCreatePassword, "Create password");
//		new CommonFunctions().validateField(txtCreatePassword, "Create password", minChar);
//		
//	}
//
//	public void validateConfirmPasswordField(String minChar, String maxChar, String moreThanMax) {
//		
//		new CommonFunctions().validateFieldMaxichar(txtConfirmPassword, "Confirm password", moreThanMax);
//		new CommonFunctions().clearText(txtConfirmPassword, "Confirm password");
//		new CommonFunctions().validateField(txtConfirmPassword, "Confirm password", maxChar);
//		new CommonFunctions().clearText(txtConfirmPassword, "Confirm password");
//		new CommonFunctions().validateField(txtConfirmPassword, "Confirm password", minChar);
//	
//		clickConfirmIcon();
//	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
