package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[.='Agreements'])[2]");

	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Agreements Page ");
	}
}
