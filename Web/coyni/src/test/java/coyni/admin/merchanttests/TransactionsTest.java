package coyni.admin.merchanttests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.Paymentpages.TransactionsPage;
import coyni.admin.components.SideBarComponent;
import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionsTest {

	HomePage homePage;
	TransactionsPage transactionsPage;
	SideBarComponent sideBarComponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		transactionsPage = new TransactionsPage();
		sideBarComponent = new SideBarComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickTransactions();
			homePage.sideBarComponent().commissionAccountPage().transactionsPage()
					.verifyTransactionHeading(data.get("listHeading"));
			homePage.sideBarComponent().commissionAccountPage().transactionsPage().getDateAndTime();
			homePage.sideBarComponent().commissionAccountPage().transactionsPage().getType();
			homePage.sideBarComponent().commissionAccountPage().transactionsPage().getDescription();
			homePage.sideBarComponent().commissionAccountPage().transactionsPage().getAmount();
			homePage.sideBarComponent().commissionAccountPage().transactionsPage().getStatus();
//			homePage.sideBarComponent().transactionsPage().paginationAndEntriesComponent()
//					.verifyTableItemsCount(data.get("query"));
//			homePage.sideBarComponent().transactionsPage().paginationAndEntriesComponent().verifyPageNumbersWithCount();
//			homePage.sideBarComponent().transactionsPage().paginationAndEntriesComponent()
//					.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
//			homePage.sideBarComponent().transactionsPage().verifyEntriesMessage();
//			ExtentTestManager.setInfoMessageInReport(
//					"Entries is displayed as " + homePage.sideBarComponent().transactionsPage().getEntriesMessage());
//			homePage.sideBarComponent().transactionsPage().clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionToday(String strParams) throws InterruptedException {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().commissionAccountPage().transactionsPage().exportComponent().clickExport();
//		homePage.sideBarComponent().commissionAccountPage().transactionsPage().exportComponent()
//				.verifyExport(data.get("heading"));
		// coyniPortalTest.testExportSelectedTransactions(strParams, "Today");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionYesterday(String strParams) throws InterruptedException {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().commissionAccountPage().transactionsPage().exportComponent().clickExport();
//		homePage.sideBarComponent().commissionAccountPage().transactionsPage().exportComponent()
//				.verifyExport(data.get("heading"));
		// coyniPortalTest.testExportSelectedTransactions(strParams, "Today");
		// coyniPortalTest.testExportSelectedTransactions(strParams, "Yesterday");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastSevenDays(String strParams) throws InterruptedException {

		Map<String, String> data = Runner.getKeywordParameters(strParams);

		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().commissionAccountPage().transactionsPage().exportComponent().clickExport();
//		homePage.sideBarComponent().commissionAccountPage().transactionsPage().exportComponent()
//				.verifyExport(data.get("heading"));
		// coyniPortalTest.testExportSelectedTransactions(strParams, "Today");
		// coyniPortalTest.testExportSelectedTransactions(strParams, "Last 7 Days");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastMonth(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickTransactions();
//			homePage.sideBarComponent().exportComponent().clickExport();
//			homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
			// coyniPortalTest.testExportSelectedTransactions(strParams, "Last Month");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testExportSelectedTransactionMonthToDate Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionMonthToDate(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickTransactions();
			Thread.sleep(2000);
			homePage.sideBarComponent().commissionAccountPage().transactionsPage().exportComponent().clickExport();
//			homePage.sideBarComponent().commissionAccountPage().transactionsPage().exportComponent()
//					.verifyExport(data.get("heading"));
			// coyniPortalTest.testExportSelectedTransactions(strParams, "Today");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testExportSelectedTransactionMonthToDate Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListFilters(String strParams) {
		try {
			homePage.sideBarComponent().clickTransactions();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListResetFilters(String strParams) {
		try {
			homePage.sideBarComponent().clickTransactions();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDebitCard(String strParams) {
		try {
			sideBarComponent.clickTransactions();
			Thread.sleep(4000);
			sideBarComponent.transactionsPage().filterComponent().clickFilters();
			// sideBarComponent.transactionsPage().filterComponent().clickBuyToken();
			// testTransactionDetailsBuyToken(strParams, "debit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenCreditCard(String strParams) {
		try {
			sideBarComponent.clickTransactions();
			Thread.sleep(2000);
			sideBarComponent.transactionsPage().filterComponent().clickFilters();
			// sideBarComponent.transactionsPage().filterComponent().clickBuyToken();
			// testTransactionDetailsBuyToken(strParams, "credit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

//	public void testTransactionDetailsBuyToken(String strParams, String card) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			if (card.equalsIgnoreCase("debit")) {
//				sideBarComponent.transactionsPage().filterComponent().clickDebitCard();
//			} else {
//				sideBarComponent.transactionsPage().filterComponent().clickCreditCard();
//			}
//			sideBarComponent.transactionsPage().filterComponent().clickApplyFilters();
//			Thread.sleep(2000);
//			String type = sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//					.verifyBuyTokenType();
//			String description = sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//					.verifyBuyTokenDescription();
//			String amount = sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//					.verifyBuyTokenAmount();
//
//			if (description.contains(type)) {
//				ExtentTestManager.setInfoMessageInReport(
//						"Transaction Type is " + type + " And " + " Transaction Description is " + description);
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().clickCompleted();
//				Thread.sleep(4000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//						.verifyTransactionDetailsHeading(data.get("transactionHeading"));
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//						.getTransactionType();
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//						.getTransactionSubType();
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCreatedDate();
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getAmount();
//				String detailsAmount = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().amount();
//				if (amount.equals(detailsAmount)) {
//					ExtentTestManager.setInfoMessageInReport("Transaction List Amount  is " + amount + " And "
//							+ " Transaction Details Amount is  " + detailsAmount);
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.verifyLedgerInformation(data.get("ledgerInformation"));
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.getReferenceID();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCordaID();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.getTransactionIPAddress();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.verifyRecipientInformation(data.get("recipientInformation"));
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.getRecipientName();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.getRecipientEmail();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.getRecipientPhoneNumber();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.verifyCardholderName();
//					// sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.verifyExpirationDate();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.verifyProcessorID();
//					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
//							.verifyProcessorAuthCode();
//				} else {
//					ExtentTestManager.setWarningMessageInReport(
//							"Transaction List Amount and Transaction Details Amount Not matched");
//				}
//			} else {
//				ExtentTestManager.setWarningMessageInReport("Buy Token Type and Description is Not match");
//			}
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionsPage().filterComponent().clickFilters();
//			sideBarComponent.transactionsPage().filterComponent().clickWithdraw();
//			sideBarComponent.transactionsPage().filterComponent().clickGiftCard();
			sideBarComponent.transactionsPage().filterComponent().clickApplyFilters();
			Thread.sleep(3000);

			String withdrawSubType = sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyWithDrawSubType();

			String withdrawDescription = sideBarComponent.transactionsPage().filterComponent()
					.transactionDetailsComponent().verifyWithdrawDescription();
			String withdrawAmount = sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyWithdrawAmount();
			ExtentTestManager.setInfoMessageInReport("Amount is Starting with negative Value " + withdrawAmount);

			String negative = "-";
			if (withdrawDescription.contains(withdrawSubType) && withdrawAmount.contains(negative)) {
				ExtentTestManager.setInfoMessageInReport("WithDraw Description is:" + withdrawDescription + " and "
						+ "Transaction SubType is : " + withdrawSubType);
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().clickCompleted();
				Thread.sleep(3000);
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.verifyTransactionDetailsHeading(data.get("transactionHeading"));
				Thread.sleep(2000);
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.getTransactionType();
				Thread.sleep(2000);
				String amount = sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.giftCardAmount();

				if (withdrawAmount.contains(amount)) {
					ExtentTestManager.setInfoMessageInReport("Withdraw GiftCard Amount is : " + amount);
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getTransactionSubType();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getCreatedDate();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getgiftCardAmount();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.verifyLedgerInformation(data.get("ledgerInformation"));
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getReferenceID();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCordaID();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getTransactionIPAddress();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.verifyRecipientInformation(data.get("recipientInformation"));
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getRecipientName();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getRecipientEmail();

					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.verifySenderInformation(data.get("senderInformation"));
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getAccountID();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getSenderName();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getAccountAddress();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getSenderEmail();
					sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
							.getSenderPhoneNumber();
				} else {
					ExtentTestManager.setInfoMessageInReport("Amount is not same");
				}
			} else {
				ExtentTestManager.setWarningMessageInReport(
						"Transaction SubType and Transaction Description is not Match / Amount is not a negative value");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionsPage().filterComponent().clickFilters();
			// sideBarComponent.transactionsPage().filterComponent().clickBuyToken();
			// sideBarComponent.transactionsPage().filterComponent().clickExternalBankAccount();
			sideBarComponent.transactionsPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getRecipientEmail();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.getRecipientPhoneNumber();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyBankInformation(data.get("bankInformation"));
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getBankName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailWithdrawInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionsPage().filterComponent().clickFilters();
//			sideBarComponent.transactionsPage().filterComponent().clickWithdraw();
//			sideBarComponent.transactionsPage().filterComponent().clickInstantPay();
			sideBarComponent.transactionsPage().filterComponent().clickCompleted();
			sideBarComponent.transactionsPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			// sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifySenderInformation(data.get("senderInformation"));
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getAccountID();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getSenderName();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getAccountAddress();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getSenderEmail();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getSenderPhoneNumber();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.verifyCardInformation(data.get("cardInformation"));
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().verifyCardholderName();
			// sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().verifyExpirationDate();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionsPage().filterComponent().clickFilters();
//			sideBarComponent.transactionsPage().filterComponent().clickWithdraw();
//			sideBarComponent.transactionsPage().filterComponent().clickExternalBankAccount();
			sideBarComponent.transactionsPage().filterComponent().clickCompleted();
			sideBarComponent.transactionsPage().filterComponent().clickApplyFilters();
			Thread.sleep(3000);
			if (sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
					.noDataFound() == 0) {
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().clickCompleted();
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.verifyTransactionDetailsHeading(data.get("transactionHeading"));
				Thread.sleep(2000);
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.getTransactionType();
				Thread.sleep(2000);
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.getTransactionSubType();
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCreatedDate();
				Thread.sleep(2000);
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getAmount();
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.verifyLedgerInformation(data.get("ledgerInformation"));
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getReferenceID();
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getCordaID();
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.getTransactionIPAddress();
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.verifySenderInformation(data.get("senderInformation"));
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getAccountID();
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getSenderName();
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent()
						.verifyBankAccountInformation(data.get("bankInformation"));
				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().getBankName();
			} else {
				ExtentTestManager.setPassMessageInReport("No filter data found");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testverifyFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionsPage().filterComponent().clickFilters();
			// sideBarComponent.transactionsPage().filterComponent().filtersComponent(data.get("filters"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testverifyApplyFilterAndClearFilters(String strParams) {
//		try {
//
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			Thread.sleep(2000);
//			sideBarComponent.clickTransactions();
//			sideBarComponent.transactionsPage().filterComponent().clickFilters();
//			// sideBarComponent.transactionsPage().filterComponent().filtersComponent(data.get("filters"));
//			sideBarComponent.transactionsPage().filterComponent().clickWithdraw();
//			sideBarComponent.transactionsPage().filterComponent().clickInstantPay();
//			sideBarComponent.transactionsPage().filterComponent().clickchkbxPersonal();
//			sideBarComponent.transactionsPage().filterComponent().clickCreditCard();
//			sideBarComponent.transactionsPage().filterComponent().clickDebitCard();
//			sideBarComponent.transactionsPage().filterComponent().clickApplyFilters();
//			Thread.sleep(2000);
//			sideBarComponent.transactionsPage().filterComponent().clickBackDebitCard();
//			sideBarComponent.transactionsPage().filterComponent().clickFilters();
//			sideBarComponent.transactionsPage().filterComponent().verifyDebitCardCheckBox();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
//		}
//	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testgenerateDisputes(String strParams) {
//		try {
//
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarComponent.clickTransactions();
//			sideBarComponent.transactionsPage().filterComponent().clickFilters();
////			sideBarComponent.transactionsPage().filterComponent().clickchkbxPersonal();
//			sideBarComponent.transactionsPage().filterComponent().clickCreditCard();
//			sideBarComponent.transactionsPage().filterComponent().clickDebitCard();
//			sideBarComponent.transactionsPage().filterComponent().clickApplyFilters();
//			Thread.sleep(2000);
//			sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().clickCompleted();
//			Thread.sleep(5000);
//
//			String transactionDetailsAmount = sideBarComponent.transactionsPage().filterComponent()
//					.transactionDetailsComponent().verifyAmount();
//			String transactionDetailsDate = sideBarComponent.transactionsPage().filterComponent()
//					.transactionDetailsComponent().verifyDate();
//			String transactionDetailsReferenceID = sideBarComponent.transactionsPage().filterComponent()
//					.transactionDetailsComponent().verifyReferenceID();
//			String transactionDetailsTSubType = sideBarComponent.transactionsPage().filterComponent()
//					.transactionDetailsComponent().verifySubType();
//			if (sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//					.getChargeBackSize() != 0) {
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.chargeBackLink();
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().getCaseID();
//
//				String caseDetailsAmount = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifyAmount();
//				String caseDetailsDate = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifyDate();
//				String caseDetailsReferenceID = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent()
//						.verifyReferenceID();
//				String caseDetailsTSubType = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifySubType();
//				Thread.sleep(2000);
//
//				if (transactionDetailsAmount.contains(caseDetailsAmount)) {
//					ExtentTestManager.setPassMessageInReport(
//							"TransactionDetalis Amount " + transactionDetailsAmount + "  matched ");
//				} else {
//					ExtentTestManager.setWarningMessageInReport(
//							"TransactionDetalis Amount " + transactionDetailsAmount + "  matched ");
//				}
//				if (transactionDetailsDate.contains(caseDetailsDate)) {
//					ExtentTestManager.setPassMessageInReport("Date Is " + transactionDetailsDate + "  matched");
//				} else {
//					ExtentTestManager.setWarningMessageInReport("Date Is " + transactionDetailsDate + " not matched");
//				}
//				if (transactionDetailsReferenceID.contains(caseDetailsReferenceID)) {
//					ExtentTestManager
//							.setPassMessageInReport("ReferenceId Is " + transactionDetailsReferenceID + " matched");
//				} else {
//					ExtentTestManager.setWarningMessageInReport(
//							"ReferenceId Is " + transactionDetailsReferenceID + " not matched");
//				}
//				if (transactionDetailsTSubType.contains(caseDetailsTSubType)) {
//					ExtentTestManager.setPassMessageInReport(
//							"Transaction Subtype is " + transactionDetailsTSubType + " Matched");
//				} else {
//					ExtentTestManager.setWarningMessageInReport(
//							"Transaction Subtype is " + transactionDetailsTSubType + " Not Matched");
//				}
//
//			} else {
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.clickChargeBack();
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.verifyHeading(data.get("chargeBackHeading"));
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.fillCaseNumber(data.get("caseNumber"));
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.clickEndDate();
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.datePickerComponent().generateDate();
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.clickStartDate();
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.datePickerComponent().clickCustomDate();
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.clickReason();
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.clickReasonText();
//				Thread.sleep(5000);
//
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.clickOpen();
//				Thread.sleep(2000);
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().verifyTableData(data.get("tableData"));
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().verifyName(data.get("nameOfUser"));
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().clickPending();
//				String caseDetailsAmount = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifyAmount();
//				String caseDetailsDate = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifyDate();
//				String caseDetailsReferenceID = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent()
//						.verifyReferenceID();
//				String caseDetailsTSubType = sideBarComponent.transactionsPage().filterComponent()
//						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifySubType();
//
//				if (transactionDetailsAmount.contains(caseDetailsAmount)) {
//					ExtentTestManager.setPassMessageInReport(
//							"TransactionDetalis Amount " + transactionDetailsAmount + "  matched ");
//				} else {
//					ExtentTestManager.setWarningMessageInReport(
//							"TransactionDetalis Amount " + transactionDetailsAmount + "  matched ");
//				}
//				if (transactionDetailsDate.contains(caseDetailsDate)) {
//					ExtentTestManager.setPassMessageInReport("Date Is " + transactionDetailsDate + "  matched");
//				} else {
//					ExtentTestManager.setWarningMessageInReport("Date Is " + transactionDetailsDate + " not matched");
//				}
//				if (transactionDetailsReferenceID.contains(caseDetailsReferenceID)) {
//					ExtentTestManager
//							.setPassMessageInReport("ReferenceId Is " + transactionDetailsReferenceID + " matched");
//				} else {
//					ExtentTestManager.setWarningMessageInReport(
//							"ReferenceId Is " + transactionDetailsReferenceID + " not matched");
//				}
//				if (transactionDetailsTSubType.contains(caseDetailsTSubType)) {
//					ExtentTestManager.setPassMessageInReport(
//							"Transaction Subtype is " + transactionDetailsTSubType + " Matched");
//				} else {
//					ExtentTestManager.setWarningMessageInReport(
//							"Transaction Subtype is " + transactionDetailsTSubType + " Not Matched");
//				}
//
////				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
////						.disputesDetailsComponent().enterMessage(data.get("message"));
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().clickWon();
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().disputesWonAndLostComponent().verifyHeading(data.get("wonHeading"));
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().disputesWonAndLostComponent().verifyContent(data.get("content"));
//				sideBarComponent.transactionsPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().disputesWonAndLostComponent().clickYes();
//			}
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testVerifyFiltersDataInTransaction(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionsPage().filterComponent().clickFilters();
//			sideBarComponent.transactionsPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionsPage().filterComponent().clickCompleted();
			sideBarComponent.transactionsPage().filterComponent().clickApplyFilters();
			// sideBarComponent.transactionsPage().filterComponent().verifyTableItemsCount(data.get("query"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

}
