package coyni_mobile.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NavigationComponent extends MobileFunctions {

	private By btnBack = MobileBy.xpath(
			"//*[contains(@resource-id,'Back')]|//*[@name='back']|//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By btnClose = MobileBy.xpath(
			"//*[contains(@resource-id,'imgClose') or contains(@resource-id,'lyClose') or contains(@resource-id,'cpConfirmBackIV') or contains(@resource-id,'imgFPClose') or contains(@resource-id,'imgBack')]|//*[@name='close'or @name='Button']");

	public void clickBack() {
		if (new CommonFunctions().isPlatformiOS()) {
			List<WebElement> list = getElementList(btnBack, "Back");
			int num = list.size();
			System.out.println(num);
			for (int i = 0; i < num; i++) {
				list.get(i).click();
			}
		}
		if (!new CommonFunctions().isPlatformiOS()) {
			click(btnBack, "Back");
		}
	}

	public void clickClose() {
		if (new CommonFunctions().isPlatformiOS()) {
			List<WebElement> list = getElementList(btnClose, "close");
			int num = list.size();
			System.out.println(num);
			for (int i = 0; i < num; i++) {
				list.get(i).click();
			}
		}
		if (!new CommonFunctions().isPlatformiOS()) {
			click(btnClose, "Close");
		}
	}

	public void verifyBackView() {
		if (!new CommonFunctions().isPlatformiOS()) {
			new CommonFunctions().elementView(btnBack, "Back Icon");
		}
	}

	public void verifyCloseView() {
		if (!new CommonFunctions().isPlatformiOS()) {
			new CommonFunctions().elementView(btnClose, "Close Icon");
		}
	}

}
