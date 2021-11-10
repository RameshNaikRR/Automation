package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ChooseFromLibraryComponent extends MobileFunctions{

	private By btnDone =MobileBy.xpath("");
	
	public void clickDone() {
		click(btnDone, "click Done");
	}


}
