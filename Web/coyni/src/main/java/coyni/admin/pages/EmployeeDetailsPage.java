package coyni.admin.pages;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class EmployeeDetailsPage extends BrowserFunctions{
	
	private By ddDepartment = By.className("FormField_selected_option__7Rw29");
	private By lblEmpID=By.className("GreenBoxUserForm_employeeId__vcGPI");
	private By btnCancelInvitation=By.xpath("//div[text()='Cancel Invitation']");//button[text()='Remove User']");
	private By lblAccStatus=By.xpath("//div[contains(@class,'GreenBoxUserForm_chip__GjzTa')]//div[contains(@class,'chip__text')]");
	private By lblPermissionRole=By.xpath("//p[text()='Permission Role:']//span");
	private By lblPhoneNum=By.xpath("(//div[contains(@class,'GreenBoxUserForm_phone_field__dJWkD')]//h3[@id=''])[1]");
	private By lblEmail=By.xpath("(//div[contains(@class,'GreenBoxUserForm_phone_field__dJWkD')]//h3[@id=''])[2]");
	private By btnRemoveUser=By.xpath("//button[text()='Remove User']");
	
	
	public String getDeptName() {
		return getText(ddDepartment, "department");
	}
	public String getEmpID() {
		return getText(lblEmpID, "Employee ID");
	}
	public String getAccStatus() {
		return getText(lblAccStatus, "Account status");
	}
	public void clickRemoveUser() {
		click(btnRemoveUser, "Remove User");
	}
	public void clickCancelInvitation() {
		click(btnCancelInvitation, "Cancel Invitation");
	}
	public String getPermissionRole() {
		return getText(lblPermissionRole, "Permission role");
	}
	public String getEmail() {
		return getText(lblEmail, "Email").trim();
	}
	public String getPhoneNum() {
		String ph = getText(lblPhoneNum, "phone number").trim();
		String phoneNumber = ph.replaceAll("[^0-9]", "");
		return phoneNumber;
	}
	
	
	

}
