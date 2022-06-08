package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SelectPaymentmethod extends MobileFunctions {

	private By lblPageHeading = MobileBy.xpath("//*[contains(@text,'Select Payment Method')]");
	private By btnSelectBank = MobileBy.xpath("(//*[contains(@resource-id,'tvBankName')])[1]");
	private By txtCode = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By lblDidntGetCode = MobileBy.xpath("//*[@text=\"Didn't get the code?\"]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'Close')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPageHeading, "Page Heading", expHeading);
	}

	public void clickBank() {
		click(btnSelectBank, "Select Bank");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}
	
	public BuyTokenBankAccountPaymentMethodPage buyTokenBankAccountPaymentMethodPage() {
		return new BuyTokenBankAccountPaymentMethodPage();
	}
}
