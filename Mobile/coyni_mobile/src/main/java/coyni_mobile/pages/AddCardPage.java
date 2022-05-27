package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.MailingAddressComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddCardPage extends MobileFunctions {
	
	private By txtNameOnCard = MobileBy.xpath("//*[contains(@resource-id,'etName')]");
	private By txtCardNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By txtCardExp = MobileBy.xpath("//*[contains(@resource-id,'etExpiry')]");
	private By txtCVVorCVC = MobileBy.xpath("//*[contains(@resource-id,'etCVV')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	private By iconCamera = MobileBy.xpath("//*[contains(@resource-id,'readCardIV')]");
	
	public void fillNameOnCard(String nameOnCard) {
		click(txtNameOnCard, "NameOnCard");
		enterText(txtNameOnCard, nameOnCard, "NameOnCard");
	}
	public void fillCardNumber(String cardNumber) {
		click(txtCardNumber, "Card Number");
		enterText(txtCardNumber, cardNumber, "Card Number");
	}
	public void fillCardExp(String cardExp) {
		click(txtCardExp, "CardExp");
		enterText(txtCardExp, cardExp, "CardExp");
	}
	public void fillCVVorCVC(String cVVorCVC) {
		click(txtCVVorCVC, "CVVorCVC");
		enterText(txtCVVorCVC, cVVorCVC, "CVVorCVC");
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clickEnter();
	}
	public void clickNext() {
//		scrollDownToElement(btnNext,"Next");
//		DriverFactory.getDriver().hideKeyboard();
		click(btnNext, "Next");
	}
	public void clickCamera() {
		click(iconCamera, "Camera");
	}
	public void clickNameOnCard() {
		click(txtNameOnCard, "NameOnCard");
	}
	public void clickCardExp() {
		click(txtCardNumber, "Card Number");
	}
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}
}
