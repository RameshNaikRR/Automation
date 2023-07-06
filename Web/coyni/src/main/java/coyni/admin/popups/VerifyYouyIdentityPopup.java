package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class VerifyYouyIdentityPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Verify Your Identity']");
	private By lblDescription = By.xpath("//h3[contains(.,'Enter the code')]");
	private By lblMsg = By.xpath("//div[text()='Having an issue with your authentication app?']");
	private By lnkSmsCode = By.xpath("//span[text()='Get an SMS code.']");
	private By clickClose = By.xpath("");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
	}

	public void verifyMsg(String Message) {
		enterText(lblMsg, Message, "Message");
	}

	public void verifyLink() {
		new CommonFunctions().elementView(lnkSmsCode, "Get An SMS Code");
	}

	public void clickClose() {
		click(clickClose, "Close");
	}

}
