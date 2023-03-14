package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CoyniEmployeeComponent extends BrowserFunctions {
	
	private By btnNewEmployee=By.xpath("//button[text()='New Employee']");
	
	
	
	public void clickNewEmployeeBtn() {
		new CommonFunctions().verifyCursorAction(btnNewEmployee, "new Employee Button");
		click(btnNewEmployee, "new Employee Button");
		
	}
	public AddNewEmployeeComponent addNewEmployeeComponent() {
		return new AddNewEmployeeComponent();
	}

}
