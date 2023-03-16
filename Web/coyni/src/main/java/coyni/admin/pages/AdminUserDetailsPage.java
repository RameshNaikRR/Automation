package coyni.admin.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.admin.popups.AccountProfileImagePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AdminUserDetailsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Admin User Details']");
	private By lblName = By.xpath("//span[@class='text-2xl font-bold text-cgy8']");
	private By lblAcountID = By.xpath("//span[@class='mt-1 text-xs text-cgy3']");
	private By lnkChangePassword = By.xpath("//span[text()='Change Password']");
	private By lblChangePasswordHeading = By
			.xpath("//div[(contains(@class,'AdminProfile'))]//span[text()='Change Password']");
	private By lblChangePasswordDesc = By.xpath("//span[@class='mt-2 text-sm text-cgy13']");
	private By txtCurrentPassword = By.xpath("//input[@id='CurrentPassword']");
	private By txtNewPassword = By.xpath("//input[@id='NewPassword']");
	private By txtConfirmPassword = By.xpath("//input[@id='ConfirmNewPassword']");
	private By iconEyeCurrentPassword = By.xpath("(//button[contains(@class,'icon-button')])[1]");
	private By iconEyeConfirmPassword = By.xpath("(//button[contains(@class,'icon-button')])[3]");
	private By iconEyeNewPassword = By.xpath("(//button[contains(@class,'icon-button')])[2]");
	private By reddot = By.cssSelector(".red-dot");
	private By greendot = By.xpath("//span[@class='green-dot']/parent::span");
	private By greendot1 = By.xpath("(//span[@class='green-dot']/parent::span)[2]");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By lblPasswordSuccessMsgHeading = By.xpath("");
	private By lblPasswordSuccessMsgDesc = By.xpath("");
	private By btneditImage = By.xpath("//img[@class='w-4 h-4']");
	private By lnkChangePasswordlink = By.xpath("//button[contains(text(),'Change Password')]");

	public void clickChangePasswordLink() {
		new CommonFunctions().verifyCursorAction(lnkChangePasswordlink, "Change Password");
		// click(lnkChangePasswordlink, "Change Password");
	}

	public By getUserDetails(String Type) {
		return By.xpath(String.format("//span[text()='%s']/following-sibling::*[1]/div/span", Type));
	}

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyName() {
		new CommonFunctions().elementView(lblName, "Name");
	}

	public void verifyAccountId(String expId) {
		String actId = getText(lblAcountID, "Account Id");
		if (actId.equals(expId)) {
			ExtentTestManager.setPassMessageInReport("Account Id is Matched");
		} else {
			ExtentTestManager.setWarningMessageInReport("Account Id is not Matched");
		}
	}

	public void getPhoneNumer(String expPhoneNumber) {
		ExtentTestManager.setInfoMessageInReport("Phone Number is " + getText(getUserDetails("Phone Number"), ""));
//		String str = getText(getUserDetails(expPhoneNumber),"Phone Number");
//		//new CommonFunctions().verifyLabelTextContains(getUserDetails(Type), expPhoneNumber, "Phone Number");
//		ExtentTestManager.setPassMessageInReport("Phone Number is"+str);
	}

	public void getEmailAddress(String expEmailAddress) {
		String str = getText(getUserDetails("Email Address"), "");
		// new CommonFunctions().verifyLabelTextContains(getUserDetails("Email
		// Address"), expexpEmailAddress, "Email Adress");
		ExtentTestManager.setInfoMessageInReport("Email Address is" + str);
	}

	public void getEmployeeDept(String expEmployeeDept) {
		String str = getText(getUserDetails("Employee Department"), "");
		// new CommonFunctions().verifyLabelTextContains(getUserDetails("Employee
		// Department"), expEmployeeDept, "Employee Department");
		ExtentTestManager.setInfoMessageInReport("Employee Department is" + str);
	}

	public void getPermission(String PermissionRole) {
		String str = getText(getUserDetails("Permission Role"), "");
		// new CommonFunctions().verifyLabelTextContains(getUserDetails("Permission
		// Role"), expPermissionRole, "Employee Department");
		ExtentTestManager.setInfoMessageInReport("Permission Role" + str);
	}

	public void clickChangePassword() {
		click(lnkChangePassword, "Change Password");
	}

	public void fillNewPsw(String newPassword) {
		enterText(txtNewPassword, newPassword, "New Password");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public void verifyChangePasswordHeading() {
		new CommonFunctions().elementView(lblChangePasswordHeading, "Change PAssword Heading");
	}

	public void verifyChangePasswordDescp() {
		new CommonFunctions().elementView(lblChangePasswordDesc, "ChangePassword");
	}

	public void fillCurrentPassword(String expCurrentPassword) {
		new CommonFunctions().verifyAutoFocus(txtCurrentPassword, "Current Password");
		enterText(txtCurrentPassword, expCurrentPassword, "Current password");
	}

	public void fillNewPassword(String newPassword) throws InterruptedException {
		String[] inputs = { "H", "h", "qazwsxeh", "qazwsxedcrfv", "@", "1" };
		String[] messages = { "uppercase", "lowercase", "total characters", "total characters", "special character",
				"number" };
		for (int i = 0; i < inputs.length; i++) {
			enterText(txtNewPassword, inputs[i], "New Password");
			String text = "";
			if (inputs[i].length() >= 8) {
				text = getText(greendot1, "Validation Dot");
			} else {
				text = getText(greendot, "Validation Dot");
			}
			if (text.toLowerCase().contains(messages[i])) {
				ExtentTestManager.setPassMessageInReport("Password field satisifies strength condition : " + text);
			} else {
				ExtentTestManager
						.setFailMessageInReport("Password field does not satisifies strength condition : " + text);
			}
//			new CommonFunctions().clearText(txtCreatePassword, "Create Password");

			clearText(txtNewPassword, "Create Password");
		}
		int initialRedDot = getElementsList(reddot, "red dot").size();
		Thread.sleep(100);
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		Thread.sleep(100);
		enterText(txtNewPassword, newPassword, "Create Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		System.out.println("value: " + initialRedDot + " " + initialGreenDot + " " + finalRedDot + " " + finalGreenDot);
		if (initialGreenDot == finalRedDot && initialRedDot == finalGreenDot && finalRedDot == initialGreenDot
				&& finalGreenDot == initialRedDot) {
			String NewPassword = getText(txtNewPassword, "CreatePassword");
			ExtentTestManager.setPassMessageInReport("password is valid");
		} else {
			ExtentTestManager.setFailMessageInReport("password is invalid");
		}
	}

	public void fillConfirmPassword(String expConfirmPassword) {
		enterText(txtConfirmPassword, expConfirmPassword, "Confirm Password");
	}

	public void clickEyeIconCurrentPassword() {
		click(iconEyeCurrentPassword, "Icon Eye Current Password ");
	}

	public void clickEyeIconNewPassword() {
		click(iconEyeNewPassword, "Icon Eye New Password");
	}

	public void clickEyeIconConfirmPassword() {
		click(iconEyeConfirmPassword, "Icon Eye Confirm Password");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void verifyPasswordUpadteSuccesMsg(String expPasswordMsgHeading) {
		new CommonFunctions().verifyLabelText(lblPasswordSuccessMsgHeading, "Password upadte Message Heading",
				expPasswordMsgHeading);
	}

	public void verifyPasswordUpdateSucessDescp(String expPasswordUpdatDescp) {
		new CommonFunctions().verifyLabelText(lblPasswordSuccessMsgDesc, "Password Update Description",
				expPasswordUpdatDescp);

	}

	public void clickEditImage() {
		click(btneditImage, "Edit Image");
	}

	public AccountProfileImagePopup accountProfileImagePopup() {
		return new AccountProfileImagePopup();
	}

	public void clickOutSide() {
		new CommonFunctions().clickOutSideElement();
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(iconEyeCurrentPassword, attribute, password);
		if (attributeValue.contains("password")) {

			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}
}
