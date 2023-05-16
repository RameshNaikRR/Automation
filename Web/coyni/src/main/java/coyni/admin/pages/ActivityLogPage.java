package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ActivityLogPage extends BrowserFunctions{
	
	private By lblActivityLog = By.xpath("");
	
	public void verifyActivityLog(String expHeading) {
		new CommonFunctions().verifyLabelText(lblActivityLog, "Heading is: ", expHeading);
	}

}
