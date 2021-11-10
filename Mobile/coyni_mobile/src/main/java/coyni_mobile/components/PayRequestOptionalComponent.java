package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestOptionalComponent extends MobileFunctions {
	private By btnCancel = MobileBy.xpath(" ");
	private By btnDone = MobileBy.xpath(" ");
	
	public void clickCancel() {
		click(btnCancel,"Cancel");
	}
	public void clickDone() {
		click(btnDone, "Done");
	}
	
	

}
