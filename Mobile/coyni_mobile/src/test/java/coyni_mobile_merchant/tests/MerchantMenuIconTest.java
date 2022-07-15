package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.TransactionSucessFailurePendingComponent;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class MerchantMenuIconTest {

	BusinessTokenAccountPage businessTokenAccountPage;
	TransactionSucessFailurePendingComponent transactionSucessFailurePendingComponent;

	@BeforeTest
	public void init() {
		businessTokenAccountPage = new BusinessTokenAccountPage();
		transactionSucessFailurePendingComponent = new TransactionSucessFailurePendingComponent();
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
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().verifyQrCode();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickClearAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getReceiptentAddress();
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().clickCopy();
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
//			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getUserLogoText();
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
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod()
					.verifyPageHeading(data.get("heading"));
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
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.clickConvertor();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.getAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.clickConvertor();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.getAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.getExchangeRate();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.clickBuyToken();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().verifyPageHeading(data.get("orderHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().getAmount();
//			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
//					.orderPreviewPopup().getCurrency();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().getPaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().getPurchaseAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().getProcessingFee();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().getTotal();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().swipeSlideToConfirm();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().getPageHeading();
//			if (.equalsIgnoreCase("Transaction Failed")) {
//				
//			}
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().getAmount();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().getCurrency();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().getPageDescription();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().getReferenceID();
//			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
//					.orderPreviewPopup().transactionSucessFailurePendingComponent().viewLearnMore();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().clickDone();

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
			// businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillSearchBox(data.get("enterCard"));
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.verifyWithdrawGiftCard(data.get("giftCardHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillFirstName(data.get("firstName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyHeading(data.get("orderPreview"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyAmazonHeading(data.get("amazonGift"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyRecipentEmail(data.get("recipentEmail"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.getProcessingFee();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().getTotal();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.slideToConfirm();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().fillPin(data.get("pin"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().successFailureComponent().verifyRecipentEmail(data.get("content"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().successFailureComponent().verifyReferenceID();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().successFailureComponent().clickLearnMore();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().successFailureComponent().clickDone();
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
			// businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillSearchBox(data.get("enterCard"));
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.verifyWithdrawGiftCard(data.get("giftCardHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillFirstName(data.get("firstName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
			// businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
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
//			tokenAccountPage.btnHome();
//			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawToUSD();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickGiftCard();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().navigationComponent().clickBack();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
					.fillFirstName(data.get("firstName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.slideToConfirm();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().clickForgotPin();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}

	public void testWithdrawToken(String strParams, String method) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			if (method.equalsIgnoreCase("bank")) {
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().clickBankAccount(data.get("last4Digits"));
			}

			if (!method.equalsIgnoreCase("bank")) {
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickDebitCard();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
//				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
//						.withdrawToUSDInstantPayPopup().clickDebitCard();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().getDailyLimit();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().getAvailabeBalance();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().fillAmount(data.get("amount"));
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickOnConvertLink();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().enterMessage(data.get("message"));
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickDone();
				DriverFactory.getDriver().hideKeyboard();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickWithdraw();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.verifyHeading(data.get("previewHeading"));
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.getAmount();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.verifySlideText();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.swipeConfirm();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.enterYourPINComponent().fillPin(data.get("pin"));
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().getStatus();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().verifyReferenceID();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().getReferenceID();
//				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
//						.successFailureComponent().clickLearnMore();
//				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
//						.successFailureComponent().navigationComponent().clickClose();
				businessTokenAccountPage.tokenMenuIconPopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().clickDone();
//				tokenAccountPage.verifyAvailableBalanceView();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawToken failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithBank(String strParams) {
		testWithdrawToken(strParams, "bank");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithInstantPay(String strParams) {
		testWithdrawToken(strParams, "debit");
	}

}