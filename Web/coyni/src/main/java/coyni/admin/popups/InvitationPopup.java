package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class InvitationPopup extends BrowserFunctions {
	
	private By heading = By.xpath("//h1[text()='Invitation Sent']");
	private By btnDone = By.xpath("//button[text()='Done']");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is", expHeading);
	}
	
	public void clickDone() {
		click(btnDone, "Done");
	}

}
