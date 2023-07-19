package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NavigationComponent extends MobileFunctions {

	private By btnBack = MobileBy.xpath(
			"//*[contains(@resource-id,'BuyClose')]|//*[contains(@resource-id,'backIV')]|//*[contains(@resource-id,'closeIV')]|//*[contains(@resource-id,'back')]|//*[contains(@resource-id,'dialogCLoseLL')]|//*[contains(@resource-id,'PayBack')]|//*[contains(@resource-id,'imgBack')]|//*[contains(@resource-id,'ivBack')]|//*[@content-desc='Back']|//*[contains(@resource-id,'Close')]");
	private By btnClose = MobileBy.xpath(
			"//*[contains(@resource-id,'backIV')]|//*[contains(@resource-id,'backBtn')]|//*[contains(@resource-id,'ivBack')]|//*[contains(@resource-id,'ivClose')]|//*[contains(@resource-id,'imgClose')]|//*[contains(@resource-id,'imgBack')]|//*[contains(@resource-id,'close')]|//*[contains(@resource-id,'Close')]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickClose() {
		wait.until(ExpectedConditions.presenceOfElementLocated(btnClose));
		click(btnClose, "close");
	}
}
