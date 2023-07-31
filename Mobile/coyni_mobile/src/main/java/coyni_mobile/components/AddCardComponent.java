package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AddCardComponent extends MobileFunctions {

	/******
	 * 
	 */
	private By txtNameOnCard = MobileBy.id("com.coyni.mapp:id/etName");
	private By txtCardNumber = MobileBy.id("com.coyni.mapp:id/pnET");
	private By txtCardExp = MobileBy.id("com.coyni.mapp:id/etExpiry");
	private By txtCVVorCVC = MobileBy.id("com.coyni.mapp:id/etCVV");
	private By btnContinue = MobileBy.id("");
	private By iconCamera = MobileBy.id("com.coyni.mapp:id/readCardIV");
	private By imgCard = MobileBy.id("com.coyni.mapp:id/imgCardType");
	private By lblAddDebitCard = MobileBy.id("com.coyni.mapp:id/addDebitTextTV");
	private By lblAddCardDesc = MobileBy.id("com.coyni.mapp:id/tvCardMsg");
	private By btnNext = MobileBy.id("com.coyni.mapp:id/nextBtnTV");
	private By lblPopUpErrMsg = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By lblPlsConfirmBillingAdd = MobileBy.id("");
	private By btnOk = MobileBy.id("com.coyni.mapp:id/cvAction");

	public void viewAddcardDesc() {
		new CommonFunctions().elementView(lblAddCardDesc, "Add Card Description");
		ExtentTestManager.setPassMessageInReport(getText(lblAddCardDesc));
		new CommonFunctions().elementView(imgCard, "Card Image");
		new CommonFunctions().elementView(iconCamera, "Camera");
	}

	public void verifyPlsConfirmBillingAdd(String desc) {
		new CommonFunctions().verifyLabelText(lblPlsConfirmBillingAdd, "Please Confirm Billing", desc);
	}

	public void verifyAddDebitorCredHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblAddDebitCard, "Add Card Heading", hdg);
	}

	public void verifyInvalidPopupmsg(String hdg) {
		new CommonFunctions().verifyLabelText(lblPopUpErrMsg, "Popup error message", hdg);
	}

	public void fillNameOnCard(String nameOnCard) {
		click(txtNameOnCard, "NameOnCard");
		enterText(txtNameOnCard, nameOnCard, "NameOnCard");
	}

	public void clickNameOnCard() {
		click(txtNameOnCard, "NameOnCard");
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

	public void validateInvalidTypeCard() {
		if (getText(txtCardNumber).equals("") && getText(txtCardExp).equals("Expiry Date")
				&& getText(txtCVVorCVC).equals("CVV/CVC")) {
			ExtentTestManager.setPassMessageInReport(
					"After entering invalid card type details, it's refreshing the fields with empty values.");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"After entering invalid card type details, the fields are not being refreshed with empty values.");
		}
	}

	public void fillCardNumber(String cardNumber) {
		click(txtCardNumber, "CardNum");
		enterText(txtCardNumber, cardNumber, "Card Number");
	}

	public void fillCardExp(String cardExp) {
		click(txtCardExp, "CardExp");
		enterText(txtCardExp, cardExp, "CardExp");
	}

	public void fillCVVorCVC(String cVVorCVC) {
		click(txtCVVorCVC, "CVVorCVC");
		enterText(txtCVVorCVC, cVVorCVC, "CVVorCVC");
	}

	public void clickContinue() {
		new CommonFunctions().clickEnabledElement(btnContinue, "Continue");
	}

	public void clickNext() {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clickEnabledElement(btnNext, "Next");
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PreAuthorizationComponent preAuthorizationComponent() {
		return new PreAuthorizationComponent();
	}

}
