package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.SideBarComponent;
import coyni.admin.pages.HomePage;
import coyni.admin.pages.TransactionPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionTest {

	HomePage homePage;
	TransactionPage transactionPage;
	SideBarComponent sideBarComponent;
	CoyniPortalTest coyniPortalTest;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		transactionPage = new TransactionPage();
		sideBarComponent = new SideBarComponent();
		coyniPortalTest = new CoyniPortalTest();
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickTransactions();
			homePage.sideBarComponent().transactionPage().verifyTransactionHeading(data.get("listHeading"));

			homePage.sideBarComponent().transactionPage().getDateAndTime();
			homePage.sideBarComponent().transactionPage().getType();
			homePage.sideBarComponent().transactionPage().getDescription();
			homePage.sideBarComponent().transactionPage().getAmount();
			homePage.sideBarComponent().transactionPage().getStatus();
//			homePage.sideBarComponent().transactionPage().paginationAndEntriesComponent()
//					.verifyTableItemsCount(data.get("query"));
//			homePage.sideBarComponent().transactionPage().paginationAndEntriesComponent().verifyPageNumbersWithCount();
//			homePage.sideBarComponent().transactionPage().paginationAndEntriesComponent()
//					.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
//			homePage.sideBarComponent().transactionPage().verifyEntriesMessage();
//			ExtentTestManager.setInfoMessageInReport(
//					"Entries is displayed as " + homePage.sideBarComponent().transactionPage().getEntriesMessage());
//			homePage.sideBarComponent().transactionPage().clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionToday(String strParams) throws InterruptedException {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Today");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionYesterday(String strParams) throws InterruptedException{

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Yesterday");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastSevenDays(String strParams) throws InterruptedException{

		Map<String, String> data = Runner.getKeywordParameters(strParams);

		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Last 7 Days");

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastMonth(String strParams) {
		try {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Last Month");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportSelectedTransactionMonthToDate Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionMonthToDate(String strParams) {
		try {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickTransactions();
		Thread.sleep(2000);
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().exportComponent().verifyExport(data.get("heading"));
		coyniPortalTest.testExportSelectedTransactions(strParams, "Month to Date");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportSelectedTransactionMonthToDate Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListFilters(String strParams) {
		try {
			homePage.sideBarComponent().clickTransactions();

			coyniPortalTest.testFilters(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListResetFilters(String strParams) {
		try {
			homePage.sideBarComponent().clickTransactions();
			coyniPortalTest.testFilters(strParams);
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
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickBuyToken();
			testTransactionDetailsBuyToken(strParams, "debit");

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
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickBuyToken();
			testTransactionDetailsBuyToken(strParams, "credit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	public void testTransactionDetailsBuyToken(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (card.equalsIgnoreCase("debit")) {
				sideBarComponent.transactionPage().filterComponent().clickDebitCard();
			} else {
				sideBarComponent.transactionPage().filterComponent().clickCreditCard();
			}
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			String type = sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyBuyTokenType();
			String description = sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyBuyTokenDescription();
			String amount = sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyBuyTokenAmount();

			if (description.contains(type)) {
				ExtentTestManager.setInfoMessageInReport(
						"Transaction Type is " + type + " And " + " Transaction Description is " + description);
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
				Thread.sleep(4000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
						.verifyTransactionDetailsHeading(data.get("transactionHeading"));
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
						.getTransactionSubType();
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
				String detailsAmount = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().amount();
				if (amount.equals(detailsAmount)) {
					ExtentTestManager.setInfoMessageInReport("Transaction List Amount  is " + amount + " And "
							+ " Transaction Details Amount is  " + detailsAmount);
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifyLedgerInformation(data.get("ledgerInformation"));
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getTransactionIPAddress();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifyRecipientInformation(data.get("recipientInformation"));
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getRecipientName();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getRecipientEmail();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getRecipientPhoneNumber();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifyCardholderName();
					// sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifyExpirationDate();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifyProcessorID();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifyProcessorAuthCode();
				} else {
					ExtentTestManager.setWarningMessageInReport(
							"Transaction List Amount and Transaction Details Amount Not matched");
				}
			} else {
				ExtentTestManager.setWarningMessageInReport("Buy Token Type and Description is Not match");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionPage().filterComponent().clickGiftCard();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			Thread.sleep(3000);

			String withdrawSubType = sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyWithDrawSubType();

			String withdrawDescription = sideBarComponent.transactionPage().filterComponent()
					.transactionDetailsComponent().verifyWithdrawDescription();
			String withdrawAmount = sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyWithdrawAmount();
			ExtentTestManager.setInfoMessageInReport("Amount is Starting with negative Value " + withdrawAmount);

			String negative = "-";
			if (withdrawDescription.contains(withdrawSubType) && withdrawAmount.contains(negative)) {
				ExtentTestManager.setInfoMessageInReport("WithDraw Description is:" + withdrawDescription + " and "
						+ "Transaction SubType is : " + withdrawSubType);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
				Thread.sleep(3000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
						.verifyTransactionDetailsHeading(data.get("transactionHeading"));
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
				Thread.sleep(2000);
				String amount = sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
						.giftCardAmount();

				if (withdrawAmount.contains(amount)) {
					ExtentTestManager.setInfoMessageInReport("Withdraw GiftCard Amount is : " + amount);
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getTransactionSubType();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getgiftCardAmount();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifyLedgerInformation(data.get("ledgerInformation"));
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getTransactionIPAddress();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifyRecipientInformation(data.get("recipientInformation"));
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getRecipientName();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getRecipientEmail();

					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.verifySenderInformation(data.get("senderInformation"));
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountID();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderName();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
							.getAccountAddress();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderEmail();
					sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
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
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickBuyToken();
			sideBarComponent.transactionPage().filterComponent().clickExternalBankAccount();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyRecipientInformation(data.get("recipientInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getRecipientEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getRecipientPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyBankInformation(data.get("bankInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getBankName();

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
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionPage().filterComponent().clickInstantPay();
			sideBarComponent.transactionPage().filterComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			// sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifySenderInformation(data.get("senderInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderEmail();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderPhoneNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyCardInformation(data.get("cardInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardholderName();
			// sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyCardNumber();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().verifyExpirationDate();

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
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionPage().filterComponent().clickExternalBankAccount();
			sideBarComponent.transactionPage().filterComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			Thread.sleep(3000);
			if(sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().noDataFound()==0) {
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyTransactionDetailsHeading(data.get("transactionHeading"));
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionType();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getTransactionSubType();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCreatedDate();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAmount();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyLedgerInformation(data.get("ledgerInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getReferenceID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getCordaID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.getTransactionIPAddress();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifySenderInformation(data.get("senderInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getAccountID();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getSenderName();
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent()
					.verifyBankAccountInformation(data.get("bankInformation"));
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().getBankName();
			}
			else {
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
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().filtersComponent(data.get("filters"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}
	
	

	@Test
	@Parameters({ "strParams" })
	public void testverifyApplyFilterAndClearFilters(String strParams) {
		try {
			
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
		//	sideBarComponent.transactionPage().filterComponent().filtersComponent(data.get("filters"));
			sideBarComponent.transactionPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionPage().filterComponent().clickInstantPay();
			sideBarComponent.transactionPage().filterComponent().clickchkbxPersonal();
			sideBarComponent.transactionPage().filterComponent().clickCreditCard();
			sideBarComponent.transactionPage().filterComponent().clickDebitCard();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().clickBackDebitCard();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().verifyDebitCardCheckBox();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testgenerateDisputes(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickchkbxPersonal();
			sideBarComponent.transactionPage().filterComponent().clickCreditCard();
			sideBarComponent.transactionPage().filterComponent().clickDebitCard();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().clickCompleted();
			Thread.sleep(5000);

			String transactionDetailsAmount = sideBarComponent.transactionPage().filterComponent()
					.transactionDetailsComponent().verifyAmount();
			String transactionDetailsDate = sideBarComponent.transactionPage().filterComponent()
					.transactionDetailsComponent().verifyDate();
			String transactionDetailsReferenceID = sideBarComponent.transactionPage().filterComponent()
					.transactionDetailsComponent().verifyReferenceID();
			String transactionDetailsTSubType = sideBarComponent.transactionPage().filterComponent()
					.transactionDetailsComponent().verifySubType();
			if (sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
					.getChargeBackSize() != 0) {
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.chargeBackLink();
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.disputesDetailsComponent().getCaseID();

				String caseDetailsAmount = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifyAmount();
				String caseDetailsDate = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifyDate();
				String caseDetailsReferenceID = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent()
						.verifyReferenceID();
				String caseDetailsTSubType = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifySubType();
				Thread.sleep(2000);

				if (transactionDetailsAmount.contains(caseDetailsAmount)) {
					ExtentTestManager.setPassMessageInReport(
							"TransactionDetalis Amount " + transactionDetailsAmount + "  matched ");
				} else {
					ExtentTestManager.setWarningMessageInReport(
							"TransactionDetalis Amount " + transactionDetailsAmount + "  matched ");
				}
				if (transactionDetailsDate.contains(caseDetailsDate)) {
					ExtentTestManager.setPassMessageInReport("Date Is " + transactionDetailsDate + "  matched");
				} else {
					ExtentTestManager.setWarningMessageInReport("Date Is " + transactionDetailsDate + " not matched");
				}
				if (transactionDetailsReferenceID.contains(caseDetailsReferenceID)) {
					ExtentTestManager
							.setPassMessageInReport("ReferenceId Is " + transactionDetailsReferenceID + " matched");
				} else {
					ExtentTestManager.setWarningMessageInReport(
							"ReferenceId Is " + transactionDetailsReferenceID + " not matched");
				}
				if (transactionDetailsTSubType.contains(caseDetailsTSubType)) {
					ExtentTestManager.setPassMessageInReport(
							"Transaction Subtype is " + transactionDetailsTSubType + " Matched");
				} else {
					ExtentTestManager.setWarningMessageInReport(
							"Transaction Subtype is " + transactionDetailsTSubType + " Not Matched");
				}

			} else {
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.clickChargeBack();
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.verifyHeading(data.get("chargeBackHeading"));
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.fillCaseNumber(data.get("caseNumber"));
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.clickEndDate();
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.datePickerComponent().generateDate();
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.clickStartDate();
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.datePickerComponent().clickCustomDate();
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.clickReason();
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.clickReasonText();
				Thread.sleep(5000);

				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.clickOpen();
				Thread.sleep(2000);
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.disputesDetailsComponent().verifyTableData(data.get("tableData"));
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.disputesDetailsComponent().verifyName(data.get("nameOfUser"));
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.disputesDetailsComponent().clickPending();
				String caseDetailsAmount = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifyAmount();
				String caseDetailsDate = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifyDate();
				String caseDetailsReferenceID = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent()
						.verifyReferenceID();
				String caseDetailsTSubType = sideBarComponent.transactionPage().filterComponent()
						.transactionDetailsComponent().chargebackComponent().disputesDetailsComponent().verifySubType();

				if (transactionDetailsAmount.contains(caseDetailsAmount)) {
					ExtentTestManager.setPassMessageInReport(
							"TransactionDetalis Amount " + transactionDetailsAmount + "  matched ");
				} else {
					ExtentTestManager.setWarningMessageInReport(
							"TransactionDetalis Amount " + transactionDetailsAmount + "  matched ");
				}
				if (transactionDetailsDate.contains(caseDetailsDate)) {
					ExtentTestManager.setPassMessageInReport("Date Is " + transactionDetailsDate + "  matched");
				} else {
					ExtentTestManager.setWarningMessageInReport("Date Is " + transactionDetailsDate + " not matched");
				}
				if (transactionDetailsReferenceID.contains(caseDetailsReferenceID)) {
					ExtentTestManager
							.setPassMessageInReport("ReferenceId Is " + transactionDetailsReferenceID + " matched");
				} else {
					ExtentTestManager.setWarningMessageInReport(
							"ReferenceId Is " + transactionDetailsReferenceID + " not matched");
				}
				if (transactionDetailsTSubType.contains(caseDetailsTSubType)) {
					ExtentTestManager.setPassMessageInReport(
							"Transaction Subtype is " + transactionDetailsTSubType + " Matched");
				} else {
					ExtentTestManager.setWarningMessageInReport(
							"Transaction Subtype is " + transactionDetailsTSubType + " Not Matched");
				}

//				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
//						.disputesDetailsComponent().enterMessage(data.get("message"));
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.disputesDetailsComponent().clickWon();
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.disputesDetailsComponent().disputesWonAndLostComponent().verifyHeading(data.get("wonHeading"));
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.disputesDetailsComponent().disputesWonAndLostComponent().verifyContent(data.get("content"));
				sideBarComponent.transactionPage().filterComponent().transactionDetailsComponent().chargebackComponent()
						.disputesDetailsComponent().disputesWonAndLostComponent().clickYes();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testVerifyFiltersDataInTransaction(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickWithdraw();
			sideBarComponent.transactionPage().filterComponent().clickCompleted();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().verifyTableItemsCount(data.get("query"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	/*
	 * New code for Filters
	 */
	@Test
	@Parameters({ "strParams" })
	public void testTransactionsFiltersWithBusiness(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().clickBusiness();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().clickFilters();

			/*
			 * Business Completed
			 */
//		    sideBarComponent.transactionPage().filterComponent().calenderComponent().clickStartDate();
//			Thread.sleep(1000);
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().filterCalenderComponent().clickPreviousTenDays();
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().filterCalenderComponent().clickCurrentDay();
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxBusiness();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkSaleOrder();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkMerchantPayout();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkRefund();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkMonthlyServiceFee();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCommissionPayout();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkeCommerce();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkRetailOrMobile();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("fromAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCompleted();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * Business Failed
			 */
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCompleted();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxFailed();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData1 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData1 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query1"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * Business In Progress
			 */
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxFailed();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxInprogress();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData2 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData2 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query2"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * Business Pending
			 */
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxInprogress();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkPending();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData3 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData3 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query3"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Filters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionsFiltersBusinessWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().clickBusiness();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().fillSenderName(data.get("senderName"));
			sideBarComponent.transactionPage().filterComponent().fillReceiverName(data.get("receiverName"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Filters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTrasactionsFiltersWithToken(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().clickToken();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			/*
			 * Business Completed
			 */
//		    sideBarComponent.transactionPage().filterComponent().calenderComponent().clickStartDate();
//			Thread.sleep(1000);
//		    homePage.sideBarComponent().tokenAccountPage().filterComponent().filterCalenderComponent().clickPreviousTenDays();
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().filterCalenderComponent().clickCurrentDay();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxPersonal();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkPayAndRequest();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickBuyToken();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickWithdraw();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkSent();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkReceived();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickDebitCard();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickCreditCard();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickExternalBankAccount();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCogent();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkInstantPay();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickGiftCard();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkFailedBankWithdraw();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("fromAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCompleted();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * Business Failed
			 */
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCompleted();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxFailed();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData1 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData1 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query1"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * Business In Progress
			 */
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxFailed();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxInprogress();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData2 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData2 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query2"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * Business Pending
			 */
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxInprogress();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkPending();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData3 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData3 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query3"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * Business Cancelled
			 */
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkPending();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxCancelled();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData4 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData4 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query4"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * Coyni Admin
			 */
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			/*
			 * Business Completed
			 */
//		    sideBarComponent.transactionPage().filterComponent().calenderComponent().clickStartDate();
//			Thread.sleep(1000);
//		    homePage.sideBarComponent().tokenAccountPage().filterComponent().filterCalenderComponent().clickPreviousTenDays();
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().filterCalenderComponent().clickCurrentDay();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxPersonal();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxCoyniAdmin();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCommissionPayout();
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCogent();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbkCompleted();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxCancelled();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData5 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData5 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query5"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Filters Failed due to Exception " + e);
		}
	}
	
	@Test
	public void testTransactionPaginations() {
		try {
		    homePage.sideBarComponent().clickTransactions();
			homePage.sideBarComponent().accountTableComponent().verifyPaginations();
		} catch (Exception e) {
		    ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}
		
	}
	@Test
	@Parameters({ "strParams" })
	public void testPersonalTransactionListWithSentAndReceive(String strParams) {
		try {
			
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarComponent.clickTransactions();
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickchkbxPersonal();
			sideBarComponent.transactionPage().filterComponent().clickchkbkSent();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			sideBarComponent.transactionPage().filterComponent().getTotalCustomerCount(data.get("query"));
			sideBarComponent.transactionPage().filterComponent().clickFilters();
			sideBarComponent.transactionPage().filterComponent().clickchkbkSent();
			sideBarComponent.transactionPage().filterComponent().clickchkbkReceived();
			sideBarComponent.transactionPage().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			sideBarComponent.transactionPage().filterComponent().getTotalCustomerCount(data.get("query1"));
			
			
		} catch (Exception e) {
		    ExtentTestManager.setFailMessageInReport("testPersonalTransactionListWithSentAndReceive Failed due to this Exception " + e);
		}
		
	}
}

