package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UserDetailsComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("");
	private By lblUserName = By.xpath("");
	private By lblAccountStatus = By.xpath("");
	private By lblAccountID = By.xpath("");
	private By lblPhoneNumber = By.xpath("");
	private By lblEmail = By.xpath("");
	private By lblAddress = By.xpath("");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
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
		ExtentTestManager.setInfoMessageInReport("Phone Number: "+getText(lblPhoneNumber, ""));
	}
	public void getEmail() {
		ExtentTestManager.setInfoMessageInReport("Email: "+getText(lblEmail, ""));
	}
	public void getAddress() {
		ExtentTestManager.setInfoMessageInReport("Address: "+getText(lblAddress, ""));
	}


}
