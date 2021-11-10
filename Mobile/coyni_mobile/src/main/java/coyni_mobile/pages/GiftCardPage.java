package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class GiftCardPage extends MobileFunctions {
	private By iconSearch = MobileBy.xpath(" ");
	private By txtSearchBox = MobileBy.xpath(" ");
	private By iconCross = MobileBy.xpath(" ");
	public void clickSearch() {
		click(iconSearch,"Search");
	}
	public void fillSearchBox(String userName) {
		enterText(txtSearchBox, "userName", userName);
	
	}
	public void clickCross() {
		click(iconCross,"Cross");
	}

}
