package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.PhoneEmailVerificationComponent;
import coyni.apibusiness.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class LoginPage extends BrowserFunctions {
	
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 120);
	
	private By lblApplicationHeading = By.cssSelector(".title");
	private By lblApplicationDescription = By.cssSelector(".disclaimer");
	private By lnkLogin = By.xpath("//span[.='Log In']");
	private By lblHeading = By.cssSelector(".business-login__title");
	private By lblDescription = By.cssSelector(".business-login__sub_title");
	private By txtEmail = By.cssSelector("#Email");
	private By txtPassword = By.cssSelector("#Password");
	private By eyeIcon = By.xpath("//button[@type='button']");
	private By btnNext = By.cssSelector(".business-login__login-button");
	private By lnkForgotEmail = By.xpath("//button[.='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//button[.='Forgot Password?']");
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
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By termsOfServicePDF = By.xpath("//div[contains(@class,'AgreementModal_pdfSize__yrzAs')]");
	private By termsOfmerchantPDF = By.xpath("//div[contains(@class,'AgreementModal_apiData__xVMmx')]");
	private By lblPrivacyPolicy = By.xpath("//div[contains(text(),'Privacy Policy')]");
	private By pdfPrivacyUpdate = By.xpath("//div[contains(@class,'AgreementModal_apiData')]");
	private By lblAdditionalDocument = By
			.xpath("//h1[contains(text(),'Merchant Application Additional Documentation')]");
	private By lblWelcome = By.xpath("//span[contains(text(),'Welcome to ')]");
	private By btnClose = By.xpath("//button[@classs='self-end']");



//	public Robot robot() throws AWTException
//	{
//		return new Robot();
//	}

	public void verifyApplicationHeading(String applicationHeading) {
		new CommonFunctions().verifyLabelText(lblApplicationHeading, "applicationHeading", applicationHeading);

	}

	public void verifyApplicationDescription(String applicationDescription) {
		new CommonFunctions().verifyLabelText(lblApplicationDescription, "applicationDescription",
				applicationDescription);
	}

	public int verifyNonMaterialAgrrement() {
		int i = getElementsList(btnClose, "Material Aggrement").size();
		return i;
	}

	public void verifyWelcomeHeading() {
		String str = getText(lblWelcome, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public int verifyTermsOfServicesHeading() {
		int i = getElementsList(termsOFServicesUpdate, "").size();
		return i;
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void clickCheckBox() {
		click(checkbox, "checkBox");
	}

	public void clickAgree() {
		click(btnAgree, "Agree");
	}

	public int verifyPrivacyPolicyHeading() {
		int i = getElementsList(privacyPolicyUpdate, "").size();
		return i;
	}

	public void scrollToPrivacyAgree() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblPrivacyPolicy));
		WebElement ele = getElement(pdfPrivacyUpdate, "");
		Thread.sleep(2000);
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
		int noOFPages = list.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(checkbox, "");
		while (!element.isEnabled()) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
		clickCheckBox();
		clickAgree();

	}

	public void scrollToTermsAgree() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(termsOfmerchantPDF));
		WebElement ele = getElement(pdfPrivacyUpdate, "");
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
		int noOFPages = list.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(checkbox, "");
		while (!element.isEnabled()) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
		clickCheckBox();
		clickAgree();
	}

	public void clickLogin() {
		click(lnkLogin, "Login");
	}

	public void verifyPageHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", heading);
	}

	public void verifyPageDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", description);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}

	public void validateEmail(String email) {
		validateTextField(email, txtEmail, "Email");
	}

	public void validatePassword(String password) {
		validateTextField(password, txtPassword, "Password");
	}

	public void validateTextField(String text, By ele, String eleName) {
		String[] data = text.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, data[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, data[4]);
	}

	public void clickEyeIcon() {
		click(eyeIcon, "EyeIcon");
	}

	public void verifyPasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtPassword, "password");
	}

//	public void clickNext() {
//		click(btnNext, "Next");
//	}
	public void clickNext() {
		new CommonFunctions().clickOutSideElement();
		if (getElement(btnNext, "Next button").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next button is Enabled");

		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickForgotEmail() {
		click(lnkForgotEmail, "ForgotEmailLink");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPasswordLink");
	}

	public void verifyEyeIcon() {
		new CommonFunctions().elementView(eyeIcon, "EyeIcon");
	}

	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}

	public void verifyPassword() {
		new CommonFunctions().elementView(txtPassword, "Password");
	}

	public void verifyForgotEmail() {
		new CommonFunctions().elementView(lnkForgotEmail, "ForgotEmail");
	}

	public void verifyForgotPassword() {
		new CommonFunctions().elementView(lnkForgotPassword, "ForgotPassword");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public ForgotPasswordPage forgotPasswordPage() {
		return new ForgotPasswordPage();

	}

	public ForgotEmailPage forgotEmailPage() {
		return new ForgotEmailPage();

	}

	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

}
