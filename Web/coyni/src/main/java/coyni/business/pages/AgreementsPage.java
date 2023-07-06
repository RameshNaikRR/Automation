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
	private By lblHeading = By.xpath("//h4[text()='Agreements']");
	private By lblDesc = By.xpath("//p[contains(text(),'before you submit your')]");
	private By agreementSign = By.xpath("//div[@contenteditable='true']");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By btnExit = By.xpath("//strong[text()='Exit']");
	private By btnAgree = By.xpath("//button[text()='Agree']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By clickPrivacyPolicy = By.xpath("(//button[text()='View'])[2]");
	private By clickTermsOfService = By.xpath("(//button[text()='View'])[1]");
	private By popupPDF = By.xpath("//div[contains(@class,'Agreements_apiData')]");
	private By PDFpages = By.cssSelector(".react-pdf__Page");

	public By getAgreementsView(String Agreements) {
		return By.xpath(String.format("(//button[text()='View'])[%s]", "Agreements"));
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyAgreementsDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDesc, "Description", description);
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
	//         for (int i = 0; i <= noOfPages+2; i++) {
	//             js.executeScript("arguments[0].scrollTop = arguments[1]", ele,
	// height);
	//             height += temp;
	//             Thread.sleep(200);
	//         }

	public void scrollDownPrivacyPolicy() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(popupPDF));
		WebElement ele = getElement(popupPDF, "");
		int height = ele.getSize().getHeight();
		int temp = height;
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

	public void clickTermsOfServices() {
		click(clickTermsOfService, "Terms Of Services");
	}

	public void clickPrivacyPolicy() {
		click(clickPrivacyPolicy, "Privacy Policy");
	}

	public void AgreementSign(String sign) {
		enterText(agreementSign, sign, "Business Agreement");
	}

	public void clickSave() {
		if (getElement(btnSave, "Next").isEnabled()) {
			click(btnSave, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is in disabled mode");
		}
	}

	public void clickAgree() {
		if (getElement(btnAgree, "Agree").isEnabled()) {
			new CommonFunctions().verifyCursorAction(btnAgree, "Agree");
			click(btnAgree, "Agree ");
		} else {
			ExtentTestManager.setPassMessageInReport("Agree button is in disabled mode");
		}
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
	}

	public void clickCheckBox() {
		click(checkbox, "checkbox");
	}

	public void clickExit() {
		click(btnExit, "Exit");
	}

};