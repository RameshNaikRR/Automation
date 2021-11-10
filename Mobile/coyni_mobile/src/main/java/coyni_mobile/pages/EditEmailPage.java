package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditEmailPage extends MobileFunctions{
	 private By heading = MobileBy.xpath("");
	 private By txtCurrentEmail =MobileBy.xpath("");
	 private By txtNewEmail =MobileBy.xpath("");
     private By lnkContactUs =MobileBy.xpath("");
	 private By btnDone =MobileBy.xpath("");
	 private By IconBack =MobileBy.xpath("");

	 
	 public void verifyHeading(String expHeading) {
		// new CommonFunctions().verifyLabelText(expHeading, expHeading, expHeading);
	 }
    public void verifyCurrentEmail(String expEmail) {
    	//new CommonFunctions().verifyLabelText(expEmail, expEmail, expEmail);
    }

    public void fillNewEmail(String newEmail) {
    	enterText(txtNewEmail, newEmail, "New Email");
    }
    public void clickContactUs() {
    	click(lnkContactUs, "Click Contact us");
    }
    public void clickDone() {
    	click(btnDone, "Click Done");
    }
    public void clickBackIcon() {
    	click(IconBack, "Click Back Icon");
    	
    }
    public VerifyCurrentEmailPage verifyCurrentEmailPage() {
    	return new VerifyCurrentEmailPage();
    }
}
