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
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class HomePage extends BrowserFunctions {
	private By lnkPersonalAccount = By.xpath("//div[text()='Personal Account']");
	private By lnkBusinessAccount = By.cssSelector("div[currentitem='false']");
	private By lnkLogIn = By.cssSelector("");
	private By lblCreateAccount = By.xpath("//span[contains(text(), 'Create an Account')]");
	private By lblPersonalAccount = By.xpath("//div[contains(text(),'Personal Account')]");
	private By lblBusinnesAccount = By.xpath("//div[text()='Business Account']");
	private By lblLogin = By.xpath("//span[text()='Log In']");
	private By lblCreateAnAccountText = By.xpath("//p[@class='disclaimer']");
	private By lblPersonalAccountText = By.xpath("//p[contains(text(),'Used for sending and receiving')]");
	private By lblBusinessAccountText = By.xpath("//p[contains(text(),'Used for receiving token')]");
	private By lblCreateAPersonAccountText = By.xpath("//span[contains(text(),'Create a Personal Account')]");
	private By lblCreateAPersonalAccountDescriptionText = By.xpath("");
	private By lblBusinessAccountTooltip = By.xpath(
			"//div[@class='__react_component_tooltip tc400c05a-2593-4ab8-a062-5bfe85d97f35 place-top type-dark items-center text-center text-cwhite']");
    
	private By SignUpElements = By.cssSelector("");
	private By txtFirstName = By.cssSelector("");
	private By txtLastName = By.cssSelector("");
	private By txtEmail = By.cssSelector("");

	private By txtCreatePasswordFiled = By.cssSelector("");
	private By lblCreatePasswordRequirementsToolTipText = By.cssSelector("span.criteria span");
	private By lblConfirmPassword = By.cssSelector("label[for='confirm-password']");
	private By opacity = By.cssSelector("div[style='opacity: 1; transform: none;']");
	private By txtConfirmPasswordFiled = By.cssSelector("");
	private By btnNext = By.cssSelector("");

	private By txtPhoneNumber = By.cssSelector("");
	private By lnkUsLogoDefault = By.cssSelector("");
	private By passErrorMsg = By.cssSelector("");
	private By lnkCreatePasswordShowIcon = By.cssSelector("");
	private By lnkConfirmPasswordShowIcon = By.cssSelector("");
	private By lnkPrivacyPolicy = By.cssSelector("");
	private By lnkTermsOfServices = By.cssSelector("");
	private By lblLogInToCoyni = By.xpath("//span[contains(text(),'Log In to Coyni')]");
	private By lblPhoneVerification = By.xpath("//div[text()='Phone Verification']");
	private By lblPhoneVericationText = By.cssSelector(
			"p[class='pl-5 text-base 4xl:text-base text-cgy5 SmsValidation_phone_validation__sub_title__2OJbV']");
	private By lblResend = By.xpath("//div[text()='Resend']");
	private By lblGoBack = By.xpath("//div[contains(text(),'Go Back')]");
	private By lblPhoneNumber = By.cssSelector("span[class='ml-2 text-base font-semibold text-cm3']");

	public void verifyHomePageOptions(String expCreateAccountText, String expPersonalAccountText,
			String expBusinessAccountText, String expLogin) {

		new CommonFunctions().verifyLabelText(lblCreateAccount, "CreateAccount", expCreateAccountText);
		new CommonFunctions().verifyLabelText(lblPersonalAccount, "PersonalAccount", expPersonalAccountText);
		new CommonFunctions().verifyLabelText(lblBusinnesAccount, "BusinnesAccount", expBusinessAccountText);
		new CommonFunctions().verifyLabelText(lblLogin, "Log In", expLogin);

	}

	public void verifyCreateAccountText(String expCreateAccountText) {
		new CommonFunctions().verifyLabelText(lblCreateAnAccountText, "Create Account Text", expCreateAccountText);
	}

	public void verifyPersonalAccountText(String expPersonalAccountText) {
		new CommonFunctions().verifyLabelText(lblPersonalAccountText, "Personal Account Text", expPersonalAccountText);
	}

	public void verifyBusinessAccountText(String expBusinessAccountText) {
		new CommonFunctions().verifyLabelText(lblBusinessAccountText, "Business Account Text", expBusinessAccountText);
	}

	public void verifyCreateAPersonalAccountText(String expCreateAPersonAccountText) {
		click(lnkPersonalAccount, "Persona Account");
		new CommonFunctions().verifyLabelText(lblCreateAPersonAccountText, "CreateAccountText",
				expCreateAPersonAccountText);
	}

	public void verifyBusinessAccountDisabled() {
		boolean flag = verifyElementDisabled(lnkBusinessAccount, "BusinessAccount");
		if (flag) {

			ExtentTestManager.setPassMessageInReport("Business account is Disabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Business account is Disabled");
		}
	}

	public void verifyBusinessAccountToolTip(String expBusinessAccountToolTip) {
		WebElement actToolTip = getElement(lblBusinessAccountTooltip, "BusinessAccountToolTip");

		if (actToolTip.equals(expBusinessAccountToolTip)) {
			ExtentTestManager.setPassMessageInReport("Business account ToolTip is Succesfully Verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Business account ToolTip is not Succesfully Verified");
		}
	}
	
	public void verifyHomePageTabNavigation() throws AWTException {
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


	public void verifyCreatePersonalAccountDescriptionText(String expCreatePersonalAccountDescriptionText) {
		new CommonFunctions().verifyLabelText(lblCreateAPersonalAccountDescriptionText, "CreateAccount",
				expCreatePersonalAccountDescriptionText);
	}

	public void verifyFirstNameautoFoucsed() {

		String attributeValue = getAttributeValue(txtFirstName, "autofoucs", "autofocus");

		if (attributeValue.equals("1")) {
			ExtentTestManager.setPassMessageInReport("Autofoucsed");

		} else {
			ExtentTestManager.setFailMessageInReport("Not AutoFoucsed");
		}

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
		enterText(txtFirstName, "FirstName", expFirstNameText);
		String actFirstNameText = getAttributeValue(txtFirstName, "Value", "First Name");

		if (expFirstNameText == actFirstNameText) {

			ExtentTestManager.setPassMessageInReport("Accepting " + input + "character");
		} else {
			ExtentTestManager.setFailMessageInReport("Not Accepting " + input + " character");
		}

	}

	public void verifyLastNameOpacity() {
		if (verifyElementDisplayed(opacity, "Opacity")) {
			ExtentTestManager.setPassMessageInReport("Opacity is  100% Succesfully verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Opacity is  not Succesfully verified verified ");
		}

	}

	public void verifyLastNameValidations(String expLastNameText, String input) {
		enterText(txtLastName, "Last Name", expLastNameText);
		String actLastNameText = getAttributeValue(txtLastName, "value", "Last Name");

		if (expLastNameText == actLastNameText) {

			ExtentTestManager.setPassMessageInReport("Accepting " + input + "character");
		} else {
			ExtentTestManager.setFailMessageInReport("Not Accepting " + input + " character");
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
		enterText(txtPhoneNumber, "Phone Number", PhoneNumber);
		String phnnum = getAttributeValue(txtPhoneNumber, "value", PhoneNumber);
		int size = phnnum.length();
		if (size == 10) {
			ExtentTestManager.setPassMessageInReport("Accepting " + PhoneNumber + "Number");

		} else {
			ExtentTestManager.setFailMessageInReport("Not Accepting " + PhoneNumber + " Number");
		}
	}

	public void verifyUSLogoDefault() {
		verifyElementDisplayed(lnkUsLogoDefault, "Defaul UsLogo");
	}

	public void verifyUSnumberForformat(String number) {
		Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\\\d{3}-\\d{4}");
		Matcher matcher = pattern.matcher(number);
		if (matcher.matches()) {
			ExtentTestManager.setPassMessageInReport("US Number Format is mattched (xxx) xxx-xxxx");
		} else {
			ExtentTestManager.setFailMessageInReport("US Number Format is not mattched (xxx) xxx-xxxx");
		}
	}

	public void verifyPhoneNumberValidations(String expPhoneNumber, String input) {
		enterText(txtPhoneNumber, "PhoneNumber", expPhoneNumber);
		String actPhoneNumber = getAttributeValue(txtPhoneNumber, "Value", "Phone Number");

		if (expPhoneNumber == actPhoneNumber) {

			ExtentTestManager.setPassMessageInReport("Accepting " + input + "character");
		} else {
			ExtentTestManager.setFailMessageInReport("Not Accepting " + input + " character");
		}
	}

	public void verifyEmailOpacity() {
		if (verifyElementDisplayed(opacity, "Opacity")) {
			ExtentTestManager.setPassMessageInReport("Opacity is  100% Succesfully verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Opacity is  not Succesfully verified verified ");
		}
	}

	public String randomStringGen(int length) {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		StringBuilder sb = new StringBuilder();

		Random random = new Random();

		for (int i = 0; i < length; i++) {

			int index = random.nextInt(alphabet.length());

			char randomChar = alphabet.charAt(index);

			sb.append(randomChar);
		}

		String randomString = sb.toString();

		return randomString;

	}

	public void verifyEmailAdressFiledwithReqcharc(String number) {
		String reqText = randomStringGen(Integer.parseInt(number));
		enterText(txtEmail, "Email Address", reqText);
		String actualEmail = getAttributeValue(txtEmail, "value", "Email");
		if (actualEmail.length() == reqText.length()) {
			ExtentTestManager.setPassMessageInReport("Email text Filed is accepting lenght is " + actualEmail.length());
		} else {
			ExtentTestManager
					.setFailMessageInReport("Email text Filed is not accepting lenght is " + actualEmail.length());
		}

	}

	public void verifyEmailAdressFiledWithSpecialCharacters(String reqText) {
		enterText(txtEmail, "Email Address", reqText);
		String actualEmail = getAttributeValue(txtEmail, "value", "Email");
		if (actualEmail.equals(reqText)) {
			ExtentTestManager.setPassMessageInReport("Email text Filed is accepting Special Characters is " + reqText);
		} else {
			ExtentTestManager
					.setFailMessageInReport("Email text Filed is not accepting Special Characters is " + reqText);
		}

	}
	
	public void verifyCreatePasswordOpacity() {
		boolean flag = verifyElementDisplayed(lnkCreatePasswordShowIcon, "ShowIcon");

		if (flag) {
			ExtentTestManager.setPassMessageInReport("Create and confirm password have ShowIcon");
		} else {
			ExtentTestManager.setFailMessageInReport("Create and confirm password not have ShowIcon");
		}

	}
		
	

	public void verifyCreatePasswordTextFiled(String expCreatepassword) {
		enterText(txtCreatePasswordFiled, expCreatepassword, "create password");// San@123$* San123
		String actualcnfpwd = getAttributeValue(txtConfirmPasswordFiled, "value", "password");
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
	
	

	public void verifyCreatePasswordRequirementsToolTip(String Createpassword, String ToolTipText, String inputType) {
		enterText(txtCreatePasswordFiled, Createpassword, "create password");
		String[] exptoolTipText = ToolTipText.split(",");
		List<WebElement> toolTipTexts = getElementsList(lblCreatePasswordRequirementsToolTipText, "ToolTip Texts");

		List<String> toolTipText = null;
		String str;
		for (int i = 0; i < toolTipTexts.size(); i++) {
			str = toolTipTexts.get(i).getText();
			toolTipText.add(str);
		}
		for (int i = 0; i < exptoolTipText.length; i++) {

			if (exptoolTipText[i].equals(toolTipText.get(i))) {
				ExtentTestManager.setPassMessageInReport("displayed correct message when the user enter only "
						+ inputType
						+ " letters in 'Create Password' field then the Password Requirements text message expected is "
						+ exptoolTipText[i] + " Actual is " + toolTipText.get(i));
			} else {
				ExtentTestManager.setFailMessageInReport("Not displayed correct message when the user enter only"
						+ inputType
						+ "letters in 'Create Password' field then the Password Requirements text message expected is "
						+ exptoolTipText[i] + " Actual is " + toolTipText.get(i));
			}

		}

	}

	public void verifyCreatePasswordMaskedWithBlackCircles(String CreatePassword) {
		enterText(txtCreatePasswordFiled, CreatePassword, "Create Password");
		String str = getAttributeValue(txtCreatePasswordFiled, "type", CreatePassword);

		if (str.equals(CreatePassword)) {

			ExtentTestManager.setPassMessageInReport(
					"Create and confirm password have masked with black circles" + CreatePassword);
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Create and confirm password not masked with black circles" + CreatePassword);

		}
	}

	public void verifyCreatePasswordShowIcons() {
		boolean flag = verifyElementDisplayed(lnkCreatePasswordShowIcon, "");

		if (flag) {
			ExtentTestManager.setPassMessageInReport("Create and confirm password have ShowIcon");
		} else {
			ExtentTestManager.setFailMessageInReport("Create and confirm password not have ShowIcon");
		}

	}

	public void verifyClickOnCreatePasswordShowIcon(String CreatePassowrd) {
		enterText(txtCreatePasswordFiled, CreatePassowrd, "Create Password");
		click(lnkCreatePasswordShowIcon, "Clicked  on ShowIcon");
		String actualPaasword = getAttributeValue(txtCreatePasswordFiled, CreatePassowrd, "Create Paasword");

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

	public void verifyConfirmPasswordMaskedWithBlackCircles(String ConfirmPassword) {
		enterText(txtConfirmPasswordFiled, ConfirmPassword, "Confirm Password");
		String str1 = getAttributeValue(txtConfirmPasswordFiled, "type", ConfirmPassword);
		if (str1.equals(ConfirmPassword)) {

			ExtentTestManager
					.setPassMessageInReport(" Confirm password have masked with black circles" + ConfirmPassword);
		} else {
			ExtentTestManager
					.setFailMessageInReport(" Confirm password not masked with black circles" + ConfirmPassword);

		}
	}

	public void verifyConfirmPasswordShowIcon() {
		boolean flag = verifyElementDisplayed(lnkConfirmPasswordShowIcon, "");
		if (flag) {
			ExtentTestManager.setPassMessageInReport("Create and confirm password have ShowIcon");
		} else {
			ExtentTestManager.setFailMessageInReport("Create and confirm password not have ShowIcon");
		}
	}

	public void verifyClickOnConfirmPasswordShowIcon(String ConfirmPassword) {
		enterText(txtConfirmPasswordFiled, ConfirmPassword, "Confirm Password");
		click(lnkConfirmPasswordShowIcon, "Clicked  on ShowIcon");
		String actualPaasword = getAttributeValue(txtConfirmPasswordFiled, ConfirmPassword, "Confirm Paasword");

		if (actualPaasword.equals(ConfirmPassword)) {
			ExtentTestManager.setPassMessageInReport("Enterd password is visibled " + actualPaasword);
		} else {
			ExtentTestManager.setFailMessageInReport("Enterd password is not visibled " + actualPaasword);

		}
	}

	

	public void clickOnNext() {
		click(btnNext, "click Next");

	}

	public void clickOnPrivacyPolicy() {
		click(lnkPrivacyPolicy, "click PrivacyPolicy");
	}

	public void clickOnTermsOfServices() {
		click(lnkTermsOfServices, "click TermsOfServices");
	}

	public void verifyNextButtonEnabled(String FirstName, String LastName, String Email, String PhoneNumber,
			String CreatePassword, String ConfirmPassword) {
		enterText(txtFirstName, FirstName, "First Name");
		enterText(txtLastName, LastName, "Last Name");
		enterText(txtEmail, Email, "Email");
		enterText(txtPhoneNumber, Email, "Email");
		enterText(txtCreatePasswordFiled, CreatePassword, "Create Password");
		enterText(txtConfirmPasswordFiled, ConfirmPassword, "Confirm Password");

		boolean flag = verifyElementSelected(btnNext, "Next");
		if (flag) {

			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is not Enabled");
		}
	}

	public void verifyClickOnLogIn(String expLoginText) {
		click(lnkLogIn, "LogIn");
		new CommonFunctions().verifyLabelText(lblLogInToCoyni, "Log In To Coyni", expLoginText);
	}

	public void verifyClickOnNext(String expPhoneVerifictionText) {
		click(btnNext, "Next");
		new CommonFunctions().verifyLabelText(lblPhoneVerification, "Log In To Coyni", expPhoneVerifictionText);
	}

	public void verifyPhoneVerificationPage(String expPhoneVerificationDescription, String expResendText,
			String expGoBackText) {
		new CommonFunctions().verifyLabelText(lblPhoneVericationText, "Phone Verification Description",
				expPhoneVerificationDescription);
		new CommonFunctions().verifyLabelText(lblResend, "Phone Verification Description", expResendText);
		new CommonFunctions().verifyLabelText(lblGoBack, "Phone Verification Description", expGoBackText);
	}

	public void verifyPhoneNumberTextInPhoneNumberDescription(String expPhoneNumber) {
		new CommonFunctions().verifyLabelText(lblPhoneNumber, "Phone Number Description", expPhoneNumber);
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
}
