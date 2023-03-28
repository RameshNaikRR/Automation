package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.FieldValidationsComponent;
import coyni_mobile_merchant.components.MailingAddressComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddCardPage extends MobileFunctions {
	private By lblAddDebitHeading = MobileBy.xpath("//*[contains(@resource-id,'tvCardHead')]");
	private By lblAddCogentHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By txtNameOnCard = MobileBy.xpath("//*[contains(@resource-id,'etName')]");
	private By txtCardNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By txtCardExp = MobileBy.xpath("//*[contains(@resource-id,'etExpiry')]");
	private By txtCVVorCVC = MobileBy.xpath("//*[contains(@resource-id,'etCVV')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	private By iconCamera = MobileBy.xpath("//*[contains(@resource-id,'readCardIV')]");
	private By txtSignetWalletId = MobileBy.xpath("//*[contains(@resource-id,'etWalletId')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'Back')]|//*[contains(@resource-id,'closeIV')]");

	public void fillNameOnCard(String nameOnCard) {
		new CommonFunctions().verifyAutoFocusElement(txtNameOnCard, "NameOnCard");
		click(txtNameOnCard, "NameOnCard");
		enterText(txtNameOnCard, nameOnCard, "NameOnCard");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void scrollUpToNameOnCard() {
		scrollUpToElement(txtNameOnCard, "Name On Card");
	}

	public void fillCardNumber(String cardNumber) {
		click(txtCardNumber, "Card Number");
		enterText(txtCardNumber, cardNumber, "Card Number");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillCardExp(String cardExp) {
		click(txtCardExp, "CardExp");
		enterText(txtCardExp, cardExp, "CardExp");
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clickEnter();
	}

	public void fillCVVorCVC(String cVVorCVC) {
		click(txtCVVorCVC, "CVVorCVC");
		enterText(txtCVVorCVC, cVVorCVC, "CVVorCVC");
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clickEnter();
	}

	public void fillSignetWalletId(String signetWalletId) {
		click(txtSignetWalletId, "Signet Wallet ID");
		enterText(txtSignetWalletId, signetWalletId, "Signet Wallet ID");
	}

	public void verifyDebitCard(String addDebitHea) {
		new CommonFunctions().verifyLabelText(lblAddDebitHeading, "Add Debit Heading", addDebitHea);
	}

	public void verifyCogentAccount(String addCogentHeading) {
		new CommonFunctions().verifyLabelText(lblAddCogentHeading, "Add Cogent Heading", addCogentHeading);
	}

	public void validateErrMsg() {
		scrollUpToElement(txtNameOnCard, "NameOnCard");
	}

	public void clickNext() {
		scrollDownToElement(btnNext, "Next");
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

	public void clickBack() {
		click(btnBack, "Back");
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}
