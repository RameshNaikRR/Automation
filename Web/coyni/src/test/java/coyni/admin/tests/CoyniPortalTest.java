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
			ExtentTestManager.setFailMessageInReport("testTokenAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenAccountActivity(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().tokenAccountPage().verifyTokenAccountActivityView(data.get("heading"));
			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();
			homePage.sideBarComponent().tokenAccountPage().daysMonthsDropDownComponent().clickOnToday();
			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();
			homePage.sideBarComponent().tokenAccountPage().daysMonthsDropDownComponent().clickOnYesterday();
			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();
			homePage.sideBarComponent().tokenAccountPage().daysMonthsDropDownComponent().clickOnLast7Days();
			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();
			homePage.sideBarComponent().tokenAccountPage().daysMonthsDropDownComponent().clickOnMonthToDate();
			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();
			homePage.sideBarComponent().tokenAccountPage().daysMonthsDropDownComponent().clickOnMonthToDate();
			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();
			homePage.sideBarComponent().tokenAccountPage().daysMonthsDropDownComponent().clickOnLastMonth();
			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();
			homePage.sideBarComponent().tokenAccountPage().daysMonthsDropDownComponent().clickOnCustomDateRange();
			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountActivity Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenAccountTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().tokenAccountPage().transactionPage()
					.verifyTransactionHeading(data.get("heading"));
			ExtentTestManager.setInfoMessageInReport("Available balance is displayed as "
					+ homePage.sideBarComponent().tokenAccountPage().getTotalAvailable());
			homePage.sideBarComponent().tokenAccountPage().transactionPage().getDateAndTime();
			homePage.sideBarComponent().tokenAccountPage().transactionPage().getType();
			homePage.sideBarComponent().tokenAccountPage().transactionPage().getDescription();
			homePage.sideBarComponent().tokenAccountPage().transactionPage().getAmount();
			homePage.sideBarComponent().tokenAccountPage().transactionPage().getStatus();
			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
					.verifyTableItemsCount(data.get("query"));
			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
					.verifyPageNumbersWithCount();
			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
					.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
			homePage.sideBarComponent().tokenAccountPage().transactionPage().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport("Entries is displayed as "
					+ homePage.sideBarComponent().tokenAccountPage().transactionPage().getEntriesMessage());
			homePage.sideBarComponent().tokenAccountPage().transactionPage().clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountTransactionList Failed due to Exception " + e);
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
