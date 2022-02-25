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
	SideBarComponent  sideBarComponent;
	AccountTableComponent accountTableComponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		sideBarComponent = new SideBarComponent();
		accountTableComponent = new AccountTableComponent();
		

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
	   }catch(Exception e) {
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
		   }catch(Exception e) {
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
			
		}catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test Total Deposit Credit and Debit Card failed due to Exception " + e);
		}
	}

}
