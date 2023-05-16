package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessInformationPage extends BrowserFunctions{
	
	private By lblBusinessInformation = By.xpath("");
	private By lnkEdit = By.xpath("");
	
	public void verifyBusinessInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBusinessInformation, "Heading is: ", expHeading);
	}
	public void clickEdit() {
		click(lnkEdit, "Edit");
	}

}
