package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ResendInvitationPopup extends BrowserFunctions {
	private By heading = By.xpath("");
	private By description = By.xpath("");
	private By email = By.xpath("");
	private By department = By.xpath("");
	private By permissionRole = By.xpath("");
	private By phoneNumber = By.xpath("");
	private By clickResend = By.xpath("");
	private By clickClose = By.xpath("");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is:", Heading);
	}

	public void verifydescription(String Description) {
		new CommonFunctions().verifyLabelText(description, "Description is :", Description);
	}

	public void enterEmail(String emailAddress) {
		enterText(email, "Email is:", emailAddress);
	}

	public By getElement1(String department) {
		return By.xpath(String.format("//div[text()='%s']", department));
	}

	public void selectDepartment(String departmentAdd) {
	}

	public By getElement(String permissionRole) {
		return By.xpath(String.format("//div[text()='%s']", permissionRole));
	}

	public void selectPermissionRole(String PermissionRole) {

	}

	public void enterPhoneNumber(String phone) {
		enterText(phoneNumber, "Phone Number:", phone);
	}

	public void clickResend() {
		click(clickResend, "Resend");
	}

	public void clickClose() {
		click(clickClose, "Close");
	}
}
