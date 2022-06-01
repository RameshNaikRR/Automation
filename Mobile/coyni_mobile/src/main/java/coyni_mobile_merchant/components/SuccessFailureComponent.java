package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By lblSucessfullHeading = MobileBy.xpath("//*[contains(@resource-id,'tvDone')]|//*[contains(@text,' Email Successful')]|//*[contains(@text,'Password Successful')]");
	private By lblSucessfullDescription = MobileBy.xpath("//*[contains(@text,'Your passwo')]|//*[contains(@text,'For security purposes')]|//*[contains(@text,'For security purposes, please log out')]");
	private By btnLogin = MobileBy.xpath("//*[contains(@resource-id,'cvLogin')]");
//	private By lblChangeEmailSucessfullHeading=MobileBy.xpath("//*[contains(@text,'Email Successful')]");
//	private By lblChangeEmailSucessfullDescription=MobileBy.xpath("//*[contains(@text,'log in again through the button below.')]");
	private By btnLogOut=MobileBy.xpath("//*[contains(@resource-id,'EmailLogoutCV')]|//*[contains(@resource-id,'btnCV')]|//*[contains(@resource-id,'Logout')]");


	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessfullHeading,
				"Password Sucessfully Upadated Page Heading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblSucessfullDescription,
				"Password Sucessfully Upadated Page Description", expDescription);
	}

	public void clickLogin() {
		new CommonFunctions().elementView(btnLogin, "Login");
		click(btnLogin, "Login");
	}
//	public void verifyChangeEmailSucessfullHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblChangeEmailSucessfullHeading,
//				"Change Email Sucessfully Upadated Page Heading", expHeading);
//	}
//
//	public void verifyChangeEmailSucessfullDescription(String expDescription) {
//		new CommonFunctions().verifyLabelText(lblChangeEmailSucessfullDescription,
//				"Change Email Upadated Page Description", expDescription);
//	}
	public void clickLogout() {
		scrollDownToElement(btnLogOut, "Log Out");
		new CommonFunctions().elementView(btnLogOut, "Logout");
		click(btnLogOut, "Logout");
	}
}
