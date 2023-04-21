package coyni.merchant.pages;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.ForgotEmailComponent;
import coyni.merchant.components.ForgotPasswordComponent;
import coyni.merchant.components.PhoneVerificationComponent;
import coyni.merchant.components.ToastComponent;
import coyni.merchant.components.UserNameDropDownComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.Navigation;

public class LoginPage extends BrowserFunctions {
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	private By logoCoyni = By.xpath("//img[@alt='coyni_Logo']");
	private By txtEmail = By.xpath("//input[@id='Email']");
	private By txtPassword = By.xpath("//input[@id='Password']");
	private By lnkForgotEmail = By.xpath("//button[text()='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//button[text()='Forgot Password?']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkSignUp = By.xpath("//button[text()='Sign Up']");
	private By heading = By.cssSelector(".business-login__title,.title");
	private By lblerrorMsg = By.cssSelector("span.error");
	private By lblEmail = By.cssSelector("");
	private By txtOTP = By.cssSelector("");
	private By iconeye = By.cssSelector(".icon-button");
	private By PDFpages = By.cssSelector(".react-pdf__Page");
	private By termsofServicePDFPages = By.cssSelector(".react-pdf__Document");
	private By termsOfMerchantPDFPages = By.cssSelector(".react-pdf__Document");
	private By pdfPagesUpdate = By.cssSelector(".react-pdf__Page");
	private By PDFtermsOfServicesUpdate = By.xpath("//div[.='Terms of Service']");
	private By PDFmerchantAgreementsUpdate = By.xpath("//div[.='Merchant Agreement']");
	private By PDFtermsOfServices = By.xpath("(//span[.='Agreement'])[1]");
	private By PDFprivacyPolicy = By.xpath("((//span[.='']))[1]");
	private By privacyPolicyUpdate = By.xpath("//span[contains(text(),'Privacy Policy')]");
	private By termsOFServicesUpdate = By.xpath("//span[contains(text(),'Terms of Service')]");
	private By merchantAgreementUpdate = By.xpath("//span[contains(text(),'Merchant Agreement')]");
	private By btnDone = By.xpath("//button[contains(text(),'Done')]");
	private By btnAgree = By.xpath("//button[contains(text(),'Agree')]");
	private By checkbox = By.xpath("(//input[@type='checkbox'])[3]");
	private By termsOfServicePDF = By.xpath("//div[contains(@class,'AgreementModal_pdfSize__yrzAs')]");
	private By termsOfmerchantPDF = By.xpath("//div[contains(@class,'AgreementModal_apiData__xVMmx')]");
	private By lblPrivacyPolicy = By.xpath("//div[contains(text(),'Privacy Policy')]");
    private By pdfPrivacyUpdate = By.xpath("//div[contains(@class,'AgreementModal_apiData')]");
	private By lblAdditionalDocument = By.xpath("//h1[contains(text(),'Merchant Application Additional Documentation')]");
	private By lblWelcome = By.xpath("//span[contains(text(),'Welcome to ')]");
	private By btnClose = By.xpath("//button[@classs='self-end']");
	
	public void clickCheckBox() {
		click(checkbox, "Check Box");
	}
	
	public int verifyNonMaterialAgrrement() {
		int i = getElementsList(btnClose, "Material Aggrement").size();
		return i;
	}
    
	public void fillEmail(String userName) {
		enterText(txtEmail, userName, "Email");
	}

	public void clickRefresh() {
		navigate(Navigation.REFRESH);
	}

	public void getLogo() {
		String text = getText(logoCoyni, "Logo Coyni");
		ExtentTestManager.setInfoMessageInReport("No Logo displayed " + text);

	}

	public void getEmail() {
		String text = getText(txtEmail, "Email");
		ExtentTestManager.setInfoMessageInReport("No Text displayed " + text);

	}

	public void viewForgotEmail() {
		new CommonFunctions().elementView(lnkForgotEmail, "Forgot Email");
	}

	public void viewForgotPassword() {
		new CommonFunctions().elementView(lnkForgotPassword, "Forgot Password");
	}

	public void fillPassword(String password) throws AWTException {
		enterText(txtPassword, password, "Password");
		clickTab();
	}

	public void clickForgotEmail() {
		click(lnkForgotEmail, "ForgotEmail");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPassword");
	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickSignUp() {
		click(lnkSignUp, "SignUp");
	}

	public void clickeyeIcon() {
		click(iconeye, "eye icon");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Login heading", expHeading);
	}

	public void verifySignUpView() {
		new CommonFunctions().elementView(lnkSignUp, "Sign up");
	}

	public void verifyEmailView() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}

	public void viewEmail() {
		new CommonFunctions().elementView(txtEmail, "View Email");
	}

	public void verifyPasswordView() {
		new CommonFunctions().elementView(txtPassword, "Password");
	}

	public void verifyForgotEmailView() {
		new CommonFunctions().elementView(lnkForgotEmail, "Forgot Email");
	}

	public void verifyForgotPasswordView() {
		new CommonFunctions().elementView(lnkForgotPassword, "Forgot Password");
	}

	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtPassword, attribute, password);
		if (attributeValue.contains("password")) {
			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}

	public void fillVerificationInput(String code) {
		List<WebElement> inputs = getElementsList(txtOTP, "OTP boxes");
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
		}

	}

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "exp email", expEmail);
	}

	public void validateRemainingAttempts(String expAttempts) {
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		String text = getText(lblerrorMsg, "error message").replaceAll("[^0-9]", "");
		if (expAttempts.equals(text)) {
			ExtentTestManager.setPassMessageInReport("Number of remaining invalid password attemps are " + expAttempts);
		} else {
			ExtentTestManager.setFailMessageInReport("Expected of number of remaining password attempts  are "
					+ expAttempts + " but actual are " + text);
		}
	}

	public void PrivacyPolicyUpdate() {
		if (verifyElementPresence(privacyPolicyUpdate, "Privacy Policy")) {
			click(btnDone, "Done");

		}
	}

	public void TermsOfServiceUpdate() {
		if (verifyElementPresence(privacyPolicyUpdate, "Privacy Policy")) {
			click(btnDone, "Done");

		}
	}

	public void merchantAgreementUpdate() {
		if (verifyElementPresence(merchantAgreementUpdate, "Merchant Agreement")) {
			click(btnDone, "Done");

		}
	}

	public void scrollDownTermsOfServiceUpdate() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(PDFtermsOfServicesUpdate));
		WebElement ele = getElement(termsOfServicePDF, "");
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsofServicePDFPages, "");
		int noOfPages = list.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(checkbox, "");
		while (!element.isEnabled()) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
		clickAgree();
		clickDone();

	}

	public void clickDone() {
      click(btnDone,"Done");
	}
	
	public int verifyDoneButtonSize() {
		int i = getElementsList(btnDone, "Done").size();
		return i;
	}

	public void clickAgree() {
		click(btnAgree, "Agree");
	}

	public void scrollDownMerchantAgreementUpdate() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(PDFmerchantAgreementsUpdate));
		WebElement ele = getElement(termsOfmerchantPDF, "");
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
		int noOfPages = list.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(checkbox, "");
		while (!element.isEnabled()) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
		clickAgree();
		clickDone();
	}
	
	public int verifyPriacyPolicyHeading() {
		int z = getElementsList(privacyPolicyUpdate, "").size();
		return z;
	}
	
	public int verifyTermsOfServicesHeading() {
		int z = getElementsList(termsOFServicesUpdate, "").size();
		return z;
	}
	
	public void verifyAdditionsalDocumentHeading(String additionalHeading) {
		new CommonFunctions().verifyLabelText(lblAdditionalDocument, "Additonal Document Heading", additionalHeading);
	}
	
	public void scrollPrivacyPolicyPdf() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblPrivacyPolicy));
		WebElement ele = getElement(pdfPrivacyUpdate,"");
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
	    int noOFPages = list.size();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement element = getElement(checkbox, "");
	    while(!element.isEnabled()) {
	    	js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
	    	height += temp;
	    	Thread.sleep(200);
	    }
	    clickAgree();
	    clickDone();
	
	}
	
	public void scrollToPrivacyAgreeNonMaterial() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblPrivacyPolicy));
		WebElement ele = getElement(pdfPrivacyUpdate,"");
		Thread.sleep(2000);
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
	    int noOFPages = list.size();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement element = getElement(btnDone, "");
	    while(element.getAttribute("class").contains("pointer")) {
	    	js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
	    	height += temp;
	    	Thread.sleep(200);
	    }
	    clickDone();
	}
	
	public void scrollToPrivacyAgree() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblPrivacyPolicy));
		WebElement ele = getElement(pdfPrivacyUpdate,"");
		Thread.sleep(2000);
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
	    int noOFPages = list.size();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement element = getElement(checkbox, "");
	    while(!element.isEnabled()) {
	    	js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
	    	height += temp;
	    	Thread.sleep(200);
	    }
	    clickCheckBox();
	    clickAgree();
	    
	}
	
	public void scrollToTermsAgreeNonMateria() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(termsOfmerchantPDF));
		WebElement ele = getElement(pdfPrivacyUpdate,"");
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
	    int noOFPages = list.size();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement element = getElement(btnDone, "");
	    while(element.getAttribute("class").contains("pointer")) {
	    	js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
	    	height += temp;
	    	Thread.sleep(200);
	    }
	    System.out.println("sucess");
    clickDone();
	}
	
	public void scrollToTermsAgree() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(termsOfmerchantPDF));
		WebElement ele = getElement(pdfPrivacyUpdate,"");
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
	    int noOFPages = list.size();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement element = getElement(checkbox, "");
	    while(!element.isEnabled()) {
	    	js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
	    	height += temp;
	    	Thread.sleep(200);
	    }
	    clickCheckBox();
	    clickAgree();
	    
	}
	public void verifyWelcomeHeading() {
		String str = getText(lblWelcome, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}
	
	public void clickTab() throws AWTException {
		new CommonFunctions().clickOutSideElement();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public ForgotEmailComponent forgotEmailComponent() {
		return new ForgotEmailComponent();
	}

	public UserNameDropDownComponent userNameDropDownComponent() {
		return new UserNameDropDownComponent();
	}

	public void validateLoginField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
		new CommonFunctions().validateTextFeild(ele, eleName, field[5]);
	}

	/**
	 * Order -minChar, minCharPlus, maxCharMinus, maxChar, maxCharPlus, spaces
	 */
	public void validateEmailTextField(String emailField) {
		validateLoginField(txtEmail, "Email", emailField);
	}

	/**
	 * Order -minChar, minCharPlus, maxCharMinus, maxChar, maxCharPlus, spaces
	 */
	public void validatePasswordText(String passwordField) {
		validateLoginField(txtPassword, "Password", passwordField);
	}

	public CreatePasswordPage createPasswordPage() {
		return new CreatePasswordPage();
	}

	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}

	public ForgotPasswordComponent forgotPasswordComponent() {
		return new ForgotPasswordComponent();
	}
}
