package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantAccountsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[.='Merchant Accounts'])[2]");

	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Merchant Accounts page ");
	}
}
