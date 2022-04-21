package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.SideBarComponent;
import coyni.admin.components.TransactionDetailsComponent;
import coyni.admin.pages.HomePage;
import coyni.admin.pages.TransactionPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionTest {

	HomePage homePage;
	TransactionPage transactionPage;
	SideBarComponent sideBarComponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		transactionPage= new TransactionPage();
		sideBarComponent = new SideBarComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickTransactions();
		//	homePage.sideBarComponent().

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsBuyDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickBuyToken();
			sideBarComponent.transactionPage().filterComponent().clickDebitCard();
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
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardholderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyExpirationDate();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyProcessorID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyProcessorAuthCode();
		
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsBuyCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickBuyToken();
			sideBarComponent.transactionPage().filterComponent().clickCreditCard();
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
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardholderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyExpirationDate();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyProcessorID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyProcessorAuthCode();
		
			
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
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientEmail();
			
			
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifySenderInformation(data.get("senderInformation"));
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
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyBankInformation(data.get("bankInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getBankName();;
		
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
		//	sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifySenderInformation(data.get("senderInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardInformation(data.get("cardInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardholderName();
			//sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
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
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifySenderInformation(data.get("senderInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyBankAccountInformation(data.get("bankInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getBankName();;
		
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}
	
	
	
	
	
	
	
}
