package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PreAuthorizationPage extends MobileFunctions {

	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By btnVerify = MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");

	public void fillAmount(String amount) throws InterruptedException {
//		enterText(txtAmount, amount, "amount");
		new EnterYourPINComponent().fillPin(amount);

	}

	public void clickVerify() {
		click(btnVerify, "Verify");
	}

	public AllDonePage allDonePage() {
		return new AllDonePage();
	}

	public PreAuthorizationFailedPage preAuthorizationFailedPage() {
		return new PreAuthorizationFailedPage();
	}
}
