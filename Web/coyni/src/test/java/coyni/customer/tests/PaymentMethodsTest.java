package coyni.customer.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.pages.CustomerProfilePage;
import coyni.customer.pages.NavigationMenuPage;
import coyni.customer.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class PaymentMethodsTest {
	CustomerProfilePage customerProfilePage;
	NavigationMenuPage navigationMenuPage;
	TokenAccountPage tokenAccountPage;

	@BeforeTest
	public void init() {
		customerProfilePage = new CustomerProfilePage();
		navigationMenuPage = new NavigationMenuPage();
		tokenAccountPage = new TokenAccountPage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickaddExternalBankAccount();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickLearnMore();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickBack();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickIamReady();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test ExternalMethod failed due to exception " + e);
		}
	}

	public void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
			customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
			Thread.sleep(2000);
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			}
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardBrand(data.get("cardType"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent()
					.clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		testAddCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCreditCard(String strParams) {
		testAddCard(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardWihInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
			customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
			Thread.sleep(2000);
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			}
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().validateCardBrand(data.get("cardType"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));

			if (data.get("state").isEmpty()) {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickstate();
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickstate();
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickTab();
			}
			if (!data.get("state").isEmpty()) {
				// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			}
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickTab();
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().backandCrossIconComponent().clickCross();

			if (!data.get("errorMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

				new CommonFunctions().validateFormErrorMessage(data.get("errorMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test AddDebitCardWith Invalid Data is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCreditCardWithInvalidData(String strParams) {
		testAddCardWihInvalidData(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardWithInvalidData(String strParams) {
		testAddCardWihInvalidData(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCardAuthiWithInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
			customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			}
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().validateCardBrand(data.get("cardType"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			Thread.sleep(3000);

			System.out.println(data.get("errorMessage"));
			String[] msg = data.get("errorMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				Thread.sleep(2000);
				customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
				Thread.sleep(2000);
				customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickTab();
				customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
				// customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().verifyAddBankAccountview();
				new CommonFunctions().validateFormErrorMessage(msg[i]);
			}
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickTab();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent()
					.verifyheadingview();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test AddDebitAuthidWith Invalid Data is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCreditCardWithInvalidPreAuthyAmount(String strParams) {
		testCardAuthiWithInvalidData(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardWithInvalidPreAuthyAmount(String strParams) {
		testCardAuthiWithInvalidData(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			customerProfilePage.paymentMethodsComponent().cardsComponent().editDeleteComponent()
					.clickEdit(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.selectState(data.get("state"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().clickSave();
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
					.successFailurePopupCardComponent().clickClose();

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			customerProfilePage.paymentMethodsComponent().cardsComponent().editDeleteComponent()
					.clickDelete(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup().clickOnRemove();
			customerProfilePage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup()
					.successFailurePopupCardComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCardsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
			//customerProfilePage.paymentMethodsComponent().verifyAddNewPaymentMethods(data.get("verifyHeading"));
			//customerProfilePage.paymentMethodsComponent();
			//customerProfilePage.paymentMethodsComponent().addCardComponent().clickClose();
			//customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifyAddNewCreditCard(data.get("verifyAddNewCardHeading"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().clickBack();
			customerProfilePage.paymentMethodsComponent().verifyAddNewPaymentMethods(data.get("verifyHeading"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().clickClose();
			customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
			customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().clickClose();
			customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
			
			
			
	} catch (Exception e) {
           ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testCardsFieldValidations(String strParams, String card) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();

			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			}

			String[] name = data.get("nameOnCard").split(",");
			String[] number = data.get("cardNumber").split(",");
			String[] expiry = data.get("cardExpiry").split(",");
			String[] cvv = data.get("cvvNumber").split(",");
			String[] address1 = data.get("address1").split(",");
			String[] address2 = data.get("address2").split(",");
			String[] city = data.get("city").split(",");
			String[] zipcode = data.get("zipCode").split(",");

			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateNameOnCard(name[0], name[1], name[2], name[3], name[4],name[5],name[6]);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardNumber(number[0], number[1], number[2], number[3], number[4]);
			Thread.sleep(3000);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardExpiry(expiry[0], expiry[1], expiry[2], expiry[3]);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCVVorCVC(cvv[0], cvv[1], cvv[2], cvv[3], cvv[4]);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress1(address1[0], address1[1], address1[2],address1[3],address1[4]);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().vaidateAddress2(address2[0], address2[1], address2[2],address2[3],address2[4]);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateCity(city[0], city[1], city[2], city[3], city[4],city[5],city[6]);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent()
					.validateZipCode(zipcode[0], zipcode[1], zipcode[2], zipcode[3]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardFieldValidations(String strParams) {
		testCardsFieldValidations(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCreditCardFieldValidations(String strParams) {
		testCardsFieldValidations(strParams, "credit");
	}
	


}
