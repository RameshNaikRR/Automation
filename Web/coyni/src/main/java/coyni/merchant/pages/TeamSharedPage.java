package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TeamSharedPage extends BrowserFunctions{
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Team']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}
}
