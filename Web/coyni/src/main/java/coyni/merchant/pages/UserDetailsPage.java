package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class UserDetailsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[.='User Details'])[2]");

	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "User Details heading ");
	}
}
