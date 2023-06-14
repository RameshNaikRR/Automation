package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.AddCardComponent;
import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class cvvPopup extends MobileFunctions {

//	private By heading = MobileBy.xpath("//*[@text='Please confirm CVV to continue']|//*[contains(@name,'confirm')]");
	private By heading = MobileBy.AccessibilityId("Please confirm CVV/CVC to continue");
//	private By txtCvv = MobileBy.xpath("//*[contains(@name,'CVV/CVC')]");
	private By txtCvv = MobileBy.AccessibilityId("CVV/CVC Text Field");
	private By btnOk = MobileBy
			.xpath("//*[@name='OK']/preceding-sibling::*[1]|//*[contains(@resource-id,'keyActionTV')]");

	public void verifyPopupHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Popup heading", expHeading);
	}

	public void fillCvv(String cvv) {
		new ChoosePinComponent().fillPins(cvv);
	}

	
	public void validateCVVorCVC(String textField) {
		String[] field = textField.split(",");
	//	for (int i = 0; i < 2; i++) {
			validateCvvField(txtCvv, "CVV/CVC", field[0]);
			validateCvvField(txtCvv, "CVV/CVC", field[1]);
		new CommonFunctions().validateFieldMaxichar(txtCvv, "CVV/CVC", field[2]);
	}

	public void validateCvvField(By ele, String eleName, String enterText) {
		ExtentTestManager.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
		enterText(ele, enterText, eleName);
		String actualtext = new CommonFunctions().getTextBoxValue(ele).trim();
		System.out.println(actualtext);
		By errorMsgs = MobileBy.xpath(String.format("//*[contains(@label,'%s,')]", eleName));
	//	new SignUpPage().clickDone();
		if (getElementList(errorMsgs, "errorMsg").size() == 0 && actualtext.length() == enterText.length()) {

			ExtentTestManager.setPassMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
		} else {

			ExtentTestManager
					.setFailMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
		}
	}
	public void clickOk() {
		click(btnOk, "Ok");
	}
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}