package coyni.admin.tests;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.CommissionAccountPage;
import coyni.admin.pages.HomePage;
import coyni.admin.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CoyniPortalTest {
	TokenAccountPage tokenAccountPage;
	HomePage homePage;
	CommissionAccountPage commissionAccountPage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		tokenAccountPage = new TokenAccountPage();
		commissionAccountPage = new CommissionAccountPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testCoyniPortal(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			// homePage.sideBarComponent().clickCoyniPortal();
			// homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp",
			// "expValue", "expColor");
			homePage.sideBarComponent().clickTokenAccount();
			Thread.sleep(2000);
			// homePage.sideBarComponent().clickCoyniPortal();
			// homePage.sideBarComponent().clickCommissionAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCoyniPortal Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTopBar(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// homePage.topBarComponent().fillSearch(data.get("search"));
			homePage.topBarComponent().clickDropDownUserName();
			// homePage.topBarComponent().verifyCursorAction();
			homePage.topBarComponent().clickUserName();
			homePage.topBarComponent().adminUserDetailsPage().verifyPageHeading(data.get("heading"));
			// homePage.topBarComponent().verifyCursorAction();
			homePage.topBarComponent().clickDropDownUserName();
			homePage.topBarComponent().clickChangePassword();
			homePage.topBarComponent().navigationComponent().clickClose();
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
			// homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().tokenAccountPage().verifyPageHeading(data.get("heading"));
			homePage.sideBarComponent().tokenAccountPage().getTotalAvailable();
			homePage.sideBarComponent().tokenAccountPage().clickWithdrawToSignet();
			homePage.sideBarComponent().tokenAccountPage().navigationComponent().clickClose();
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
			// homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().tokenAccountPage().verifyTokenAccountActivityView(data.get("heading"));
//			homePage.sideBarComponent().tokenAccountPage().getPayOutsReceived();
//			homePage.sideBarComponent().tokenAccountPage().getSignetWithdraw();
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

	public void testFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			HomePage homePage = new HomePage();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyMouseHoverChangedColor("cssProp",
//					"expValue", "expColor");
			homePage.sideBarComponent().tokenAccountPage().filterComponent().viewFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().selectFilter(data.get("filterType"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("amount"));
			// homePage.sideBarComponent().tokenAccountPage().filterComponent().fillReferenceID(data.get("referenceID"));
			// homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyEmployeeName(data.get("empName"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenAccountFilters(String strParams) {

		// Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickTokenAccount();
		testFilters(strParams);

	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenAccountResetFilters(String strParams) {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickTokenAccount();
		testResetFilters(strParams);

	}

	public void testResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			HomePage homePage = new HomePage();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyMouseHoverChangedColor("cssProp",
					"expValue", "expColor");
			homePage.sideBarComponent().tokenAccountPage().filterComponent().viewFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().selectFilter(data.get("filterType"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("amount"));
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillReferenceID(data.get("referenceID"));
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyEmployeeName(data.get("empName"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountResetFilters Failed due to Exception " + e);
		}
	}

	public void testExportSelectedTransactions(String strParams, String strParams1) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			HomePage homePage = new HomePage();
			if (strParams1.equalsIgnoreCase("Today")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnToday();
			} else if (strParams1.equalsIgnoreCase("Yesterday")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnYesterday();

			} else if (strParams1.equalsIgnoreCase("Last 7 Days")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOn7Days();
			} else if (strParams1.equalsIgnoreCase("Last Month")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnLastMonth();
			} else if (strParams1.equalsIgnoreCase("Month to Date")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickMonthTODate();
			} else {
				ExtentTestManager.setInfoMessageInReport("Export is done");
			}
			Thread.sleep(2000);
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnExport();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
					.verifyTitle(data.get("exportHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickExportPage();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionToday(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
				.verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Today");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionYesterday(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
				.verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Yesterday");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastSevenDays(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
				.verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Last Seven Days");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastMonth(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
				.verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Last Month");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionMonthToDate(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
				.verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Month to Date");
	}

	public void addSignet(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		tokenAccountPage.noSignetAccountsExistPopup().verifyPageHeading(data.get("noSignetAccountsExistHeading"));
		// tokenAccountPage.noSignetAccountsExistPopup().verifyPageDescription(data.get("description"));
		Thread.sleep(1000);
		tokenAccountPage.noSignetAccountsExistPopup().clickAddSignet();
		Thread.sleep(1000);
		// tokenAccountPage.addNewSignetAccountPopup().verifyPageHeading(data.get("addNewSignetAccountHeading
		// "));
		tokenAccountPage.addNewSignetAccountPopup().fillName(data.get("newSignetAccount"));
		tokenAccountPage.addNewSignetAccountPopup().fillSignetWalletId(data.get("walletID"));
// tokenAccountPage.addNewSignetAccountPopup().clickPaste();
		tokenAccountPage.mailingAddressComponent().fillAddress1(data.get("addressLine1"));
		tokenAccountPage.mailingAddressComponent().fillAddress2(data.get("addressLine2"));
		tokenAccountPage.mailingAddressComponent().fillCity(data.get("city"));
		tokenAccountPage.mailingAddressComponent().clickstate();
		
		Thread.sleep(500);
		tokenAccountPage.mailingAddressComponent().selectState(data.get("state"));

		tokenAccountPage.mailingAddressComponent().fillZipCode(data.get("zipCode"));
		tokenAccountPage.mailingAddressComponent().clickOutSide();
		tokenAccountPage.addNewSignetAccountPopup().clickSave();

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickWithdrawToSignet();
			Thread.sleep(2000);
			if (tokenAccountPage.noSignetAccountsExistPopup().getLabelsize() > 0) {
				Thread.sleep(2000);
				addSignet(strParams);
			} else {
				Thread.sleep(1000);
				testWithdrawToSignetAccount(strParams);

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	public void testWithdrawToSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			System.out.println("--------------------------------------");
			// tokenAccountPage.clickWithdrawToSignet();
			tokenAccountPage.withdrawToSignetPopup().verifyPageHeading();
			tokenAccountPage.withdrawToSignetPopup().fillAmount(data.get("amount"));
			
			tokenAccountPage.withdrawToSignetPopup().getAvailableBalance();
			tokenAccountPage.withdrawToSignetPopup().fillMessage(data.get("description"));
			int lblError = tokenAccountPage.withdrawToSignetPopup().lblError();
			if (lblError > 0) {
				ExtentTestManager.setInfoMessageInReport("Don't have amount in Total withdraw");
			} else {

				
				tokenAccountPage.withdrawToSignetPopup().clickNext();
				tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup()
						.verifyPageHeading(data.get("withdrawToSignetPreviewHeading"));
				tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().verifyAmount();
				tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getWithdrawAmount();
				tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getProcessingFee();
				tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getTotal();
				tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().clickConfirm();
				// tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent().verifyPageHeading(data.get("authyHeading1"));
				tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent()
						.fillInput(data.get("code"));
				tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent()
						.successFailureComponent();
				Thread.sleep(2000);
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRemoveSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickWithdrawToSignet();
			tokenAccountPage.withdrawToSignetPopup().verifyPageHeading();
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

	@Test
	@Parameters({ "strParams" })
	public void testAddSignetAccountInvalidDataValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickWithdrawToSignet();
			addSignet(strParams);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddSignetAccountInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickWithdrawToSignet();
			tokenAccountPage.withdrawToSignetPopup().verifyPageHeading();
			tokenAccountPage.withdrawToSignetPopup().fillAmount(data.get("amount"));
			tokenAccountPage.withdrawToSignetPopup().getAvailableBalance();
			tokenAccountPage.withdrawToSignetPopup().fillMessage(data.get("description"));
			tokenAccountPage.withdrawToSignetPopup().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarComponent().clickCoyniPortal();
//			homePage.sideBarComponent().clickCommissionAccount();
			homePage.sideBarComponent().commissionAccountPage().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnToday();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnYesterday();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnLast7Days();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnMonthToDate();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnLastMonth();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCommissionAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionAccountPayOut(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickCommissionAccount();
			homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().fillSearch(data.get("search"));
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().clickPayOut();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getPayOutDate();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getPayOutAmount();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getTransactionReference();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getToTokenAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCommissionAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedPayOutToday(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Today");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedPayOutYesterday(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Yesterday");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedpayOutLastSevenDays(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Last Seven Days");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedPayOutLastMonth(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Last Month");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedPayOutMonthToDate(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Month to Date");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionAccountTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickCommissionAccount();
			homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().tokenAccountPage().transactionPage()
					.verifyTransactionHeading(data.get("heading"));
			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
					.verifyTableItemsCount(data.get("query"));
			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
					.verifyPageNumbersWithCount();
//			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
//					.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
			homePage.sideBarComponent().tokenAccountPage().transactionPage().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport("Entries is displayed as "
					+ homePage.sideBarComponent().tokenAccountPage().transactionPage().getEntriesMessage());
			homePage.sideBarComponent().tokenAccountPage().transactionPage().clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountTransactionList Failed due to Exception " + e);
		}
	}

	public void testCommissionAccountFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniPortal();
			homePage.sideBarComponent().clickCommissionAccount();
			homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().viewFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().selectFilter(data.get("filterType"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("amount"));
			// homePage.sideBarComponent().tokenAccountPage().filterComponent().selectType(data.get("referenceID"));
			// homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyEmployeeName(data.get("empName"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionResetFilters(String strParams) {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		testResetFilters(strParams);

	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionToday(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Today");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionYesterday(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Yesterday");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionLastSevenDays(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Last Seven Days");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionLastMonth(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Last Month");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionMonthToDate(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCoyniPortal();
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Month to Date");
	}

	@Test
	@Parameters({ "strParams" })
	public void testVerifyPayoutTransactionHistory(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		// homePage.sideBarComponent().clickTokenAccount();
		// homePage.sideBarComponent().commissionAccountPage().verifyHeading(data.get("heading"));
		homePage.sideBarComponent().commissionAccountPage().verifyTransactionList();

	}

}
