package coyni.admin.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class AuthyComponent extends BrowserFunctions {
	private By inputBox = By.cssSelector("input[class *= 'verification-input']");
	private By lblHeading = By.cssSelector(".verify-identity__title");
	private By lblDescription = By.cssSelector(".verify-identity__sub-title");
	private By txtInput = By.cssSelector("input[class *= 'verification-input']:nth-of-type(1)");
	private By lnkSmsCode = By.xpath("//div[contains(@class,'text-xs text-left text-cgy3 group-hover:text-cgy4')]");
	private By lblMessage = By.cssSelector("span[class*='VerificationInput_code'],span.text-crd5");
	private By lnkGoBack = By.xpath("//div[text()='Go Back']");
	private By btnActivateTwostepVerify=By.xpath("//button[text()='Activate Two-Step Authentication']");
	private By btnDone=By.xpath("//button[@type='button'][text()='Done']");

	private static Map<String, String> prevCode = new HashMap<>();

	private String getTwoFactorCode(String securityKey) {
		Totp totp = new Totp(securityKey); // 2FA secret key
		String twoFactorCode = totp.now(); // Generated 2FA code here
		try {
			prevCode.get(securityKey).equals(twoFactorCode);
		} catch (Exception e) {
			prevCode.put(securityKey, "");
		}
		while (prevCode.get(securityKey).equals(twoFactorCode)) {
			twoFactorCode = totp.now();
		}
		prevCode.put(securityKey, twoFactorCode);
		return twoFactorCode;
	}
	public void verifyAutoFocus() {
		new CommonFunctions().verifyAutoFocus(txtInput, "Authy Input Box");

	}

	public void fillAuthyInput(String securityKey) {
		String code = getTwoFactorCode(securityKey);
		fillPin(inputBox, "InputBoxes", code);
	}

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Autentication Heading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description ", expDescription);
	}

	public void clickGoBack() {
		click(lnkGoBack, "Back Option");
	}

	public void clickSmsCode() {
		click(lnkSmsCode, "SmsCode");
	}

	public void verifyMessage(String expMessage) throws InterruptedException {
		waitForCondition(e -> e.findElement(lblMessage).getText().contains("Verification"),
				"verification message is displayed");
		Thread.sleep(500);
		new CommonFunctions().verifyLabelText(lblMessage, "Message", expMessage);
	}

	public void fillAuthyInputInvalid(String code, String character) {
		fillPin(inputBox, "InputBoxes", code);
		ExtentTestManager.setPassMessageInReport(character + " entered in text field");
	}

	// order - alphabet, specialChar
	public void validateAuthyField(String code) {
		String[] field = code.split(",");
		for (int i = 0; i < 2; i++) {
			new CommonFunctions().validateTextFeild(txtInput, "Input", field[i]);
		}
	}

	public void fillInput(String code) {
		fillPin(inputBox, "InputBoxes", code);
	}

	public void verifyLogin() {
		waitForCondition(e -> !e.getCurrentUrl().contains("verify-you-identity"),
				"Waiting for url to contain token-account");

		String pageURL = getPageURL();
		if (pageURL.contains("token-account") || pageURL.contains("getstarted")) {
			ExtentTestManager.setPassMessageInReport("Login success");
		} else {
			ExtentTestManager
					.setFailMessageInReport("Login failed. Page url " + pageURL + " does not contains token-account");
		}
	}

	public void verifyLoginWithInvalidPin() {
		String pageURL = getPageURL();
		if (pageURL.contains("token-account") || pageURL.contains("getstarted")) {
			ExtentTestManager.setFailMessageInReport("Login success with invalid pin");
		} else {
			ExtentTestManager.setPassMessageInReport("Login failed with invalid pin");
		}
	}

	public void fillPin(By ele, String eleName, String code) {
		List<WebElement> inputs = getElementsList(ele, eleName);
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
			ExtentTestManager.setPassMessageInReport("Authy Verification Code entered");
		}
		//
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

	/**
	 * this method will click on Button `Activate Two step Authentication`. 
	 * this button is visible after creating coyni employee in admin
	 */
	public void clickActivateTwoStepAuthyLink() {
		click(btnActivateTwostepVerify, "Activate Two Step Authentication Link");
	}
	/**
	 * using the existing method for entering authy verification code
	 * @param authyCode
	 */
	public void enterVerficationCode(String authyCode) {
		fillInput(authyCode);
	}
	public void clickDoneBtn() throws InterruptedException {
		Thread.sleep(2000);
		click(btnDone, "Done Button");
		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(3000);
	}
	

}
