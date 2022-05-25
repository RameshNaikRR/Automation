package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.MerchantTransactionDetailsPage;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class BatchPayOutComponent extends MobileFunctions {

	private By lblBatchPayOuts = MobileBy.xpath("//*[contains(@resource-id,'')]");
	private By btnBatchNow = MobileBy.xpath("");
	private By lnkViewFullPayOutsHistory = MobileBy.xpath("//*[contains(@resource-id,'')]");

	public void veirfyLabelBatchPayouts(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBatchPayOuts, "Batch PayOuts", expHeading);

	}

	public void clickBatchNow() {
		scrollDownToElement(btnBatchNow, "Batch Now");
		click(btnBatchNow, "Batch Now");

	}

	public void clickFullPayOutsHistory() {
		click(lnkViewFullPayOutsHistory, "Full PayOuts History");

	}

	public MerchantTransactionDetailsPage merchantTransactionDetailsPage() {
		return new MerchantTransactionDetailsPage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}
}
