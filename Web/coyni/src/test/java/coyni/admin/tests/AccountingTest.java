package coyni.admin.tests;

import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import coyni.admin.components.AccountTableComponent;
import coyni.admin.components.SideBarComponent;
import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class AccountingTest {

	HomePage homePage;
	SideBarComponent sideBarComponent;
	AccountTableComponent accountTableComponent;
	CoyniPortalTest coyniPortalTest;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		sideBarComponent = new SideBarComponent();
		accountTableComponent = new AccountTableComponent();
		coyniPortalTest = new CoyniPortalTest();
	}
	

	public void totalWithdraw(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		Thread.sleep(2000);
		

		homePage.sideBarComponent().accountTableComponent().verifyColumnView();
		int notransactionFound = homePage.sideBarComponent().accountTableComponent().notransactionFound();
		if(notransactionFound>0) {
			ExtentTestManager.setPassMessageInReport("No Transaction Found in the System");
		}else {
		homePage.sideBarComponent().accountTableComponent().clickdrpdwmBatchIdImg();
		homePage.sideBarComponent().accountTableComponent().verifydrpdwnBatchIdView();
		// homePage.sideBarComponent().accountTableComponent().verifydrpdwnDepositIdView();
		homePage.sideBarComponent().accountTableComponent().verifydrpdwnReferenceIdView();
		// homePage.sideBarComponent().accountTableComponent().verifyEnter8charIdView();
//		homePage.sideBarComponent().accountTableComponent().verifyBankAccountView();
		homePage.sideBarComponent().accountTableComponent().fillBatchId(data.get("batchId"));
		// Thread.sleep(2000);
		homePage.sideBarComponent().accountTableComponent().clickSearch();
		Thread.sleep(5000);
		int size = homePage.sideBarComponent().accountTableComponent().getSize();
		if (size > 0) {
			ExtentTestManager.setPassMessageInReport("Transaction Details are not found");
		} else {
			Thread.sleep(4000);
			homePage.sideBarComponent().accountTableComponent().clickDetails();

			Thread.sleep(6000);
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().getTotalBatchAmount();
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().getInProgressCount();
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().getPaidCount();
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().getFailedCount();
			// homePage.sideBarComponent().accountTableComponent().batchIDComponent().getPendingCount();
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().getTotalAccount();
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().verifyBatchId(data.get("bID"));
			Thread.sleep(2000);
//		homePage.sideBarComponent().accountTableComponent().batchIDComponent().paginationAndEntriesComponent()
//		.verifyPageNumbersWithCount();
		}
		}
	}

	public void disableFilter(String strParams) {

	}

	public void testFilters(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		// if(
		// homePage.sideBarComponent().accountTableComponent().batchIDComponent().filterComponent().clickFilters().)
		// {

		if (homePage.sideBarComponent().accountTableComponent().batchIDComponent().filterComponent()
				.noTransaction() != 0) {
			ExtentTestManager.setInfoMessageInReport("Filter button is disable because no transactions");
		} else {
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().filterComponent().clickFilters();
//			homePage.sideBarComponent().accountTableComponent().batchIDComponent().filterComponent()
//					.fillWithdrawID(data.get("withdrawId"));
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().filterComponent()
					.fillReferenceId(data.get("refrenceId"));
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().filterComponent()
					.fillUserId(data.get("userId"));
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().filterComponent()
					.fillNameOnAccount(data.get("nameOnBank"));
		}
	}

	public void testExport(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		if (homePage.sideBarComponent().accountTableComponent().batchIDComponent().filterComponent()
				.noTransaction() != 0) {
			ExtentTestManager.setInfoMessageInReport("Export button is disable because no transactions");
		} else {
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().exportComponent().clickExport();
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().exportComponent()
					.verifyExport(data.get("heading"));
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().exportComponent()
					.clickExportButton();
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().exportComponent()
					.verifyExportPrepared(data.get("exportPrepared"));
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().exportComponent().clickClose();
		}
	}

	@Test
	@Parameters("strParams")
	public void testTotalWithdrawWithSignetAccounts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			Thread.sleep(2000);
			homePage.sideBarComponent().clickTotalWithdraw();
			homePage.sideBarComponent().accountTableComponent().verifyWithdrawView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickCogentAccount();
			totalWithdraw(strParams);
			// testFilters(strParams);
			// testExport(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testTotalWithdrawWithBankAccounts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			Thread.sleep(2000);
			homePage.sideBarComponent().clickTotalWithdraw();
			homePage.sideBarComponent().accountTableComponent().verifyWithdrawView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickBankAccount();
			totalWithdraw(strParams);
//			testFilters(strParams);
//			testExport(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testTotalWithdrawWithInsantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalWithdraw();
			homePage.sideBarComponent().accountTableComponent().verifyWithdrawView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickInstantPay();
			totalWithdraw(strParams);
//			testFilters(strParams);
//			testExport(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testTotalWithdrawWithGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalWithdraw();
			homePage.sideBarComponent().accountTableComponent().verifyWithdrawView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickGiftCard();
			totalWithdraw(strParams);
//			testFilters(strParams);
//			testExport(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testAccountingTest(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarComponent().verifyCursorAction();
//			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
//			homePage.sideBarComponent().clickAccounting();
//			homePage.sideBarComponent().clickTotalWithdraw();
//			homePage.sideBarComponent().clickTotalDeposits();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testAccountingTest Failed due to Exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testTotalDepositsBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
//			homePage.sideBarComponent().verifyTotalDepositsView();
			// Thread.sleep(1000);
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().verifyDepositView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickBankAccount();
			totalWithdraw(strParams);
			testFilters(strParams);
			testExport(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposits failed due to Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTotalDepositSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().verifyDepositView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickCogentAccount();
			totalWithdraw(strParams);
			testFilters(strParams);
			testExport(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposit Signet Account failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTotalDepositCreditandDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().verifyDepositView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickCreditAndDebitCard();
			totalWithdraw(strParams);
			testFilters(strParams);
			testExport(strParams);

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Total Deposit Credit and Debit Card failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTotalDepositFilterView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().fillBatchId(data.get("batch Id"));
			homePage.sideBarComponent().accountTableComponent().clickSearch();
			homePage.sideBarComponent().verifyMouseHoverChangedColor(data.get("cssProp"), data.get("exp value"),
					data.get(" expcolor"));
			homePage.sideBarComponent().profileComponent().clickFilter();
			homePage.sideBarComponent().filterComponent().verifyFiltersLabelView(data.get("elemements"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposit Filter is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTotalDepositsFilterFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().fillBatchId(data.get("batch Id"));
			homePage.sideBarComponent().accountTableComponent().clickSearch();
			homePage.sideBarComponent().verifyMouseHoverChangedColor(data.get("cssProp"), data.get("exp value"),
					data.get(" expcolor"));
			homePage.sideBarComponent().profileComponent().clickFilter();
			homePage.sideBarComponent().filterComponent().fillDepositId(data.get("depositId"));
			homePage.sideBarComponent().filterComponent().fillReferenceId(data.get("referenceId"));
			homePage.sideBarComponent().filterComponent().fillUserId(data.get("UserId"));
			homePage.sideBarComponent().filterComponent().clickchkbxBusiness();
			homePage.sideBarComponent().filterComponent().clickchkbxPersonal();
			homePage.sideBarComponent().filterComponent().clickchkbxCoyniAdmin();
			homePage.sideBarComponent().filterComponent().fillFromAmount(data.get("fromAmount"));
			homePage.sideBarComponent().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().filterComponent().fillNameOnAccount(data.get("accountName"));
			homePage.sideBarComponent().filterComponent().fillBankAccountNumber(data.get("bankAccountNumber"));
			homePage.sideBarComponent().filterComponent().clickchkbxPaid();
			homePage.sideBarComponent().filterComponent().clickchkbxFailed();
			homePage.sideBarComponent().filterComponent().clickchkbxInprogress();
			homePage.sideBarComponent().filterComponent().clickApplyFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total depoist filter flow is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "String strParams" })
	public void testTotalDepositsFilterClearFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().fillBatchId(data.get("batch Id"));
			homePage.sideBarComponent().accountTableComponent().clickSearch();
			homePage.sideBarComponent().verifyMouseHoverChangedColor(data.get("cssProp"), data.get("exp value"),
					data.get(" expcolor"));
			homePage.sideBarComponent().profileComponent().clickFilter();
			homePage.sideBarComponent().filterComponent().fillDepositId(data.get("depositId"));
			homePage.sideBarComponent().filterComponent().clickDepositIdClr();
			homePage.sideBarComponent().filterComponent().fillDepositId(data.get("depositId"));
			homePage.sideBarComponent().filterComponent().fillReferenceId(data.get("referenceId"));
			homePage.sideBarComponent().filterComponent().clickReferenceIdClr();
			homePage.sideBarComponent().filterComponent().fillReferenceId(data.get("referenceId"));
			homePage.sideBarComponent().filterComponent().fillUserId(data.get("UserId"));
			homePage.sideBarComponent().filterComponent().clickUserIdClr();
			homePage.sideBarComponent().filterComponent().clickchkbxBusiness();
			homePage.sideBarComponent().filterComponent().clickchkbxPersonal();
			homePage.sideBarComponent().filterComponent().clickchkbxCoyniAdmin();
			homePage.sideBarComponent().filterComponent().clickUserTypeClearAll();
			homePage.sideBarComponent().filterComponent().clickchkbxBusiness();
			homePage.sideBarComponent().filterComponent().clickchkbxPersonal();
			homePage.sideBarComponent().filterComponent().clickchkbxCoyniAdmin();
			homePage.sideBarComponent().filterComponent().fillFromAmount(data.get("fromAmount"));
			homePage.sideBarComponent().filterComponent().clickFromAmountClr();
			homePage.sideBarComponent().filterComponent().fillFromAmount(data.get("fromAmount"));
			homePage.sideBarComponent().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().filterComponent().clickTOAmountClr();
			homePage.sideBarComponent().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().filterComponent().fillNameOnAccount(data.get("accountName"));
			homePage.sideBarComponent().filterComponent().clickNameOnAccountClr();
			homePage.sideBarComponent().filterComponent().fillNameOnAccount(data.get("accountName"));
			homePage.sideBarComponent().filterComponent().fillBankAccountNumber(data.get("bankAccountNumber"));
			homePage.sideBarComponent().filterComponent().clickBankAccountnumClr();
			homePage.sideBarComponent().filterComponent().fillBankAccountNumber(data.get("bankAccountNumber"));
			homePage.sideBarComponent().filterComponent().clickchkbxPaid();
			homePage.sideBarComponent().filterComponent().clickchkbxFailed();
			homePage.sideBarComponent().filterComponent().clickchkbxInprogress();
			homePage.sideBarComponent().filterComponent().clickTransactionStatusClr();
			homePage.sideBarComponent().filterComponent().clickchkbxPaid();
			homePage.sideBarComponent().filterComponent().clickchkbxFailed();
			homePage.sideBarComponent().filterComponent().clickchkbxInprogress();
			homePage.sideBarComponent().filterComponent().clickResetAllFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposits Filter failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "String strParams" })
	public void testTotalDepositsCreditandDebitCardExports(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().fillBatchId(data.get("batch Id"));
			homePage.sideBarComponent().accountTableComponent().clickSearch();
//		homePage.sideBarComponent().accountTableComponent().verifylblInprogressView();
//		homePage.sideBarComponent().accountTableComponent().verifylblPaidView();
//		homePage.sideBarComponent().accountTableComponent().verifylblFailedView();
//		homePage.sideBarComponent().accountTableComponent().verifylblTotalCountView();
			homePage.sideBarComponent().accountTableComponent().verifyTableLabels(data.get("tableLabels"));
			homePage.sideBarComponent().exportComponent().clickExport();
			homePage.sideBarComponent().exportComponent().VerifylblExportHdgView();
			homePage.sideBarComponent().exportComponent().clickExportDrpdwn();
			homePage.sideBarComponent().exportComponent().clicklblCustom();
			homePage.sideBarComponent().exportComponent().verifydrpdwnDepositIdView();
			homePage.sideBarComponent().exportComponent().verifydrpdwnUserIdView();
			homePage.sideBarComponent().exportComponent().verifydrpdwnFeeView();
			homePage.sideBarComponent().exportComponent().verifydrpdwnFirst6digitsView();
			homePage.sideBarComponent().exportComponent().verifydrpdwnStatusView();
			homePage.sideBarComponent().exportComponent().verifydrpdwnUserTypeView();
			homePage.sideBarComponent().exportComponent().verifydrpdwnRecievedAmountView();
			homePage.sideBarComponent().exportComponent().verifydrpdwnLast4digitsView();
			homePage.sideBarComponent().exportComponent().clickExportButton();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Total Deposits Credit and Debit Card filters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "String strParams" })
	public void testTotalDepositsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().verifyTotalDepositsView();
			homePage.sideBarComponent().clickTotalDeposits();
			if (data.get("paymentMethod").equalsIgnoreCase("signetAccount")) {
				homePage.sideBarComponent().accountTableComponent().verifySignetAccountView();
				homePage.sideBarComponent().accountTableComponent().clickCogentAccount();

			} else if (data.get("paymentMethod").equalsIgnoreCase("cards")) {
				homePage.sideBarComponent().accountTableComponent().verifyCreditandDebitCardView();
				homePage.sideBarComponent().accountTableComponent().clickCreditAndDebitCard();
			}
			homePage.sideBarComponent().accountTableComponent().verifyTableLabels(data.get("tablecolumns"));
			homePage.sideBarComponent().accountTableComponent().clickDropDownId();
			if (data.get("id").equalsIgnoreCase("Batch ID")) {
				homePage.sideBarComponent().accountTableComponent().clickdrpdwnBatchId();
			} else if (data.get("id").equalsIgnoreCase("Reference ID")) {
				homePage.sideBarComponent().accountTableComponent().clickdrpdwnRefferenceId();
			} else {
				homePage.sideBarComponent().accountTableComponent().clickdrpdwnDepositId();
			}
			homePage.sideBarComponent().accountTableComponent().fillBatchId(data.get("value"));
			homePage.sideBarComponent().accountTableComponent().clickSearch();
			homePage.sideBarComponent().accountTableComponent().getRowElements(data.get("columns"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test total deposits View failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "String strParams" })
	public void testTotalDepositsDetailsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			if (data.get("paymentMethod").equalsIgnoreCase("signetAccount")) {
				homePage.sideBarComponent().accountTableComponent().verifySignetAccountView();
				homePage.sideBarComponent().accountTableComponent().clickCogentAccount();

			} else if (data.get("paymentMethod").equalsIgnoreCase("cards")) {
				homePage.sideBarComponent().accountTableComponent().verifyCreditandDebitCardView();
				homePage.sideBarComponent().accountTableComponent().clickCreditAndDebitCard();
			}
			homePage.sideBarComponent().accountTableComponent().clickFirstElement();
			homePage.sideBarComponent().accountTableComponent().verifyLabelHeading(data.get("label Headings"));
			homePage.sideBarComponent().batchIDComponent().getInProgressCount();
			homePage.sideBarComponent().batchIDComponent().getTotalAccount();
			homePage.sideBarComponent().batchIDComponent().getPaidCount();
			homePage.sideBarComponent().batchIDComponent().getFailedCount();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Total deposits detailed view is failed due to Exception " + e);
		}
	}

}
