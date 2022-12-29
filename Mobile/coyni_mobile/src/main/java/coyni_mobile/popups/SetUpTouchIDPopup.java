package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SetUpTouchIDPopup extends MobileFunctions {

	private By setUpTouchID = MobileBy.xpath("//*[contains(@resource-id,'tvEnable')]");

	private By notNow = MobileBy.xpath("//*[contains(@resource-id,'notNowLL')]");

	private By heading = MobileBy.xpath("//*[@text='Set Up Touch ID']");

	private By backIcon = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]");

	public void clickSetUpTouchID() {
		click(setUpTouchID, "Set Up Touch ID");
	}

	public void clickNotNow() {
		click(notNow, "Not Now");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}
	
	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Heading");
		new CommonFunctions().elementView(setUpTouchID, "Set Up Touch ID");
		new CommonFunctions().elementView(notNow, "Not Now");
	}
	
	public void clickBackButton() {
		click(backIcon, "Back Icon");
	}

}
