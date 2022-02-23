package coyni.admin.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneVerificationComponent extends BrowserFunctions{
	
	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By lnkResend = By.xpath("");
	private By txtInput  = By.xpath("");
	private By lnkLogin  = By.xpath("");
	private By lnkCoyni = By.xpath("");
	private By lnkBacktoLogin = By.xpath("");
	
	
	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Heading");
	}
	
	public void VerifyDescription() {
		new CommonFunctions().elementView(lblDescription, "Description");
	}
	
	public void clickResend() {
		click(lnkResend,"resend");
	}
	
	public void fillInput(String code) {
		List<WebElement> inputs = getElementsList(txtInput, "input boxes");
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
			ExtentTestManager.setPassMessageInReport("verification entered in text field");
		}
	}
	
	public void clickLogin() {
		click(lnkLogin,"Click Login");
	}
	
	public void clickCoyni() {
		click(lnkCoyni, "Click Coyni");
	}
	
	public void clickBackToLogin() {
		click(lnkBacktoLogin,"Click Back To Login");
	}
	
	}
