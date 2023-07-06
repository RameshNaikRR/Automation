package coyni.admin.popups;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NoBankAccountExist extends BrowserFunctions {
	private By heading = By.xpath("");
	private By description = By.xpath("");
	private By clickbank = By.xpath("");
	private By clickClose = By.xpath("");

	public void verifyHeading(String bankHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is :", bankHeading);
	}

	public void verifyDescription(String bankDesription) {
		new CommonFunctions().verifyLabelText(description, "Description is :", bankDesription);
	}

	public void clickClose() {
		click(clickClose, "Close");
	}

	public void clickbank() {
		click(clickbank, "Bank");
	}

}
