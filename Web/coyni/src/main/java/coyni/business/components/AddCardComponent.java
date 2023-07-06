package coyni.business.components;

import org.openqa.selenium.By;

import coyni.business.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class AddCardComponent extends BrowserFunctions {
	private By txtNameOnCard = By.id("name-on-card");
	private By txtCardNumber = By.name("cardNumber");
	private By lblCardType = By.xpath("//input[@id='card-number']/../following-sibling::*[1]");
	private By txtCardExp = By.name("expiryDate");
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

	public void verifylblErrorMsg(String expErrorMsg) {
		new CommonFunctions().verifyLabelText(lblErrorMsg, "Error Message", expErrorMsg);

	}

	public void verifyAddNewCreditCard(String expHeading) {
		new CommonFunctions().verifyLabelText(lblNewCreditCard, "Add New Credit Card PopUp Heading", expHeading);
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public void clickClose() {
		new NavigationComponent().clickClose();

	}

	public void clickBack() {
		new NavigationComponent().clickBack();
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

	/**
	 * Order -minChar, minCharPlus, maxCharMinus, maxChar, specialChar, Number,
	 * spaces maxiPlus
	 */
	public void validateNameOnCard(String nameOnCard) {
		new HomePage().validateNameField(txtNameOnCard, "Name on Card", nameOnCard);
	}

	public void validateCardNumber(String cardNumber) {
		validateCardNumberAndCvv(txtCardNumber, "Card Number", cardNumber);
	}

	public void validateCardExpiry(String cardExpiry) {
		new HomePage().validateNumber(txtCardExp, "Card Expiry", cardExpiry);
	}

	/**
	 * Order -minChar, maxChar, specialChar, alphabets, spaces ,maxiPlus
	 */
	public void validateCardNumberAndCvv(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 2; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		for (int i = 2; i < 5; i++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[5]);
	}

}
