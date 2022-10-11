package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.BatchPayOutComponent;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import coyni_mobile_merchant.pages.LandingPage;
import coyni_mobile_merchant.pages.LoginPage;
import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class DashBoardTest {

	MerchantProfilePage merchantProfilePage;
	BusinessTokenAccountPage businessTokenAccountPage;
	BatchPayOutComponent batchPayOutComponent;
	EnterYourPINComponent enterYourPINComponent;
	NavigationComponent navigationComponent;
	LoginPage loginPage;
	LandingPage landingPage;
	MerchantMenuIconTest merchantMenuIconTest;

	@BeforeTest
	public void init() {
		merchantMenuIconTest = new MerchantMenuIconTest();
		merchantProfilePage = new MerchantProfilePage();
		businessTokenAccountPage = new BusinessTokenAccountPage();
		navigationComponent = new NavigationComponent();
		batchPayOutComponent = new BatchPayOutComponent();
		loginPage = new LoginPage();
		landingPage = new LandingPage();

		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@AfterTest
	public void hideKeyBoard() {
		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBottomMenuBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageHeading(data.get("tokenAccountHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageDescription(data.get("tokenAccountDescription"));
			businessTokenAccountPage.clickProfile();
			businessTokenAccountPage.merchantProfilePage().getAccountDetails();
			businessTokenAccountPage.merchantProfilePage().getAccountId();
			businessTokenAccountPage.merchantProfilePage().clickBack();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickTransactions();
			Thread.sleep(2000);
			businessTokenAccountPage.merchantTransactionsPage().verifyLabelMerchanTransactions(data.get("merchantHeading"));
			businessTokenAccountPage.merchantTransactionsPage().clickClose();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickDashBoard();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().viewScan();
			businessTokenAccountPage.tokenMenuIconPopUp().viewReceivePayment();
			businessTokenAccountPage.tokenMenuIconPopUp().viewBuyTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().viewWithdrawTokens();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBottomMenuBarView  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantBalance(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			businessTokenAccountPage.clickDashBoard();
			businessTokenAccountPage.dashBoardPage().verifyLabelMerchantBalance(data.get("label"));
			businessTokenAccountPage.dashBoardPage().getDashBoardDescription();
			businessTokenAccountPage.dashBoardPage().getMerchantBalance();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantBalance Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProcessingVolume(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.dashBoardPage().verifyLabelProcessingVolume(data.get("label"));
			businessTokenAccountPage.daysDropDownComponent().clickOnToday();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.dashBoardPage().getSaleOrder();
			businessTokenAccountPage.daysDropDownComponent().clickOnYesterday();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.dashBoardPage().getSaleOrder();
			businessTokenAccountPage.daysDropDownComponent().clickOnMonthToDate();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.daysDropDownComponent().clickOnLastMonth();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.dashBoardPage().getHighTicket();
			businessTokenAccountPage.dashBoardPage().getAverageTicket();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProcessingVolume Failed due to this Exception" + e);
		}
	}

	

	@Test
	@Parameters({ "strParams" })
	public void testMerchantTransactionsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickTransactions();
			businessTokenAccountPage.merchantTransactionsPage().verifyLabelMerchanTransactions(data.get("merchantHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().scrollToNoMoreTransactions();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyNoMoreTransactions(data.get("noMoreTransactions"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testMerchantTransactionsList Failed due to this Exception" + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testMerchantTransactionsWithOneFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.dashBoardPage().clickMerchantTransactions();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage()
					.verifyLabelMerchanTransactions(data.get("merchantHeading"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().clickFilterIcon();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterType"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.fillFromMerchantAmount(data.get("fromAmount"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.fillToMerchantAmount(data.get("toAmount"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().datePickerComponent()
					.clickCalendar();
			Thread.sleep(1000);
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().datePickerComponent()
					.selectFromDate(data.get("fromDate"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().datePickerComponent()
					.selectToDate(data.get("toDate"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().datePickerComponent()
					.clickDone();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().clickApplyfilters();
			Thread.sleep(2000);
			if (businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().verifyTransactionsCount() == 0) {
				businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().clickMerchantTransctions();
				businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
						.verifyMerchantDetails(data.get("merchantTransDetails"));
				businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
						.getTransactionType();
				businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
						.getTransactionAmount();

				if (data.get("filterType").equalsIgnoreCase("TransactionTypeRefund")) {
					businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
							.getRefundSentDetails();

				} else if (data.get("filterType").equalsIgnoreCase("Merchant Payout")) {
					businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
							.getMerchantPayoutDetails();
				} else if (data.get("filterType").equalsIgnoreCase("Monthly Service Fee")) {
					businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
							.getMonthlyServiceFee();
				}
			} else {
				ExtentTestManager.setInfoMessageInReport("You Have No Transactions");
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testMerchantTransactionsWithOneFilter Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantTransactionsWithTwoFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.dashBoardPage().clickMerchantTransactions();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage()
					.verifyLabelMerchanTransactions(data.get("merchantHeading"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().clickFilterIcon();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterType"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterType1"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.fillFromMerchantAmount(data.get("fromAmount"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.fillToMerchantAmount(data.get("toAmount"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().datePickerComponent()
					.clickCalendar();
			Thread.sleep(1000);
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().datePickerComponent()
					.selectFromDate(data.get("fromDate"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().datePickerComponent()
					.selectToDate(data.get("toDate"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().datePickerComponent()
					.clickDone();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().clickApplyfilters();

			if (businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().verifyTransactionsCount() == 0) {
				businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().clickMerchantTransctions();
				businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
						.verifyMerchantDetails(data.get("merchantTransDetails"));
				businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
						.getTransactionType();

				if (data.get("filterType").equalsIgnoreCase("Sale Order - Token")
						&& data.get("filterType1").equalsIgnoreCase("Completed")) {
					businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
							.getSaleOrderTokenDetails();
					testRefund(strParams);

				} else if (data.get("filterType").equalsIgnoreCase("Sale Order - Token")
						&& data.get("filterType1").equalsIgnoreCase("Partial Refund")) {
					businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
							.getSaleOrderTokenDetails();
					testRefund(strParams);

				} else if (data.get("filterType").equalsIgnoreCase("Sale Order - Token")
						&& data.get("filterType1").equalsIgnoreCase("TransactionStatusRefund")) {
					businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().merchantTransactionDetailsPage()
							.getSaleOrderTokenDetails();
				}
			} else {
				ExtentTestManager.setInfoMessageInReport("You Have No Transactions");
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testMerchantTransactionsWithTwoFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetFiltersForMerchantTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.dashBoardPage().clickMerchantTransactions();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage()
					.verifyLabelMerchanTransactions(data.get("label"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.verifyTransactionType(data.get("label"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().clickFilterIcon();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterTransactiontype"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterTransactionStatus"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.fillFromAmount(data.get("fromAmount"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.fillToAmount(data.get("toAmount"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup().clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testResetFiltersForMerchantTransactions Failed due to this Exception" + e);
		}
	}

	public void testRefund(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.merchantTransactionDetailsPage().clickRefund();
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
					.verifyHeading(data.get("refundHeading"));
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().getTransactionAmount();
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().clickReason();
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
					.fillReason(data.get("reason"));
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().clickCancel();
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().clickReason();
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
					.fillReason(data.get("reason"));
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().clickDone();

			if (data.get("validateRefund").equalsIgnoreCase("yes")) {
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().clickFullAmount();
			} else if (data.get("validateRefund").equalsIgnoreCase("no")) {
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().clickHalfAmount();
			} else {
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
						.fillAmount(data.get("refundAmount"));
			}
			businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().clickRefund();

			if (businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
					.verifyBuyTokenInsufficientFundsDsecription() == 1) {

				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
						.verifyInsufficientFundsHeading(data.get("insufficientfundsHeading"));
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
						.verifyBuyTokenInsufficientFundsDescription(data.get("buyTokenInsufficientfundsDescription"));
				merchantMenuIconTest.testBuyTokenBankAccount(strParams);

			} else if (businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
					.verifyBusinessAccountInsufficientFundsDescription() == 1) {

				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
						.verifyInsufficientFundsHeading(data.get("insufficientfundsHeading"));
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
						.VerifyBusinessAccountInsufficientFundsDescription(
								data.get("businessAccountInsufficientFundsDescription"));
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage()
						.clickBusinessAccount();
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().orderPreviewPopup()
						.refundPreviewDetails(data.get("orderHeading"));
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().orderPreviewPopup()
						.enterYourPINComponent().fillPin(data.get("pin"));
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().orderPreviewPopup()
						.transactionSucessFailurePendingComponent().getRefundTokenTransactionStatusDetails();
			} else {
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().orderPreviewPopup()
						.refundPreviewDetails(data.get("orderHeading"));
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().orderPreviewPopup()
						.enterYourPINComponent().fillPin(data.get("pin"));
				businessTokenAccountPage.merchantTransactionDetailsPage().refundTransactionPage().orderPreviewPopup()
						.transactionSucessFailurePendingComponent().getRefundTokenTransactionStatusDetails();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRefund Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayOuts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			if (businessTokenAccountPage.batchPayOutComponent().verifyTransactionAmount() > 0.00) {
				businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
				businessTokenAccountPage.batchPayOutComponent().verifyHeading(data.get("batchHeading"));
				businessTokenAccountPage.batchPayOutComponent().getBatchPayoutAmount();
				businessTokenAccountPage.batchPayOutComponent().getBatchPayoutSentto();
				businessTokenAccountPage.batchPayOutComponent().slideToConfirm();
				businessTokenAccountPage.batchPayOutComponent().enterYourPINComponent().fillPin(data.get("pin"));
				businessTokenAccountPage.batchPayOutComponent().enterYourPINComponent().toastComponent()
						.verifyToastMsg(data.get("batchToastMsg"));
				Thread.sleep(2000);
				businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
				businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
						.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
				businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().clickPayoutTransaction();
				businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().payoutTransactionDetailsPage()
						.verifyPageHeading(data.get("payoutHeading"));
				businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().payoutTransactionDetailsPage()
						.getPayoutTransactionAllDetails();
			} else {
				ExtentTestManager.setInfoMessageInReport("We don't have any amount to do for Batch Now");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayOuts Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayOutApplyFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().clickFilterIcon();
			Thread.sleep(1000);
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().datePickerComponent()
					.clickCalendar();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().datePickerComponent()
					.selectFromDate(data.get("fromDate"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().datePickerComponent()
					.selectToDate(data.get("toDate"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().datePickerComponent()
					.clickDone();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().clickApplyfilters();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().clickPayoutTransaction();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().payoutTransactionDetailsPage()
					.verifyPageHeading(data.get("payoutHeading"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().payoutTransactionDetailsPage()
					.getPayoutTransactionAllDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayOutApplyFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayOutResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().clickFilterIcon();
			Thread.sleep(1000);
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().datePickerComponent()
					.clickCalendar();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().datePickerComponent()
					.selectFromDate(data.get("fromDate"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().datePickerComponent()
					.selectToDate(data.get("toDate"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup().datePickerComponent()
					.clickDone();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().filterPopup()
					.clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayOutResetFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayoutsSearchField(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().clickPayoutTransaction();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().payoutTransactionDetailsPage()
					.verifyPageHeading(data.get("payoutHeading"));
			String a = businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().getPayoutID();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().payoutTransactionDetailsPage()
					.clickBack();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().fillSearchField(a);
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().clickPayoutTransaction();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().payoutTransactionDetailsPage()
					.verifyPageHeading(data.get("payoutHeading"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().payoutTransactionDetailsPage()
					.getPayoutTransactionAllDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayoutsSearchField Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayoutsScrollMethod(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage().scrollToNoMoreTransactions(data.get("noMoreTransactions"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayoutsScrollMethod Failed due to this Exception" + e);
		}
	}

	
	@Test
	@Parameters({ "strParams" })
	public void testReserveBalance(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().getReserveRule();
			businessTokenAccountPage.reserveBalanceComponent().getNextRelease();
			businessTokenAccountPage.reserveBalanceComponent().getLastRelease();
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickDrpDwn();
			if (data.get("validate").equalsIgnoreCase("yes")) {
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickManual();
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
						.verifyReleaseType(data.get("releaseType"));
			} else {
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickManual();
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickDrpDwn();
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickRolling();
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
						.verifyReleaseType(data.get("releaseType"));

			}

			if (businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyTransactionsCount() == 0) {
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().getTranHeading();
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().getStatus();
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().getAmount();
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().getDate();
			} else {
				ExtentTestManager.setInfoMessageInReport("You Have No Transactions");
			}
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().ClickClose();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.getUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveBalance Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveBalanceFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.clickFilterIcon();
			Thread.sleep(1000);
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.selectFilter(data.get("filterType"));
			Thread.sleep(1000);
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.datePickerComponent().clickCalendar();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.datePickerComponent().selectFromDate(data.get("fromDate"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.datePickerComponent().selectToDate(data.get("toDate"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.datePickerComponent().clickDone();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.clickApplyfilters();
			if (businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyTransactionsCount() == 0) {

				if (data.get("filterType").equalsIgnoreCase("Open")) {
					businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
							.getFailedorOpenTransactionDetails();

				} else if (data.get("filterType").equalsIgnoreCase("Released")) {
					businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickReserve();
					businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
							.reserveReleaseDetailsPage().verifyReserveDetail(data.get("reserveDetail"));
					businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
							.reserveReleaseDetailsPage().getReserveReleasedDetails();

				} else if (data.get("filterType").equalsIgnoreCase("On Hold")) {

					businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickReserve();
					businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
							.reserveReleaseDetailsPage().verifyReserveDetail(data.get("reserveDetail"));
					businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
							.reserveReleaseDetailsPage().getReserveOnHoldDetails();

				} else if (data.get("filterType").equalsIgnoreCase("Canceled")) {

				} else if (data.get("filterType").equalsIgnoreCase("Failed")) {
					businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
							.getFailedorOpenTransactionDetails();
				}
				businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
						.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));

			} else {
				ExtentTestManager.setInfoMessageInReport("You Have No Transactions");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveBalanceFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveBalanceResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.clickFilterIcon();
			Thread.sleep(1000);
			String[] filterType = data.get("filterType").split(",");
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.validateReserveBalanceFilters(filterType[0], filterType[1], filterType[2], filterType[3],
							filterType[4]);
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.datePickerComponent().clickCalendar();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.datePickerComponent().selectFromDate(data.get("fromDate"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.datePickerComponent().selectToDate(data.get("toDate"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.datePickerComponent().clickDone();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveBalanceResetFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveReleasesSearchField(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickTransaction();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().verifyReserveDetail(data.get("reserveDetail"));
			String a = businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.getReserveID();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().clickBack();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().fillSearchOption(a);
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickReserve();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().verifyReserveDetail(data.get("reserveDetail"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().getReserveOnHoldDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveReleasesSearchField Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveReleasesScroll(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
			.verifyNoMoreTransaction(data.get("noMoreTransactions"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveReleasesScroll Failed due to this Exception" + e);
		}
	}

	
	@Test
	public void testNotifications() {
		try {
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().viewNotification();
			businessTokenAccountPage.notificationComponent().countNotifications();
			businessTokenAccountPage.notificationComponent().viewDots();
			businessTokenAccountPage.notificationComponent().navigationComponent().clickBack();
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().viewRequest();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().navigationComponent().clickBack();
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().swipeNotificationLeft();
			businessTokenAccountPage.notificationComponent().clickRead();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotifications faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginwithNewAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(data.get("email1"));
			loginPage.fillPassword(data.get("password1"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(data.get("pin1"));
			Thread.sleep(2000);
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginwithNewAccount failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().viewPay();
			businessTokenAccountPage.notificationComponent().clickPay();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup()
					.verifyHeading(data.get("heading"));
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyAmount();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyPreview();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyLockSwipe();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifySlideText();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().swipeConfirm();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.clickForgotPin();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().forgotPinComponent()
					.navigationComponent().clickBack();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationPay faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().viewDeny();
			businessTokenAccountPage.notificationComponent().viewPay();
			businessTokenAccountPage.notificationComponent().clickDeny();
			businessTokenAccountPage.notificationComponent().verifyDenyMessage(data.get("denyMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationDeny faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestReminder(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().clickRemainder();
			businessTokenAccountPage.notificationComponent().verifyReminderMessage(data.get("reminderMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestReminder faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestCancel(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().clickCancel();
			businessTokenAccountPage.notificationComponent().verifyCancelMessage(data.get("cancelMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestCancel faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().clickPay();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup()
					.verifyHeading(data.get("heading"));
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyAmount();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyPreview();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyLockSwipe();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifySlideText();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().swipeConfirm();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.clickForgotPin();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().forgotPinComponent()
					.navigationComponent().clickBack();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestPay faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().clickDeny();
			businessTokenAccountPage.notificationComponent().verifyDenyMessage(data.get("denyMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestDeny faield due to exception " + e);
		}

	}

	@Test
	public void testNotificationsDelete() {
		try {
			businessTokenAccountPage.clickNotifications();
			Thread.sleep(2000);
			businessTokenAccountPage.notificationComponent().viewDots();
			businessTokenAccountPage.notificationComponent().swipeNotificationRight();
			businessTokenAccountPage.notificationComponent().clickDelete();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationsDelete is failed due to Exception " + e);
		}

	}

}
