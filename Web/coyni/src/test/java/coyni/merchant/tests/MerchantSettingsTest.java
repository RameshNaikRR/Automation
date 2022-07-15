package coyni.merchant.tests;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.pages.MerchantSettingsPage;
import coyni.merchant.components.MerchantSettingsSideBarMenuComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantSettingsTest {
	SideMenuBarComponent sideMenuBarComponent;
	MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent;

	@BeforeTest
	public void init() {
		sideMenuBarComponent = new SideMenuBarComponent();
		merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsSideBar(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyUserName();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyAccountId();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyLblAccountStatus();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyAccountStatus();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.verifyCompanyInformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.verifyDBAInformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.verifyBeneficiaryOwnersBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.verifyPaymentMethodsBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyPreferencesBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyAgreementsBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyFeesBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyAccountLimitsBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyTeamSharedBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().verifyApiKeyBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsSideBarView failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsSideBarBtnView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.clickCompanyInformationBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.clickBeneficiaryOwnerBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickPaymentMethodsBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickPreferencesBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickAgreementsBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickFeesBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickAccountLimitsBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickTeamSharedBtn();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsSideBarBtnView failed due to " + e);
		}
	}

	public void testAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			// customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickLearnMore();
			// customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickBack();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickBankAccount();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().clickIamReady();
			Thread.sleep(5000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().verifyHeading();
			Thread.sleep(8000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().switchToWindow();

			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().verifyNewWindowHeading();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup()
					.enterBankName(data.get("expBankName"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().clickOnBankName();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup()
					.enterUserName(data.get("expUserName"));
			;
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup()
					.enterPassword(data.get("expPassword"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().clickNext();
			;
			Thread.sleep(5000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().unSelectBank();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().clickUncheckBank();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup().switchToWindow();
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup()
					.successFailurePopupCardComponent().verifyBankAddSuccesfulHeaading();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addBankAccountPopup()
					.successFailurePopupCardComponent().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test ExternalMethod failed due to exception " + e);
		}
	}

//
	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccountWithOutPaymentMethod(String strParams) {
		merchantSettingsSideBarMenuComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
		testAddExternalBankAccount(strParams);
	}

//
	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().verifyBankName();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().clickDeleteBank();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().removePaymentMethodPopup()
					.verifyRemovePaymentHeading();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().removePaymentMethodPopup().clickOnRemove();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().removePaymentMethodPopup()
					.successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
			// customerProfilePage.paymentMethodsComponent().removePaymentMethodPopup().successFailurePopupCardComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsSignetAccount(String strParams) {
		try {
			Thread.sleep(1000);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickAddSignetAccount();
			testSignetAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
//			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
//					.addNewPaymentMethodPopup().addNewSignetAccountPopup().verifyPageHeading(data.get("heading"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().fillName(data.get("newSignetAccount"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().fillSignetWalletId(data.get("walletID"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().fillCity(data.get("city"));
			Thread.sleep(500);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().selectState(data.get("state"));
			Thread.sleep(1000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().clickSave();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().successFailureComponent()
					.verifySignetSucessfulHeading(data.get("heading1"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().successFailureComponent()
					.verifySignetSucessfulHeading2(data.get("heading2"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().successFailureComponent().navigationComponent().clickClose();
		} catch (

		Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteSignet(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().clickDeleteSignet(data.get("signetNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().removePaymentMethodPopup().clickOnRemove();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().removePaymentMethodPopup()
					.successFailurePopupCardComponent().verifySignetDeleteHeading(data.get("DeleteHeading"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().removePaymentMethodPopup()
					.successFailurePopupCardComponent().verifySignetDeleteHeading2(data.get("DeleteHeading1"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().removePaymentMethodPopup()
					.successFailurePopupCardComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Delete Signet failed due to Exception " + e);
		}
	}

//
	public void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			Thread.sleep(2000);

			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickDebitCard();
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.validateCardBrand(data.get("cardType"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup()
//					.fillAmount(data.get("amount"));
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup().clickOnVerify();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup()
//					.successFailurePopupCardComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

//
	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		merchantSettingsSideBarMenuComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
		merchantSettingsSideBarMenuComponent.paymentMethodPage().verifyPaymentMethodsview();
		testAddCard(strParams, "debit");
	}

//
	@Test
	@Parameters({ "strParams" })
	public void testAddCardWihInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();

			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickDebitCard();
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().validateCardBrand(data.get("cardType"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));

			if (data.get("state").isEmpty()) {
				merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickstate();
				merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickstate();
				merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().clickTab();
			}
			if (!data.get("state").isEmpty()) {
				// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
				merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			}
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
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
	public void testDebitCardWithInvalidData(String strParams) {

		merchantSettingsSideBarMenuComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
		merchantSettingsSideBarMenuComponent.paymentMethodPage().verifyPaymentMethodsview();
		testAddCardWihInvalidData(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCardAuthiWithInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().verifyPaymentMethodsview();

			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickDebitCard();
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().validateCardBrand(data.get("cardType"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			Thread.sleep(3000);

			System.out.println(data.get("errMessage"));
			String[] msg = data.get("errMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				Thread.sleep(2000);
				merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup()
						.fillAmount(data.get("amount"));
				Thread.sleep(2000);
				merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup().clickTab();
				merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup().clickOnVerify();
				// customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().verifyAddBankAccountview();
				new CommonFunctions().validateFormErrorMessage(msg[i]);
			}
			merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup()
					.fillAmount(data.get("amount"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup().clickTab();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup().clickOnVerify();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().preAuthorizationPopup()
					.successFailurePopupCardComponent().verifyFailedHeadingView();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test AddDebitAuthidWith Invalid Data is failed due to exception " + e);
		}
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

			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

			merchantSettingsSideBarMenuComponent.paymentMethodPage().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addCardComponent().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addCardComponent().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addCardComponent().mailingAddressComponent()
					.fillCity(data.get("city"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addCardComponent().mailingAddressComponent()
					.selectState(data.get("state"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addCardComponent().mailingAddressComponent()
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

		merchantSettingsSideBarMenuComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
		testEditCard(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().cardsComponent().editDeleteComponent()
					.clickDelete(data.get("cardNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().cardsComponent().removePaymentMethodPopup()
					.clickOnRemove();
			// customerProfilePage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup()
			// .successFailurePopupCardComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsAddDebitCardWithOutPaymentMethod(String strParams) {
		try {
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
			Thread.sleep(1000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickDebitCard();
			testAddCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddBankAccountWithoutPaymentMethod is failed due to " + e);
		}

	}

//
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
//

	@Test
	@Parameters({ "strParams" })
	public void testCardsFieldValidations(String strParams, String card) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();

			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickDebitCard();
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.validateNameOnCard(data.get("nameOnCard"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.validateCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.validateCardExpiry(data.get("cardExpiry"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.validateCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress1(data.get("address1"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateAddress2(data.get("address2"));
			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().validateCity(data.get("city"));
			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
			// .mailingAddressComponent()
			// .validateZipCode(data.get("zipCode"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to" + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testCardsView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
//			// customerProfilePage.paymentMethodsComponent().verifyAddNewPaymentMethods(data.get("verifyHeading"));
//			// customerProfilePage.paymentMethodsComponent();
//			// customerProfilePage.paymentMethodsComponent().addCardComponent().clickClose();
//			// customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickCreditCard();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
//					.verifyAddNewCreditCard(data.get("verifyAddNewCardHeading"));
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
//					.clickBack();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage()
//					.verifyAddNewPaymentMethods(data.get("verifyHeading"));
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().addCardComponent().clickClose();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().verifyPaymentMethodsview();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().clickCreditCard();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().addNewPaymentMethodPopup().addCardComponent()
//					.clickClose();
//			merchantSettingsSideBarMenuComponent.paymentMethodPage().verifyPaymentMethodsview();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardFieldValidations(String strParams) {
		try {

			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().clickAddNewPayment();
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodPage().verifyPaymentMethodsview();

			testCardsFieldValidations(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDebitCardFieldValidations is" + e);
		}
	}
//

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsNoTeamMember(String strParams) {

		merchantSettingsSideBarMenuComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
		merchantSettingsSideBarMenuComponent.teamComponent().verifyTeamHeading();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifySearch(data.get("search"));
		merchantSettingsSideBarMenuComponent.teamComponent().iconSearch();
		merchantSettingsSideBarMenuComponent.teamComponent().clickFilter();
		merchantSettingsSideBarMenuComponent.teamComponent().verifyRecords();

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().clickAddTeamMember();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyHeading(data.get("heading"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyFirstName(data.get("firstName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyLastName(data.get("lastName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyEmail(data.get("email"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyPhone(data.get("phone"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().clickAddRole();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().addCustomRolePopup()
					.verifyHeading(data.get("customHeading"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().addCustomRolePopup()
					.verifyRoleName(data.get("roleName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().addCustomRolePopup()
					.clickAdd();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.addCustomRolePopup().navigationComponent().clickClose();

			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().clickEdit();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().verifyTokenWalletAccess();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().verifyTransferToken();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().verifyBuyToken();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().verifyWithdrawToken();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().verifyEcosystemActivity();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().verifyExportedFiles();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().verifyBusinessSettings();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().clickSave();
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().saveChangePopUp()
					.verifyHeading(data.get("expHeading"));

			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().saveChangePopUp().clickYes();
			merchantSettingsSideBarMenuComponent.teamComponent().clickSendInvitation();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Add Team Member failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().clickAddTeamMember();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().filtersPage().verifyActive();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().filtersPage().verifyPending();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().filtersPage().verifyExpired();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().filtersPage()
					.verifyClearAll();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()

			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().filtersPage()
					.verifyApplyFilters();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().filtersPage()
					.getNoRecordsFound();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().filtersPage()
					.verifyResetFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Add Team Member failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamSearch(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().clickAddTeamMember();
			merchantSettingsSideBarMenuComponent.teamComponent().verifySearch(data.get("searchingKey"));
			merchantSettingsSideBarMenuComponent.teamComponent().iconSearch();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Team Search  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().clickAddTeamMember();
			merchantSettingsSideBarMenuComponent.teamComponent().verifyEditIcon();
			merchantSettingsSideBarMenuComponent.teamComponent().clickEdit();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings Team Edit  failed due to Exception " + e);
		}
	}

}