package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.AgreementComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class RegistrationMerchantAgreementsPage extends MobileFunctions {

	private By btnSignature = MobileBy.xpath("//*[contains(@resource-id,'signatureEditIV')]");
	private By btnSignatureDone = MobileBy.xpath("//*[contains(@resource-id,'tv_signature_done')]");
	private By btnAgreementsDone = MobileBy
			.xpath("//*[contains(@text,'Done')]|//*[contains(@resource-id,'AgreeDoneCv')]");
	private By lblApplicationDisclosureHea = MobileBy.id("com.coyni.mapp:id/agreNameTV");
	private By drawSignature = MobileBy.xpath("//*[contains(@resource-id,'csv_signature_view')]");
	private By btnClear = MobileBy.xpath("//*[@text='Clear']");
	private By btnMerchantAgreement = MobileBy.xpath("//*[contains(@resource-id,'aggrementsIncompleteLL')]");
	private By lblHeading = MobileBy.xpath("//*[@text='Agreements']");
	private By btnTermsOfService = MobileBy.xpath("//*[contains(@resource-id,'termsOfServiceLL')]");
	private By btnPrivacyPolicy = MobileBy.xpath("//*[contains(@resource-id,'privacyPolicyLL')]");
	private By chkBoxAgreements = MobileBy.xpath("//*[contains(@resource-id,'agreeCB')]");
	private By btnSubmit = MobileBy.xpath("//*[contains(@text,'Submit')]");
	
	public void clickSignature() {
		new CommonFunctions().elementView(lblApplicationDisclosureHea, "Application Disclosure");
		click(btnSignature, "Signature");
	}

	public void clickSignatureDone() {
		click(btnSignatureDone, "Signature Done");
	}

	public void clickClear() {
		click(btnClear, "Clear");
	}

	public void clickAgreementsDone() {
		click(btnAgreementsDone, "Done");
	}
	public void clickAgreementsCheckBox() {
		click(chkBoxAgreements, "Agreements Check Box");
	}

	public void VerifyAgreementsTerms() {
		new CommonFunctions().elementView(lblHeading, "Agreements");
		new CommonFunctions().elementView(btnTermsOfService, "Terms of Service");
		click(btnTermsOfService, "Terms of Service");
	}

	public void VerifyAgreementsPrivacyPolicy() {
		new CommonFunctions().elementView(btnPrivacyPolicy, "Privacy Policy");
		click(btnPrivacyPolicy, "Privacy Policy");
	}

	public void drawSignature() throws InterruptedException {

		DeviceRotation landscapeRightRotation = new DeviceRotation(0, 0, 90);
		DriverFactory.getDriver().rotate(landscapeRightRotation);
		TouchAction touch = new TouchAction(DriverFactory.getDriver());
		touch.press(PointOption.point(1645, 572)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(1900, (int) (572))).release().perform();
	}

	public void VerifyApplicationDisclosure() throws InterruptedException {
		clickSignature();
		drawSignature();
		clickClear();
		drawSignature();
		clickSignatureDone();
		clickAgreementsCheckBox();
		click(btnSubmit, "Submit");
	}

	public void clickMerchantAgreement() {
		click(btnMerchantAgreement, "Merchant's Agreement");
	}

	public AgreementComponent agreementComponent() {
		return new AgreementComponent();
	}
}
