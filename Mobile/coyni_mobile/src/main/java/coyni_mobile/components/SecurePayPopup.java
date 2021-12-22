package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SecurePayPopup extends MobileFunctions{

	private By heading = MobileBy.xpath("");
	private By btnNotNow =MobileBy.xpath("(//*[@name='Not Now'])[1]");
	
	public void clickNotNow() {
		click(btnNotNow, "Not Now");
	}
	
}
