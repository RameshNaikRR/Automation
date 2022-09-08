package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import io.appium.java_client.MobileBy;

public class ToastComponent {
	private By lblSucessMsg = MobileBy.xpath("//*[contains(@resource-id,'toastTV')]");

	
	public void verifyToastMsg(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessMsg, "Toast Message", expHeading);
	}
	
}
