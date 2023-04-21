package coyni.merchant.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;

public class MerchantAgreementsPage extends BrowserFunctions {
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	private By popupPDF = By.xpath("//div[contains(@class,'Agreements_apiData')]");
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By btnAgree = By.xpath("//button[text()='Agree']");
	private By lblHeading = By.xpath("//h4[text()='Agreements']");
	private By lblMerchantAgreementsView = By.xpath("//button[text()='View']");
	private By lblMerchantAgreement = By.xpath("//h6[text()='Merchant Agreements']");
	private By lblPrivacyPolicy = By.xpath("//p[text()='Privacy Policy']");
	private By lblTermsOfService = By.xpath("//p[text()='Terms of Service']");
	private By lblESignature = By.xpath("//div[text()='eSignature']");
	private By btnSignature = By.xpath("//div[contains(@class,'outline-none')]");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By btnExit = By.xpath("//button[text()='Exit']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By PDFprivacyPolicy = By.xpath("((//span[.='']))[1]");
	private By privacyPolicyUpdate = By.xpath("//span[contains(text(),'Privacy Policy')]");
	private By btnViewForTermsOfService = By.xpath("(//button[text()='View'])[1]");
	private By btnViewForPrivacyPolicy = By.xpath("(//button[text()='View'])[2]");
	private By PDFpages = By.cssSelector(".react-pdf__Page");

	private By privacyPDF = By.xpath("//div[contains(@class,'PrivacyAgreements_apiData__ewNFA')]");

	public By getAgreements(String Agreements) {
		return By.cssSelector(String.format(
				"div[class*='bg-cwhite BusinessSettingsAgreements_agreements']>div:nth-of-type(%s)", "Agreements"));
	}

	public void clickOnCheckBox() {
		click(checkbox, "Check Box");

	}

	public void clickAgree() {
		click(btnAgree, "Agree");
	}

	public void clickMerchantAgreement() {
		click(lblMerchantAgreementsView, "Merchant Agreements");
	}

	public void clickView() {
		click(btnViewForTermsOfService, "View");
	}

	public void clickViewForPrivacyPolicy() {
		click(btnViewForPrivacyPolicy, "View");
	}

	public void clickMerchantAgreements() {
		click(lblMerchantAgreement, "Agreements");
	}

	public void clickSave() {
		click(btnSave, " Save Button");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickExit() {
		click(btnExit, "Exit");
	}

	public void clickNext() {
		click(btnNext, "Next");
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
//		for (int i = 0; i <= noOfPages+2; i++) {
//			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
//			height += temp;
//			Thread.sleep(200);
//		}
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

	public void verifyESignature(String signature) {
		scrollToElement(lblESignature, "ESignature");
		click(btnSignature, "Signature");
		enterText(btnSignature, signature, "Signature");
	}

	public void verifyMerchantAgreement(String expHeading) {
		new CommonFunctions().elementView(lblMerchantAgreementsView, expHeading);
	}

	public void verifyPrivacyPolicy(String expHeading) {
		new CommonFunctions().elementView(lblPrivacyPolicy, expHeading);
	}

	public void verifyTermsOfService(String expHeading) {
		new CommonFunctions().elementView(lblTermsOfService, expHeading);
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
