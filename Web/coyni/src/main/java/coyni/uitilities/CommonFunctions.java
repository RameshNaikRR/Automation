package coyni.uitilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

	public void verifyBordercolor(String expcolour, By color, String colorName) {
		objBrowserFunctions.moveToElement(color, "Moved to element");
		String cssValue = objBrowserFunctions.getElement(color, "locatin").getCssValue("border-color");
		ExtentTestManager.setInfoMessageInReport(cssValue);

		if (cssValue.equalsIgnoreCase(expcolour)) {
			ExtentTestManager.setPassMessageInReport("Text field border colour changed to " + colorName);
		} else {
			ExtentTestManager.setFailMessageInReport("Text field border colour is not changed");
		}
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
	
	public void verifyOTPBorderColor(String expcolour,String eleName) {	
		By txterror = By.cssSelector("input[class *='verification-input error ']");
		Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
		String value = objBrowserFunctions.getElement(txterror, "error textField").getCssValue("border-color");
		ExtentTestManager.setInfoMessageInReport(value);

		if (value.equalsIgnoreCase(expcolour)) {
			ExtentTestManager.setPassMessageInReport(eleName +" changed to red colour");
		} else {
			ExtentTestManager.setFailMessageInReport(" not changed to red colour");
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

	public void verifyTextUnderLine(By ele, String eleName) {
		String text = objBrowserFunctions.getElement(ele, eleName).getAttribute("class");
		if (text.contains("underline")) {
			ExtentTestManager.setPassMessageInReport(eleName + " text is underlined when mouse hover on it");
		} else {
			ExtentTestManager.setFailMessageInReport(eleName + " text is not underlined when mouse hover on it");
		}
	}

	public void validateFormErrorMessage(String expErrMsg) {
		By errorMsgs = By.cssSelector(".text-crd5");
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
		DriverFactory.getDriver().findElement(ele).clear();//
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
					.setInfoMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
		}

	}

	public void validateFieldMaxichar(By ele, String eleName, String enterText) {

		By errorMsgs = By.cssSelector("span.text-crd5");
		ExtentTestManager.setInfoMessageInReport("trying to enter " + enterText.length() + "characters  in " + eleName);
		DriverFactory.getDriver().findElement(ele).clear();//
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
		Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
		String FinalValue = objBrowserFunctions.getElement(ele, eleName).getCssValue(cssProp);
		System.out.println(initialValue + " : " + FinalValue);
		if (FinalValue.equalsIgnoreCase(expValue)) {
			ExtentTestManager.setPassMessageInReport(
					String.format("%s element %s css property value changed to ", eleName, cssProp) + "" + expColor);
		} else {
			ExtentTestManager.setWarningMessageInReport(
					String.format("%s element %s css property value not changed to ", eleName, cssProp) + ""
							+ expColor);
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

	public void verifyPreviousData(By ele, String eleName, String expText) {
		String actualText = objBrowserFunctions.getTextBoxValue(ele, eleName).trim().replace("/", "").replace("-", "")
				.replace("(", "").replace(") ", "");
		if (expText.equals(actualText)) {
			ExtentTestManager.setPassMessageInReport(eleName + " has previous data");
		} else {
			ExtentTestManager.setWarningMessageInReport("Previous data is mismatched for " + eleName);
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

	public String convertRgbaToHex(String a) {

		String replaceAll = a.replaceAll("[a-zA-Z]", "");
		int length = replaceAll.length();
		String substring = replaceAll.substring(1, length - 1);
		String str = substring.replaceAll("[ ]", "");
		String[] split = str.split(",");
		System.out.println(split);
		int R = Integer.parseInt(split[0]);
		int G = Integer.parseInt(split[1]);
		int B = Integer.parseInt(split[2]);

		String hex = String.format("#%02X%02X%02X", R, G, B);
		System.out.println(hex);
		return hex;
	}

	public void verifyPasswordMaskedView(By ele, String eleName) {
		String attributeValue = objBrowserFunctions.getElement(ele, eleName).getAttribute("type");
		if (attributeValue.contains("password")) {
			ExtentTestManager.setInfoMessageInReport("Password Masked with black circles");

		} else {
			ExtentTestManager.setInfoMessageInReport("Password Not masked with black circles");

		}
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}



	public void switchtoUrl(String url) throws InterruptedException {
		
		DriverFactory.getDriver().navigate().to(url);
		Thread.sleep(4000);

	}

	public void verifyHeadings(List<WebElement> elementsList, String excelHeading, String eleName) {
		for (WebElement webElement : elementsList) {
			String text = webElement.getText();
			String[] split = excelHeading.split("/");
			int count = 0;
			for (int i = 0; i < split.length; i++) {
				if (text.equalsIgnoreCase(split[i])) {
					ExtentTestManager.setPassMessageInReport(text + " Filter Data match");
					break;
				}

				else {
					count++;
					if (count == split.length) {
						ExtentTestManager.setWarningMessageInReport(text + " Filter Data Not Found");
					}
				}
			}

		}

	}

	public void verifyNewWindow(String url) {
		String parentWindowHandle = DriverFactory.getDriver().getWindowHandle();

		Set<String> allWindowHandles = DriverFactory.getDriver().getWindowHandles();
		Actions action = new Actions(DriverFactory.getDriver());

		// Iterate through each handle
		for (String handle : allWindowHandles) {
			// Switch to the new window
			if (!handle.equals(parentWindowHandle)) {
				DriverFactory.getDriver().switchTo().window(handle);
				action.keyDown(Keys.CONTROL).sendKeys(url).keyUp(Keys.CONTROL).build().perform();
				break;
			}
		}

	}

	public void swtichToNewtabUrl(String Url) {
		WebDriver driver = DriverFactory.getDriver();
		try {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open(Url)");
		ExtentTestManager.setPassMessageInReport(Url + "Url Launched");} 
		catch (Throwable e) {
		ExtentTestManager.setFailMessageInReport(e + "launching yopmail site is failed");}
	}
	
	public void scrollToHorizontal() {
		try {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("window.scrollBy(250,0)", "Scrolled Horizontally");
		ExtentTestManager.setPassMessageInReport("Scrolled Horizontally");
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("Not Scrolled Horizontally");
		}
	}

}
