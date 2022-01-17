package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditEmailPage extends MobileFunctions {
	private By heading = MobileBy.xpath("//*[@text='Edit Email']");
	private By txtCurrentEmail = MobileBy.xpath("//*[contains(@resource-id,'currentEmailET')]");
	private By txtNewEmail = MobileBy.xpath("//*[contains(@resource-id,'newEmailET')]");
	private By lblDontHaveAccess = MobileBy.xpath("//*[contains(@text,'access')]");
	private By lnkContactUs = MobileBy.xpath("//*[@text='Contact Us']");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'saveEmailCV')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}
    public void verifyEditEmailPageView() {
    	new CommonFunctions().elementView(heading, "Edit Email Page");
    }
	public void verifyCurrentEmail(String expEmail) {
		String value = getAttribute(txtCurrentEmail, "text");
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
