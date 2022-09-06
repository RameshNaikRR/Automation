package coyni.checkout;

import org.openqa.selenium.By;
import ilabs.WebFramework.BrowserFunctions;

public class ScanQRCodePayMerchantPage extends BrowserFunctions {

	private By btnContinueWithBrowser = By.xpath("//p[contains(text(),'Continue with browser')]");

	public void clickContinueWithBrowser() {
		click(btnContinueWithBrowser, "Continue With Browser");
	}

}
