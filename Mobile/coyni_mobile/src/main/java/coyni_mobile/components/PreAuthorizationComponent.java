package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PreAuthorizationComponent extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[@text='Pre-Authorization']");
	private By lblPageDes = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By txtAmount = MobileBy.id("com.coyni.mapp:id/preauthET");
	private By btnVerify = MobileBy.id("com.coyni.mapp:id/keyActionLL");
	private By imgPreAuth = MobileBy.AccessibilityId("Pre-Authorization");
	private By lblDollar = MobileBy.id("com.coyni.mapp:id/dollarTV");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "heading", expHeading);
	}

	public void verifyPageDes(String expPageDes) {
		new CommonFunctions().elementView(imgPreAuth, "Pre Authy image");
		new CommonFunctions().elementView(lblDollar, "Dollar");
		new CommonFunctions().verifyLabelText(lblPageDes, "Page Description", expPageDes);
	}

	public void fillAmount(String amount) {
		new ChoosePinComponent().fillPin(amount);
	}

	public void clickVerify() {
		click(btnVerify, "Verify");
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

//	private By lblStatusHeading = MobileBy.xpath("//*[@name='Pre-Authorization Failed']");
//
//	private By lblMessage = MobileBy.xpath("//*[contains(@name,'amount')] ");
//
//	private By btnAddBank = MobileBy.xpath("(//*[contains(@name,'Add Bank')])[1]");

//	public void verifyErrHeading(String statusHeading) {
//		new CommonFunctions().verifyLabelText(lblStatusHeading, "Status ", statusHeading);
//	}
//
//	public void verifyErrText(String statusText) {
//		new CommonFunctions().verifyLabelText(lblMessage, "Message", statusText);
//	}
//
//	public void clickAddBankAccount() {
//		click(btnAddBank, "Add Bank Account");
//	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
