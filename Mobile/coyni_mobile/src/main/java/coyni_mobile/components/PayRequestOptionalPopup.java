package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestOptionalPopup extends MobileFunctions {
	private By btnCancel = MobileBy.xpath(" ");
	private By btnDone = MobileBy.xpath(" ");
	private By txtMessage = MobileBy.xpath("");

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void fillMessage(String message) {
		enterText(txtMessage, message, "Message");
	}
}
