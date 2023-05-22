package coyni.business.components;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.util.concurrent.Uninterruptibles;

public class ToastComponent extends BrowserFunctions {

	private By title = By.cssSelector("p.title");
	private By message = By.cssSelector("p.message");
	private By btnClose = By.cssSelector("");

	/**
	 * verify toast is success or error
	 * 
	 * @param expTitle is error or success
	 */
	public void verifyToastTitle(String expTitle) {
		this.waitForCondition(ExpectedConditions.not(ExpectedConditions.textToBe(title,"")), "toast title not to be empty");
		String actTitle = getText(title, "toast title");
		String actMessage = getText(message, "toast message");
		if (actTitle.toLowerCase().contains(expTitle.toLowerCase())) {
			ExtentTestManager.setPassMessageInReport(actTitle + " Toast displayed");
		} else {
			ExtentTestManager.setFailMessageInReport(
					actTitle + " Toast is displayed instead of " + expTitle + " with message: " + actMessage);
		}
	}

	public void verifyToastMessage(String expMessage) {
		String actMessage = getText(message, "toast message").toLowerCase();
		if (actMessage.contains(expMessage.toLowerCase())) {
			ExtentTestManager.setPassMessageInReport("Toast message is: " + actMessage);
		} else {
			ExtentTestManager.setFailMessageInReport(actMessage + " does not contains exp message: " + expMessage);
		}
	}

	/**
	 * verify toast message
	 * 
	 * @param expTitle   is error or success
	 * @param expMessage is either full or partial message
	 */
	public void verifyToast(String expTitle, String expMessage) {
		Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
		verifyToastTitle(expTitle);
		verifyToastMessage(expMessage);
	}

	public void clickCloseToastButton() {
		click(btnClose, "close button");
	}
	
	
	

}
