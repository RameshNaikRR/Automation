package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ErrorMessagePopup extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]|//*[contains(@text,'Cancel')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]|//*[contains(@text,'sure you want')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By btnNo = MobileBy.xpath("//*[contains(@resource-id,'No')]");
	private By btnYes = MobileBy.xpath("//*[contains(@resource-id,'Yes')]");
	public void verifyHeading(String Heading) {
		new CommonFunctions().elementView(lblHeading, "Heading");
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().elementView(lblDescription, "Description");
	}

	public void clickOk() {
		new CommonFunctions().elementView(btnOk, "Ok");
		click(btnOk, "Ok");
	}
	public void clickNo() {
		new CommonFunctions().elementView(btnNo, "No");
		click(btnNo, "No");
	}
	public void clickYes() {
		new CommonFunctions().elementView(btnYes, "Yes");
		click(btnYes, "Yes");
	}
	
}
