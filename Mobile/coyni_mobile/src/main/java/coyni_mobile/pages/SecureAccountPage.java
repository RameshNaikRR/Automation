package coyni_mobile.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private By privacyPolicyUpdate = MobileBy
			.xpath("//*[contains(@resource-id,'privacy_policy')]|//*[contains(@text,'Privacy Policy')]");
	private By termsOfServiceUpdateHeading = MobileBy.xpath("//*[contains(@resource-id,'agreNameTV')]");
	private By privacyPolicyHeading = MobileBy.xpath("//*[contains(@resource-id,'privacy_policy')]|//*[contains(@resource-id,'agreNameTV')]");
	private By termsOfServiceUpdateOk = MobileBy.xpath("//*[contains(@resource-id,'actionCV')]");
//	private By chboxAgree = MobileBy.xpath("//*[contains(@resource-id,'agreeCB')]");

	WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), 40);
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
//		wait.until(ExpectedConditions.presenceOfElementLocated(btnNext));
//		while (getElementList(btnNext, "Next").size() == 0) {
//			TouchAction touch = new TouchAction(DriverFactory.getDriver());
//			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//					.moveTo(PointOption.point(540, (int) (300))).release().perform();
//		}
	}

	public void scrollPrivacyPolicy() throws InterruptedException {
//		while (getElementList(btnFinishSignup, "Finish Signup").size() == 0) {
//			TouchAction touch = new TouchAction(DriverFactory.getDriver());
//			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//					.moveTo(PointOption.point(540, (int) (300))).release().perform();
//		}
	}

	public void verifyTermsOfServiceUpdateForSignUp(String expHeading) throws InterruptedException {
//		wait.until(ExpectedConditions.titleIs(expHeading));
		wait.until(ExpectedConditions.presenceOfElementLocated(termsOfServiceUpdateHeading));
		new CommonFunctions().verifyLabelText(termsOfServiceUpdateHeading, "Terms Of Service Update Heading",
				expHeading);
		scrollDownToElement(termsOfServiceUpdateOk, "Terms of Service Agree button");
		clickAgreeCheckBox();
		click(termsOfServiceUpdateOk, "Terms Of Service Update Ok");
}

public void verifyPrivacyPolicyHeadingForSignUp(String expHeading) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(privacyPolicyHeading));
		new CommonFunctions().verifyLabelText(privacyPolicyHeading, "Privacy Policy Update Heading", expHeading);
		scrollDownToElement(termsOfServiceUpdateOk, "Privacy Policy Update button");
		clickAgreeCheckBox();
		click(termsOfServiceUpdateOk, "Privacy Policy Update Update Ok");
	
}

	public void clickFinishSignup() {
		click(btnFinishSignup, "Finish Signup");
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
