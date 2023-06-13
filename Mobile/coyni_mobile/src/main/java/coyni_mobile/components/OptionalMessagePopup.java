package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class OptionalMessagePopup extends MobileFunctions {
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
	
	/**
	 * Order -minChar, MaxiPlus
	 */
	public void validateMessageField(String message) {
		        String[] field = message.split(",");
		        new CommonFunctions().validateField(txtMessage, "message", field[0]);
		        new CommonFunctions().validateFieldMaxichar(txtMessage, "message", field[1]);
	}
	
}
