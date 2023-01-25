package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.TransactionSucessFailurePendingComponent;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class MerchantMenuIconTest {

	BusinessTokenAccountPage businessTokenAccountPage;
	MerchantProfilePage merchantProfilePage;
	TransactionSucessFailurePendingComponent transactionSucessFailurePendingComponent;
	MerchantProfileTest merchantProfileTest;
	BusinessTransactionDetailsTest businessTransactionDetailsTest;

	@BeforeTest
	public void init() {
		merchantProfilePage=new MerchantProfilePage();
		businessTokenAccountPage = new BusinessTokenAccountPage();
		merchantProfileTest = new MerchantProfileTest();
		transactionSucessFailurePendingComponent = new TransactionSucessFailurePendingComponent();
		businessTransactionDetailsTest = new BusinessTransactionDetailsTest();
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
	public void testScanCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickScan();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().clickOnWhileUsingApp();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().clickFlashLight();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().navigationComponent().clickClose();
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickScan();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().clickOnAlbum();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().clickAllow();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage()
					.verifySelectPhoto(data.get("label"));
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().clickPhoto();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().clickOnCancel();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testReceivePaymentView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickReceivePayment();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().verifyPageHeading(data.get("heading"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getUserNameText();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage()
					.verifyPageDescription(data.get("description"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickSetAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage()
					.verifyAmountPageHeading(data.get("amountHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickOk();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getRequestedAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickSaveAlbum();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickAllow();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().toastComponent().verifyToastMsg(data.get("saveAlbumToast"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().verifyQrCode();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickClearAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getReceiptentAddress();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickCopy();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().toastComponent().verifyToastMsg(data.get("copyToastMsg"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickShare();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage()
					.verifySharePageHeading(data.get("sharePageHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getShareDescription();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getShareReceiptentAddress();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickShareCopy();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().verifyPageHeading(data.get("heading"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getUserNameText();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickClose();
			businessTokenAccountPage.getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReceivePaymentView  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testReceivePaymentWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickReceivePayment();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().verifyPageHeading(data.get("heading"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getUserNameText();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage()
					.verifyPageDescription(data.get("description"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickSetAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage()
					.verifyAmountPageHeading(data.get("amountHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickOk();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().errorMessagePopupComponent()
					.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().errorMessagePopupComponent()
					.verifyPopUpMsg(data.get("errPopUpMsg"));
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().errorMessagePopupComponent().clickOk();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage()
					.verifyAmountPageHeading(data.get("amountHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReceivePaymentWithInvalidData  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickBuyTokens();
			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
			Thread.sleep(2000);
			merchantProfileTest.testAddBankAccount(strParams);
			testBuyTokenBankAccount(strParams);
			businessTransactionDetailsTest.testVerifyBuyTokenBankTransaction(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	public void testBuyTokenBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod()
//					.verifyPageHeading(data.get("selectPaymentMethodHeading"));
//			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().clickBank();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.buyTokenWithBankAccount(data.get("buyTokenHeading"), data.get("buyTokenDescription"),
							data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().orderPreviewDetails(data.get("orderHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().getTokenTransactionStatusDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankAccountWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickBuyTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod()
					.verifyPageHeading(data.get("selectPaymentMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().clickBank();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.verifyPageHeading(data.get("buyTokenHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.verifyPageDescription(data.get("buyTokenDescription"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.getPaymentMethodDetails();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.getLimitDescription();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.fillAmount(data.get("amount"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawnToUSDGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickGiftCard();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.verifyGiftCardHeading(data.get("cardHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.verifyBrandHeading(data.get("poplurHeading"));
			Thread.sleep(2000);
			if(data.get("validateGiftCard").equalsIgnoreCase("yes")) {
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickAmazon();	
			}else {
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickVisa();
			}
			
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.verifyWithdrawGiftCard(data.get("giftCardHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillFirstName(data.get("firstName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillLastName(data.get("lastName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillEmail(data.get("email1"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyHeading(data.get("orderOverview"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyGiftCardHeading(data.get("amazonGift"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyRecipentEmail(data.get("recipentEmail"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.getProcessingFee();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.getTotal();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.slideToConfirm();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().fillPin(data.get("pin"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().successFailureComponent().getTransactionDetails();
			Thread.sleep(2000);
			businessTransactionDetailsTest.testVerifyWithdrawGiftCardTransaction(strParams);
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawnToUSDGiftCardInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickGiftCard();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.verifyGiftCardHeading(data.get("cardHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.verifyBrandHeading(data.get("poplurHeading"));
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.verifyWithdrawGiftCard(data.get("giftCardHeading"));
			if (data.get("validateEmail").equalsIgnoreCase("no")) {

				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillAmount(data.get("amount"));
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillFirstName(data.get("firstName"));
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillLastName(data.get("lastName"));
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillEmail(data.get("email1"));
			} else {
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillAmount(data.get("amount"));
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillFirstName(data.get("firstName"));
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillLastName(data.get("lastName"));
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillEmail(data.get("email1"));
				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
						.fillAmount(data.get("amount"));
			}

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawnToUSDGiftCardNavigationOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().navigationComponent().clickClose();
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickGiftCard();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().navigationComponent().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickGiftCard();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillFirstName(data.get("firstName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillLastName(data.get("lastName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillEmail(data.get("email1"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.slideToConfirm();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().clickForgotPin();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().navigationComponent().clickBack();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickBank();
			Thread.sleep(2000);
			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
			merchantProfileTest.testAddBankAccount(strParams);
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickBank();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseWithdrawBankAccount();
			testWithdrawTokenProcedure(strParams);
			Thread.sleep(2000);
			businessTransactionDetailsTest.testVerifyWithdrawBankTransaction(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawTokenWithBankAccount failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickInstantPay();
//			if (businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//					.verifyAddNewPaymentMethod() == 0) {
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//						.verifyAddPaymentHeading(data.get("addPaymentHeading"));
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//						.verifyAddPaymentDesc(data.get("addPaymentDescription"));
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickAddPaymentMethod();
//			} else {
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//						.verifyWithdraMethodHeading(data.get("withdrawMethod"));
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickAddPaymentMethod();
//			}
			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
			merchantProfileTest.AddDebitCard(strParams);
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickInstantPay();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseInstantPay();
			testWithdrawTokenProcedure(strParams);
			Thread.sleep(2000);
			businessTransactionDetailsTest.testVerifyWithdrawInstantPayTransaction(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawTokenWithInstantPay failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankAccountNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickBuyTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod()
					.verifyPageHeading(data.get("selectPaymentMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().clickBank();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.buyTokenWithBankAccount(data.get("buyTokenHeading"), data.get("buyTokenDescription"),
							data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().orderPreviewDetails(data.get("orderHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().enterYourPINComponent().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.clickChangePaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.paymentMethodsPage().clickAddNewPaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.addNewPaymentComponent().verifyHeading(data.get("heading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.paymentMethodsPage().clickExternalBankAccount();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.paymentMethodsPage().verifyAddExternalBankAccountHeading(data.get("addExternalBankHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.paymentMethodsPage().clickBack();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.paymentMethodsPage().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.verifyPageHeading(data.get("buyTokenHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod()
					.verifyPageHeading(data.get("selectPaymentMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().clickClose();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWBankAccountWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickBank();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseWithdrawBankAccount();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.withdrawTokenTransaction(data.get("withdrawTokenHeading"), data.get("amount"),
							data.get("optionalMessage"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().orderPreviewDetails(data.get("orderHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().enterYourPINComponent().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickChangePaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickOnAddNewPaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.addNewPaymentComponent().verifyHeading(data.get("heading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickExternalBankAccount();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().verifyAddExternalBankAccountHeading(data.get("addExternalBankHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickBack();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickClose();
			businessTokenAccountPage.dashBoardPage().getUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawTokenWithBankAccount failed due to exception " + e);
		}

	}

	public void testWithdrawTokenProcedure(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.withdrawTokenTransaction(data.get("withdrawTokenHeading"), data.get("amount"),
							data.get("optionalMessage"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().orderPreviewDetails(data.get("orderHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().getTokenTransactionStatusDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawTokenWithBankAccount failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithInstantPayNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickInstantPay();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseInstantPay();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.withdrawTokenTransaction(data.get("withdrawTokenHeading"), data.get("amount"),
							data.get("optionalMessage"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().orderPreviewDetails(data.get("orderHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().enterYourPINComponent().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickChangePaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickOnAddNewPaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.addNewPaymentComponent().verifyHeading(data.get("heading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickDebitCard();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickBack();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickClose();
			businessTokenAccountPage.dashBoardPage().getUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawTokenWithInstantPay failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithSignetAccountNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickCogentAccount();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseSignetAccount();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.withdrawTokenTransaction(data.get("withdrawTokenHeading"), data.get("amount"),
							data.get("optionalMessage"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().orderPreviewDetails(data.get("orderHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.orderPreviewPopup().enterYourPINComponent().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickChangePaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickOnAddNewPaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.addNewPaymentComponent().verifyHeading(data.get("heading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickSignetAccount();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickBack();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.paymentMethodsPage().clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.clickClose();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickClose();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawTokenWithBankAccount failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickCogentAccount();
//			if (businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//					.verifyAddNewPaymentMethod() == 0) {
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//						.verifyAddPaymentHeading(data.get("addPaymentHeading"));
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//						.verifyAddPaymentDesc(data.get("addPaymentDescription"));
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickAddPaymentMethod();
//			} else {
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//						.verifyWithdraMethodHeading(data.get("withdrawMethod"));
//				businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickAddPaymentMethod();
//			}
			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
			merchantProfileTest.AddCogentAccount(strParams);
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickCogentAccount();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
//					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseSignetAccount();
			testWithdrawTokenProcedure(strParams);
			Thread.sleep(2000);
			businessTransactionDetailsTest.testVerifyWithdrawSignetTransaction(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawTokenWithBankAccount failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithBankAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickBank();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseWithdrawBankAccount();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.getPaymentMethodName();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().withdrawTokenTransactionPage()
					.fillAmount(data.get("amount"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdrawTokenWithBankAccountInvalidData failed due to exception " + e);
		}

	}

}