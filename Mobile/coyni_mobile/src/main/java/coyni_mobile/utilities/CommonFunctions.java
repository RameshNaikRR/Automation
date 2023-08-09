package coyni_mobile.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import ilabs.mobile.utilities.FileReaderManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class CommonFunctions {

	MobileFunctions mobileFunctions;

	public CommonFunctions() {
		mobileFunctions = new MobileFunctions();
	}

	public void verifyLabelText(By label, String labelName, String expText) {
		String actText = mobileFunctions.getText(label).trim().replace("\n", "");
		if (expText.equalsIgnoreCase(actText)) {
//			System.out.println(actText);
//			System.out.println(expText);
			ExtentTestManager.setPassMessageInReport(String.format("%s is %s", labelName, actText));
		} else {
			ExtentTestManager.setWarningMessageInReport(
					String.format("%s ::<p>Expected =  %s</br>Actual = %s</p>", labelName, expText, actText));
		}
	}

	public void verifyLabelTextforEmailDescription(By label, String labelName, String expText1, String expText2) {
		String[] actText = mobileFunctions.getText(label).split(":");
		String actText1 = actText[0];
		String actText2 = actText[1].replace(" ", "");
		if (expText1.equals(actText1) && expText2.equals(actText2)) {
			ExtentTestManager.setPassMessageInReport(actText1 + ": " + actText2);
		} else {
			ExtentTestManager.setWarningMessageInReport("The Email Verification Description not as expected");

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

	public void clickEnabledElement(By ele, String eleName) {
		try {
			if (mobileFunctions.getElement(ele, eleName).isEnabled()) {
				ExtentTestManager.setPassMessageInReport(eleName + " button is enabled");
				mobileFunctions.click(ele, eleName);
			} else {
				ExtentTestManager.setFailMessageInReport(eleName + " button is not enabled");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("click Enabled Element  method is failed due to exception " + e);
		}

	}

	public void verifyAutoFocusElement(By ele, String eleName) {
		try {
			if (mobileFunctions.getAttribute(ele, "focused").equalsIgnoreCase("true")) {
				ExtentTestManager.setPassMessageInReport(eleName + " is auto focused");
			} else {
				ExtentTestManager.setFailMessageInReport(eleName + " is not auto focused");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("verifyAutoFocusElement method is failed due to exception " + e);
		}

	}

	public void clickFocusableElement(By ele, String eleName) {
		try {
			String a = mobileFunctions.getAttribute(ele, "focusable");
			if (mobileFunctions.getAttribute(ele, "focusable").equalsIgnoreCase("true")) {
				ExtentTestManager.setPassMessageInReport(eleName + " is enabled");
				mobileFunctions.click(ele, eleName);
			} else {
				ExtentTestManager.setFailMessageInReport(eleName + " is not enabled");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("clickFocusableElement method is failed due to exception " + e);
		}

	}

	// passwordInfoTV
	public void validateFormErrorMessage(String expErrMsg, String elementName) {
		try {
			By errorMsgs = MobileBy.xpath(
					"//*[contains(@resource-id,'tvPasswordInfo')]|//*[contains(@resource-id,'passwordInfoTV')]|(//*[contains(@resource-id,'Error')])[2]|//*[contains(@resource-id,'Error')]");
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

	public void validateErrMsg(String errMesg) throws InterruptedException {

		//     clearText(getElement(errMessage), errMessage);
		List<WebElement> errorMsgEles = mobileFunctions.getElementList(getElement(errMesg), errMesg);
		if (errorMsgEles.size() >= 1) {
			Thread.sleep(2000);
			ExtentTestManager.setPassMessageInReport("Error message " + errMesg);
		} else {
			ExtentTestManager.setFailMessageInReport("Error message failed " + errMesg);
		}
	}

	private By getElement(String errMesg) {
		// TODO Auto-generated method stub
		return MobileBy.xpath(String.format("//*[contains(@resource-id,'tvError')]", errMesg));
	}

	public void clearText(By ele, String eleName) {
		try {
			mobileFunctions.getElement(ele, eleName).clear();
//			if(mobileFunctions.getText(ele).length()==0||mobileFunctions.getText(ele).equalsIgnoreCase("Name")) {
//				ExtentTestManager.setPassMessageInReport("Search option is clearing the text");
//			}else {
//				ExtentTestManager.setFailMessageInReport("Search option is not clearing the text");	
//			}
		} catch (Exception e) {
			ExtentTestManager.setPassMessageInReport("clearText is failed due to exception " + e);
		}
	}

	public void validateField(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			// clickEnter();
			String actualtext = mobileFunctions.getText(ele).replace(" ", "").replace("(", "").replace(")", "")
					.replace("-", "");
			System.out.println("length " + actualtext.length());
//			By errorMsgs = MobileBy
//					.xpath("(//*[contains(@resource-id,'Error')])[2]|//*[contains(@resource-id,'tvPasswordInfo')]");
//			&& DriverFactory.getDriver().findElements(errorMsgs).size() == 0
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

	public void validateFieldWithErrorMsg(By ele, String eleName, String enterText) {
		try {
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			// clickEnter();
			String actualtext = mobileFunctions.getText(ele).replace(" ", "").replace("/", "").replace("(", "")
					.replace(")", "").replace("-", "");
			System.out.println("length " + actualtext.length());
			By errorMsgs = MobileBy
					.xpath("//*[contains(@resource-id,'tvPasswordInfo')]|//*[contains(@resource-id,'passwordInfoTV')]");
			if (enterText.equalsIgnoreCase(actualtext)
					&& mobileFunctions.getElement(errorMsgs, "Error Msg").isDisplayed()) {
				ExtentTestManager.setPassMessageInReport(
						eleName + " it is showing error Message " + mobileFunctions.getText(errorMsgs));
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
						.setFailMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateFieldMaxichar is failed due to exception " + e);
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

	public void enterSpecialKey(By ele, String eleName) {
		mobileFunctions.click(ele, "Field");
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.AT));
		ExtentTestManager.setPassMessageInReport("@,(-+ text entered in element " + eleName);
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.COMMA));
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.LEFT_BRACKET));
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.MINUS));
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.PLUS));
//		ExtentTestManager.setPassMessageInReport(mobileFunctions.getText(ele));
		String actualtext = mobileFunctions.getText(ele).replace("First Name", "").replace("Last Name", "")
				.replace("Name on Card", "").replace("Card Number", "").replace("Expiry Date", "")
				.replace("CVV/CVC", "").replace("0.00", "").replace(")", "").replace("-", "");
		if (actualtext.length() == 0 || actualtext.equals("First Name") || actualtext.equals("Last Name")) {
			ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Special Charcters");
		} else {
			ExtentTestManager.setFailMessageInReport(eleName + " is accepting Special Charcters");
		}
//		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.SPACE));
	}

	public void enterKeys(By ele, String data, String type, String eleName) throws InterruptedException {
		mobileFunctions.click(ele, "Field");
		String[] keys = data.split("");
		if (type.equalsIgnoreCase("alphanumeric")) {
			// takes numbers from alpha numeric keyboard
			for (String key : keys) {
				((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + key)));
				ExtentTestManager.setPassMessageInReport(key + " text entered in element " + eleName);
				String actualtext = mobileFunctions.getText(ele);// BUTTON_
				// Thread.sleep(2000);
				if (actualtext.length() == 0 || actualtext.equals("First Name") || actualtext.equals("Last Name")
						|| actualtext.equals("Name on Card")) {
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
			ExtentTestManager.setFailMessageInReport(eleName + " is not enabled");
		}
	}

	public void verifyDisabledElement(By ele, String eleName) {
		if (!mobileFunctions.getElement(ele, eleName).isEnabled()) {
			ExtentTestManager.setPassMessageInReport(eleName + " is disabled");
		} else {
			ExtentTestManager.setFailMessageInReport(eleName + " is not disabled");
		}
	}

	public void verifyNonFocusableElement(By ele, String eleName) {
		String a = mobileFunctions.getAttribute(ele, "focusable");
		ExtentTestManager.setPassMessageInReport(a);
		if (!mobileFunctions.getAttribute(ele, "focusable").equalsIgnoreCase("true")) {
			ExtentTestManager.setPassMessageInReport(eleName + " is disabled");
		} else {
			ExtentTestManager.setFailMessageInReport(eleName + " is not disabled");
		}
	}

	public void verifyKeyBoardType(By ele, String data, String type, String eleName) throws InterruptedException {
		mobileFunctions.click(ele, "Field");
		String[] keys = data.split("");
		if (type.equalsIgnoreCase("alphanumeric")) {
			// takes numbers from alpha numeric keyboard
			for (String key : keys) {
				((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + key)));
				ExtentTestManager.setPassMessageInReport(key + " text entered in element " + eleName);
				String actualtext = mobileFunctions.getText(ele);
				if (actualtext.length() == 0) {
					ExtentTestManager.setPassMessageInReport("Aplha Numeric Key Board is opened for " + eleName);
				} else {
					ExtentTestManager.setFailMessageInReport("Aplha Numeric Key Board is not opened for " + eleName);
				}
			}
		} else if (type.equalsIgnoreCase("numeric")) {
			// takes numbers from numeric keyboard
			for (String key : keys) {
				((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.valueOf("NUMPAD_" + key)));
				String actualtext = mobileFunctions.getText(ele);
				if (actualtext.length() == 0) {
					ExtentTestManager.setPassMessageInReport("Numeric Key Board is opened for " + eleName);
				} else {
					ExtentTestManager.setFailMessageInReport("Numeric Key Board is not opened for " + eleName);
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
					ExtentTestManager.setPassMessageInReport("Aplhabetical Key Board is opened for " + eleName);
				} else {
					ExtentTestManager.setFailMessageInReport("Aplhabetical Key Board is not opened for " + eleName);
				}

			}
		} else {
			ExtentTestManager.setFailMessageInReport(
					"type argument value should be either 'alphanumeric' or 'numeric' or 'alpha'");
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

	public void VerifySearchWithPasteOption(By ele) {
		TouchAction action = new TouchAction(DriverFactory.getDriver());
		MobileElement search = (MobileElement) DriverFactory.getDriver().findElement(ele);
		Duration duration = Duration.ofMillis(1000);
		action.longPress(
				LongPressOptions.longPressOptions().withElement(ElementOption.element(search)).withDuration(duration))
				.release().perform();
		String copiedData = mobileFunctions.getCopiedData();
		mobileFunctions.enterText(ele, copiedData, "Search");
//		action.tap(PointOption.point(120, 350)).perform();
//		mobileFunctions.getCopiedData();
	}

	public String getTextBoxValue(By ele) {
		return mobileFunctions.getAttribute(ele, "text");
	}

	public void clickBack() {
		((AndroidDriver) DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
		System.out.println("clicked on Back");
	}

	public void validateDynamicTextMessage(String eleName) {
		By errorMsgs = MobileBy.xpath(
				"//*[contains(@resource-id,'tvPasswordInfo')]|//*[contains(@resource-id,'passwordInfoTV')]|(//*[contains(@resource-id,'Error')])[2]|//*[contains(@resource-id,'Error')]");
		if ((mobileFunctions.getText(errorMsgs).contains("The minimum is ")
				&& mobileFunctions.getText(errorMsgs).contains(" CYN"))
				|| ((mobileFunctions.getText(errorMsgs).contains("Minimum Amount is ")
						&& mobileFunctions.getText(errorMsgs).contains(" CYN")))) {
			ExtentTestManager
					.setPassMessageInReport(mobileFunctions.getText(errorMsgs) + " is displayed for " + eleName);
		} else {
			ExtentTestManager
					.setFailMessageInReport(mobileFunctions.getText(errorMsgs) + " is not displayed for " + eleName);
		}
	}
}