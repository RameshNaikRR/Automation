package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.FilterComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.TokenWalletPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletTest {

	TokenWalletPage tokenwalletPage;
	SideBarMenuComponent sideBarMenuComponent;
	FilterComponent filterComponent;

	@BeforeMethod
	public void init() {

		tokenwalletPage = new TokenWalletPage();
		sideBarMenuComponent = new SideBarMenuComponent();
		filterComponent = new FilterComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.verifyTokenWalletView();
			sideBarMenuComponent.verifyHandCursorAction();
			sideBarMenuComponent.verifyTokenWalletBackGroundColor(data.get("backgroundcolor"), data.get("border"));
			sideBarMenuComponent.clickTokenwallet();
			Thread.sleep(5000);
			sideBarMenuComponent.tokenWalletPage().verifyHeading(data.get("heading"));
			sideBarMenuComponent.tokenWalletPage().verifyTotalWalletBalanceView();
			sideBarMenuComponent.tokenWalletPage().getWalletInfo();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet view is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletFiltersView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.filterComponent().verifyFilterBackgroundColor(data.get("backGround color"),
					data.get("border"));
			sideBarMenuComponent.filterComponent().verifyFilterCursorAction();
			sideBarMenuComponent.filterComponent().clickFilter();
			sideBarMenuComponent.filterComponent().verifyDateView();
			sideBarMenuComponent.filterComponent().verifyFromCYNview();
			sideBarMenuComponent.filterComponent().verifyToCYNview();
			sideBarMenuComponent.filterComponent().verifyTransactionTypeView();
			sideBarMenuComponent.filterComponent().verifyWithdrawChkbxView();
			sideBarMenuComponent.filterComponent().verifyBuyTokenChkbxView();
			sideBarMenuComponent.filterComponent().verifyWithdrawChkbxView();
			sideBarMenuComponent.filterComponent().verifyTransactionSubtypeView();
			sideBarMenuComponent.filterComponent().verifyBankAccountChkbxView();
			sideBarMenuComponent.filterComponent().verifyInstantPayChkbxView();
			sideBarMenuComponent.filterComponent().verifySignetChkbxView();
			sideBarMenuComponent.filterComponent().verifyTransactionAmountView();
			sideBarMenuComponent.filterComponent().verifyReferenceIdView();
			sideBarMenuComponent.filterComponent().verifyTransactionStatusView();
			sideBarMenuComponent.filterComponent().verifyPendingChkbxView();
			sideBarMenuComponent.filterComponent().verifyCompletedChkbxView();
			sideBarMenuComponent.filterComponent().verifyCancelledChkbxView();
			sideBarMenuComponent.filterComponent().verifyInprogressChkbxView();
			sideBarMenuComponent.filterComponent().verifyFailedChkbxView();
			sideBarMenuComponent.filterComponent().verifyApplyFiltersView();
			sideBarMenuComponent.filterComponent().verifyResetFiltersView();
			sideBarMenuComponent.filterComponent().verifyTransactionDateClearView();
			sideBarMenuComponent.filterComponent().verify15CharIdView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Filters flow failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (data.get("validateDate").equalsIgnoreCase("Yes")) {
				sideBarMenuComponent.filterComponent().clickStartDate();
				sideBarMenuComponent.filterComponent().datePickerComponent().setDateWithYear(data.get("startDate"));
				sideBarMenuComponent.filterComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
				sideBarMenuComponent.filterComponent().verifyStartDate(data.get("expStartDate"));
				sideBarMenuComponent.filterComponent().verifyEndDate(data.get("expEndDate"));
			} else if (data.get("validateTransactionType").equalsIgnoreCase("Yes")) {
				String[] checkBox = data.get("TransactionTypecheckBoxList").split(",");
				for (int i = 0; i <= checkBox.length; i++) {
					sideBarMenuComponent.filterComponent().clickCheckBox(checkBox[i]);
				}
			} else if (data.get("validateTransactionSubType").equalsIgnoreCase("Yes")) {
				String[] checkBox = data.get("TransactionSubTypecheckboxList").split(",");
				for (int i = 0; i <= checkBox.length; i++) {
					sideBarMenuComponent.filterComponent().clickCheckBox(checkBox[i]);
				}
			} else if (data.get("validateTransactionStatus").equalsIgnoreCase("Yes")) {
				String[] checkBox = data.get("TransactionStatus").split(",");
				for (int i = 0; i <= checkBox.length; i++) {
					sideBarMenuComponent.filterComponent().clickCheckBox(checkBox[i]);
				}

			}else if(data.get("validateTransactionAmount").equalsIgnoreCase("Yes")) {
				sideBarMenuComponent.filterComponent().fillFromCYN(data.get("fromCYN"));
				sideBarMenuComponent.filterComponent().fillToCYN(data.get("toCYN"));
			}else if(data.get("ValidateReferenceID").equalsIgnoreCase("Yes")) {
				sideBarMenuComponent.filterComponent().fill15CharReferenceId(data.get("referenceId"));
			}
			sideBarMenuComponent.filterComponent().clickApplyFilter();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Filters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletFiltersValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// sideBarMenuComponent.filterComponent().daysMonthsDropDownComponent();
			sideBarMenuComponent.filterComponent().clickWalletTransferChkbx();
			sideBarMenuComponent.filterComponent().clickBuyTokenChkBx();
			sideBarMenuComponent.filterComponent().clickWithdrawChkbx();
			sideBarMenuComponent.filterComponent().clickTransactionTypeClearAll();
			sideBarMenuComponent.filterComponent().clickBankAccountChkbx();
			sideBarMenuComponent.filterComponent().clickInstantPayChkbx();
			sideBarMenuComponent.filterComponent().clickSignetChkbx();
			sideBarMenuComponent.filterComponent().clickTrasactionSubtypeClearAll();
			sideBarMenuComponent.filterComponent().fillFromCYN(data.get("fromCYN"));
			sideBarMenuComponent.filterComponent().fillToCYN(data.get("toCYN"));
			sideBarMenuComponent.filterComponent().clickTransactionAmntClear();
			sideBarMenuComponent.filterComponent().fill15CharReferenceId(data.get("refernceID"));
			sideBarMenuComponent.filterComponent().clickReferenceIdClear();
			sideBarMenuComponent.filterComponent().clickPendingChkbx();
			sideBarMenuComponent.filterComponent().clickCompletedChkbx();
			sideBarMenuComponent.filterComponent().clickCancelledChkbx();
			sideBarMenuComponent.filterComponent().clickInprogressChkbx();
			sideBarMenuComponent.filterComponent().clickFailedChkbx();
			sideBarMenuComponent.filterComponent().clickTransactionStatusClearAll();
			// 2nd validation
			// sideBarMenuComponent.filterComponent().daysMonthsDropDownComponent();
			sideBarMenuComponent.filterComponent().clickWalletTransferChkbx();
			sideBarMenuComponent.filterComponent().clickBuyTokenChkBx();
			sideBarMenuComponent.filterComponent().clickWithdrawChkbx();
			sideBarMenuComponent.filterComponent().clickBankAccountChkbx();
			sideBarMenuComponent.filterComponent().clickInstantPayChkbx();
			sideBarMenuComponent.filterComponent().clickSignetChkbx();
			sideBarMenuComponent.filterComponent().fillFromCYN(data.get("fromCYN"));
			sideBarMenuComponent.filterComponent().fillToCYN(data.get("toCYN"));
			sideBarMenuComponent.filterComponent().fill15CharReferenceId(data.get("refernceID"));
			sideBarMenuComponent.filterComponent().clickPendingChkbx();
			sideBarMenuComponent.filterComponent().clickCompletedChkbx();
			sideBarMenuComponent.filterComponent().clickCancelledChkbx();
			sideBarMenuComponent.filterComponent().clickInprogressChkbx();
			sideBarMenuComponent.filterComponent().clickFailedChkbx();
			sideBarMenuComponent.filterComponent().clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Token Wallet Filters Validations Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({"strParams"})
	public void testTokenWalletExportsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
		sideBarMenuComponent.exportComponent().clickExport();
		sideBarMenuComponent.exportComponent().verifyExportBackgroundColor(data.get("backgroundColor"), data.get("border"));
		sideBarMenuComponent.exportComponent().verifyExportCursorAction();
		sideBarMenuComponent.exportComponent().verifyExportsSelectedOptionsView();
		sideBarMenuComponent.exportComponent().verifyDateRangeView();
		sideBarMenuComponent.exportComponent().verifyTodayView();
		sideBarMenuComponent.exportComponent().verifyYesterdayView();
		sideBarMenuComponent.exportComponent().verifyLast7DatsView();
		sideBarMenuComponent.exportComponent().verifyMonthtoDateView();
		sideBarMenuComponent.exportComponent().verifyLastMonthView();
		sideBarMenuComponent.exportComponent().verifyCustomDateRangeView();
		sideBarMenuComponent.exportComponent().verifyColumnsView();
		sideBarMenuComponent.exportComponent().verifyDefault8View();
		sideBarMenuComponent.exportComponent().verifyDefault8Desc(data.get("description"));
		sideBarMenuComponent.exportComponent().clickimgDropdown();
		sideBarMenuComponent.exportComponent().verifyDateandTimeChkbxView();
		sideBarMenuComponent.exportComponent().verifyReferenceIDChkbxView();
		sideBarMenuComponent.exportComponent().verifyTypeChkbxView();
		sideBarMenuComponent.exportComponent().verifySubTypeChkbxView();
		sideBarMenuComponent.exportComponent().verifyDescriptionChkbxView();
		sideBarMenuComponent.exportComponent().verifyAmountChkbxView();
		sideBarMenuComponent.exportComponent().verifyBalanceChkbxView();
		sideBarMenuComponent.exportComponent().verifyStatusChkbxView();
		
	}
		catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Token Wallet Exports View Failed due to Exception " + e);
		}
	}
	
	
	
//	@Test
//	@Parameters({ "strParams" })
//	public void testTokenWalletBalance(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenwalletPage.verifyTokenWalletBalanceView(data.get("walletBalanceHeading"));
//			tokenwalletPage.getWalletBalance();
//			tokenwalletPage.verifyCurrencyView();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testTransferTokensView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenwalletPage.clickItem(data.get("walletName"));
//			tokenwalletPage.verifyMouseActionTransferTokens();
//			tokenwalletPage.clickTransferTokens();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyTokensView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenwalletPage.clickItem(data.get("walletName"));
//			tokenwalletPage.verifyMouseActionBuyTokens();
//			tokenwalletPage.clickBuyTokens();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUsdView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenwalletPage.clickItem(data.get("walletName"));
//			tokenwalletPage.verifyMouseActionWithdrawToUsd();
//			tokenwalletPage.clickWithdrawToUsd();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
//		}
//	}
}
