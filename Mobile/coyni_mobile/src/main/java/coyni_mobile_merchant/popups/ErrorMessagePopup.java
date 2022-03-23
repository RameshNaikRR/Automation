package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ErrorMessagePopup extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().elementView(lblHeading, "Heading");
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().elementView(lblDescription, "Description");
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

	public void verifyOk() {
		new CommonFunctions().elementView(btnOk, "Ok");
	}
}
