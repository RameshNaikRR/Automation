package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TwoStepAuthenticationPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[.='2-Step Authentication'])[2]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Two step authentication", Heading);
	}
}
