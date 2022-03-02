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
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposits failed due to Exception" + e);
		}
	}

	@Test
	public void testTotalDepositSignetAccount() {
		try {
			Map<String, String> data = Runner.getKeywordParameters(null);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().verifySignetAccountView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposit Signet Account failed due to Exception " + e);
		}
	}

	@Test
	public void testTotalDepositCreditandDebitCard() {
		try {
			Map<String, String> data = Runner.getKeywordParameters(null);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalDeposits();
			homePage.sideBarComponent().accountTableComponent().verifyCreditandDebitCardView();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Total Deposit Credit and Debit Card failed due to Exception " + e);
		}
	}
	@Test
	public void testTotalDepositFilter() {
		try {
		 Map<String, String> data = Runner.getKeywordParameters(null);
		 homePage.sideBarComponent().clickAccounting();
		 homePage.sideBarComponent().clickTotalDeposits();
		 homePage.sideBarComponent().accountTableComponent().fillBatchId(data.get("batch Id"));
		 homePage.sideBarComponent().accountTableComponent().clickSearch();
		 homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "exp value", " expcolor");
		 homePage.sideBarComponent().profileComponent().clickFilter();	 
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposit Filter is failed due to Exception " + e);
		}	
	}
	}
