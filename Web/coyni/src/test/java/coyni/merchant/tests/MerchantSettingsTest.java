package coyni.merchant.tests;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.MerchantActivityComponent;
import coyni.merchant.components.MerchantSettingsSideBarMenuComponent;
import coyni.merchant.components.SideMenuBarComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantSettingsTest {
	SideMenuBarComponent sideMenuBarComponent;
	MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent;
	MerchantActivityComponent merchantActivityComponent;

	@BeforeTest
	public void init() {
		sideMenuBarComponent = new SideMenuBarComponent();
		merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
		merchantActivityComponent = new MerchantActivityComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsLinks(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent()
					.clickCompanyInformationBtn();
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
			ExtentTestManager.setFailMessageInReport(" testMerchantSettingsLinks failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantSettingsSideBarBtnView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
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
					.clickEditImage();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.accountProfileImagePopup().clickUploadNewImage();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.accountProfileImagePopup().cropYourImagePopup()
					.uploadSelectImage(data.get("folderName"), data.get("fileName"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
					.accountProfileImagePopup().cropYourImagePopup().clickSave();
			Thread.sleep(3000);
			String[] numbers = data.get("dbaInfoPhoneNumber").split(",");
			for (String number : numbers) {
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
						.clickPhoneNumber(number);
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().dbaInformationPage()
						.verifySaveBtn();
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
			sideMenuBarComponent.clickOnMerchantdrpdwn();
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
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
//					.verifyhandSymbolHighlightedBeneficialOwners(data.get("cssProp"), data.get("value"),
//							data.get("color"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().beneficiaryOwnersPage()
					.verifyStarMark();
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
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().preferencesPage()
//					.verifyhandSymbolHighlightedPreferences(data.get("cssProp"), data.get("value"), data.get("color"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().preferencesPage()
					.selectDefaultTimeZone(data.get("defaultTimeZone"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().preferencesPage()
					.clickSave();
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickDashboard();
			merchantActivityComponent.dashBoardPage().getAccountBalance();
			merchantActivityComponent.dashBoardPage().getBatchPayOuts();
			merchantActivityComponent.dashBoardPage().getNextPayOut();
			merchantActivityComponent.dashBoardPage().getLastPayOut();
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
					.verifyAgreementsBorderColor(data.get("expColor"), data.get("colorName"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyPrivacyPolicyTab();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyTermsOfServicesTab();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyMouseHoverAction();

			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.clickPrivacyPolicy();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.clickAgreements();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.verifyDownloadIcon();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.clickTermsOfService();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
					.clickAgreements();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
//					.verifyPrivacyPolicyIpAddress();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
//					.verifyTermsOfServiceIpAddress();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
//					.verifyPrivacyPolicyIpAddressLbl();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().agreementsPage()
//					.verifyTermsOfServiceIpAddressLbl();

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
			Thread.sleep(3000);
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.clickRevealSecretKey();
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

//	@Test
//	@Parameters({ "strParams" })
//	public void testAPIKeysRevealSecretInvalidAuthy(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideMenuBarComponent.clickMerchantSettings();
//			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.getPublicKey();
//			Thread.sleep(2000);
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.clickGenerateNewSecretKey();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ClickGenerate();
////			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
////					.clickRevealSecretKey();
//			if (!data.get("code").isEmpty()) {
//				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//						.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
//			}
//			if (!data.get("errMessage").isEmpty()) {
//				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//						.authyComponent().verifyMessage(data.get("errMessage"));
//			}
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
//		}
//
//	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testAPIKeysInactiveRecords(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideMenuBarComponent.clickMerchantSettings();
//			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.verifyHeading(data.get("apiKeysHeading"));
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.verifyTableItemsCount(data.get("query"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
//		}
//
//	}
//	

	@Test
	@Parameters({ "strParams" })
	public void testAPIKeysEcommerce(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			Thread.sleep(4000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickApiKeys();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.clickActiveKeys();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.clickGenerateNewSecretKey();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.generateNewSecretKeyPopup().clickGenerate();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getPublicKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickRevealSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.authyComponent().fillInput(data.get("code"));
			Thread.sleep(2000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnAPIKeyss();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getAPIKeyLog();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.getListOfAPIKeyLogs();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAPIKeysEcommerceInActiveAndExpiredKeysData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
			Thread.sleep(3000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickApiKeys();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickInActiveKeys();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getListOfInActiveAPIKeys();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickExpiredKeys();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAPIKeysPOS(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			// sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.clickApiKeys();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnPOSIntegrationAPIKeys();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnConfigure();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnViewAPIKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.apiKeysPopup().clickRevealSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.apiKeysPopup().authyComponent().fillInput(data.get("code1"));
			Thread.sleep(4000);
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.apiKeysPopup().getSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.apiKeysPopup().clickOnHideSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.apiKeysPopup().clickGenerateNewSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.apiKeysPopup().ClickGenerate();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAPIKeysInactiveAndExpiredKeysPOS(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnPOSIntegrationAPIKeys();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnViewAPIKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.apiKeysPopup().clickInActiveKeys();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.apiKeysPopup().clickExpiredKeys();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAPIKeysRevealSecretInvalidAuthy(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			Thread.sleep(3000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickApiKeys();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.getPublicKey();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.clickGenerateNewSecretKey();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ClickGenerate();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickRevealSecretKey();
			if (!data.get("code").isEmpty()) {
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
						.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
			}
			if (!data.get("errMessage").isEmpty()) {
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
						.authyComponent().verifyMessage(data.get("errMessage"));
			}

		} catch (

		Exception e) {
			ExtentTestManager.setFailMessageInReport("testAPIKeys failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAPIKeysInactiveRecords(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
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

	@Test
	@Parameters({ "strParams" })
	public void testAddIpAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnIpAddress();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ipAddressPage().verifyNoIp(data.get("noIPExist"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().clickIpAddress();
			// sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
			// .ipAddressPage().addIPAddressPopup().verifyAccountName();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillIpAddress(data.get("ipAddress"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillDescription(data.get("ipDescription"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickOnAdditionalIpAddress();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillIpAddress1(data.get("ipAddress1"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillDescription1(data.get("ipDescription1"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickOnAdditionalIpAddress();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillIpAddress2(data.get("ipAddress2"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillDescription2(data.get("ipDescription2"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickSubmit();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ipAddressPage().addIPAddressPopup().verifySuccessHeading(data.get("successHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickClose();
			Thread.sleep(2000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnAPIKeyss();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnIpAddressLog();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getIPAddressLog();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAdditionalIpAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnIpAddress();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ipAddressPage().verifyNoIp(data.get("noIPExist"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().clickAddNewIpAddress();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ipAddressPage().addIPAddressPopup().verifyAccountName();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickOnAdditionalIpAddress();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillIpAddress(data.get("ipAddress"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillDescription(data.get("ipDescription"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickSubmit();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickClose();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnAPIKeyss();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickIPAddress();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getListOfIpAddressLogs();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAdditionalIpAddress  Failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddIpAddressInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnIpAddress();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ipAddressPage().verifyNoIp(data.get("noIPExist"));
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ipAddressPage().clickIpAddress();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().clickAddNewIpAddress();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.ipAddressPage().addIPAddressPopup().verifyAccountName();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillIpAddress(data.get("ipAddress"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().fillDescription(data.get("ipDescription"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickOutSide();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().addIPAddressPopup().clickSubmit();
			Thread.sleep(2000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessageForIPAddress(data.get("errMessage"));
			} else if (!data.get("toastMessage").isEmpty()) {
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
						.ipAddressPage().toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddIpAddressInvalidData  Failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteIpAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnIpAddress();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().clickDelete();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().verifyRemoveHeading(data.get("removeHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().verifydesc();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.ipAddressPage().clickYes();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteIpAddress  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWebhookView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnWebHooks();
			// sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
			// .webhookComponent().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().verifyEndPointURL();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().verifyEndPointDescription();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().verifyEndPointStatus();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().verifyLastUpdated();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditWebhook(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnWebHooks();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.webhookComponent().verifyHeading(data.get("heading"));
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.webhookComponent().clickOnEndPointURL();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().enterEndPointURL(data.get("endpointURL"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().clickEndPointDescription();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().enterEndpointDesc(data.get("endpointDesc"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().clickSave();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().saveChangePopUp().clickYes();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().toastComponent().verifyToast(data.get("title"), data.get("message"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnAPIKeyss();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickWebhooks();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getWebHookLog();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditWebhook  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCreateWebhook(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.clickOnWebHooks();
//			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
//					.webhookComponent().verifyHeading(data.get("heading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().clickOnEndPointURL();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().enterEndPointURL(data.get("endpointURL"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().enterEndpointDesc(data.get("description"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.webhookComponent().clickCreate();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCreateWebhook  Failed due to Exception " + e);
		}
	}

	public void testAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickBankAccount();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().verifyHeading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillNameOnBankAccount(data.get("bankAccountName"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillRoutingNumber(data.get("routingNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillConfirmRoutingNumber(data.get("confirmRoutingNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillAccountNumber(data.get("accountNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillConfirmAccountNumber(data.get("confirmAccountNumber"));
			// merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickAdd();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyHeading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyNameOnAccount();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyInstitution();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyRoutingNumber();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyAccount();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.clickDone();

			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMXBankCheckBox();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickStart();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.verifyNewWindowHeading();
			// merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().addExternalBankAccountPopup().close();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.clickSearchInstitutions();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMxBank();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.addExternalBankAccountPopup().enterBankName(data.get("bankName"));

//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnBankName();
//			Thread.sleep(3000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.enterUserName(data.get("expUserName"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.enterPassword(data.get("expPassword"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickNext();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
					.clickOnBankAccountName(data.get("accountType"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickNext();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.successFailurePopupCardComponent().verifyBankAddSuccesfulHeaading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.successFailurePopupCardComponent().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test ExternalMethod failed due to exception " + e);
		}
	}

	public void testAddExternalBankAccountOATH(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup().clickBankAccount();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().verifyHeading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillNameOnBankAccount(data.get("bankAccountName"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillRoutingNumber(data.get("routingNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillConfirmRoutingNumber(data.get("confirmRoutingNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillAccountNumber(data.get("accountNumber"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.fillConfirmAccountNumber(data.get("confirmAccountNumber"));
			// merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickAdd();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyHeading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyNameOnAccount();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyInstitution();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyRoutingNumber();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.verifyAccount();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().bankAccountAddedPopup()
//					.clickDone();

			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMXBankCheckBox();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickStart();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.verifyNewWindowHeading();
			// merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().addExternalBankAccountPopup().close();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.clickSearchInstitutions();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMxBankOATH();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.addExternalBankAccountPopup().enterBankName(data.get("bankName"));

//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnBankName();
//			Thread.sleep(3000);
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.enterUserName(data.get("expUserName"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.enterPassword(data.get("expPassword"));
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickNext();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
					.clickOnBankAccountName(data.get("accountType"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickNext();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addBankAccountPopup()
//					.successFailurePopupCardComponent().verifyBankAddSuccesfulHeaading();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addExternalBankAccountPopup()
//					.successFailurePopupCardComponent().navigationComponent().clickClose();

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
		// testDeleteBankAccount(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent()
					.clickDeleteBankAccount(data.get("bankNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup().clickOnRemove();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup()
					.successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testPaymentMethodFeatureControls(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			Thread.sleep(3000);
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().featureControlPage()
					.verifyHeading(data.get("FeatureControlheading"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().featureControlPage().getHeading();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().featureControlPage().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Buy Token Transaction with bank account failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddSigent(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.clickAddCognetAccount();
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
		testAddSigent(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddSignetAccountInvalidDataValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
			testAddSigent(strParams);
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
			merchantSettingsSideBarMenuComponent.paymentMethodComponent()
					.clickDeleteSignetAccount(data.get("signetNumber"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup().clickOnRemove();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().removePaymentMethodPopup()
					.successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteSignetAccount is failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testaddCogent(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.clickAddCognetAccount();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewCogentAccountPopup().fillName(data.get("newCogentAccount"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewCogentAccountPopup().fillCognetWalletId(data.get("walletID"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewCogentAccountPopup().mailingAddressComponent().fillAddress1(data.get("addressLine1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewCogentAccountPopup().mailingAddressComponent().fillAddress2(data.get("addressLine2"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewCogentAccountPopup().mailingAddressComponent().fillCity(data.get("city1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewCogentAccountPopup().mailingAddressComponent().selectState(data.get("state1"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewCogentAccountPopup().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewCogentAccountPopup().clickSave();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testaddSignet failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCognetAccount(String strParams) {
		sideMenuBarComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		testaddCogent(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCogentAccountInvalidDataValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
			testaddCogent(strParams);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantSettings();
			merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent()
					.clickDeleteCogentAccount(data.get("cogentNumber"));
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

	public void testAddCardFifth(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
					.verifyAddNewPaymentMethodHeading(data.get("heading"));
			Thread.sleep(2000);
			if (card.equalsIgnoreCase("credit")) {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.clickCreditCard();
			} else {
				merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
						.getDebitCardCount();
			}
			Thread.sleep(3000);

//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().addNewPaymentMethodPopup()
//					.getDebitCardCount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardFifth(String strParams) {
		sideMenuBarComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
//		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
		testAddCardFifth(strParams, "debit");

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		sideMenuBarComponent.clickMerchantSettings();
		merchantSettingsSideBarMenuComponent.clickPaymentMethodsBtn();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().clickAddNewPayment();
		merchantSettingsSideBarMenuComponent.paymentMethodComponent().verifyPaymentMethodsview();
		testAddCard(strParams, "debit");
		testEditCard(strParams);
		testDeleteCard(strParams);
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
	public void testEditDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent = new MerchantSettingsSideBarMenuComponent();
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
			Thread.sleep(2000);
			int verifyTeamMemberRecords = merchantSettingsSideBarMenuComponent.teamComponent()
					.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				merchantSettingsSideBarMenuComponent.teamComponent().verifyNoRecordsFound();
			} else {
				merchantSettingsSideBarMenuComponent.clickTeamSharedBtn();
			}

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
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().switchTab();
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
			merchantSettingsSideBarMenuComponent.teamComponent().addTeamMemberComponent().clickSendInvitation();
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
			Thread.sleep(2000);
			int verifyTeamMemberRecords = merchantSettingsSideBarMenuComponent.teamComponent()
					.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				merchantSettingsSideBarMenuComponent.teamComponent().verifyNoRecordsFound();
			} else {
				merchantSettingsSideBarMenuComponent.teamComponent().clickSettings();
				merchantSettingsSideBarMenuComponent.teamComponent().clickRemove();
				merchantSettingsSideBarMenuComponent.teamComponent().removeUserPopup().clickGoBack();
				merchantSettingsSideBarMenuComponent.teamComponent().removeUserPopup().clickYes();
			}

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
			Thread.sleep(2000);
			int verifyTeamMemberRecords = merchantSettingsSideBarMenuComponent.teamComponent()
					.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				merchantSettingsSideBarMenuComponent.teamComponent().verifyNoRecordsFound();
			} else {
				merchantSettingsSideBarMenuComponent.teamComponent().clickCheckBox();
				merchantSettingsSideBarMenuComponent.teamComponent().clickActions();
				merchantSettingsSideBarMenuComponent.teamComponent().clickRemoveUser();
				merchantSettingsSideBarMenuComponent.teamComponent().clickApplyAction();
				merchantSettingsSideBarMenuComponent.teamComponent().teamMemberRemoveUserPopup().getDescription();
				merchantSettingsSideBarMenuComponent.teamComponent().teamMemberRemoveUserPopup().clickRemove();
			}

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
			Thread.sleep(2000);
			int verifyTeamMemberRecords = merchantSettingsSideBarMenuComponent.teamComponent()
					.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				merchantSettingsSideBarMenuComponent.teamComponent().verifyNoRecordsFound();
			} else {
				merchantSettingsSideBarMenuComponent.teamComponent().clickDelete();
				merchantSettingsSideBarMenuComponent.teamComponent().deleteUserPopup().clickRemove();
			}

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
			Thread.sleep(2000);
			int verifyTeamMemberRecords = merchantSettingsSideBarMenuComponent.teamComponent()
					.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				merchantSettingsSideBarMenuComponent.teamComponent().verifyNoRecordsFound();
			} else {
				merchantSettingsSideBarMenuComponent.teamComponent().clickFilter();
				merchantSettingsSideBarMenuComponent.teamComponent().filterComponent()
						.selectFilter(data.get("filterType"));
				merchantSettingsSideBarMenuComponent.teamComponent().filterComponent().clickApplyFilters();
			}
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
			int verifyTeamMemberRecords = merchantSettingsSideBarMenuComponent.teamComponent()
					.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				merchantSettingsSideBarMenuComponent.teamComponent().verifyNoRecordsFound();
			} else {
				merchantSettingsSideBarMenuComponent.teamComponent().clickEdit();
				merchantSettingsSideBarMenuComponent.teamComponent().clickEditTeam();
			}

		} catch (

		Exception e) {
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
			int verifyTeamMemberRecords = merchantSettingsSideBarMenuComponent.teamComponent()
					.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				merchantSettingsSideBarMenuComponent.teamComponent().verifyNoRecordsFound();
			} else {
				merchantSettingsSideBarMenuComponent.teamComponent().clickResendInvitation();
			}

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
			Thread.sleep(2000);
			int verifyTeamMemberRecords = merchantSettingsSideBarMenuComponent.teamComponent()
					.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				merchantSettingsSideBarMenuComponent.teamComponent().verifyNoRecordsFound();
			} else {
				merchantSettingsSideBarMenuComponent.teamComponent().clickFilter();
				merchantSettingsSideBarMenuComponent.teamComponent().filterComponent()
						.selectFilter(data.get("filterType"));
				merchantSettingsSideBarMenuComponent.teamComponent().filterComponent().clickResetFilters();
			}
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