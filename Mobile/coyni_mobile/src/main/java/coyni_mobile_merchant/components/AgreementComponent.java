package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AgreementComponent extends MobileFunctions {

	private By headingAgreements = MobileBy.xpath("//*[contains(@text,'Agreements')]");
	private By headingActiveAgreements = MobileBy.xpath("//*[contains(@resource-id,'activeTV')]");
	private By privacyPolicy = MobileBy.xpath("//*[contains(@text,'Privacy')]");
	private By termsOfService = MobileBy.xpath("//*[contains(@text,'Terms')]");
	private By lblMerchantAgreements = MobileBy.xpath("//*[contains(@text,'Merchant’s')]");
	private By headingPastAgreements = MobileBy.xpath("");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'back')]");

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
		new CommonFunctions().elementView(lblMerchantAgreements, "Merchant Agreements");
		ExtentTestManager.setInfoMessageInReport("Merchant Agreements : " + getText(lblMerchantAgreements));
	}

	public void verifyPrivacyPolicyView() {
		new CommonFunctions().elementView(privacyPolicy, "Privacy Policy");
		ExtentTestManager.setInfoMessageInReport("Privacy Policy : " + getText(privacyPolicy));
	}
//
//	public void clickPrivacyPolicy() {
//		click(privacyPolicy, "Privacy Policy");
//	}

	public void verifyTermsOfServiceView() {
		new CommonFunctions().elementView(termsOfService, "Terms of Service");
		ExtentTestManager.setInfoMessageInReport("Terms of service : " + getText(termsOfService));
	}

//	public void clickTermsOfService() {
//		click(termsOfService, "Terms of Service");
//	}
	public void clickBack() {
		click(btnBack, "Back");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
