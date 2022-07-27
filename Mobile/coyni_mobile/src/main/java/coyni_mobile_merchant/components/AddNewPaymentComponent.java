package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.AddCardPage;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;


public class AddNewPaymentComponent extends MobileFunctions{
	private By lblHeading = MobileBy.xpath("//*[@text='Add Payment Method']");
	private By btnExternalBank = MobileBy.xpath("//*[contains(@resource-id,'tvBankHead')]");
	private By btnDebitCard = MobileBy.xpath("//*[contains(@resource-id,'tvBDCHead')]");
	private By btnCreditCard = MobileBy.xpath("//*[contains(@resource-id,'layoutCCard')]");
	private By btnSignetAccount = MobileBy.xpath("//*[contains(@resource-id,'tvSignetHead')]");


	public void verifyHeading(String expHeading) {
		if (getElementList(lblHeading, "Heading").size() > 0) {
			new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);

		}

	}

	public void clickExternalBankAcount() {
		click(btnExternalBank, "External Bank Account");
	}

	public void clickDebitCard() {
		click(btnDebitCard, "Debit Card");
	}

	public void clickCreditCard() {
		click(btnCreditCard, "Credit Card");
	}

	public void clickSignetAccount() {
		click(btnSignetAccount, "Signet Account");
	}

	public AddExternalBankAccountComponent addExternalBankAccountComponent() {
		return new AddExternalBankAccountComponent();
	}

//	public AddExternalBankAccountComponent addExternalBankAccountComponent() {
//		return new AddExternalBankAccountComponent();
//	}

	public AddCardPage addCardPage() {
		return new AddCardPage();
	}
}
