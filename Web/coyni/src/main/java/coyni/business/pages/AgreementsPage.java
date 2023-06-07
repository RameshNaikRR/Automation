package coyni.business.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class AgreementsPage extends BrowserFunctions {

	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	private By lblHeading = By.xpath("(//span[.='Agreements'])[2]");
	private By btnTermsOfService = By.xpath("//span[text()='Terms of Service']");
	private By btnPrivacyPolicy = By.xpath("//span[text()='Privacy Policy']"); // Privacy Policy
	private By lnkDownload = By.xpath("(//div[contains(@class,'__react_component_tooltip')])[4]");
	private By lblAgreementsHeading = By.xpath("");
	private By lblAgreementsDes = By.xpath("");
	private By lnkBack = By.xpath("");
	private By lnkExit = By.xpath("");
	private By btnNext = By.xpath("");
	private By lnkPrivacyPolicyView = By.xpath("");
	private By lnkTermsofServiceView = By.xpath("");
	private By popupPDF = By.xpath("");
	private By PDFpages = By.cssSelector("");
	private By checkbox = By.xpath("");
	private By PDFprivacyPolicy = By.xpath("");
	private By privacyPDF = By.xpath("");
	private By lblESignature = By.xpath("//div[text()='eSignature']");
	private By btnSignature = By.xpath("//div[contains(@class,'outline-none')]");

	public void verifyAgreements(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}

	public void verifyTermsofService() {
		new CommonFunctions().verifyCursorAction(btnTermsOfService, "Terms Of Service");
		click(btnTermsOfService, "Terms Of Service");
	}

	public void verifyPrivacyPolicy() {
		new CommonFunctions().verifyCursorAction(btnPrivacyPolicy, "Privacy Policy");
		click(btnPrivacyPolicy, "Privacy Policy");
	}

	public void clickDownload() {
		click(lnkDownload, "Download");
	}

	public void verifyAgreementsHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAgreementsHeading, "Heading is: ", expHeading);
	}

	public void verifyAgreementsDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblAgreementsDes, "Description is: ", expDes);
	}

	public void clickPrivacyPolicyView() {
		new CommonFunctions().verifyCursorAction(lnkPrivacyPolicyView, "Privacy Policy View");
		click(lnkPrivacyPolicyView, "Privacy Policy View");
	}

	public void clickTermsofServiceView() {
		new CommonFunctions().verifyCursorAction(lnkTermsofServiceView, "Terms of Service View");
		click(lnkTermsofServiceView, "Terms of Service View");
	}

	public void clickNext() {
		new CommonFunctions().verifyCursorAction(btnNext, "Next");
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

	public void clickBack() {
		click(lnkBack, "Back");
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}

	public void scrollDownTermsOfService() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(popupPDF));
		WebElement ele = getElement(popupPDF, "");
		int height = ele.getSize().getHeight();
		int temp = height;
		List<WebElement> list = getElementsList(PDFpages, "");
		int noOfPages = list.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(checkbox, "");
		while (!element.isEnabled()) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
	}

	public void scrollDownPrivacyPolicy() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(PDFprivacyPolicy));
		WebElement ele = getElement(privacyPDF, "");
		int height = ele.getSize().getHeight();
		int temp = height;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(checkbox, "");
		while (!element.isEnabled()) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
		clickOnCheckBox();
		clickNext();
	}

	public void clickOnCheckBox() {
		click(checkbox, "Check Box");

	}

	public void verifyESignature(String signature) {
		scrollToElement(lblESignature, "ESignature");
		click(btnSignature, "Signature");
		enterText(btnSignature, signature, "Signature");
	}

};