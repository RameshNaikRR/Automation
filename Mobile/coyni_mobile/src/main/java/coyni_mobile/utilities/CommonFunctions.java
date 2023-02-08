package coyni_mobile.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import ilabs.mobile.utilities.FileReaderManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonFunctions {

	MobileFunctions mobileFunctions;

	public CommonFunctions() {
		mobileFunctions = new MobileFunctions();
	}

	public void verifyLabelText(By label, String labelName, String expText) {
		String actText = mobileFunctions.getText(label).trim().replace("\n", "");
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
			By errorMsgs = MobileBy.xpath(
					"(//*[contains(@resource-id,'Error')])[2]|//*[contains(@resource-id,'Error')]|//*[contains(@resource-id,'TV')]");
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
			// clickEnter();
			String actualtext = mobileFunctions.getText(ele).replace(" ", "").replace("/", "").replace("(", "")
					.replace(")", "").replace("-", "");
			System.out.println("length " + actualtext.length());
			By errorMsgs = MobileBy.xpath("(//*[contains(@resource-id,'Error')])[2]");
			if (enterText.equalsIgnoreCase(actualtext)) {
				ExtentTestManager
						.setPassMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
			} else {

				ExtentTestManager
						.setFailMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate field is failed due to exception " + e);

		}
		// && mobileFunctions.getElementList(errorMsgs, "errorMsg").size() == 0

	}

	public void validateFieldMaxichar(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			// clickEnter();
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

				ExtentTestManager.setFailMessageInReport(eleName + " is not accepting alphabets");
			} else {

				ExtentTestManager.setPassMessageInReport(eleName + " is accepting alphabets");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateFieldWithalphabet is failed due to exception " + e);
		}
	}

	public void validateFieldWithNotAcceptAlphabet(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager.setInfoMessageInReport("trying to enter alphabets in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = mobileFunctions.getText(ele);
			if (actualtext.length() == 0) {

				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting alphabets");
			} else {

				ExtentTestManager.setFailMessageInReport(eleName + " is accepting alphabets");
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

				ExtentTestManager.setFailMessageInReport(eleName + " is not accepting Numbers");
			} else {

				ExtentTestManager.setPassMessageInReport(eleName + " is accepting Numbers");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateFieldWithNumber is failed due to exception " + e);
		}
	}

	public void validateFieldWithNotAcceptNumber(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager.setInfoMessageInReport("trying to enter Numbers in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = mobileFunctions.getText(ele);
			if (actualtext.length() == 0) {

				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Numbers");
			} else {

				ExtentTestManager.setFailMessageInReport(eleName + " is accepting Numbers");
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

				ExtentTestManager.setFailMessageInReport(eleName + " is not accepting Special characters");
			} else {

				ExtentTestManager.setPassMessageInReport(eleName + " is accepting Special characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateFieldWithSpecialchar is failed due to exception " + e);
		}
	}

	public void validateFieldWithNotAcceptSpecialchar(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager.setInfoMessageInReport("trying to enter Special characters in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = mobileFunctions.getText(ele);
			if (actualtext.length() == 0) {

				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Special characters");
			} else {

				ExtentTestManager.setFailMessageInReport(eleName + " is accepting Special characters");
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
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
		System.out.println("clicked on enter");
	}

	public void clickTab() {
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.TAB));
		System.out.println("clicked on tab");
	}

	public void enterSpecialKey(String specialKey) {
		// AT: @, LEFT_BRACKET : ( and so on
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.valueOf(specialKey)));
	}

	public void enterKeys(By ele, By inputPlace, String data, String type, String eleName) throws InterruptedException {
		mobileFunctions.click(ele, "Field");
		String[] keys = data.split("");
		if (type.equalsIgnoreCase("alphanumeric")) {
			// takes numbers from alpha numeric keyboard
			for (String key : keys) {
				((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + key)));
				String actualtext = mobileFunctions.getText(inputPlace);// BUTTON_
				// Thread.sleep(2000);
				ExtentTestManager.setPassMessageInReport(actualtext);
				if (actualtext.length() == 0) {
					ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Numbers");
				} else {
					ExtentTestManager.setFailMessageInReport(eleName + " is accepting Numbers");
				}
			}
		} else if (type.equalsIgnoreCase("numeric")) {
			// takes numbers from numeric keyboard
			for (String key : keys) {
				((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.valueOf("NUMPAD_" + key)));
				String actualtext = mobileFunctions.getText(ele);
				if (actualtext.length() == 0) {
					ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Numbers");
				} else {
					ExtentTestManager.setFailMessageInReport(eleName + " is accepting Numbers");
				}
			}
		} else if (type.equalsIgnoreCase("alpha")) {
			// takes alphabets from alpha numeric keyboard
			for (String key : keys) {
				if (key.matches("/[A-Z]+/")) {
					((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.SHIFT_LEFT));
					((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.valueOf(key)));
				} else {
					((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.valueOf(key)));
				}
				String actualtext = mobileFunctions.getText(ele);
				if (actualtext.length() == 0) {
					ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Alphabets");
				} else {
					ExtentTestManager.setFailMessageInReport(eleName + " is accepting Alphabets");
				}

			}
		} else {
			ExtentTestManager.setFailMessageInReport(
					"type argument value should be either 'alphanumeric' or 'numeric' or 'alpha'");
		}
	}

	public void swipeElement(By loc, Direction dir) {
		System.out.println("swipeElementAndroid(): dir: '" + dir + "'");

		// Animation default time:
		// - Android: 300 ms
		// - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // m

		final int PRESS_TIME = 200; // ms

		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		WebElement element = mobileFunctions.getElement(loc, "eleName");
		Rectangle rect = element.getRect();
		// sometimes it is needed to configure edgeBorders
		// you can also improve borders to have vertical/horizontal
		// or left/right/up/down border variables
		edgeBorder = 0;

		switch (dir) {
		case DOWN: // from up to down
			pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
			break;
		case UP: // from down to up
			pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
			break;
		case LEFT: // from right to left
			pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			break;
		case RIGHT: // from left to right
			pointOptionStart = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + rect.width - 10 * edgeBorder, rect.y + rect.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
		}
		ExtentTestManager.setInfoMessageInReport("Swipe Action Completed on element Slide to Confirm");
		// execute swipe using TouchAction
		try {
			new TouchAction(DriverFactory.getDriver()).press(pointOptionStart)
					// a bit more reliable when we add small wait
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();
		} catch (Exception e) {
			System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}

	public void elementEnabled(By ele, String eleName) {
		if (mobileFunctions.getElement(ele, eleName).isEnabled()) {
			ExtentTestManager.setPassMessageInReport(eleName + " is enabled");
		} else {
			ExtentTestManager.setInfoMessageInReport(eleName + " is not enabled");
		}
	}

	public void selectState(String state) throws InterruptedException {

		By drpDwnState = MobileBy.xpath("//*[contains(@resource-id,'etState')]|//*[contains(@resource-id,'stateET')]");
		By txtState = MobileBy.xpath("//*[contains(@resource-id,'searchET')]|//*[contains(@resource-id,'stateET')]");
		By btnConfirmState = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");

		DriverFactory.getDriver().hideKeyboard();
		mobileFunctions.click(drpDwnState, "State Drop down");
		mobileFunctions.enterText(txtState, state, "State");
		Thread.sleep(2000);
		new CommonFunctions().clickEnter();
		// click(MobileBy.xpath(String.format("//*[@text='%s']", state)), "state");
		new CommonFunctions().clickEnter();
		mobileFunctions.click(btnConfirmState, "Done");
	}

	public String getTextBoxValue(By ele) {
		return mobileFunctions.getAttribute(ele, "text");
	}
}