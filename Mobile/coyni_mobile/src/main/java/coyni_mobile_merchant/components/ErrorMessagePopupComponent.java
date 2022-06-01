package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ErrorMessagePopupComponent extends MobileFunctions {
	private By lblpopUpMsgHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblpopUpMsg = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'tvAction')]");

	public void verifyPopUpMsg(String expPopUpMsg) {
		new CommonFunctions().verifyLabelText(lblpopUpMsg, "Pop Up Message", expPopUpMsg);
	}
	public void verifyPopUpMsgHeading(String expPopUpMsgHeading) {
		new CommonFunctions().verifyLabelText(lblpopUpMsgHeading, "Pop Up Message", expPopUpMsgHeading);
	}
	public void clickOk() {
		click(btnOk, "Ok");
	}

}
