package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditEmailPage extends MobileFunctions {
	private By heading = MobileBy.xpath("//*[@name='Edit Email']");
	private By txtCurrentEmail = MobileBy.xpath("//*[@name='Current Email']");
	private By txtNewEmail = MobileBy.xpath("//*[@name='Enter New Email']");
	private By lblDontHaveAccess = MobileBy.xpath("//*[contains(@name,'access')]");
	private By lnkContactUs = MobileBy.xpath("(//*[@name='Contact Us'])[1]");
	private By btnSave = MobileBy.xpath("(//*[@name='Save'])[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void verifyCurrentEmail(String expEmail) {
		String value = getAttribute(txtCurrentEmail, "value");
		if (value.equalsIgnoreCase(expEmail)) {
			ExtentTestManager.setPassMessageInReport("Current email is " + expEmail);
		} else {
			ExtentTestManager.setFailMessageInReport("Current email is not " + expEmail);
		}
	}

	public void fillNewEmail(String newEmail) {
		enterText(txtNewEmail, newEmail, "New Email");
	}

	public void verifyDontHaveAccessView() {
		new CommonFunctions().elementView(lblDontHaveAccess, "Dont Have Access");
	}

	public void clickContactUs() {
		click(lnkContactUs, "Click Contact us");
	}

	public void verifyContactUsView() {
		new CommonFunctions().elementView(lnkContactUs, "Contact Us");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public VerifyEmailPage verifyEmailPage() {
		return new VerifyEmailPage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
