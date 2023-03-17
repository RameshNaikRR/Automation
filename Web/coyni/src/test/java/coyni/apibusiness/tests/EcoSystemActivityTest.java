package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.TransactionDetailsComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.ExportFilesPage;
import coyni.apibusiness.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class EcoSystemActivityTest {

	SideBarMenuComponent sideBarMenuComponent;
	HomePage homePage;
	ExportFilesPage exportfilesPage;

	@BeforeMethod
	public void init() {

		sideBarMenuComponent = new SideBarMenuComponent();
		homePage = new HomePage();
		exportfilesPage = new ExportFilesPage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosysyemActivityDashBoardView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickEcosystemActivity();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyEcosystemHeading(data.get("heading"));
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyActivityDashBoard();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyTransactionType();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyTransCount();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyVolume();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyWalletTransfer();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyDeposits();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyWithdraws();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().DropDown();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().walletTransfer();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().deposits();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().Withdraw();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().listDropDown();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testEcosystemActivityDashboard failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcoSystemActivityTransactionListWithdrawInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickEcosystemActivity();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickTransHistory();
			sideBarMenuComponent.filterComponent().clickFilter();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().listDateAndTime();
			sideBarMenuComponent.filterComponent().clickWithdrawChkbx();
			sideBarMenuComponent.filterComponent().clickInstantPayChkbx();
			sideBarMenuComponent.filterComponent().scrollDownFilter();
			sideBarMenuComponent.filterComponent().clickApplyFilter();
			Thread.sleep(3000);
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransactionRow();
			sideBarMenuComponent.transactionDetailsComponent().verifyLblTransactionDetailsHeading();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawTransactionType();
			sideBarMenuComponent.transactionDetailsComponent().getInstantPayTransactionSubType();
			sideBarMenuComponent.transactionDetailsComponent().getReferenceId();
			sideBarMenuComponent.transactionDetailsComponent().getReferenceIdCopy();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawId();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawIdCopy();
			sideBarMenuComponent.transactionDetailsComponent().getCreatedDate();
			sideBarMenuComponent.transactionDetailsComponent().getAmountReceived();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawAmount();
			sideBarMenuComponent.transactionDetailsComponent().getProcessingFee();
			sideBarMenuComponent.transactionDetailsComponent().getTotalAmount();
			sideBarMenuComponent.transactionDetailsComponent().getTransactionDescription();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawAccountBalance();
			sideBarMenuComponent.transactionDetailsComponent().getCardInfo();
//			sideBarMenuComponent.ecoSystemActivityComponent().clickNext();
//			sideBarMenuComponent.ecoSystemActivityComponent().clickPrevious();
//			sideBarMenuComponent.ecoSystemActivityComponent().viewEntries();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testTransactionList failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEcoSystemActivityTransactionListWithdrawBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickEcosystemActivity();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickTransHistory();
			sideBarMenuComponent.filterComponent().clickFilter();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().listDateAndTime();
			sideBarMenuComponent.filterComponent().clickWithdrawChkbx();
			sideBarMenuComponent.filterComponent().clickBankAccountChkbx();
			sideBarMenuComponent.filterComponent().scrollDownFilter();
			sideBarMenuComponent.filterComponent().clickApplyFilter();
			Thread.sleep(3000);
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransactionRow();
			sideBarMenuComponent.transactionDetailsComponent().verifyLblTransactionDetailsHeading();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawTransactionType();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawBankAccountTransactionSubType();
			sideBarMenuComponent.transactionDetailsComponent().getReferenceId();
			sideBarMenuComponent.transactionDetailsComponent().getReferenceIdCopy();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawId();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawIdCopy();
			sideBarMenuComponent.transactionDetailsComponent().getCreatedDate();
			sideBarMenuComponent.transactionDetailsComponent().getAmountReceived();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawAmount();
			sideBarMenuComponent.transactionDetailsComponent().getProcessingFee();
			sideBarMenuComponent.transactionDetailsComponent().getTotalAmount();
			sideBarMenuComponent.transactionDetailsComponent().getTransactionDescription();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawAccountBalance();
			sideBarMenuComponent.transactionDetailsComponent().getNameOnAccount();
			sideBarMenuComponent.transactionDetailsComponent().getBankAccountNumber();
			sideBarMenuComponent.transactionDetailsComponent().getBankName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testTransactionList failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEcoSystemActivityTransactionListWithdrawCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickEcosystemActivity();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickTransHistory();
			sideBarMenuComponent.filterComponent().clickFilter();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().listDateAndTime();
			sideBarMenuComponent.filterComponent().clickWithdrawChkbx();
			sideBarMenuComponent.filterComponent().clickBankAccountChkbx();
			sideBarMenuComponent.filterComponent().scrollDownFilter();
			sideBarMenuComponent.filterComponent().clickApplyFilter();
			Thread.sleep(3000);
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransactionRow();
			sideBarMenuComponent.transactionDetailsComponent().verifyLblTransactionDetailsHeading();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawTransactionType();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawCogentAccountTransactionSubType();
			sideBarMenuComponent.transactionDetailsComponent().getReferenceId();
			sideBarMenuComponent.transactionDetailsComponent().getReferenceIdCopy();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawId();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawIdCopy();
			sideBarMenuComponent.transactionDetailsComponent().getCreatedDate();
			sideBarMenuComponent.transactionDetailsComponent().getAmountReceived();
			sideBarMenuComponent.transactionDetailsComponent().getWithdrawAmount();
			sideBarMenuComponent.transactionDetailsComponent().getProcessingFee();
			sideBarMenuComponent.transactionDetailsComponent().getTotalAmount();
			sideBarMenuComponent.transactionDetailsComponent().getTransactionDescription();
			sideBarMenuComponent.transactionDetailsComponent().getRecipientEmail();
			sideBarMenuComponent.transactionDetailsComponent().getRecipientAccountID();
			sideBarMenuComponent.transactionDetailsComponent().getRecipientAccountIDaddress();
			sideBarMenuComponent.transactionDetailsComponent().getRecipientName();
			sideBarMenuComponent.transactionDetailsComponent().getRecipientPhone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testTransactionList failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosystemActivityFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickEcosystemActivity();
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransHistory();
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
			sideBarMenuComponent.filterComponent().verifyCogentChkbxView();
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
			ExtentTestManager
					.setFailMessageInReport("test Ecosystem Activity Filters flow failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosystemActivityClearFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickEcosystemActivity();
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransHistory();
			sideBarMenuComponent.filterComponent().verifyFilterCursorAction();
			sideBarMenuComponent.filterComponent().clickFilter();
			sideBarMenuComponent.filterComponent().scrollDownFilter();
			sideBarMenuComponent.filterComponent().calendarComponponent().clickStartDate();
			sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("startDate"));
			sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("endDate"));
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
			sideBarMenuComponent.filterComponent().fill15CharReferenceId(data.get("referenceId"));
			sideBarMenuComponent.filterComponent().clickReferenceIdClear();
			sideBarMenuComponent.filterComponent().clickPendingChkbx();
			sideBarMenuComponent.filterComponent().clickCompletedChkbx();
			sideBarMenuComponent.filterComponent().clickCancelledChkbx();
			sideBarMenuComponent.filterComponent().clickInprogressChkbx();
			sideBarMenuComponent.filterComponent().clickFailedChkbx();
			sideBarMenuComponent.filterComponent().clickTransactionStatusClearAll();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Ecosystem Activity Filters Clear All  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosystemActivityResetAllFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickEcosystemActivity();
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransHistory();
			sideBarMenuComponent.filterComponent().verifyFilterCursorAction();
			sideBarMenuComponent.filterComponent().clickFilter();
			sideBarMenuComponent.filterComponent().calendarComponponent().clickStartDate();
			sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("startDate"));
			sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("endDate"));
			sideBarMenuComponent.filterComponent().clickWalletTransferChkbx();
			sideBarMenuComponent.filterComponent().clickBuyTokenChkBx();
			sideBarMenuComponent.filterComponent().clickWithdrawChkbx();
			sideBarMenuComponent.filterComponent().clickBankAccountChkbx();
			sideBarMenuComponent.filterComponent().clickInstantPayChkbx();
			sideBarMenuComponent.filterComponent().clickSignetChkbx();
			sideBarMenuComponent.filterComponent().fillToCYN(data.get("toCYN"));
			sideBarMenuComponent.filterComponent().fillFromCYN(data.get("fromCYN"));
			sideBarMenuComponent.filterComponent().fill15CharReferenceId(data.get("referenceId"));
			sideBarMenuComponent.filterComponent().clickPendingChkbx();
			sideBarMenuComponent.filterComponent().clickCompletedChkbx();
			sideBarMenuComponent.filterComponent().clickCancelledChkbx();
			sideBarMenuComponent.filterComponent().clickInprogressChkbx();
			sideBarMenuComponent.filterComponent().clickFailedChkbx();
			sideBarMenuComponent.filterComponent().clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Ecosystem Activity ResetAll Filters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosystemActivityExportsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickEcosystemActivity();
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransHistory();
			sideBarMenuComponent.exportComponent().verifyExportCursorAction();
			sideBarMenuComponent.exportComponent().clickExport();
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
			sideBarMenuComponent.exportComponent().verifyDefault8Desc();
//			sideBarMenuComponent.exportComponent().clickimgDropdown();
			sideBarMenuComponent.exportComponent().clickCustom();
			sideBarMenuComponent.exportComponent().clickCustomDateRange();
			sideBarMenuComponent.exportComponent().verifyDateandTimeChkbxView();
			sideBarMenuComponent.exportComponent().verifyReferenceIDChkbxView();
			sideBarMenuComponent.exportComponent().verifyTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifySubTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifyDescriptionChkbxView();
			sideBarMenuComponent.exportComponent().verifyAmountChkbxView();
			sideBarMenuComponent.exportComponent().verifyBalanceChkbxView();
			sideBarMenuComponent.exportComponent().verifyStatusChkbxView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Exports View Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosystemActivityExports(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickEcosystemActivity();
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransHistory();
			sideBarMenuComponent.exportComponent().verifyExportCursorAction();
			sideBarMenuComponent.exportComponent().clickExport();
			if (data.get("validate").equalsIgnoreCase("Today")) {
				sideBarMenuComponent.exportComponent().clickToday();
			}
			if (data.get("validate").equalsIgnoreCase("Yesterday")) {
				sideBarMenuComponent.exportComponent().clickYesterday();
			}
			if (data.get("validate").equalsIgnoreCase("Last 7 Days")) {
				sideBarMenuComponent.exportComponent().clickLast7Days();
			}
			if (data.get("validate").equalsIgnoreCase("Month to Date")) {
				sideBarMenuComponent.exportComponent().clickMonthtoDate();
			}
			if (data.get("validate").equalsIgnoreCase("Last Month")) {
				sideBarMenuComponent.exportComponent().clickLastMonth();
			}
			if (data.get("validate").equalsIgnoreCase("Custom Date Range")) {
				sideBarMenuComponent.exportComponent().clickCustomDateRange();
				sideBarMenuComponent.filterComponent().calendarComponponent().clickStartDate();
				sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("startDate"));
				sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("endDate"));
				sideBarMenuComponent.exportComponent().verifyStartDate(data.get("expStartDate"));
				sideBarMenuComponent.exportComponent().verifyEndDate(data.get("expEndDate"));
			}
			sideBarMenuComponent.exportComponent().clickPopupExport();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Exports failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosystemActivityCustom(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickEcosystemActivity();
			sideBarMenuComponent.ecoSystemActivityComponent().clickTransHistory();
			sideBarMenuComponent.exportComponent().verifyExportCursorAction();
			sideBarMenuComponent.exportComponent().clickExport();
			sideBarMenuComponent.exportComponent().clickToday();
			sideBarMenuComponent.exportComponent().verifyDefault8Desc();
			sideBarMenuComponent.exportComponent().clickCustom();
			sideBarMenuComponent.exportComponent().clickDateandTimeChkbx();
			sideBarMenuComponent.exportComponent().clickReferenceIDChkbx();
			sideBarMenuComponent.exportComponent().clickTypeChkbx();
			sideBarMenuComponent.exportComponent().clickSubTypeChkbx();
			sideBarMenuComponent.exportComponent().clickDescriptionChkbx();
			sideBarMenuComponent.exportComponent().clickAmountChkbx();
			sideBarMenuComponent.exportComponent().clickBalanceChkbx();
			sideBarMenuComponent.exportComponent().clickStatusChkbx();
			sideBarMenuComponent.exportComponent().clickReceiverChkbx();
			sideBarMenuComponent.exportComponent().clickSenderChkbx();
			sideBarMenuComponent.exportComponent().verifyDeselectAllView();
			sideBarMenuComponent.exportComponent().clickDeselectAll();
			sideBarMenuComponent.exportComponent().ClickSelectAllCheckboxes();
			sideBarMenuComponent.exportComponent().clickPopupExport();
			sideBarMenuComponent.exportComponent().verifyPopupHeading(data.get("heading"));
			sideBarMenuComponent.exportComponent().verifyPopupHeadingView();
			sideBarMenuComponent.exportComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Token Wallet Exports Custom is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosystemActivityAPICallHistory(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickEcosystemActivity();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyAPIHeading(data.get("apiHeading"));
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().apiCallsCount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception " + e);

		}
	}
}