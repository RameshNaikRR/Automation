package coyni.merchant.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class SideBarMenuComponent extends BrowserFunctions {
	private By drpdwnHello = By.xpath("(//div[.='Hello'])[1]");

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	private By getMerchantActivity(String Activity) {
		return By.xpath(String.format("//button[.='%s']", Activity));
	}
	
}
