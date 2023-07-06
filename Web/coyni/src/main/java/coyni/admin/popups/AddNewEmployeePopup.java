package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewEmployeePopup extends BrowserFunctions {
	private By heading = By.xpath("");
	private By description = By.xpath("");
	private By lblContactInfo = By.xpath("");
	private By lbldepartAndpermission = By.xpath("");
	private By firstName = By.xpath("");
	private By lastName = By.xpath("");
	private By email = By.xpath("");
	private By phoneNumber = By.xpath("");
	private By lnkViewPermissions = By.xpath("");
	private By clickSendInvitation = By.xpath("");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is:", Heading);
	}

	public void verifydescription(String Description) {
		new CommonFunctions().verifyLabelText(description, "Description is :", Description);
	}

	public void verifyContactInfo(String contactInfo) {
		new CommonFunctions().verifyLabelText(lblContactInfo, "Contact Info:", contactInfo);
	}

	public void enterFirstName(String enterfirstName) {
		enterText(firstName, "First Name:", enterfirstName);
	}

	public void enterLastName(String enterLastName) {
		enterText(lastName, "Last Name:", enterLastName);
	}

	public void enterEmail(String emailAddress) {
		enterText(email, "Email is:", emailAddress);
	}

	public void enterPhoneNumber(String phone) {
		enterText(phoneNumber, "Phone Number:", phone);
	}

	public void verifyDepartmentAndpermission(String departmentAndpermission) {
		new CommonFunctions().verifyLabelText(lbldepartAndpermission, "Department And permission:",
				departmentAndpermission);
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

	public void clickViewPermissions() {
		click(lnkViewPermissions, "view permissions");
	}

	public void clickSendInvitation() {
		click(clickSendInvitation, "Send Invitation");
	}
}
