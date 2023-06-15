package coyni_mobile.popups;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class OptionalMessagePopup extends MobileFunctions {
	private By btnCancel = MobileBy.AccessibilityId("(//*[@name='Cancel'])[1]");
	private By btnDone = MobileBy.AccessibilityId("(//*[@name='Done'])[1]");
	private By txtMessage = MobileBy.AccessibilityId("");
	private By lblCount = MobileBy.AccessibilityId("");

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void fillMessage(String message) {
		enterText(txtMessage, message, "Message");
	}

	/**
	 * Order -minChar, MaxiPlus
	 */
	public void validateMessageField() {
		int word = getText(txtMessage).length();
		String[] wordNumber = getText(lblCount).split("/");
		int wordCount = Integer.parseInt(wordNumber[0]);
		int totalCount = Integer.parseInt(wordNumber[1]);
		if (word == wordCount && totalCount == 120) {
			ExtentTestManager.setPassMessageInReport("The Optional Message field is properly showing the letter count");
		} else {
			ExtentTestManager
					.setFailMessageInReport("The Optional Message field is not properly showing the letter count");
		}
	}

}
