package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SetUpTouchIDPopup extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[contains(@text,'Choose screen lock')]");//

	private By setUpTouchID = MobileBy.xpath("//*[contains(@resource-id,'enableCV')]");

	private By notNow = MobileBy.xpath("//*[contains(@resource-id,'notNowLL')]");

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

	public void clickBackButton() {
		click(backIcon, "Back Icon");
	}

}
