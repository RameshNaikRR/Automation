package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.FieldValidationsComponent;
import coyni_mobile.components.MailingAddressComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddCardPage extends MobileFunctions {
	
	private By heading = MobileBy.xpath("//*[contains(@resource-id,'tvCardHead')]");
	private By lblCardDescription = MobileBy.xpath("//*[contains(@resource-id,'tvCardMsg')]");
	private By txtNameOnCard = MobileBy.xpath("//*[contains(@resource-id,'etName')]");
	private By txtCardNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By txtCardExp = MobileBy.xpath("//*[contains(@resource-id,'etExpiry')]");
	private By txtCVVorCVC = MobileBy.xpath("//*[contains(@resource-id,'etCVV')]");
	private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
	private By iconCamera = MobileBy.xpath("//*[contains(@resource-id,'readCardIV')]");
	private By txtSignetWalletId = MobileBy.xpath("//*[contains(@resource-id,'etWalletId')]");
	private By lblCountryName= MobileBy.xpath("//*[contains(@resource-id,'etCountry')]|//*[contains(@resource-id,'countryET')]");
	private By btnAddCard = MobileBy.xpath("//*[contains(@resource-id,'cvAddCard')] | //*[contains(@resource-id,'cvAdd')]");
	private By lblErrHead = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblErrContent = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	
	
	public void verifyCardError(String expHeading, String expErrContent) {
		new CommonFunctions().verifyLabelText(lblErrHead, "Heading", expHeading);
		new CommonFunctions().verifyLabelText(lblErrContent, "Message", expErrContent);
		click(btnOk, "Ok");
	}
	public void verifyHeading(String expheading) {
		new CommonFunctions().verifyLabelText(heading, "Add card Heading", expheading);
		new CommonFunctions().elementView(lblCardDescription, "Card Description");
	}
	public void fillNameOnCard(String nameOnCard) {
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
	public void clickNext() {
	scrollDownToElement(btnNext,"Next");
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
	public void clickAddCardInAddress() {
	click(btnAddCard, "Add Card");	
	}
	public void verifyCountryName(String countryName) {
		new CommonFunctions().verifyLabelText(lblCountryName, "Country Name", countryName);
	}
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}
	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}
