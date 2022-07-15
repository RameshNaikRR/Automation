package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddCustomRolePopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Add Custom Role']");
	private By txtRoleName = By.xpath("//input[@name='roleName']");
	private By btnAdd = By.xpath("//button[@type='submit']");
	private By lnkGoBack = By.xpath("//span[text()='No, go back']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add Custom Role", expHeading);
	}

	public void verifyRoleName(String expRoleName) {
		enterText(txtRoleName, "Role Name", expRoleName);
	}

	public void clickAdd() {
		click(btnAdd, "Add");
	}

	public void clickGoBack() {
		click(lnkGoBack, "Go Back");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
