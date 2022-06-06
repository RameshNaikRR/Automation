package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.AddCardPage;
import coyni_mobile.pages.PaymentMethodsPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddNewPaymentComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Add Payment Method']");
	private By btnExternalBank = MobileBy.xpath("//*[contains(@resource-id,'lyAddExternal')]");
	private By btnDebitCard = MobileBy
			.xpath("//*[@text='Debit Card']");
	private By btnCreditCard = MobileBy.xpath("//*[contains(@resource-id,'imgCCardArrowC')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
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

	public AddExternalBankAccountComponent addExternalBankAccountComponent() {
		return new AddExternalBankAccountComponent();
	}

	public AddCardPage addCardPage() {
		return new AddCardPage();
	}
	
}
