package coyni.customer.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class HomePage extends BrowserFunctions {
	private By lnkPersonalAccount = By.cssSelector("div[class='pt-3 pb-3 font-bold text-center 1xl:text-lg 2xl:text-xl text-cm3']");
	private By lnkBusinessAccount = By.cssSelector("div[currentitem='false']");
	private By lnkLogIn = By.xpath("//span[contains(text(),'Log In')]");
	private By lnkSignUp = By.cssSelector("span[class='font-semibold cursor-pointer text-cm3 hover:underline']");
	private By lblCreateAccount = By.xpath("//span[contains(text(), 'Create an Account')]");
	private By lblPersonalAccount = By.xpath("//div[contains(text(),'Personal Account')]");
	private By lblBusinnesAccount = By.xpath("//div[text()='Business Account']");
	private By lblLogin = By.xpath("//span[text()='Log In']");
	private By lblCreateAnAccountText = By.xpath("//p[@class='disclaimer']");
	private By lblPersonalAccountText = By.cssSelector("a[href='/choose-account/create-account/personal-account'] p");
	private By lblBusinessAccountText = By.xpath("//p[contains(text(),'Used for receiving token')]");
	private By lblCreateAPersonAccountText = By.xpath("//span[contains(text(),'Create a Personal Account')]");
	private By lblCreateAPersonalAccountDescriptionText = By.cssSelector("div[class='create-account__form'] p");
	private By lblBusinessAccountTooltip = By.xpath("//div[@class='__react_component_tooltip tc400c05a-2593-4ab8-a062-5bfe85d97f35 place-top type-dark items-center text-center text-cwhite']");

	private By SignUpElements =By.xpath("");
	private By passErrorMsg = By.cssSelector("");
	private By txtFirstName = By.cssSelector("input[name='first_name']");
	private By txtLastName = By.cssSelector("input[name='last_name']");
	private By txtEmail = By.cssSelector("input[id='email-address']");

	private By txtCreatePasswordFiled = By.cssSelector("input[name='create_password']");
	private By lblCreatePasswordRequirementsToolTipText = By.cssSelector("span.criteria span");
	private By lblConfirmPassword = By.cssSelector("label[for='confirm-password']");
	private By opacity = By.cssSelector("div[style='opacity: 1; transform: none;']");
	private By txtConfirmPasswordFiled = By.cssSelector("input[name='confirm_password']");
	private By btnNext = By.xpath("//button[text()='Next']");

	private By txtPhoneNumber = By.cssSelector("input[id='phone-number']");
	private By lnkCreatePasswordShowIcon = By.cssSelector("button[class='icon-button  icon-password-hide-new fix-eye view-password']");
	private By lnkConfirmPasswordShowIcon = By.cssSelector("button[class='icon-button  icon-password-hide-new  view-password']");
	private By lnkPrivacyPolicy = By.xpath("//span[text()='Privacy Policy']");
	private By lnkTermsOfServices = By.xpath("//span[contains(text(),' Terms of Services.')]");
	private By lblLogInToCoyni = By.xpath("//span[contains(text(),'Log In to Coyni')]");
	private By lblPhoneVerification = By.cssSelector("div[class='font-bold tracking-wide cursor-default text-cgy4 SmsValidation_title__3ok9r']");
	private By lblPhoneVericationText = By.cssSelector("div[class='flex mt-5 cursor-default'] p");
	private By lblResend = By.xpath("//div[text()='Resend']");
	private By lblGoBack = By.xpath("//div[contains(text(),'Go Back')]");
	private By lblPhoneNumber = By.cssSelector("div[class='flex mt-5 cursor-default'] p span");
	
	
	public void clickPersonalAccount() {
		click(lnkPersonalAccount, "Personal Account");
	}

	public void verifyHomePageOptions(String expCreateAccountText, String expPersonalAccountText,
			String expBusinessAccountText, String expLogin) {

		new CommonFunctions().verifyLabelText(lblCreateAccount, "Create Account Title is", expCreateAccountText);
		new CommonFunctions().verifyLabelText(lblPersonalAccount, "Personal Account Title is", expPersonalAccountText);
		new CommonFunctions().verifyLabelText(lblBusinnesAccount, "Businees Account Title is", expBusinessAccountText);
		new CommonFunctions().verifyLabelText(lblLogin, "Log In Title is", expLogin);

	}

	public void verifyCreateAccountText(String expCreateAccountText) {

		new CommonFunctions().verifyLabelTextContains(lblCreateAnAccountText, "Create Account Text Description is",
				expCreateAccountText);
	}

	public void verifyPersonalAccountText(String expPersonalAccountText) {
		new CommonFunctions().verifyLabelTextContains(lblPersonalAccountText, "Personal Account Text Description is",
				expPersonalAccountText);
	}

	public void verifyBusinessAccountText(String expBusinessAccountText) {
		new CommonFunctions().verifyLabelTextContains(lblBusinessAccountText, "Business Account Text Description is",
				expBusinessAccountText);
	}

	public void clickSignUp() {
		click(lnkSignUp, "clicked on SignUpLink");
	}

	public void verifyCreateAPersonalAccountText(String expCreateAPersonAccountText) {

		new CommonFunctions().verifyLabelText(lblCreateAPersonAccountText, "Create A Personal Account Title is",
				expCreateAPersonAccountText);
	}

	public void verifyBusinessAccountDisabled() {
		boolean flag = verifyElementDisabled(lnkBusinessAccount, "Clicked on BusinessAccountLink");
		if (flag) {

			ExtentTestManager.setPassMessageInReport("Business account is Disabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Business account is  not Disabled");
		}
	}

	public void verifyBusinessAccountToolTip(String expBusinessAccountToolTip) {

		String actToolTip = getAttributeValue(lblBusinessAccountTooltip, "value", "BusinessAccountToolTip");

		if (actToolTip.equals(expBusinessAccountToolTip)) {
			ExtentTestManager.setPassMessageInReport("Business account ToolTip is Succesfully Verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Business account ToolTip is not Succesfully Verified");
		}
	}

	
	public void verifyCreatePersonalAccountDescriptionText(String expCreatePersonalAccountDescriptionText) {
		new CommonFunctions().verifyLabelText(lblCreateAPersonalAccountDescriptionText,"Create Personal Account Description is", expCreatePersonalAccountDescriptionText);
	}

	
	  public void verifyFirstNameautoFoucsed(String expColor) { 
		  new CommonFunctions().verifyTextBoxBorderColor(expColor); 
	 
	  
	  if (expColor.equals("1")) {
	  ExtentTestManager.setPassMessageInReport("Autofoucsed");
	  
	  } else { ExtentTestManager.setFailMessageInReport("Not AutoFoucsed"); }
	  
	  }
	 

	public void verifySignUpFieldsTabNavigation() throws AWTException {
		Robot robot = new Robot();
        
		List<WebElement> str = getElementsList(SignUpElements, "elementsList");
		for (int i = 0; i < str.size(); i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			String focus = str.get(i).getAttribute("focus");
			if (focus.equals("true")) {

				ExtentTestManager.setPassMessageInReport("foucsed with tab");
			} else {
				ExtentTestManager.setFailMessageInReport("Not Foucsed in order with Tab");
				break;
			}

		}
	}

	public void verifyFirstNameFieldOpacity() {

		if (verifyElementDisplayed(opacity, "Opacity")) {
			ExtentTestManager.setPassMessageInReport("Opacity is  100% Succesfully verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Opacity is  not Succesfully verified verified ");
		}

	}

	public void verifyFirstNameValidations(String expFirstNameText, String input) {
		enterText(txtFirstName, expFirstNameText, "FirstName");
		String actFirstNameText = getAttributeValue(txtFirstName, "value", "First Name");

		if (expFirstNameText.equals(actFirstNameText)) {

			ExtentTestManager.setPassMessageInReport("Accepting " + input + "character");
		} else {
			ExtentTestManager.setFailMessageInReport("Not Accepting " + input + " character");
		}

	}

	public void verifySignUpFieldsWithEmpty(String expFirstName, String expLastName, String expPhoneNumber,
			String expEmail, String expCreatePassword, String expConfirmPassword) throws AWTException {

		enterText(txtFirstName, expFirstName, "FirstName");
		enterText(txtLastName, expLastName, "LastName");
		enterText(txtPhoneNumber, expPhoneNumber, "PhoneNumber");
		enterText(txtEmail, expEmail, "Email");
		enterText(txtCreatePasswordFiled, expCreatePassword, "CreatePassword");
		enterText(txtConfirmPasswordFiled, expConfirmPassword, "ConfirmPassword");
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void verifySignUpEmailFieldsWithInvalidData(String expEmail, String inputTypes) {
		enterText(txtEmail, expEmail, "Email");

	}

	public void verifySignUpFieldCreatePasswordWithInvalidData(String expCreatePAssword) {
		enterText(txtCreatePasswordFiled, expCreatePAssword, "CreatePassword");
	}

	public void verifySignUpFieldConfirmPasswordWithInvalidData(String expConfirmPassword) {
		enterText(txtConfirmPasswordFiled, expConfirmPassword, "ConfirmPassword");
	}

	public void verifyFirstNameValidations(String expFirstNameText) {
		enterText(txtFirstName, expFirstNameText, "FirstName");
		String actFirstNameText = getAttributeValue(txtFirstName, "value", "First Name");

		if (!expFirstNameText.equals(actFirstNameText)) {

			ExtentTestManager.setPassMessageInReport("Not Accepting More Than 30 characters");
		} else {
			ExtentTestManager.setFailMessageInReport(" Accepting More than 30 character");
		}

	}

	public void verifyLastNameOpacity() {
		if (verifyElementDisplayed(opacity, "Opacity")) {
			ExtentTestManager.setPassMessageInReport("Opacity is  100% Succesfully verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Opacity is  not Succesfully verified verified ");
		}

	}

	public void verifyLastNameValidations(String explastNameText, String input) throws InterruptedException {
		enterText(txtLastName, explastNameText, "Last name");

		String actLastNameText = getAttributeValue(txtLastName, "value", "LastName");

		if (explastNameText.equals(actLastNameText)) {

			ExtentTestManager.setPassMessageInReport("Accepting " + input + "character");
		} else {
			ExtentTestManager.setFailMessageInReport("Not Accepting " + input + " character");
		}

	}

	public void verifyLastNameValidations(String explastNameText) throws InterruptedException {
		enterText(txtLastName, explastNameText, "Last name");

		String actLastNameText = getAttributeValue(txtLastName, "value", "LastName");

		if (!explastNameText.equals(actLastNameText)) {

			ExtentTestManager.setPassMessageInReport("Not Accepting Moore than  30character");
		} else {
			ExtentTestManager.setFailMessageInReport(" Accepting more than 30 character");
		}

	}

	public void verifyPhonenUmberOpacity() {
		if (verifyElementDisplayed(opacity, "Opacity")) {
			ExtentTestManager.setPassMessageInReport("Opacity is  100% Succesfully verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Opacity is  not Succesfully verified verified ");
		}
	}

	public void verifyPhoneNumberTenDigitValidations(String PhoneNumber) {
		enterText(txtPhoneNumber, PhoneNumber, "Phone Number");
		String phnnum = getAttributeValue(txtPhoneNumber, "value", "txtPhoneNumber");
		String strNew = phnnum.replaceAll("[^0-9]", "");
		int size = strNew.length();
		if (size == 10) {
			ExtentTestManager.setPassMessageInReport("Accepting 10 Digits Phone Number Number");

		} else {
			ExtentTestManager.setFailMessageInReport("Not Accepting " + PhoneNumber + " Number");
		}
	}

	

	public void verifyUSnumberForformat(String number) {
		enterText(txtPhoneNumber, number, "number");
		String actNumber = getAttributeValue(txtPhoneNumber, "value", number);
		Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\\\d{3}-\\d{4}");
		Matcher matcher = pattern.matcher(actNumber);
		if (matcher.matches()) {
			ExtentTestManager.setPassMessageInReport("US Number Format is mattched (xxx) xxx-xxxx");
		} else {
			ExtentTestManager.setFailMessageInReport("US Number Format is not mattched (xxx) xxx-xxxx");
		}
	}

	public void verifyPhoneNumberValidations(String expPhoneNumber, String input) {
		enterText(txtPhoneNumber, expPhoneNumber, "PhoneNumber");
		String actPhoneNumber = getAttributeValue(txtPhoneNumber, "value", "Phone Number");

		if (!expPhoneNumber.equals(actPhoneNumber)) {

			ExtentTestManager.setPassMessageInReport("Not Accepting " + input + "character");
		} else {
			ExtentTestManager.setFailMessageInReport(" Accepting " + input + " character");
		}
	}

	public void verifyEmailOpacity() {
		if (verifyElementDisplayed(opacity, "Opacity")) {
			ExtentTestManager.setPassMessageInReport("Opacity is  100% Succesfully verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Opacity is  not Succesfully verified verified ");
		}
	}

	

	public void verifyEmailAdressFiledWithSpecialCharacters(String expEmail, String inputTypes) {
		enterText(txtEmail, expEmail, "Email Address");
		String actualEmail = getAttributeValue(txtEmail, "value", "Email");
		if (actualEmail.equals(expEmail)) {
			ExtentTestManager.setPassMessageInReport("Email  Filed is accepting  " + expEmail);
		} else {
			ExtentTestManager.setFailMessageInReport("Email Filed is not accepting " + expEmail);
		}

	}

	public void verifyCreatePasswordOpacity() {
		if (verifyElementDisplayed(opacity, "Opacity")) {
			ExtentTestManager.setPassMessageInReport("Opacity is  100% Succesfully verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Opacity is  not Succesfully verified verified ");
		}

	}

	public void verifyCreatePasswordTextFiled(String expCreatepassword) {
		enterText(txtCreatePasswordFiled, expCreatepassword, "createpassword");// San@123$* San123
		String actualcnfpwd = getAttributeValue(txtCreatePasswordFiled, "value", "createpassword");
		if (actualcnfpwd.equals(expCreatepassword)) {
			ExtentTestManager.setPassMessageInReport(
					"Confirm password is accepted Uppercase, lower case and numbers and special charcters"
							+ actualcnfpwd);
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Confirm password is NOT accepted Uppercase, lower case and numbers and special charcters"
							+ actualcnfpwd);
		}

	}

	public void verifyCreatePasswordRequirementsToolTip(String Createpassword, String createPasswordToolTipText,
			String inputTypes) {
		enterText(txtCreatePasswordFiled, Createpassword, "create password");
		String[] exptoolTipText = createPasswordToolTipText.split("*");
		List<WebElement> toolTipTexts = getElementsList(lblCreatePasswordRequirementsToolTipText, "ToolTip Texts");

		List<String> toolTipText = null;
		String str;
		for (int i = 0; i < toolTipTexts.size(); i++) {
			str = toolTipTexts.get(i).getText();
			toolTipText.add(str);
		}
		for (int i = 0; i < exptoolTipText.length; i++) {

			if (exptoolTipText[i].toString().equals(toolTipText.get(i))) {
				ExtentTestManager.setPassMessageInReport("displayed correct message when the user enter only "
						+ inputTypes
						+ " letters in 'Create Password' field then the Password Requirements text message expected is "
						+ exptoolTipText[i] + " Actual is " + toolTipText.get(i));
			} else {
				ExtentTestManager.setFailMessageInReport("Not displayed correct message when the user enter only"
						+ inputTypes
						+ "letters in 'Create Password' field then the Password Requirements text message expected is "
						+ exptoolTipText[i] + " Actual is " + toolTipText.get(i));
			}

		}

	}

	public void verifyCreatePasswordMaskedWithBlackCircles(String CreatePassword, String expType) {
		enterText(txtCreatePasswordFiled, CreatePassword, "Create Password");

		String str = getAttributeValue(txtCreatePasswordFiled, "type", CreatePassword);

		if (expType.contains(str)) {

			ExtentTestManager.setPassMessageInReport(
					"Create and confirm password have masked with black circles " + CreatePassword);
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Create and confirm password not masked with black circles " + CreatePassword);

		}
	}

	public void verifyCreatePasswordShowIcons(String expCreateShowIconType) {

		String str = getAttributeValue(lnkCreatePasswordShowIcon, "type", expCreateShowIconType);
		if (str.equals(expCreateShowIconType)) {
			ExtentTestManager.setPassMessageInReport("Create password have ShowIcon");
		} else {
			ExtentTestManager.setFailMessageInReport("Create  password not have ShowIcon");
		}

	}

	public void verifyClickOnCreatePasswordShowIcon(String CreatePassowrd) {
		enterText(txtCreatePasswordFiled, CreatePassowrd, "Create Password");
		click(lnkCreatePasswordShowIcon, "Clicked  on ShowIcon");
		String actualPaasword = getAttributeValue(txtCreatePasswordFiled, "value", CreatePassowrd);

		if (actualPaasword.equals(CreatePassowrd)) {
			ExtentTestManager.setPassMessageInReport("Enterd password is visibled " + actualPaasword);
		} else {
			ExtentTestManager.setFailMessageInReport("Enterd password is not visibled " + actualPaasword);

		}
	}

	public void verifyConfirmPaaswordFieldDescription(String ConfirmPassword) {
		new CommonFunctions().verifyLabelText(lblConfirmPassword, "ConfirmPasswordDescription", ConfirmPassword);
	}

	public void verifyConfirmPasswordOpacity() {

		if (verifyElementDisplayed(opacity, "Opacity")) {
			ExtentTestManager.setPassMessageInReport("Opacity is  100% Succesfully verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Opacity is  not Succesfully verified verified ");
		}
	}

	public void verifyConfirmPasswordShowIcon() {
		boolean flag = verifyElementSelected(lnkConfirmPasswordShowIcon, "Click Confirm Password");
		if (flag) {
			ExtentTestManager.setPassMessageInReport("Confirm password have ShowIcon");
		} else {
			ExtentTestManager.setFailMessageInReport("Confirm password not have ShowIcon");
		}
	}

	public void verifyConfirmPasswordMaskedWithBlackCircles(String ConfirmPassword, String expType) {
		enterText(txtConfirmPasswordFiled, ConfirmPassword, "Confirm Password");
		String str1 = getAttributeValue(txtConfirmPasswordFiled, "type", ConfirmPassword);
		if (expType.equals(str1)) {

			ExtentTestManager
					.setPassMessageInReport(" Confirm password have masked with black circles" + ConfirmPassword);
		} else {
			ExtentTestManager
					.setFailMessageInReport(" Confirm password not masked with black circles" + ConfirmPassword);

		}
	}

	public void verifyClickOnConfirmPasswordShowIcon(String ConfirmPassword) {
		enterText(txtConfirmPasswordFiled, ConfirmPassword, "Confirm Password");
		click(lnkConfirmPasswordShowIcon, " ShowIcon");
		String actualPaasword = getAttributeValue(txtConfirmPasswordFiled, "value", ConfirmPassword);

		if (actualPaasword.equals(ConfirmPassword)) {
			ExtentTestManager.setPassMessageInReport("Enterd password is visibled " + actualPaasword);
		} else {
			ExtentTestManager.setFailMessageInReport("Enterd password is not visibled " + actualPaasword);

		}
	}
	
	public void clickLogIn() {
		click(lnkLogIn,"Click LogIn");
	}

	public void clickNext() {
		click(btnNext, "click Next");

	}

	public void verifyNextButtonEnabled(String FirstName, String LastName, String Email, String PhoneNumber,
			String CreatePassword, String ConfirmPassword) {
		enterText(txtFirstName, FirstName, "First Name");
		enterText(txtLastName, LastName, "Last Name");
		enterText(txtEmail, Email, "Email");
		enterText(txtPhoneNumber, PhoneNumber, "Phone Number");
		enterText(txtCreatePasswordFiled, CreatePassword, "Create Password");
		enterText(txtConfirmPasswordFiled, ConfirmPassword, "Confirm Password");

		if (verifyElementPresence(btnNext, "Next")) {

			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is not Enabled");
		}
	}

	public void verifyClickLogIn(String expLoginText) {
		click(lnkLogIn, "LogIn");
		new CommonFunctions().verifyLabelText(lblLogInToCoyni, "Log In Tite Description is", expLoginText);
	}

	public void verifyClickNext(String expPhoneVerifictionText) {
		click(btnNext, "Next");
		new CommonFunctions().verifyLabelText(lblPhoneVerification, "Phone Verification Title is",
				expPhoneVerifictionText);
	}

	public void verifyPhoneVerificationPage(String expPhoneVerificationDescription, String expResendText,
			String expGoBackText) {
		new CommonFunctions().verifyLabelTextContains(lblPhoneVericationText, "Phone Verification Description",
				expPhoneVerificationDescription);
		new CommonFunctions().verifyLabelText(lblResend, "Resend Button text is", expResendText);
		new CommonFunctions().verifyLabelText(lblGoBack, "Go Back Button Txt is", expGoBackText);
	}

	public void verifyPhoneNumberTextInPhoneNumberDescription(String expPhoneNumber) {
		new CommonFunctions().verifyLabelTextContains(lblPhoneNumber, "Phone Number in phone verication description is",
				expPhoneNumber);
	}

	public void validateRemainingAttempts(String expAttempts) {
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		String text = getText(passErrorMsg, "password error").replaceAll("[^0-9]", "");
		if (expAttempts.equals(text)) {
			ExtentTestManager.setPassMessageInReport("Number of remaining invalid password attemps are " + expAttempts);
		} else {
			ExtentTestManager.setFailMessageInReport("Expected of number of remaining password attempts  are "
					+ expAttempts + " but actual are " + text);
		}
	}

	public void clickPrivacyPolicy() {
		click(lnkPrivacyPolicy, "click PrivacyPolicy");
	}

	public void clickTermsOfServices() {
		click(lnkTermsOfServices, "click TermsOfServices");
	}
}
