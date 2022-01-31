package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestOptionalPopup extends MobileFunctions {

	private By btnCancel = MobileBy.xpath("(//*[@name='Cancel'])[1]");
	private By btnDone = MobileBy.xpath("(//*[@name='Done'])[1]|//*[contains(@resource-id,'doneBtn')]");
	// private By txtMessage =
	// MobileBy.xpath("(//*[@name='Cancel'])[1]/../preceding-sibling::*[1]");
	private By optionaltxt = MobileBy.xpath("//*[contains(@resource-id,'addNoteClickLL')]");
	private By txtmsg = MobileBy.xpath("//*[contains(@resource-id,'addNoteET')]");

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

//	public void fillMessage(String message) {
//		enterText(txtMessage, message, "Message");
//	}

	public void enterMessage(String message) {
		click(optionaltxt, "optional message");
		enterText(txtmsg, message, "message");

	}
}
