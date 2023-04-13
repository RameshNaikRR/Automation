package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AgreementComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Agreements']");
	private By privacyPolicy = MobileBy.xpath("(//*[contains(@resource-id,'listagreementsTV')])[1]");
	private By termsOfService = MobileBy.xpath("(//*[contains(@resource-id,'listagreementsTV')])[2]");
	private By backIconAgreement = MobileBy.xpath("//*[contains(@resource-id,'backAgreeIV')]");
	private By lblActiveAgreements = MobileBy.xpath("//*[contains(@resource-id,'activeTV')]");
	private By lblPastAgreements = MobileBy.xpath("//*[contains(@resource-id,'pastTV')]");
	// Updates of Agreements after login
	private By privacyPolicyUpdate = MobileBy
			.xpath("//*[contains(@resource-id,'privacy_policy')]|//*[contains(@text,'Privacy Policy')]");
	private By termsOfServiceUpdateHeading = MobileBy.xpath("//*[contains(@resource-id,'agreNameTV')]");
	private By termsOfServiceUpdateOk = MobileBy.xpath("//*[contains(@resource-id,'actionCV')]");
	private By chboxAgree = MobileBy.xpath("//*[contains(@resource-id,'agreeCB')]");
	private By allow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	
	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void clickAllow() {
		if (getElementList(allow, "Allow").size() > 0) {
			click(allow, "Allow");	
		}
	}
	
	public void verifyTermsOfServiceUpdate(String expHeading) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(termsOfServiceUpdateHeading));
		if (getElementList(termsOfServiceUpdateHeading, "").size() > 0) {
			new CommonFunctions().verifyLabelText(termsOfServiceUpdateHeading, "Terms Of Service Update Heading",
					expHeading);
			scrollDownToElement(termsOfServiceUpdateOk, "Terms of Service Agree button");
			clickAgreeCheckBox();
			click(termsOfServiceUpdateOk, "Terms Of Service Update Ok");
		}
	}

	public void clickAgreeCheckBox() {
		click(chboxAgree, "Terms of service and Privacy");
	}
	
	public void verifyPrivacyPolicyHeading(String expHeading) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(privacyPolicyUpdate));
		if (getElementList(privacyPolicyUpdate, "").size() > 0) {
			new CommonFunctions().verifyLabelText(privacyPolicyUpdate, "Privacy Policy Update Heading", expHeading);
			scrollDownToElement(termsOfServiceUpdateOk, "Privacy Policy Update button");
			clickAgreeCheckBox();
			click(termsOfServiceUpdateOk, "Privacy Policy Update Update Ok");
		}
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Page Heading");
	}
	
	public void verifyActiveAgreementsView() {
		new CommonFunctions().elementView(lblActiveAgreements, "Active Agreements Label");
	}

	public void verifyPastAgreementsView() {
		new CommonFunctions().elementView(lblPastAgreements, "Past Agreements Label");
	}

	public void verifyActiveAgreementsHeading(String expActiveHeading) {
		new CommonFunctions().verifyLabelText(lblActiveAgreements, "Active Agreements ", expActiveHeading);
	}

	public void verifyPastAgreementsHeading(String expPastHeading) {
		new CommonFunctions().verifyLabelText(lblPastAgreements, "Past Agreements ", expPastHeading);
	}

	public void verifyPrivacyPolicyView() {
		new CommonFunctions().elementView(privacyPolicy, "Privacy Policy");
	}

	public void clickPrivacyPolicy() {
		click(privacyPolicy, "Privacy Policy");
	}

	public void verifyTermsOfServiceView() {
		new CommonFunctions().elementView(termsOfService, "Terms of Service");
	}

	public void clickTermsOfService() {
		click(termsOfService, "Terms of Service");
	}

	public void clickBack() {
		click(backIconAgreement, "Back");
	}

}
