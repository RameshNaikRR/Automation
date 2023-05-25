package coyni.business.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni.business.components.PhoneVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class SignupPage extends BrowserFunctions {

	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By txtFirstName = By.xpath("");
	private By txtLastName = By.xpath("");
	private By txtPhoneNumber = By.xpath("");
	private By txtEmail = By.xpath("");
	private By txtCreatePassword = By.xpath("");
	private By txtConfirmPassword = By.xpath("");
	private By btnNext = By.xpath("");
	private By lnkLogIn = By.xpath("");
	private By greendot1 = By.xpath("");
	private By greendot = By.xpath("");
	private By reddot = By.cssSelector("");
	private By txtPassword = By.xpath("");
	private By iconCreatePassword = By.cssSelector("");
	private By iconConfirmPassword = By.cssSelector("");
	private By eyeIconConfirmPassword = By.xpath("");
	private By eyeIconCreatePassword = By.xpath("");
	private By lblLogin = By.xpath("");
	private By popupPDF = By.xpath("");
	private By PDFpages = By.cssSelector("");
	private By checkbox = By.xpath("");
	private By PDFprivacyPolicy = By.xpath("");
	private By privacyPDF = By.xpath("");

	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	private String Email;
	private String CreatePassword;
	private String ConfirmPassword;

	public void verifyHeading(String expHedaing) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHedaing);
	}

	public void verifyDescription(String expHead) {
		new CommonFunctions().verifyLabelText(lblDescription, "Heading is: ", getCopiedData());
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "First Name");
		firstName = getText(txtFirstName, "First Name");
	}

	public void fillLastNmae(String lastNmae) {
		enterText(txtLastName, lastNmae, "Last Name");
		lastNmae = getText(txtLastName, "Last Name");
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtPhoneNumber, phoneNumber, "Phone Number");
		phoneNumber = getText(txtPhoneNumber, "Phone Number");
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
		email = getText(txtEmail, "Email");
	}

	public void fillCreatePassword(String createPassword) throws InterruptedException {
		String[] inputs = { "H", "h", "qazwsxeh", "qazwsxedcrfv", "@", "1" };
		String[] messages = { "uppercase", "lowercase", "total characters", "total characters", "special character",
				"number" };
		for (int i = 0; i < inputs.length; i++) {
			enterText(txtCreatePassword, inputs[i], "Create Password");
			String text = "";
			if (inputs[i].length() >= 8) {
				text = getText(greendot1, "Validation Dot");
			} else {
				text = getText(greendot, "Validation Dot");
			}
			if (text.toLowerCase().contains(messages[i])) {
				ExtentTestManager.setPassMessageInReport("Password field satisifies strength condition : " + text);
			} else {
				ExtentTestManager
						.setFailMessageInReport("Password field does not satisifies strength condition : " + text);
			}

			clearText(txtCreatePassword, "Create Password");
		}
		int initialRedDot = getElementsList(reddot, "red dot").size();
		Thread.sleep(100);
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		Thread.sleep(100);
		enterText(txtCreatePassword, createPassword, "Create Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		System.out.println("value: " + initialRedDot + " " + initialGreenDot + " " + finalRedDot + " " + finalGreenDot);
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

	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtPassword, attribute, password);
		if (attributeValue.contains("password")) {
			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}

	public void clickCreateIcon() {
		click(iconCreatePassword, "Create Icon");
	}

	public void clickConfirmIcon() {
		click(iconConfirmPassword, "Confirm Icon");
	}

	public void verifyCreatePasswordMasked(String CreatePassword, String expType) {
		enterText(txtCreatePassword, CreatePassword, "Create Password");
		String str = getAttributeValue(txtCreatePassword, "type", CreatePassword);
		if (expType.contains(str)) {
			ExtentTestManager
					.setPassMessageInReport("Create password have masked with black circles " + CreatePassword);
		} else {
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

		if (actualPaasword.equals(CreatePassowrd)) {
			ExtentTestManager.setPassMessageInReport("Enterd password is visibled " + actualPaasword);
		} else {
			ExtentTestManager.setFailMessageInReport("Enterd password is not visibled " + actualPaasword);

		}
	}

	public void verifyConfirmPasswordMasked(String ConfirmPassword, String expType) {
		enterText(txtConfirmPassword, ConfirmPassword, "Create Password");
		String str = getAttributeValue(txtCreatePassword, "type", ConfirmPassword);
		if (expType.contains(str)) {
			ExtentTestManager
					.setPassMessageInReport("Create password have masked with black circles " + ConfirmPassword);
		} else {
			ExtentTestManager
					.setFailMessageInReport("Create password not masked with black circles " + ConfirmPassword);

		}
	}

	public void verifyConfirmPasswordEyeIcon() {
		new CommonFunctions().elementView(eyeIconConfirmPassword, "Confirm Password View Eye Icon");
	}

	public void verifyClickOnConfirmPasswordShowIcon(String CreatePassowrd) {
		enterText(txtCreatePassword, CreatePassowrd, "Create Password");
		click(eyeIconCreatePassword, "Clicked  on ShowIcon");
		String actualPaasword = getAttributeValue(txtCreatePassword, "value", CreatePassowrd);

		if (actualPaasword.equals(CreatePassowrd)) {
			ExtentTestManager.setPassMessageInReport("Enterd password is visibled " + actualPaasword);
		} else {
			ExtentTestManager.setFailMessageInReport("Enterd password is not visibled " + actualPaasword);

		}
	}

	public void verifyLoginPageHeading() {
		new CommonFunctions().elementView(lblLogin, "Login Page heading is");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");

		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

	public void clickLogin() {
		new CommonFunctions().verifyCursorAction(lnkLogIn, "Login");
		click(lnkLogIn, "Login");
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



	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}
}
