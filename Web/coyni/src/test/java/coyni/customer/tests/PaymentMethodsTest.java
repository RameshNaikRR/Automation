package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.CustomerProfilePage;
import coyni.customer.pages.NavigationMenuPage;
import coyni.customer.popups.AddNewPaymentMethodPopup;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;
    public class PaymentMethodsTest{
	 CustomerProfilePage customerProfilePage;
	
    @BeforeTest
 
   public void init() {
   customerProfilePage = new CustomerProfilePage();
   
   
   }
    
    @Test
    @Parameters({"strParams"})
    public void testExternalBankAccount(String strParams) {    	try {
    	 Map<String, String> data = Runner.getKeywordParameters(strParams);
    	customerProfilePage.paymentMethodsComponent().clickAddNewPaymentMethod();
    	customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickaddExternalBankAccount();
    	customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickLrnmore();
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
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifylblErrorMsg(data.get("cardHolderNameErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("expiryDate"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifylblErrorMsg(data.get("cardNumberErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("cvv"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifylblErrorMsg(data.get("expiryErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifylblErrorMsg(data.get("cvvrErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifylblErrorMsg(data.get("Address1ErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifylblErrorMsg(data.get("Address2ErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifylblErrorMsg(data.get("cityErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().verifylblErrorMsg(data.get("ZipCodeErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickSave();
    	     customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
    	     customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().clickOnVerify();
    	     customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().VerifyErrorMessage(data.get("preAuthiErrorMessage"));
    	     customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().clickDone();
    	     }catch (Exception e) {
		   ExtentTestManager.setFailMessageInReport("test AddDebitCardWith Invalid Data is failed due to exception " +  e);
	   }
   }
   }
 