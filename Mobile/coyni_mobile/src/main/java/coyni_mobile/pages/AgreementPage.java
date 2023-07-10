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
	private By btnDone = MobileBy.id("");
	private By chkBx = MobileBy.AccessibilityId("Agreement Check Box");
	private By chkbxDesc = MobileBy.AccessibilityId("Check Box Acknowledge");
	private By btnAgree = MobileBy.AccessibilityId("Agree");

//	Profile Agreements Page
	private By lblAgreeHeading = MobileBy.xpath("//*[@text='Agreements']");
	private By lnkPrivacyPolicy = MobileBy.id("com.coyni.mapp:id/privacyPolicyRL");
	private By lnkTermsService = MobileBy.id("com.coyni.mapp:id/termsOfServiceRL");
	private By lblPrivacyPolicy = MobileBy.xpath("//*[@text='Privacy Policy']");
	private By lblTermsService = MobileBy.xpath("//*[@text='Terms of Service']");
	private By lblActive = MobileBy.xpath("//*[@text='Active']");
	private By lblPast = MobileBy.xpath("//*[@text='Past']");
	private By lblActiveAgrmntVersion = MobileBy.xpath("//*[@text='Active']/parent::*/following-sibling::android.widget.LinearLayout[1]/descendant::android.widget.TextView[2]");
	private By lblActiveAgreeDate = MobileBy.xpath("//*[@text='Active']/parent::*/following-sibling::android.widget.LinearLayout[1]/descendant::android.widget.TextView[3]");
	private By lblPastAgrmntVersion = MobileBy.xpath("//*[@text='Past']/parent::*/following-sibling::android.widget.LinearLayout[1]/descendant::android.widget.TextView[2]");
	private By lblPastAgreeDate = MobileBy.xpath("//*[@text='Past']/parent::*/following-sibling::android.widget.LinearLayout[1]/descendant::android.widget.TextView[3]");
	private By lnkActiveAgree = MobileBy.xpath("//*[@text='Active']/parent::*/following-sibling::android.widget.LinearLayout[1]");
	private By lnkPastAgree = MobileBy.xpath("//*[@text='Past']/parent::*/following-sibling::android.widget.LinearLayout[1]");
	private By lblAgreementDocHeading = MobileBy.xpath("//*[@text='Agreement']");

	public void verifyLegalView(String legalDesc) {
		new CommonFunctions().elementView(lblLegal, "Heading is");
		new CommonFunctions().verifyLabelText(lblLegalDesc, "Legal", legalDesc);
	}

	public void clickPrivacyPolicy() {
		click(lnkPrivacyPolicy, "Privacy Policy");
	}

	public void clickTermsOfService() {
		click(lnkTermsService, "Terms of Service");
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
	public void verifyPrivacyAgreement(String expText) {
		new CommonFunctions().verifyLabelText(lblPrivacyPolicy, "Privacy Policy Header",expText);
	}

	public void verifyTermsAgreement(String expText) {
		new CommonFunctions().verifyLabelText(lblTermsService, "Terms of Service Header",expText);
	}
	
	public void verifyAgreements(String expText) {
		new CommonFunctions().verifyLabelText(lblAgreeHeading, "Agreements",expText);
	}
	
	public void verifyActiveAgreement() {
		new CommonFunctions().elementView(lblActive, "Active Agreements");		
		new CommonFunctions().elementView(lblActiveAgrmntVersion, "Active Agreement Version");
		new CommonFunctions().elementView(lblActiveAgreeDate, "Active Agreement Agreed Date");		
	}
	
	public void verifyPastAgreement() {
		new CommonFunctions().elementView(lblPast, "Past Agreements");		
		new CommonFunctions().elementView(lblPastAgrmntVersion, "Past Agreement Version");
		new CommonFunctions().elementView(lblPastAgreeDate, "Past Agreement Agreed Date");		
	}
	
	public void clickPastAgreement() {
		click(lnkPastAgree, "Past Agreement");
	}

	public void clickActiveAgreement() {
		click(lnkActiveAgree, "Active Agreement");
	}

	public void verifyDocAgreeHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblAgreementDocHeading, "Agree Doc Heading", heading);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
