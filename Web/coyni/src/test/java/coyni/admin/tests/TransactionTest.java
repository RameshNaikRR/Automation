package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.SideBarComponent;
import coyni.admin.pages.HomePage;
import coyni.admin.pages.TransactionPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionTest {

	HomePage homePage;
	TransactionPage transactionPage;
	SideBarComponent sideBarComponent;
	CoyniPortalTest coyniPortalTest;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		transactionPage = new TransactionPage();
		sideBarComponent = new SideBarComponent();
		coyniPortalTest = new CoyniPortalTest();
	}

	
	
	
	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickTransactions();
			homePage.sideBarComponent().transactionPage().verifyTransactionHeading(data.get("listHeading"));
		
			homePage.sideBarComponent().transactionPage().getDateAndTime();
			homePage.sideBarComponent().transactionPage().getType();
			homePage.sideBarComponent().transactionPage().getDescription();
			homePage.sideBarComponent().transactionPage().getAmount();
			homePage.sideBarComponent().transactionPage().getStatus();
			homePage.sideBarComponent().transactionPage().paginationAndEntriesComponent()
					.verifyTableItemsCount(data.get("query"));
			homePage.sideBarComponent().transactionPage().paginationAndEntriesComponent()
					.verifyPageNumbersWithCount();
			homePage.sideBarComponent().transactionPage().paginationAndEntriesComponent()
					.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
			homePage.sideBarComponent().transactionPage().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport("Entries is displayed as "
					+ homePage.sideBarComponent().transactionPage().getEntriesMessage());
			homePage.sideBarComponent().transactionPage().clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountTransactionList Failed due to Exception " + e);
		}
	}

	
	
	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionToday(String strParams)  {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Today");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionYesterday(String strParams) {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Yesterday");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastSevenDays(String strParams) {

		Map<String, String> data = Runner.getKeywordParameters(strParams);

		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Last 7 Days");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastMonth(String strParams) {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Last Month");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionMonthToDate(String strParams) {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Month to Date");
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListFilters(String strParams) {
		try {
			homePage.sideBarComponent().clickTransactions();
			
			coyniPortalTest.testFilters(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListResetFilters(String strParams) {
		try {
			homePage.sideBarComponent().clickTransactions();
			coyniPortalTest.testFilters(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDebitCard(String strParams) {
		try {

			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickBuyToken();
			testTransactionDetailsBuyToken(strParams, "debit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenCreditCard(String strParams) {
		try {

			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickBuyToken();
			testTransactionDetailsBuyToken(strParams, "credit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	
	public void testTransactionDetailsBuyToken(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (card.equalsIgnoreCase("debit")) {
				sideBarComponent.transactionPage().filterComponent().clickDebitCard();
			} else {
				sideBarComponent.transactionPage().filterComponent().clickCreditCard();
			}
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getRecipientPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardholderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyExpirationDate();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyProcessorID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyProcessorAuthCode();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionPage().filterComponent().clickGiftCard();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getgiftCardAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientEmail();

			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifySenderInformation(data.get("senderInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderPhoneNumber();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickBuyToken();
			sideBarComponent.transactionPage().filterComponent().clickExternalBankAccount();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getRecipientPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyBankInformation(data.get("bankInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getBankName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailWithdrawInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionPage().filterComponent().clickInstantPay();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			// sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifySenderInformation(data.get("senderInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyCardInformation(data.get("cardInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardholderName();
			// sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyExpirationDate();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionPage().filterComponent().clickExternalBankAccount();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifySenderInformation(data.get("senderInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyBankAccountInformation(data.get("bankInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getBankName();
			;

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

}
