package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.SuccessFailureComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class RemovePaymentMethodPopup extends BrowserFunctions {

	private By btnRemove = By.xpath("//button[text()='Remove']");
	private By heading = By.xpath("//h1[text()='Remove Payment Method']");
	private By btnDelete = By.xpath("//button[@data-tip='Delete'][1]");

	public void clickOnRemove() {
		click(btnRemove, "Click Remove");
	}

	public void clickDeleteCard() {
		click(btnDelete, "click Delete");
	}

	public void verifyRemoveHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, expHeading, "Remove Payment Method");
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

}
