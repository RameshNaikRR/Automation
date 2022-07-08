package coyni.merchant.pages;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GetHelpPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector(".header>span");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Get help page heading ", Heading);
	}
}