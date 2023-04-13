package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PreAuthorizationFailedPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Your account')]");
	private By btnAddBankAccount = MobileBy.xpath("//*[@text='Add Bank Account']");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'cvOK')]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}
	public void clickOk() {
		click(btnOk, "Ok");
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
	}

	public void clickAddBankAccount() {
		click(btnAddBankAccount, "Add Bank Account");
	}
	public void verifyPreAuthDescription(String expContent) {
		new CommonFunctions().verifyLabelText(lblDescription, "Content", expContent);
	}
	
}
