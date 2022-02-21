package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodsComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}
}
