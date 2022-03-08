package coyni.uitilities;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.util.concurrent.Uninterruptibles;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.Navigation;
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

	public void verifyLabelTextContains(By label, String labelName, String expText) {
		objBrowserFunctions.waitForCondition(e -> e.findElement(label).isDisplayed(), labelName + " is displayed");
		String actText = objBrowserFunctions.getText(label, labelName).trim().replace("\n", "").replace(",", "");
		if (expText.contains(actText)) {
			ExtentTestManager.setPassMessageInReport(String.format("%s is %s", labelName, actText));
		} else {
			ExtentTestManager.setWarningMessageInReport(
					String.format("%s ::<p>Expected =  %s</br>Actual = %s</p>", labelName, expText, actText));
		}
	}

	public void selectCustomDropDown(String option, String eleName) {
		try {
			By options = By.xpath(
					"//div[contains(@class, 'StateForm_options_wrap__22oMi') or contains(@class, 'FormField_options')]/div");
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

	public void validateFormErrorMessage(String expErrMsg, String expcolour, String elementName) {
		By errorMsgs = By.cssSelector("span.text-crd5");
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

	public void validateTextfieldIcon(String message) {
		By passFailImg = By.cssSelector(".business-login-inner-icon");
		String imgClass = objBrowserFunctions.getAttributeValue(passFailImg, "class", "Imgclass");
		message = message.toLowerCase();
		if (imgClass.contains(message)) {
			ExtentTestManager.setPassMessageInReport(message + " icon is displayed ");
		} else {
			ExtentTestManager.setFailMessageInReport(message + " icon is not  displayed ");
		}
	}

	public void verifyTextBoxBorderColor(String expcolour) {
		By txterror = By.cssSelector("div[class *= 'FormField_error']");
		String value = objBrowserFunctions.getElement(txterror, "error textField").getCssValue("border-color");
		ExtentTestManager.setInfoMessageInReport(value);

		if (value.equalsIgnoreCase(expcolour)) {
			ExtentTestManager.setPassMessageInReport("Text field border changed to red colour");
		} else {
			ExtentTestManager.setFailMessageInReport("Text field border not changed to red colour");
		}
	}

	public void elementView(By ele, String eleName) {
		if (objBrowserFunctions.getElement(ele, eleName).isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(eleName + " is displayed ");
		} else {
			ExtentTestManager.setFailMessageInReport(eleName + " is not displayed ");
		}
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

	public void verifyCursorAction(By ele, String eleName) {
		String text = objBrowserFunctions.getElement(ele, eleName).getCssValue("cursor");
		if (text.equalsIgnoreCase("pointer")) {
			ExtentTestManager.setPassMessageInReport("Hand symbol is displayed when mouse hover on " + eleName);
		} else {
			ExtentTestManager.setPassMessageInReport("Hand symbol is not displayed when mouse hover on " + eleName);
		}
	}

	public void validateFormErrorMessage(String expErrMsg) {
		By errorMsgs = By.cssSelector("span.text-crd5");
		objBrowserFunctions.waitForElement(errorMsgs, BrowserFunctions.waittime, WaitForElement.presence);
		boolean status = objBrowserFunctions.getElementsList(errorMsgs, "error messages").stream()
				.map(ele -> ele.getText().toLowerCase()).anyMatch(msg -> msg.contains(expErrMsg.toLowerCase()));
		if (status) {
			ExtentTestManager.setPassMessageInReport("Error message '" + expErrMsg + "' displayed");
		} else {
			ExtentTestManager.setFailMessageInReport("Error message '" + expErrMsg + "' not displayed");
		}
	}

	public void clearText(By ele, String eleName) {
		// WebElement eleAddress = objBrowserFunctions.getElement(ele, eleName);
		// objBrowserFunctions.executeJavaScript("arguments[0].value = ''", eleAddress);
		DriverFactory.getDriver().findElement(ele).clear();
		objBrowserFunctions.getElement(ele, eleName).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		ExtentTestManager.setPassMessageInReport("Text field " + eleName + " is cleared");
	}

	public void clickOutSideElement() {
		// DriverFactory.getDriver().findElement(By.xpath("//html")).click();
		Actions action = new Actions(DriverFactory.getDriver());
		action.moveByOffset(10, 10).click().build().perform();
		ExtentTestManager.setInfoMessageInReport("clicked outside");
	}

	public void validateField(By ele, String eleName, String enterText) {
		ExtentTestManager.setInfoMessageInReport("trying to enter " + enterText.length() + "characters in " + eleName);
		objBrowserFunctions.enterText(ele, enterText, eleName);
		String actualtext = objBrowserFunctions.getTextBoxValue(ele, eleName).replace(" ", "").replace("/", "")
				.replace("-", "").replace("(", "").replace(")", "");
		System.out.println("length " + actualtext.length());

		clickOutSideElement();

		By errorMsgs = By.cssSelector("span.text-crd5");
		if (enterText.equalsIgnoreCase(actualtext)
				&& objBrowserFunctions.getElementsList(errorMsgs, "error messages").size() == 0) {

			ExtentTestManager.setPassMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
		} else {

			ExtentTestManager
					.setFailMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
		}

	}

	public void validateFieldMaxichar(By ele, String eleName, String enterText) {

		By errorMsgs = By.cssSelector("span.text-crd5");
		ExtentTestManager.setInfoMessageInReport("trying to enter " + enterText.length() + "characters  in " + eleName);
		objBrowserFunctions.enterText(ele, enterText, eleName);
		String actualtext = objBrowserFunctions.getTextBoxValue(ele, eleName).replace(" ", "").replace("/", "")
				.replace("-", "").replace("(", "").replace(")", "");
		if (!enterText.equalsIgnoreCase(actualtext)
				&& objBrowserFunctions.getElementsList(errorMsgs, "error messages").size() == 0) {
			ExtentTestManager
					.setPassMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
		} else {
			ExtentTestManager.setInfoMessageInReport(eleName + " is  accepting " + enterText.length() + " characters");
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

	public void verifyChangedColor(By ele, String eleName, String cssProp, String expValue, String expColor) {

		String initialValue = objBrowserFunctions.getElement(ele, eleName).getCssValue(cssProp);
		objBrowserFunctions.moveToElement(ele, eleName);
		Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
		String FinalValue = objBrowserFunctions.getElement(ele, eleName).getCssValue(cssProp);
		System.out.println(initialValue + " : " + FinalValue);
		if (FinalValue.equalsIgnoreCase(expValue)) {
			ExtentTestManager.setPassMessageInReport(
					String.format("%s css property value changed to ", cssProp) + "" + expColor);
		} else {
			ExtentTestManager.setFailMessageInReport(
					String.format("%s css property value is not changed to ", cssProp) + "" + expColor);
		}

	}

	public void validateTextFeild(By ele, String eleName, String enterText) {
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
	public void verifyPreviousData(By ele,String eleName,String expText) {
		String actualText = objBrowserFunctions.getTextBoxValue(ele, eleName).trim().replace("/", "").replace("-", "")
				.replace("(", "").replace(") ", "");
		if(expText.equals(actualText)) {
			ExtentTestManager.setPassMessageInReport(eleName+" has previous data");
		}else {
			ExtentTestManager.setWarningMessageInReport("Previous data is mismatched for "+eleName);
		}
	}
	public void Refresh() {
		objBrowserFunctions.navigate(Navigation.REFRESH);
		}
	public void switchTodWindow() {
		String mainWindow = DriverFactory.getDriver().getWindowHandle();
		Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
			for (String string : windowHandles) {
				if (!string.equals(mainWindow)) {
					DriverFactory.getDriver().switchTo().window(string);
					ExtentTestManager.setPassMessageInReport("Switched to Window");
					break;
				}
			}

		}
	public void verifyPasswordMaskedView(By ele,String eleName) {
		String attributeValue = objBrowserFunctions.getElement(ele, eleName).getAttribute("type");
		if (attributeValue.contains("password")) {
			ExtentTestManager.setInfoMessageInReport("Password Masked with black circles");
			
		}else {
			ExtentTestManager.setInfoMessageInReport("Password Not masked with black circles");
			
		}
	}

	
	
}
