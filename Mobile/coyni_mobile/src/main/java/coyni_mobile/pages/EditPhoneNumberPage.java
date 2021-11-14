package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditPhoneNumberPage  extends MobileFunctions{
	
	private By heading = MobileBy.xpath("");
	private By txtCurrentPhoneNumber =MobileBy.xpath("");
	private By txtPhoneNumber =MobileBy.xpath("");
	private By lnkContactUs =MobileBy.xpath("");
	private By btnSave =MobileBy.xpath("");
	 private By IconBack =MobileBy.xpath("");
	 private By lblDontHaveAccess =MobileBy.xpath("");
	 public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "edit PhoneNumber", expHeading);
		 }
	    public void verifyCurrentPhoneNumber(String expPhoneNumber) {
	    	new CommonFunctions().verifyLabelText(txtCurrentPhoneNumber, "Current PhoneNumber", expPhoneNumber);
	    }

	    public void fillPhoneNumber(String phoneNumber) {
	    	enterText(txtPhoneNumber, phoneNumber, "phone Number");
	    }
	    public void clickContactUs() {
	    	click(lnkContactUs, "Click Contact us");
	    }
	    public void clickSave() {
	    	click(btnSave, "Click Save");
	    }
//	    public void clickBackIcon() {
//	    	click(IconBack, "Click Back Icon");
//	    	
//	    }
	    public void verifyContactUsView() {
	    	new CommonFunctions().elementView(lnkContactUs, "Contact Us");
	    }
	    public void verifyDontHaveAccessView() {
	    	new CommonFunctions().elementView(lblDontHaveAccess, "Dont Have Access");
	    }
	    public NavigationComponent navigationComponent() {
	    	return new NavigationComponent();	
	    	}
	    public VerifyCurrentPhoneNumber verifyCurrentPhoneNumber() {
	    	return new VerifyCurrentPhoneNumber();
	    }

}
