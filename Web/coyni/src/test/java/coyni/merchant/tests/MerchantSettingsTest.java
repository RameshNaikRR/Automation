package coyni.merchant.tests;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.SideBarMenuComponent;
import coyni.merchant.components.MerchantSettingsSideBarMenuComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantSettingsTest {
	SideBarMenuComponent sideBarMenuComponent;
	MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent;

	@BeforeTest
	public void init() {
		sideBarMenuComponent = new SideBarMenuComponent();
		merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
	}

//	@Test
//	public void testBusinessSettingsSideBarView() {
//		Map<String, String> data = Runner.getKeywordParameters(null);
//		sideBarMenuComponent.clickBusinessSettings();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyHeading(data.get("heading"));
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyUserImageView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountIdView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().getAccountId(data.get("accountID"));
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountStatusView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountStatus(data.get("accountStatus"));
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyCompanyInformationView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyDBAInformationView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyBeneficiaryOwnersView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickBeneficiaryOwner();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyPaymentMethodsView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickPaymentMethods();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyPreferencesView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickPreferences();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAgreementsView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickAgreements();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyFeesView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickFees();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountLimitsView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickAccountLimits();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyTeamView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickTeam();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyIpAddressesView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyApiKeyView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickApiKey();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyWebHooksView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
//	}

	public void testAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			// customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickLearnMore();
			// customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickBack();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.clickaddExternalBankAccount();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().clickIamReady();
			Thread.sleep(5000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().verifyHeading();
			Thread.sleep(8000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.switchToWindow();

			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.verifyNewWindowHeading();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.enterBankName(data.get("expBankName"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.clickOnBankName();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.enterUserName(data.get("expUserName"));
			;
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.enterPassword(data.get("expPassword"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().clickNext();
			;
			Thread.sleep(5000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().unSelectBank();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.clickUncheckBank();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.switchToWindow();
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.successFailurePopupCardComponent().verifyBankAddSuccesfulHeaading();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.successFailurePopupCardComponent().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test ExternalMethod failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccountWithOutPaymentMethod(String strParams) {
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		testAddExternalBankAccount(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyBankName();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickDeleteBank();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup()
					.verifyRemovePaymentHeading();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup().clickOnRemove();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup()
					.successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
			// customerProfilePage.paymentMethodsComponent().removePaymentMethodPopup().successFailurePopupCardComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	public void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();

			Thread.sleep(2000);
			if (card.equalsIgnoreCase("credit")) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickCreditCard();
			} else {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickDebitCard();
			}
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardBrand(data.get("cardType"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
					.fillAmount(data.get("amount"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickOnVerify();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
					.successFailurePopupCardComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
		testAddCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })

	public void testAddCreditCard(String strParams) {
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
		testAddCard(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardWihInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			Thread.sleep(2000);
			if (card.equalsIgnoreCase("credit")) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickCreditCard();
			} else {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickDebitCard();
			}
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().validateCardBrand(data.get("cardType"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));

			if (data.get("state").isEmpty()) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().clickstate();
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().clickstate();
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().clickTab();
			}
			if (!data.get("state").isEmpty()) {
				// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			}
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
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

		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
		testAddCardWihInvalidData(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardWithInvalidData(String strParams) {

		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
		testAddCardWihInvalidData(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCardAuthiWithInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
			if (card.equalsIgnoreCase("credit")) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickCreditCard();
			} else {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickDebitCard();
			}
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().validateCardBrand(data.get("cardType"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			Thread.sleep(3000);

			System.out.println(data.get("errMessage"));
			String[] msg = data.get("errMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				Thread.sleep(2000);
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
						.fillAmount(data.get("amount"));
				Thread.sleep(2000);
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickTab();
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickOnVerify();
				// customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().verifyAddBankAccountview();
				new CommonFunctions().validateFormErrorMessage(msg[i]);
			}
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
					.fillAmount(data.get("amount"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickTab();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickOnVerify();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
					.successFailurePopupCardComponent().verifyFailedHeadingView();

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

			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();

			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

			merchantSettingsSideBarMenuComponent.paymentMethodComponent().cardsComponent().editDeleteComponent()
					.clickEdit(data.get("cardNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
					.fillCity(data.get("city"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
					.selectState(data.get("state"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
					.clickSave();
			// customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
			// .successFailurePopupCardComponent().clickClose();

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardEdit(String strParams) {

		// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
		testEditCard(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testCreditCardEdit(String strParams) {

		// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
		testEditCard(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().cardsComponent().editDeleteComponent()
					.clickDelete(data.get("cardNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().cardsComponent().removePaymentMethodPopup()
					.clickOnRemove();
			// customerProfilePage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup()
			// .successFailurePopupCardComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

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

			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
			// customerProfilePage.paymentMethodsComponent().verifyAddNewPaymentMethods(data.get("verifyHeading"));
			// customerProfilePage.paymentMethodsComponent();
			// customerProfilePage.paymentMethodsComponent().addCardComponent().clickClose();
			// customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickCreditCard();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.verifyAddNewCreditCard(data.get("verifyAddNewCardHeading"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.clickBack();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent()
					.verifyAddNewPaymentMethods(data.get("verifyHeading"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().clickClose();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickCreditCard();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.clickClose();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCardsFieldValidations(String strParams, String card) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
			if (card.equalsIgnoreCase("credit")) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickCreditCard();
			} else {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickDebitCard();
			}

			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateNameOnCard(data.get("nameOnCard"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardExpiry(data.get("cardExpiry"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateCity(data.get("city"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
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

			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();

			testCardsFieldValidations(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDebitCardFieldValidations is" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCreditCardFieldValidations(String strParams) {
		try {

			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
			testCardsFieldValidations(strParams, "credit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDebitCardFieldValidations is" + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testAddIpAddress(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.clickBusinessSettings();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickIpAddress();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.verifyIpHeading(data.get("ipHeading"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.verifyAccountId();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.verifyAccountName();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.fillIpAddress(data.get("ipAddress"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.fillDescription(data.get("description"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.clickSubmit();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.verifySuccessHeading(data.get("successHeading"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.clickClose();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
//		}
//
//	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testAddIpAddressInvalidScenario(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.clickBusinessSettings();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickIpAddress();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.verifyIpHeading(data.get("ipHeading"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.verifyAccountId();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.verifyAccountName();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.fillIpAddress(data.get("ipAddress"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.fillDescription(data.get("description"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
//					.clickOutSide();
//			if (!data.get("errMessage").isEmpty()) {
//				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
//			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testDeleteAddIpAddress(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.clickBusinessSettings();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickDelete();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent()
//					.verifyRemoveHeading(data.get("removeHeading"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickYes();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Remove ip address  Failed due to Exception " + e);
//		}
//	}

}