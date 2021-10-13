package coyni.uitilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class CommonFunctions {

	BrowserFunctions objBrowserFunctions = new BrowserFunctions();
	
	public void verifyLabelText(By label, String labelName, String expText){
		String actText = objBrowserFunctions.getText(label, labelName).trim().replace("\n", "").replace(",", "");
		if (expText.equalsIgnoreCase(actText)){
			ExtentTestManager.setPassMessageInReport(String.format("%s is %s", labelName, actText));
		} else {
			ExtentTestManager.setFailMessageInReport(String.format("%s ::<p>Expected =  %s</br>Actual = %s</p>", labelName, expText, actText));
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

	
	
	
}
