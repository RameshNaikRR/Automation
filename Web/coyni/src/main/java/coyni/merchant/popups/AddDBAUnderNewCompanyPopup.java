package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddDBAUnderNewCompanyPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Add DBA Under New Company']");

	private By btnAddDBA = By.xpath("//button[text()='Add DBA']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add DBA Under New Company", expHeading);
	}

	public void clickAddDBA() {
		click(btnAddDBA, "Add DBA");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
