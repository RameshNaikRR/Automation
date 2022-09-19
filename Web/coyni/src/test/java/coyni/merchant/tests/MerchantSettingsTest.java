package coyni.merchant.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.MerchantSettingsSideBarMenuComponent;
import coyni.merchant.components.SideMenuBarComponent;
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
					.verifyHeading(data.get("preferencesHeading"));
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
			String[] numbers = data.get("companyInfoPhoneNumber").split(",");
			for (String number : numbers) {
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
						.companyInformationPage().clickPhoneNumber(number);
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
						.companyInformationPage().verifySaveBtn();
				Thread.sleep(2000);
			}
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
					.verifySaveBtn();
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
					.verifySaveBtn();
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
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
//					.verifyCancelMerchnatAccountLnk();
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
			String[] numbers = data.get("dbaInfoPhoneNumber").split(",");
			for (String number : numbers) {
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
						.clickPhoneNumber(number);
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
						.verifySaveBtn();
				Thread.sleep(2000);
			}
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

	@Test
	@Parameters({ "strParams" })
	public void testBeneficiaryOwners(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.clickBeneficiaryOwnerBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyHeading(data.get("beneficiaryOwnersHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyBeneficialOwnernameLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyOwnershipLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyBeneficialOwnernameLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyOwnerShipPercentage();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.clickBeneficialOwnerDrpDwn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyBeneficialOwnernameLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifySocialSecurityNumberLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyOwnershipLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyAddressLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.getOwnerName();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.getDateOfBirth();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.getSocialSecurityNumber();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.getOwnerShip();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.getAddressLine1();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.getAddressLine2();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.getState_City_Zipcode();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.getCountry();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFeesView failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickPreferencesBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().preferencesPage()
					.verifyHeading(data.get("preferencesHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().preferencesPage()
					.clickTimeDropdown();
			Thread.sleep(3000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().preferencesPage()
					.clickEastern();
			Thread.sleep(3000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().preferencesPage()
					.clickSave();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPreferences failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAgreementsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickAgreementsBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyHeading(data.get("agreementsHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyMerchantAgreementsTab();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyPrivacyPolicyTab();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyTermsOfServicesTab();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyMerchantAgreementsLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyPrivacyPolicyLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyMerchantAgreementsIpAddressLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyPrivacyPolicyIpAddressLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyTermsOfServiceIpAddressLbl();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyMerchantAgreementsIpAddress();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyPrivacyPolicyIpAddress();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyTermsOfServiceIpAddress();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAgreements failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFeesView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickFeesBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().feesPage()
					.verifyHeading(data.get("feesHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().feesPage()
					.verifyLabelHeadings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().feesPage()
					.verifyFeesChargesLbl();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFeesView failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimitsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickAccountLimitsBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyHeading(data.get("accountLimitsHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyLables();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyAccountLimits();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFeesView failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAPIKeys(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getPublicKey();
			Thread.sleep(2000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickGenerateNewSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ClickGenerate();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickRevealSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.authyComponent().fillInput(data.get("code"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getAPIKeysLogs();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAPIKeysInactiveRecords(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyTableItemsCount(data.get("query"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
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

	public void testAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickBankAccount();
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
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
					.enterPassword(data.get("expPassword"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup().clickNext();
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
		sideMenuBarComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		testAddExternalBankAccount(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickDelete(data.get("bankNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup().clickOnRemove();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup()
					.successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testaddSignet(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.clickAddSignetAccount();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().fillName(data.get("newSignetAccount"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().fillSignetWalletId(data.get("walletID"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().fillAddress1(data.get("addressLine1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().fillAddress2(data.get("addressLine2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().fillCity(data.get("city1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().clickstate();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().selectState(data.get("state1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewSignetAccountPopup().clickSave();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testaddSignet failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddSignetAccount(String strParams) {
		sideMenuBarComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		testaddSignet(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddSignetAccountInvalidDataValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
			testaddSignet(strParams);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteSignetAccount(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickDelete(data.get("signetNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup().clickOnRemove();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup()
					.successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteSignetAccount is failed due to " + e);
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
					.mailingAddressComponent().fillAddress1(data.get("addressLine1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("addressLine2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
					.successFailurePopupCardComponent().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		sideMenuBarComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
		testAddCard(strParams, "debit");
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
						.clickDebitCard();
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
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("addressLine1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("addressLine2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city1"));

			if (data.get("state1").isEmpty()) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().clickstate();
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().clickstate();
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().clickTab();
			}
			if (!data.get("state1").isEmpty()) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			}
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickTab();

			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			} else if (!data.get("toastMessage").isEmpty()) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.addCardComponent().mailingAddressComponent().toastComponent()
						.verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test AddDebitCardWith Invalid Data is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardWithInvalidData(String strParams) {
		sideMenuBarComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		testAddCardWihInvalidData(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().cardsComponent().editDeleteComponent()
					.clickEdit(data.get("number"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().editCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().editCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			Thread.sleep(2000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().editCardComponent().mailingAddressComponent()
					.fillAddress1(data.get("addressLine1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().editCardComponent().mailingAddressComponent()
					.fillAddress2(data.get("addressLine2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().editCardComponent().mailingAddressComponent()
					.fillCity(data.get("city1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().editCardComponent().mailingAddressComponent()
					.selectState(data.get("state1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().editCardComponent().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addCardComponent().mailingAddressComponent()
					.clickSave();

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardEdit(String strParams) {
		sideMenuBarComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
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
					.clickDelete(data.get("number"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().cardsComponent().removePaymentMethodPopup()
					.clickOnRemove();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test delete card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
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
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			if (card.equalsIgnoreCase("credit")) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickDebitCard();
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
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardFieldValidations(String strParams) {
		try {
			Thread.sleep(2000);
			sideMenuBarComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
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
	public void testMerchantSettingsTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().verifyTeamHeading(data.get("teamSharedHeading"));
			merchantSettingsSideBarMenuComponent.teamComponent().clickSettings();
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().verifySearch(data.get("searchingKey"));
			merchantSettingsSideBarMenuComponent.teamComponent().iconSearch();
			merchantSettingsSideBarMenuComponent.teamComponent().verifyRecords();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsNoTeamMember failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsAddTeamMemberWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().clickAddTeamMember();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyFirstName(data.get("firstName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyLastName(data.get("lastName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyEmail(data.get("email1"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyPhone(data.get("phone"));
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			} else if (!data.get("toastMessage").isEmpty()) {

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testMerchantSettingsAddTeamMemberWithInvalidData Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsAddedTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().clickAddTeamMember();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyFirstName(data.get("firstName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyLastName(data.get("lastName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyEmail(data.get("email1"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyPhone(data.get("phone"));
			if (!data.get("toastMessage").isEmpty()) {
				merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().toastComponent()
						.verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsNoTeamMember failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsAddTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().clickAddTeamMember();
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyFirstName(data.get("firstName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyLastName(data.get("lastName"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyEmail(data.get("email1"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent()
					.verifyPhone(data.get("phone"));
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().clickSendInvitation();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsAddTeamMember failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamMemberRemove(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().verifyTeamHeading(data.get("teamSharedHeading"));
			merchantSettingsSideBarMenuComponent.teamComponent().clickSettings();
//			merchantSettingsSideBarMenuComponent.teamComponent().verifyName();
//			merchantSettingsSideBarMenuComponent.teamComponent().verifyActivation();
			merchantSettingsSideBarMenuComponent.teamComponent().clickRemoveUser();
			merchantSettingsSideBarMenuComponent.teamComponent().removeUserPopup().clickGoBack();
			merchantSettingsSideBarMenuComponent.teamComponent().removeUserPopup().clickYes();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsTeamMember failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamMemberRemoveUsers(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().verifyTeamHeading(data.get("teamSharedHeading"));
			merchantSettingsSideBarMenuComponent.teamComponent().clickCheckBox();
			merchantSettingsSideBarMenuComponent.teamComponent().clickActions();
			merchantSettingsSideBarMenuComponent.teamComponent().clickRemoveUser();
			merchantSettingsSideBarMenuComponent.teamComponent().clickApplyAction();
			merchantSettingsSideBarMenuComponent.teamComponent().teamMemberRemoveUserPopup().getDescription();
			merchantSettingsSideBarMenuComponent.teamComponent().teamMemberRemoveUserPopup().clickRemove();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsTeamMember failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamMemberDelete(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
//			merchantSettingsSideBarMenuComponent.teamComponent().verifyTeamHeading(data.get("teamSharedHeading"));
//			merchantSettingsSideBarMenuComponent.teamComponent().clickSettings();
//			merchantSettingsSideBarMenuComponent.teamComponent().verifyName();
//			merchantSettingsSideBarMenuComponent.teamComponent().verifyActivation();
			merchantSettingsSideBarMenuComponent.teamComponent().clickDelete();
			merchantSettingsSideBarMenuComponent.teamComponent().deleteUserPopup().clickRemove();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsTeamMember failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().clickFilter();
			merchantSettingsSideBarMenuComponent.teamComponent().filterComponent().selectFilter(data.get("filterType"));
			merchantSettingsSideBarMenuComponent.teamComponent().filterComponent().clickApplyFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantSettingsTeamFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamActiveFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testMerchantSettingsTeamFilters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyActive();
		//	merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyApplyFilters();
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().getNoRecordsFound();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testMerchantSettingsTeamActiveFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamInvitationPendingFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testMerchantSettingsTeamFilters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyPending();
		//	merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyApplyFilters();
			merchantSettingsSideBarMenuComponent.teamComponent().clickEdit();
			merchantSettingsSideBarMenuComponent.teamComponent().clickEditTeam();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testMerchantSettingsTeamInvitationPendingFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamInvitationExpiredFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testMerchantSettingsTeamFilters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyExpired();
			//merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyApplyFilters();
			merchantSettingsSideBarMenuComponent.teamComponent().clickResendInvitation();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testMerchantSettingsTeamInvitationExpiredFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantSettingsSideBarMenuComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			merchantSettingsSideBarMenuComponent.teamComponent().clickFilter();
			merchantSettingsSideBarMenuComponent.teamComponent().filterComponent().selectFilter(data.get("filterType"));
			merchantSettingsSideBarMenuComponent.teamComponent().filterComponent().clickResetAllFilters();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testMerchantSettingsTeamResetFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamActiveResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testMerchantSettingsTeamResetFilters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyActive();
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyResetFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testMerchantSettingsTeamActiveResetFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamResetPendingFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testMerchantSettingsTeamResetFilters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyPending();
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyResetFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testMerchantSettingsTeamResetPendingFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsTeamResetExpiredFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testMerchantSettingsTeamResetFilters(strParams);
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyExpired();
			merchantSettingsSideBarMenuComponent.teamComponent().filtersPage().verifyResetFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testMerchantSettingsTeamResetExpiredFilters failed due to Exception " + e);
		}
	}

}