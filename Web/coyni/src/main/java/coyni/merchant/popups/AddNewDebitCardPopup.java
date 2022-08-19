package coyni.merchant.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.merchant.components.AddCardComponent;
import coyni.merchant.components.MailingAddressComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.pages.SignupPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddNewDebitCardPopup extends BrowserFunctions {
	private By heading = By.cssSelector("//div[@class='modal__body']/h1");
	private By txtNameOnCard = By.xpath("//input[@id ='name-on-card']");
	private By txtCardNumber = By.name("cardNumber");
	private By lblCardType = By.xpath("//input[@id='card-number']/../following-sibling::*[1]");
	private By txtCardExp = By.name("expiryDate");
	private By txtCVVorCVC = By.name("cvv");
	private By txtBillingAddress1 = By.cssSelector("input[id='billing-address-line-1']");
	private By txtBillingAddress2 = By.cssSelector("input[id='billing-address-line-2']");
	private By txtCity = By.cssSelector("input[id='city']");
	private By drpDwnState = By.xpath("//div[.='State']");
	private By states = By.xpath("//div[@class='flex items-center justify-between pr-3 cursor-pointer']");
	private By txtZipCode = By.xpath("input[id='zip-code']");
	private By txtCountry = By.xpath("//div[.='United States']");

	private By lblErrorMsg = By.cssSelector("span.text-crd5 ");
	private By btnNext = By.xpath("//button[contains(text(),'Next')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Add New Credit Card PopUp Heading", expHeading);
	}

	public void fillNameOnCard(String nameOnCard) {
		enterText(txtNameOnCard, nameOnCard, "Name On Card");
	}

	public void fillCardNumber(String cardNumber) {
		enterText(txtCardNumber, cardNumber, "Card Number");
	}

	public void fillCardExpiry(String cardExpiry) {
		enterText(txtCardExp, cardExpiry, "Card Expiry");
	}

	public void fillCardCVVorCVC(String cvvOrCvc) {
		enterText(txtCVVorCVC, cvvOrCvc, "CVV or CVC");
	}

	public void fillBillingAddress1(String CVV) {
		enterText(txtBillingAddress1, CVV, "Card CVV");
	}

	public void fillBillingAddress2(String CVV) {
		enterText(txtBillingAddress2, CVV, "Card CVV");
	}

	public void fillCity(String City) {
		enterText(txtCity, City, "City");
	}

	public void verifyStateDrpDwn() {
		new CommonFunctions().elementView(drpDwnState, "Drop down button");
//		click(drpDwnState, "Drop down button");
	}

	public void clickStateDrpDwn() {
		click(drpDwnState, "Drop down button");
	}

	public void clickStates() {
		List<WebElement> list = getElementsList(states, "");
		for (WebElement element : list) {
			click(drpDwnState, "Drop down button");
			element.click();
		}
	}

	public void fillZipCode(String Zipcode) {
		enterText(txtZipCode, Zipcode, "Zip code");
	}

	public void verifyCountryTxtField() {
		new CommonFunctions().elementView(txtCountry, "country text field");
	}

	public void verifylblErrorMsg(String expErrorMsg) {
		new CommonFunctions().verifyLabelText(lblErrorMsg, "Error Message", expErrorMsg);

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
		new SignupPage().validateNameField(txtNameOnCard, "Name on Card", nameOnCard);
	}

	public void validateCardNumber(String cardNumber) {
		validateCardNumberAndCvv(txtCardNumber, "Card Number", cardNumber);
	}

	public void validateCardExpiry(String cardExpiry) {
		new SignupPage().validateNumber(txtCardExp, "Card Expiry", cardExpiry);
	}

	public void validateCVVorCVC(String cvvOrCVC) {
		validateCardNumberAndCvv(txtCVVorCVC, "CVV or CVC", cvvOrCVC);
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

	public void selectState(String expOption) {
		new CommonFunctions().selectCustomDropDown(expOption, "Alasak");
	}

	public void clickNext() {
//		WebDriver driver = DriverFactory.getDriver();
//		driver.get(btnNext);
		String text = getText(btnNext, "");
		boolean parseBoolean = Boolean.parseBoolean(text);
		if (parseBoolean) {
			click(btnNext, "click Next");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next button is in disabled mode");
		}
	}

	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

	public PreAuthorizationPopup preAuthorizationPopup() {
		return new PreAuthorizationPopup();
	}

	public CardAddedSuccessfullyPopup cardAddedSuccessfullyPopup() {
		return new CardAddedSuccessfullyPopup();
	}

}
