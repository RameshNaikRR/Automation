package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.SideBarComponent;
import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class SystemSettingsTest {

	HomePage homePage;
	SideBarComponent sideBarComponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		sideBarComponent = new SideBarComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSystemSettings(String strParams) {
		try {
			Map<String, String>data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickAgreements();
			homePage.sideBarComponent().clickFeeStructure();
			homePage.sideBarComponent().clickAccountLimits();
			homePage.sideBarComponent().clickPermissions();
			homePage.sideBarComponent().clickFeatureControls();
			homePage.sideBarComponent().clickCardBlackList();
			homePage.sideBarComponent().clickPushNotifications();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSystemSettings Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFeeStructure(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickFeeStructure();
			homePage.sideBarComponent().feeStructurePage().verifyHeading(data.get("expHeading"));
			// homePage.sideBarComponent().feeStructurePage().clickPersonal();
			Thread.sleep(3000);
			homePage.sideBarComponent().feeStructurePage().accountTableComponent()
					.verifyTableLabels(data.get("labelColumn"));
			homePage.sideBarComponent().feeStructurePage().accountTableComponent().getRowElements(data.get("firstRow"));
			// sideBarComponent.feeStructurePage().accountTableComponent().verifylblHeading(data.get("Status"));
			sideBarComponent.feeStructurePage().statusView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFeeStructure Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testViewPersonalFeeStructure(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickFeeStructure();
			Thread.sleep(2000);
			homePage.sideBarComponent().feeStructurePage().clickView();
			homePage.viewPersonalFeeStructurePage().verifyHeading(data.get("expViewHeading"));
			homePage.sideBarComponent().viewPersonalFeeStructurePage().getDefaultFirstRowHeading();
			homePage.sideBarComponent().feeStructurePage().viewPersonalFeeStructurePage().verifyWithdrawals();
			homePage.sideBarComponent().feeStructurePage().viewPersonalFeeStructurePage().verifyBuyToken();
			homePage.sideBarComponent().feeStructurePage().viewPersonalFeeStructurePage().verifyDispute();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testViewPersonalFeeStructure Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPersonalFeeStructure(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickFeeStructure();
			sideBarComponent.feeStructurePage().clickEdit();
			sideBarComponent.feeStructurePage().editPersonalFeeStructurePage()
					.verifyHeading(data.get("expEditHeading"));
			sideBarComponent.feeStructurePage().editPersonalFeeStructurePage().getFirstRowHeading();
			sideBarComponent.feeStructurePage().editPersonalFeeStructurePage().verifyWithdrawals();
			sideBarComponent.feeStructurePage().editPersonalFeeStructurePage().verifyBuyToken();
			sideBarComponent.feeStructurePage().editPersonalFeeStructurePage().verifyDispute();
			sideBarComponent.feeStructurePage().editPersonalFeeStructurePage().clickEdit();
			// sideBarComponent.feeStructurePage().editPersonalFeeStructurePage().

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditPersonalFeeStructure Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditMerchantFeeStructure(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickFeeStructure();
			Thread.sleep(2000);
			// homePage.sideBarComponent().feeStructurePage().verifyHeading(data.get("expHeading"));
			homePage.sideBarComponent().feeStructurePage().clickMerchant();
			Thread.sleep(2000);
			sideBarComponent.feeStructurePage().clickEdit();
			sideBarComponent.feeStructurePage().viewMerchantfeeStructurePage()
					.verifyHeading(data.get("expEditHeading"));
			sideBarComponent.feeStructurePage().editMerchantFeeStructurePage().getFirstRowHeading();
			sideBarComponent.feeStructurePage().editMerchantFeeStructurePage().verifyTranscation();
			sideBarComponent.feeStructurePage().editMerchantFeeStructurePage().verifyTokenAccount();
			sideBarComponent.feeStructurePage().editMerchantFeeStructurePage().verifyOtherfees();
			// sideBarComponent.feeStructurePage().editMerchantFeeStructurePage().clickEdit();
			// sideBarComponent.feeStructurePage().editPersonalFeeStructurePage().

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditMerchantFeeStructure Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testViewMerchantfeeStructurePage(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickFeeStructure();
			Thread.sleep(2000);
			// homePage.sideBarComponent().feeStructurePage().verifyHeading(data.get("expHeading"));
			homePage.sideBarComponent().feeStructurePage().clickMerchant();
			Thread.sleep(2000);
			homePage.sideBarComponent().feeStructurePage().clickView();
			// homePage.viewMerchantfeeStructurePage().verifyHeading(data.get("expViewHeading"));
			homePage.sideBarComponent().viewMerchantfeeStructurePage().getDefaultFirstRowHeading();
			homePage.sideBarComponent().feeStructurePage().viewMerchantfeeStructurePage().verifyTransction();
			homePage.sideBarComponent().feeStructurePage().viewMerchantfeeStructurePage().verifyTokenAccount();
			homePage.sideBarComponent().feeStructurePage().viewMerchantfeeStructurePage().verifyOtherfees();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testViewMerchantfeeStructurePage Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFeatureControl(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			Thread.sleep(2000);
			homePage.sideBarComponent().clickFeatureControls();
			Thread.sleep(2000);
			homePage.sideBarComponent().featureControlPage().verifyActivityHeading(data.get("expActivityHeading"));
			homePage.sideBarComponent().featureControlPage().verifyActivityDescription();
			Thread.sleep(2000);
			// homePage.sideBarComponent().featureControlPage().verifyAllTransactionsControls();
			// homePage.sideBarComponent().featureControlPage().verifyCreditCard();
			homePage.sideBarComponent().featureControlPage().verifyPay();
			homePage.sideBarComponent().featureControlPage().verifyPayRequest();
			homePage.sideBarComponent().featureControlPage().verifyBuyTokensExternalBankAccount();
			homePage.sideBarComponent().featureControlPage().verifyInstantPay();
			homePage.sideBarComponent().featureControlPage().verifyGiftCard();
			homePage.sideBarComponent().featureControlPage().verifySignetAccount();

			homePage.sideBarComponent().featureControlPage().verifyDebitCard();
			homePage.sideBarComponent().featureControlPage().verifyPaymentMethodsExternalBankAccount();
			homePage.sideBarComponent().featureControlPage().verifyPayRequest();
			homePage.sideBarComponent().featureControlPage().verifyWithdrawals();
			homePage.sideBarComponent().featureControlPage().verifyBuyTokens();
			homePage.sideBarComponent().featureControlPage().verifyPaymentMethods();

			homePage.sideBarComponent().featureControlPage().verifyPaymentMethodsCreditCard();
			homePage.sideBarComponent().featureControlPage().verifyPaymentMethodsDebitCard();
			Thread.sleep(2000);
			homePage.sideBarComponent().featureControlPage().clickSave();
			Thread.sleep(2000);
			homePage.sideBarComponent().featureControlPage().saveChangePopUp().verifyHeading(data.get("expHeading"));
			homePage.sideBarComponent().featureControlPage().saveChangePopUp()
					.verifyDescription(data.get("expDescription"));
			homePage.sideBarComponent().featureControlPage().saveChangePopUp().clickYes();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFeatureControl Failed due to Exception " + e);
		}

	}
}
