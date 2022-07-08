package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantSettingsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Merchant Settings']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Merchant settings page heading ", Heading);
	}
}
