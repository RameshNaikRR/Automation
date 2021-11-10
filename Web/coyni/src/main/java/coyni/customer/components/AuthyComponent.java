package coyni.customer.components;

import java.util.List;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AuthyComponent extends  BrowserFunctions{

	private By inputBox = By.cssSelector("input[class *= 'verification-input']");
	
	private By heading = By.cssSelector("");
	
	private By lblMessage = By.cssSelector("");
	
	private By lnkGoBack = By.cssSelector("");

	private static String prevCode = "";

	private String getTwoFactorCode(String securityKey) {
		Totp totp = new Totp(securityKey); // 2FA secret key
		String twoFactorCode = totp.now(); // Generated 2FA code here
		while (prevCode.equals(twoFactorCode)) {
			twoFactorCode = totp.now();

		}
		prevCode = twoFactorCode;
		return twoFactorCode;
	}

	public void fillAuthyInput(String securityKey) {
		String code = getTwoFactorCode(securityKey);
		List<WebElement> inputs = getElementsList(inputBox, "input boxes");
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
			ExtentTestManager.setPassMessageInReport("Authy Verification Code entered");
		}
		//
	}	
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Autentication Heading", expHeading);
	}
	
	public void verifyMessage(String expMessage) {
		new CommonFunctions().verifyLabelText(lblMessage, "Sucess/Failure Message", expMessage);
	}
	
	
	public void fillAuthyInputInvalid(String code) {
		
		List<WebElement> inputs = getElementsList(inputBox, "input boxes");
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
			ExtentTestManager.setPassMessageInReport("Authy Verification Code entered");
		}
		//
	}
	
	
	public void clickGoBack() {
		click(lnkGoBack, "Back Option");
	}
	
}
