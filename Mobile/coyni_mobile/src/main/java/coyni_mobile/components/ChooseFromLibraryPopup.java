package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ChooseFromLibraryPopup extends MobileFunctions{

	private By btnDone =MobileBy.xpath("");
	private By imgSelectPhoto =MobileBy.xpath("");
	
	public void ClickImage() {
		click(imgSelectPhoto, "Click Image");
	}
	
	public void clickDone() {
		click(btnDone, "click Done");
	}
	public void verifyDoneView() {
		new CommonFunctions().elementView(btnDone, " Done ");
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();	
		}
		


}
