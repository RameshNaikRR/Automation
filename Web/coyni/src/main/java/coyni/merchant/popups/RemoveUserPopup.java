package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class RemoveUserPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Remove User']");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By lnkGoBack = By.xpath("//p[text()='No, go back']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Remove User", expHeading);
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void clickGoBack() {
		click(lnkGoBack, "Go Back");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
