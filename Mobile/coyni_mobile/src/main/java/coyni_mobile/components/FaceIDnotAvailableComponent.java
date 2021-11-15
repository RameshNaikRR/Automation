package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FaceIDnotAvailableComponent extends MobileFunctions{
	private By lblFaceIdNotAvailable = MobileBy.xpath(" ");
	private By btnOk = MobileBy.xpath(" ");
	
	public void clickOk() {
		click(btnOk, "Ok");
	}
	public void verifyFaceIdNotAvailableView() {
		new CommonFunctions().elementView(lblFaceIdNotAvailable, "FaceId Not Available");
	}
}
