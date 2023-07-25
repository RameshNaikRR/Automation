package coyni.business.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WeFoundYourAccountComponent extends BrowserFunctions {

	private By lblAccountHeading = By.xpath("");
	private By btnCustomerName = By.xpath("");
	private By lnkBacktoLogin = By.xpath("//div[text()='Back to Login']");

	public void verifyAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAccountHeading, "Account Heading is: ", expHeading);
	}

	public void clickCustomerName() {
		click(btnCustomerName, "Customer Name");
	}

	public void clickBacktoLogin() {
		click(lnkBacktoLogin, "Back to Login");
	}

}
