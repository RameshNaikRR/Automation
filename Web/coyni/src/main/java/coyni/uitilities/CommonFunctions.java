package coyni.uitilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
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
			ExtentTestManager.setFailMessageInReport(
					String.format("%s ::<p>Expected =  %s</br>Actual = %s</p>", labelName, expText, actText));
		}
	}

	public void selectCustomDropDown(String option, String eleName) {
		try {
			By options = By.cssSelector("");
			boolean status = false;
			objBrowserFunctions.waitForElement(options, BrowserFunctions.waittime, WaitForElement.presence);
			List<WebElement> optionsEles = objBrowserFunctions.getElementsList(options, "options");
			for (WebElement optionEle : optionsEles) {
				if (optionEle.getText().equalsIgnoreCase(option)) {
					optionEle.click();
					status = true;
					break;
				}
			}
			if (status) {
				ExtentTestManager.setInfoMessageInReport(option + " selected from " + eleName + " drop down");
			} else {
				ExtentTestManager.setFailMessageInReport(option + " not available in " + eleName + " dropdown");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("select custom drop down failed due to exception " + e);
		}
	}

	public void validateFormErrorMessage(String expErrMsg, String expcolour) {
		try {
			By errorMsgs = By.cssSelector("span.text-crd5");
			objBrowserFunctions.waitForElement(errorMsgs, BrowserFunctions.waittime, WaitForElement.presence);
			boolean status = objBrowserFunctions.getElementsList(errorMsgs, "error messages").stream()
					.map(ele -> ele.getText().toLowerCase()).anyMatch(msg -> msg.contains(expErrMsg.toLowerCase()));
			if (status) {
				ExtentTestManager.setPassMessageInReport("Error message '" + expErrMsg + "' displayed");
			} else {
				ExtentTestManager.setFailMessageInReport("Error message '" + expErrMsg + "' not displayed");
			}
			getcssValue(expcolour);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate form error message failed due to exception " + e);
		}
	}

	public void validateTextfieldIcon(String message) {
		try {
			By passFailImg = By.cssSelector(".business-login-inner-icon");
			String imgClass = objBrowserFunctions.getAttributeValue(passFailImg, "class", "Imgclass");
			message = message.toLowerCase();
			if (imgClass.contains(message)) {
				ExtentTestManager.setPassMessageInReport(message + " icon is displayed ");
			} else {
				ExtentTestManager.setFailMessageInReport(message + " icon is not  displayed ");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate text field icon failed due to exception " + e);
		}
	}

	public void getcssValue(String expcolour) {
		try {
			By txterror = By.cssSelector("div[class *= 'FormField_error']");
			String value = objBrowserFunctions.getElement(txterror, "error textField").getCssValue("border-color");
			ExtentTestManager.setInfoMessageInReport(value);

			if (value.equalsIgnoreCase(expcolour)) {
				ExtentTestManager.setPassMessageInReport("Text field border changed to red colour");
			} else {
				ExtentTestManager.setFailMessageInReport("Text field border not changed to red colour");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("getcssValue failed due to exception " + e);
		}

	}

	public void elementView(By ele, String eleName) {
		try {
			if (objBrowserFunctions.getElement(ele, eleName).isDisplayed()) {
				ExtentTestManager.setPassMessageInReport(eleName + " is displayed ");
			} else {
				ExtentTestManager.setFailMessageInReport(eleName + " is not displayed ");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" element View failed due to exception " + e);
		}

	}

	public void verifyMouseHoverAction(By ele, String eleName, String backGround, String border) {
		try {
			Thread.sleep(2000);
			String initialBackGroundColor = objBrowserFunctions.getElement(ele, eleName).getCssValue(backGround);
			String initialBorderColor = objBrowserFunctions.getElement(ele, eleName).getCssValue(border);
			ExtentTestManager.setInfoMessageInReport(initialBackGroundColor);
			ExtentTestManager.setInfoMessageInReport(initialBorderColor);
			objBrowserFunctions.moveToElement(ele, eleName);
			Thread.sleep(2000);
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
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" verify mouse hover action test failed due to exception " + e);
		}
	}

	public void verifyCursorAction(By ele, String eleName) {

		try {
			String text = objBrowserFunctions.getElement(ele, eleName).getCssValue("cursor");
			if (text.equalsIgnoreCase("pointer")) {
				ExtentTestManager.setPassMessageInReport("Hand symbol is displayed when mouse hover on " + eleName);
			}
			else {
				ExtentTestManager.setPassMessageInReport("Hand symbol is not displayed when mouse hover on " + eleName);
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" verify mouse hover action test failed due to exception " + e);
		}

	}
}
