package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CardAddedSuccessfullyPopup extends BrowserFunctions {
	private By heading = By.xpath("//h1[text()='Card Added Successfully']");
	private By btnDone = By.xpath("//button[text()='Done']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Card Added", expHeading);
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
