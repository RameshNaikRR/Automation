package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class CustomerProfilePage extends MobileFunctions {
	private By lblUserName =MobileBy.xpath("");
	private By lblAccountID =MobileBy.xpath("");
    private By lblAccountStatus =MobileBy.xpath("");
    
    private By lnkUserDetails =MobileBy.xpath("");
    private By lnkPaymentMethods =MobileBy.xpath("");
    private By lnkPreferences =MobileBy.xpath("");
    private By lnkAccountLimits =MobileBy.xpath("");
    private By lnkAgreements=MobileBy.xpath("");
    private By lnkResetPinCode =MobileBy.xpath("");
    private By btnFaceIDSetting =MobileBy.xpath("");
    private By lnkChangePassword =MobileBy.xpath("");
    private By btnLogOut =MobileBy.xpath("");
    
    
    public void verifyUserName(String expUserName) {
    	new CommonFunctions().verifyLabelText(lblUserName, "User Name", expUserName);
    }
    public void verifyAccountID(String expAccountID) {
    	new CommonFunctions().verifyLabelText(lblAccountID, "Account ID", expAccountID);
    }
   public void verifyAccountStatus(String expStatus) {
	   new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", expStatus);
   }
   public void clickUserDetails() {
	   click(lnkUserDetails	, " Click User Details");
   }

   public void clickPaymentMethods() {
	   click(lnkPaymentMethods, "Click Payment Methods");
   }
   public void clickPreferences() {
	   click(lnkPreferences, "Click Preferences");
   }
   public void clickAccountLimits() {
	   click(lnkAccountLimits, "click Account limits");
   }
   public void clickAgreements() {
	   click(lnkAgreements, "Click Agreements");
   }
   public void clickResetPinCode() {
	   click(lnkResetPinCode, "Click Reset Pin Code");
   }
   public void clickFaceIDSetting() {
	   click(btnFaceIDSetting, "Click FaceID Setting");
   }
   public void clickChangePassword() {
	   click(lnkChangePassword, "Click Change Password");
   }
   public void clickLogOut() {
	   click(btnLogOut, "Click LogOut");
   }
   public void verifyProfilePageView() {
	   new CommonFunctions().elementView(lblUserName, "UserName");
   }
   
   public void verifyUserDetailsView() {
		new CommonFunctions().elementView(lnkUserDetails, "User Details");
	}
public UserDetailsPage userDetailsPage() {
	return new UserDetailsPage();
}
}
