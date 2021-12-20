package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SecureAccountPage extends MobileFunctions{

	private By heading = MobileBy.xpath("//*[@name='Secure your account']");
	private By btnNext =MobileBy.xpath("//*[@name='secure-lock-bg']/following-sibling::*[1]");

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
