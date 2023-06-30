package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ToastComponent extends MobileFunctions {

	private By lblSucessMsg = MobileBy.id("com.coyni.mapp:id/toastTV");

	public void verifyToastMsg(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessMsg, "Toast Message", expHeading);
	}
}
