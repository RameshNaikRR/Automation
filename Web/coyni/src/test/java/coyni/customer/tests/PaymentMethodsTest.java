package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.CustomerProfilePage;
import coyni.customer.pages.NavigationMenuPage;
import coyni.customer.popups.AddNewPaymentMethodPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;
public class PaymentMethodsTest{
	CustomerProfilePage customerProfilePage;
	NavigationMenuPage navigationMenuPage;

	@BeforeTest
    public void init() {
		customerProfilePage = new CustomerProfilePage();
		navigationMenuPage = new NavigationMenuPage();

	}

	@Test
	@Parameters({"strParams"})
	public void testExternalBankAccount(String strParams) {    
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickaddExternalBankAccount();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickLearnMore();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickBack();
			customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickIamReady();

		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test ExternalMethod failed due to exception " +e);
		}
	} 

	@Test
	@Parameters({"strParams"})
	public void testAddDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifyCardType(data.get(" "));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCVVorCVC(data.get("cvvNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("country"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickSave();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().clickDone();
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({"strParams"})
	public void testAddCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifyCardType(data.get(""));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCVVorCVC(data.get("cvvNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country")); 	
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickSave();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().clickDone();

		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test AddcreditCard failed due to exception  " +e);
		}
	}

	@Test
	@Parameters({"strParams"})
	public void testAddDebitCardWihInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("expiryDate"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("cvv"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
			if (!data.get("errMessage").isEmpty()) {

				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"),data.get("colour"));
			}
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickSave();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().clickDone();
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test AddDebitCardWith Invalid Data is failed due to exception " +  e);
		}
	}

	@Test
	@Parameters({"strParams"})
	public void testDebitAuthiWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("expiryDate"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("cvv"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickSave();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
			if (!data.get("errMessage").isEmpty()) 
			{
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"),data.get("colour"));
			}
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().clickDone();
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test AddDebitCardWith Invalid Data is failed due to exception " +  e);
		}
	}

	@Test
	@Parameters({"strParams"})
	public void testCreditCardWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCVVorCVC(data.get("cvvNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
			if (!data.get("errMessage").isEmpty())
			{

				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"),data.get("colour"));
			}
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickSave();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().clickDone();

		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddCreditCardWith Invalid Dta is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({"strParams"})
	public void testCreditCardWithInvalidPreAuthyAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifyCardType(data.get("cardType"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCVVorCVC(data.get("cvvNumber"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
			customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickSave();
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
			if (!data.get("errMessage").isEmpty()) 
			{
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"),data.get("colour"));
			}
			customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().clickDone();

		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddCreditCardWith Invalid Dta is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({"strParams"})
	public void testEditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.customerMenuComponent().clickPaymentMethods();
			customerProfilePage.paymentMethodsComponent().cardsComponent().clickEdit(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().fillCVVorCVC("cvvOrCVC");
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().clickSave();
			customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent().successFailurePopupCardComponent().clickClose();
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}
	
	@Test
	@Parameters({"strParams"})
	public void testDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.customerMenuComponent().clickPaymentMethods();
			customerProfilePage.paymentMethodsComponent().cardsComponent().clickDelete(data.get("cardNumber"));
			customerProfilePage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup().clickOnRemove();
			customerProfilePage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup().successFailurePopupCardComponent().clickClose();


		} catch (Exception e) {

		}
	}
}
