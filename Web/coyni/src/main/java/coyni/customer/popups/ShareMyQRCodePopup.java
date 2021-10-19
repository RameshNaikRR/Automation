package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class ShareMyQRCodePopup extends BrowserFunctions {
	
	private By txtmsg = By.cssSelector("");
	private By txtEmail = By.cssSelector("");
	
	public void enterMessage(String Message) {
		enterText(txtmsg, Message, "Message" );
	}
	public void enterEmail(String Email) {
		enterText(txtEmail, Email, "Email");
	}

}
