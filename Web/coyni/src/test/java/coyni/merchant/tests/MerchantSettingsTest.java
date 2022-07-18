package coyni.merchant.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.components.MerchantSettingsSideBarMenuComponent;
import coyni.merchant.components.SideMenuBarComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantSettingsTest<V> {
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
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
//					.clickCompanyInformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyHeading(data.get("companyInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyHeading(data.get("dbaInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.clickBeneficiaryOwnerBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyHeading(data.get("beneficiaryOwnersHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickPaymentMethodsBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().paymentMethodsPage()
					.verifyHeading(data.get("paymentMethodsHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickPreferencesBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().preferencesPage()
					.verifyHeading(data.get("preferenccesHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickAgreementsBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyHeading(data.get("agreementsHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickFeesBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().feesPage()
					.verifyHeading(data.get("feesHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickAccountLimitsBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyHeading(data.get("accountLimitsHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickTeamSharedBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().teamSharedPage()
					.verifyHeading(data.get("teamSharedHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsSideBarBtnView failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInfoPage(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyHeading(data.get("companyInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyCompanyInformationLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyContactInformationLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyAddressLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getCompanyName();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getBusinessEntity();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getEINnumber();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getAccountID();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getPhoneNumber();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getEmail();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getAddressLine1();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getAddressLine2();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getState_City_Zipcode();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.getCountry();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifySaveBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoPage failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInfoEditPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyHeading(data.get("companyInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.clickPhoneNumber(data.get("companyInfoPhoneNumber"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifySaveBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.clickSave();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoEditPhoneNumber failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInfoPhoneNumberFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyHeading(data.get("companyInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyPhoneNumber(data.get("companyInfoPhoneNumber"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifySaveBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoPhoneNumberFieldValidations failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInfoInavlidPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyHeading(data.get("companyInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.clickPhoneNumber(data.get("companyInfoPhoneNumber"));
			new CommonFunctions().clickOutSideElement();
			new CommonFunctions().validateFormErrorMessage(data.get("errMsg"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifySaveBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoInavlidPhoneNumber failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInfoInavlidEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyHeading(data.get("companyInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.clickEmail(data.get("companyInfoEmail"));
			new CommonFunctions().clickOutSideElement();
			new CommonFunctions().validateFormErrorMessage(data.get("errMsg"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifySaveBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoInavlidEmail failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInfoEditEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyHeading(data.get("companyInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.clickEmail(data.get("companyInfoEmail"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifySaveBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.clickSave();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoEditEmail failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInfoEmailFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyHeading(data.get("companyInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyEmail(data.get("companyInfoEmail"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifySaveBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.clickSave();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoEmailFieldValidations failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInfoPage(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyHeading(data.get("dbaInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyDBAnameLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyWebsiteLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyBusinessTypeLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyCustomerServiceLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyAddressLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getDBAname();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyCancelMerchnatAccountLnk();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getWebsiteName();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getBusinessType();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getPhoneNumber();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getEmail();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getAddressLine1();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getAddressLine2();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getState_City_Zipcode();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.getCountry();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoPage failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInfoEditPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyHeading(data.get("dbaInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.clickPhoneNumber(data.get("dbaInfoPhoneNumber"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifySaveBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.clickSave();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditPhoneNumberDBAInfo failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInfoPhoneNumberFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyHeading(data.get("dbaInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyPhoneNumber(data.get("dbaInfoPhoneNumber"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifySaveBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInfoPhoneNumberFieldValidations failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInfoInavlidPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyHeading(data.get("dbaInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.clickPhoneNumber(data.get("dbaInfoPhoneNumber"));
			new CommonFunctions().clickOutSideElement();
			new CommonFunctions().validateFormErrorMessage(data.get("errMsg"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifySaveBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInfoInavlidPhoneNumber failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInfoEditEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyHeading(data.get("dbaInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.clickEmail(data.get("dbaInfoEmail"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifySaveBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.clickSave();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInfoEditEmail failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInfoEmailFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyHeading(data.get("dbaInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyEmail(data.get("dbaInfoEmail"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifySaveBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.clickSave();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInfoEmailFieldValidations failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInfoInavlidEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickDBAinformationBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifyHeading(data.get("dbaInformationHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.clickEmail(data.get("dbaInfoEmail"));
			new CommonFunctions().clickOutSideElement();
			new CommonFunctions().validateFormErrorMessage(data.get("errMsg"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.verifySaveBtn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInfoInavlidEmail failed due to " + e);
		}
	}

//	@Test
//	@Parameters({"strParams"})
//	public void testCompanyInforScreenResloutions(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideMenuBarComponent.clickMerchantSettings();
//			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
//				HashMap<String, Object> deviceMetrics = new HashMap<String, Object>();
//				deviceMetrics.put("Width", );
//		} catch (Exception e) {
//			// 
//		}
//	}

//	public void testAddExternalBankAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
//			// customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickLearnMore();
//			// customerProfilePage.paymentMethodsComponent().addExternalBankAccountPopup().clickBack();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//					.clickaddExternalBankAccount();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().clickIamReady();
//			Thread.sleep(5000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().verifyHeading();
//			Thread.sleep(8000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.switchToWindow();
//
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.verifyNewWindowHeading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.enterBankName(data.get("expBankName"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.clickOnBankName();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.enterUserName(data.get("expUserName"));
//			;
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.enterPassword(data.get("expPassword"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().clickNext();
//			;
//			Thread.sleep(5000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().unSelectBank();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.clickUncheckBank();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.switchToWindow();
//			Thread.sleep(2000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.successFailurePopupCardComponent().verifyBankAddSuccesfulHeaading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.successFailurePopupCardComponent().navigationComponent().clickClose();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(" test ExternalMethod failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddBankAccountWithOutPaymentMethod(String strParams) {
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//		testAddExternalBankAccount(strParams);
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testDeleteBankAccount(String strParams) {
//		try {
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyBankName();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickDeleteBank();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup()
//					.verifyRemovePaymentHeading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup().clickOnRemove();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup()
//					.successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
//			// customerProfilePage.paymentMethodsComponent().removePaymentMethodPopup().successFailurePopupCardComponent().clickClose();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
//		}
//
//	}
//
//	public void testAddCard(String strParams, String card) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
//
//			Thread.sleep(2000);
//			if (card.equalsIgnoreCase("credit")) {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.clickCreditCard();
//			} else {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.clickDebitCard();
//			}
//			Thread.sleep(3000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillNameOnCard(data.get("nameOnCard"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCardNumber(data.get("cardNumber"));
//			Thread.sleep(3000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.validateCardBrand(data.get("cardType"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCardExpiry(data.get("cardExpiry"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCVVorCVC(data.get("cvvNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillAddress1(data.get("address1"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillAddress2(data.get("address2"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillCity(data.get("city"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().selectState(data.get("state"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().verifyCountry(data.get("country"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().clickSave();
//			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
//					.fillAmount(data.get("amount"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickOnVerify();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
//					.successFailurePopupCardComponent().navigationComponent().clickClose();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddDebitCard(String strParams) {
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//		testAddCard(strParams, "debit");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//
//	public void testAddCreditCard(String strParams) {
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//		testAddCard(strParams, "credit");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddCardWihInvalidData(String strParams, String card) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
//			Thread.sleep(2000);
//			if (card.equalsIgnoreCase("credit")) {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.clickCreditCard();
//			} else {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.clickDebitCard();
//			}
//			Thread.sleep(3000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillNameOnCard(data.get("nameOnCard"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCardNumber(data.get("cardNumber"));
//			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().validateCardBrand(data.get("cardType"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCardExpiry(data.get("cardExpiry"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCVVorCVC(data.get("cvvNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillAddress1(data.get("address1"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillAddress2(data.get("address2"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillCity(data.get("city"));
//			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
//
//			if (data.get("state").isEmpty()) {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.addCardComponent().mailingAddressComponent().clickstate();
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.addCardComponent().mailingAddressComponent().clickstate();
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.addCardComponent().mailingAddressComponent().clickTab();
//			}
//			if (!data.get("state").isEmpty()) {
//				// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().selectState(data.get("state"));
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
//			}
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().clickTab();
//			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().backandCrossIconComponent().clickCross();
//
//			if (!data.get("errMessage").isEmpty()) {
//				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
//
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
//						data.get("elementName"));
//			}
//
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("test AddDebitCardWith Invalid Data is failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testCreditCardWithInvalidData(String strParams) {
//
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//		testAddCardWihInvalidData(strParams, "credit");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testDebitCardWithInvalidData(String strParams) {
//
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//		testAddCardWihInvalidData(strParams, "debit");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testCardAuthiWithInvalidData(String strParams, String card) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//			if (card.equalsIgnoreCase("credit")) {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.clickCreditCard();
//			} else {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.clickDebitCard();
//			}
//			Thread.sleep(3000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillNameOnCard(data.get("nameOnCard"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCardNumber(data.get("cardNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCardExpiry(data.get("cardExpiry"));
//			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().validateCardBrand(data.get("cardType"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.fillCVVorCVC(data.get("cvvNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillAddress1(data.get("address1"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillAddress2(data.get("address2"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillCity(data.get("city"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().selectState(data.get("state"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
//			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent().verifyCountry(data.get("Country"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().clickSave();
//			Thread.sleep(3000);
//
//			System.out.println(data.get("errMessage"));
//			String[] msg = data.get("errMessage").split(",");
//			for (int i = 0; i < msg.length; i++) {
//				Thread.sleep(2000);
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
//						.fillAmount(data.get("amount"));
//				Thread.sleep(2000);
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickTab();
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickOnVerify();
//				// customerProfilePage.paymentMethodsComponent().preAuthorizationPopup().successFailurePopupCardComponent().verifyAddBankAccountview();
//				new CommonFunctions().validateFormErrorMessage(msg[i]);
//			}
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
//					.fillAmount(data.get("amount"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickTab();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup().clickOnVerify();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
//					.successFailurePopupCardComponent().verifyFailedHeadingView();
//
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("test AddDebitAuthidWith Invalid Data is failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testCreditCardWithInvalidPreAuthyAmount(String strParams) {
//		testCardAuthiWithInvalidData(strParams, "credit");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testDebitCardWithInvalidPreAuthyAmount(String strParams) {
//		testCardAuthiWithInvalidData(strParams, "debit");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testEditCard(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
//
//			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().cardsComponent().editDeleteComponent()
//					.clickEdit(data.get("cardNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent()
//					.fillNameOnCard(data.get("nameOnCard"));
//			Thread.sleep(2000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent()
//					.fillCardExpiry(data.get("cardExpiry"));
//			Thread.sleep(2000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
//					.fillAddress1(data.get("address1"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
//					.fillAddress2(data.get("address2"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
//					.fillCity(data.get("city"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
//					.selectState(data.get("state"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
//			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
//					.clickSave();
//			// customerProfilePage.paymentMethodsComponent().addCardComponent().mailingAddressComponent()
//			// .successFailurePopupCardComponent().clickClose();
//
//		} catch (Exception e) {
//
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testDebitCardEdit(String strParams) {
//
//		// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
//		testEditCard(strParams);
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testCreditCardEdit(String strParams) {
//
//		// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickDebitCard();
//		testEditCard(strParams);
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testDeleteCard(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
//			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().cardsComponent().editDeleteComponent()
//					.clickDelete(data.get("cardNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().cardsComponent().removePaymentMethodPopup()
//					.clickOnRemove();
//			// customerProfilePage.paymentMethodsComponent().cardsComponent().removePaymentMethodPopup()
//			// .successFailurePopupCardComponent().clickClose();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testDebitDeleteCard(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			testDeleteCard(strParams);
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testCreditDeleteCard(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			testDeleteCard(strParams);
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testCardsView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//			// customerProfilePage.paymentMethodsComponent().verifyAddNewPaymentMethods(data.get("verifyHeading"));
//			// customerProfilePage.paymentMethodsComponent();
//			// customerProfilePage.paymentMethodsComponent().addCardComponent().clickClose();
//			// customerProfilePage.paymentMethodsComponent().verifyPaymentMethodsview();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickCreditCard();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.verifyAddNewCreditCard(data.get("verifyAddNewCardHeading"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.clickBack();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent()
//					.verifyAddNewPaymentMethods(data.get("verifyHeading"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().clickClose();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickCreditCard();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.clickClose();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testCardsFieldValidations(String strParams, String card) {
//
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
//			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().clickCreditCard();
//			if (card.equalsIgnoreCase("credit")) {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.clickCreditCard();
//			} else {
//				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//						.clickDebitCard();
//			}
//
//			Thread.sleep(3000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.validateNameOnCard(data.get("nameOnCard"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.validateCardNumber(data.get("cardNumber"));
//			Thread.sleep(3000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.validateCardExpiry(data.get("cardExpiry"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.validateCVVorCVC(data.get("cvvNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().validateAddress1(data.get("address1"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().validateAddress2(data.get("address2"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.mailingAddressComponent().validateCity(data.get("city"));
//			// customerProfilePage.paymentMethodsComponent().addNewPaymentMethodPopup().addCardComponent()
//			// .mailingAddressComponent()
//			// .validateZipCode(data.get("zipCode"));
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("failed due to" + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testDebitCardFieldValidations(String strParams) {
//		try {
//
//			Thread.sleep(2000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//			Thread.sleep(2000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//
//			testCardsFieldValidations(strParams, "debit");
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testDebitCardFieldValidations is" + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testCreditCardFieldValidations(String strParams) {
//		try {
//
//			Thread.sleep(2000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//			Thread.sleep(2000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
//			testCardsFieldValidations(strParams, "credit");
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testDebitCardFieldValidations is" + e);
//		}
//	}
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

	/// }

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