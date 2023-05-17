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
	private By popUperror = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'tvAction')]");
	private By lblNeedHelpHeading = MobileBy.xpath("//*[@text='Need help with coyni?']");

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

	public void clickContactUs(String expHeading) {
		click(lnkContactUs, "Click Contact us");
		new CommonFunctions().verifyLabelText(lblNeedHelpHeading, "Contact us Heading",expHeading);
	}

	public void verifyContactUsView() {
		new CommonFunctions().elementView(lnkContactUs, "Contact Us");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}
	public void clickOk() {
		//new CommonFunctions().verifyLabelText(lblErrMsg, "Error", expError);
		click(btnOk, "Ok");
	}
	public void verifyPopupMsg(String expText) {
		new CommonFunctions().verifyLabelText(popUperror, "PopupMessage", expText);
		
	}
	public VerifyEmailPage verifyEmailPage() {
		return new VerifyEmailPage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
