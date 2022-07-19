package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.admin.pages.AdminUserDetailsPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TopBarComponent extends BrowserFunctions {

	private By txtSearch = By.xpath(
			"//input[@class='form-input-search  Header_main_search__2-DYt px-2 bg-cwhite flex-row flex shadow-3xl outline-none border-2 focus:border-cgy2']");

	private By drpdwnUserName = By.xpath("//div[contains(@class,'header__circle-initials hover:underline hover:text-cgy4')]");

	private By handMark = By.xpath("//div[@class='cursor-pointer']");

	public void verifyCursorAction() {
		new CommonFunctions().verifyCursorAction(handMark, "Hand Mark");
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

	public AdminUserDetailsPage adminUserDetailsPage() {
		return new AdminUserDetailsPage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
