package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EnableFaceIDpage extends MobileFunctions {
	
	private By btnNotNow = MobileBy.xpath("//*[contains(@resource-id, 'layoutNotnow')]|(//*[@name='Not Now'])[1]");
	private By lnkDontRemindMeAgain = MobileBy.xpath("//*[contains(@resource-id, 'dontRemindTouchTV')]|(//*[@name='Don’t Remind Me Again'])[1]");
	private By btnEnableFaceId = MobileBy.xpath("//*[contains(@resource-id, 'enableTouchCV')]|(//*[@name='Enable Face ID'])[2]");
	private By lblEnableFaceId = MobileBy.xpath("(//*[@text='Enable Touch ID'])[1]|(//*[@name='Enable Face ID'])[1]");
	private By lblEnableFaceIDtouchID = MobileBy.xpath(" ");
	private By btnSettings = MobileBy.xpath(" ");
	private By btnCancel = MobileBy.xpath(" ");
	public void clickNotNow() {
		click(btnNotNow, "Not Now");
	}
	public void clickEnableFaceId() {
		click(btnEnableFaceId, "Enable Face Id");
		
	}
	public void verifyEnableFaceIDButtonView() {
		new CommonFunctions().elementView(btnEnableFaceId, "Enable Face ID Button");
	}
	public void verifyNotNowButtonView() {
		new CommonFunctions().elementView(btnNotNow, "Not Now");
	}
	public void verifyDontRemindButtonView() {
		new CommonFunctions().elementView(lnkDontRemindMeAgain, "Dont Remind Me Again link ");
	}
	public void clickSettigs() {
		click(btnSettings, "Settings");
	}
	public void clickCancel() {
		click(btnCancel, "Cancel");
	}
	public void verifySettingsView() {
		new CommonFunctions().elementView(btnSettings, "Settings");
	}
	public void verifyCancelView() {
		new CommonFunctions().elementView(btnCancel, "Cancel");
	}
	public void clickDontRemindMeAgain() {
		click(lnkDontRemindMeAgain, "DontRemindMeAgain");
	}
	public void verifyEnableFaceIdView() {
		new CommonFunctions().elementView(lblEnableFaceId, "Enable Face Id");
	}
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEnableFaceId, "heading", expHeading);
	}
//  public  TokenAccountPage tokenAccountPage() {
//	   return new TokenAccountPage();
//  }
//  public AccountCreatedPage accountCreatedPage() {
//	  return new AccountCreatedPage();
//  }
	public RegistrationPage registrationPage() {
		return new RegistrationPage();
	}
}
