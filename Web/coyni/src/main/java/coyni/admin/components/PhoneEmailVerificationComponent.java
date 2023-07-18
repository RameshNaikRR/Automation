package coyni.admin.components;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import coyni.admin.pages.ChooseAccountPage;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneEmailVerificationComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[text()='Email Verification']");
	private By lblDescription = By.cssSelector(".text-base");
	private By lblPhoneHeading = By.xpath("//div[text()='Phone Verification']");
	private By lnkResend = By.xpath("//div[text()='Resend Verification Code']");
	// private By txtInput = By.cssSelector(".verification-input-wrapper ");
	private By lnkLogin = By.xpath("");
	private By lnkCoyni = By.xpath("");
	private By lnkBackToLogin = By.xpath("//div[text()='Back to Login']");
	private By headingEmailVerification = By.xpath("//div[text()='Email Verification']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Email Verification", expHeading);
	}

	public void verifEmailVerificationHeading() {
		new CommonFunctions().elementView(headingEmailVerification, "Email Verification");
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Email Verification", expDescription);
	}

	public void getEmailDescription() {
		ExtentTestManager.setInfoMessageInReport(getText(lblDescription, "Email Description : "));
	}

	public void verifyPhoneHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPhoneHeading, "Phone Verification", expHeading);
	}

	public void clickResend() {
		click(lnkResend, " Resend ");

	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public void fillpin(String code) {
		new AuthyComponent().fillInput(code);
	}

	public void clickLogin() {
		if (getElement(lnkLogin, "Login").isEnabled()) {
			click(lnkLogin, " Login ");
		} else {
			ExtentTestManager.setInfoMessageInReport(" Login Button is Disabled");
		}
	}

	public void clickCoyni() {
		click(lnkCoyni, "Coyni");
	}

	public void clickBackToLogin() {
		click(lnkBackToLogin, "Back to Login");
	}

	public void verifyMessage(String message) throws InterruptedException {
		new AuthyComponent().verifyMessage(message);
	}

	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	private By termsOfmerchantPDF = By.xpath("//p[text()='Terms of Service']");//// div[contains(@class,'AgreementModal_apiData__xVMmx')]
	private By pdfPrivacyUpdate = By.xpath("//div[contains(@class,'PaymentTosAgreements_shadedDiv__NbeJi')]");// ("//div[contains(@class,'AgreementModal_apiData')]");
	private By termsOfMerchantPDFPages = By.cssSelector(".react-pdf__Document");
	private By checkbox = By.xpath("//input[@type='checkbox']");// (//input[@type='checkbox'])[3]
	private By btnAgree = By.xpath("//button[contains(text(),'Agree')]");
	private By lblPrivacyPolicy = By.xpath("//div[contains(text(),'Privacy Policy')]");

	public void clickCheckBox() {
		click(checkbox, "Check Box");
	}

	public void clickAgree() {
		click(btnAgree, "Agree");
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
		clickNext();

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
		clickNext();

	}
	
	private By btnNext=By.xpath("//button[text()='Next']");
	
	public void clickNext() {
		click(btnNext, "Next");
	}

}
