package coyni.admin.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UserDetailsComponent extends BrowserFunctions {

	private By lblUserDetailsHeading = By
			.xpath("//div[contains(@class,'UserDetails_container')]//.//span[text()='User Details']");
	private By lblUserName = By.xpath("(//div[contains(@class,'UserDetails_group2')]//p)[1]");
	private By lblAccountStatus = By.xpath("//div[contains(@class,'UserDetails')]//span[text()='Active']");
	private By lblAccountID = By
			.xpath("//div[contains(@class,'UserDetails_group2')]//p[contains(@class,'UserDetails_accountID')]");
	private By lblPhoneNumber = By.xpath("(//div[contains(@class,'flex-row')]//h3)[1]");
	private By lblEmail = By.xpath("(//div[contains(@class,'flex-row')]//h3)[2]");
	private By lblAddress = By.xpath(
			"//h3[contains(@class,'text-cgy4 tracking-wide Heading_heading3__EO4gE font-semibold italic text-cgy8 leading-3 tracking-tightest pl-2')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblUserDetailsHeading, "Heading", expHeading);
	}

	public void verifyUserName(String expUserName) {
		new CommonFunctions().verifyLabelText(lblUserName, "User Name", expUserName);
	}

	public void verifyAccountStatus(String expAccountStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", expAccountStatus);
	}

	public void verifyAccountID(String expAccountID) {
		new CommonFunctions().verifyLabelText(lblAccountID, "AccountID", expAccountID);
	}

	public void getPhoneNumber() {
		ExtentTestManager.setInfoMessageInReport("Phone Number: " + getText(lblPhoneNumber, ""));
	}

	public void getEmail() {
		ExtentTestManager.setInfoMessageInReport("Email: " + getText(lblEmail, ""));
	}

	public void getAddress() {
		ExtentTestManager.setInfoMessageInReport("Address: " + getText(lblAddress, ""));
	}

}
