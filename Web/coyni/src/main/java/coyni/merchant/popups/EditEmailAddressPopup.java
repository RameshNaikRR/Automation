package coyni.merchant.popups;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class EditEmailAddressPopup extends BrowserFunctions {

	private By txtOldEmailAddress = By.xpath("//input[@id='EmailId']");
	private By txtNewEmailAddress = By.xpath("//input[@name='email']");
	private By btnSendcode = By.xpath("//button[text()='Send Code']");
	private By lblEditEmailAddress = By.xpath("//h1[text()='Edit Email Address']");

	public void verifyOldEmailAddress() {
		new CommonFunctions().elementView(txtOldEmailAddress, "Old Email Address");
	}

	public void fillNewEmailAddress(String newNumber) {
		// waitForElement(txtNewEmailAddress, waittime, WaitForElement.visibility);
		enterText(txtNewEmailAddress, newNumber, "NewNumber");
	}

	public void clickSendCode() {
		if (getElement(btnSendcode, "SendCode").isEnabled()) {
			click(btnSendcode, "SendCode");
		} else {
			ExtentTestManager.setPassMessageInReport("SendCode button is Disabled");
		}
	}

	public void sendCodeEnabled() {
		verifyElementDisplayed(btnSendcode, "Send Code");
	}

	public void verifyEditEmailAddress(String emailAddress) {
		new CommonFunctions().verifyLabelText(lblEditEmailAddress, "Edit Email Address Heading", emailAddress);
	}

	public VerifyCurrentEmailAddressPopup verifyCurrentEmailAddressPopup() {
		return new VerifyCurrentEmailAddressPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public void clickTab() throws AWTException {
		new CommonFunctions().clickOutSideElement();
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		ExtentTestManager.setInfoMessageInReport("click on tab");
	}

}
