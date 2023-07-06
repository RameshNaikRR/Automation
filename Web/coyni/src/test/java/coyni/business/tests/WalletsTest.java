package coyni.business.tests;

import java.util.Map;

import org.junit.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import coyni.business.components.SideBarMenuComponent;
import coyni.business.pages.WalletsPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class WalletsTest {
	SideBarMenuComponent sideBarMenuComponent;
	WalletsPage walletpage;

	@BeforeTest
	public void init() {

		sideBarMenuComponent = new SideBarMenuComponent();
		walletpage = new WalletsPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testWalletDashboardview(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.verifyWalletsHeading(data.get("walletHeading"));
			walletpage.verifyTotalWalletBalance();
			walletpage.verifyAvailableFunds();
			walletpage.copyWallet();
			walletpage.clickDepositFunds();
			walletpage.close();
			walletpage.clickTransfer();
			walletpage.close();
			walletpage.clickWithdraw();
			walletpage.close();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("wallet Dashboard view failed due to Exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDepositFunds(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickDepositFunds();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("deposit funds failed due to Exception " + e);

		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTransferFunds(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickTransfer();
			walletpage.selectTransferTypePopup().clickWalletTransfer(data.get("background"), data.get("border"));
			walletpage.selectTransferTypePopup().verifySelectTransferTypeHeading(data.get("transferHeading"));
			walletpage.selectTransferTypePopup().walletTransferPopup()
					.verifyWalletTransferHeading(data.get("transferHeading"));
			walletpage.selectTransferTypePopup().walletTransferPopup().verifyAvailableBalance();
			walletpage.selectTransferTypePopup().walletTransferPopup().fillAmount(data.get("amount"));
			walletpage.selectTransferTypePopup().walletTransferPopup().selectWallet();
			walletpage.selectTransferTypePopup().walletTransferPopup().fillNote(data.get("note"));
			walletpage.selectTransferTypePopup().walletTransferPopup().clickNext();
			walletpage.selectTransferTypePopup().walletTransferPopup().walletTransferSummaryPopup().verifyAmount();
			walletpage.selectTransferTypePopup().walletTransferPopup().walletTransferSummaryPopup()
					.verifyTransferAmount();
			walletpage.selectTransferTypePopup().walletTransferPopup().walletTransferSummaryPopup()
					.transactionDetails();
			walletpage.selectTransferTypePopup().walletTransferPopup().walletTransferSummaryPopup().clickConfirm();
			walletpage.selectTransferTypePopup().walletTransferPopup().walletTransferSummaryPopup().authyComponent()
					.fillInput(data.get("code"));
			walletpage.selectTransferTypePopup().walletTransferPopup().walletTransferSummaryPopup().authyComponent()
					.transferCompletedPopup().verifyTransferCompletedHeading(data.get("transferCompletedHeading"));
			walletpage.selectTransferTypePopup().walletTransferPopup().walletTransferSummaryPopup().authyComponent()
					.transferCompletedPopup().viewStatus();
			walletpage.selectTransferTypePopup().walletTransferPopup().walletTransferSummaryPopup().authyComponent()
					.transferCompletedPopup().clickViewTransaction();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Transfer funds failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTransferFundsInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickTransfer();
			walletpage.selectTransferTypePopup().clickWalletTransfer(data.get("background"), data.get("border"));
			walletpage.selectTransferTypePopup().verifySelectTransferTypeHeading(data.get("transferHeading"));
			walletpage.selectTransferTypePopup().walletTransferPopup()
					.verifyWalletTransferHeading(data.get("transferHeading"));
			walletpage.selectTransferTypePopup().walletTransferPopup().verifyAvailableBalance();
			walletpage.selectTransferTypePopup().walletTransferPopup().fillAmount(data.get("amount"));
			if (!data.get("errMsg").isEmpty()) {
				Thread.sleep(1000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("color"),
						data.get("amount"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Transfer funds failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSelectB2BTransfer(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickTransfer();
			walletpage.selectTransferTypePopup().clickB2BTransfer(data.get("background"), data.get("border"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().verifyB2BTransferHeading(data.get("b2bHeading"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().fillAmount(data.get("amount"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().verifyAvailableBalance();
			walletpage.selectTransferTypePopup().b2bTransferPopup().fillRecipientWalletNumber(data.get("walletNum"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().fillNote(data.get("note"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().clickUpload();
			walletpage.selectTransferTypePopup().b2bTransferPopup().clickNext();
			walletpage.selectTransferTypePopup().b2bTransferPopup().b2bTransferSummaryPopup()
					.verifyB2BTransferSummaryHeading(data.get("b2bsummaryHeading"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().b2bTransferSummaryPopup().verifyAmount();
			walletpage.selectTransferTypePopup().b2bTransferPopup().b2bTransferSummaryPopup().verifyProcessingFee();
			walletpage.selectTransferTypePopup().b2bTransferPopup().b2bTransferSummaryPopup().verifyTotal();
			walletpage.selectTransferTypePopup().b2bTransferPopup().b2bTransferSummaryPopup().clickConfirm();
			walletpage.selectTransferTypePopup().b2bTransferPopup().b2bTransferSummaryPopup().authyComponent()
					.fillInput(data.get("code"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().b2bTransferSummaryPopup().authyComponent()
					.transferCompletedPopup().viewStatus();
			walletpage.selectTransferTypePopup().b2bTransferPopup().b2bTransferSummaryPopup().authyComponent()
					.transferCompletedPopup().clickViewTransaction();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("B2BTransfer funds failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSelectB2BTransferInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickTransfer();
			walletpage.selectTransferTypePopup().clickB2BTransfer(data.get("background"), data.get("border"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().verifyB2BTransferHeading(data.get("b2bHeading"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().fillAmount(data.get("amount"));
			walletpage.selectTransferTypePopup().b2bTransferPopup().verifyAvailableBalance();
			if (!data.get("errMsg").isEmpty()) {
				Thread.sleep(1000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("color"),
						data.get("amount"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("B2BTransfer funds failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokensBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickWithdraw();
			walletpage.withdrawTokensPopup().clickBankAccount();
			walletpage.withdrawTokensPopup().verifyWithdrawTokensHeading(data.get("withdrawHeading"));
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().clickBankAccount();
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().fillAmount(data.get("amount"));
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().verifyAvailableBalance();
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().fillNote(data.get("note"));
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().clickNext();
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().withdrawSummaryPopup().verifyProcessingFee();
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().withdrawSummaryPopup().verifyAmount();
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().withdrawSummaryPopup().verifyTotal();
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().withdrawSummaryPopup().clickConfirm();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Withdraw Tokens  Bank Account failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokensBankAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickWithdraw();
			walletpage.withdrawTokensPopup().clickBankAccount();
			walletpage.withdrawTokensPopup().verifyWithdrawTokensHeading(data.get("withdrawHeading"));
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().clickBankAccount();
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().fillAmount(data.get("amount"));
			walletpage.withdrawTokensPopup().withdrawToBankAccountPopup().verifyAvailableBalance();
			if (!data.get("errMsg").isEmpty()) {
				Thread.sleep(1000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("color"),
						data.get("amount"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Withdraw Tokens bank Account  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokensInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickWithdraw();
			walletpage.withdrawTokensPopup().clickInstantPay();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().verifyHeading(data.get("instantpayHeading"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup()
					.verifyDescription(data.get("instantDescription"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().clickRadioButton();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().clickNext();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().amount(data.get("amount"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().Inputnote(data.get("note"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().clickNext();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().withdrawSummaryPopup().verifyProcessingFee();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().withdrawSummaryPopup().verifyAmount();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().withdrawSummaryPopup().verifyTotal();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().withdrawSummaryPopup().clickConfirm();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().withdrawSummaryPopup().authyComponent()
					.fillInput(data.get("code"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().withdrawSummaryPopup()
					.withdrawInProgressPopup().getStatus();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().withdrawSummaryPopup()
					.withdrawInProgressPopup().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Withdraw Tokens Instant Pay failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokensInstantPayInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickWithdraw();
			walletpage.withdrawTokensPopup().clickInstantPay();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().verifyHeading(data.get("instantpayHeading"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup()
					.verifyDescription(data.get("instantDescription"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().clickRadioButton();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().clickNext();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().amount(data.get("amount"));
			if (!data.get("errMsg").isEmpty()) {
				Thread.sleep(1000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("color"),
						data.get("amount"));
			}
//			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().Inputnote(data.get("note"));
//			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().clickNext();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Withdraw Tokens Instant Pay failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			walletpage.clickWithdraw();
			walletpage.withdrawTokensPopup().clickInstantPay();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().verifyHeading(data.get("instantpayHeading"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().clickDelete();
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().removePaymentMethodPopup()
					.verifyRemovePaymentHeading(data.get("removeHeading"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().removePaymentMethodPopup()
					.verifyRemovePaymentDescription(data.get("removeDescription"));
			walletpage.withdrawTokensPopup().withdrawToInstantPayPopup().removePaymentMethodPopup().clickRemove();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Withdraw Tokens Instant Pay failed due to Exception " + e);
		}
	}
}
