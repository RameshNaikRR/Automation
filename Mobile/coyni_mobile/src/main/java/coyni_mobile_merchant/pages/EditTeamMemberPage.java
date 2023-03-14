package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.ToastComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditTeamMemberPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Team Member')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Administrator')]");
	private By lblDesc2 = MobileBy.xpath("//*[contains(@text,'Full administrator permission')]");
	private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id,'editFNameET')]");
	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'editLNameET')]");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'editEmailET')]");
	private By txtPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By lblNoteMsg = MobileBy.xpath("//*[contains(@text,' New team members ')]");
	private By btnSend = MobileBy.xpath("//*[contains(@text,'Send')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'backBtn')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Edit Team Member Heading", expHeading);
	}

	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Edit Team Member Description", expDescription);
	}

	public void getAdministratorDesc() {
		String str = getText(lblDesc2);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void fillFirstName(String expFirstName) {
		new CommonFunctions().verifyAutoFocusElement(txtFirstName, "First Name");
		click(txtFirstName, "First Name");
		enterText(txtFirstName, expFirstName, "First Name");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillLastName(String expLastName) {
		click(txtLastName, "Last Name");
		enterText(txtLastName, expLastName, "Last Name");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillEmail(String expEmail) {
		click(txtEmail, "txtEmail");
		enterText(txtEmail, expEmail, "txtEmail");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillPhoneNumber(String expPhoneNumber) {
		click(txtPhoneNumber, "txtPhoneNumber");
		enterText(txtPhoneNumber, expPhoneNumber, "Phone Number");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void getNoteMsg() {
		String str = getText(lblNoteMsg);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickSend() {
		click(btnSend, "Send");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
