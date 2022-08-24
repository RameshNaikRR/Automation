package coyni.merchant.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ReConfigturationTwoStepAuthenticationPage extends BrowserFunctions {

	private By inputBox = By.cssSelector("input[class*= 'verification-input']");

	private By btnManualEntry = By.xpath("//div[text()='Use Manual Entry']");

	public void clickManualEntry() {
		click(btnManualEntry, "Manual Entry");
	}

	public void fillpin(String code) {
		List<WebElement> inputs = getElementsList(inputBox, "input boxes");
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
			ExtentTestManager.setPassMessageInReport("verification entered in text field");
		}
	}

}
