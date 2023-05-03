package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class MerchantDetailsComponent extends BrowserFunctions {

	private By preferencesControl = By.xpath("//span[contains(text(),'Preferences / Controls')]");
	
	public void clickPreferencesControl() {
		click(preferencesControl, "Preferences Control");
	}
}
