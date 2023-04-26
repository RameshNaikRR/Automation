package coyni.apibusiness.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.api.business.popups.AddIPAddressPopups;
import coyni.apibusiness.components.BusinessSettingsSideBarMenuComponent;
import coyni.apibusiness.components.NavigationComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.components.TeamComponent;
import coyni.apibusiness.components.WebhookComponent;
import coyni.apibusiness.pages.BusinessProfilePage;
import coyni.apibusiness.pages.DBAInfoEditPage;
import coyni.apibusiness.pages.HomePage;
import coyni.apibusiness.pages.TokenWalletPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessSettingsTest {
	SideBarMenuComponent sideBarMenuComponent;
	TokenWalletPage tokenWalletPage;
	BusinessProfilePage apiBusinessProfilePage;
	BusinessSettingsSideBarMenuComponent businessSettingsSideBarMenuComponent;
	AddIPAddressPopups addIpAddressPopups;
	NavigationComponent navigationComponent;
	HomePage homePage;
	DBAInfoEditPage dbaInfoEditPage;
	WebhookComponent webComponent;
	TeamComponent teamComponent;

	@BeforeTest
	public void init() {
		sideBarMenuComponent = new SideBarMenuComponent();
		businessSettingsSideBarMenuComponent = new BusinessSettingsSideBarMenuComponent();
		addIpAddressPopups = new AddIPAddressPopups();
		tokenWalletPage = new TokenWalletPage();
		apiBusinessProfilePage = new BusinessProfilePage();
		navigationComponent = new NavigationComponent();
		homePage = new HomePage();
		dbaInfoEditPage = new DBAInfoEditPage();
		teamComponent = new TeamComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsSideBarView(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		sideBarMenuComponent.clickBusinessSettings();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyHeading(data.get("heading"));
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyUserImageView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountIdView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().getAccountId(data.get("accountID"));
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountStatusView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountStatus(data.get("accountStatus"));
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyCompanyInformationView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyDBAInformationView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyBeneficiaryOwnersView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickBeneficiaryOwner();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyPaymentMethodsView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickPaymentMethods();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyPreferencesView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickPreferences();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAgreementsView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickAgreements();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyFeesView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickFees();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountLimitsView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickAccountLimits();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyTeamView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickTeam();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyIpAddressesView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyApiKeyView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickApiKey();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyWebHooksView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickCompanyInformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().verifyCompanyInfo();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().viewPhoneNumber();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().viewCompanyEmail();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().verifyAddress();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickSaveEnabled();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Company Information  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformationInvalidInfoEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickCompanyInformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickTab();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage()
					.fillCompanyEmail(data.get("companyEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickOutsideElement();
			Thread.sleep(4000);
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickSaveEnabled();
			Thread.sleep(4000);
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test CompanyInfo  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationInvalidInfo(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage()
					.fillCompanyEmail(data.get("DBAEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().clickTab();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().clickSaveEnabled();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test DBAInfo  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().clickEditDBA();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().clickCross();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().viewPhoneNumber();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().viewDBAEmail();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().verifywebsiteInfo();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().verifybusinessTypeInfo();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().verifyAddressInfo();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().clickSaveEnabled();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test DBA Information Edit  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialOwnersView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickBeneficiaryOwner();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().beneficialOwnersPage().clickBeneficialOwner();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().beneficialOwnersPage()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().beneficialOwnersPage()
					.viewBeneficialOwnerData();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimitsView failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsPaymentsList(String strParams) {
		try {
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.viewEditCard();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.viewDeleteCard();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent().clickEdit();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickClose();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
//					.clickDebitCard(data.get("deleteCard"));
//			Thread.sleep(3000);
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
//					.clickClose();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickAddNewPayment();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickClose();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.viewBankAccount();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.viewDebitCard();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.viewCogentAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" Payments List  failed due to Exception " + e);
		}

	}

	public void testAddExternalBankAccountNavigations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickBankAccount();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().verifyHeading();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().navigationComponent().clickBack();
			sideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickBankAccount();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMXBankCheckBox();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickStart();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().navigationComponent().clickClose();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().sessionCancelledPopup().clickTryAgain();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMXBankCheckBox();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickStart();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickSearchInstitutions();
			Thread.sleep(5000);
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().navigationComponent().clickClose();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().sessionCancelledPopup().clickTryAgain();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMXBankCheckBox();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickStart();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMxBank();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().navigationComponent().clickClose();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().sessionCancelledPopup().clickTryAgain();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMXBankCheckBox();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickStart();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMxBank();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().enterUserName(data.get("expUserName"));
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().enterPassword(data.get("expPassword"));
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickBack();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().navigationComponent().clickClose();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Bank Account Method failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickBankAccount();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().verifyHeading();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMXBankCheckBox();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickStart();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickMXBank();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().enterBankName(data.get("expBankName"));
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnBankName();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().enterUserName(data.get("expUserName"));
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().enterPassword(data.get("expPassword"));
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickNext();
			Thread.sleep(5000);
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnChecking();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickNext();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().successFailureComponent()
					.verifyBankAddSuccesfulHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Bank Account failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddExternalBank(String strParams) throws InterruptedException {
		homePage.sideBarMenuComponent().clickBusinessSettings();
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
				.clickAddNewPayment();
		testAddBankAccount(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickDeleteBankAccount(data.get("bankNumber"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().clickOnRemove();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent()
					.verifyPaymnetRemovedSuccessfulHeading(data.get("removeHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	public static void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessProfilePage apiBusinessProfilePage = new BusinessProfilePage();
			apiBusinessProfilePage.paymentMethodComponent().clickAddNewDebit();
			Thread.sleep(3000);
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
//			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.validateCardBrand(data.get("cardType"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickNext();
			Thread.sleep(4000);
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			apiBusinessProfilePage.paymentMethodComponent().cardAddedSuccessfullyPopup().navigationComponent()
					.clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddDebitCard(String strParams) {
		try {
			sideBarMenuComponent.clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickAddNewPayment();
			testAddCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Business Settings Add Debit card  failed  due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsDeleteDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickDebitCard(data.get("deleteDebit"));
			Thread.sleep(1000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().verifyRemoveHeading(data.get("heading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().clickOnRemove();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent()
					.verifyPaymnetRemovedSuccessfulHeading(data.get("successHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Test Business Settings Delete Debit card  failed  due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddCogentAccount(String strParams) {
		try {
			Thread.sleep(1000);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickAddNewPayment();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().clickCogentAccount();
			testCogentAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
//			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
//					.addNewPaymentMethodPopup().addNewSignetAccountPopup().verifyPageHeading(data.get("heading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().fillName(data.get("newSignetAccount"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().fillCogentWalletId(data.get("walletID"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.fillCity(data.get("city"));
			Thread.sleep(500);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.selectState(data.get("state"));
			Thread.sleep(1000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().clickSave();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().successFailureComponent()
					.verifySignetSucessfulHeading(data.get("heading1"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().successFailureComponent()
					.verifySignetSucessfulHeading2(data.get("heading2"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().successFailureComponent()
					.navigationComponent().clickClose();
		} catch (

		Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsDeleteCogent(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickDeleteSignet(data.get("signetNumber"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().clickOnRemove();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent()
					.verifySignetDeleteHeading(data.get("deleteHeading"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
//					.removePaymentMethodPopup().successFailureComponent()
//					.verifySignetDeleteHeading2(data.get("deleteHeading1"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Delete Signet failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardWithOutPaymentMethod(String strParams) {
		try {
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickAddNewPayment();
			Thread.sleep(1000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().clickDebit();
			testAddCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddBankAccountWithoutPaymentMethod is failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsEditDebitCard(String strParams) {
		try {
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent().clickEdit();
			testEditCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}
	}

	public static void testEditCard(String strParams, String string) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessProfilePage apiBusinessProfilePage = new BusinessProfilePage();

			Thread.sleep(3000);
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
//			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.validateCardBrand(data.get("cardType"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickNext();
			apiBusinessProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.successFailureComponent().verifyPaymentEditSuccess(data.get("successHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsCardWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickAddNewPayment();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().clickDebit();
			Thread.sleep(3000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().fillCardNumber(data.get("cardNumber"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().fillCVVorCVC(data.get("cvvNumber"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.selectState(data.get("state"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.verifyCountry(data.get("country"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickTab();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickNext();
			Thread.sleep(3000);

			System.out.println(data.get("errMessage"));
			String[] msg = data.get("errMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				new CommonFunctions().validateFormErrorMessage(msg[i]);
			}
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().clickNext();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.cardAddedSuccessfullyPopup().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsCardFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickAddNewPayment();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().clickDebit();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().fillCardNumber(data.get("cardNumber"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().fillCVVorCVC(data.get("cvvNumber"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
//					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
//					.selectState(data.get("state"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsDebitCardWithInvalidPreAuthyAmount(String strParams) {
		testAddCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPreferences();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().preferencesPage().dropDownIcon();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().preferencesPage()
					.clickTimeDropdown();
			Thread.sleep(4000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().preferencesPage()
					.selectTimeZone(data.get("timeZone"));
			Thread.sleep(1000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().preferencesPage()
					.verifyCurrency(data.get("currency"));
			Thread.sleep(5000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().preferencesPage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Preferences failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAgreements(String strParams) {
		try {
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickAgreements();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().verifyAgreementsView();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.termsOfService();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.privacyPolicy();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.clickTermsOfServices();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.getAllVersionAgreements();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.clickDownloadPDF();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.clickLinkAgreements();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.clickiconDownloadTermsOfService();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.clickPrivacyPolicy();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.clickDownloadPDF();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.clickLinkAgreements();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().agreementsComponent()
					.clickiconDownloadPrivacyPolicy();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings Agreements failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFeesView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent()
					.verifyHeading(data.get("heading")); // Business Settings
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().clickFees();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.clickYourFees();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyFeesHeading(data.get("feesHeading")); // Fees
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyYourFeesHeading(data.get("yourFeesHeading")); // Your Fees
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyYourFeesLabels();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyYourFeesCharges();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.clickUserFees();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyUserFeesHeading(data.get("userFeesHeading")); // User Fees
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyUserFeesLabels();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyUserFeesCharges();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimitsView failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimitsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent()
					.verifyHeading(data.get("heading")); // Business Settings
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().clickAccountLimits();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.clickYourLimits();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifYAccountLimitsHeading(data.get("accountLimitsHeading")); // Account Limits
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyYourLimitsHeading(data.get("yourLimitsHeading")); // Your Account Limits
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyYourLimitsLabels();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyYourLimitsAccountlimits();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.clickUserLimits();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyUserLimitsHeading(data.get("userLimitsHeading")); // User Account Limits
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyUserLimitsLabels();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyUserLimitsAccountlimits();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimitsView failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void addCustomRole(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
				.addCustomRolePopup().verifyHeading(data.get("customHeading"));
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
				.addCustomRolePopup().verifyRoleName(data.get("roleName"));
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
				.addCustomRolePopup().clickAdd();
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.verifyNoFoundRecords();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyHeading(data.get("addTeamHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyFirstName(data.get("firstName"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyLastName(data.get("lastName"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyEmail(data.get("emaildet"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyPhone(data.get("phone"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.clickAddRole();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.addCustomRolePopup().verifyHeading(data.get("customHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.addCustomRolePopup().verifyRoleName(data.get("roleNewName"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.addCustomRolePopup().clickGoBack();
//			ExtentTestManager.setPassMessageInReport("You have successfully added Role Name role!");
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.getUserPermission(data.get("option"), data.get("eleName"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.addCustomRolePopup().navigationComponent().clickClose();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.clickAdminRole();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent().clickEdit();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyTokenWalletAccess();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyEcosystemActivity();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyExportedFiles();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyBusinessSettings();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent().clickSave();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.saveChangePopUp().verifyHeading(data.get("expHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.saveChangePopUp().clickYes();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.clickSendInvitation();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.toastComponent().verifyToast(data.get("toastTitle"), data.get("message"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Add Team Member failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.verifyTeamHeading(data.get("heading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.teamComponent().clickFilter();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyActive();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyPending();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyExpired();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyApplyFilters();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.teamComponent().clickFilter();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().verifyClearAll();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyResetFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Team Filters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTeamFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.verifyTeamHeading(data.get("heading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.teamComponent().clickFilter();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyActive();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyPending();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyExpired();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyApplyFilters();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.teamComponent().verifyRecords();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Team Search  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamSearch(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.verifySearch(data.get("searchingKey"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().iconSearch();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickSearchIcon();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Team Search  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsRemoveTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().iconDelete();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.verifyRemoveHeading1();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.verifyRemoveHeading2();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifyDescription();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickRemove();
			Thread.sleep(1000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().toastComponent()
					.verifyToast(data.get("toastTitle"), data.get("toastMessage"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Remove Team Member  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamEdit(String strParams) {
		try {
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifyEditIcon();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickEdit();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings Team Edit  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddIpAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent()
//					.verifyNoIp(data.get("noIPExist"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickIpAddress();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountId();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountName();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillIpAddress(data.get("ipAddress"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillDescription(data.get("ipDescription"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickSubmit();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifySuccessHeading(data.get("successHeading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddIpAddressInvalidScenario(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickIpAddress();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountId();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountName();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillIpAddress(data.get("ipAddress"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickOutSide();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyerrMsg(data.get("errMessage"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickTab();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillDescription(data.get("ipDescription"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickOutSide();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyerrMsg1(data.get("errMsg"));

//			if (!data.get("errMessage").isEmpty()) 
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteAddIpAddress(String strParams) {
		try {
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickDelete();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().verifyRemoveHeading();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().verifydesc();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickYes();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Remove ip address  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsGenerateAPIKeys(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickApiKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyAPIKey(data.get("apiKeyHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.clickGenerateApiKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.generateNewSecretKeyPopup().verifyHeading(data.get("popupHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.generateNewSecretKeyPopup().getGenerateKeyDescription();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.generateNewSecretKeyPopup().clickGenerate();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyLblPublicKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyLblSecretKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().clickCopy();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().verifyCopy();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.clickRevealSecretKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().authyComponent()
					.fillInput(data.get("code"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.clickHideSecretKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().clickCopy();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().verifyCopy();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.clickRevealSecretKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().authyComponent()
					.clickSmsCode();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().authyComponent()
					.fillInput(data.get("code"));
			Thread.sleep(5000);
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().toastComponent()
//					.verifyToastTitle(data.get("title"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().verifyApiKeyView();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().verifyAPIEvents();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings API Keys  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsWebhook(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyHeading(data.get("heading"));

			if (sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyEditButton() == 1) {
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyEndPointURL();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
						.verifyEndPointDescription();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyEndPointStatus();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyLastUpdated();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickEditIcon();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
						.enterEndPointURL(data.get("endpointURL"));
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
						.clickEndPointDescription();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
						.enterEndpointDesc(data.get("endpointDesc"));
//				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickEditIcon();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickSave();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().saveChangePopUp()
						.clickYes();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().toastComponent()
						.verifyToast(data.get("title"), data.get("message"));
			} else {

				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickCreate();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
						.enterEndPointURL(data.get("endpointURL"));
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
						.clickEndPointDescription();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
						.enterEndpointDesc(data.get("endpointDesc"));
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickSave();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().saveChangePopUp()
						.clickYes();
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().toastComponent()
						.verifyToast(data.get("title"), data.get("message"));

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}
}
