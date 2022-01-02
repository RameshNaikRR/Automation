package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddNewPaymentComponent extends MobileFunctions{
	
	private By lblHeading =MobileBy.xpath("//*[@name='Add Payment Method']");
	private By btnExternalBank =MobileBy.xpath("//*[contains(@name,'External Bank')]");
	private By btnDebitCard = MobileBy.xpath("//*[@name='Debit Card']");
	private By btnCreditCard =MobileBy.xpath("//*[@name='Credit Card']");
	
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
	
	
}
