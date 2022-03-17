package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.apibusiness.pages.TokenWalletPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletTest {

	TokenWalletPage tokenwalletPage;

	@BeforeMethod
	public void init() {

		tokenwalletPage = new TokenWalletPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletBalance(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenwalletPage.verifyTokenWalletBalanceView(data.get("walletBalancenHeading"));
			tokenwalletPage.getWalletBalance();
			tokenwalletPage.verifyCurrencyView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}

	}
}
