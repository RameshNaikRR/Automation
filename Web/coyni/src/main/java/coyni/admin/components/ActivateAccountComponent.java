package coyni.admin.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ActivateAccountComponent extends BrowserFunctions{
	
	private By txtPhoneNum=By.name("phone_number");
	private By btnNext=By.xpath("//button[@type='button']");
	private By lblVerifyPhoneNum=By.xpath("//div[text()='Verify Your Phone Number']");
	private By inputBox = By.cssSelector("input[class *= 'verification-input']");
	private By lblCreatePwd=By.xpath("//span[text()='Create Password']");
	private By txtCreatePwd=By.name("create_password");
	private By txtConfirmPwd=By.name("confirm_password");
	private By btnCreate=By.xpath("//button[@type='submit']");
	
	
	
	
	public void fillPhoneNumber(String phoneNum) {
		enterText(txtPhoneNum, phoneNum, "Phone Number");
		
	}
	
	public void clickNext() {
		if (getElement(btnNext, "Next Button").isEnabled()) {
			click(btnNext, "Next button ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}
	
	public void fillVerificationCode(String code) throws InterruptedException {
		System.out.println(code);
		Thread.sleep(5000);
		fillPin(inputBox, "InputBoxes", code);
		
	}
	
	public void fillCreatePassword(String createPassword) {
		enterText(txtCreatePwd, createPassword, "Create Password");
	}
	public void fillConfirmPassword(String confirmPwd) {
		enterText(txtConfirmPwd, confirmPwd, "Confirm Password");
	}

	public void clickCreate() {
		if (getElement(btnCreate, "Create Button").isEnabled())
			click(btnCreate, "Create button");
		else
			ExtentTestManager.setPassMessageInReport("Create button is Disabled");
	}
	
	
	public void fillPin(By ele, String eleName, String code) {
		List<WebElement> inputs = getElementsList(ele, eleName);
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
			ExtentTestManager.setPassMessageInReport("Verification Code entered");
		}
		else {
			ExtentTestManager.setPassMessageInReport("input xpath failed "+noOfInputs);
		}
	}
	
	
	
	

}
