package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class IconComponent extends BrowserFunctions {
	private By backIcon = By.cssSelector("");
	private By crossIcon = By.cssSelector("");
	
	public void clickBackIcon() {
		click(backIcon, "Back Icon");
	}
	public void clickCrossIcon() {
		click(crossIcon, "Cross Icon");
	}

}
