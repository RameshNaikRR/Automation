package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class cvvPopup extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[contains(@text,'CVV to')]");
	private By txtCvv = MobileBy.id("com.coyni.mapp:id/etCVV");
	private By btnOk = MobileBy.id("com.coyni.mapp:id/keyActionLL");

	public void verifyPopupHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Popup heading", expHeading);
	}

	public void fillCvv(String cvv) {
		new ChoosePinComponent().fillPins(cvv);
	}

	public void validateCVVorCVC(String textField) {
		String[] field = textField.split(",");
		// for (int i = 0; i < 2; i++) {
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
		// new SignUpPage().clickDone();
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