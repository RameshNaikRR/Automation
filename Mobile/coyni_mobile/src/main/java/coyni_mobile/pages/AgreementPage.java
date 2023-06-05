package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AgreementPage extends MobileFunctions {

	private By lblLegal = MobileBy.AccessibilityId("");
	private By lblLegalDesc = MobileBy.AccessibilityId("");
	private By arwPrivacyPolicy = MobileBy.AccessibilityId("");
	private By btnDone = MobileBy.AccessibilityId("");
	private By arwTermsOfService = MobileBy.AccessibilityId("");
	private By chkBx = MobileBy.AccessibilityId("");
	private By chkbxDesc = MobileBy.AccessibilityId("");
	private By btnAgree = MobileBy.AccessibilityId("");

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

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
