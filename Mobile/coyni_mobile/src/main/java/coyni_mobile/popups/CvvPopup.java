package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class CvvPopup extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[@text='Please confirm CVV to continue']|//*[contains(@name,'confirm')]");
	private By txtCvv = MobileBy.xpath("(//*[contains(@text,'CVV/CVC')])[2]");
	private By btnOk = MobileBy
			.xpath("//*[@name='OK']/preceding-sibling::*[1]|//*[contains(@resource-id,'keyActionTV')]");

	public void verifyPopupHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Popup heading", expHeading);
	}

	public void fillCvv(String cvv) {
		click(txtCvv, "CVV");
		enterText(txtCvv, cvv, "CVV");
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}
}
