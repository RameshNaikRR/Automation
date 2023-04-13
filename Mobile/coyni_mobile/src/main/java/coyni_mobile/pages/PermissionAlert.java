package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PermissionAlert extends MobileFunctions {

	private By lblAlertHeading = MobileBy.xpath("Would Like to Access Your");
	private By lblAlertDes = MobileBy.xpath("(//*[contains(@name,'accessed')])[1]");
	private By btnDontAllow = MobileBy.xpath("(//*[contains(@name,'Allow')])[1]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By lblAlertErrorMsg = MobileBy.xpath("//*[contains(@text,'From Amount')]|//*[contains(@resource-id,'tvMessage')]");
	private By lblAlertLessThanAmountErrorMsg = MobileBy
			.xpath("//*[contains(@text,'From Amount')]|//*[contains(@resource-id,'tvMessage')]");

	public void verifyErrorMessage(String errMsg) {
		new CommonFunctions().verifyLabelText(lblAlertErrorMsg, "errMsg", errMsg);
	}

	public void verifyAlertErrorMessage(String errMsg) {
		new CommonFunctions().verifyLabelText(lblAlertLessThanAmountErrorMsg, "errMsg", errMsg);
	}

	public void getAlertLabel() {
		ExtentTestManager.setInfoMessageInReport("Alert Title:" + getText(lblAlertHeading));
	}

	public void getAlertDes() {
		ExtentTestManager.setInfoMessageInReport("Alert Title:" + getText(lblAlertDes));
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

	public void clickDontAllow() {
		click(btnDontAllow, "Don't Allow");
	}

	public void handlingPopup() {
		if (getElementList(lblAlertHeading, "").size() > 0) {

			getAlertLabel();

			getAlertDes();

			clickOk();

		}

	}

}