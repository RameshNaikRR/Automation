package coyni.uitilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class CommonFunctions {

	BrowserFunctions objBrowserFunctions = new BrowserFunctions();

	public void verifyLabelText(By label, String labelName, String expText) {
		objBrowserFunctions.waitForCondition(e -> e.findElement(label).isDisplayed(), labelName + " is displayed");
		String actText = objBrowserFunctions.getText(label, labelName).trim().replace("\n", "").replace(",", "");
		if (expText.equalsIgnoreCase(actText)) {
			ExtentTestManager.setPassMessageInReport(String.format("%s is %s", labelName, actText));
		} else {
			ExtentTestManager.setWarningMessageInReport(
					String.format("%s ::</br>Expected =  %s</br>Actual = %s", labelName, expText, actText));
		}
	}

	public void verifyCursorAction(By ele, String eleName) {
		String text = objBrowserFunctions.getElement(ele, eleName).getCssValue("cursor");
		if (text.equalsIgnoreCase("pointer")) {
			ExtentTestManager.setPassMessageInReport("Hand symbol is displayed when mouse hover on " + eleName);
		} else {
			ExtentTestManager.setPassMessageInReport("Hand symbol is not displayed when mouse hover on " + eleName);
		}

	}

	public void verifyAutoFocus(By ele, String eleName) {
		WebElement webele = objBrowserFunctions.getElement(ele, eleName);
		if (webele.equals(DriverFactory.getDriver().switchTo().activeElement())) {
			ExtentTestManager.setPassMessageInReport(eleName + " is Auto Focused");
		} else {
			ExtentTestManager.setFailMessageInReport(eleName + " is not Auto Focused");
		}
	}

	public void validateFormErrorMessage(String expErrMsg, String expcolour, String elementName) {
		By errorMsgs = By
				.cssSelector("div[class *= 'FormField_error'],span[class *='verification_error'],span.text-crd5");// By.cssSelector("span.text-crd5
		// |
		// span.text-crd2");
		objBrowserFunctions.waitForElement(errorMsgs, BrowserFunctions.waittime, WaitForElement.presence);
		boolean status = objBrowserFunctions.getElementsList(errorMsgs, "error messages").stream()
				.map(ele -> ele.getText().toLowerCase()).anyMatch(msg -> msg.contains(expErrMsg.toLowerCase()));
		if (status) {
			ExtentTestManager
					.setPassMessageInReport("Error message '" + expErrMsg + "' displayed, for  " + elementName);
		} else {
			ExtentTestManager
					.setFailMessageInReport("Error message '" + expErrMsg + "' not displayed for " + elementName);
		}
		verifyTextBoxBorderColor(expcolour);
	}

	public void verifyTextBoxBorderColor(String expcolour) {
		By txterror = By.cssSelector("div[class *= 'FormField_error'],span[class *='verification_error']");
		Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
		String value = objBrowserFunctions.getElement(txterror, "error textField").getCssValue("border-color");
		ExtentTestManager.setInfoMessageInReport(value);

		if (value.equalsIgnoreCase(expcolour)) {
			ExtentTestManager.setPassMessageInReport("Text field border changed to red colour");
		} else {
			ExtentTestManager.setFailMessageInReport("Text field border not changed to red colour");
		}
	}

	public void validateTextFeild(By ele, String eleName, String enterText) {
		DriverFactory.getDriver().findElement(ele).clear();//
		objBrowserFunctions.enterText(ele, enterText, eleName);
//		String actualtext = objBrowserFunctions.getTextBoxValue(ele, eleName).trim();
		String actualtext = objBrowserFunctions.getTextBoxValue(ele, eleName).trim().replace("/", "").replace("-", "")
				.replace("(", "").replace(") ", "");
		if (enterText.matches("[a-zA-z]*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter alphabets in " + eleName);
			if (actualtext.length() == 0) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting  alphabets");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  alphabets");
			}
		} else if (enterText.matches("[0-9]*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter Numbers in " + eleName);
			if (actualtext.length() == 0) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting  Numbers");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  Numbers");
			}
		} else if (enterText.matches("[^A-Za-z0-9]*") && !enterText.matches(".*\\s.*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter Special characters in " + eleName);
			if (actualtext.length() == 0) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting  Special characters");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  Special characters");
			}
		} else if (enterText.matches(".*\\s.*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter spaces in " + eleName);
			System.out.println(actualtext);
			System.out.println(enterText);
			if (!actualtext.equals(enterText)) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Spaces");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  Spaces");
			}
		}
	}

	public void elementView(By ele, String eleName) {
		if (objBrowserFunctions.getElement(ele, eleName).isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(eleName + " is displayed ");
		} else {
			ExtentTestManager.setFailMessageInReport(eleName + " is not displayed ");
		}
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void verifyMouseHoverAction(By ele, String eleName, String backGround, String border) {
		Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
		String initialBackGroundColor = objBrowserFunctions.getElement(ele, eleName).getCssValue(backGround);
		String initialBorderColor = objBrowserFunctions.getElement(ele, eleName).getCssValue(border);
		ExtentTestManager.setInfoMessageInReport(initialBackGroundColor);
		ExtentTestManager.setInfoMessageInReport(initialBorderColor);
		objBrowserFunctions.moveToElement(ele, eleName);
		Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
		String finalBackGroundColor = objBrowserFunctions.getElement(ele, eleName).getCssValue(backGround);
		String finalBorderColor = objBrowserFunctions.getElement(ele, eleName).getCssValue(border);
		ExtentTestManager.setInfoMessageInReport(finalBackGroundColor);
		ExtentTestManager.setInfoMessageInReport(finalBorderColor);
		if (!initialBackGroundColor.equalsIgnoreCase(finalBackGroundColor)
				|| !initialBorderColor.equalsIgnoreCase(finalBorderColor)) {
			ExtentTestManager.setPassMessageInReport("Border color and Background color is changed");
		} else {
			ExtentTestManager.setFailMessageInReport("Border color and Background color is not changed");
		}
	}

}
