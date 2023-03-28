package coyni.apibusiness.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.api.business.popups.BuyCoyniTokensNoPaymentPopup;
import coyni.api.business.popups.BuyTokensPaymentPopup;
import coyni.apibusiness.components.FilterComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.BusinessProfilePage;
import coyni.apibusiness.pages.HomePage;
import coyni.apibusiness.pages.TokenWalletPage;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletTest {

	TokenWalletPage tokenWalletPage;
	SideBarMenuComponent sideBarMenuComponent;
	FilterComponent filterComponent;
	HomePage homePage;
	BuyCoyniTokensNoPaymentPopup buyCoyniTokensNoPaymentPopup;
	BuyTokensPaymentPopup buyTokensPaymentPopup;
	BrowserFunctions objBrowserFunctions;

	@BeforeMethod
	public void init() {

		tokenWalletPage = new TokenWalletPage();
		homePage = new HomePage();
		sideBarMenuComponent = new SideBarMenuComponent();
		filterComponent = new FilterComponent();
		buyCoyniTokensNoPaymentPopup = new BuyCoyniTokensNoPaymentPopup();
		buyTokensPaymentPopup = new BuyTokensPaymentPopup();
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletTransfer(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.sideBarMenuComponent().clickTokenwallet();
			sideBarMenuComponent.verifyTokenWalletView();
			sideBarMenuComponent.verifyHandCursorAction();
//			sideBarMenuComponent.verifyTokenWalletBackGroundColor(data.get("backgroundcolor"), data.get("border"));
			tokenWalletPage.verifyHeading(data.get("tokenPageHeading"));
			tokenWalletPage.clickTransfer(data.get("walletNumber"));
			tokenWalletPage.tokenWalletTransferPopup().verifyHeading(data.get("transferPopupHeading"));
			tokenWalletPage.tokenWalletTransferPopup().verifyDescription(data.get("transferPopupDescription"));
			tokenWalletPage.tokenWalletTransferPopup().fillAmount(data.get("amount"));
			tokenWalletPage.tokenWalletTransferPopup().clickTransferToDropDown();
			tokenWalletPage.tokenWalletTransferPopup().clickWallet3();
			tokenWalletPage.tokenWalletTransferPopup().clickNext();
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup()
					.verifyHeading(data.get("walletTransferPopupHeading"));
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().clickConfirm();
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup()
					.verifyHeading(data.get("verifyYourIdentityHeading"));
			Thread.sleep(2000);
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup()
					.authyComponent().fillInput(data.get("code"));
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup()
					.transactionSuccessfulPopup().verifyHeading(data.get("transactionSuccessfulHeading"));
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup()
					.transactionSuccessfulPopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWalletTransfer exception happend due to this " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testwalletTransferTransactionINAdmin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWalletTransfer exception happend due to this " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletTransferNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.sideBarMenuComponent().clickTokenwallet();
//			tokenWalletPage.sideBarMenuComponent().verifyTokenWalletCursorAction();
			sideBarMenuComponent.verifyTokenWalletView();
			sideBarMenuComponent.verifyHandCursorAction();
//			sideBarMenuComponent.verifyTokenWalletBackGroundColor(data.get("backgroundcolor"), data.get("border"));
//			sideBarMenuComponent.clickTokenwallet();
			tokenWalletPage.verifyHeading(data.get("tokenPageHeading"));
			tokenWalletPage.clickTransfer(data.get("walletNumber"));
			tokenWalletPage.tokenWalletTransferPopup().verifyHeading(data.get("transferPopupHeading"));
			tokenWalletPage.tokenWalletTransferPopup().navigationComponent().clickClose();
			tokenWalletPage.clickTransfer(data.get("walletNumber"));
			tokenWalletPage.tokenWalletTransferPopup().verifyHeading(data.get("transferPopupHeading"));
			tokenWalletPage.tokenWalletTransferPopup().fillAmount(data.get("amount"));
			tokenWalletPage.tokenWalletTransferPopup().clickTransferToDropDown();
			tokenWalletPage.tokenWalletTransferPopup().clickWallet1();
			tokenWalletPage.tokenWalletTransferPopup().clickNext();
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup()
					.verifyHeading(data.get("walletTransferPopupHeading"));
			tokenWalletPage.tokenWalletTransferPopup().navigationComponent().clickBack();
			tokenWalletPage.tokenWalletTransferPopup().verifyHeading(data.get("transferPopupHeading"));
			tokenWalletPage.tokenWalletTransferPopup().verifyAmount(data.get("expAmount"));
			Thread.sleep(1000);
			tokenWalletPage.tokenWalletTransferPopup().commonFunctions().clickOutSideElement();
			Thread.sleep(1000);
			tokenWalletPage.tokenWalletTransferPopup().clickNext();
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup()
					.verifyHeading(data.get("walletTransferPopupHeading"));
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().clickConfirm();
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup()
					.verifyHeading(data.get("verifyYourIdentityHeading"));
			Thread.sleep(1000);
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup()
					.navigationComponent().clickBack();
			Thread.sleep(1000);
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup()
					.verifyHeading(data.get("walletTransferPopupHeading"));
			Thread.sleep(1000);
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyAmount();
			Thread.sleep(1000);
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().clickConfirm();
			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup()
					.verifyHeading(data.get("verifyYourIdentityHeading"));
//			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup().authyComponent().fillInput(data.get("code"));
//			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup().transactionSuccessfulPopup().verifyHeading(data.get("transactionSuccessfulHeading"));
//			tokenWalletPage.tokenWalletTransferPopup().walletTransferPrieviewPopup().verifyYourIdentityPopup().transactionSuccessfulPopup().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setPassMessageInReport("testTokenWalletNavigationView failed due to this exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletTransferView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(4000);
			sideBarMenuComponent.verifyTokenWalletView();
			sideBarMenuComponent.verifyHandCursorAction();
//			sideBarMenuComponent.verifyTokenWalletBackGroundColor(data.get("backgroundcolor"), data.get("border"));
			sideBarMenuComponent.clickTokenwallet();
			sideBarMenuComponent.tokenWalletPage().verifyHeading(data.get("tokenPageHeading"));
			sideBarMenuComponent.tokenWalletPage().verifyTotalWalletBalanceView();
//			sideBarMenuComponent.tokenWalletPage().getWalletInfo();
			sideBarMenuComponent.tokenWalletPage().verifyTransfer();
			sideBarMenuComponent.tokenWalletPage().clickTransfer(data.get("walletNumber"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet view is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWalletTransferTransactionDetails(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.clickWallet(data.get("walletNum"));
			tokenWalletPage.filterComponent().clickFilter();
			tokenWalletPage.filterComponent().clickWalletTransferChkbx();
			tokenWalletPage.filterComponent().clickApplyFilter();
			tokenWalletPage.transactionDetailsComponent().verifyWalletType();
			tokenWalletPage.transactionDetailsComponent().verifyWalletTransferSubType();
			tokenWalletPage.transactionDetailsComponent().clickTransactions("Wallet", "Transfer");
			tokenWalletPage.transactionDetailsComponent().verifyLblTransactionDetailsHeading();
			tokenWalletPage.transactionDetailsComponent().verifyLblTransactionType(data.get("lblTransactionType"));
			tokenWalletPage.transactionDetailsComponent()
					.verifyLblWalletTransferCreatedDate(data.get("lblCreatedDate"));
			tokenWalletPage.transactionDetailsComponent().getWalletTransferTransactionType();
//			tokenWalletPage.transactionDetailsComponent().getWalletTransferCreatedDate();
			tokenWalletPage.transactionDetailsComponent().verifyAmountCategory(data.get("lblAmount"));
			tokenWalletPage.transactionDetailsComponent().verifyAmount();
			tokenWalletPage.transactionDetailsComponent().getWalletTransferProcessingFee();
			tokenWalletPage.transactionDetailsComponent().getWalletTransferTotalAmount();
			tokenWalletPage.transactionDetailsComponent().verifyLedgerInfoHeading();
			tokenWalletPage.transactionDetailsComponent().getLedgerReferenceID();
			tokenWalletPage.transactionDetailsComponent().getLedgerCordaID();
			tokenWalletPage.transactionDetailsComponent().getLedgerTransactionIPaddress();
			tokenWalletPage.transactionDetailsComponent().verifyRecipientInfoHeading();
			tokenWalletPage.transactionDetailsComponent().getRecipientAccountID();
			tokenWalletPage.transactionDetailsComponent().getRecipientName();
			tokenWalletPage.transactionDetailsComponent().getRecipientAccountIDaddress();
			tokenWalletPage.transactionDetailsComponent().getRecipientEmail();
			tokenWalletPage.transactionDetailsComponent().getRecipientPhone();
			tokenWalletPage.transactionDetailsComponent().verifySenderInfoHeading();
			tokenWalletPage.transactionDetailsComponent().getSenderAccountID();
			tokenWalletPage.transactionDetailsComponent().getSenderName();
			tokenWalletPage.transactionDetailsComponent().getSenderAccountAddress();
			tokenWalletPage.transactionDetailsComponent().getSenderEmail();
			tokenWalletPage.transactionDetailsComponent().getSenderPhone();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWalletTransferTransactionDetails is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWalletRecievedTransactionDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.clickSecondWallet(data.get("walletNum"));
			tokenWalletPage.filterComponent().clickFilter();
			tokenWalletPage.filterComponent().clickWalletTransferChkbx();
			tokenWalletPage.filterComponent().clickApplyFilter();
			tokenWalletPage.transactionDetailsComponent().verifyWalletType();
			tokenWalletPage.transactionDetailsComponent().verifyWalletRecievedSubType();
			tokenWalletPage.transactionDetailsComponent().clickTransactions("Wallet", "Received");
//			tokenWalletPage.transactionDetailsComponent()
//					.verifyLblTransactionDetailsHeading(data.get("transactionDetailsHeading"));
//			tokenWalletPage.transactionDetailsComponent().verifyLblTransactionType(data.get("lblTransactionType"));
//			tokenWalletPage.transactionDetailsComponent()
//					.verifyLblWalletTransferCreatedDate(data.get("lblCreatedDate"));
			tokenWalletPage.transactionDetailsComponent().getWalletReceivedTransactionType();
//			tokenWalletPage.transactionDetailsComponent().getWalletRecievedCreatedDate();
			tokenWalletPage.transactionDetailsComponent().verifyAmountCategory(data.get("lblAmount"));
			tokenWalletPage.transactionDetailsComponent().verifyAmount();
			tokenWalletPage.transactionDetailsComponent().getWalletTransferProcessingFee();
			tokenWalletPage.transactionDetailsComponent().getWalletTransferTotalAmount();
			tokenWalletPage.transactionDetailsComponent().verifyLedgerInfoHeading();
			tokenWalletPage.transactionDetailsComponent().getLedgerReferenceID();
			tokenWalletPage.transactionDetailsComponent().getLedgerCordaID();
			tokenWalletPage.transactionDetailsComponent().getLedgerTransactionIPaddress();
			tokenWalletPage.transactionDetailsComponent().verifyRecipientInfoHeading();
			tokenWalletPage.transactionDetailsComponent().getRecipientAccountID();
			tokenWalletPage.transactionDetailsComponent().getRecipientName();
			tokenWalletPage.transactionDetailsComponent().getRecipientAccountIDaddress();
			tokenWalletPage.transactionDetailsComponent().getRecipientEmail();
			tokenWalletPage.transactionDetailsComponent().getRecipientPhone();
			tokenWalletPage.transactionDetailsComponent().verifySenderInfoHeading();
			tokenWalletPage.transactionDetailsComponent().getSenderAccountID();
			tokenWalletPage.transactionDetailsComponent().getSenderName();
			tokenWalletPage.transactionDetailsComponent().getSenderAccountAddress();
			tokenWalletPage.transactionDetailsComponent().getSenderEmail();
			tokenWalletPage.transactionDetailsComponent().getSenderPhone();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWalletRecievedTransactionDetails is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			sideBarMenuComponent.tokenWalletActivityComponent().clickBuyTokens();
			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensNoPaymentPopup().clickOnAddNewPayment();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().verifyHeading();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnMXBankCheckBox();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickStart();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickMXBank();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().enterBankName(data.get("expBankName"));
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnBankName();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().enterUserName(data.get("expUserName"));
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().enterPassword(data.get("expPassword"));
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickNext();
			Thread.sleep(5000);
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickOnChecking();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().clickNext();
			sideBarMenuComponent.paymentMethodComponent().addBankAccountPopup().successFailureComponent()
					.verifyBankAddSuccesfulHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Bank Account failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankAccountTransactionDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.clickWallet(data.get("walletNum"));
			tokenWalletPage.filterComponent().clickFilter();
			tokenWalletPage.filterComponent().clickBuyTokenChkBx();
			tokenWalletPage.filterComponent().clickBankAccountChkbx();
			tokenWalletPage.filterComponent().clickCompletedChkbx();
			tokenWalletPage.filterComponent().clickApplyFilter();
//			if (tokenWalletPage.getTransactionsSize() == 0) {
//			tokenWalletPage.clickFirstTransaction();
			tokenWalletPage.transactionDetailsComponent().verifyBuyTokenType();
			tokenWalletPage.transactionDetailsComponent().verifyBuyTokenSubType();
			Thread.sleep(2000);
			tokenWalletPage.transactionDetailsComponent().clickTransactions("Buy Token", "Bank Account", "Completed");
			Thread.sleep(4000);
			tokenWalletPage.transactionDetailsComponent().verifyLblTransactionDetailsHeading();
			tokenWalletPage.transactionDetailsComponent().verifyLblTransactionType(data.get("lblTransactionType"));
			tokenWalletPage.transactionDetailsComponent().getBuyTokenTransactionType();
			tokenWalletPage.transactionDetailsComponent()
					.verifyLblTransactionSubType(data.get("lblTransactionSubtype"));
			tokenWalletPage.transactionDetailsComponent().getBuyTokenBankAccoutTransactionSubType();
			tokenWalletPage.transactionDetailsComponent().verifyLblReferenceID("lblReferenceID");
			tokenWalletPage.transactionDetailsComponent().getBuyTokenReferenceID();
			tokenWalletPage.transactionDetailsComponent().verifyLblDepositID(data.get("lblDepositID"));
			tokenWalletPage.transactionDetailsComponent().getBuyTokenDepositID();
			tokenWalletPage.transactionDetailsComponent().verifyLblBuyTokenCreatedDate();
			tokenWalletPage.transactionDetailsComponent().getBuyTokenCreatedDate();
			tokenWalletPage.transactionDetailsComponent().verifyAmountCategory(data.get("lblAmount"));
			tokenWalletPage.transactionDetailsComponent().verifyAmount();
			tokenWalletPage.transactionDetailsComponent().getBuyTokenPurchaseAmount();
			tokenWalletPage.transactionDetailsComponent().getBuyTokenProcessingFee();
			tokenWalletPage.transactionDetailsComponent().getBuyTokenTotalAmount();
			tokenWalletPage.transactionDetailsComponent().getBuyTokenAccountBalance();
			tokenWalletPage.transactionDetailsComponent().verifyBankAccountInfoHeading();
			tokenWalletPage.transactionDetailsComponent().verifyAccountName();
			tokenWalletPage.transactionDetailsComponent().getBankName();
			tokenWalletPage.transactionDetailsComponent().getBankAccountNumber();
			tokenWalletPage.transactionDetailsComponent().verifyActivityLog();
//			} else {
//				ExtentTestManager.setPassMessageInReport("No Filter Data Found");
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenInProgressTransactionDetails failed due to " + e);
		}

	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyTokenFailedTransactionDetails(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenWalletPage.clickWallet(data.get("walletNum"));
//			tokenWalletPage.filterComponent().clickFilter();
//			tokenWalletPage.filterComponent().clickBuyTokenChkBx();
//			tokenWalletPage.filterComponent().clickApplyFilter();
//			if (tokenWalletPage.getTransactionsSize() == 0) {
//				tokenWalletPage.transactionDetailsComponent().verifyBuyTokenType();
//				tokenWalletPage.transactionDetailsComponent().verifyBuyTokenSubType();
//				Thread.sleep(2000);
//				tokenWalletPage.transactionDetailsComponent().clickTransactions("Buy Token", "Bank Account", "Failed");
//				tokenWalletPage.transactionDetailsComponent().verifyLblTransactionDetailsHeading();
//				tokenWalletPage.transactionDetailsComponent().verifyLblTransactionType(data.get("lblTransactionType"));
//				tokenWalletPage.transactionDetailsComponent()
//						.verifyLblTransactionSubType(data.get("lblTransactionSubtype"));
//				tokenWalletPage.transactionDetailsComponent().verifyLblReferenceID(data.get("lblReferenceID"));
//				tokenWalletPage.transactionDetailsComponent().verifyLblDepositID(data.get("lblDepositID"));
//				tokenWalletPage.transactionDetailsComponent().verifyLblBuyTokenCreatedDate();
//				tokenWalletPage.transactionDetailsComponent().getBuyTokenTransactionType();
//				tokenWalletPage.transactionDetailsComponent().getBuyTokenBankAccoutTransactionSubType();
//				tokenWalletPage.transactionDetailsComponent().getReferenceId();
//				tokenWalletPage.transactionDetailsComponent().getDepositID();
////			tokenWalletPage.transactionDetailsComponent().getBuyTokenCreatedDate();
//				tokenWalletPage.transactionDetailsComponent().verifyAmountCategory(data.get("lblAmount"));
//				tokenWalletPage.transactionDetailsComponent().verifyAmount();
//				tokenWalletPage.transactionDetailsComponent().getBuyTokenPurchaseAmount();
//				tokenWalletPage.transactionDetailsComponent().getBuyTokenProcessingFee();
//				tokenWalletPage.transactionDetailsComponent().getBuyTokenTotalAmount();
//				tokenWalletPage.transactionDetailsComponent().getBuyTokenAccountBalance();
//				tokenWalletPage.transactionDetailsComponent().verifyBankAccountInfoHeading();
//				tokenWalletPage.transactionDetailsComponent().getNameOnAccount();
//				tokenWalletPage.transactionDetailsComponent().getBankName();
//				tokenWalletPage.transactionDetailsComponent().getBankAccountNumber();
//				tokenWalletPage.transactionDetailsComponent().verifyActivityLog();
//			} else {
//				ExtentTestManager.setPassMessageInReport("No Filter Data Found");
//			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testBuyTokenFailedTransactionDetails failed due to " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.clickTokenwallet();
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.verifyTokenWalletView();
			sideBarMenuComponent.verifyHandCursorAction();
//			sideBarMenuComponent.verifyTokenWalletBackGroundColor(data.get("backgroundcolor"), data.get("border"));
			Thread.sleep(5000);
			sideBarMenuComponent.tokenWalletPage().verifyHeading(data.get("heading"));
			sideBarMenuComponent.tokenWalletPage().verifyTotalWalletBalanceView();
			sideBarMenuComponent.tokenWalletPage().viewWalletsData();
			sideBarMenuComponent.tokenWalletPage().getWalletInfo();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet view is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletFiltersView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
//			sideBarMenuComponent.filterComponent().verifyFilterBackgroundColor(data.get("backGround color"),
//					data.get("border"));
			sideBarMenuComponent.filterComponent().verifyFilterCursorAction();
			sideBarMenuComponent.filterComponent().clickFilter();
			sideBarMenuComponent.filterComponent().verifyDateView();
			sideBarMenuComponent.filterComponent().verifyFromCYNview();
			sideBarMenuComponent.filterComponent().verifyToCYNview();
			sideBarMenuComponent.filterComponent().verifyTransactionTypeView();
			sideBarMenuComponent.filterComponent().verifyWithdrawChkbxView();
			sideBarMenuComponent.filterComponent().verifyBuyTokenChkbxView();
			sideBarMenuComponent.filterComponent().verifyWithdrawChkbxView();
			sideBarMenuComponent.filterComponent().verifyTransactionSubtypeView();
			sideBarMenuComponent.filterComponent().verifyBankAccountChkbxView();
			sideBarMenuComponent.filterComponent().verifyInstantPayChkbxView();
			sideBarMenuComponent.filterComponent().verifyCogentChkbxView();
			sideBarMenuComponent.filterComponent().verifyTransactionAmountView();
			sideBarMenuComponent.filterComponent().verifyReferenceIdView();
			sideBarMenuComponent.filterComponent().verifyTransactionStatusView();
			sideBarMenuComponent.filterComponent().verifyPendingChkbxView();
			sideBarMenuComponent.filterComponent().verifyCompletedChkbxView();
			sideBarMenuComponent.filterComponent().verifyCancelledChkbxView();
			sideBarMenuComponent.filterComponent().verifyInprogressChkbxView();
			sideBarMenuComponent.filterComponent().verifyFailedChkbxView();
			sideBarMenuComponent.filterComponent().verifyApplyFiltersView();
			sideBarMenuComponent.filterComponent().verifyResetFiltersView();
			sideBarMenuComponent.filterComponent().verifyTransactionDateClearView();
			sideBarMenuComponent.filterComponent().verify15CharIdView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Filters flow failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			sideBarMenuComponent.filterComponent().clickFilter();
			if (data.get("validateDate").equalsIgnoreCase("Yes")) {
				sideBarMenuComponent.filterComponent().calendarComponponent().clickStartDate();
				sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("startDate"));
				sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("endDate"));
				sideBarMenuComponent.filterComponent().verifyStartDate(data.get("expStartDate"));
				sideBarMenuComponent.filterComponent().verifyEndDate(data.get("expEndDate"));
			}
			if (data.get("validateTransactionType").equalsIgnoreCase("Yes")) {
				String[] checkBox = data.get("TransactionTypecheckBoxList").split(",");
				for (int i = 0; i <= checkBox.length; i++) {
					sideBarMenuComponent.filterComponent().clickCheckBox(checkBox[i]);
				}
			}
			if (data.get("validateTransactionSubType").equalsIgnoreCase("Yes")) {
				String[] checkBox = data.get("TransactionSubTypecheckboxList").split(",");
				for (int i = 0; i <= checkBox.length; i++) {
					sideBarMenuComponent.filterComponent().clickCheckBox(checkBox[i]);
				}
			}
			if (data.get("validateTransactionStatus").equalsIgnoreCase("Yes")) {
				String[] checkBox = data.get("TransactionStatus").split(",");
				for (int i = 0; i <= checkBox.length; i++) {
					sideBarMenuComponent.filterComponent().clickCheckBox(checkBox[i]);
				}

			}
			if (data.get("validateTransactionAmount").equalsIgnoreCase("Yes")) {
				sideBarMenuComponent.filterComponent().fillToCYN(data.get("toCYN"));
				sideBarMenuComponent.filterComponent().fillFromCYN(data.get("fromCYN"));
			}
			if (data.get("ValidateReferenceID").equalsIgnoreCase("Yes")) {
				sideBarMenuComponent.filterComponent().fill15CharReferenceId(data.get("referenceId"));
			}
			sideBarMenuComponent.filterComponent().clickApplyFilter();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Filters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletFiltersClearAllFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			sideBarMenuComponent.filterComponent().clickFilter();
			sideBarMenuComponent.filterComponent().scrollDownFilter();
			sideBarMenuComponent.filterComponent().calendarComponponent().clickStartDate();
			sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("startDate"));
			sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("endDate"));
			sideBarMenuComponent.filterComponent().clickWalletTransferChkbx();
			sideBarMenuComponent.filterComponent().clickBuyTokenChkBx();
			sideBarMenuComponent.filterComponent().clickWithdrawChkbx();
			sideBarMenuComponent.filterComponent().clickTransactionTypeClearAll();
			sideBarMenuComponent.filterComponent().clickBankAccountChkbx();
			sideBarMenuComponent.filterComponent().clickInstantPayChkbx();
			sideBarMenuComponent.filterComponent().clickCogentChkbx();
			sideBarMenuComponent.filterComponent().clickTrasactionSubtypeClearAll();
			sideBarMenuComponent.filterComponent().fillFromCYN(data.get("fromCYN"));
			sideBarMenuComponent.filterComponent().fillToCYN(data.get("toCYN"));
			sideBarMenuComponent.filterComponent().clickTransactionAmntClear();
			sideBarMenuComponent.filterComponent().fill15CharReferenceId(data.get("referenceId"));
			sideBarMenuComponent.filterComponent().clickReferenceIdClear();
			sideBarMenuComponent.filterComponent().clickPendingChkbx();
			sideBarMenuComponent.filterComponent().clickCompletedChkbx();
			sideBarMenuComponent.filterComponent().clickCancelledChkbx();
			sideBarMenuComponent.filterComponent().clickInprogressChkbx();
			sideBarMenuComponent.filterComponent().clickFailedChkbx();
			sideBarMenuComponent.filterComponent().clickTransactionStatusClearAll();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Token Wallet Filters Clear All  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletResetAllFiltersFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			sideBarMenuComponent.filterComponent().clickFilter();
			sideBarMenuComponent.filterComponent().calendarComponponent().clickStartDate();
			sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("startDate"));
			sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("endDate"));
			sideBarMenuComponent.filterComponent().clickWalletTransferChkbx();
			sideBarMenuComponent.filterComponent().clickBuyTokenChkBx();
			sideBarMenuComponent.filterComponent().clickWithdrawChkbx();
			sideBarMenuComponent.filterComponent().clickBankAccountChkbx();
			sideBarMenuComponent.filterComponent().clickInstantPayChkbx();
			sideBarMenuComponent.filterComponent().clickCogentChkbx();
			sideBarMenuComponent.filterComponent().fillToCYN(data.get("toCYN"));
			sideBarMenuComponent.filterComponent().fillFromCYN(data.get("fromCYN"));
			sideBarMenuComponent.filterComponent().fill15CharReferenceId(data.get("referenceId"));
			sideBarMenuComponent.filterComponent().clickPendingChkbx();
			sideBarMenuComponent.filterComponent().clickCompletedChkbx();
			sideBarMenuComponent.filterComponent().clickCancelledChkbx();
			sideBarMenuComponent.filterComponent().clickInprogressChkbx();
			sideBarMenuComponent.filterComponent().clickFailedChkbx();
			sideBarMenuComponent.filterComponent().clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet ResetAll Filters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletExportsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			sideBarMenuComponent.exportComponent().clickExport();
//			sideBarMenuComponent.exportComponent().verifyExportBackgroundColor(data.get("backgroundColor"),
//					data.get("border"));
			sideBarMenuComponent.exportComponent().verifyExportCursorAction();
			sideBarMenuComponent.exportComponent().verifyExportsSelectedOptionsView();
			sideBarMenuComponent.exportComponent().verifyDateRangeView();
			sideBarMenuComponent.exportComponent().verifyTodayView();
			sideBarMenuComponent.exportComponent().verifyYesterdayView();
			sideBarMenuComponent.exportComponent().verifyLast7DatsView();
			sideBarMenuComponent.exportComponent().verifyMonthtoDateView();
			sideBarMenuComponent.exportComponent().verifyLastMonthView();
			sideBarMenuComponent.exportComponent().verifyCustomDateRangeView();
			sideBarMenuComponent.exportComponent().verifyColumnsView();
			sideBarMenuComponent.exportComponent().verifyDefault10View();
			sideBarMenuComponent.exportComponent().clickCustom();
			sideBarMenuComponent.exportComponent().clickCustomDateRange();
			sideBarMenuComponent.exportComponent().verifyDateandTimeChkbxView();
			sideBarMenuComponent.exportComponent().verifyReferenceIDChkbxView();
			sideBarMenuComponent.exportComponent().verifyTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifySubTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifyDescriptionChkbxView();
			sideBarMenuComponent.exportComponent().verifyAmountChkbxView();
			sideBarMenuComponent.exportComponent().verifyBalanceChkbxView();
			sideBarMenuComponent.exportComponent().verifyStatusChkbxView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Exports View Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletExports(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			sideBarMenuComponent.exportComponent().clickExport();
			if (data.get("validate").equalsIgnoreCase("Today")) {
				sideBarMenuComponent.exportComponent().clickToday();
			}
			if (data.get("validate").equalsIgnoreCase("Yesterday")) {
				sideBarMenuComponent.exportComponent().clickYesterday();
			}
			if (data.get("validate").equalsIgnoreCase("Last 7 Days")) {
				sideBarMenuComponent.exportComponent().clickLast7Days();
			}
			if (data.get("validate").equalsIgnoreCase("Month to Date")) {
				sideBarMenuComponent.exportComponent().clickMonthtoDate();
			}
			if (data.get("validate").equalsIgnoreCase("Last Month")) {
				sideBarMenuComponent.exportComponent().clickLastMonth();
			}
			if (data.get("validate").equalsIgnoreCase("Custom Date Range")) {
				sideBarMenuComponent.exportComponent().clickCustomDateRange();
				sideBarMenuComponent.filterComponent().calendarComponponent().clickStartDate();
				sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("startDate"));
				sideBarMenuComponent.filterComponent().datePickerComponent().setDate(data.get("endDate"));
				sideBarMenuComponent.exportComponent().verifyStartDate(data.get("expStartDate"));
				sideBarMenuComponent.exportComponent().verifyEndDate(data.get("expEndDate"));
			}
			sideBarMenuComponent.exportComponent().clickPopupExport();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Exports failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletExportsCustom(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			sideBarMenuComponent.exportComponent().clickExport();
			sideBarMenuComponent.exportComponent().clickToday();
			sideBarMenuComponent.exportComponent().clickimgDropdown();
			sideBarMenuComponent.exportComponent().clickCustom();
//			sideBarMenuComponent.exportComponent().clickimgDropdown();
			sideBarMenuComponent.exportComponent().clickDateandTimeChkbx();
			sideBarMenuComponent.exportComponent().clickReferenceIDChkbx();
			sideBarMenuComponent.exportComponent().clickTypeChkbx();
			sideBarMenuComponent.exportComponent().clickSubTypeChkbx();
			sideBarMenuComponent.exportComponent().clickDescriptionChkbx();
			sideBarMenuComponent.exportComponent().clickAmountChkbx();
			sideBarMenuComponent.exportComponent().clickBalanceChkbx();
			sideBarMenuComponent.exportComponent().clickStatusChkbx();
			sideBarMenuComponent.exportComponent().clickReceiverChkbx();
			sideBarMenuComponent.exportComponent().clickSenderChkbx();
			sideBarMenuComponent.exportComponent().verifyDeselectAllView();
			sideBarMenuComponent.exportComponent().clickDeselectAll();
			sideBarMenuComponent.exportComponent().ClickSelectAllCheckboxes();
			sideBarMenuComponent.exportComponent().clickPopupExport();
			sideBarMenuComponent.exportComponent().verifyPopupHeading(data.get("heading"));
			sideBarMenuComponent.exportComponent().verifyPopupHeadingView();
			sideBarMenuComponent.exportComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Token Wallet Exports Custom is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletTransferTokens(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			// sideBarMenuComponent.tokenWalletActivityComponent().verifyTransferTokenBackgroundColor(data.get("backgroundcolor"),
			// data.get("border"));
			sideBarMenuComponent.tokenWalletActivityComponent().verifyTransferTokenCursorAction();
			sideBarMenuComponent.tokenWalletActivityComponent().clickTransferTokens();
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup().verifytxtAmountView();
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup().verifyTransferToView();
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup()
					.verifyAvailableBalanceView();
			// sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup().clickClose();
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup()
					.fillAmount(data.get("amount"));
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup()
					.clickTransferToDropDown();
//			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup().verifyWallet1View();
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup().clickWallet3();
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup().clickNext();
			sideBarMenuComponent.tokenWalletActivityComponent().walletTransferPrieviewPopup()
					.verifyWalletTransferPreviewPopupHeading(data.get("WalletTransferheading"));
			Thread.sleep(5000);
//			sideBarMenuComponent.tokenWalletActivityComponent().walletTransferPrieviewPopup().VerifyTransferFromView();
//			sideBarMenuComponent.tokenWalletActivityComponent().walletTransferPrieviewPopup().verifyTransferToView();
			sideBarMenuComponent.tokenWalletActivityComponent().walletTransferPrieviewPopup().clickConfirm();
			sideBarMenuComponent.tokenWalletActivityComponent().verifyYourIdentityPopup()
					.verifyHeading(data.get("verifyYourIdentityHeading"));
			sideBarMenuComponent.tokenWalletActivityComponent().verifyYourIdentityPopup().authyComponent()
					.fillInput(data.get("code"));
			sideBarMenuComponent.tokenWalletActivityComponent().transactionSuccessfulPopup()
					.verifyHeading(data.get("TransactionSuccessfullHeading"));
			sideBarMenuComponent.tokenWalletActivityComponent().transactionSuccessfulPopup().verifyDescriptionView();
			sideBarMenuComponent.tokenWalletActivityComponent().transactionSuccessfulPopup().VerifyReferenceIdView();
			sideBarMenuComponent.tokenWalletActivityComponent().transactionSuccessfulPopup()
					.verifyFromBalanceNameView();
			sideBarMenuComponent.tokenWalletActivityComponent().transactionSuccessfulPopup().verifyToBalanceNameView();
			sideBarMenuComponent.tokenWalletActivityComponent().transactionSuccessfulPopup().clickDone();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Token Wallet Transfer Tokens is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletTransferTokenWithInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.sideBarMenuComponent().clickTokenwallet();
//			tokenWalletPage.sideBarMenuComponent().verifyTokenWalletCursorAction();
			sideBarMenuComponent.verifyTokenWalletView();
			sideBarMenuComponent.verifyHandCursorAction();
			sideBarMenuComponent.tokenWalletPage().clickTokenWallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			sideBarMenuComponent.tokenWalletActivityComponent().clickTransferTokens();
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup()
					.fillAmount(data.get("amount"));
			Thread.sleep(2000);
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup().clickTab();
			sideBarMenuComponent.tokenWalletActivityComponent().tokenWalletTransferTokenPopup().insufficientFunds();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Token WalletTransfer Token Navigation failed due to Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletBuyTokensBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickTokenwallet();
			sideBarMenuComponent.tokenWalletPage().clickIndividualWalletsName();
			sideBarMenuComponent.tokenWalletActivityComponent().clickBuyTokens();
			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensPopup()
					.VerifyHeading(data.get("heading"));
//			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensPopup()
//					.VerifySubHeading(data.get("subHeading"));
//			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensPopup().buyCoyniTokensNoPaymentPopup()
//					.selectBankAccount();
//			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensPopup().clickNext();
//			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup()
//					.verifyHeading(data.get("heading"));
//				sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup()
//						.verifySubHeading();
//			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().clickNext();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().fillAmount(data.get("amount"));
//			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().clickChange();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().clickCovert();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().clickTab();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().clickNext();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.verifyHeading(data.get("previewHeading"));
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.verifyOrderPreviewForWithdraw();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.clickConfrim();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.authyComponent().fillInput(data.get("code"));
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().verifyReferenceID();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().clickReferenceID();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Token Wallet Buy Tokens is failed due to Exception" + e);
		}
	}

//	public void addBankAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensPopup()
//					.VerifyHeading(data.get("heading"));
//			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensPopup().clickAddnewpaymentmethod();
//			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensPopup().addNewPaymentMethodPopup()
//					.verifyHeading(data.get("addNewPaymenthdg"));
//			sideBarMenuComponent.tokenWalletActivityComponent().buyCoyniTokensPopup().addNewPaymentMethodPopup()
//					.clickBankAccount();
//			sideBarMenuComponent.bankAccountPage().clickImReady();
//			sideBarMenuComponent.bankAccountPage().verifyAddBankAccountView();
//			sideBarMenuComponent.bankAccountPage().verifyDoNotNavigateView();
//			Thread.sleep(15000);
//			sideBarMenuComponent.bankAccountPage().switchTab();
//			sideBarMenuComponent.bankAccountPage().fillBankName(data.get("bankName"));
//			Thread.sleep(1000);
//			sideBarMenuComponent.bankAccountPage().fillUserName(data.get("userName"));
//			sideBarMenuComponent.bankAccountPage().fillPassword(data.get("password1"));
//			Thread.sleep(5000);
//			sideBarMenuComponent.bankAccountPage().clickEnter();
//			Thread.sleep(10000);
//			// sideBarMenuComponent.bankAccountPage().clickBankNext();
//			sideBarMenuComponent.bankAccountPage().clickChkbxBank();
//			sideBarMenuComponent.bankAccountPage().clickEnter();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Token Wallet Buy Tokens is failed due to Exception" + e);
//		}
//
//	}
	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletWithdrawBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeadingWithdraw(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnExternalBankAccount();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup()
//					.verifyWithdrawToBankAccountHeading(data.get("popupHeading"));
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup()
//					.selectBankAccount();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup().clickNext();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup()
					.verifyWithdrawToBankAccountHeading(data.get("popupHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup()
					.fillAmount(data.get("amount"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup().clickOutside();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup()
//					.verifyDescription(data.get("description"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup().clickNext();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup()
					.verifyWithdrawToBankAccountHeading(data.get("popupHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup()
					.verifyOrderPreviewForWithdraw();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawToBankAccountPopup().clickConfrim();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.authyComponent().fillInput(data.get("code"));
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().verifyReferenceID();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().clickReferenceID();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test token wallet withdraw bank account failed due to Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletWithdrawCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnCogentAccount();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.verifyHeading(data.get("cogentAccountHeading"));
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoSignetAccountPopup()
//					.selectSignetAccount();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoSignetAccountPopup().clickNext();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.fillAmount(data.get("amount"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.clickOutside();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoSignetAccountPopup()
//					.verifyDescription(data.get("description"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup().clickNext();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.verifyHeading(data.get("popupHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.verifyOrderPreviewForWithdraw();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.clickConfirm();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.authyComponent().fillInput(data.get("code"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().transactionInProgessPopup()
					.verifyHeading(data.get("transactionInProgHdg"));
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().verifyReferenceID();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().clickReferenceID();
			sideBarMenuComponent.tokenWalletActivityComponent().buyTokensPaymentPopup().orderPreviewPopup()
					.successFailureComponent().clickDone();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Token Wallet Withdraw cogent Account failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletWithdrawCogentAccountTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//					.verifyCogentHeading(data.get("cogentAccountHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblDesc(data.get("cogentDescription"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnCogentAccount();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.verifyHeading(data.get("cogentAccountHeading"));
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
//					.selectSignetAccount();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup().clickNext();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
//				.verifyWithdrawHeading(data.get("withdrawcogentAccountHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.fillAmount(data.get("amount"));
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.clickConverter();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoSignetAccountPopup()
//					.fillTransactionDesc(data.get("description"));
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
//					.verifyNote(data.get("note"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup().clickNext();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.verifyOrderPreviewForWithdraw();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.clickConfirm();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyYourIdentityPopup().authyComponent()
					.fillInput(data.get("code"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().transactionInProgessPopup()
					.verifyHeading(data.get("transactionInProgHdg"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().transactionInProgessPopup()
					.verifyReferenceIDview();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().transactionInProgessPopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test token Wallet withdraw cogent Account Transactions failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletWithdrawCogentAccountTransactionsInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnCogentAccount();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.verifyHeading(data.get("cogentAccountHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.verifyHeading(data.get("cogentAccountHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.fillAmount(data.get("amount"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.clickConverter();
			Thread.sleep(2000);
			Thread.sleep(1000);
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.InvalidMessage();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test token Wallet withdraw Cogent Account Transactions failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteTokenWalletWithdrawCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnCogentAccount();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.verifyHeading(data.get("cogentAccountHeading"));
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoSignetAccountPopup()
//					.selectSignetAccount();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup().clickDelete();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().removePaymentMethodPopup()
					.verifyRemoveHeading(data.get("removeHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().removePaymentMethodPopup().clickOnRemove();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().successFailureComponent()
					.verifyPaymnetRemovedSuccessfulHeading(data.get("removeSuccessfullHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().successFailureComponent()
					.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test delete token Wallet withdraw cogent Account Transactions failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletWithdrawToUsdViaInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnInstantPay();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//					.withdrawviaInstantPayPopup().clickDebitCard(data.get("last4digits"));
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//					.withdrawviaInstantPayPopup().clickOnNext();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().verifyLabelHeading(data.get("instantPayHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().enterAmount(data.get("amount"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.clickConverter();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().txtMessage(data.get("message"));
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickTab();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickOnNext();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//			.withdrawviaInstantPayPopup().clickOnNext();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().orderPreviewPopup().verifyOrderPreviewForWithdraw();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().orderPreviewPopup().clickConfrim();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().authyComponent().fillInput(data.get("code"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().transactionInProgessPopup()
					.verifyHeading(data.get("transactionInProgHdg"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().orderPreviewPopup().successFailureComponent().verifyReferenceID();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().orderPreviewPopup().successFailureComponent().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test withdraw via Instant Pay failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithInvalidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnInstantPay();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//					.withdrawviaInstantPayPopup().clickDebitCard(data.get("last4digits"));
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//					.withdrawviaInstantPayPopup().clickOnNext();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().enterAmount(data.get("amount"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickTab();

			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().InvalidMessage();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithInvalidDetails failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardToInstantPay(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnInstantPay();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().verifyLabelHeading(data.get("instantPayHeading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickOnAddNewDebitCard();
			testWithdrawAddDebitCard(strParams, "Debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddNewDebitCard failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawViaInstantPayDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnInstantPay();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickOnChangeLink();
			BusinessSettingsTest.testEditCard(strParams, "debit");

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" testWithdrawViaInstantPayDeleteCard failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawViaInstantPayEditDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnInstantPay();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//					.withdrawviaInstantPayPopup().clickOnChangeLink();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickDebitCard(data.get("last4digits"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickEdit();
			BusinessSettingsTest.testEditCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" testWithdrawViaInstantPayEditDebitCard failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawInProgressBankAccountTransactionDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.clickWallet(data.get("walletNum"));
			tokenWalletPage.filterComponent().clickFilter();
			tokenWalletPage.filterComponent().clickWithdrawChkbx();
			tokenWalletPage.filterComponent().clickBankAccountChkbx();
			tokenWalletPage.filterComponent().clickInprogressChkbx();
			tokenWalletPage.filterComponent().clickApplyFilter();
			tokenWalletPage.transactionDetailsComponent().verifyWithdrawType();
			tokenWalletPage.transactionDetailsComponent().verifyWithdrawSubType();
			Thread.sleep(2000);
			tokenWalletPage.transactionDetailsComponent().clickTransactions("Withdraw", "Bank Account", "In Progress");
			tokenWalletPage.transactionDetailsComponent().verifyLblTransactionDetailsHeading();
			tokenWalletPage.transactionDetailsComponent().verifyLblTransactionType(data.get("lblTransactionType"));
//			tokenWalletPage.transactionDetailsComponent()
//					.verifyLblTransactionSubType(data.get("lblTransactionSubtype"));
//			tokenWalletPage.transactionDetailsComponent().verifyLblReferenceID(data.get("lblReferenceID"));
//			tokenWalletPage.transactionDetailsComponent().verifyLblWithdrawId(data.get("lblWithdrawID"));
//			tokenWalletPage.transactionDetailsComponent().verifyLblWithdrawCreatedDate();
			tokenWalletPage.transactionDetailsComponent().getWithdrawTransactionType();
			tokenWalletPage.transactionDetailsComponent().getWithdrawBankAccountTransactionSubType();
			tokenWalletPage.transactionDetailsComponent().getWithdrawReferenceID();
			tokenWalletPage.transactionDetailsComponent().getWithdrawDepositID();
//			tokenWalletPage.transactionDetailsComponent().getWithdrawCreatedDate();
			tokenWalletPage.transactionDetailsComponent().verifyAmountCategory(data.get("lblAmount"));
			tokenWalletPage.transactionDetailsComponent().verifyAmount();
			tokenWalletPage.transactionDetailsComponent().getWithdrawAmount();
			tokenWalletPage.transactionDetailsComponent().getProcessingFee();
			tokenWalletPage.transactionDetailsComponent().getTotalAmount();
			tokenWalletPage.transactionDetailsComponent().getWithdrawAccountBalance();
			tokenWalletPage.transactionDetailsComponent().verifyBankAccountInfoHeading();
			tokenWalletPage.transactionDetailsComponent().getNameOnAccount();
			tokenWalletPage.transactionDetailsComponent().getBankName();
			tokenWalletPage.transactionDetailsComponent().getBankAccountNumber();
			tokenWalletPage.transactionDetailsComponent().verifyActivityLogHeading();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdrawBankAccountInProgressTransactionDetails failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawFailedBankAccountTransactionDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.clickWallet(data.get("walletNum"));
			tokenWalletPage.filterComponent().clickFilter();
			tokenWalletPage.filterComponent().clickWithdrawChkbx();
			tokenWalletPage.filterComponent().clickBankAccountChkbx();
			tokenWalletPage.filterComponent().clickFailedChkbx();
			tokenWalletPage.filterComponent().clickApplyFilter();
			Thread.sleep(3000);
			if (tokenWalletPage.getTransactionsSize() == 0) {
				tokenWalletPage.transactionDetailsComponent().verifyWithdrawType();
				tokenWalletPage.transactionDetailsComponent().verifyWithdrawSubType();
				Thread.sleep(2000);
				tokenWalletPage.transactionDetailsComponent().clickTransactions("Withdraw", "Bank Account", "Failed");
//			tokenWalletPage.transactionDetailsComponent()
//					.verifyLblTransactionDetailsHeading(data.get("transactionDetailsHeading"));
				tokenWalletPage.transactionDetailsComponent().verifyLblTransactionType(data.get("lblTransactionType"));
				tokenWalletPage.transactionDetailsComponent()
						.verifyLblTransactionSubType(data.get("lblTransactionSubtype"));
				tokenWalletPage.transactionDetailsComponent().verifyLblReferenceID(data.get("lblReferenceID"));
				tokenWalletPage.transactionDetailsComponent().verifyLblWithdrawId(data.get("lblWithdrawID"));
//			tokenWalletPage.transactionDetailsComponent().verifyLblWithdrawCreatedDate();
				tokenWalletPage.transactionDetailsComponent().getWithdrawTransactionType();
				tokenWalletPage.transactionDetailsComponent().getWithdrawBankAccountTransactionSubType();
				tokenWalletPage.transactionDetailsComponent().getReferenceId();
//			tokenWalletPage.transactionDetailsComponent().getWithdrawCreatedDate();
				tokenWalletPage.transactionDetailsComponent().verifyAmountCategory(data.get("lblAmount"));
				tokenWalletPage.transactionDetailsComponent().verifyAmount();
				tokenWalletPage.transactionDetailsComponent().getWithdrawAmount();
				tokenWalletPage.transactionDetailsComponent().getProcessingFee();
				tokenWalletPage.transactionDetailsComponent().getTotalAmount();
				tokenWalletPage.transactionDetailsComponent().getWithdrawAccountBalance();
				tokenWalletPage.transactionDetailsComponent().verifyBankAccountInfoHeading();
				tokenWalletPage.transactionDetailsComponent().getNameOnAccount();
				tokenWalletPage.transactionDetailsComponent().getBankName();
				tokenWalletPage.transactionDetailsComponent().getBankAccountNumber();
				tokenWalletPage.transactionDetailsComponent().verifyActivityLogHeading();
			} else {
				ExtentTestManager.setPassMessageInReport("No Transactions FoundS");
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdarwBankAccountFailedTransactionDetails failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawCancelledBankAccountTransactionDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.clickWallet(data.get("walletNum"));
			tokenWalletPage.filterComponent().clickFilter();
			tokenWalletPage.filterComponent().clickWithdrawChkbx();
			tokenWalletPage.filterComponent().clickBankAccountChkbx();
			tokenWalletPage.filterComponent().clickCancelledChkbx();
			tokenWalletPage.filterComponent().clickApplyFilter();
			if (tokenWalletPage.getTransactionsSize() == 0) {
				tokenWalletPage.transactionDetailsComponent().verifyWithdrawType();
				tokenWalletPage.transactionDetailsComponent().verifyWithdrawSubType();
				Thread.sleep(2000);
				tokenWalletPage.transactionDetailsComponent().clickTransactions("Withdraw", "Bank Account",
						"Cancelled");
				Thread.sleep(5000);
				tokenWalletPage.transactionDetailsComponent().verifyLblTransactionDetailsHeading();
				tokenWalletPage.transactionDetailsComponent().verifyLblTransactionType(data.get("lblTransactionType"));
				tokenWalletPage.transactionDetailsComponent()
						.verifyLblTransactionSubType(data.get("lblTransactionSubtype"));
				tokenWalletPage.transactionDetailsComponent().verifyLblReferenceID(data.get("lblReferenceID"));
				tokenWalletPage.transactionDetailsComponent().verifyLblWithdrawId(data.get("lblWithdrawID"));
//			tokenWalletPage.transactionDetailsComponent().verifyLblWithdrawCreatedDate();
				tokenWalletPage.transactionDetailsComponent().getWithdrawTransactionType();
				tokenWalletPage.transactionDetailsComponent().getWithdrawBankAccountTransactionSubType();
				tokenWalletPage.transactionDetailsComponent().getWithdrawReferenceID();
				tokenWalletPage.transactionDetailsComponent().getWithdrawDepositID();
				tokenWalletPage.transactionDetailsComponent().verifyAmountCategory(data.get("lblAmount"));
				tokenWalletPage.transactionDetailsComponent().verifyAmount();
				tokenWalletPage.transactionDetailsComponent().getWithdrawAmount();
				tokenWalletPage.transactionDetailsComponent().getProcessingFee();
				tokenWalletPage.transactionDetailsComponent().getTotalAmount();
				tokenWalletPage.transactionDetailsComponent().getWithdrawAccountBalance();
				tokenWalletPage.transactionDetailsComponent().verifyBankAccountInfoHeading();
				tokenWalletPage.transactionDetailsComponent().getNameOnAccount();
				tokenWalletPage.transactionDetailsComponent().getBankName();
				tokenWalletPage.transactionDetailsComponent().getBankAccountNumber();
				tokenWalletPage.transactionDetailsComponent().verifyActivityLogHeading();
			} else {
				ExtentTestManager.setPassMessageInReport("No Transactions Found");
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdarwBankAccountCancelledTransactionDetails failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawCogentTransactionDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.clickWallet(data.get("walletNum"));
			tokenWalletPage.filterComponent().clickFilter();
			tokenWalletPage.filterComponent().clickWithdrawChkbx();
			tokenWalletPage.filterComponent().clickCogentChkbx();
			tokenWalletPage.filterComponent().clickFailedChkbx();
			tokenWalletPage.filterComponent().clickApplyFilter();
			Thread.sleep(3000);
			tokenWalletPage.transactionDetailsComponent().verifyWithdrawType();
			tokenWalletPage.transactionDetailsComponent().verifyWithdrawCogentSubType();
			Thread.sleep(2000);
//			tokenWalletPage.transactionDetailsComponent().clickFirstTransactions();
			tokenWalletPage.transactionDetailsComponent().clickTransactions("Withdraw", "Cogent", "Failed");
//			tokenWalletPage.transactionDetailsComponent()
//					.verifyLblTransactionDetailsHeading(data.get("transactionDetailsHeading"));
			tokenWalletPage.transactionDetailsComponent().verifyLblTransactionType(data.get("lblTransactionType"));
			tokenWalletPage.transactionDetailsComponent().getWithdrawTransactionType();
			tokenWalletPage.transactionDetailsComponent()
					.verifyLblTransactionSubType(data.get("lblTransactionSubtype"));
			tokenWalletPage.transactionDetailsComponent().getWithdrawCogentAccountTransactionSubType();
			tokenWalletPage.transactionDetailsComponent().verifyLblReferenceID(data.get("lblReferenceID"));
			tokenWalletPage.transactionDetailsComponent().getReferenceId();
//			stokenWalletPage.transactionDetailsComponent().verifyLblWithdrawId(data.get("lblWithdrawID"));
//			tokenWalletPage.transactionDetailsComponent().getWithdrawCreatedDate();
			tokenWalletPage.transactionDetailsComponent().verifyAmountCategory(data.get("lblAmount"));
			tokenWalletPage.transactionDetailsComponent().verifyAmount();
			tokenWalletPage.transactionDetailsComponent().getWithdrawAmount();
			tokenWalletPage.transactionDetailsComponent().getProcessingFee();
			tokenWalletPage.transactionDetailsComponent().getTotalAmount();
			tokenWalletPage.transactionDetailsComponent().getWithdrawAccountBalance();
			tokenWalletPage.transactionDetailsComponent().verifyRecipientInfoHeading();
			tokenWalletPage.transactionDetailsComponent().getNameOnAccount();
			tokenWalletPage.transactionDetailsComponent().getBankName();
			tokenWalletPage.transactionDetailsComponent().getBankAccountNumber();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdarwBankAccountFailedTransactionDetails failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.transactionListComponent().clickFilterButton();
			tokenWalletPage.transactionListComponent().filterComponent().calendarComponponent().clickStartDate();
			tokenWalletPage.transactionListComponent().filterComponent().datePickerComponent()
					.setDate(data.get("startDate"));
			tokenWalletPage.transactionListComponent().filterComponent().datePickerComponent()
					.setDate(data.get("endDate"));
			Thread.sleep(5000);
			tokenWalletPage.transactionListComponent().filterComponent().scroolDownToElement();
			tokenWalletPage.transactionListComponent().filterComponent().clickCheckBox(data.get("checkBox"));
			tokenWalletPage.transactionListComponent().filterComponent().fillFromAmount(data.get("fromAmount"));
			tokenWalletPage.transactionListComponent().filterComponent().fillToAmount(data.get("toAmount"));
			tokenWalletPage.transactionListComponent().filterComponent().fillReferenceID(data.get("referenceID"));
			tokenWalletPage.transactionListComponent().filterComponent().clickCheckBox(data.get("checkBox"));
			tokenWalletPage.transactionListComponent().filterComponent().clickApplyFilters();
			Thread.sleep(3000);
			tokenWalletPage.transactionListComponent().filterComponent().getNoRecordsFound();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	public static void testDeleteCardForInstantPay(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			HomePage homePage = new HomePage();
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//					.verifylblHeading(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().mouseHoverOnDebitCard(data.get("last4digits"));
			Thread.sleep(3000);
//			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
//					.withdrawviaInstantPayPopup().clickDeleteCardIcon();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickDelete();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().removePaymentMethodPopup().clickOnRemove();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	public static void testEditCardforInstantPay(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			HomePage homePage = new HomePage();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().mouseHoverOnDebitCard(data.get("last4digits"));
			Thread.sleep(3000);
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.withdrawviaInstantPayPopup().clickEdit();
			BusinessSettingsTest.testEditCard(strParams, "debit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	public static void testWithdrawAddDebitCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			BusinessProfilePage apiAdminProfilePage = new BusinessProfilePage();
			Thread.sleep(3000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
//			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
//					.validateCardBrand(data.get("cardType"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickNext();
			Thread.sleep(4000);
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			apiAdminProfilePage.paymentMethodComponent().cardAddedSuccessfullyPopup().navigationComponent()
					.clickClose();

////		Thread.sleep(3000);
//		apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent().switchToWindow();
//		apiAdminProfilePage.paymentMethodComponent().preAuthorizationPopup().verifyHeading();
//		apiAdminProfilePage.paymentMethodComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
//		apiAdminProfilePage.paymentMethodComponent().preAuthorizationPopup().clickOnVerify();
//		apiAdminProfilePage.paymentMethodComponent().preAuthorizationPopup().successFailureComponent()
//				.navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTokensTransferredActivityDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickdrpdwnTokenWalletActivity();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickMonthToDate();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickTransferedDetails();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickExport();
			sideBarMenuComponent.exportComponent().verifyExportCursorAction();
			sideBarMenuComponent.exportComponent().verifyExportsSelectedOptionsView();
			sideBarMenuComponent.exportComponent().verifyDateRangeView();
			sideBarMenuComponent.exportComponent().verifyTodayView();
			sideBarMenuComponent.exportComponent().verifyYesterdayView();
			sideBarMenuComponent.exportComponent().verifyLast7DatsView();
			sideBarMenuComponent.exportComponent().verifyMonthtoDateView();
			sideBarMenuComponent.exportComponent().verifyLastMonthView();
			sideBarMenuComponent.exportComponent().verifyCustomDateRangeView();
			sideBarMenuComponent.exportComponent().verifyColumnsView();
			sideBarMenuComponent.exportComponent().verifyDefault10View();
			sideBarMenuComponent.exportComponent().clickCustom();
//			sideBarMenuComponent.exportComponent().clickCustomDateRange();
			sideBarMenuComponent.exportComponent().verifyDateandTimeChkbxView();
			sideBarMenuComponent.exportComponent().verifyReferenceIDChkbxView();
			sideBarMenuComponent.exportComponent().verifyTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifySubTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifyDescriptionChkbxView();
			sideBarMenuComponent.exportComponent().verifyAmountChkbxView();
			sideBarMenuComponent.exportComponent().verifyBalanceChkbxView();
			sideBarMenuComponent.exportComponent().verifyStatusChkbxView();
			sideBarMenuComponent.exportComponent().clickPopupExport();
			sideBarMenuComponent.exportComponent().exportBeingPrepared();
			sideBarMenuComponent.exportComponent().exportBeingPrepareddescription();
			sideBarMenuComponent.exportComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test TokensTransferredActivityDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokensPurchasedActivityDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickdrpdwnTokenWalletActivity();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickLastMonth();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickPurchasedDetails();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickExport();
			sideBarMenuComponent.exportComponent().verifyExportCursorAction();
			sideBarMenuComponent.exportComponent().verifyExportsSelectedOptionsView();
			sideBarMenuComponent.exportComponent().verifyDateRangeView();
			sideBarMenuComponent.exportComponent().verifyTodayView();
			sideBarMenuComponent.exportComponent().verifyYesterdayView();
			sideBarMenuComponent.exportComponent().verifyLast7DatsView();
			sideBarMenuComponent.exportComponent().verifyMonthtoDateView();
			sideBarMenuComponent.exportComponent().verifyLastMonthView();
			sideBarMenuComponent.exportComponent().verifyCustomDateRangeView();
			sideBarMenuComponent.exportComponent().verifyColumnsView();
			sideBarMenuComponent.exportComponent().verifyDefault10View();
			sideBarMenuComponent.exportComponent().clickCustom();
//			sideBarMenuComponent.exportComponent().clickCustomDateRange();
			sideBarMenuComponent.exportComponent().verifyDateandTimeChkbxView();
			sideBarMenuComponent.exportComponent().verifyReferenceIDChkbxView();
			sideBarMenuComponent.exportComponent().verifyTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifySubTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifyDescriptionChkbxView();
			sideBarMenuComponent.exportComponent().verifyAmountChkbxView();
			sideBarMenuComponent.exportComponent().verifyBalanceChkbxView();
			sideBarMenuComponent.exportComponent().verifyStatusChkbxView();
			sideBarMenuComponent.exportComponent().clickPopupExport();
			sideBarMenuComponent.exportComponent().exportBeingPrepared();
			sideBarMenuComponent.exportComponent().exportBeingPrepareddescription();
			sideBarMenuComponent.exportComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test Tokens purchased ActivityDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokensWithdrawnActivityDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickdrpdwnTokenWalletActivity();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickMonthToDate();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawnDetails();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickExport();
			sideBarMenuComponent.exportComponent().verifyExportsSelectedOptionsView();
			sideBarMenuComponent.exportComponent().verifyDateRangeView();
			sideBarMenuComponent.exportComponent().verifyTodayView();
			sideBarMenuComponent.exportComponent().verifyYesterdayView();
			sideBarMenuComponent.exportComponent().verifyLast7DatsView();
			sideBarMenuComponent.exportComponent().verifyMonthtoDateView();
			sideBarMenuComponent.exportComponent().verifyLastMonthView();
			sideBarMenuComponent.exportComponent().verifyCustomDateRangeView();
			sideBarMenuComponent.exportComponent().verifyColumnsView();
			sideBarMenuComponent.exportComponent().verifyDefault10View();
			sideBarMenuComponent.exportComponent().clickCustom();
//			sideBarMenuComponent.exportComponent().clickCustomDateRange();
			sideBarMenuComponent.exportComponent().verifyDateandTimeChkbxView();
			sideBarMenuComponent.exportComponent().verifyReferenceIDChkbxView();
			sideBarMenuComponent.exportComponent().verifyTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifySubTypeChkbxView();
			sideBarMenuComponent.exportComponent().verifyDescriptionChkbxView();
			sideBarMenuComponent.exportComponent().verifyAmountChkbxView();
			sideBarMenuComponent.exportComponent().verifyBalanceChkbxView();
			sideBarMenuComponent.exportComponent().verifyStatusChkbxView();
			sideBarMenuComponent.exportComponent().clickDeselectAll();
			sideBarMenuComponent.exportComponent().clickPopupExport();
			sideBarMenuComponent.exportComponent().exportBeingPrepared();
			sideBarMenuComponent.exportComponent().exportBeingPrepareddescription();
			sideBarMenuComponent.exportComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test Tokens Withdarwn ActivityDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTokenWalletAddCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickTokenwallet();
			homePage.sideBarMenuComponent().tokenWalletPage().clickIndividualWalletsName();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().verifyWithdrawtoUsdCursorAction();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().clickWithdrawToUSD();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.verifylblHeadingWithdraw(data.get("heading"));
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawCoyniToUSDPopup()
					.clickOnCogentAccount();
			homePage.sideBarMenuComponent().tokenWalletActivityComponent().withdrawtoCogentAccountPopup()
					.clickAddNewCogentAccount();
			testCogentAccount(strParams);

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test TokensTransferredActivityDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
//			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
//					.addNewPaymentMethodPopup().addNewSignetAccountPopup().verifyPageHeading(data.get("heading"));
			homePage.sideBarMenuComponent().paymentMethodComponent().addNewPaymentMethodPopup()
					.addNewcogentAccountPopup().fillName(data.get("newCogentAccount"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().fillCogentWalletId(data.get("walletID"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.fillCity(data.get("city"));
			Thread.sleep(500);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.selectState(data.get("state"));
			Thread.sleep(1000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().clickSave();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().successFailureComponent()
					.verifySignetSucessfulHeading(data.get("heading1"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().successFailureComponent()
					.verifySignetSucessfulHeading2(data.get("heading2"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewcogentAccountPopup().successFailureComponent()
					.navigationComponent().clickClose();
		} catch (

		Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}

	}

}
