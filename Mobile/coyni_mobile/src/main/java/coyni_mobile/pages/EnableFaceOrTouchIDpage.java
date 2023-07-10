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
	private By btnProfileNotNow = MobileBy.id("com.coyni.mapp:id/notNowLL");
	private By btnNotNow = MobileBy.AccessibilityId("Not Now");
	private By btnSetUpTouch = MobileBy.id("com.coyni.mapp:id/enableCV");
	private By lnkDontRemindMeAgain = MobileBy.AccessibilityId("Don’t Remind Me Again");
	private By lblGetHelpHeading = MobileBy.xpath("//*[contains(@text,'help')]");
	private By lblGetHelpDesc = MobileBy.id("com.coyni.mapp:id/support_text_click");
	private By lblGetHelpDetails = MobileBy.id("com.coyni.mapp:id/text_support_tv");

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

	public void viewScreenLock() {
		new CommonFunctions().elementView(lblScreenLock, "Choose screen lock");
	}
	
	public void verifyPermissionPopup() {
		new CommonFunctions().elementView(lnkAllow, "Allow");
		click(lnkDontAllow, "Dont Allow");
	}

	public void clickSkip() {
		if (getElementList(lnkSkip, "Skip").size() > 0) {
			if (getElement(lnkSkip, "Skip").isEnabled()) {
				click(lnkSkip, "Skip");
			}
		}
	}

	public void clickNotNow() {
		click(btnNotNow, "Not Now");
	}

	public void clickSetUpTouch() {
		click(btnSetUpTouch, "Set Up Touch ID");
	}
	
	public void clickTouchIDNotNow() {
		click(btnProfileNotNow, "Not Now");
	}
	
	public void verifyDontRemindButtonView() {
		new CommonFunctions().elementView(lnkDontRemindMeAgain, "Dont Remind Me Again");
	}

	public void verifyGetHelp(String expHeading) {
		new CommonFunctions().verifyLabelText(lblGetHelpHeading, "Heading", expHeading);
	}

	public void verifyGetHelpDesc(String expHeading) {
		new CommonFunctions().verifyLabelText(lblGetHelpDesc, "Description", expHeading);
	}

	public void verifyGetHelpView() {
		if(!getText(lblGetHelpDetails).equals("")) {
			new CommonFunctions().elementView(lblGetHelpDetails, "Get Help Details");
		}else {
			ExtentTestManager.setInfoMessageInReport("Its not showing the detailed description as Name,Account ID etc.");
		}
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
