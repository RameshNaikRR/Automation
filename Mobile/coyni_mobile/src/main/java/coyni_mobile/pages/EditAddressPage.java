package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.MailingAddressComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditAddressPage extends MobileFunctions{
	private By heading =MobileBy.xpath("//*[@text='Edit Address']");
	private By btnSave =MobileBy.xpath("//*[contains(@resource-id,'SaveC')]");
	
	public void clickSave() {
		click(btnSave, "Click Save");
	}
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	

}
