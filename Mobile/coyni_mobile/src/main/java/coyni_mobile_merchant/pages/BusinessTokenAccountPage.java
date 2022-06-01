package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile_merchant.components.BatchPayOutComponent;
import coyni_mobile_merchant.components.DaysDropDownComponent;
import coyni_mobile_merchant.components.ReserveBalanceComponent;
import coyni_mobile_merchant.popups.TokenMenuIconPopUp;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BusinessTokenAccountPage extends MobileFunctions {
	private By btnProfile = MobileBy.xpath("//*[contains(@resource-id,'tv_profile_text')]");
	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'businessTrackerCloseIV')]");
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'tv_user_name')]");
	private By btnHome = MobileBy.xpath("//*[contains(@resource-id,'iv_menu_tab')]");

	public void clickProfile() {
		click(btnProfile, "Profile");
	}

	public void clickClose() {
		click(btnCloseIcon, "Close Icon");
	}

	public void getUserName() {
		ExtentTestManager.setInfoMessageInReport("User Name is : " + getText(lblUserName));
	}

	public void clickHome() {
		click(btnHome, "Home");
	}

	public BatchPayOutComponent batchPayOutComponent() {
		return new BatchPayOutComponent();
	}

	public MerchantTransactionDetailsPage merchantTransactionDetailsPage() {
		return new MerchantTransactionDetailsPage();
	}

	public DaysDropDownComponent daysDropDownComponent() {
		return new DaysDropDownComponent();
	}

	public ReserveBalanceComponent reserveBalanceComponent() {
		return new ReserveBalanceComponent();
	}

	public TokenMenuIconPopUp tokenMenuIconPopUp() {
		return new TokenMenuIconPopUp();
	}
}
