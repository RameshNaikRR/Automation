package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TopBarComponent extends BrowserFunctions {
	private By lblTitle = By.cssSelector(".welcome-text");
	private By drpdwnUserName = By.cssSelector(".internal-header__right-container>span>div");
	private By iconNotification = By.cssSelector(".internal-header__right-container>span>div");

	private By getDropDownItems(String itemsNum) {
		return By.cssSelector(String.format(".dropdown-container>div:nth-of-type('%s')", itemsNum));
	}
	public void VerifyTitle(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTitle, "Title Heading", expHeading);
	}
	public void clickUserName() {
		click(drpdwnUserName, "User Name");
	}

	public void clickIconNotification() {
		click(iconNotification, "Icon Notification");
	}

	public void clickUserDetails() {
		click(getDropDownItems("1"), "User Details");
	}

	public void clickPaymentMethods() {
		click(getDropDownItems("2"), "Payment Methods");
	}

	public void clickPreferences() {
		click(getDropDownItems("3"), "Preferences");
	}

	public void clickAgreements() {
		click(getDropDownItems("4"), "Agreements");
	}

	public void clickChangePassword() {
		click(getDropDownItems("5"), "Change Password");
	}

	public void clickTwoStepAuthentication() {
		click(getDropDownItems("6"), "2-Step Authentication");
	}

	public void clickSignOut() {
		click(getDropDownItems("7"), "Sign Out");
	}
	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
//	public VerifyYourIdentityPage verifyYourIdentityPage() {
//		return new VerifyYourIdentityPage();
//	}
//	public ChangePasswordPage changePasswordPage() {
//		return new ChangePasswordPage();
//	}

}
