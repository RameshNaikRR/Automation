package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestOptionalPopup extends MobileFunctions {
	private By btnCancel = MobileBy.xpath("(//*[@name='Cancel'])[1]");
	private By btnDone = MobileBy.xpath("(//*[@name='Done'])[1]");
	private By txtMessage = MobileBy.xpath("(//*[@name='Cancel'])[1]/../preceding-sibling::*[1]");

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
