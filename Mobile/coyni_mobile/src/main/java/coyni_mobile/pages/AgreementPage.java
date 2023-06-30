package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AgreementPage extends MobileFunctions {

	private By lblLegal = MobileBy.AccessibilityId("Legal");
	private By lblLegalDesc = MobileBy.AccessibilityId("Review Privacy and Terms Heading");
	private By arwPrivacyPolicy = MobileBy.AccessibilityId("Privacy Policy");
	private By btnDone = MobileBy.id("");
	private By arwTermsOfService = MobileBy.AccessibilityId("Terms of Services");
	private By chkBx = MobileBy.AccessibilityId("Agreement Check Box");
	private By chkbxDesc = MobileBy.AccessibilityId("Check Box Acknowledge");
	private By btnAgree = MobileBy.AccessibilityId("Agree");

//	Profile Agreements Page

	private By lblPrivacyPolicy = MobileBy.id("");
	private By lblTermsService = MobileBy.id("");
	private By lblPrivacyActive = MobileBy.id("");
	private By lblPrivacyPast = MobileBy.id("");
	private By lnkPrivacyActiveAgree = MobileBy.id("");
	private By lnkPrivacyPastAgree = MobileBy.id("");
	private By lblTermsActive = MobileBy.id("");
	private By lblTermsPast = MobileBy.id("");
	private By lnkTermsActiveAgree = MobileBy.id("");
	private By lnkTermsPastAgree = MobileBy.id("");
	private By lblAgreementDocHeading = MobileBy.id("");

	public void verifyLegalView(String legalDesc) {
		new CommonFunctions().elementView(lblLegal, "Heading is");
		new CommonFunctions().verifyLabelText(lblLegalDesc, "Legal", legalDesc);
	}

	public void clickPrivacyPolicy() {
		click(arwPrivacyPolicy, "Privacy Policy");
	}

	public void clickTermsOfService() {
		click(arwTermsOfService, "Terms of Service");
	}

	public void clickCheckBox() {
		click(chkBx, "Check Box");
		ExtentTestManager.setInfoMessageInReport("The checkbox desc is" + getText(chkbxDesc));
	}

	public void clickAgree() {
		if (getElement(btnAgree, "Agree").isEnabled()) {
			click(btnAgree, "Agree");
		}
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

//	Profile Agreements page
	public void clickPrivacyActiveAgreement() {
		new CommonFunctions().elementView(lblPrivacyPolicy, "Privacy Policy Header");
		new CommonFunctions().elementView(lblPrivacyActive, "Privacy Policy Active Header");
		click(lnkPrivacyActiveAgree, "Privacy Policy Active Agreement");
	}

	public void clickPrivacyPastAgreement() {
		new CommonFunctions().elementView(lblPrivacyPolicy, "Privacy Policy Header");
		new CommonFunctions().elementView(lblPrivacyPast, "Privacy Policy Past Header");
		click(lnkPrivacyPastAgree, "Privacy Policy Past Agreement");
	}

	public void clickActiveTermsAgreement() {
		new CommonFunctions().elementView(lblTermsService, "Terms of Service Header");
		new CommonFunctions().elementView(lblTermsActive, "Terms of Service Active Header");
		click(lnkTermsActiveAgree, "Terms of Service Active Agreement");
	}

	public void clickPastTermsAgreement() {
		new CommonFunctions().elementView(lblTermsService, "Terms of Service Header");
		new CommonFunctions().elementView(lblTermsPast, "Terms of Service Past Header");
		click(lnkTermsPastAgree, "Terms of Service Past Agreement");
	}

	public void verifyDocAgreeHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblAgreementDocHeading, "Agree Doc Heading", heading);
		click(lnkTermsPastAgree, "Terms of Service Past Agreement");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
