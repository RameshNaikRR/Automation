package coyni_mobile_merchant.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.MailingAddressComponent;
import coyni_mobile_merchant.components.ToastComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AddNewTeamMemberPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Add New Team Member')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Administrator')]");
	private By lblDesc2 = MobileBy.xpath("//*[contains(@text,'Full administrator permission')]");
	private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id,'editFNameET')]");
	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'lNameET')]");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'emailIdET')]");
	private By txtPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By lblNoteMsg = MobileBy.xpath("//*[contains(@text,' New team members ')]");
	private By btnSend = MobileBy.xpath("//*[contains(@text,'Send')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'backBtn')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'tvAction')]");
	private By popUpMsg = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add New Team Members Heading", expHeading);
	}

	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Add New Team Members Description", expDescription);
	}

	public void verifyPopUpMsg(String expPopUpMsg) {
		new CommonFunctions().verifyLabelText(popUpMsg, "Pop Up Message", expPopUpMsg);
	}

	public void getAdministratorDesc() {
		String str = getText(lblDesc2);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void fillFirstName(String expFirstName) {
		click(txtFirstName, "First Name");
		enterText(txtFirstName, expFirstName, "First Name");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillLastName(String expLastName) {
		click(txtLastName, "Last Name");
		enterText(txtLastName, expLastName, "Last Name");
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

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void clickOk() {
		click(btnOk, "Ok");
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
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

}
