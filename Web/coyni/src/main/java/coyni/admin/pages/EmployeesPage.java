package coyni.admin.pages;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class EmployeesPage extends BrowserFunctions {
	private By addNewEmployee = By.xpath("");
	private By clickSearch = By.xpath("");
	private By addPermissionRole = By.xpath("");

	public void clickAddNewEmployee() {
		click(addNewEmployee, "Add New Employee");
	}

	public void clickAddEmployee() {
		click(addPermissionRole, "Permission Role");
	}

	public void clickSearch() {
		click(clickSearch, "Search");
	}

//	public ExportComponent exportComponent() {
//		return new ExportComponent();
//	}
//
//	public FilterComponent filterComponent() {
//		return new FilterComponent();
//	}
}
