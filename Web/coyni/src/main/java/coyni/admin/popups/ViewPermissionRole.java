package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ViewPermissionRole extends BrowserFunctions {
	private By heading = By.xpath("");
	private By description = By.xpath("");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is:", Heading);
	}

	public void verifydescription(String Description) {
		new CommonFunctions().verifyLabelText(description, "Description is :", Description);
	}
}
