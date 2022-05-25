package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AgreementComponent extends MobileFunctions {

	private By headingAgreements = MobileBy.xpath("//*[contains(@resource-id,'cpAgreementsLL')]");
	private By headingActiveAgreements = MobileBy.xpath("//*[contains(@resource-id,'activeTV')]");
	private By privacyPolicy = MobileBy.xpath("//*[@text='Privay Policy']");
	private By termsOfService = MobileBy.xpath("//*[@text='Terms of Service']");
	private By lblMerchantAgreements = MobileBy.xpath("//*[contains(@resource-id,'listagreementsTV')]");
	private By headingPastAgreements = MobileBy.xpath(" ");

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

	public void verifyMerchantAgreementsLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantAgreements, "Label", expHeading);
	}

	public void verifyPrivacyPolicyView() {
		new CommonFunctions().elementView(privacyPolicy, "Privacy Policy");
	}
//
//	public void clickPrivacyPolicy() {
//		click(privacyPolicy, "Privacy Policy");
//	}

	public void verifyTermsOfServiceView() {
		new CommonFunctions().elementView(termsOfService, "Terms of Service");
	}

//	public void clickTermsOfService() {
//		click(termsOfService, "Terms of Service");
//	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
