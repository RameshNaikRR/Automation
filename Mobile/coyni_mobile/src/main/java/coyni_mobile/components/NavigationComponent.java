package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NavigationComponent extends MobileFunctions {

	private By btnBack = MobileBy.xpath(
			"//*[contains(@resource-id,'Back') or contains(@resource-id,'otpValidationCloseIV') or contains(@resource-id,'Close') or contains(@resource-id,'cpbackBtn')]");
	private By btnClose = MobileBy.xpath(
			"//*[contains(@resource-id,'imgFPClose')]|//*[contains(@resource-id,'PayClose')]|//*[contains(@resource-id,'imgREClose')]|//*[contains(@resource-id,'imgClose')]|//*[contains(@resource-id,'lyPayClose')]|//*[contains(@resource-id,'lyClose')]|//*[contains(@resource-id,'Back')]|//*[contains(@resource-id,'closeBtnSC')]|//*[contains(@resource-id,'closeBtnIV')]|//*[contains(@resource-id,'accountsCloseIV')]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void clickBack() {
			click(btnBack, "Back");
	}

	public void clickClose() {
		wait.until(ExpectedConditions.presenceOfElementLocated(btnClose));
			click(btnClose, "Close");
	}

	public void verifyBackView() {
			new CommonFunctions().elementView(btnBack, "Back Icon");
	}

	public void verifyCloseView() {
			new CommonFunctions().elementView(btnClose, "Close Icon");
		
	}

}
