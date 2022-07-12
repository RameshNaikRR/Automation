package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreferencesPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[.='Preferences'])[2]");

	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Preferences Page ");
	}
}
