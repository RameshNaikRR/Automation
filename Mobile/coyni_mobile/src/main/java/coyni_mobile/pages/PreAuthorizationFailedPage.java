package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PreAuthorizationFailedPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[@text='Pre-Authorization Failed']");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'The amount')]");
	private By btnAddBankAccount = MobileBy.xpath("//*[@text='Add Bank Account']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
	}

	public void clickAddBankAccount() {
		click(btnAddBankAccount, "Add Bank Account");
	}
}
