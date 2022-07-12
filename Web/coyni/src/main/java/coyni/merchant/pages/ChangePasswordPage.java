package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ChangePasswordPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[.='Change Password'])[2]");

	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Change Password Page ");
	}
}
