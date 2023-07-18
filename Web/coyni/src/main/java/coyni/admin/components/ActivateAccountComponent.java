package coyni.admin.components;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ActivateAccountComponent extends BrowserFunctions {

	private By txtPhoneNum = By.name("phone_number");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By inputBox = By.cssSelector("input[class *= 'verification-input']");
	private By txtCreatePwd = By.name("create_password");
	private By txtConfirmPwd = By.name("confirm_password");
	private By btnCreate = By.xpath("//button[@type='submit']");
	private By txtFirstName = By.name("first_name");
	private By txtLastName = By.name("last_name");
	private By txtEmail = By.id("email-address");

	public void fillFirstName(String phoneNum) {
		enterText(txtFirstName, phoneNum, "FirstName");

	}

	public void fillLastName(String phoneNum) {
		enterText(txtLastName, phoneNum, "LastName");

	}

	public void fillEmail(String phoneNum) {
		enterText(txtEmail, phoneNum, "Email");

	}
	public void fillEmail1() {
		enterText(txtEmail, generateEmail(), "Email");

	}
	public static String generateEmail() {
		int length = 4;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString + "@yopmail.com";
	}

	public void fillPhoneNumber() {
		enterText(txtPhoneNum, generateNumber(), "Phone Number");

	}
	public String generateNumber() {
		Random random = new Random();
		int nextInt = random.nextInt(100000);
		String i = "630132" + String.valueOf(nextInt);
		return i;
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

	public void fillCreatePassword() {
		enterText(txtCreatePwd, "Admin@123", "Create Password");
	}

	public void fillConfirmPassword() {
		enterText(txtConfirmPwd, "Admin@123", "Confirm Password");
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
		} else {
			ExtentTestManager.setPassMessageInReport("input xpath failed " + noOfInputs);
		}
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

}
