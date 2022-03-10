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

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		sideBarComponent = new SideBarComponent();
		accountTableComponent = new AccountTableComponent();
	}

	@Test
	@Parameters("strParams")
	public void testTotalWithdrawWithBankAccounts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalWithdraw();
			homePage.sideBarComponent().accountTableComponent().verifyWithdrawView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickBankAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testTotalWithdrawWithSignetAccounts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalWithdraw();
			homePage.sideBarComponent().accountTableComponent().verifyWithdrawView(data.get("withdraw"));
			homePage.sideBarComponent().accountTableComponent().clickSignetAccount();
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
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountingTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalWithdraw();
			homePage.sideBarComponent().clickTotalDeposits();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountingTest Failed due to Exception " + e);
		}
	}

	@Test
	public void testTotalDepositsBankAccount() {
		try {
			Map<String, String> data = Runner.getKeywordParameters(null);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().verifyTotalDepositsView();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().verifyBankAccountView();
			homePage.sideBarComponent().accountTableComponent().batchIDComponent().verifyBatchIdView();
			homePage.sideBarComponent().accountTableComponent().verifyEnter8charIdView();
			homePage.sideBarComponent().accountTableComponent().verifyButtonSearchView();
			homePage.sideBarComponent().accountTableComponent().clickdrpdwmBatchIdImg();
			homePage.sideBarComponent().accountTableComponent().verifydrpdwnBatchIdView();
			homePage.sideBarComponent().accountTableComponent().verifydrpdwnDepositIdView();
			homePage.sideBarComponent().accountTableComponent().verifydrpdwnReferenceIdView();
			homePage.sideBarComponent().accountTableComponent().clickdrpdwnBatchId();
			homePage.sideBarComponent().accountTableComponent().verifyTableLabels(data.get("tablecolumns"));
			
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposits failed due to Exception" + e);
		}
	}

	@Test
	@Parameters({"String strParams"})
	public void testTotalDepositSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().verifySignetAccountView();
			homePage.sideBarComponent().accountTableComponent().verifyTableLabels(data.get("tablecolumns"));	
			} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposit Signet Account failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({"String strParams"})
	public void testTotalDepositCreditandDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().verifyCreditandDebitCardView();
			homePage.sideBarComponent().accountTableComponent().verifyTableLabels(data.get("tableColumns"));
            
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
	@Parameters({"String strParams"})
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
			homePage.sideBarComponent().filterComponent().clickDepositIdClr();
			homePage.sideBarComponent().filterComponent().clickReferenceIdClr();
			homePage.sideBarComponent().filterComponent().clickUserIdClr();
			homePage.sideBarComponent().filterComponent().clickUserTypeClearAll();
			homePage.sideBarComponent().filterComponent().clickDepositAmtClr();
			homePage.sideBarComponent().filterComponent().clickNameOnAccountClr();
			homePage.sideBarComponent().filterComponent().clickBankAccountnumClr();
			homePage.sideBarComponent().filterComponent().clickTransactionStatusClr();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposits Filter failed due to Exception " + e);
		}

	}
	@Test
	@Parameters({"String strParams"})
	public void testTotalDepositsFilterResetFilters(String strParams) {
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
				homePage.sideBarComponent().filterComponent().clickResetAllFilters();
		}catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposits Filter failed due to Exception " + e);
		}
	}
	@Test
	@Parameters({"String strParams"})
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
		}catch(Exception e){
			ExtentTestManager.setFailMessageInReport("test Total Deposits Credit and Debit Card filters failed due to Exception " + e);
		}
	}
	@Test
	@Parameters({"String strParams"})
	public void testTotalDepositsView(String strParams) {
		try { 
		  Map<String, String> data = Runner.getKeywordParameters(strParams);
		   homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().verifyTotalDepositsView();
			homePage.sideBarComponent().clickTotalDeposits();
			if(data.get("paymentMethod").equalsIgnoreCase("signetAccount")) {
				homePage.sideBarComponent().accountTableComponent().verifySignetAccountView();
				homePage.sideBarComponent().accountTableComponent().clickSignetAccount();
				
			}else if(data.get("paymentMethod").equalsIgnoreCase("cards")) {
				homePage.sideBarComponent().accountTableComponent().verifyCreditandDebitCardView();
				homePage.sideBarComponent().accountTableComponent().clickCreditAndDebitCard();
			}
			homePage.sideBarComponent().accountTableComponent().verifyTableLabels(data.get("tablecolumns"));	
			homePage.sideBarComponent().accountTableComponent().clickDropDownId();
			if(data.get("id").equalsIgnoreCase("Batch ID")) {
				homePage.sideBarComponent().accountTableComponent().clickdrpdwnBatchId();
			}else if(data.get("id").equalsIgnoreCase("Reference ID")) {
				homePage.sideBarComponent().accountTableComponent().clickdrpdwnRefferenceId();
			}else{
				homePage.sideBarComponent().accountTableComponent().clickdrpdwnDepositId();
			}
			homePage.sideBarComponent().accountTableComponent().fillBatchId(data.get("value"));
			homePage.sideBarComponent().accountTableComponent().clickSearch();
			homePage.sideBarComponent().accountTableComponent().getRowElements(data.get("columns"));
			
		}catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test total deposits View failed due to Exception " + e);
		}  
	}
	
	@Test
	@Parameters({"String strParams"})
	public void testTotalDepositsDetailsView(String strParams) {
		try {
		   Map<String, String> data = Runner.getKeywordParameters(strParams);
		   homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			if(data.get("paymentMethod").equalsIgnoreCase("signetAccount")) {
				homePage.sideBarComponent().accountTableComponent().verifySignetAccountView();
				homePage.sideBarComponent().accountTableComponent().clickSignetAccount();
				
			}else if(data.get("paymentMethod").equalsIgnoreCase("cards")) {
				homePage.sideBarComponent().accountTableComponent().verifyCreditandDebitCardView();
				homePage.sideBarComponent().accountTableComponent().clickCreditAndDebitCard();
			}
			homePage.sideBarComponent().accountTableComponent().clickFirstElement();
			homePage.sideBarComponent().accountTableComponent().verifyLabelHeading(data.get("label Headings"));
			homePage.sideBarComponent().batchIDComponent().getInProgressCount();
			homePage.sideBarComponent().batchIDComponent().getTotalAccount();
			homePage.sideBarComponent().batchIDComponent().getPaidCount();
			homePage.sideBarComponent().batchIDComponent().getFailedCount();
		   
		}catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total deposits detailed view is failed due to Exception "+ e);
		}
	}
	
	
	
	
	
}
