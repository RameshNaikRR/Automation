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
	public void testTokenAccountFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyMouseHoverChangedColor("cssProp",
					"expValue", "expColor");
			homePage.sideBarComponent().tokenAccountPage().filterComponent().viewFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().selectFilter(data.get("filterType"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("amount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("amount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillReferenceID(data.get("referenceID"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyEmployeeName(data.get("empName"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenAccountResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyMouseHoverChangedColor("cssProp",
					"expValue", "expColor");
			homePage.sideBarComponent().tokenAccountPage().filterComponent().viewFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().selectFilter(data.get("filterType"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("amount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("amount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillReferenceID(data.get("referenceID"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyEmployeeName(data.get("empName"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountResetFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
//			homePage.sideBarComponent().clickCoyniPortal();
//			homePage.sideBarComponent().clickTokenAccount();
			tokenAccountPage.clickWithdrawToSignet();
			tokenAccountPage.noSignetAccountsExistPopup().verifyPageHeading(data.get("noSignetAccountsExistHeading"));
			tokenAccountPage.noSignetAccountsExistPopup().verifyPageDescription(data.get("description"));
			tokenAccountPage.noSignetAccountsExistPopup().clickAddSignet();
			// tokenAccountPage.addNewSignetAccountPopup().verifyPageHeading(data.get("addNewSignetAccountHeading
			// "));
			tokenAccountPage.addNewSignetAccountPopup().fillName(data.get("newSignetAccount"));
			tokenAccountPage.addNewSignetAccountPopup().fillSignetWalletId(data.get("walletID"));
			// tokenAccountPage.addNewSignetAccountPopup().clickPaste();
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
	public void testWithdrawToSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToSignet();
			tokenAccountPage.withdrawToSignetPopup().verifyPageHeading(data.get("withdrawToSignetAccountHeading"));
			tokenAccountPage.withdrawToSignetPopup().fillAmount(data.get("amount"));
			tokenAccountPage.withdrawToSignetPopup().getAvailableBalance();
			tokenAccountPage.withdrawToSignetPopup().fillMessage(data.get("description"));
			tokenAccountPage.withdrawToSignetPopup().clickNext();
			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup()
					.verifyPageHeading(data.get("withdrawToSignetPreviewHeading"));
			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().verifyAmount(data.get("amount"));
			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getWithdrawAmount();
			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getProcessingFee();
			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getTotal();
			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().clickConfirm();
			// tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent().verifyPageHeading(data.get("authyHeading1"));
			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent()
					.fillInput(data.get("code"));
			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent()
					.successFailureComponent();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRemoveSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToSignet();
			tokenAccountPage.withdrawToSignetPopup().verifyPageHeading(data.get("withdrawToSignetAccountHeading"));
			tokenAccountPage.withdrawToSignetPopup().clickDeleteSignetIcon();
			tokenAccountPage.withdrawToSignetPopup().removeSignetAccountPopup()
					.verifyPageHeading(data.get("removeSignetAccountHeading"));
			tokenAccountPage.withdrawToSignetPopup().removeSignetAccountPopup()
					.verifyPageDescription(data.get("description"));
			// tokenAccountPage.withdrawToSignetPopup().removeSignetAccountPopup().verifyWalletIDView();
			tokenAccountPage.withdrawToSignetPopup().removeSignetAccountPopup().clickRemove();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

}
