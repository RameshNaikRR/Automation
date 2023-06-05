package coyni_mobile.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import coyni_mobile.pages.SignUpPage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import ilabs.mobile.utilities.FileReaderManager;
import io.appium.java_client.MobileBy;

public class CommonFunctions {

	MobileFunctions mobileFunctions;
	private String actualtext;

	public CommonFunctions() {
		mobileFunctions = new MobileFunctions();
	}

	public void verifyLabelText(By label, String labelName, String expText) {
		String actText = mobileFunctions.getText(label).trim().replace("\n", "");
		System.out.println(actText+"\n"+expText);
		
		if (expText.equals(actText)) {
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
			mobileFunctions.scrollUpToElement(errorMsgs, "error message");
			String msg = mobileFunctions.getText(errorMsgs).split(",")[1];
			String actualMsg = msg.trim();
			System.out.println(actualMsg);
			System.out.println(expErrMsg);
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
	public By getElement(String errMessage) {
		return MobileBy.xpath(String.format("//*[@name='%s']", errMessage));
	}
	
	public void validateFormErrMsg(String errMessage, String elementName) {
		String actualText = mobileFunctions.getText(getElement(errMessage)).trim();
		if (actualText.equals(errMessage)) {
			ExtentTestManager.setPassMessageInReport("Error message '" + errMessage + "' displayed for " + elementName);
		} else {
			ExtentTestManager
					.setFailMessageInReport("Error message '" + errMessage + "' not displayed for " + elementName);
		}
	}
	
	public void validateErrMsg(String errMessage) {
//	clearText(getElement(errMessage), errMessage);
		List<WebElement> errorMsgEles = mobileFunctions.getElementList(getElement(errMessage), errMessage);
		if (errorMsgEles.size() >= 1) {
			ExtentTestManager.setPassMessageInReport("Error message " + errMessage );
		} else {
			ExtentTestManager
					.setFailMessageInReport("Error message failed " + errMessage );
		}
	}

//	public void validateFormErrorMessage(String expErrMsg, String elementName) {
//		try {
//			By errorMsgs = MobileBy.xpath("(//*[contains(@resource-id,'Error')])[2]");
//			mobileFunctions.waitForVisibility(errorMsgs);
//			// mobileFunctions.
//			boolean status = mobileFunctions.getElementList(errorMsgs, "error Message").stream()
//					.map(ele -> ele.getText().toLowerCase()).anyMatch(msg -> msg.contains(expErrMsg.toLowerCase()));
//			if (status) {
//				ExtentTestManager
//						.setPassMessageInReport("Error message '" + expErrMsg + "' displayed for " + elementName);
//			} else {
//				ExtentTestManager
//						.setFailMessageInReport("Error message '" + expErrMsg + "' not displayed for " + elementName);
//			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("validate form error message failed due to exception " + e);
//		}
//	}

	public void clearText(By ele, String eleName) {
		try {
			mobileFunctions.getElement(ele, eleName).clear();
			ExtentTestManager.setPassMessageInReport("Text field " + eleName + " is cleared");
		} catch (Exception e) {
			ExtentTestManager.setPassMessageInReport("Text field " + eleName + " is not cleared");
		}
	}

	public void clear(By ele) {
		mobileFunctions.getElement(ele, "ele").clear();
	}
	public void validateField(By ele, String eleName, String enterText) {
		try {
     		clearText(ele, eleName);
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
			mobileFunctions.click(ele, eleName);
    	//	mobileFunctions.getElement(ele, eleName).clear();
		//	DriverFactory.getDriver().findElement(ele).clear();
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = getTextBoxValue(ele).replace("/", "").replace("-", "")
					.replace("(", "").replace(")", "").replace(" ", "");
			
		//	System.out.println("length " + actualtext.length());
			By errorMsgs = MobileBy.xpath(String.format("//*[contains(@label,'%s,')]", eleName));
//			new SignUpPage().clickDone();
			Thread.sleep(2000);
			if (enterText.equalsIgnoreCase(actualtext)&& mobileFunctions.getElementList(errorMsgs, "errorMsg").size() == 0) {

				ExtentTestManager
						.setPassMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
			} else {

				ExtentTestManager
						.setFailMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate field is failed due to exception " + e);

		}

	}
	
	public void validatePasswordField(By ele, String eleName, String enterText) {
		try {
		//	clearText(ele, eleName);
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
		
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = getTextBoxValue(ele).trim().replace("/", "").replace("-", "")
					.replace("(", "").replace(")", "").replace(" ", "");
			ExtentTestManager
			.setInfoMessageInReport(actualtext);
//			System.out.println("length " + actualtext.length());
			if (enterText.equalsIgnoreCase(actualtext)
					) {

				ExtentTestManager
						.setPassMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
			} else {

				ExtentTestManager
						.setFailMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate field is failed due to exception " + e);

		}

	}

	public void validateFieldMaxichar(By ele, String eleName, String enterText) {
		try {
			clearText(ele, eleName);
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
		//	mobileFunctions.click(ele, eleName);
			mobileFunctions.enterText(ele, enterText, eleName);
			String actualtext = getTextBoxValue(ele).trim().replace("/", "").replace("-", "").replace(") ", "").replace(" ", "")
					.replace("(", "");
//			new SignUpPage().clickDone();
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
	
	public String getTextBoxValue(By ele) {
		return mobileFunctions.getAttribute(ele, "value");
	}

	public void validateTextFeild(By ele, String eleName, String enterText) {
		clearText(ele, eleName);
	//	System.out.println("test");
		mobileFunctions.click(ele, eleName);
		mobileFunctions.enterText(ele, enterText, eleName);
		if(mobileFunctions.getAttribute(ele, "value")!=null) {
		String actualtext = getTextBoxValue(ele).trim().replace("/", "").replace("-", "")
				.replace("(", "").replace(") ", "");
		}else {
			actualtext ="";
		}
	//	System.out.println("test");
		if (enterText.matches("[a-zA-z]*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter alphabets in " + eleName);
			if (!actualtext.equals(enterText)) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting  alphabets");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  alphabets");
			}
		} else if (enterText.matches("[0-9]*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter Numbers in " + eleName);
			if (!actualtext.equals(enterText)) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting  Numbers");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  Numbers");
			}
		} else if (enterText.matches("[^A-Za-z0-9]*") && !enterText.matches(".*\\s.*")) {
			System.out.println("test");
			ExtentTestManager.setInfoMessageInReport("trying to enter Special characters in " + eleName);
			if (!actualtext.equals(enterText)) {
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
//		else if(enterText.matches("^[a-zA-Z0-9_ ]*$")) {
//			System.out.println("test");
//			ExtentTestManager.setInfoMessageInReport("trying to enter spaces in " + eleName);
//			if(!actualtext.equals(enterText)) {
//				ExtentTestManager.setPassMessageInReport(eleName + "is not accepting spaces");
//			}else {
//				ExtentTestManager.setWarningMessageInReport(eleName + "is accepeting spaces");
//			}
//		}
	
	}
 public void clickDone() {
	 By btnDone = MobileBy.xpath("//*[@name='Title']/preceding-sibling::*[1]|//*[@name='Done']");
	 DriverFactory.getDriver().findElement(btnDone).click();
 }

 public void clickOutSideElement() {
     // DriverFactory.getDriver().findElement(By.xpath("//html")).click();
     Actions action = new Actions(DriverFactory.getDriver());
     action.moveByOffset(10, 10).click().build().perform();
     ExtentTestManager.setInfoMessageInReport("clicked outside");
 }
 
 
}