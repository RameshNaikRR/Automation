package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AccountLimitsComponent extends MobileFunctions {

	private By lblVerifyBuyTokens = MobileBy.xpath(" ");
	private By lblBankAccountAmount = MobileBy.xpath(" ");
	private By lblDebitCardAmount = MobileBy.xpath(" ");
	private By lblCreditCardAmount = MobileBy.xpath(" ");
	private By lblVerifyWithdraw = MobileBy.xpath(" ");
	private By lblInstantPayAmount = MobileBy.xpath(" ");
	private By lblGiftCardAmount = MobileBy.xpath(" ");
	private By lblVerifyAcitveAgreements = MobileBy.xpath(" ");
	private By lblVerifyPastAgreements = MobileBy.xpath(" ");

	public void verifyBuyTokensHeading(String expHeading) {
		// new CommonFunctions().verifyLabelText(lblVerifyBuyTokens, "Heading ",
		// expHeading);
	}

	public String getBankAccountAmount() {
		return getText(lblBankAccountAmount);

	}

	public String getDebitCardAmount() {
		return getText(lblDebitCardAmount);
	}

	public String getCreditCardAmount() {
		return getText(lblCreditCardAmount);
	}

	public void VerifyWithdrawHeading(String expHeading) {
		// new CommonFunctions().verifyLabelText(lblVerifyWithdraw, "Heading ",
		// expHeading);
	}

	public String getInstantPayAccount() {
		return getText(lblInstantPayAmount);

	}

	public String getGiftCardAmount() {
		return getText(lblGiftCardAmount);

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
