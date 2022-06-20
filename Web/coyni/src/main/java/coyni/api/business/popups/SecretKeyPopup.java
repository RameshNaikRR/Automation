package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SecretKeyPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By btnGenerate = By.xpath("");
	private By selfEnd = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, "Are You Sure ");
	}

	public void verifyDescription(String expdescription) {
		new CommonFunctions().verifyLabelText(lblDescription, expdescription, "Description");
	}

	public void clickGenerate() {
		click(btnGenerate, "Generate");
	}

	public void clickEnd() {
		click(selfEnd, "Self End");
	}
}
