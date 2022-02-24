package coyni.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import ilabs.WebFramework.BrowserFunctions;

public class AddCoyniEmployeePage  extends BrowserFunctions{
	private By lblHeading = By.cssSelector(".title-container>span");
	private By lblEmployeeDetails =By.xpath("//span[.='New Employee Details']");
	private By txtFirstName= By.cssSelector("#firstName");
	private By txtLastName =By.cssSelector("#lastName");
	private By txtEmail =By.cssSelector("#email");
	private By txtPhoneNumber = By.cssSelector("#Phone_Number");
	private By drpdwnDepartment = By.cssSelector("div[class*='selected_option']");
	
	private By lblPermissionRoles =By.xpath("//span[.='Permission Roles']");
	private By lblPermissionDes =By.xpath("//p[contains(.,'below')]");
	private By btnAddPermission = By.xpath("//button[.='+ Add Permission Role']");
	
	
	
	
	
	private By getPermissionRole(String permissionRole) {
		return By.xpath(String.format("//p[contains(@class,'GreenBoxUserForm_role_name') and text()='%s']", permissionRole));
	}
	
	

}
