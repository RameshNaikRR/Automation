package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddCardComponent extends BrowserFunctions {

	private By txtNameOnCard = By.id("name-on-card");
	private By txtCardNumber = By.name("cardNumber");
	private By lblCardType = By.xpath("//input[@id='card-number']/../following-sibling::*[1]");
	private By txtCardExp = By.name("expiryDate");
	private By txtCVVorCVC = By.name("cvv");
	private By lblErrorMsg = By.cssSelector("span.text-crd5 ");
	private By lblNewCreditCard = By.cssSelector(".Heading_heading1__18f6i.mb-10.text-center");

	public void fillNameOnCard(String nameOnCard) {
		enterText(txtNameOnCard, nameOnCard, "Name On Card");
	}

	public void fillCardNumber(String cardNumber) {
		enterText(txtCardNumber, cardNumber, "Card Number");
	}

	public void fillCardExpiry(String cardExpiry) {
		enterText(txtCardExp, cardExpiry, "Card Expiry");
	}

	public void fillCVVorCVC(String cvvOrCvc) {
		enterText(txtCVVorCVC, cvvOrCvc, "CVV or CVC");
	}

	public void switchToWindow() {
		new CommonFunctions().switchTodWindow();
	}

	public void verifylblErrorMsg(String expErrorMsg) {
		new CommonFunctions().verifyLabelText(lblErrorMsg, "Error Message", expErrorMsg);

	}

	public void verifyAddNewCreditCard(String expHeading) {
		new CommonFunctions().verifyLabelText(lblNewCreditCard, "Add New Credit Card PopUp Heading", expHeading);
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public void validateCardBrand(String cardType) {

		String brandClass = getAttributeValue(lblCardType, "class", "card brand");
		System.out.println(brandClass);
		cardType = cardType.toLowerCase();
		if (brandClass.contains(cardType)) {
			ExtentTestManager.setPassMessageInReport("valid card type: " + cardType.toUpperCase());
		} else {
			ExtentTestManager.setFailMessageInReport("invalid card type: " + cardType.toUpperCase());
		}
	}

	public void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 7; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[7]);
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

}
