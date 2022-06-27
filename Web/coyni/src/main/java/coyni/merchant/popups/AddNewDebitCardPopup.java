package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.AddCardComponent;
import coyni.merchant.components.MailingAddressComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddNewDebitCardPopup extends BrowserFunctions{
	
	private By txtNameOnCard = By.xpath("//input[@id ='name-on-card']");
	private By txtCardNumber = By.name("cardNumber");
	private By lblCardType = By.xpath("//input[@id='card-number']/../following-sibling::*[1]");
	private By txtCardExp = By.name("expiryDate");
	private By txtCVVorCVC = By.name("cvv");
	private By lblErrorMsg = By.cssSelector("span.text-crd5 ");
	private By heading = By.cssSelector(".Heading_heading1__18f6i.mb-10.text-center");
	private By btnNext = By.xpath("//button[contains(text(),'Next')]");

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

	public void verifylblErrorMsg(String expErrorMsg) {
		new CommonFunctions().verifyLabelText(lblErrorMsg, "Error Message", expErrorMsg);

	}
	public void verifyAddNewDebitCardHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Add New Credit Card PopUp Heading", expHeading);
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
	
	public void selectState(String expOption) {
	       new CommonFunctions().selectCustomDropDown(expOption, "Alasak");
	}

	public void clickNext() {
		click(btnNext,"click Next");
	}
	
	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}
	
	public PreAuthorizationPopup preAuthorizationPopup() {
		return new PreAuthorizationPopup();
	}

}
