package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By lblHeading =MobileBy.xpath("");
	private By ImgSuccessFailure =MobileBy.xpath("");
	private By btnLogout =MobileBy.xpath("");
	
	public void verifyHeading(String expHeading) {
		// new CommonFunctions().verifyLabelText(expHeading, expHeading, expHeading);
	 }
	public void verifySuccessFailureImage() {
		
	}
	public void clickLogOut() {
		click(btnLogout, "click LogOut");
	}

}
