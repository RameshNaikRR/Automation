package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditEmailPage extends MobileFunctions{
	 private By heading = MobileBy.xpath("");
	 private By txtCurrentEmail =MobileBy.xpath("");
	 private By txtNewEmail =MobileBy.xpath("");
	 private By lblDontHaveAccess =MobileBy.xpath("");
     private By lnkContactUs =MobileBy.xpath("");
	 private By btnSave =MobileBy.xpath("");
	 //private By IconBack =MobileBy.xpath("");

	 
	 public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Edit Email", expHeading);
	 }
    public void verifyCurrentEmail(String expEmail) {
    	new CommonFunctions().verifyLabelText(txtCurrentEmail, "Current Email", expEmail);
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
    	click(btnSave, "Click Done");
    }
//    public void clickBackIcon() {
//    	click(IconBack, "Click Back Icon");
//    	
//    }
    public VerifyCurrentEmailPage verifyCurrentEmailPage() {
    	return new VerifyCurrentEmailPage();
    }
    
    public NavigationComponent navigationComponent() {
    	return new NavigationComponent();	
    	}
}
