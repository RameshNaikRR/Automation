package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.components.AuthyComponent;
import coyni.customer.pages.TokenAccountPage;
import coyni.customer.popups.PayAndRequestTokensPopup;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;


public class TokenAccountTest {
	TokenAccountPage tokenAccountPage;
	
	
	
	@BeforeTest
	 public void init() {
        tokenAccountPage = new TokenAccountPage();
        
    }
	
	@Test
	public void testAvailableBalance() {
		try {
			ExtentTestManager.setInfoMessageInReport( "Available balance is displayed as "+ tokenAccountPage.getAvailableBalance());
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test available balance failed due to exception " + e);
		}
	}
	
	@Test
	public void testPayAndRequestTokens() {
		tokenAccountPage.clickPayRequestToken();
	}
	
	@Test
	public void testBuyTokens() {
		tokenAccountPage.clickBuyTokens();
	}
	
	@Test
	public void testWithdrawToUSD() {
		tokenAccountPage.clickWithdrawToUSD();
	}
	
	@Test
	public void testTokenSent() {
		try {
			ExtentTestManager.setInfoMessageInReport( "Tokens sent "+ tokenAccountPage.tokenAccountActivityComponent().getTokensSent());
			tokenAccountPage.tokenAccountActivityComponent().clickTokensSentDetails();
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test token sent failed due to exception " + e);
		}
	}
	
	@Test
	public void testTokenPurchased() {
		try {
			ExtentTestManager.setInfoMessageInReport( "Tokens purchased "+ tokenAccountPage.tokenAccountActivityComponent().getTokensPurchased());
			tokenAccountPage.tokenAccountActivityComponent().clickTokensPurchasedDetails();
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test token purchased failed due to exception " + e);
		}
	}
	
	@Test
	public void testTokenReceived() {
		try {
			ExtentTestManager.setInfoMessageInReport( "Tokens received "+ tokenAccountPage.tokenAccountActivityComponent().getTokensReceived());
			tokenAccountPage.tokenAccountActivityComponent().clickTokensReceivedDetails();
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test token received failed due to exception " + e);
		}
	}
	
	
	
	@Test
	public void testTokenWithdrawn() {
		try {
			ExtentTestManager.setInfoMessageInReport( "Tokens Withdrawn "+ tokenAccountPage.tokenAccountActivityComponent().getTokensWithdrawn());
			tokenAccountPage.tokenAccountActivityComponent().clickTokensWithdrawn();
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test token withdrawn failed due to exception " + e);
		}
	}
	
	@Test
	public void testPaidOrders() {
		try {
			ExtentTestManager.setInfoMessageInReport( "Paid orders "+ tokenAccountPage.tokenAccountActivityComponent().getPaidOrders());
			tokenAccountPage.tokenAccountActivityComponent().clickPaidOrdersDetails();
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test paid orders failed due to exception " + e);
		}
	
	}
	
	
	
	@Test
	@Parameters({"strParams"})
	public void testTodayTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickToday();
			//verify today transactions list?
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test Today Transaction List is failed due to exception " + e);
		}
	}
	
	
	@Test
	@Parameters({"strParams"})
	public void testYesterdayTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickYesterday();
			//verify yesterday transactions list?
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test Yesterday Transaction List is failed due to exception " + e);
		}
	}
	
	
	@Test
	@Parameters({"strParams"})
	public void testLast7DaysTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickLast7Days();
			//verify last7Days transactions list ?
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test Last7Days TransactionList is failed due to exception " + e);
		}
	}
	
	@Test
	@Parameters({"strParams"})
	public void testLastMonthTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickLastMonth();
			//verify lastMonth transactions list?
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test LastMonth TransactionList is failed due to exception " + e);
		}
	}
	
	@Test
	@Parameters({"strParams"})
	public void testMonthToDate(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickMonthToDate();
			//verify monthToDate
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test MonthToDate TransactionList is failed due to exception " + e);
		}
	}
	
	@Test
	@Parameters({"strParams"})
	public void testCustomDateRange(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickCustomDateRange();
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("startDate"));
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
			//verify CustomDateRange
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test CustomDateRange TransactionList is failed due to exception " + e);
		}
	}
	
	
	//Not in Sprint1
	@Test
	@Parameters({"strParams"})
	public void testPayTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountHolderName(data.get("accountHolderName"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("message"));
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			//
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent().verifyHeading(data.get("authyHeading"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent().fillAuthyInput(data.get("securityKey"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent().verifyMessage(data.get("message"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().successFailurePopupCardComponent().verifyHeading(data.get("successFailureHeading"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().successFailurePopupCardComponent().verifyImage(data.get("image"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().successFailurePopupCardComponent().verifyMessge(data.get("sucessMessage"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().successFailurePopupCardComponent().clickDone();
		}
	catch (Exception e) {
        ExtentTestManager.setFailMessageInReport("testPayTransaction failed due to exception " + e);
    }
	}
	
	@Test
	@Parameters({"strParams"})
	public void testRequestTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("message"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountHolderName(data.get("accountHolderName"));
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			//
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup().successFailurePopupCardComponent().verifyHeading(data.get("successFailureHeading"));
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup().successFailurePopupCardComponent().verifyImage(data.get("image"));
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup().successFailurePopupCardComponent().verifyMessge(data.get("sucessMessage"));
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup().successFailurePopupCardComponent().clickDone();
			
		}
		catch (Exception e) {
	        ExtentTestManager.setFailMessageInReport("testRequestTransaction failed due to exception " + e);
	    }
    }
	
	@Test
	@Parameters({"strParams"})
	public void testBuyTokenTransactionBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickBank();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("Amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().transactionInProgessPopup().clickDone();
			
		}
		catch (Exception e) {
            ExtentTestManager.setFailMessageInReport("test Buy Token Transaction with bank account failed due to exception " + e);
        }
	}
	
	@Test
	@Parameters({"strParams"})
	public void testBuyTokenTransactionCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickCredit();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("Amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().transactionInProgessPopup().clickDone();
			
		}
		catch (Exception e) {
            ExtentTestManager.setFailMessageInReport(" test Buy Token Transaction with credit card failed due to exception " + e);
        }
	}
	
	@Test
	@Parameters({"strParams"})
	public void testBuyTokenTransactionDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickDebit();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("Amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().transactionInProgessPopup().clickDone();
			
		}
		catch (Exception e) {
            ExtentTestManager.setFailMessageInReport(" test Buy Token Transaction with debit card failed due to exception " + e);
        }
	}
	
	
}
