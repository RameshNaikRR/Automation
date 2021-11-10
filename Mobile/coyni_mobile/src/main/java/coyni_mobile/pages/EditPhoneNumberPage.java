package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditPhoneNumberPage  extends MobileFunctions{
	
	private By heading = MobileBy.xpath("");
	private By txtCurrentPhoneNumber =MobileBy.xpath("");
	private By txtPhoneNumber =MobileBy.xpath("");
	private By lnkContactUs =MobileBy.xpath("");
	private By btnSave =MobileBy.xpath("");
	 private By IconBack =MobileBy.xpath("");
	 
	 public void verifyHeading(String expHeading) {
			
		 }
	    public void verifyCurrentPhoneNumber(String expPhoneNumber) {
	    	
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
	    public void clickBackIcon() {
	    	click(IconBack, "Click Back Icon");
	    	
	    }

}
