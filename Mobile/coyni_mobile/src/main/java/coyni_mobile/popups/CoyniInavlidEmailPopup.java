package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class CoyniInavlidEmailPopup extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[@text='coyni']");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'User data not')]");
	private By btnOk = MobileBy.xpath("//*[@text='OK']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
	}

	public void clickOk() {
		click(btnOk, "OK");
	}
}
