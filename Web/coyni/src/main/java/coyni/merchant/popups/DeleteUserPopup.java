package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DeleteUserPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//p[contains(text(),'To Remove')]");
	private By lblDescription = By.xpath("//p[contains(text(),'To Remove')]/following-sibling::*");
	private By btnRemove = By.xpath("//button[text()='Remove']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Delete User", expHeading);
	}

	public void clickRemove() {
		click(btnRemove, "Remove");
	}

	public void verifyDescription() {
		String text = getText(lblDescription, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
