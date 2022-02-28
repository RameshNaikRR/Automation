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
			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().clickCommissionAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCoyniPortal Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTopBar(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.topBarComponent().fillSearch(data.get("search"));
			homePage.topBarComponent().clickDropDownUserName();
			homePage.topBarComponent().verifyCursorAction();
			homePage.topBarComponent().clickUserName();
			homePage.topBarComponent().adminUserDetailsPage().verifyPageHeading(data.get("heading"));
			homePage.topBarComponent().verifyCursorAction();
			homePage.topBarComponent().clickChangePassword();
			homePage.topBarComponent().navigationComponent().clickBack();
			homePage.topBarComponent().clickDropDownUserName();
			homePage.topBarComponent().clickSignOut();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTopBar Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().tokenAccountPage().verifyPageHeading(data.get("heading"));
			homePage.sideBarComponent().tokenAccountPage().getTotalAvailable();
			homePage.sideBarComponent().tokenAccountPage().clickWithdrawToSignet();
			homePage.sideBarComponent().tokenAccountPage().navigationComponent().clickBack();
			homePage.sideBarComponent().tokenAccountPage().verifyPageHeading(data.get("heading"));

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
			tokenAccountPage.withdrawToSignetPopup().verifyTransDescription(data.get("Description"));
			tokenAccountPage.withdrawToSignetPopup().clickNext();
			tokenAccountPage.withdrawToSignetPreviewPopup().clickConfirm();
			tokenAccountPage.authyComponent().verifyLogin();
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
			tokenAccountPage.noSignetAccountsExistPopup()
					.verifyPageHeading(data.get("No Signet Accounts Exist Heading"));
			tokenAccountPage.noSignetAccountsExistPopup().verifyPageDescription(data.get("Description"));
			tokenAccountPage.noSignetAccountsExistPopup().clickAddSignet();
			tokenAccountPage.addNewSignetAccountPopup().verifyPageHeading(data.get("Add New Signet Account Heading "));
			tokenAccountPage.addNewSignetAccountPopup().fillName(data.get("New Signet Account"));
			tokenAccountPage.addNewSignetAccountPopup().fillSignetWalletId(data.get("Adsfgt12345"));
			tokenAccountPage.addNewSignetAccountPopup().clickPaste();
			tokenAccountPage.mailingAddressComponent().fillAddress1(data.get("addressLine1"));
			tokenAccountPage.mailingAddressComponent().fillAddress2(data.get("addressLine2"));
			tokenAccountPage.mailingAddressComponent().fillCity(data.get("city"));
			tokenAccountPage.mailingAddressComponent().clickstate();
			tokenAccountPage.mailingAddressComponent().selectState(data.get("state"));
			tokenAccountPage.mailingAddressComponent().fillZipCode(data.get("zipCode"));
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
			tokenAccountPage.removeSignetAccountPopup().verifyPageHeading(data.get(" Remove Signet Account Heading"));
			tokenAccountPage.removeSignetAccountPopup().verifyPageDescription(data.get("Description "));
			tokenAccountPage.removeSignetAccountPopup().verifyWalletIDView();
			tokenAccountPage.removeSignetAccountPopup().verifyName(data.get("Signet Account "));
			tokenAccountPage.removeSignetAccountPopup().clickRemove();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

}
