package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TopBarComponent extends BrowserFunctions {
	private By lblTitle = By.cssSelector(".welcome-text");
	private By drpdwnUserName = By.xpath("//img[contains(@class,'cursor-pointer down-arrow')]");
	private By iconNotification = By.xpath("//button[contains(@class,'icon-notification')]");

	public void VerifyTitle() {
		new CommonFunctions().elementView(lblTitle, "Title has been ");
	}

	public void clickUserNameDrpDwn() {
		click(drpdwnUserName, "User Name Drop Down ");
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

	public TopBarDrpDwnComponent topBarDrpDwnComponent() {
		return new TopBarDrpDwnComponent();
	}

	public UserDetailsComponent userDetailsComponent() {
		return new UserDetailsComponent();
	}

	public UserNameDropDownComponent userNameDropDownComponent() {
		return new UserNameDropDownComponent();
	}
}
