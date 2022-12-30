package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NavigationComponent extends MobileFunctions {

	private By btnBack = MobileBy.xpath(
			"//*[contains(@resource-id,'close')]|//*[contains(@resource-id,'Back') or contains(@resource-id,'closeBtnIV') or contains(@resource-id,'otpValidationCloseIV') or contains(@resource-id,'Close') or contains(@resource-id,'cpbackBtn') or contains(@resource-id,'CLoseLL') or contains(@resource-id,'closeLL') or contains(@resource-id,'backLL') or contains(@resource-id,'accountsCloseIV') or contains(@resource-id,'notifBackbtn')]");
	private By btnClose = MobileBy.xpath(
			"//*[contains(@resource-id,'llClose')]|//*[contains(@resource-id,'accountsCloseIV')]|//*[contains(@resource-id,'closeBtnIV')]|//*[contains(@resource-id,'imgREClose')]|//*[contains(@resource-id,'imgClose')]|//*[contains(@resource-id,'lyPayClose')]|//*[contains(@resource-id,'lyClose')]|//*[contains(@resource-id,'Back')]|//*[contains(@resource-id,'closeBtnSC')]");

	// *[contains(@resource-id,'imgFPClose')]

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickClose() {
//		wait.until(ExpectedConditions.elementSelectionStateToBe(btnClose, false));
//		TouchActions action = new TouchActions(DriverFactory.getDriver());
//		action.singleTap((WebElement) btnClose);
//		action.perform();

			click(btnClose, "Close");
//			click(btnClose, "Close");
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
