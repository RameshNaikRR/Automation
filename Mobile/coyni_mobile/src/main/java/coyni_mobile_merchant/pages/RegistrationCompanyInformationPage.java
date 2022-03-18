package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class RegistrationCompanyInformationPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("");
	
	
	
	
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading",expHeading);
	}
	

}
