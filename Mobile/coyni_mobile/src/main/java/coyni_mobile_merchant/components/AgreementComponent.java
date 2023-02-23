package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AgreementComponent extends MobileFunctions {

	private By headingAgreements = MobileBy.xpath("//*[contains(@text,'Agreements')]");
	private By headingActiveAgreements = MobileBy.xpath("//*[contains(@resource-id,'activeTV')]");
	private By privacyPolicy = MobileBy.xpath("//*[contains(@text,'Privacy Policy')]");
	private By termsOfService = MobileBy.xpath("//*[contains(@text,'Terms of Service')]");
	private By lblMerchantAgreements = MobileBy
			.xpath("//*[contains(@resource-id,'merchant_agreements')]|//*[contains(@text,'Merchant’s Agreement')]");
	private By headingPastAgreements = MobileBy.xpath("");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'back')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'canceled')]");

	// Updates of Agreements after login
	private By privacyPolicyUpdate = MobileBy
			.xpath("//*[contains(@resource-id,'privacy_policy')]|//*[contains(@text,'Privacy Policy')]");
	private By termsOfServiceUpdateHeading = MobileBy.xpath("(//*[contains(@text,'Terms of Service')])[1]");
	private By privacyPolicyHeading = MobileBy.xpath(
			"(//*[contains(@text,'Privacy Policy')])[1]|//*[contains(@resource-id,'privacy_policy')]|//*[contains(@resource-id,'agreNameTV')]");
	private By termsOfServiceUpdateOk = MobileBy.xpath("//*[contains(@resource-id,'actionCV')]");
	private By chboxAgree = MobileBy.xpath("//*[contains(@resource-id,'agreeCB')]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingAgreements, "Page Heading", expHeading);
	}

	public void verifyTermsOfServiceUpdate(String expHeading) throws InterruptedException {
		if (getElementList(termsOfServiceUpdateHeading, "").size() > 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(termsOfServiceUpdateHeading));
			new CommonFunctions().verifyLabelText(termsOfServiceUpdateHeading, "Terms Of Service Update Heading",
					expHeading);
			scrollDownToElement(termsOfServiceUpdateOk, "Terms of Service Agree button");
			clickAgreeCheckBox();
			click(termsOfServiceUpdateOk, "Terms Of Service Update Ok");
		}
	}

	public void verifyPrivacyPolicyHeading(String expHeading) throws InterruptedException {
		if (getElementList(privacyPolicyHeading, "").size() > 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(privacyPolicyUpdate));
			new CommonFunctions().verifyLabelText(privacyPolicyHeading, "Privacy Policy Update Heading", expHeading);
			scrollDownToElement(termsOfServiceUpdateOk, "Privacy Policy Update button");
			clickAgreeCheckBox();
			click(termsOfServiceUpdateOk, "Privacy Policy Update Update Ok");
		}
	}

	public void verifyTermsOfServiceUpdateForSignUp(String expHeading) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(termsOfServiceUpdateHeading));
		new CommonFunctions().verifyLabelText(termsOfServiceUpdateHeading, "Terms Of Service Update Heading",
				expHeading);
		Thread.sleep(2000);
		scrollDownToElement(termsOfServiceUpdateOk, "Terms of Service Agree button");
		clickAgreeCheckBox();
		click(termsOfServiceUpdateOk, "Terms Of Service Update Ok");
	}

	public void verifyPrivacyPolicyHeadingForSignUp(String expHeading) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyHeading));
		new CommonFunctions().verifyLabelText(privacyPolicyHeading, "Privacy Policy Update Heading", expHeading);
		Thread.sleep(2000);
		scrollDownToElement(termsOfServiceUpdateOk, "Privacy Policy Update button");
		clickAgreeCheckBox();
		click(termsOfServiceUpdateOk, "Privacy Policy Update Update Ok");

	}

	public void scrollTermsOfService() {

//		while (getElementList(termsOfServiceUpdateOk, "Next").size() == 0) {
		scrollDownToElement(termsOfServiceUpdateOk, "Terms of Service Agree button");
//			TouchAction touch = new TouchAction(DriverFactory.getDriver());
//			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//					.moveTo(PointOption.point(540, (int) (300))).release().perform();
//		}
	}

	public void clickAgreeCheckBox() {
		click(chboxAgree, "Terms of service and Privacy");
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

	public void verifyMerchantAgreementView() {
		scrollDownToElement(lblMerchantAgreements, "Merchant Agreements");
		new CommonFunctions().elementView(lblMerchantAgreements, "Merchant Agreements");
		ExtentTestManager.setInfoMessageInReport("Merchant Agreements : " + getText(lblMerchantAgreements));
		click(lblMerchantAgreements, "Merchant Agreements");
	}

	public void verifyPrivacyPolicyView() {
		new CommonFunctions().elementView(privacyPolicy, "Privacy Policy");
		ExtentTestManager.setInfoMessageInReport("Privacy Policy : " + getText(privacyPolicy));
		click(privacyPolicy, "Privacy Policy");
	}

	public void verifyTermsOfServiceView() {
		new CommonFunctions().elementView(termsOfService, "Terms of Service");
		ExtentTestManager.setInfoMessageInReport("Terms of service : " + getText(termsOfService));
		click(termsOfService, "Terms Of Service");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void verifyHeading() {
		new CommonFunctions().elementView(headingAgreements, "Page Heading");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
