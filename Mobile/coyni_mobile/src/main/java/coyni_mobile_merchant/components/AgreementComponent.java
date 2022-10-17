package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AgreementComponent extends MobileFunctions {

	private By headingAgreements = MobileBy.xpath("//*[contains(@text,'Agreements')]");
	private By headingActiveAgreements = MobileBy.xpath("//*[contains(@resource-id,'activeTV')]");
	private By privacyPolicy = MobileBy.xpath("//*[contains(@resource-id,'privacy_policy')]|//*[contains(@text,'Privacy Policy')]");
	private By termsOfService = MobileBy.xpath("//*[contains(@resource-id,'terms_of_service')]|//*[contains(@text,'Terms of Service')]");
	private By lblMerchantAgreements = MobileBy.xpath("//*[contains(@resource-id,'merchant_agreements')]|//*[contains(@text,'Merchant’s Agreement')]");
	private By headingPastAgreements = MobileBy.xpath("");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'back')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'canceled')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingAgreements, "Page Heading", expHeading);
	}

	public void verifyActiveAgreementsView() {
		new CommonFunctions().elementView(headingActiveAgreements, "Active Agreements Label");
	}

	public void verifyPastAgreementsView() {
		new CommonFunctions().elementView(headingPastAgreements, "Past Agreements Label");
	}

	public void verifyActiveAgreementsHeading(String expActiveHeading) {
		new CommonFunctions().verifyLabelText(headingActiveAgreements, "Active Agreements ", expActiveHeading);
	}

	public void verifyPastAgreementsHeading(String expPastHeading) {
		new CommonFunctions().verifyLabelText(headingPastAgreements, "Past Agreements ", expPastHeading);
	}

//	public void verifyMerchantAgreementsLabel(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblMerchantAgreements, "Label", expHeading);
//	}

	
	public void verifyMerchantAgreementView() {
		scrollDownToElement(lblMerchantAgreements, "Merchant Agreements");
		new CommonFunctions().elementView(lblMerchantAgreements, "Merchant Agreements");
		ExtentTestManager.setInfoMessageInReport("Merchant Agreements : " + getText(lblMerchantAgreements));
		click(lblMerchantAgreements, "Merchant Agreements");
	}

	public void verifyPrivacyPolicyView() {
		scrollDownToElement(privacyPolicy, "Privacy Policy");
		new CommonFunctions().elementView(privacyPolicy, "Privacy Policy");
		ExtentTestManager.setInfoMessageInReport("Privacy Policy : " + getText(privacyPolicy));
		click(privacyPolicy, "Privacy Policy");
	}
//
//	public void clickPrivacyPolicy() {
//		click(privacyPolicy, "Privacy Policy");
//	}

	public void verifyTermsOfServiceView() {
		scrollDownToElement(termsOfService, "Terms Of Service");
		new CommonFunctions().elementView(termsOfService, "Terms of Service");
		ExtentTestManager.setInfoMessageInReport("Terms of service : " + getText(termsOfService));
		click(termsOfService, "Terms Of Service");
	}

//	public void clickTermsOfService() {
//		click(termsOfService, "Terms of Service");
//	}
	public void clickBack() {
		click(btnBack, "Back");
	}
	
	public void clickClose() {
		click(btnClose, "Close");
	}
	
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
