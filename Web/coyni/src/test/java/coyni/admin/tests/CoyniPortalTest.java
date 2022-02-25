package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import coyni.admin.pages.TokenAccountPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CoyniPortalTest {
	TokenAccountPage tokenAccountPage;
	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		tokenAccountPage = new TokenAccountPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testCoyniPortal(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().clickCommissionAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCoyniPortal Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToSignet();
			tokenAccountPage.withdrawToSignetPopup().verifyPageHeading(data.get("Withdraw To Signet Account"));
			tokenAccountPage.withdrawToSignetPopup().fillAmount(data.get("5.00"));
			tokenAccountPage.withdrawToSignetPopup().getAvailableBalance();
			tokenAccountPage.withdrawToSignetPopup().verifyTransDescription(data.get(""));
			tokenAccountPage.withdrawToSignetPopup().clickNext();
			tokenAccountPage.withdrawToSignetPreviewPopup().clickConfirm();
			tokenAccountPage.authyComponent();
			tokenAccountPage.successFailureComponent();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.noSignetAccountsExistPopup().verifyPageHeading(data.get("No Signet Accounts Exist"));
			tokenAccountPage.noSignetAccountsExistPopup().verifyPageDescription(data.get(""));
			tokenAccountPage.noSignetAccountsExistPopup().clickAddSignet();
			tokenAccountPage.addNewSignetAccountPopup().verifyPageHeading(data.get(" "));
			tokenAccountPage.addNewSignetAccountPopup().fillName(data.get(" "));
			tokenAccountPage.addNewSignetAccountPopup().fillSignetWalletId(data.get(" "));
			tokenAccountPage.addNewSignetAccountPopup().clickPaste();
			tokenAccountPage.mailingAddressComponent();
			tokenAccountPage.addNewSignetAccountPopup().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRemoveSignetAccount(String strparams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strparams);
			tokenAccountPage.removeSignetAccountPopup().verifyPageHeading(data.get(" Remove Signet Account"));
			tokenAccountPage.removeSignetAccountPopup().verifyPageDescription(data.get(" "));
			tokenAccountPage.removeSignetAccountPopup().verifyWalletIDView();
			tokenAccountPage.removeSignetAccountPopup().verifyName(data.get(" "));
			tokenAccountPage.removeSignetAccountPopup().clickRemove();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

}
