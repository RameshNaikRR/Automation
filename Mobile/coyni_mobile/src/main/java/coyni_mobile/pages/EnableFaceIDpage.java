package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EnableFaceIDpage extends MobileFunctions {
	
	private By btnNotNow = MobileBy.xpath("//*[contains(@resource-id, 'layoutNotnow')]");
	private By lnkDontRemindMeAgain = MobileBy.xpath(" ");
	private By btnEnableFaceId = MobileBy.xpath("//*[contains(@resource-id, 'enableTouchCV')]");
	private By lblEnableFaceId = MobileBy.xpath("(//*[@text='Enable Touch ID'])[1]");
	private By lblEnableFaceIDtouchID = MobileBy.xpath(" ");
	private By btnSettings = MobileBy.xpath(" ");
	private By btnCancel = MobileBy.xpath(" ");
	public void clickNotNow() {
		click(btnNotNow, "Not Now");
	}
	public void clickEnableFaceId() {
		click(btnEnableFaceId, "Enable Face Id");
		
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
  public  TokenAccountPage tokenAccountPage() {
	   return new TokenAccountPage();
  }
}
