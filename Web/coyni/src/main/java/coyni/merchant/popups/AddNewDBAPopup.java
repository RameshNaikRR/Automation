package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewDBAPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Add New DBA']");

	private By drpDownSelectCompany = By.xpath("//div[text()='Select Company']/parent::div");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add DBA Business", expHeading);
	}

	public By getElement(String state) {
		return By.xpath(String.format("//div[text()='%s']", state));
	}

	public void selectCompany(String state) {
		click(drpDownSelectCompany, "Select Company DropDown");
		click(getElement(state), state);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
