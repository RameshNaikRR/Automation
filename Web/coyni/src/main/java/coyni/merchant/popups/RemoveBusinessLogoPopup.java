package coyni.merchant.popups;

import org.openqa.selenium.By;
import coyni.merchant.components.NavigationComponent;
import ilabs.WebFramework.BrowserFunctions;

public class RemoveBusinessLogoPopup extends BrowserFunctions {

	private By btnRemove = By.xpath("//button[contains(text(),'Remove')]");

	public void clickRemove() {
		click(btnRemove, "Remove");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
