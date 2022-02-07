package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NavigationComponent extends MobileFunctions {
	private By btnBack = MobileBy.xpath(
			"//*[contains(@resource-id,'Back') or contains(@resource-id,'otpValidationCloseIV') or contains(@resource-id,'Close') or contains(@resource-id,'cpbackBtn')]");
	private By btnClose = MobileBy.xpath(
			"(//*[contains(@resource-id,'Close')][1]|//*[contains(@resource-id,'Close')][2]|//*[contains(@resource-id,'Close')])[3]|//*[contains(@resource-id,'layoutClose')]|//*[contains(@resource-id,'imgREClose')]|//*[contains(@resource-id,'imgClose')]|//*[contains(@resource-id,'lyClose')]|//*[contains(@resource-id,'Back')]|//*[contains(@resource-id,'closeBtnSC')]");

	public void clickBack() {

		if (!new CommonFunctions().isPlatformiOS()) {
			click(btnBack, "Back");
		}
	}

	public void clickClose() {

		if (!new CommonFunctions().isPlatformiOS()) {
			click(btnClose, "Close");
		}
	}

	public void verifyBackView() {
		if (!new CommonFunctions().isPlatformiOS()) {
			new CommonFunctions().elementView(btnBack, "Back Icon");
		}
	}

	public void verifyCloseView() {
		if (!new CommonFunctions().isPlatformiOS()) {
			new CommonFunctions().elementView(btnClose, "Close Icon");
		}
	}

}
