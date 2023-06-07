package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessApplicationRegistrationStartPage extends BrowserFunctions {
	
	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By btnStartApplication = By.xpath("");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}
	public void verifyDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description is: ", expDes);
	}
	public void clickStartApplication() {
		click(btnStartApplication, "Start Application");
	}
	public BusinessInformationPage businessInformationPage() {
		return new BusinessInformationPage();
	}
	
	
	
}
