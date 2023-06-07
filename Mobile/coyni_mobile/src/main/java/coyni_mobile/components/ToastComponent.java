package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ToastComponent extends MobileFunctions {

	private By lblSucessMsg = MobileBy.AccessibilityId("");

	public void verifyToastMsg(String expHeading) {
		new AndroidCommonFunctions().verifyLabelText(lblSucessMsg, "Toast Message", expHeading);
	}
}
