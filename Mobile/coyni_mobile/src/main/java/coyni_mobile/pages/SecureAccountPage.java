package coyni_mobile.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SecureAccountPage extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[@text='Secure your account']");
	private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
	private By btnFinishSignup = MobileBy.xpath("//*[contains(@text,'Finish Signup')]");
	private By chboxAgree = MobileBy.xpath("//*[contains(@resource-id,'agreeCB')]");

	
	public void clickAgreeCheckBox() {
		click(chboxAgree, "Terms of service and Privacy");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void scrollTermsOfService() throws InterruptedException {
		Thread.sleep(8000);
		while (getElementList(btnNext, "Next").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (300))).release().perform();
		}
	}

	public void scrollPrivacyPolicy() throws InterruptedException {
		Thread.sleep(6000);
		while (getElementList(btnFinishSignup, "Finish Signup").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (300))).release().perform();
		}
	}

	public void clickFinishSignup() {
		click(btnFinishSignup, "Finish Signup");
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
