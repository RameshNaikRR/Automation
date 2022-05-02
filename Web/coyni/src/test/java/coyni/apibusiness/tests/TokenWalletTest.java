package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.FilterComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.TokenWalletPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletTest {

	TokenWalletPage tokenwalletPage;
	SideBarMenuComponent sideBarMenuComponent;
	FilterComponent filterComponent;

	@BeforeMethod
	public void init() {

		tokenwalletPage = new TokenWalletPage();
		sideBarMenuComponent = new SideBarMenuComponent();
		filterComponent = new FilterComponent();
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
	@Test
	public void testTokenWalletFiltersView() {
		try {
		 Map<String, String> data = Runner.getKeywordParameters(null);
		 sideBarMenuComponent.filterComponent().verifyFilterBackgroundColor(data.get("backGround color"), data.get("border"));
		 sideBarMenuComponent.filterComponent().verifyFilterCursorAction();
		 sideBarMenuComponent.filterComponent().clickFilter();
		 sideBarMenuComponent.filterComponent().verifyDateView();
		 sideBarMenuComponent.filterComponent().verifyFromCYNview();
		 sideBarMenuComponent.filterComponent().verifyToCYNview();
		 sideBarMenuComponent.filterComponent().verifyTransactionTypeView();
		 sideBarMenuComponent.filterComponent().verifyWithdrawChkbxView();
		 sideBarMenuComponent.filterComponent().verifyBuyTokenChkbxView();
		 sideBarMenuComponent.filterComponent().verifyWithdrawChkbxView();
		 sideBarMenuComponent.filterComponent().verifyTransactionSubtypeView();
		 sideBarMenuComponent.filterComponent().verifyBankAccountChkbxView();
		 sideBarMenuComponent.filterComponent().verifyInstantPayChkbxView();
		 sideBarMenuComponent.filterComponent().verifySignetChkbxView();
		 sideBarMenuComponent.filterComponent().verifyTransactionAmountView();
		 sideBarMenuComponent.filterComponent().verifyReferenceIdView();
		 sideBarMenuComponent.filterComponent().verifyTransactionStatusView();
		 sideBarMenuComponent.filterComponent().verifyApplyFiltersView();
		 sideBarMenuComponent.filterComponent().verifyResetFiltersView();
		 sideBarMenuComponent.filterComponent().verifyTransactionDateClearView();
		 sideBarMenuComponent.filterComponent().verify15CharIdView();
	
		}catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Filters failed due to Exception " + e);
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
