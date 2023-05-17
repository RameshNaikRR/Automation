package coyni.merchant.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.admin.components.SideBarComponent;
import coyni.merchant.components.MerchantActivityComponent;
import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.components.TopBarComponent;
import coyni.merchant.components.TransactionDetailsComponent;
import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.GetHelpPage;
import coyni.merchant.pages.LoginPage;
import coyni.merchant.pages.MerchantSettingsPage;
import coyni.merchant.pages.MerchantTransactionsPage;
import coyni.merchant.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantActivityTest {
	LoginPage loginPage;
	SideMenuBarComponent sideMenuBarComponent;
	MerchantActivityComponent merchantActivityComponent;
	MerchantTransactionsPage merchantTransactionsPage;
	TokenAccountPage tokenAccountPage;
	TopBarComponent topBarComponent;
	ExportfilesPage exportfilesPage;
	MerchantSettingsPage merchantSettingsPage;
	GetHelpPage getHelpPage;
	SideBarComponent adminSideBarComponent;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		sideMenuBarComponent = new SideMenuBarComponent();
		merchantActivityComponent = new MerchantActivityComponent();
		merchantTransactionsPage = new MerchantTransactionsPage();
		topBarComponent = new TopBarComponent();
		tokenAccountPage = new TokenAccountPage();
		exportfilesPage = new ExportfilesPage();
		merchantSettingsPage = new MerchantSettingsPage();
		getHelpPage = new GetHelpPage();
		merchantActivityComponent = new MerchantActivityComponent();
		sideMenuBarComponent = new SideMenuBarComponent();
		adminSideBarComponent = new SideBarComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantActivityLinks(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			merchantActivityComponent.clickTransactions();
			merchantActivityComponent.transactionPage().verifyTransactionHeading(data.get("transactionHeading"));
			merchantActivityComponent.clickPayOutHistory();
			merchantActivityComponent.payOutHistoryPage().verifyHeading(data.get("payOutHistoryHeading"));
			merchantActivityComponent.clickReserveHistory();
			merchantActivityComponent.reserveHistoryPage().verifyHeading(data.get("reserveHistoryHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testMerchantActivityLinks failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantActivityAfterApproved(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			new CommonFunctions().switchtoUrl(data.get("url"));
			merchantActivityComponent.verifyApprovedHeading();
			merchantActivityComponent.clickMerchantDashBoad();
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("merchantDashBoardheading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testMerchantActivityLinks failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantActivityAcceptResrve(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			if (loginPage.verifyPriacyPolicyHeading() == 1) {
				loginPage.scrollToPrivacyAgree();
				loginPage.clickDone();
			}

			else {
				loginPage.verifyWelcomeHeading();
			}
			Thread.sleep(1000);
			if (loginPage.verifyTermsOfServicesHeading() == 1) {
				loginPage.scrollToTermsAgree();
				loginPage.clickDone();
			}
			merchantActivityComponent.verifyApprovedReserveHeading();
			merchantActivityComponent.verifyMonthlyProcessingVolume(data.get("monthlyProcessingVolume"));
			merchantActivityComponent.verifyHighTicket(data.get("highTicket"));
			merchantActivityComponent.verifyResrverAmount(data.get("reserveAmount"));
			merchantActivityComponent.verifyResrverPeriod(data.get("reservePeriod"));
			merchantActivityComponent.clickAcceptReserve();
			merchantActivityComponent.clickMerchantDashBoad();
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("merchantDashBoardheading"));

			merchantActivityComponent.clickUserName();
			merchantActivityComponent.clickUserDetails();
			merchantActivityComponent.verifyStatus();

			/*
			 * String merchID =merchantActivityComponent.verifyMerchantIDForReserver();
			 * 
			 * new CommonFunctions().switchtoUrl(data.get("urlAdmin"));
			 * //merchantActivityComponent.homePage().sideBarComponent().
			 * clickReserveManagement();
			 * //merchantActivityComponent.homePage().sideBarComponent().
			 * reserveManagementPage().clickActive(); Thread.sleep(2000);
			 * 
			 * 
			 * merchantActivityComponent.homePage().sideBarComponent().reserveManagementPage
			 * ().fillSearch(merchID);
			 * merchantActivityComponent.homePage().sideBarComponent().reserveManagementPage
			 * ().clickSearchButton();
			 * 
			 * //merchantActivityComponent.homePage().sideBarComponent().
			 * reserveManagementPage().verifyStatus();
			 * merchantActivityComponent.homePage().sideBarComponent().clickProfiles();
			 * merchantActivityComponent.homePage().sideBarComponent().clickMerchant();
			 * merchantActivityComponent.homePage().sideBarComponent().profileComponent().
			 * fillSearch(merchID);
			 * 
			 * merchantActivityComponent.homePage().sideBarComponent().profileComponent().
			 * verifyMerchantStatus();
			 */
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testMerchantActivityAcceptResrve failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDashBoardProcessingVolume(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnToday();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnYesterday();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnLast7Days();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnMonthToDate();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnLastMonth();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
			merchantActivityComponent.dashBoardPage().getAccountBalance();
			merchantActivityComponent.dashBoardPage().getBatchPayOuts();
			merchantActivityComponent.dashBoardPage().getNextPayOut();
			merchantActivityComponent.dashBoardPage().getLastPayOut();
			// merchantActivityComponent.dashBoardPage().clickFullPayOutHistory();
//			merchantActivityComponent.clickDashBoard();
//			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
//			// merchantActivityComponent.dashBoardPage().clickFullTransactionHistory();
//			merchantActivityComponent.clickDashBoard();
//			//merchantActivityComponent.dashBoardPage().clickFullReserveReleaseHistory();
//			merchantActivityComponent.clickDashBoard();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testDashBoardProcessingVolume failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			merchantTransactionsPage.verifyTableItemsCount(data.get("query"));
			merchantTransactionsPage.verifyPageNumbersWithCount();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + merchantTransactionsPage.getDefaultEntriesPerPage());
			merchantTransactionsPage.clickDropDownEntriesPage();
			merchantTransactionsPage.verifyEntriesMessage();
			ExtentTestManager
					.setInfoMessageInReport("Entries is displayed as " + merchantTransactionsPage.getEntriesMessage());
			merchantTransactionsPage.clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testTransactionList failed due to exception " + e);
		}
	}

	public void testExportSelectedTransactions(String strParams, String strParams1) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			merchantTransactionsPage.clickExport();
			if (strParams1.equalsIgnoreCase("Today")) {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnToday();
			} else if (strParams1.equalsIgnoreCase("Yesterday")) {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnYesterday();

			} else if (strParams1.equalsIgnoreCase("Last Seven Days")) {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOn7Days();
			} else if (strParams1.equalsIgnoreCase("Last Month")) {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnLastMonth();
			} else {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickMonthTODate();
			}
			Thread.sleep(2000);
			merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnExport();
			merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup()
					.verifyTitle(data.get("heading"));
			Thread.sleep(2000);
			merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickExportPage();
			merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionToday(String strParams) {
		testExportSelectedTransactions(strParams, "Today");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionYesterday(String strParams) {
		testExportSelectedTransactions(strParams, "Yesterday");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastSevenDays(String strParams) {
		testExportSelectedTransactions(strParams, "Last Seven Days");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastMonth(String strParams) {
		testExportSelectedTransactions(strParams, "Last Month");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionMonthToDate(String strParams) {
		testExportSelectedTransactions(strParams, "Month to Date");
	}

	@Test
	@Parameters({ "strParams" })
	public void testFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			if (merchantTransactionsPage.filterComponent().verifyTransactionss() > 0) {
				merchantTransactionsPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				merchantTransactionsPage.filterComponent().verifyMouseAction();
				merchantTransactionsPage.filterComponent().clickFilters();
				// merchantTransactionsPage.filterComponent().datePickerComponent().setDate(data.get("startdate"));
				// merchantTransactionsPage.filterComponent().datePickerComponent().setDate(data.get("enddate"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType3"));
				if (!data.get("errMessage").isEmpty()) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
				}

				merchantTransactionsPage.filterComponent().clickApplyFilters();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFilters Failed due to Exception " + e);
		}
	}

	public void testFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			if (merchantTransactionsPage.filterComponent().verifyTransactionss() > 0) {
				merchantTransactionsPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				merchantTransactionsPage.filterComponent().verifyMouseAction();
				merchantTransactionsPage.filterComponent().clickFilters();
				// merchantTransactionsPage.filterComponent().datePickerComponent().setDate(data.get("startdate"));
				// merchantTransactionsPage.filterComponent().datePickerComponent().setDate(data.get("enddate"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType"));
				// merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType3"));
				merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
				merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType2"));
				merchantTransactionsPage.filterComponent().fillSender(data.get("senderName"));
				merchantTransactionsPage.filterComponent().clickApplyFilters();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListFilters(String strParams) {
		// testFilters(strParams);
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
			Thread.sleep(3000);
//			int filterData = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query1"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
			// int filterData1 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData1 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query1"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData2 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData2 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query1"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData3 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData3 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query1"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData4 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData4 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query2"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
			// int filterData5 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData5 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query2"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData6 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData6 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query3"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData7 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData7 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query3"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData8 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData8 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query3"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData9 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData9 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query4"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData10 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData10 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query4"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData11 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData11 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query4"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData12 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData12 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query5"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData13 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData13 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query5"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();
//			int filterData14 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData14 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query5"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickApplyFilters();

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();

			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().clickResetAllFilters();
			merchantTransactionsPage.filterComponent().clickOnDate();
			Thread.sleep(2000);
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickApplyFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFilters Failed due to Exception " + e);
		}

	}

	public void testResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			if (merchantTransactionsPage.filterComponent().verifyTransactionss() > 0) {
				merchantTransactionsPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				merchantTransactionsPage.filterComponent().clickFilters();
				merchantTransactionsPage.filterComponent().filterCalenderComponent().clickPreviousTenDays();
				merchantTransactionsPage.filterComponent().filterCalenderComponent().clickStartDate();
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType"));
				merchantTransactionsPage.filterComponent().clickClearAllTransactionType();
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType"));
				merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
				merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
				merchantTransactionsPage.filterComponent().clickClearTransactionAmount();
				merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
				merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
				merchantTransactionsPage.filterComponent().fillSender(data.get("senderName"));
				merchantTransactionsPage.filterComponent().clickClearSenderName();
				merchantTransactionsPage.filterComponent().fillSender(data.get("senderName"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType2"));
				merchantTransactionsPage.filterComponent().fillSender(data.get("senderName"));
				merchantTransactionsPage.filterComponent().clickClearSenderName();
				merchantTransactionsPage.filterComponent().clickResetAllFilters();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testResetFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListResetFilters(String strParams) {
		// testResetFilters(strParams);
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query1"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

//			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
			// int filterData1 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData1 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query1"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData2 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData2 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query1"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

//			merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData3 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData3 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query1"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData4 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData4 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query2"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
			// int filterData5 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData5 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query2"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData6 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData6 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query3"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData7 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData7 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query3"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnMerchantPayOut();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData8 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData8 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query3"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData9 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData9 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query4"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}

			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData10 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData10 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query4"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnMonthlyServiceFee();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData11 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData11 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query4"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
//			merchantTransactionsPage.filterComponent().clickOnClearAllTxnSubType();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData12 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData12 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query5"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
//			merchantTransactionsPage.filterComponent().clickOnClearAllTxnSubType();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();

			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
//			merchantTransactionsPage.filterComponent().clickOnClearAllTxnSubType();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderEmobile();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();

			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
//			merchantTransactionsPage.filterComponent().clickOnClearAllTxnSubType();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().ClickOnCompleted();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData13 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData13 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query5"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
//			merchantTransactionsPage.filterComponent().clickOnClearAllTxnSubType();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();
//			int filterData14 = merchantTransactionsPage.filterComponent().noFilterData();
//			if (filterData14 == 0) {
//				merchantTransactionsPage.filterComponent().getTotalCount(data.get("query5"));
//
//			} else {
//				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
//			}
			// merchantTransactionsPage.filterComponent().clickFilters();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setPrevious10Date();
			merchantTransactionsPage.filterComponent().filterCalenderComponent().setDate();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
			merchantTransactionsPage.filterComponent().clickOnClearAll();
			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
//			merchantTransactionsPage.filterComponent().clickOnClearAllTxnSubType();
			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().clickOnClearTxnAmount();
			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().clickOnClearSender();
			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnClearReceiver();
			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickOnClearAllTxnStatus();
			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
			merchantTransactionsPage.filterComponent().clickResetFilters();

			// merchantTransactionsPage.filterComponent().clickFilters();
//			merchantTransactionsPage.filterComponent().filterCalenderComponent().clickSelectDate(data.get("startDate"));
//			merchantTransactionsPage.filterComponent().filterCalenderComponent().clickSelectDate(data.get("endDate"));
//			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
//			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
//			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
//			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
//			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
//			merchantTransactionsPage.filterComponent().ClickOnCompleted();
//			merchantTransactionsPage.filterComponent().clickResetFilters();
//
//			// merchantTransactionsPage.filterComponent().clickFilters();
////			merchantTransactionsPage.filterComponent().filterCalenderComponent().clickSelectDate(data.get("startDate"));
////			merchantTransactionsPage.filterComponent().filterCalenderComponent().clickSelectDate(data.get("endDate"));
//			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
//			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
//			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
//			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
//			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
//			merchantTransactionsPage.filterComponent().clickOnRefund();
//			merchantTransactionsPage.filterComponent().clickResetFilters();
//
//			// merchantTransactionsPage.filterComponent().clickFilters();
////			merchantTransactionsPage.filterComponent().filterCalenderComponent().clickSelectDate(data.get("startDate"));
////			merchantTransactionsPage.filterComponent().filterCalenderComponent().clickSelectDate(data.get("endDate"));
//			merchantTransactionsPage.filterComponent().clickOnSaleOrder();
//			merchantTransactionsPage.filterComponent().clickOnSaleOrderECommerce();
//			merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
//			merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
//			merchantTransactionsPage.filterComponent().fillSender(data.get("filterType1"));
//			merchantTransactionsPage.filterComponent().fillReceiver(data.get("filterType2"));
//			merchantTransactionsPage.filterComponent().clickOnPartialRefund();
//			merchantTransactionsPage.filterComponent().clickResetFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testResetFilters Failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testDashBoardPayOutHistory(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			merchantActivityComponent.clickPayOutHistory();
			// merchantActivityComponent.dashBoardPage().getPayOutHistoryRecentTransactions();
			// merchantActivityComponent.dashBoardPage().clickFullPayOutHistory();
			// merchantActivityComponent.payOutHistoryPage().verifyHeading(data.get("heading"));
			if (merchantActivityComponent.payOutHistoryPage().verifyPayOut() > 0) {
				merchantActivityComponent.payOutHistoryPage().verifyNoPayOutFound();
			} else {
				merchantActivityComponent.payOutHistoryPage().clickPayOut();
				merchantActivityComponent.payOutHistoryPage().payOutIDPage().getPayOutDate();
				merchantActivityComponent.payOutHistoryPage().payOutIDPage().getPayOutAmount();
				merchantActivityComponent.payOutHistoryPage().payOutIDPage().getToTokenAccount();
				merchantActivityComponent.payOutHistoryPage().payOutIDPage().getTransactionReference();
				merchantActivityComponent.payOutHistoryPage().payOutIDPage().verifyDownloadPDF();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDashBoardPayOutHistory failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDashBoardReserveHistoryNoRecords(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickReserveHistory();
			merchantActivityComponent.reserveHistoryPage().verifyHeading(data.get("heading"));
			merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();
			merchantActivityComponent.reserveHistoryPage().clickManual();
			merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();
			merchantActivityComponent.reserveHistoryPage().clickRolling();
			merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDashBoardReserveHistory failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDashBoardFullReserveHistory(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
			merchantActivityComponent.dashBoardPage().getReserveBalance();
			merchantActivityComponent.dashBoardPage().getReserveBalanceDescription();
			merchantActivityComponent.dashBoardPage().getNextRelease();
			merchantActivityComponent.dashBoardPage().getLastRelease();
			merchantActivityComponent.dashBoardPage().clickFullReserveReleaseHistory();
			merchantActivityComponent.reserveHistoryPage().clickOnHold();
			merchantActivityComponent.reserveHistoryPage().clickOpen();
			merchantActivityComponent.reserveHistoryPage().clickReleased();
			merchantActivityComponent.reserveHistoryPage().clickManual();
			merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDashBoardFullReserveHistory failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveHistoryExports(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickReserveHistory();
			merchantActivityComponent.reserveHistoryPage().verifyHeading(data.get("heading"));
			if (merchantActivityComponent.reserveHistoryPage().verifyExports() > 0) {
				merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();
			} else {
				merchantActivityComponent.reserveHistoryPage().exportfilesPage().clickReserveExport();
				merchantActivityComponent.reserveHistoryPage().exportfilesPage().exportSelectedTransactionsPopup()
						.clickOnExport();

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveHistoryexports failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveHistoryIDDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickReserveHistory();
			merchantActivityComponent.reserveHistoryPage().verifyHeading(data.get("heading"));
			if (merchantActivityComponent.reserveHistoryPage().verifyExports() > 0) {
				merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();
			} else {
				merchantActivityComponent.reserveHistoryPage().clickReserveHistory();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getDailyBatchIds();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getBatchDate();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getReserveRule();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getReleasedOn();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getReleasedTransactionID();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getToTokenAccount();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().verifyDownloadPDF();

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveHistoryIDDetails failed due to exception " + e);
		}
	}

	static String referenceID;
	static String processFee;
	static String netAmount;
	static String PercentageAmountOfResrve;
	static String grossAmount;

	@Test
	@Parameters({ "strParams" })
	public void testMerchantReserveandProcessAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			// sideMenuBarComponent.clickMerchantActivityDrpDwn();
			// Thread.sleep(2000);
			merchantActivityComponent.clickTransactions();
			merchantActivityComponent.clickFilter();
			merchantActivityComponent.clickeCommerceChcekBox();
			merchantActivityComponent.clickApplyFliters();
			merchantActivityComponent.transactionDetailsComponent().clickRecord();
			Thread.sleep(2000);
			grossAmount = merchantActivityComponent.transactionDetailsComponent().getGrossAmount();
			processFee = merchantActivityComponent.transactionDetailsComponent().getProcessingFee();

			String expPercentageAmountOfReserve = merchantActivityComponent.transactionDetailsComponent()
					.reservePercentage(data.get("reserveAmount"));
			PercentageAmountOfResrve = merchantActivityComponent.transactionDetailsComponent().getPercatageAmount();
			if (expPercentageAmountOfReserve.equals(PercentageAmountOfResrve)) {
				ExtentTestManager.setPassMessageInReport(
						"The Reserved Percentage Calculation amount of the total cart amount is "
								+ expPercentageAmountOfReserve + "Matched with"
								+ " The Reserved Percentage calaulation amount in the Merchant Transaction details  "
								+ PercentageAmountOfResrve);
			} else {
				ExtentTestManager.setInfoMessageInReport(
						"The Reserved Percentage Calculation amount of the total cart amount is "
								+ expPercentageAmountOfReserve + " not Matched with"
								+ " The Reserved Percentage calaulation amount in the Merchant Transaction details  "
								+ PercentageAmountOfResrve);
			}
			netAmount = merchantActivityComponent.transactionDetailsComponent().getNetAmount();

			merchantActivityComponent.transactionDetailsComponent().clickCopyReferenceID();
			Thread.sleep(2000);
			referenceID = merchantActivityComponent.transactionDetailsComponent().getCopyReferenceID();
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickFeesBtn();
			String eCommereceProcess = sideMenuBarComponent.merchantSettingsPage()
					.merchantSettingsSideBarMenuComponent().feesPage().geteCommerceProcessing();
			if (processFee.equals(eCommereceProcess)) {
				ExtentTestManager.setPassMessageInReport(
						"The Processing amount of the total cart amount is " + processFee + "Matched with"
								+ " The Processing amount in the Merchant Settings Fees  " + eCommereceProcess);
			} else {
				ExtentTestManager.setInfoMessageInReport(
						"The Processing amount of the total cart amount is " + processFee + "not Matched with"
								+ " The Processing amount in the Merchant Settings Fees  " + eCommereceProcess);
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAdminReserveAndCommisionAmountLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			new CommonFunctions().switchtoUrl(data.get("urlAdmin"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			Thread.sleep(1500);
			if (data.get("securityKey").equalsIgnoreCase("123456")) {
				loginPage.authyComponent().fillInput(data.get("securityKey"));
			} else {
				loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			}
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAdminReserveAndCommisionAmount(String strParams) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			adminSideBarComponent.clickTransactions();
			adminSideBarComponent.transactionPage().clickBusiness();

			adminSideBarComponent.transactionPage().fillSearch(referenceID);
			adminSideBarComponent.transactionPage().clickSearch();
			Thread.sleep(2000);
			adminSideBarComponent.transactionPage().transactionDetailsComponent().clickDetails();
			String actGrossAmount = adminSideBarComponent.transactionPage().transactionDetailsComponent()
					.getGrossAmount();
			if (grossAmount.equals(actGrossAmount)) {
				ExtentTestManager.setPassMessageInReport("The Gross Amount of the Merchant Portal " + grossAmount
						+ " is reflecelted and Matched with the Gross amount in the Admin Transaction Page  "
						+ actGrossAmount);
			} else {
				ExtentTestManager.setPassMessageInReport("The Gross Amount of the Merchant Portal " + grossAmount
						+ " is not reflecelted and not Matched with the Gross amount in the Admin Transaction Page  "
						+ actGrossAmount);
			}
			String actProcessingFee = adminSideBarComponent.transactionPage().transactionDetailsComponent()
					.getProcessingFee();
			if (processFee.equals(actProcessingFee)) {
				ExtentTestManager.setPassMessageInReport("The Processing Fees of the Merchant Portal " + processFee
						+ " is reflecelted and Matched with the Processing amount in the Admin Transaction Page  "
						+ actProcessingFee);
			} else {
				ExtentTestManager.setPassMessageInReport("The Processing Fees of the Merchant Portal " + processFee
						+ " is not reflecelted and not Matched with the Processing amount in the Admin Transaction Page  "
						+ actProcessingFee);
			}
			String actResrve = adminSideBarComponent.transactionPage().transactionDetailsComponent()
					.getPercatageAmount();
			if (PercentageAmountOfResrve.equals(actResrve)) {
				ExtentTestManager.setPassMessageInReport("The Reserve Percentage Amount of the Merchant Portal "
						+ PercentageAmountOfResrve
						+ " is reflecelted and Matched with the Reserve Percentage amount in the Admin Transaction Page  "
						+ actResrve);
			} else {
				ExtentTestManager.setPassMessageInReport("The Reserve Percentage Amount of the Merchant Portal "
						+ PercentageAmountOfResrve
						+ " is not reflecelted and not Matched with the Reserve Percentage amount in the Admin Transaction Page  "
						+ actResrve);
			}
			String actnetAmount = adminSideBarComponent.transactionPage().transactionDetailsComponent().getNetAmount();
			if (netAmount.equals(actnetAmount)) {
				ExtentTestManager.setPassMessageInReport("The Net Amount of the Merchant Portal " + netAmount
						+ " is reflecelted and Matched with the Net amount in the Admin Transaction Page  "
						+ actnetAmount);
			} else {
				ExtentTestManager.setPassMessageInReport("The Net Amount of the Merchant Portal " + netAmount
						+ " is not reflecelted and not Matched with the Net amount in the Admin Transaction Page  "
						+ actnetAmount);
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAdminReserveandProcessFeeCommisionAmount(String strParams) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			adminSideBarComponent.clickCoyniPortal();
			adminSideBarComponent.clickCommissionAccount();
			adminSideBarComponent.commissionAccountPage().clickFullTransactionHistory();
			Thread.sleep(2000);
			adminSideBarComponent.commissionAccountPage().transactionPage().filterComponent().clickFilters();
			adminSideBarComponent.commissionAccountPage().transactionPage().filterComponent()
					.fillReferenceID(referenceID);
			adminSideBarComponent.commissionAccountPage().transactionPage().filterComponent().clickApplyFilters();

			Thread.sleep(2000);
			adminSideBarComponent.transactionPage().transactionDetailsComponent().clickDetails();
			String actGrossAmount = adminSideBarComponent.transactionPage().transactionDetailsComponent()
					.getGrossAmount();
			if (grossAmount.equals(actGrossAmount)) {
				ExtentTestManager.setPassMessageInReport("The Gross Amount of the Merchant Portal " + grossAmount
						+ " is reflecelted and Matched with the Gross amount in the Admin Commisssion Page  "
						+ actGrossAmount);
			} else {
				ExtentTestManager.setPassMessageInReport("The Gross Amount of the Merchant Portal " + grossAmount
						+ " is not reflecelted and not Matched with the Gross amount in the Admin Commisssion Page  "
						+ actGrossAmount);
			}
			String actProcessingFee = adminSideBarComponent.transactionPage().transactionDetailsComponent()
					.getProcessingFee();
			if (processFee.equals(actProcessingFee)) {
				ExtentTestManager.setPassMessageInReport("The Processing Fees of the Merchant Portal " + processFee
						+ " is reflecelted and Matched with the Processing amount in the Admin Commisssion Page  "
						+ actProcessingFee);
			} else {
				ExtentTestManager.setPassMessageInReport("The Processing Fees of the Merchant Portal " + processFee
						+ " is not reflecelted and not Matched with the Processing amount in the Admin Commisssion Page  "
						+ actProcessingFee);
			}
			String actResrve = adminSideBarComponent.transactionPage().transactionDetailsComponent()
					.getPercatageAmount();
			if (PercentageAmountOfResrve.equals(actResrve)) {
				ExtentTestManager.setPassMessageInReport("The Reserve Percentage Amount of the Merchant Portal "
						+ PercentageAmountOfResrve
						+ " is reflecelted and Matched with the Reserve Percentage amount in the Admin Commisssion Page  "
						+ actResrve);
			} else {
				ExtentTestManager.setPassMessageInReport("The Reserve Percentage Amount of the Merchant Portal "
						+ PercentageAmountOfResrve
						+ " is not reflecelted and not Matched with the Reserve Percentage amount in the Admin Commisssion Page  "
						+ actResrve);
			}
			String actnetAmount = adminSideBarComponent.transactionPage().transactionDetailsComponent().getNetAmount();
			if (netAmount.equals(actnetAmount)) {
				ExtentTestManager.setPassMessageInReport("The Net Amount of the Merchant Portal " + netAmount
						+ " is reflecelted and Matched with the Net amount in the Admin Commisssion Page  "
						+ actnetAmount);
			} else {
				ExtentTestManager.setPassMessageInReport("The Net Amount of the Merchant Portal " + netAmount
						+ " is not reflecelted and not Matched with the Net amount in the Admin Commisssion Page  "
						+ actnetAmount);
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			if (merchantTransactionsPage.filterComponent().verifyTransactionss() > 0) {
				Thread.sleep(3000);
				merchantTransactionsPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				merchantTransactionsPage.filterComponent().clickFilters();
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType"));
				merchantActivityComponent.filterComponent().clickApplyFilters();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsFilters Failed due to Exception " + e);
		}
	}

	public void testRecords(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		Thread.sleep(3000);
		if (merchantActivityComponent.transactionDetailsComponent().verifyRecords() != 0) {
			merchantActivityComponent.transactionDetailsComponent().verifyNoRecordsFound();
		} else {
			// merchantActivityComponent.merchantTransactionsPage().verifyTransactionHeading(data.get("heading"));
			merchantActivityComponent.transactionDetailsComponent().clickRecord();
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsMerchantPayOut(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
			merchantActivityComponent.transactionDetailsComponent().getTransactionType();
			merchantActivityComponent.transactionDetailsComponent().getPayOutID();
//			merchantActivityComponent.transactionDetailsComponent().getReferenceID();
//			merchantActivityComponent.transactionDetailsComponent().getCreatedDate();
//			merchantActivityComponent.transactionDetailsComponent().getAmount();
//			merchantActivityComponent.transactionDetailsComponent().getTotalTransctions();
//			merchantActivityComponent.transactionDetailsComponent().getPayOutDate();
//			merchantActivityComponent.transactionDetailsComponent().getDepositTo();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionDetailsMerchantPayOut Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsSaleOrder(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
			merchantActivityComponent.transactionDetailsComponent().getCustomerName();
			merchantActivityComponent.transactionDetailsComponent().getCustomerEmail();
//			merchantActivityComponent.transactionDetailsComponent().getReferenceID();
//			merchantActivityComponent.transactionDetailsComponent().getCreatedDate();
//			merchantActivityComponent.transactionDetailsComponent().getAmount();
//			merchantActivityComponent.transactionDetailsComponent().getTotalTransctions();
//			merchantActivityComponent.transactionDetailsComponent().getPayOutDate();
//			merchantActivityComponent.transactionDetailsComponent().getDepositTo();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsSaleOrder Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsRefund(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
//			 testRecords(strParams);
//			merchantActivityComponent.transactionDetailsComponent().getTransactionType();
//			merchantActivityComponent.transactionDetailsComponent().getPayOutID();
//			merchantActivityComponent.transactionDetailsComponent().getReferenceID();
//			merchantActivityComponent.transactionDetailsComponent().getCreatedDate();
//			merchantActivityComponent.transactionDetailsComponent().getAmount();
//			merchantActivityComponent.transactionDetailsComponent().getTotalTransctions();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsRefund Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsMonthlyServiceFee(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
			// merchantActivityComponent.transactionDetailsComponent().getTransactionType();
//			merchantActivityComponent.transactionDetailsComponent().getReferenceID();
//			merchantActivityComponent.transactionDetailsComponent().getCreatedDate();
//			merchantActivityComponent.transactionDetailsComponent().getAmount();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionDetailsMonthlyServiceFee Failed due to Exception " + e);
		}
	}

}
