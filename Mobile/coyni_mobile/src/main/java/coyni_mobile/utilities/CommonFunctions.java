package coyni_mobile.utilities;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

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
			ExtentTestManager.setFailMessageInReport(
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

	public void validateFormErrorMessage(String expErrMsg) {
		try {
			By errorMsgs = MobileBy.xpath("");
			mobileFunctions.waitForVisibility(errorMsgs);
			boolean status = mobileFunctions.getElementList(errorMsgs, "error Message").stream()
					.map(ele -> ele.getText().toLowerCase()).anyMatch(msg -> msg.contains(expErrMsg.toLowerCase()));
			if (status) {
				ExtentTestManager.setPassMessageInReport("Error message '" + expErrMsg + "' displayed");
			} else {
				ExtentTestManager.setFailMessageInReport("Error message '" + expErrMsg + "' not displayed");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate form error message failed due to exception " + e);
		}
	}

}