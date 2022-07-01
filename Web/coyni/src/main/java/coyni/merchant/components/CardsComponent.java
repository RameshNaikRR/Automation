package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.customer.popups.RemovePaymentMethodPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CardsComponent extends BrowserFunctions {

	private By lblCardNumber = By.cssSelector(".text-base.font-semibold.text-cgy4");
	private By lblCardBrand = By.cssSelector("");
	private By lblCardType = By.cssSelector(".icon-mastercard");
	private By iconEdit = By.cssSelector(".icon-edit.PaymentMethod_action_icon__3z0Dn");
	private By iconDelete = By.cssSelector(".icon-trash.PaymentMethod_action_icon__3z0Dn");
	private By lblAddress = By.cssSelector(".relative.mt-4");
	private By lblExpired = By.cssSelector("");

	public void verifyCardNumber(String last4digts) {
		new CommonFunctions().verifyLabelText(lblCardNumber, "Last 4 Digits", last4digts);
	}

	public void verifyCardBrand(String cardBrand) {
		new CommonFunctions().verifyLabelText(lblCardBrand, "Card Brand", cardBrand);
	}

	public void verifyCardType(String cardType) {
		new CommonFunctions().verifyLabelText(lblCardType, "Card Type", cardType);
	}

	public void verifyCardAddresss(String address) {
		new CommonFunctions().verifyLabelText(lblAddress, "Address", address);
	}

	// DOUBT - are we going to add the parameter "card Number " in the xpath of
	// lblExpired?
	public void verifyCardExpired(String cardNumber, String expExpired) {
		new CommonFunctions().verifyLabelText(lblExpired, "Expired", expExpired);
	}

	public void clickEdit() {
		click(iconEdit, "Edit icon");
	}

	// DOUBT
	public void clickDelete(String cardNumber) {
		click(iconDelete, "Delete icon");
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}

	public EditandDeleteComponent editDeleteComponent() {
		return new EditandDeleteComponent();
	}

}
