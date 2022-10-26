package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.ToastComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class RemovingPopup extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[contains(@text,'Removing')]");
	private By btnYes = MobileBy.xpath("//*[contains(@text,'Yes')]");
	private By btnNo = MobileBy.xpath("//*[contains(@resource-id,'id/tvNo')]");

	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Removing");
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void clickNo() {
		click(btnNo, "No");
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
