package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By lblPasswordSucessfullHeading = MobileBy.xpath("//*[contains(@resource-id,'tvDone')]");
	private By lblPasswordSucessfullDescription = MobileBy.xpath("//*[contains(@text,'Your passwo')]");
	private By btnPasswordLogin = MobileBy.xpath("//*[contains(@resource-id,'cvLogin')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPasswordSucessfullHeading,
				"Password Sucessfully Upadated Page Heading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblPasswordSucessfullDescription,
				"Password Sucessfully Upadated Page Description", expDescription);
	}

	public void clickLogin() {
		new CommonFunctions().elementView(btnPasswordLogin, "Login");
		click(btnPasswordLogin, "Login");
	}

}
