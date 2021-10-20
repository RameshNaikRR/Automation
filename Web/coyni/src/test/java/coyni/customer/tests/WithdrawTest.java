package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.TokenAccountPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawTest {
	
	TokenAccountPage tokenAccountPage;
	
	@BeforeTest
	public void init() {
		tokenAccountPage = new TokenAccountPage();
		
	}
	
	@Test
	@Parameters({"strParams"})
	public void testWithdrawAddNewExternalBankAccount(String strParams) {
		try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 tokenAccountPage.clickWithdrawToUSD();
			 tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().clickOnAddPayment();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().addExternalBankAccountPopup().clickLearnMore();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().addExternalBankAccountPopup().clickBack();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().addExternalBankAccountPopup().clickIamReady();
			 
		
			 
			 } catch (Exception e) {
				 ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
			
		}
		
	}
	@Test
	@Parameters({"strParams"})
	public void testWithdrawBank(String strParams) {
		try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 tokenAccountPage.clickWithdrawToUSD();
			 tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().clickOnSelectBank();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().clickNext();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().withdrawToBankAccountPopup().fillAmount(data.get("amount"));
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().withdrawToBankAccountPopup().fillMessage(data.get("message"));
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().withdrawToBankAccountPopup().clickNext();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().withdrawToBankAccountPopup().withdrawConfirmPopup().clickConfirm();
			 tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().withdrawToBankAccountPopup().withdrawConfirmPopup().authyComponent().fillAuthyInput(data.get("securityKey"));
		     tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountSelectBankPopup().withdrawToBankAccountPopup().withdrawConfirmPopup().transactionInProgessPopup().clickDone();
		} catch (Exception e) {
				ExtentTestManager.setFailMessageInReport("Failed due to this Exception");
			
		}
		
	}


}
