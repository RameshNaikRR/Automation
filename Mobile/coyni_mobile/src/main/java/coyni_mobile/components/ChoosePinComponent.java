package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.EnableFaceIDpage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ChoosePinComponent extends MobileFunctions {

	private By heading1 = MobileBy.xpath("//*[@name='Choose your PIN'] | (//*[contains(@resource-id,'tvHead')])");
	
	private By heading2 = MobileBy.xpath("//*[@name='Confirm your PIN'] | (//*[contains(@resource-id,'tvHead')])");
	
	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	
	
	public void verifyChoosePinHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading1, "heading", expHeading);
	}
	public void verifyChooseYourPinView() {
		new CommonFunctions().elementView(heading1, "Choose your Pin ");
	}
	public void verifyConfirmPinHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading2, "heading", expHeading);
	}
	public void fillPin(String pin) {
		new EnterYourPINComponent().fillPin(pin);
	}
	public EnableFaceIDpage enableFaceIDpage() {
		return new EnableFaceIDpage();
	}
	
}
