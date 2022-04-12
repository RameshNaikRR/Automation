package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.TokenWalletPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletTest {

	TokenWalletPage tokenwalletPage;
	SideBarMenuComponent sideBarMenuComponent;

	@BeforeMethod
	public void init() {

		tokenwalletPage = new TokenWalletPage();
		sideBarMenuComponent = new SideBarMenuComponent();
	}
	@Test
	@Parameters({"strParams"})
	public void testTokenWalletView(String strParams) {
		try {
		 Map<String, String> data = Runner.getKeywordParameters(strParams);
		 sideBarMenuComponent.verifyTokenWalletView();
		 sideBarMenuComponent.verifyHandCursorAction();
		 sideBarMenuComponent.verifyTokenWalletBackGroundColor(data.get("backgroundcolor"), data.get("border"));
		 sideBarMenuComponent.clickTokenwallet();
		 Thread.sleep(5000);
		 sideBarMenuComponent.tokenWalletPage().verifyHeading(data.get("heading"));
		 sideBarMenuComponent.tokenWalletPage().verifyTotalWalletBalanceView();
		 sideBarMenuComponent.tokenWalletPage().getWalletInfo();
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet view is failed due to Exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testTokenWalletBalance(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenwalletPage.verifyTokenWalletBalanceView(data.get("walletBalanceHeading"));
//			tokenwalletPage.getWalletBalance();
//			tokenwalletPage.verifyCurrencyView();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testTransferTokensView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenwalletPage.clickItem(data.get("walletName"));
//			tokenwalletPage.verifyMouseActionTransferTokens();
//			tokenwalletPage.clickTransferTokens();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyTokensView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenwalletPage.clickItem(data.get("walletName"));
//			tokenwalletPage.verifyMouseActionBuyTokens();
//			tokenwalletPage.clickBuyTokens();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUsdView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenwalletPage.clickItem(data.get("walletName"));
//			tokenwalletPage.verifyMouseActionWithdrawToUsd();
//			tokenwalletPage.clickWithdrawToUsd();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
//		}
//	}
}
