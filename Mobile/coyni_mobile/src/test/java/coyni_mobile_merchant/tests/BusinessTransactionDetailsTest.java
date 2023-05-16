package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.BusinessRecentTokenTransactionsPage;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import coyni_mobile_merchant.pages.MerchantProfilePage;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class BusinessTransactionDetailsTest {
	BusinessRecentTokenTransactionsPage businessRecentTokenTransactionsPage;
	BusinessTokenAccountPage businessTokenAccountPage;
	MerchantProfilePage merchantProfilePage;
	OrderPreviewPopup orderPreviewPopup;

	@BeforeTest
	public void init() {
		merchantProfilePage = new MerchantProfilePage();
		businessRecentTokenTransactionsPage = new BusinessRecentTokenTransactionsPage();
		businessTokenAccountPage = new BusinessTokenAccountPage();
		orderPreviewPopup = new OrderPreviewPopup();
		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
//		merchantProfilePage.verifyAcccountStatus();
	}

	@AfterTest
	public void hideKeyBoard() {
		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessTokenTransactionWithTwoFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageHeading(data.get("businessTokenHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyTotalAvailableFunds(data.get("fundsHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getTotalAvailableFunds();
			businessTokenAccountPage.businessRecentTokenTransactionsPage();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().ScrollToViewMore();
			if (businessTokenAccountPage.businessRecentTokenTransactionsPage().verifyViewMore() == 1) {
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickViewMore();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickFilterIcon();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup()
						.selectFilter(data.get("filterType"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup()
						.selectFilter(data.get("filterType1"));
				Thread.sleep(1000);
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.clickCalendar();
				Thread.sleep(1000);
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.selectFromDate();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.selectToDate();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.clickDone();
//				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().clickResetAllFilters();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().fillFromAmount(data.get("fromAmount"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().fillToAmount(data.get("toAmount"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().clickApplyfilters();
				if (businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
						.verifyTransactionsCount() == 0) {
					businessTokenAccountPage.businessRecentTokenTransactionsPage().clickTransaction();
					businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
							.verifyPageHeading(data.get("transactionDetailsHeading"));
					businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
							.verifyTransactionType(data.get("transactionType"));
					businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
							.getStatus();
					if (data.get("filterType").equalsIgnoreCase("Buy Token")
							&& data.get("filterType1").equalsIgnoreCase("Bank Account")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.clickBuyBankReferenceID();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.clickbtnBuyBankBack();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().fillSearch();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().clickTransaction();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.verifyBuyTokenBankTransactionDetails();
					} else if (data.get("filterType").equalsIgnoreCase("Buy Token")
							&& data.get("filterType1").equalsIgnoreCase("Cogent")) {

					} else if (data.get("filterType").equalsIgnoreCase("Withdrawn")
							&& data.get("filterType1").equalsIgnoreCase("Bank Account")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.clickWithBankReferenceID();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.clickWithBankSignetBack();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().fillSearch();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().clickTransaction();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.verifyWithdrawTokenBankTransactionDetails();
					} else if (data.get("filterType").equalsIgnoreCase("Withdrawn")
							&& data.get("filterType1").equalsIgnoreCase("Instant Pay")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.clickInstantPayReferenceID();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.clickInstantPayBack();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().fillSearch();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().clickTransaction();
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.verifyWithdrawTokenInstantPayTransactionDetails();
					} else if (data.get("filterType").equalsIgnoreCase("Withdrawn")
							&& data.get("filterType1").equalsIgnoreCase("Cogent")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.verifyWithdrawTokenCogentTransactionDetails();
					} else if (data.get("filterType").equalsIgnoreCase("Withdrawn")
							&& data.get("filterType1").equalsIgnoreCase("Gift Card")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.verifyWithdrawTokenGiftCardTransactionDetails();
					}

				} else {
					ExtentTestManager.setWarningMessageInReport("You have no transactions");
				}
			} else {
				ExtentTestManager.setFailMessageInReport("You Have No More Transactions to Apply Filters");
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testBusinessTokenTransactionWithTwoFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessTokenTransactionWithThreeFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageHeading(data.get("businessTokenHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getTotalAvailableFunds();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageDescription(data.get("businessTokenDescription"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().ScrollToViewMore();
			if (businessTokenAccountPage.businessRecentTokenTransactionsPage().verifyViewMore() == 1) {
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickViewMore();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickFilterIcon();
				Thread.sleep(1000);
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup()
						.selectFilter(data.get("filterType"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup()
						.selectFilter(data.get("filterType1"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup()
						.selectFilter(data.get("filterType2"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().fillFromAmount(data.get("fromAmount"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().fillToAmount(data.get("toAmount"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.clickCalendar();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.selectFromDate();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.selectToDate();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.clickDone();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().clickApplyfilters();
				Thread.sleep(1000);
				if (businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
						.verifyTransactionsCount() == 0) {
					businessTokenAccountPage.businessRecentTokenTransactionsPage().clickTransaction();
					businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
							.verifyPageHeading(data.get("transactionDetailsHeading"));
					businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
							.verifyTransactionType(data.get("transactionType"));
					businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
							.verifyTranStatus(data.get("transactionStatus"));
					if (data.get("filterType").equalsIgnoreCase("Withdrawn")
							&& data.get("filterType1").equalsIgnoreCase("Bank Account")
							&& data.get("filterType2").equalsIgnoreCase("Failed")) {

					} else if (data.get("filterType").equalsIgnoreCase("Withdrawn")
							&& data.get("filterType1").equalsIgnoreCase("Bank Account")
							&& data.get("filterType2").equalsIgnoreCase("Canceled")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.verifyWithdrawTokenBankTransactionDetails();
					} else if (data.get("filterType").equalsIgnoreCase("Withdrawn")
							&& data.get("filterType1").equalsIgnoreCase("Bank Account")
							&& data.get("filterType2").equalsIgnoreCase("In progress")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.verifyWithdrawTokenBankTransactionDetails();
						cancelTransaction(strParams);
					} else if (data.get("filterType").equalsIgnoreCase("Buy Token")
							&& data.get("filterType1").equalsIgnoreCase("Bank Account")
							&& data.get("filterType2").equalsIgnoreCase("In progress")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.verifyBuyTokenBankTransactionDetails();
						cancelTransaction(strParams);
					}

				} else {
					ExtentTestManager.setInfoMessageInReport("You have no transactions");
				}
			} else {
				ExtentTestManager.setWarningMessageInReport("You Have No More Transactions to Apply Filters");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testBusinessTokenTransactionWithThreeFilters failed due to Exception " + e);
		}
	}

	public void cancelTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.verifyCancelTransaction() == 1) {
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.clickCancelTransaction();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.verifyCancelTransactionHeading(data.get("cancelHeading"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.verifyCancelTransactionDescription(data.get("cancelDescription"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.clickNo();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.verifyPageHeading(data.get("transactionDetailsHeading"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.clickCancelTransaction();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.verifyCancelTransactionHeading(data.get("cancelHeading"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.verifyCancelTransactionDescription(data.get("cancelDescription"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.clickYes();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.errorMessagePopup()
						.verifyCancelTransaction(data.get("popUpHeading"), data.get("popUpDescription"));
			}
		} catch (

		Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testBusinessTokenTransactionWithThreeFilters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessTokenTransactionWithOneFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageHeading(data.get("businessTokenHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyTotalAvailableFunds(data.get("fundsHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getTotalAvailableFunds();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageDescription(data.get("businessTokenDescription"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().ScrollToViewMore();
			if (businessTokenAccountPage.businessRecentTokenTransactionsPage().verifyViewMore() == 1) {
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickViewMore();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickFilterIcon();
				Thread.sleep(1000);
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup()
						.selectFilter(data.get("filterType"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().fillFromAmount(data.get("fromAmount"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().fillToAmount(data.get("toAmount"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.clickCalendar();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.selectFromDate();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.selectToDate();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().datePickerComponent()
						.clickDone();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().filterPopup().clickApplyfilters();
				Thread.sleep(1000);
				if (businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
						.verifyTransactionsCount() == 0) {
					businessTokenAccountPage.businessRecentTokenTransactionsPage().clickTransaction();
					businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
							.verifyPageHeading(data.get("transactionDetailsHeading"));
					if (data.get("filterType").equalsIgnoreCase("Merchant Payout")) {
						businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
								.getMerchantPayoutTransactionDetails();
					}

				} else {
					ExtentTestManager.setWarningMessageInReport("You Have No More Transactions");
				}
			} else {
				ExtentTestManager.setFailMessageInReport("You Have No More Transactions to Apply Filters");
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testBusinessTokenTransactionWithOneFilter failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveReleaseTransactionDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageHeading(data.get("businessTokenHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyTotalAvailableFunds(data.get("fundsHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getTotalAvailableFunds();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageDescription(data.get("businessTokenDescription"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().ScrollToViewMore();
			if (businessTokenAccountPage.businessRecentTokenTransactionsPage().verifyViewMore() == 1) {
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickViewMore();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.getBusinessTokenReserveReleaseTransaction(data.get("transactionDetailsHeading"),
								data.get("transactionType"), data.get("transactionStatus"));

			} else {
				ExtentTestManager.setInfoMessageInReport("You Have No More Transactions to Apply Filters");
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testBusinessTokenTransactionWithOneFilter failed due to Exception " + e);
		}
	}

	public void testVerifyWithdrawBankTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessTokenAccountPage businessTokenAccountPage = new BusinessTokenAccountPage();
			testVerifyTransaction(strParams);
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.VerifyLatestWithdrawTokenBankTransactionDetails();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.clickWithBankSignetBack();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testVerifyWithdrawBankTransaction failed due to Exception " + e);
		}
	}

	public void testVerifyTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessTokenAccountPage businessTokenAccountPage = new BusinessTokenAccountPage();
//			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageHeading(data.get("businessTokenHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyTotalAvailableFunds(data.get("fundsHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getTotalAvailableFunds();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageDescription(data.get("businessTokenDescription"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getRecentTransAmount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getRecentTransBalance();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().clickRecentTransaction();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.verifyPageHeading(data.get("transactionDetailsHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.verifyTransactionType(data.get("transactionType"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testVerifyWithdrawInstantPayTransaction failed due to Exception " + e);
		}
	}

	public void testVerifyWithdrawInstantPayTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessTokenAccountPage businessTokenAccountPage = new BusinessTokenAccountPage();
			testVerifyTransaction(strParams);
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.verifyLatestWithdrawTokenInstantPayTransactionDetails();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.clickInstantPayBack();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testVerifyWithdrawInstantPayTransaction failed due to Exception " + e);
		}
	}

	public void testVerifyWithdrawCogentTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessTokenAccountPage businessTokenAccountPage = new BusinessTokenAccountPage();
			testVerifyTransaction(strParams);
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.verifyLatestWithdrawTokenCogentTransactionDetails();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.clickWithBankSignetBack();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testVerifyWithdrawSignetTransaction failed due to Exception " + e);
		}
	}

	public void testVerifyWithdrawGiftCardTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessTokenAccountPage businessTokenAccountPage = new BusinessTokenAccountPage();
			testVerifyTransaction(strParams);
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.verifyLatestWithdrawTokenGiftCardTransactionDetails();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testVerifyWithdrawGiftCardTransaction failed due to Exception " + e);
		}
	}

	public void testVerifyBuyTokenBankTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessTokenAccountPage businessTokenAccountPage = new BusinessTokenAccountPage();
			testVerifyTransaction(strParams);
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.VerifyLatestBuyTokenBankTransactionDetails();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
					.clickbtnBuyBankBack();
			businessTokenAccountPage.businessRecentTokenTransactionsPage().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testVerifyBuyTokenBankTransaction failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessTokenTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageHeading(data.get("businessTokenHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyTotalAvailableFunds(data.get("fundsHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getTotalAvailableFunds();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageDescription(data.get("businessTokenDescription"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().ScrollToViewMore();
			if (businessTokenAccountPage.businessRecentTokenTransactionsPage().verifyViewMore() == 1) {
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickViewMore();
			} else {
				ExtentTestManager.setInfoMessageInReport("You Have No More Transactions to Apply Filters");
			}
			businessTokenAccountPage.businessRecentTokenTransactionsPage().scrollToNoMoreTransactions();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyNoMoreTransactions(data.get("noMoreTransactions"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBusinessTokenTransactionList failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessTokenTransactionValidateSearch(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageHeading(data.get("businessTokenHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyTotalAvailableFunds(data.get("fundsHeading"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().getTotalAvailableFunds();
			businessTokenAccountPage.businessRecentTokenTransactionsPage()
					.verifyPageDescription(data.get("businessTokenDescription"));
			businessTokenAccountPage.businessRecentTokenTransactionsPage().ScrollToViewMore();
			if (businessTokenAccountPage.businessRecentTokenTransactionsPage().verifyViewMore() == 1) {
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickViewMore();
				String[] search = data.get("search").split(",");
				businessTokenAccountPage.businessRecentTokenTransactionsPage().fieldValidationsComponent()
						.validateSearchField(search[0], search[1], search[2]);
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickSearchTransaction();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.verifyPageHeading(data.get("transactionDetailsHeading"));
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.getReferenceID();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.clickBack();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().fillSearch();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().clickSearchTransaction();
				businessTokenAccountPage.businessRecentTokenTransactionsPage().businessTransactionDetailsPage()
						.verifySearchTransactionDetails();

			} else {
				ExtentTestManager.setWarningMessageInReport("You Have No More Transactions to validate Search field");
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testBusinessTokenTransactionValidateSearch failed due to Exception " + e);
		}
	}
}
