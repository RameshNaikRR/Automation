package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AgreementPage extends MobileFunctions {

	private By lblLegal = MobileBy.AccessibilityId("Legal");
	private By lblLegalDesc = MobileBy.AccessibilityId("Review Privacy and Terms Heading");
	private By arwPrivacyPolicy = MobileBy.AccessibilityId("Privacy Policy");
	private By btnDone = MobileBy.AccessibilityId("");
	private By arwTermsOfService = MobileBy.AccessibilityId("Terms of Services");
	private By chkBx = MobileBy.AccessibilityId("Agreement Check Box");
	private By chkbxDesc = MobileBy.AccessibilityId("Check Box Acknowledge");
	private By btnAgree = MobileBy.AccessibilityId("Agree");

//	Profile Agreements Page

	private By lblPrivacyPolicy = MobileBy.AccessibilityId("");
	private By lblTermsService = MobileBy.AccessibilityId("");
	private By lblPrivacyActive = MobileBy.AccessibilityId("");
	private By lblPrivacyPast = MobileBy.AccessibilityId("");
	private By lnkPrivacyActiveAgree = MobileBy.AccessibilityId("");
	private By lnkPrivacyPastAgree = MobileBy.AccessibilityId("");
	private By lblTermsActive = MobileBy.AccessibilityId("");
	private By lblTermsPast = MobileBy.AccessibilityId("");
	private By lnkTermsActiveAgree = MobileBy.AccessibilityId("");
	private By lnkTermsPastAgree = MobileBy.AccessibilityId("");
	private By lblAgreementDocHeading = MobileBy.AccessibilityId("");

	public void verifyLegalView(String legalDesc) {
		new AndroidCommonFunctions().elementView(lblLegal, "Heading is");
		new AndroidCommonFunctions().verifyLabelText(lblLegalDesc, "Legal", legalDesc);
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
		new AndroidCommonFunctions().elementView(lblPrivacyPolicy, "Privacy Policy Header");
		new AndroidCommonFunctions().elementView(lblPrivacyActive, "Privacy Policy Active Header");
		click(lnkPrivacyActiveAgree, "Privacy Policy Active Agreement");
	}

	public void clickPrivacyPastAgreement() {
		new AndroidCommonFunctions().elementView(lblPrivacyPolicy, "Privacy Policy Header");
		new AndroidCommonFunctions().elementView(lblPrivacyPast, "Privacy Policy Past Header");
		click(lnkPrivacyPastAgree, "Privacy Policy Past Agreement");
	}

	public void clickActiveTermsAgreement() {
		new AndroidCommonFunctions().elementView(lblTermsService, "Terms of Service Header");
		new AndroidCommonFunctions().elementView(lblTermsActive, "Terms of Service Active Header");
		click(lnkTermsActiveAgree, "Terms of Service Active Agreement");
	}

	public void clickPastTermsAgreement() {
		new AndroidCommonFunctions().elementView(lblTermsService, "Terms of Service Header");
		new AndroidCommonFunctions().elementView(lblTermsPast, "Terms of Service Past Header");
		click(lnkTermsPastAgree, "Terms of Service Past Agreement");
	}

	public void verifyDocAgreeHeading(String heading) {
		new AndroidCommonFunctions().verifyLabelText(lblAgreementDocHeading, "Agree Doc Heading", heading);
		click(lnkTermsPastAgree, "Terms of Service Past Agreement");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
