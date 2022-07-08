package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TopBarComponent extends BrowserFunctions {
	private By lblTitle = By.cssSelector(".welcome-text");
	private By drpdwnUserName = By.xpath("//span[contains(@class,'cursor-pointer')]/..");
	private By iconNotification = By.xpath("//button[contains(@class,'icon-notification')]");

	public void VerifyTitle(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTitle, "Title Heading", expHeading);
	}

	public void clickUserNameDrpDwn() {
		click(drpdwnUserName, "User Name");
	}

	public void verifyUserNameDrpDwn() {
		new CommonFunctions().elementView(drpdwnUserName, "User Name drop down");
	}

	public void clickIconNotification() {
		click(iconNotification, "Icon Notification");
	}

	public void verifyIconNotification() {
		new CommonFunctions().elementView(iconNotification, "Notification icon ");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public UserDetailsComponent userDetailsComponent() {
		return new UserDetailsComponent();
	}
}
