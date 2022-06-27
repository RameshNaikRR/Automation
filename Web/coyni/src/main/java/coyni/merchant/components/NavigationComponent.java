package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NavigationComponent extends BrowserFunctions {
	private By btnBack = By.cssSelector(".self-start");
	private By btnClose = By.cssSelector(".self-end");

	public void clickBack() {
		click(btnBack, "Back");
	}
	public void clickClose() {
		click(btnClose, "Close");
	}
	public void verifyBackView() {
		new CommonFunctions().elementView(btnBack, "Back Icon");
		new CommonFunctions().verifyCursorAction(btnBack, "Back Icon");
	}
	public void verifyCloseView() {
		new CommonFunctions().elementView(btnClose, "Close Icon");
		new CommonFunctions().verifyCursorAction(btnClose, "Close Icon");
	}

}
