package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ActivateEmployee  extends BrowserFunctions{
	private By heading = By.xpath("");
	private By description = By.xpath("");
	private By clickActivate=By.xpath("");
	
	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is:", Heading);
	}

	public void verifydescription(String Description) {
		new CommonFunctions().verifyLabelText(description, "Description is :", Description);
	}
	public void clickDeactivate() {
		click(clickActivate, "Deactivate");
	}
}
