package coyni_mobile.utilities;

import org.openqa.selenium.By;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import ilabs.mobile.utilities.FileReaderManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class CommonFunctions {

	MobileFunctions mobileFunctions;

	public CommonFunctions() {
		mobileFunctions = new MobileFunctions();
	}

	public void verifyLabelText(By label, String labelName, String expText) {
		String actText = mobileFunctions.getText(label).trim().replace("\n", "").replace(",", "");
		if (expText.equalsIgnoreCase(actText)) {
			ExtentTestManager.setPassMessageInReport(String.format("%s is %s", labelName, actText));
		} else {
			ExtentTestManager.setWarningMessageInReport(
					String.format("%s ::<p>Expected =  %s</br>Actual = %s</p>", labelName, expText, actText));
		}
	}

	public void elementView(By ele, String eleName) {
		try {
			if (mobileFunctions.getElement(ele, eleName).isDisplayed()) {
				ExtentTestManager.setPassMessageInReport(eleName + " is displayed ");
			} else {
				ExtentTestManager.setFailMessageInReport(eleName + " is not displayed ");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" element View failed due to exception " + e);
		}

	}

	public void validateFormErrorMessageIOS(String expErrMsg, String elementName) {
		try {
			By errorMsgs = MobileBy.xpath(String.format("//*[contains(@label,'%s,')]", elementName));
			String msg = mobileFunctions.getText(errorMsgs).split(",")[1];
			String actualMsg = msg.trim();
			System.out.println(actualMsg);
			mobileFunctions.waitForVisibility(errorMsgs);
			if (actualMsg.equals(expErrMsg)) {
				ExtentTestManager
						.setPassMessageInReport("Error message '" + expErrMsg + "' displayed for " + elementName);
			} else {
				ExtentTestManager
						.setFailMessageInReport("Error message '" + expErrMsg + "' not displayed for " + elementName);
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate form error message failed due to exception " + e);
		}
	}

	public void validateFormErrorMessage(String expErrMsg, String elementName) {
		try {
			By errorMsgs = MobileBy.xpath("(//*[contains(@resource-id,'Error')])[2]");
			mobileFunctions.waitForVisibility(errorMsgs);
			// mobileFunctions.
			boolean status = mobileFunctions.getElementList(errorMsgs, "error Message").stream()
					.map(ele -> ele.getText().toLowerCase()).anyMatch(msg -> msg.contains(expErrMsg.toLowerCase()));
			if (status) {
				ExtentTestManager
						.setPassMessageInReport("Error message '" + expErrMsg + "' displayed for " + elementName);
			} else {
				ExtentTestManager
						.setFailMessageInReport("Error message '" + expErrMsg + "' not displayed for " + elementName);
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate form error message failed due to exception " + e);
		}
	}

	public void clearText(By ele, String eleName) {
		try {
			mobileFunctions.getElement(ele, eleName).clear();
			ExtentTestManager.setPassMessageInReport("Text field " + eleName + " is cleared");
		} catch (Exception e) {
			ExtentTestManager.setPassMessageInReport("Text field " + eleName + " is not cleared");
		}
	}

	public void validateField(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			clickEnter();
			String actualtext = mobileFunctions.getText(ele).replace(" ", "").replace("/", "");
			System.out.println("length " + actualtext.length());
			By errorMsgs = MobileBy.xpath("(//*[contains(@resource-id,'Error')])[2]");
			if (enterText.equalsIgnoreCase(actualtext)
					&& mobileFunctions.getElementList(errorMsgs, "errorMsg").size() == 0) {
				ExtentTestManager
						.setPassMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
			} else {

				ExtentTestManager
						.setFailMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate field is failed due to exception " + e);

		}

	}

	public void validateFieldMaxichar(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			clickEnter();
			String actualtext = mobileFunctions.getText(ele);
			if (!enterText.equalsIgnoreCase(actualtext)) {

				ExtentTestManager
						.setPassMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
			} else {

				ExtentTestManager
						.setInfoMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateFieldMaxichar is failed due to exception " + e);
		}
	}

	public void validateFieldWithalphabet(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager.setInfoMessageInReport("trying to enter alphabets in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = mobileFunctions.getText(ele);
			if (actualtext.length() == 0) {

				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting alphabets");
			} else {

				ExtentTestManager.setInfoMessageInReport(eleName + " is accepting alphabets");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateFieldWithalphabet is failed due to exception " + e);
		}
	}

	public void validateFieldWithNumber(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager.setInfoMessageInReport("trying to enter Numbers in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = mobileFunctions.getText(ele);
			if (actualtext.length() == 0) {

				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Numbers");
			} else {

				ExtentTestManager.setInfoMessageInReport(eleName + " is accepting Numbers");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateFieldWithNumber is failed due to exception " + e);
		}
	}

	public void validateFieldWithSpecialchar(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager.setInfoMessageInReport("trying to enter Special characters in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = mobileFunctions.getText(ele);
			if (actualtext.length() == 0) {

				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Special characters");
			} else {

				ExtentTestManager.setInfoMessageInReport(eleName + " is accepting Special characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateFieldWithSpecialchar is failed due to exception " + e);
		}
	}

	public boolean isPlatformiOS() {
		return FileReaderManager.getInstance().getConfigReader().get("platform").equalsIgnoreCase("ios");

	}

	public void checkPassword(By ele, By ele1) {
		String enterPassword = mobileFunctions.getText(ele);
		String confirmPassword = mobileFunctions.getText(ele1);
		if (enterPassword.equals(confirmPassword)) {
			ExtentTestManager.setPassMessageInReport("Password is Same");
		} else {
			ExtentTestManager.setFailMessageInReport("Password is not Same");
		}
	}

	public void clickEnter() {
		 ((AndroidDriver)DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
}