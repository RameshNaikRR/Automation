package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NavigationComponent extends MobileFunctions {
	private By btnBack = MobileBy.xpath("");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");

	public void clickBack() {
		click(btnBack, "click Back");
	}

	public void clickClose() {
		click(btnClose, "click Close");
	}

	public void verifyBackView() {
		new CommonFunctions().elementView(btnBack, "Back Icon");
	}

	public void verifyCloseView() {
		new CommonFunctions().elementView(btnClose, "Close Icon");
	}

}
