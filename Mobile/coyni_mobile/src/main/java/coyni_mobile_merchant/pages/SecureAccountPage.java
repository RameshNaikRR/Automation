package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile_merchant.components.*;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SecureAccountPage extends MobileFunctions{

	private By heading = MobileBy.xpath("//*[@text='Secure your account']");
	private By btnNext =MobileBy.xpath("//*[contains(@resource-id,'secureNextCV')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
