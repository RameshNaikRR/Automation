package coyni.uitilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

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

}
