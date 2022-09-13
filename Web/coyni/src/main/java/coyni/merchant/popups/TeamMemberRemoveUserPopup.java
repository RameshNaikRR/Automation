package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TeamMemberRemoveUserPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//p[contains(text(),'Are You Sure You Want')]");
	private By lblDescription = By.xpath("//p[contains(text(),'will be permanently ')]");
	private By btnRemove = By.xpath("//button[contains(text(),'Remove')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Remove User", expHeading);
	}

	public void getDescription() {
		String desc = getText(lblDescription, "Description");
		ExtentTestManager.setInfoMessageInReport("Description : " + desc);
	}

	public void clickRemove() {
		click(btnRemove, "Remove");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
