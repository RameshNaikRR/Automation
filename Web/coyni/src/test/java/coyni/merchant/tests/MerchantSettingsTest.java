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

//
////	@Test
////	@Parameters({ "strParams" })
////	public void testAddIpAddress(String strParams) {
////		try {
////			Map<String, String> data = Runner.getKeywordParameters(strParams);
////			sideBarMenuComponent.clickBusinessSettings();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickIpAddress();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.verifyIpHeading(data.get("ipHeading"));
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.verifyAccountId();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.verifyAccountName();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.fillIpAddress(data.get("ipAddress"));
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.fillDescription(data.get("description"));
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.clickSubmit();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.verifySuccessHeading(data.get("successHeading"));
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.clickClose();
////		} catch (Exception e) {
////			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
////		}
////
////	}
//
////	@Test
////	@Parameters({ "strParams" })
////	public void testAddIpAddressInvalidScenario(String strParams) {
////		try {
////			Map<String, String> data = Runner.getKeywordParameters(strParams);
////			sideBarMenuComponent.clickBusinessSettings();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickIpAddress();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.verifyIpHeading(data.get("ipHeading"));
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.verifyAccountId();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.verifyAccountName();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.fillIpAddress(data.get("ipAddress"));
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.fillDescription(data.get("description"));
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
////					.clickOutSide();
////			if (!data.get("errMessage").isEmpty()) {
////				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
////				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
////			}
////		} catch (Exception e) {
////			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
////		}
////
////	}
////
////	@Test
////	@Parameters({ "strParams" })
////	public void testDeleteAddIpAddress(String strParams) {
////		try {
////			Map<String, String> data = Runner.getKeywordParameters(strParams);
////			sideBarMenuComponent.clickBusinessSettings();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickDelete();
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent()
////					.verifyRemoveHeading(data.get("removeHeading"));
////			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickYes();
////		} catch (Exception e) {
////			ExtentTestManager.setFailMessageInReport("test Remove ip address  Failed due to Exception " + e);
////		}
////	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testBusinessSettingsNoTeamMember(String strParams) {
//
//		homePage.sideBarMenuComponent().clickBusinessSettings();
//		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
//		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifyTeamHeading();
////			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifySearch(data.get("search"));
//		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().iconSearch();
//		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickFilter();
//		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifyRecords();
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBusinessSettingsAddTeamMember(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarMenuComponent().clickBusinessSettings();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickAddTeamMember();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyHeading(data.get("heading"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyFirstName(data.get("firstName"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyLastName(data.get("lastName"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyEmail(data.get("email"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyPhone(data.get("phone"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.clickAddRole();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.addCustomRolePopup().verifyHeading(data.get("customHeading"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.addCustomRolePopup().verifyRoleName(data.get("roleName"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.addCustomRolePopup().clickAdd();
////			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
////					.addCustomRolePopup().navigationComponent().clickClose();
//
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent().clickEdit();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyTokenWalletAccess();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyTransferToken();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyBuyToken();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyWithdrawToken();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyEcosystemActivity();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyExportedFiles();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyBusinessSettings();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent().clickSave();
//			Thread.sleep(2000);
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.saveChangePopUp().verifyHeading(data.get("expHeading"));
//
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.saveChangePopUp().clickYes();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
//					.clickSendInvitation();
//
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("test Business Settings Add Team Member failed due to Exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBusinessSettingsTeamFilters(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().verifyActive();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().verifyPending();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().verifyExpired();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().verifyClearAll();
////			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().verifyApplyFilters();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().getNoRecordsFound();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().verifyResetFilters();
//
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("test Business Settings Add Team Member failed due to Exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBusinessSettingsTeamSearch(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
//					.verifySearch(data.get("searchingKey"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().iconSearch();
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("test Business Settings Team Search  failed due to Exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBusinessSettingsTeamEdit(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifyEditIcon();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickEdit();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Business Settings Team Edit  failed due to Exception " + e);
//		}
//	}

}