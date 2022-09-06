package coyni.checkout;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CancelTransactionPopup extends BrowserFunctions {

	private By heading = By.xpath("//h6[contains(text(),'Cancel Transaction')]");
	private By lblDescription = By.xpath("//p[contains(text(),'Are you sure you want')]");
	private By btnYes = By.xpath("//button[contains(text(),'Yes')]");
	private By btnNoGoBack = By.xpath("//button[contains(text(),'No, go back')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Cancel Transaction Heading", expHeading);
	}

	public String getDescription() {
		return getText(lblDescription, "Description");

	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void clickNo() {
		click(btnNoGoBack, "No");
	}

}
