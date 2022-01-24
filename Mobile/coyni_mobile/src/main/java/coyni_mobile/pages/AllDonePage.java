package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AllDonePage extends MobileFunctions{
	
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'cvDone')]");
	
	public void clickDone() {
		click(btnDone, "Done");
	}

}
