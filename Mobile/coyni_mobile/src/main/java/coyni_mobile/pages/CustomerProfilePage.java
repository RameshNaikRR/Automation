package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.AddNewPaymentComponent;
import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CustomerProfilePage extends MobileFunctions {
	private By lblUserName = MobileBy.id("");
	private By lblAccountID = MobileBy.xpath("//*[contains(@name,'Account ID')]");
	private By lblAccountStatus = MobileBy.xpath("//*[contains(@name,'Status')]/preceding-sibling::*[1]");
	private By imgQRCode = MobileBy.AccessibilityId("qr code");
	private By lblUserDetails = MobileBy.AccessibilityId("User Details");
	private By lnkProfile = MobileBy.id("com.coyni.mapp:id/profileLL");
	private By lnkPreferences = MobileBy.id("");
	private By lnkAgreements = MobileBy.AccessibilityId("Agreements");
	private By lblWalletSettings = MobileBy.id("");
	private By lnkPaymentMethods = MobileBy.id("com.coyni.mapp:id/paymentMethodsLL");
	private By lnkAccountLimits = MobileBy.xpath("//*[@name='Account Limits']");
	private By lnkWalletFees = MobileBy.id("");
	private By lblSecurity = MobileBy.id("");
	private By lnkLoginSessions = MobileBy.id("");
	private By lnkResetPinCode = MobileBy.AccessibilityId("Reset PIN Code");
	private By lnkFaceIDtouchID = MobileBy.id("");
	private By lnkChangePassword = MobileBy.AccessibilityId("Change Password");
	private By lblSupport = MobileBy.id("");
	private By lnkGetHelp = MobileBy.AccessibilityId("Get Help");
	private By btnLogOut = MobileBy.id("");
	
	public void verifyUserNAmeandStatus() {
		ExtentTestManager.setInfoMessageInReport("The User Name is :" + getText(lblUserName));
		ExtentTestManager.setInfoMessageInReport("The Account Id is :" + getText(lblAccountID));
		ExtentTestManager.setInfoMessageInReport("The Account Status is:" + getText(lblAccountStatus));
	}
	
	public void verifyUserDetailsView() {
		new CommonFunctions().elementView(lblUserDetails, "User Details");
	}
	public void clickimgQRCode() {
		click(imgQRCode, "QRcode");
	}
	public void clickProfile() {
		click(lnkProfile, "Profile");
	}
	public void clickPreferences() {
		click(lnkPreferences, "Preferences");
	}
	public void clickAgreements() {
		click(lnkAgreements, "Agreements");
	}
    public void verifyWalletSettingsView() {
    	new CommonFunctions().elementView(lblWalletSettings, "Wallet Settings");
    }
    public void clickPaymentMethods() {
		click(lnkPaymentMethods, "Payment Methods");
	}
    public void clickAccountLimits() {
		click(lnkAccountLimits, "Account Limits");
	}
    public void clickWalletFees() {
    	click(lnkWalletFees, "Wallet");
    }
    public void verifySecurityView() {
    	new CommonFunctions().elementView(lblSecurity, "Security");
    }
    public void clickLoginSessions() {
    	click(lnkLoginSessions, "Login sessions");
    }
    public void clickResetPinCode() {
		click(lnkResetPinCode, "Reset Pin Code");
	}
    public void clickFaceIDTouchID() {
    	scrollDownToElement(lnkFaceIDtouchID, "FaceID Touch Id");
    	click(lnkFaceIDtouchID, "FaceID Touch Id");
    }
    public void clickChangePassword() {
		scrollDownToElement(lnkChangePassword, "Change Password");
		click(lnkChangePassword, "Change Password");
	}
    public void clickGetHelp() {
    	scrollDownToElement(lnkGetHelp, "GetHelp");
    	click(lnkGetHelp, "Get Help");
    }
    public void clickLogout() {
    	click(btnLogOut, "Log out");
    }
    public DashboardPage dashboardPage() {
		return new DashboardPage();
	}
    public ProfilePage profilePage() {
		return new ProfilePage();
	}
    
    public AccountLimitsPage accountLimitsPage() {
		return new AccountLimitsPage();
	}

	public WalletsFeesPage walletsFeesPage() {
		return new WalletsFeesPage();
	}
	public EnableFaceOrTouchIDpage enableFaceOrTouchIDpage() {
		return new EnableFaceOrTouchIDpage();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
	public AddNewPaymentComponent addNewPaymentComponent() {
		return new AddNewPaymentComponent();
	}
	public LogInSessionsPage logInSessionsPage() {
		return new LogInSessionsPage();
	}
}
