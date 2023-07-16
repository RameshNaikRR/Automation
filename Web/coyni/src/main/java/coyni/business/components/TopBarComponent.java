package coyni.business.components;

import org.openqa.selenium.By;
import coyni.admin.Paymentcomponents.NavigationComponent;
import coyni.admin.Paymentpages.AdminUserDetailsPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TopBarComponent extends BrowserFunctions {
	private By lblTitle = By.xpath("//span[@data-ui-auto='welcom_coyni']");
	private By txtSearch = By.xpath(
			"//input[@class='form-input-search  Header_main_search__2-DYt px-2 bg-cwhite flex-row flex shadow-3xl outline-none border-2 focus:border-cgy2']");

	private By drpdwnUserName = By.xpath("//button[contains(@class,'px-1 h-7')]");
	private By iconNotification = By.xpath("");

	private By handMark = By.xpath("//div[@class='cursor-pointer']");

	public void verifyCursorAction() {
		new CommonFunctions().verifyCursorAction(handMark, "Hand Mark");
	}

	public void clickUserNameDrpDwn() {
		click(drpdwnUserName, "User Name Drop Down ");
	}

	public void verifyUserNameDrpDwn() {
		new CommonFunctions().elementView(drpdwnUserName, "User Name drop down");
	}

	public void verifyIconNotification() {
		new CommonFunctions().elementView(iconNotification, "Notification icon ");
	}

	public void VerifyTitle() {
		new CommonFunctions().elementView(lblTitle, "Title has been ");
	}

	public void fillSearch(String search) {
		enterText(drpdwnUserName, "Search", search);
	}

	public void clickDropDownUserName() {
		click(drpdwnUserName, "Drop Down");

	}

	public By getDropDownItems(String elementName) {
		return By.xpath(String.format("//button[(contains(@class,'user' ) or contains(@class,'text'))and text()='%s']",
				elementName));
	}

	public void clickUserName() {
		click(getDropDownItems("User Details"), "Coyni Portal");
	}

	public void clickChangePassword() {
		click(getDropDownItems("Change Password"), "Change Password");
	}

	public void clickSignOut() {
		click(getDropDownItems("Sign Out"), "Sign Out");
	}

	public TopBarDrpDwnComponent topBarDrpDwnComponent() {
		return new TopBarDrpDwnComponent();
	}

	public AdminUserDetailsPage adminUserDetailsPage() {
		return new AdminUserDetailsPage();
	}

	public UserDetailsComponent userDetailsComponent() {
		return new UserDetailsComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
