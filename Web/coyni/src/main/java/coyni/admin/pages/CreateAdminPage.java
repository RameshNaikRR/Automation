package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CreateAdminPage extends BrowserFunctions{

	private By heading = By.xpath("");
	private By txtFirstName = By.xpath("");
	private By txtLastName = By.xpath("");
	private By txtPhoneNumber = By.xpath("");
	private By txtEmail = By.xpath("");
	private By txtEmployementDept = By.xpath("");
	private By txtPermissonRole = By.xpath("");
	private By txtCreatePassword = By.xpath("");
	private By txtConfirmPassword = By.xpath("");
	private By btnCreate = By.xpath("");
	
	
	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Heading is");
	}
	
	public void fillFirstName(String expFirstName) {
		enterText(txtFirstName, expFirstName, "First Name");
	}
	
	public void fillLastName(String expLastName) {
		enterText(txtLastName, expLastName, "Last Name");
	}
	
	public void fillPhoneNumber(String expPhoneNumber) {
		enterText(txtPhoneNumber, expPhoneNumber, "Phone Number");
	}
	
	public void fillEmail(String expEmail) {
		enterText(txtEmail, expEmail, "Email");
	}
	
	public void fillEmploymentDept(String expEmploymentDept) {
		enterText(txtEmployementDept, expEmploymentDept, "Employment Department");
	}
	
	public void fillPermissionRole(String expPermissionRole) {
		enterText(txtPermissonRole, expPermissionRole, "Permission Role");
	}
	
	public void fillCreatePassword(String expCreatePaasword) {
		enterText(txtCreatePassword, expCreatePaasword,"Create Password");
	}
	
	public void fillConfirmPassword(String expComfirmPaasword) {
		enterText(txtConfirmPassword, expComfirmPaasword, "ComfirmPassw0rd");
	}
	
	public void clickBack() {
		click(btnCreate, "Last Name");
	}
	
}
