package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AgreementComponent extends MobileFunctions {

	private By btnAgreements = MobileBy.xpath("//*[@text='Agreements']");

	private By privacyPolicy = MobileBy.xpath("(//*[contains(@resource-id,'listagreementsTV')])[1]");

	private By termsOfService = MobileBy.xpath("(//*[contains(@resource-id,'listagreementsTV')])[2]");

	private By lblAccountHolderName = MobileBy.xpath("//*[contains(@resource-id,'customerNameTV')]");

	private By backIconAgreement = MobileBy.xpath("//*[contains(@resource-id,'backAgreeIV')]");

	private By lblVerifyAcitveAgreements = MobileBy.xpath(" ");

	private By lblVerifyPastAgreements = MobileBy.xpath(" ");

	public void clickBack() {
		click(backIconAgreement, "Back");
	}

	public void Agreements() {
		scrollDownToElement(btnAgreements, "Agreements");
	}

	public void clickOnAgreements() {
		click(btnAgreements, "Agreements");
	}

	public void clickPrivacyPolicy() {
		click(privacyPolicy, "Privacy Policy");
	}

	public void verifyPrivacyPolicy() {
		new CommonFunctions().elementView(privacyPolicy, "Privacy Policy");
	}

	public void clickTermsOfService() {
		click(termsOfService, "Terms of Service");
	}

	public void verifyTermsOfService() {
		new CommonFunctions().elementView(termsOfService, "Terms of Service");
	}

	public void VerifyAccountHolderName() {
		new CommonFunctions().elementView(lblAccountHolderName, "Account Holder " + getText(lblAccountHolderName));
	}

	public void verifyActiveAgreementsHeading(String expHeading) {
		// new CommonFunctions().verifyLabelText(lblVerifyAcitveAgreements, "Active
		// Agreements Heading", expHeading);
	}

	public void verifyPastAgreementsHeading(String expHeading) {

		// new CommonFunctions().verifyLabelText(lblVerifyPastAgreements, "past
		// Agreements Heading", expHeading);
	}

}
