package coyni.admin.tests;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

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
	

//sanity test
	@Test
	@Parameters({ "strParams" })
	public void testSystemSettings(String strParams) {
		try {
			Map<String, String>data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
		//	homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickAgreements();
			homePage.sideBarComponent().clickFeeStructure();
			homePage.sideBarComponent().feeStructurePage().verifyHeading(data.get("feeHeading"));
			homePage.sideBarComponent().clickAccountLimits();
			//homePage.sideBarComponent().accountLimitsComponent().verifyHeading(data.get("accountLimitHeading"));
		//	homePage.sideBarComponent().clickPermissions();
			homePage.sideBarComponent().clickFeatureControls();
		//	homePage.sideBarComponent().featureControlPage().verifyF(data.get("expActivityHeading"));
			homePage.sideBarComponent().clickCardBlackList();
		//	homePage.sideBarComponent().clickPushNotifications();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSystemSettings Failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testTermOfServiceAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickAgreements();
			homePage.sideBarComponent().agreementsComponent().verifyHeading();
			homePage.sideBarComponent().agreementsComponent().verifyTermsOfServiceLastUpdateDate();
			homePage.sideBarComponent().agreementsComponent().clickTosViewDetails();
			homePage.sideBarComponent().agreementsComponent().verifyTableHeading(data.get("AgreementList"));
			homePage.sideBarComponent().agreementsComponent().clickEdit();
			homePage.sideBarComponent().agreementsComponent().enterVersion();
			homePage.sideBarComponent().agreementsComponent().enterSummery();
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			homePage.sideBarComponent().agreementsComponent().uploadDocument(data.get("folderName"),
					data.get("fileName"));
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			homePage.sideBarComponent().agreementsComponent().clickSave();
			homePage.sideBarComponent().agreementsComponent().verifyTosAgreement(data.get("tosHeading"));
			homePage.sideBarComponent().agreementsComponent().clickNonMeterial();
			homePage.sideBarComponent().agreementsComponent().clickEfftiveDate();
			homePage.sideBarComponent().agreementsComponent().clickStartDate();
			homePage.sideBarComponent().agreementsComponent().clickSchedule();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTermOfServiceAgreements Failed due to Exception  " + e);
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
			//homePage.sideBarComponent().feeStructurePage().accountTableComponent().getRowElements(data.get("firstRow"));
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
			//homePage.sideBarComponent().viewPersonalFeeStructurePage().getDefaultFirstRowHeading();
			homePage.sideBarComponent().feeStructurePage().viewPersonalFeeStructurePage().verifyWithdrawals();
			homePage.sideBarComponent().feeStructurePage().viewPersonalFeeStructurePage().verifyBuyToken();
			homePage.sideBarComponent().feeStructurePage().viewPersonalFeeStructurePage().verifyDispute();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testViewPersonalFeeStructure Failed due to Exception " + e);
		}
	}

	
	//We can use Edit Fee structure Also but we are not including 
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
			Thread.sleep(4000);
			// homePage.sideBarComponent().feeStructurePage().verifyHeading(data.get("expHeading"));
			homePage.sideBarComponent().feeStructurePage().clickMerchant();
			Thread.sleep(4000);
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
			 homePage.viewMerchantfeeStructurePage().verifyViewHeading(data.get("expViewHeading"));
			//homePage.sideBarComponent().viewMerchantfeeStructurePage().getDefaultFirstRowHeading();
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
	//		homePage.sideBarComponent().featureControlPage().verifyActivityDescription();
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
	@Test
	@Parameters({ "strParams" })
	public void testAccountLimts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickAccountLimits();;
			homePage.sideBarComponent().accountLimitsComponent().verifyHeading(data.get("expHeading"));
			// homePage.sideBarComponent().feeStructurePage().clickPersonal();
			Thread.sleep(3000);
			homePage.sideBarComponent().accountLimitsComponent().accountTableComponent()
					.verifyTableLabels(data.get("labelColumn"));
			//homePage.sideBarComponent().feeStructurePage().accountTableComponent().getRowElements(data.get("firstRow"));
			// sideBarComponent.feeStructurePage().accountTableComponent().verifylblHeading(data.get("Status"));
			sideBarComponent.feeStructurePage().statusView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFeeStructure Failed due to Exception " + e);
		}
	}

	
	@Test
	@Parameters({ "strParams" })
	public void testViewPersonalAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickAccountLimits();
			Thread.sleep(2000);
			homePage.sideBarComponent().accountLimitsComponent().clickView();
			homePage.sideBarComponent().accountLimitsComponent().verifyHeading(data.get("expViewHeading"));
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
	public void testTransactionSearch(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().fillSearch(data.get("data"));
			sideBarComponent.transactionPage().clickSearch();
			Thread.sleep(1000);
			int size = sideBarComponent.transactionPage().transactionDetailsComponent().getSize();
			if (size > 0) {
				ExtentTestManager.setWarningMessageInReport("No Search data Found in the System");
			} else {
				sideBarComponent.transactionPage().transactionDetailsComponent().clickDetails();
				String verifySearchData = sideBarComponent.transactionPage().transactionDetailsComponent()
						.verifySearchData();
				if (data.get("data").contains(verifySearchData)) {
					ExtentTestManager.setInfoMessageInReport("Data is matched");
				} else {
					ExtentTestManager.setInfoMessageInReport("Data is not matched");
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionSearch Failed due to Exception " + e);
		}
	}
	@SuppressWarnings("unlikely-arg-type")
    @Test
    @Parameters({ "strParams" })
    public void testFeeStructuresActiveToSheduled(String strParams) {
        try {
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            homePage.sideBarComponent().clickSystemSettings();
            homePage.sideBarComponent().clickFeeStructure();
            homePage.sideBarComponent().feeStructurePage().clickActiveEdit();
            homePage.sideBarComponent().feeStructurePage().enterTextDebit(data.get("debitAmnt"));
            homePage.sideBarComponent().feeStructurePage().clickSheduled();
            homePage.sideBarComponent().feeStructurePage().clickSelectDate(data.get("selectDate"));
            homePage.sideBarComponent().feeStructurePage().clickSheduled2();
            Thread.sleep(1000);
            homePage.sideBarComponent().accountLimitsComponent().toastComponent().verifyToast(data.get("success"), data.get("message"));;
            
            Thread.sleep(3000);
            List<WebElement> ActStartDates=homePage.sideBarComponent().feeStructurePage().getStartDate();
            if(ActStartDates.contains(data.get("selectDate"))) {
        
            ExtentTestManager.setFailMessageInReport("Given date in sheduled fee structure is present in fee structure");
            }
        
        } catch (Exception e) {
            ExtentTestManager.setFailMessageInReport("testFeeStructuresActiveToSheduled Failed due to Exception " + e);
        }
    }
	
    @SuppressWarnings("unlikely-arg-type")
    @Test
    @Parameters({ "strParams" })
    public void testAccountLimitsActiveToSheduled(String strParams) {
        try {
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            homePage.sideBarComponent().clickSystemSettings();
            homePage.sideBarComponent().clickAccountLimits();
            homePage.sideBarComponent().accountLimitsComponent().clickActiveEdit();
            homePage.sideBarComponent().accountLimitsComponent().enterTextDebit(data.get("debitAmnt"));
            homePage.sideBarComponent().accountLimitsComponent().clickSheduled();
            homePage.sideBarComponent().accountLimitsComponent().clickSelectDate(data.get("selectDate"));
            homePage.sideBarComponent().accountLimitsComponent().clickSheduled2();
            homePage.sideBarComponent().accountLimitsComponent().toastComponent().verifyToast(data.get("success"), data.get("message"));;
            
            
            Thread.sleep(3000);
            List<WebElement> ActStartDates=homePage.sideBarComponent().feeStructurePage().getStartDate();
            if(ActStartDates.contains(data.get("selectDate"))) {
        
            ExtentTestManager.setFailMessageInReport("Given date in sheduled fee structure is present in fee structure");
            }
            
    
        } catch (Exception e) {
            ExtentTestManager.setFailMessageInReport("testAccountLimitsActiveToSheduled Failed due to Exception " + e);
        }
    }

	
}
