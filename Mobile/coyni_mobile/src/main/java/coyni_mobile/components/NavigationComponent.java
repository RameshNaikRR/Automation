package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NavigationComponent extends MobileFunctions {

	private By btnClose= MobileBy.xpath("//*[contains(@resource-id,'Close')]|//*[(contains(@resource-id,'ack') or contains(@resource-id,'lose')) and (contains(@class,'ImageView') and not(contains(@resource-id,'ction')))]");
	private By btnBack= MobileBy.xpath("//*[contains(@resource-id,'alBackbtn')]|//*[contains(@resource-id,'userDetailsCloseLL')]|//*[contains(@resource-id,'lyPRClose')] |//*[contains(@resource-id,'notifBackbtn')] | //*[(contains(@resource-id,'ack') or contains(@resource-id,'lose')) and (contains(@class,'ImageView') and not(contains(@resource-id,'ction')))]");
	//WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void clickBack() {
			click(btnBack, "Back");
	}

	public void clickClose() {
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(btnClose));
			click(btnClose, "Close");
	}
	public void verifyBackView() {
			new CommonFunctions().elementView(btnBack, "Back Icon");
	}

	public void verifyCloseView() {
			new CommonFunctions().elementView(btnClose, "Close Icon");
		
	}


}
