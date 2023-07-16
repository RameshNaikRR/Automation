package coyni.business.pages;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni.business.components.AuthyComponent;
import coyni.business.components.ForgotPasswordComponent;
import coyni.business.components.PhoneVerificationComponent;
import coyni.business.components.RetrieveEmailComponent;
import coyni.business.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.Navigation;

public class LoginPage extends BrowserFunctions {

	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	private By lblHeading = By.xpath("//span[@ui-auto='login_logintocoyni_text']");
	private By lblDescription = By.xpath("");
	private By txtEmail = By.xpath("//input[@data-ui-auto='login_email_field']");
	private By txtPassword = By.xpath("//input[@data-ui-auto='login_password_field']");
	private By lnkForgotEmail = By.xpath("//button[@ui-auto='login_forgotemail_text']");
	private By lnkForgotPassword = By.xpath("//button[@ui-auto='login_forgotpassword_text']");
	private By eyeIcon = By.cssSelector(".icon-button");
	private By btnNext = By.xpath("//button[@data-ui-auto='login_next_button']");
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
	private By lblAdditionalDocument = By
			.xpath("//h1[contains(text(),'Merchant Application Additional Documentation')]");
	private By lblWelcome = By.xpath("//span[contains(text(),'Welcome to ')]");
	private By btnClose = By.xpath("//button[@classs='self-end']");

	CommonFunctions commonfunctions = new CommonFunctions();

	public void verifyPageHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", heading);
	}

	public void verifyPageDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", description);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
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

	public void clickRefresh() {
		navigate(Navigation.REFRESH);
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}

	public void clickEyeIcon() {
		click(eyeIcon, "EyeIcon");
	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next button is Enabled");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickRetrievemail() {
		click(lnkForgotEmail, "ForgotEmailLink");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPasswordLink");
	}

	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}

	public void verifyPassword() {
		new CommonFunctions().elementView(txtPassword, "Password");
	}

	public void verifyRetrieveEmail() {
		new CommonFunctions().elementView(lnkForgotEmail, "ForgotEmail");
	}

	public void verifyForgotPassword() {
		new CommonFunctions().elementView(lnkForgotPassword, "ForgotPassword");
	}

	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtPassword, attribute, password);
		if (attributeValue.contains("password")) {

			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}

	public void clickOutSide() throws AWTException {
		new CommonFunctions().clickTab();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
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
		click(btnDone, "Done");
	}

	public void clickCheckBox() {
		click(checkbox, "Check Box");
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
		clickAgree();
		clickDone();

	}

	public void scrollToPrivacyAgreeNonMaterial() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblPrivacyPolicy));
		WebElement ele = getElement(pdfPrivacyUpdate, "");
		Thread.sleep(2000);
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
		int noOFPages = list.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(btnDone, "");
		while (element.getAttribute("class").contains("pointer")) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
		clickDone();
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

	public void scrollToTermsAgreeNonMateria() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(termsOfmerchantPDF));
		WebElement ele = getElement(pdfPrivacyUpdate, "");
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(termsOfMerchantPDFPages, "");
		int noOFPages = list.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(btnDone, "");
		while (element.getAttribute("class").contains("pointer")) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
		System.out.println("sucess");
		clickDone();
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

	public void verifyWelcomeHeading() {
		String str = getText(lblWelcome, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public int verifyNonMaterialAgrrement() {
		int i = getElementsList(btnClose, "Material Aggrement").size();
		return i;
	}

	public ForgotPasswordPage forgotPasswordPage() {
		return new ForgotPasswordPage();
	}

	public ForgotPasswordComponent forgotPasswordComponent() {
		return new ForgotPasswordComponent();
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public RetrieveEmailComponent retrieveEmailComponent() {
		return new RetrieveEmailComponent();
	}

}