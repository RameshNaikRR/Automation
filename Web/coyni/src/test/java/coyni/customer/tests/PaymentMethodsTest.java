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

	
	public void testAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			//customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickLearnMore();
			//customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickBack();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickIamReady();
			Thread.sleep(5000);
           customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().verifyHeading();
            Thread.sleep(8000);
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().switchToWindow();
			
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().verifyNewWindowHeading();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().enterBankName(data.get("expBankName"));
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickOnBankName();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().enterUserName(data.get("expUserName"));;
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().enterPassword(data.get("expPassword"));
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickNext();;   
			Thread.sleep(5000);
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().unSelectBank();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickUncheckBank();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().switchToWindow();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().successFailurePopupCardComponent().verifyBankAddSuccesfulHeaading();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().successFailurePopupCardComponent().clickDone();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test ExternalMethod failed due to exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccountWithOutPaymentMethod(String strParams) {
		navigationMenuPage.clickTokenAccountMenu();
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
		customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
		customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickaddExternalBankAccount();
		testAddExternalBankAccount(strParams);
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
		navigationMenuPage.clickTokenAccountMenu();
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
	    customerProfilePage.paymentMethodsComponent().verifyBankName();
	    customerProfilePage.paymentMethodsComponent().clickDelete();
	    customerProfilePage.paymentMethodsComponent().removePaymentMethodPopup().verifyRemovePaymentHeading();
	    customerProfilePage.paymentMethodsComponent().removePaymentMethodPopup().clickOnRemove();
	    customerProfilePage.paymentMethodsComponent().removePaymentMethodPopup().successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
	    customerProfilePage.paymentMethodsComponent().removePaymentMethodPopup().successFailurePopupCardComponent().clickClose();
	} catch(Exception e) {
		ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
	}

	}


	public void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			
			Thread.sleep(2000);
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			}
			Thread.sleep(3000);
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
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		navigationMenuPage.clickTokenAccountMenu();
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
		customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
		customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
		testAddCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	
	public void testAddCreditCard(String strParams) {
		navigationMenuPage.clickTokenAccountMenu();
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
		customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
		customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
		testAddCard(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardWihInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
	         CustomerProfilePage customerProfilePage = new CustomerProfilePage(); 
			Thread.sleep(2000);
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			}
			Thread.sleep(3000);
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
	public void testCreditCardWithInvalidData(String strParams) {
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
		customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
		customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
		testAddCardWihInvalidData(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardWithInvalidData(String strParams) {
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
		customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
		customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
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
			Thread.sleep(3000);
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

			System.out.println(data.get("errMessage"));
			String[] msg = data.get("errMessage").split(",");
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
					.verifyFailedHeadingView();

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
			
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			
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
	public void testDebitCardEdit(String strParams) {
		navigationMenuPage.clickTokenAccountMenu();
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
	//	customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
		testEditCard(strParams);
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testCreditCardEdit(String strParams) {
		navigationMenuPage.clickTokenAccountMenu();
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
	//	customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
		testEditCard(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
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
	public void testDebitDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			testDeleteCard(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCreditDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
			testDeleteCard(strParams);

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
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			}

           Thread.sleep(3000);
		   customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateNameOnCard(data.get("nameOnCard"));
		   customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
			        .validateCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCVVorCVC(data.get("cvvNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateCity(data.get("city"));
		//	customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
			//		.mailingAddressComponent()
				//	.validateZipCode(data.get("zipCode"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardFieldValidations(String strParams)  {
		try {
		navigationMenuPage.clickTokenAccountMenu();
		tokenAccountPage.userNameDropDownComponent().clickUserName();
		tokenAccountPage.userNameDropDownComponent().clickPaymentMethods();
		Thread.sleep(2000);
		customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
		Thread.sleep(2000);
		customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();

		testCardsFieldValidations(strParams, "debit");
	}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("testDebitCardFieldValidations is"+e);
		}
	}
		

	@Test
	@Parameters({ "strParams" })
	public void testCreditCardFieldValidations(String strParams) {
		testCardsFieldValidations(strParams, "credit");
	}
	


}
