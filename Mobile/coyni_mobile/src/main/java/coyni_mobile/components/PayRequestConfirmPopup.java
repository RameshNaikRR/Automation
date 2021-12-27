package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import io.appium.java_client.MobileBy;

public class PayRequestConfirmPopup extends MobileFunctions {

	private By heading = MobileBy.xpath("");
	private By lnkCopy = MobileBy.xpath(" ");
	private By btnConfirm = MobileBy.xpath("//*[@name='Slide to confirm']/../..");
	private By lblAvailableBalance = MobileBy.xpath(" ");
	private By btnDone = MobileBy.xpath(" ");

	public void verifyHeading() {
		
	}
	public void clickCopy() {
		click(lnkCopy, "Copy");
	}

	public void swipeConfirm() {
		swipeOnElement(btnConfirm, "Confirm", SwipeDirection.RIGHT);
	}

	public void getAvailableBalance() {

	}

	public void clickDone() {
		click(btnDone, "Done");
	}
	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}
	public SecurePayPopup securePayPopup() {
		return new SecurePayPopup();
	}
}
