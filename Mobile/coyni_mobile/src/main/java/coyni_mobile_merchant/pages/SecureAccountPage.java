package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import coyni_mobile_merchant.components.*;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SecureAccountPage extends MobileFunctions{

	private By heading = MobileBy.xpath("//*[@text='Secure your account']");
	private By btnNext =MobileBy.xpath("//*[contains(@text,'Next')]");
	private By btnFinishSignup =MobileBy.xpath("//*[contains(@text,'Finish Signup')]");	

	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}
	
	public void scrollTermsOfService() {
		
		while (getElementList(btnNext, "Next").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (300))).release().perform();
		}
//		for (int i=1;i<10;i++) {
//			TouchAction touch = new TouchAction(DriverFactory.getDriver());
//			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//					.moveTo(PointOption.point(540, (int) (300))).release().perform();
//		}
		
	}
	
	public void scrollPrivacyPolicy() {
		
		while (getElementList(btnFinishSignup, "Finish Signup").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (300))).release().perform();
		}
//		for (int i=1;i<8;i++) {
//			TouchAction touch = new TouchAction(DriverFactory.getDriver());
//			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//					.moveTo(PointOption.point(540, (int) (300))).release().perform();
//		}
		
		
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
	
	public void clickFinishSignup() {
		click(btnFinishSignup, "Finish Signup");
	}
	
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
	
}
