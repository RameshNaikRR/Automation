package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.MailingAddressComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditProfilePage extends MobileFunctions{
//	private By heading =MobileBy.xpath("//*[@name='Edit Address']");
//	private By heading =MobileBy.AccessibilityId("Edit Address");
	
	private By lblEditAddress = MobileBy.AccessibilityId("");
//	private By txtCountryDropdown = MobileBy.AccessibilityId("");
//	private By txtSearch = MobileBy.AccessibilityId("");
//	
	
	
	
	
	
	
	
	
	
	
	
	private By btnSave =MobileBy.xpath("(//*[@name='Save'])[1]");
	
	public void clickSave() {
		click(btnSave, "Click Save");
	}
	
//	public void verifyHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
//	}
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	

}
