package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AccountNotFoundPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Sorry')]");
	private By btnTryAgain = MobileBy.xpath("//*[contains(@resource-id,'reTryAgainBtn')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void clickTryAgain() {
		click(btnTryAgain, "Try Again");
	}

	public void verifyTryAgainView() {
		new CommonFunctions().elementView(btnTryAgain, "Try Again");
	}
}
