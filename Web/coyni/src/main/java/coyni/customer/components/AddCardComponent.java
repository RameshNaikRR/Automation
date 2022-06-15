package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.customer.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class AddCardComponent extends BrowserFunctions {

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
	public void validateCVVorCVC(String cvvOrCVC) {
		validateCardNumberAndCvv(txtCVVorCVC, "CVV or CVC", cvvOrCVC);
	}
	/**
	 * Order -minChar, maxChar, specialChar, alphabets,
	 * spaces ,maxiPlus
	 */
	public void validateCardNumberAndCvv(By ele,String eleName, String textField) {
		String[] field = textField.split(",");
		for(int i=0;i<2;i++) {
		new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		for (int i = 2; i < 5; i++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[5]);
	}

//	public void validateNameOnCard(String minChar,String minCharPlus,  String maxLessChar, String maxChar, String moreThanMaxChar, String number,
//			String specialChar) {
//		new CommonFunctions().validateFieldWithSpecialchar(txtNameOnCard, "Name on Card", specialChar);
//		new CommonFunctions().clearText(txtNameOnCard, "Name on card");
//		new CommonFunctions().validateFieldWithNumber(txtNameOnCard, "Name on Card", number);
//		new CommonFunctions().clearText(txtNameOnCard, "Name on card");
//		new CommonFunctions().validateFieldMaxichar(txtNameOnCard, "Name on Card", moreThanMaxChar);
//		new CommonFunctions().clearText(txtNameOnCard, "Name on card");
//		new CommonFunctions().validateField(txtNameOnCard, "Name on Card", maxChar);
//		new CommonFunctions().clearText(txtNameOnCard, "Name on card");
//		new CommonFunctions().validateField(txtNameOnCard, "Name on Card", maxLessChar);
//		new CommonFunctions().clearText(txtNameOnCard, "Name on card");
//		new CommonFunctions().validateField(txtNameOnCard, "Name on Card", minCharPlus);
//		new CommonFunctions().clearText(txtNameOnCard, "Name on card");
//		new CommonFunctions().validateField(txtNameOnCard, "Name on Card", minChar);
//
//	}
//
//	public void validateCardNumber(String minChar, String maxChar, String moreThanMaxChar, String specialChar,
//			String alphabets) {
//
//		new CommonFunctions().validateFieldWithSpecialchar(txtCardNumber, "Card Number", specialChar);// #$@!
//		new CommonFunctions().clearText(txtCardNumber, "Card Number");
//		new CommonFunctions().validateFieldWithalphabet(txtCardNumber, "Card Number", alphabets);
//		new CommonFunctions().clearText(txtCardNumber, "Card Number");
//		new CommonFunctions().validateFieldMaxichar(txtCardNumber, "Card Number", moreThanMaxChar);
//		new CommonFunctions().clearText(txtCardNumber, "Card Number");
//		new CommonFunctions().validateField(txtCardNumber, "Card Number", maxChar);
//		new CommonFunctions().clearText(txtCardNumber, "Card Number");
//		new CommonFunctions().validateField(txtCardNumber, "Card Number", minChar);
//
//	}
//
//	public void validateCardExpiry(String minChar, String moreThanMaxChar, String specialChar, String alphabets) {
//
//		new CommonFunctions().validateFieldWithSpecialchar(txtCardExp, "Card Expiry", specialChar);// #$@!
//		new CommonFunctions().clearText(txtCardExp, "Card Expiry");
//		new CommonFunctions().validateFieldWithalphabet(txtCardExp, "Card Expiry", alphabets);// abcg
//		new CommonFunctions().clearText(txtCardExp, "Card Expiry");
//		new CommonFunctions().validateFieldMaxichar(txtCardExp, "Card Expiry", moreThanMaxChar);// 5
//		new CommonFunctions().clearText(txtCardExp, "Card Expiry");
//		new CommonFunctions().validateField(txtCardExp, "Card Expiry", minChar);// 4
//
//	}
//
//	public void validateCVVorCVC(String minChar, String maxChar, String moreThanMaxChar, String specialChar,
//			String alphabets) throws InterruptedException {
//
//		new CommonFunctions().validateFieldWithSpecialchar(txtCVVorCVC, "CVVorCVC", specialChar);
//		new CommonFunctions().clearText(txtCVVorCVC, "CVVorCVC");
//		new CommonFunctions().validateFieldWithalphabet(txtCVVorCVC, "CVVorCVC", alphabets);
//		new CommonFunctions().clearText(txtCVVorCVC, "CVVorCVC");
//		new CommonFunctions().validateField(txtCVVorCVC, "CVCorCVC", minChar);
//		new CommonFunctions().clearText(txtCVVorCVC, "CVVorCVC");
//		new CommonFunctions().validateField(txtCVVorCVC, "CVCorCVC", maxChar);
//		new CommonFunctions().clearText(txtCVVorCVC, "CVVorCVC");
//		new CommonFunctions().validateFieldMaxichar(txtCVVorCVC, "CVVorCVC", moreThanMaxChar);
//	}

}
