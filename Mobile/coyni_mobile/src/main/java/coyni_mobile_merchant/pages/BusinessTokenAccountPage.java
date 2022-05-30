package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile_merchant.components.BatchPayOutComponent;
import coyni_mobile_merchant.components.DaysDropDownComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class BusinessTokenAccountPage extends MobileFunctions {
	private By btnProfile = MobileBy.xpath("//*[contains(@resource-id,'tv_profile_text')]");
	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'businessTrackerCloseIV')]");

	public void clickProfile() {
		click(btnProfile, "Profile");
	}

	public void clickClose() {
		click(btnCloseIcon, "Close Icon");
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
}
