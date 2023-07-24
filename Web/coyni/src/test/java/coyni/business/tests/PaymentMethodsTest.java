package coyni.business.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
	public void testAddBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.clickBankAccount();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup().verifyHeading();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup()
					.clickOnMXBankCheckBox();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup().clickNext();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup().clickOnMxBank();
//			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup()
//					.enterBankName(data.get("expBankName"));
			Thread.sleep(3000);
//			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup()
//					.clickOnBankName();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup()
					.clickOnChecking();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup().clickContinue();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup()
					.enterUserName(data.get("expUserName"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup()
					.enterPassword(data.get("expPassword"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup().clickNext();
			Thread.sleep(5000);

			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addBankAccountPopup()
					.successFailureComponent().verifyBankAddSuccesfulHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Bank Account failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccount(String strParams) throws InterruptedException {
		sideBarMenuComponent.clickBusinessSettings();
		sideBarMenuComponent.businessSettingsPage().clickPaymentMethods();
		sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().clickAddNewPaymentMethod();
		testAddBank(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickPaymentMethods();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().editandDeleteComponent()
					.clickBankAccountDelete(data.get("last4digits"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().removePaymentMethodPopup()
					.verifyRemovePaymentHeading(data.get("removeHeading"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().removePaymentMethodPopup()
					.verifyRemovePayDescription(data.get("removeDescription"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().removePaymentMethodPopup()
					.verifyRemovePaymentDescription(data.get("removeDesc"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().removePaymentMethodPopup()
					.clickRemove();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().removePaymentMethodPopup()
					.toastComponent().verifyToastMessage(data.get("toastMessage"));

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
					.addCardComponent().mailingAddressComponent().clickNext();
			Thread.sleep(4000);
			ExtentTestManager
					.setInfoMessageInReport("The debit card has been successfully added to your payment methods.");
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

			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().fillCardNumber(data.get("cardNumber"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().fillCardExpiry(data.get("cardExpiry"));

			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().selectState(data.get("state"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().verifyCountry(data.get("country"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().clickTab();
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().clickNext();
			Thread.sleep(3000);

			System.out.println(data.get("errMessage"));
			String[] msg = data.get("errMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				new CommonFunctions().validateFormErrorMessage(msg[i]);
			}
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().clickNext();
//			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent()
//					.cardAddedSuccessfullyPopup().navigationComponent().clickClose();

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
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
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

			Thread.sleep(2000);
			businessSettingsPage.paymentMethodsComponent().cardsComponent().editDeleteComponent()
					.clickEdit(data.get("last4digits"));
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
			sideBarMenuComponent.businessSettingsPage().paymentMethodsComponent().addNewPaymentMethodPopup()
					.addCardComponent().mailingAddressComponent().selectState(data.get("state"));
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			businessSettingsPage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().clickSave();

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
			businessSettingsPage.paymentMethodsComponent().verifyPaymentMethodsview();
//			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
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
					.clickDelete(data.get("last4digits"));
			Thread.sleep(2000);
			businessSettingsPage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup().clickRemove();

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
			businessSettingsPage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			testCardsFieldValidations(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDebitCardFieldValidations is" + e);
		}
	}

}
