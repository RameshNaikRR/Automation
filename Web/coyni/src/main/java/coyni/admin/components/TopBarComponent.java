package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TopBarComponent extends BrowserFunctions {

	private By txtSearch = By.xpath(
			"//input[@class='form-input-search  Header_main_search__2-DYt px-2 bg-cwhite flex-row flex shadow-3xl outline-none border-2 focus:border-cgy2']");

	private By drpdwnUserName = By.xpath("//span[contains(@class,'user-initials-ring user-initials-ring__active' )]");

	public void fillSearch(String search) {
		enterText(drpdwnUserName, "Search", search);
	}

	public void clickDropDownUserName() {
		click(drpdwnUserName, "Drop Down");

	}

	public By getDropDownItems(String elementName) {
		return By.xpath(String.format("//span[(contains(@class,'user' ) or contains(@class,'text'))and text()='%s']",
				elementName));
	}

	public void clickUserName() {
		click(getDropDownItems("UserName"), "Coyni Portal");
	}

	public void clickChangePassword() {
		click(getDropDownItems("Change Password"), "Change Password");
	}

	public void clickSignOut() {
		click(getDropDownItems("SignOut"), "SignOut");
	}
}
