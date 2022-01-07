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
	private By lnkResend = By.xpath("//div[text()='Resend Verification Code']");
	private By lblResendDescrp =  By.xpath("//div[text()='New Verification Code Sent");
	
	private By lblLastName = By.xpath("//label[text()='Last Name']");
	private By lblEmail = By.xpath("//input[@id='email-address']/preceding-sibling::*[1]");
	private By lblPhoneNumber = By.xpath("//input[@id='phone-number']/preceding-sibling::*[1]");
	private By lblCreatePassword = By.xpath("//input[@id='create-password']/preceding-sibling::*[1]");
	private By lblConfirmPassword = By.xpath("//input[@id='confirm-password']/preceding-sibling::*[1]");
	private By lblLogin = By.xpath("//span[@class='business-login__title']");
	
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
	private By eyeIconCreatePassword = By.xpath("(//button[@class='icon-button  icon-password-hide-new  view-password text-cgy2 hover:text-cgy3'])[1]");
	private By eyeIconConfirmPassword = By.xpath("(//button[@class='icon-button  icon-password-hide-new  view-password text-cgy2 hover:text-cgy3'])[2]");
	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	private String Email;
	private String CreatePassword;
	private String ConfirmPassword;
	
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
		FirstName = getText(txtFirstName, "First Name");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
		LastName = getText(txtLastName,"Last Name");
	}

	public void fillEmail(String userName) {
		enterText(txtEmail, userName, "Email");
		Email = getText(txtEmail, "Email");
	}

	public void fillPhoneNumber(String PhoneNumber) {
		enterText(txtPhoneNumber, PhoneNumber, "PhoneNumber");
		PhoneNumber = getText(txtPhoneNumber,  "Phone Number");
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
			CreatePassword = getText(txtCreatePassword, "CreatePassword");
			ExtentTestManager.setPassMessageInReport("password is valid");
		} else {
			ExtentTestManager.setFailMessageInReport("password is invalid");
		}
	}

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
		ConfirmPassword = getText(txtConfirmPassword, "Confirm Password");
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
    public void verifyCreatePasswordMasked(String CreatePassword,String expType) {
    	enterText(txtCreatePassword, CreatePassword, "Create Password");
    	String str = getAttributeValue(txtCreatePassword, "type", CreatePassword);
    	if(expType.contains(str)) {
    		ExtentTestManager.setPassMessageInReport("Create password have masked with black circles " + CreatePassword);
    	}
    	else {
    		ExtentTestManager.setFailMessageInReport("Create password not masked with black circles " + CreatePassword);
    		
    	}
    }
   public void verifyCreatePasswordEyeIcon() {
	   new CommonFunctions().elementView(eyeIconCreatePassword, "Create Password View Eye Icon");
   }
   public void verifyClickOnCreatePasswordShowIcon(String CreatePassowrd) {
		enterText(txtCreatePassword, CreatePassowrd, "Create Password");
		click(eyeIconCreatePassword, "Clicked  on ShowIcon");
		String actualPaasword = getAttributeValue(txtCreatePassword, "value", CreatePassowrd);

		if (actualPaasword.equals(CreatePassowrd )) {
			ExtentTestManager.setPassMessageInReport("Enterd password is visibled " + actualPaasword);
		} else {
			ExtentTestManager.setFailMessageInReport("Enterd password is not visibled " + actualPaasword);

		}
	}

   public void verifyConfirmPasswordMasked(String ConfirmPassword,String expType) {
   	enterText(txtConfirmPassword, ConfirmPassword, "Create Password");
   	String str = getAttributeValue(txtCreatePassword, "type", ConfirmPassword);
   	if(expType.contains(str)) {
   		ExtentTestManager.setPassMessageInReport("Create password have masked with black circles " + ConfirmPassword);
   	}
   	else {
   		ExtentTestManager.setFailMessageInReport("Create password not masked with black circles " + ConfirmPassword);
   		
   	}
   }
  public void verifyConfirmPasswordEyeIcon() {
	   new CommonFunctions().elementView(eyeIconConfirmPassword, "Confirm Password View Eye Icon");
  }
  public void verifyClickOnConfirmPasswordShowIcon(String CreatePassowrd) {
		enterText(txtCreatePassword, CreatePassowrd, "Create Password");
		click(eyeIconCreatePassword, "Clicked  on ShowIcon");
		String actualPaasword = getAttributeValue(txtCreatePassword, "value", CreatePassowrd);

		if (actualPaasword.equals(CreatePassowrd )) {
			ExtentTestManager.setPassMessageInReport("Enterd password is visibled " + actualPaasword);
		} else {
			ExtentTestManager.setFailMessageInReport("Enterd password is not visibled " + actualPaasword);

		}
	}
  
  public void verifyLoginPageHeading() {
	  new CommonFunctions().elementView(lblLogin, "Login Page heading is");
  }

  public void clickResend() {
	  click(lnkResend, "Clicked on Resend");
  }
  
  public void verifyResendHeading() {
	  new CommonFunctions().elementView(lnkResend, "Resend Heading");
  }
  
  public void verifyResendDescrp() {
	  new CommonFunctions().elementView(lblResendDescrp, "Resend description");
  }
  
   public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	/**
	 * Order -minChar, minCharPlus, maxCharMinus, maxChar, specialChar, Number,
	 * spaces maxiPlus
	 */
	public void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 7; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[7]);
	}
	
	

	public void validateFirstNameField(String firstName) {
		validateNameField(txtFirstName, "First Name", firstName);
	}

	public void validateLastNameField(String LastName) {
		validateNameField(txtLastName, "Last Name", LastName);
	}

	public void validateEmailField(String email) {
		new LoginPage().validateEmailTextField(email);
	}

	public void validatePassword(String password) {
		new LoginPage().validateLoginField(txtCreatePassword, "Create Password", password);
	}

	/**
	 * Order -minChar, alphabets, specialChar, spaces, maxiPlus
	 */
	public void validateNumber(By ele,String eleName, String textField) {
		String[] field = textField.split(",");
		new CommonFunctions().validateField(ele, eleName, field[0]);
		for (int i = 1; i < 4; i++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
	}
	public void validatePhoneNumber(String phoneNumber) {
		validateNumber(txtPhoneNumber, "Phone Number", phoneNumber);
	}
   
	public void getPreviousData(String firstName, String lastName, String phoneNumber, String email,
			String createPassword, String confirmPassword) {
		new CommonFunctions().verifyPreviousData(txtFirstName, "First Name", firstName);
		new CommonFunctions().verifyPreviousData(txtLastName, "Last Name", lastName);
		new CommonFunctions().verifyPreviousData(txtPhoneNumber, "Phone Number", phoneNumber);
		new CommonFunctions().verifyPreviousData(txtEmail, "Email", email);
		new CommonFunctions().verifyPreviousData(txtCreatePassword, "Create Password", createPassword);
		new CommonFunctions().verifyPreviousData(txtConfirmPassword, "Confirm Password", confirmPassword);
	}

	public void verifyClearAndUpdateAllFileds(String firstName, String lastName, String NewPhoneNumber, String newEmail,
			String createPassword, String confirmPassword) {

		new CommonFunctions().Refresh();

		fillFirstName(firstName);
		fillLastName(lastName);
		fillPhoneNumber(NewPhoneNumber);
		fillEmail(newEmail);
		enterText(txtCreatePassword, createPassword, "CreatePassword");
		fillConfirmPassword(confirmPassword);

	}



}
