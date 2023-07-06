package coyni.business.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.business.components.SideBarMenuComponent;
import coyni.business.pages.BusinessSettingsPage;
import coyni.business.pages.PaymentMethodPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class PaymentMethodsTest {
	SideBarMenuComponent sideBarMenuComponent;
	PaymentMethodPage paymentMethodPage;
	BusinessSettingsPage businessSettingsPage;

	@BeforeTest
	public void init() {
		sideBarMenuComponent = new SideBarMenuComponent();
		paymentMethodPage = new PaymentMethodPage();
		businessSettingsPage = new BusinessSettingsPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickPaymentMethods();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().bankDetails();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().removePaymentMethodPopup()
					.clickRemove();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	public void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().validateCardBrand(data.get("cardType"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().selectState(data.get("state"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().verifyCountry(data.get("country"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		try {
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickPaymentMethods();
			businessSettingsPage.paymentMethodsComponent().clickAddNewPaymentMethod();
			businessSettingsPage.paymentMethodsComponent().verifyPaymentMethodsview();
			testAddCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardWihInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			Thread.sleep(3000);
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			// businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().validateCardBrand(data.get("cardType"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCountry(data.get("country"));
			// businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));

			if (data.get("state").isEmpty()) {
				businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickstate();
				businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickstate();
				businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickTab();
			}
			if (!data.get("state").isEmpty()) {
				// businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
				businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			}
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickTab();
			// businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().backandCrossIconComponent().clickCross();

			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test AddDebitCardWith Invalid Data is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardWithInvalidData(String strParams) {
		try {
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickPaymentMethods();
			businessSettingsPage.paymentMethodsComponent().clickAddNewPaymentMethod();
			businessSettingsPage.paymentMethodsComponent().verifyPaymentMethodsview();
			testAddCardWihInvalidData(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test AddDebitCardWith Invalid Data is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessSettingsPage.paymentMethodsComponent().cardsComponent().editDeleteComponent()
					.clickEdit(data.get("cardNumber"));
			businessSettingsPage.paymentMethodsComponent().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			Thread.sleep(2000);
			businessSettingsPage.paymentMethodsComponent().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			Thread.sleep(2000);
			businessSettingsPage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			businessSettingsPage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			businessSettingsPage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.fillCity(data.get("city"));
			businessSettingsPage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.editSelectState(data.get("state"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			businessSettingsPage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().clickSave();
			// businessSettingsPage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
			// .successFailurePopupCardComponent().clickClose();

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardEdit(String strParams) {
		try {
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickPaymentMethods();
			businessSettingsPage.paymentMethodsComponent().clickAddNewPaymentMethod();
			businessSettingsPage.paymentMethodsComponent().verifyPaymentMethodsview();
			// businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			testEditCard(strParams);
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessSettingsPage.paymentMethodsComponent().cardsComponent().editDeleteComponent()
					.clickDelete(data.get("cardNumber"));
			businessSettingsPage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup().clickRemove();
			// businessSettingsPage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup()
			// .successFailurePopupCardComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitDeleteCard(String strParams) {
		try {
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickPaymentMethods();
			businessSettingsPage.paymentMethodsComponent().clickAddNewPaymentMethod();
			businessSettingsPage.paymentMethodsComponent().verifyPaymentMethodsview();
			testDeleteCard(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCardsFieldValidations(String strParams, String card) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();

			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();

			Thread.sleep(3000);
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateNameOnCard(data.get("nameOnCard"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardExpiry(data.get("cardExpiry"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress1(data.get("address1"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress2(data.get("address2"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateCity(data.get("city"));
			// businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
			// .mailingAddressComponent()
			// .validateZipCode(data.get("zipCode"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardFieldValidations(String strParams) {
		try {
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickPaymentMethods();
			businessSettingsPage.paymentMethodsComponent().clickAddNewPaymentMethod();
			businessSettingsPage.paymentMethodsComponent().verifyPaymentMethodsview();
			testCardsFieldValidations(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDebitCardFieldValidations is" + e);
		}
	}

}
