package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class RemoveProfileImagePopup extends BrowserFunctions {
	private By heading = By.cssSelector(".UserDetails_container__50Pke>h1");
	private By btnRemoveImage = By.xpath("//button[text()='Remove']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}
	public void clickRemoveImage() {
		new CommonFunctions().verifyCursorAction(btnRemoveImage, "Remove Button");
		click(btnRemoveImage, "Remove Button");
	}
	public void verifyRemoveView() {
		new CommonFunctions().elementView(btnRemoveImage, "Remove Button");
		new CommonFunctions().verifyCursorAction(btnRemoveImage, "Remove Button");
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
