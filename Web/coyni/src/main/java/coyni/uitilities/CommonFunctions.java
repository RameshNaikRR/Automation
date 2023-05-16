package coyni.uitilities;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
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

}
