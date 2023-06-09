package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.AndroidCommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EnableFaceOrTouchIDpage extends MobileFunctions {
	private By lblEnableFaceId = MobileBy.AccessibilityId("Enable Biometric heading");
	private By lblEnableFaceIDText = MobileBy.AccessibilityId("Add Another Layer");
	private By btnEnable = MobileBy.AccessibilityId("Enable Touch ID");
	private By lnkSkip = MobileBy.AccessibilityId("");
	private By lnkAllow = MobileBy.AccessibilityId("");
	private By lnkDontAllow = MobileBy.AccessibilityId("");
	private By imgFaceID = MobileBy.AccessibilityId("Enable Face/Thumb Image");
	private By btnNotNow = MobileBy.AccessibilityId("Not Now");
	private By lnkDontRemindMeAgain = MobileBy.AccessibilityId("Don’t Remind Me Again");
	private By lblGetHelpHeading = MobileBy.AccessibilityId("");
	private By lblGetHelpDesc = MobileBy.AccessibilityId("");
	private By lblGetHelpName = MobileBy.AccessibilityId("");
	private By lblLoginEmail = MobileBy.AccessibilityId("");
	private By lblAccountID = MobileBy.AccessibilityId("");
	private By lblDesc = MobileBy.AccessibilityId("");

	public void verifyEnableFaceIdView() {
		new CommonFunctions().elementView(imgFaceID, "Face Id image");
		new CommonFunctions().elementView(lblEnableFaceId, "Enable Face Id");
		ExtentTestManager.setInfoMessageInReport("The text is :" + getText(lblEnableFaceIDText));
	}

	public void clickEnable() {
		click(btnEnable, "Enable");
	}
	public void verifyPermissionPopup() {
		new CommonFunctions().elementView(lnkAllow, "Allow");
		click(lnkDontAllow, "Dont Allow");
	}
	public void clickSkip() {
		if(getElement(lnkSkip, "Skip").isEnabled()) {
		click(lnkSkip, "Skip");
		}
	}
	public void clickNotNow() {
		click(btnNotNow, "Not Now");
	}
	public void verifyDontRemindButtonView() {
		new CommonFunctions().elementView(lnkDontRemindMeAgain, "Dont Remind Me Again");
	}
	public void verifyGetHelp(String expHeading) {
		new CommonFunctions().elementView(lblGetHelpHeading, "Heading");
		new CommonFunctions().verifyLabelText(lblGetHelpHeading, "Heading", expHeading);
	}
	public void verifyGetHelpDesc(String expHeading) {
		new CommonFunctions().elementView(lblGetHelpDesc, "Description");
		new CommonFunctions().verifyLabelText(lblGetHelpDesc, "Description", expHeading);
	}
	public void verifyGetHelpview() {
		new CommonFunctions().elementView(lblGetHelpName, "Name");
		new CommonFunctions().elementView(lblLoginEmail, "Email");
		new CommonFunctions().elementView(lblAccountID, "Account");
		new CommonFunctions().elementView(lblDesc, "Description");
	}
	public AccountCreatedPage accountCreatedPage() {
		return new AccountCreatedPage();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	

}
