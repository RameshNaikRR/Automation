package coyni_mobile_merchant.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditDetailsComponent extends MobileFunctions {
	private By lblEditComponentHeading = MobileBy
			.xpath("//*[contains(@text,'Edit Email')]|//*[contains(@text,'Edit Phone Number')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'CloseLL')]");
	private By btnSave = MobileBy.xpath("//*[contains(@text,'Save')]");
	private By txtComponent = MobileBy
			.xpath("//*[contains(@resource-id,'b_newEmailET')]|//*[contains(@resource-id,'pnET')]");
	private By lblErrorMsgHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblErrorMsg = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By lblSucessMsg = MobileBy.xpath("//*[contains(@resource-id,'toastTV')]");

	public void clickSave() {
		
		click(btnSave, "Save");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

	public void verifyToastMsg(String expHeading) {
//		ExtentTestManager.setInfoMessageInReport("Toast Message : " + getText(lblSucessMsg));
		new CommonFunctions().verifyLabelText(lblSucessMsg, "Toast Message", expHeading);
	}

	public void verifyEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEditComponentHeading, " Email Heading ", expHeading);
	}

	public void verifyPhoneNumberHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEditComponentHeading, " Phone Number Heading ", expHeading);
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void fillEmail(String email) {
		click(txtComponent, email);
		enterText(txtComponent, email, "Email");
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtComponent, phoneNumber, "Phone Number");
	}

	public void verifyErrorMsgHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblErrorMsgHeading, "Error Message Heading", expHeading);
	}

	public void verifyErrorMsg(String expErrMsg) {
		new CommonFunctions().verifyLabelText(lblErrorMsg, "Invalid Email Error Message", expErrMsg);
	}

	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}

}
