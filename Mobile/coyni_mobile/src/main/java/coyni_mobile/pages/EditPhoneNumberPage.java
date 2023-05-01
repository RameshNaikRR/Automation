package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditPhoneNumberPage extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[contains(@text,'Edit Phone')]");
	private By txtCurrentPhone = MobileBy.xpath("(//*[contains(@resource-id,'pnET')])[1]");
	private By txtNewPhone = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By lblDontHaveAccess = MobileBy.xpath("//*[contains(@text,'access')]");
	private By lnkContactUs = MobileBy.xpath("//*[@text='Contact Us']");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'save')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void verifyCurrentPhoneNumber(String expPhone) {
		String value = getAttribute(txtCurrentPhone, "text");
		if (value.equalsIgnoreCase(expPhone)) {
			ExtentTestManager.setPassMessageInReport("Current Phone Number is " + expPhone);
		} else {
			ExtentTestManager.setFailMessageInReport("Current Phone Number is not " + expPhone);
		}
	}
	  public void verifyEditPhonePageView() {
	    	new CommonFunctions().elementView(heading, "Edit Phone Page");
	    }

	public void fillNewPhoneNumber(String newPhone) {
		enterText(txtNewPhone, newPhone, "New Phone Number");
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

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public VerifyPhoneNumberPage verifyPhoneNumberPage() {
		return new VerifyPhoneNumberPage();
	}

}
