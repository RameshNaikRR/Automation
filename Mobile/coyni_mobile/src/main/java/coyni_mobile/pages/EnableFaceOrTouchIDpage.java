package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EnableFaceOrTouchIDpage extends MobileFunctions {
//	Enable Biometric heading
	private By lblEnableFaceId = MobileBy.AccessibilityId("Enable Touch ID");
	private By lblEnableFaceIDText = MobileBy.AccessibilityId("Add Another Layer");
	private By btnEnable = MobileBy.AccessibilityId("Enable Touch ID");
	private By lblScreenLock = MobileBy.xpath("//*[@text='Choose screen lock']");
	private By lnkSkip = MobileBy.AccessibilityId("Skip");
	private By lnkAllow = MobileBy.xpath("");
	private By lnkDontAllow = MobileBy.xpath("");
	private By imgFaceID = MobileBy.AccessibilityId("Enable Face/Thumb Image");
	private By btnNotNow = MobileBy.AccessibilityId("Not Now");
	private By lnkDontRemindMeAgain = MobileBy.AccessibilityId("Don’t Remind Me Again");
	private By lblGetHelpHeading = MobileBy.xpath("");
	private By lblGetHelpDesc = MobileBy.xpath("");
	private By lblGetHelpName = MobileBy.xpath("");
	private By lblLoginEmail = MobileBy.xpath("");
	private By lblAccountID = MobileBy.xpath("");
	private By lblDesc = MobileBy.xpath("");
	

	public void verifyEnableFaceIdHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEnableFaceId, "Heading", expHeading);
	}

	public void verifyEnableFaceIdView() {
		new CommonFunctions().elementView(imgFaceID, "Face Id image");
		new CommonFunctions().elementView(lblEnableFaceIDText, "Enable Face Id");
		ExtentTestManager.setInfoMessageInReport("The text is :" + getText(lblEnableFaceIDText));
	}
	
	public void clickEnable() {
		click(btnEnable, "Enable");
		new CommonFunctions().elementView(lblScreenLock, "Choose screen lock");
	}
	public void verifyPermissionPopup() {
		new CommonFunctions().elementView(lnkAllow, "Allow");
		click(lnkDontAllow, "Dont Allow");
	}
	public void clickSkip() {
		if(getElementList(lnkSkip, "Skip").size()>0) {
		if(getElement(lnkSkip, "Skip").isEnabled()) {
		click(lnkSkip, "Skip");
		}
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
	
	public DashboardPage dashBoardPage() {
		return new DashboardPage();
	}

}
