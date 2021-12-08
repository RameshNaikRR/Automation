package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class RemoveProfileImagePopup extends BrowserFunctions {
	private By heading = By.cssSelector(".UserDetails_container__50Pke>h1");
	private By btnRemoveImage = By.cssSelector("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void clickOnRemoveImage() {
		click(btnRemoveImage, "Click RemoveImage");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
