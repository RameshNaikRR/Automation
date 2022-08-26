package coyni.merchant.popups;

import java.awt.AWTException;

import org.openqa.selenium.By;

import coyni.merchant.components.PhoneVerificationComponent;
import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class EditPhoneNumberPopup extends BrowserFunctions {

	private By txtOldNumber = By.xpath("");
	private By txtNewNumber = By.xpath("//input[@id='Phone_Number']");
	private By btnSendCode = By.xpath("//button[text()='Send Code']");
	private By btnSMSCode = By.xpath("//span[contains(text(),'Get an SMS code.')]");
	private By lblAuthyEditPhone = By.xpath("//h1[text()='Edit Phone Number']");
	private By lblEditPhoneNumberAuthenticationDescription = By
			.xpath("//span[@class='mt-10 text-base text-center text-cgy4']");
	private By Heading = By.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading1__18f6i mt-4 text-center']");

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public VerifyCurrentPhoneNumberPopup verifyCurrentPhoneNumberPopup() {
		return new VerifyCurrentPhoneNumberPopup();
	}

	public void verifyAuthyEditPhoneHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAuthyEditPhone, "Authy Edit Phone Number Headig", expHeading);
	}

	public void verifyEditPhoneNumberAuthenticationDescription(String expEditPhoneNumberAuthenticationDescription) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNumberAuthenticationDescription,
				"Edit Phone Number Description Text", expEditPhoneNumberAuthenticationDescription);
	}

	public void VerifyOldNumber(String OldNumber) {
		new CommonFunctions().verifyLabelText(txtOldNumber, OldNumber, "OldNumber");
	}

	public void fillNewNumber(String NewNumber) {
		// waitForElement(txtNewNumber, waittime, WaitForElement.visibility);
		enterText(txtNewNumber, NewNumber, "NewNumber");
	}

	public void clickSendCode() {
		click(btnSendCode, "Click SendCode");
	}

	public void clickSMSCode() {
		click(btnSMSCode, "Click SMSCode");
	}

	public void verifyPageHeadingWithValidCode(String expHeding) {
		new CommonFunctions().verifyLabelText(Heading, "Edit Phone Number", expHeding);
	}

	public void verifyNewPhoneField(String expNewPhoneNumber) {
		new CommonFunctions().validateTextFeild(txtNewNumber, "New Phone Number", expNewPhoneNumber);
	}

	public void verifySendCodeButtonEnabled() {
		verifyElementPresence(btnSendCode, "Send Code");

	}

	public void clickTab() throws AWTException {
		new CommonFunctions().clickOutSideElement();
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		ExtentTestManager.setInfoMessageInReport("clicked on tab");
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

}
