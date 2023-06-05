package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EnableFaceOrTouchIDpage extends MobileFunctions {
	private By lblEnableFaceId = MobileBy.AccessibilityId("Enable Face ID");
	private By lblEnableFaceIDText = MobileBy.AccessibilityId("");
	private By btnEnable = MobileBy.AccessibilityId("");
	private By lnkSkip = MobileBy.AccessibilityId("");
	private By lnkAllow = MobileBy.AccessibilityId("");
	private By lnkDontAllow = MobileBy.AccessibilityId("");
	private By imgFaceID = MobileBy.AccessibilityId("");
	private By btnNotNow = MobileBy.AccessibilityId("");
	private By lnkDontRemindMeAgain = MobileBy.AccessibilityId("");

	public void verifyEnableFaceIdView() {
		new AndroidCommonFunctions().elementView(imgFaceID, "Face Id image");
		new AndroidCommonFunctions().elementView(lblEnableFaceId, "Enable Face Id");
		ExtentTestManager.setInfoMessageInReport("The text is :" + getText(lblEnableFaceIDText));
	}

	public void clickEnable() {
		click(btnEnable, "Enable");
	}
	public void verifyPermissionPopup() {
		new AndroidCommonFunctions().elementView(lnkAllow, "Allow");
		click(lnkDontAllow, "Dont Allow");
	}
	public void clickSkip() {
		if(getElement(lnkSkip, "Skip").isEnabled()) {
		click(lnkSkip, "Skip");
		}
	}
	public void clickNotNow() {
		if(getElement(btnNotNow, "Not Now").isEnabled()) {
		click(btnNotNow, "Not Now");
		}
	}
	public void verifyDontRemindButtonView() {
		new AndroidCommonFunctions().elementView(lnkDontRemindMeAgain, "Dont Remind Me Again");
	}
	public AccountCreatedPage accountCreatedPage() {
		return new AccountCreatedPage();
	}
	

}
