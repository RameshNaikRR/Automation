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
	private By lblAddCredorDebit = MobileBy.id("");
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
	private By lblPlsConfirmBillingAdd = MobileBy.id("");

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

	public void fillNameOnCard(String nameOnCard) {
		enterText(txtNameOnCard, nameOnCard, "NameOnCard");
	}

	public void fillCardNumber(String cardNumber) {
		click(txtCardNumber, "CardNum");
		enterText(txtCardNumber, cardNumber, "Card Number");
	}

	public void fillCardExp(String cardExp) {
		enterText(txtCardExp, cardExp, "CardExp");
	}

	public void fillCVVorCVC(String cVVorCVC) {
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
