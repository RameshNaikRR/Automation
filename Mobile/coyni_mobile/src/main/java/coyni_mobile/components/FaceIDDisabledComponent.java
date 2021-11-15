package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FaceIDDisabledComponent extends MobileFunctions {
	private By btnOk = MobileBy.xpath(" ");
	private By heading = MobileBy.xpath(" ");
	
	public void clickOk() {
	//	click(btnOk ,"Ok");
	}
	public void verifyOkView() {
		new CommonFunctions().elementView(btnOk, "Ok");
	}
	public void verifyHHeadingView() {
		new CommonFunctions().elementView(heading, "heading");
	}
	}
   

