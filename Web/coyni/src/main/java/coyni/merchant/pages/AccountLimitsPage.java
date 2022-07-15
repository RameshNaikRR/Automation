package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountLimitsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Account Limits']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}
}
