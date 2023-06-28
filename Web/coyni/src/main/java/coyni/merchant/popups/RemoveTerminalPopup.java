package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RemoveTerminalPopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[contains(text(),'Remove Terminal')]");
	private By btnRemove = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void clickOnRemove() {
		click(btnRemove, "Remove");
	}

}
