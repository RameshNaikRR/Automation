package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class CvvPopup extends MobileFunctions{
	
	private By heading = MobileBy.xpath("//*[contains(@name,'confirm')]");
	private By txtCvv = MobileBy.xpath("//*[contains(@name,'CVV/CVC')]");
	private By btnOk = MobileBy.xpath("//*[@name='OK']/preceding-sibling::*[1]");
	
	public void verifyPopupHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Popup heading", expHeading);
	}
    public void fillCvv(String cvv) {
    	new EnterYourPINComponent().fillPin(cvv);
    }
    public void clickOk() {
    	click(btnOk, "Ok");
    }
}
