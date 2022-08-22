package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;

public class EditCardComponent extends BrowserFunctions {

	private By txtNameOnCard = By.id("name-on-card");
	private By txtCardNumber = By.name("cardNumber");
	private By lblCardType = By.xpath("//input[@id='card-number']/../following-sibling::*[1]");
	private By txtCardExp = By.name("expiryDate");
	private By txtCVVorCVC = By.name("cvv");
	private By lblErrorMsg = By.cssSelector("span.text-crd5 ");
	private By lblNewCreditCard = By.xpath("//h1[contains(text(),'Add New')]");

	public void fillNameOnCard(String nameOnCard) {
		enterText(txtNameOnCard, nameOnCard, "Name On Card");
	}

	public void fillCardNumber(String cardNumber) {
		enterText(txtCardNumber, cardNumber, "Card Number");
	}

	public void fillCardExpiry(String cardExpiry) {
		DriverFactory.getDriver().findElement(txtCardExp).clear();
		enterText(txtCardExp, cardExpiry, "Card Expiry");
	}

	public void fillCVVorCVC(String cvvOrCvc) {
		enterText(txtCVVorCVC, cvvOrCvc, "CVV or CVC");
	}

	public void verifylblErrorMsg(String expErrorMsg) {
		new CommonFunctions().verifyLabelText(lblErrorMsg, "Error Message", expErrorMsg);

	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

}
