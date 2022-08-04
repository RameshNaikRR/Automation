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
			testBuyTokenBankAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}
	
	
	public void testBuyTokenBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().verifyPageHeading(data.get("heading"));
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().clickBank();
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
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().verifyPageHeading(data.get("heading"));
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
	public void testBuyTokenWithBankAccoun(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickBuyTokens();
			testBuyTokenBankAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}
	
	
	public void testBuyTokenBankAccountNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickBuyTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().verifyPageHeading(data.get("heading"));
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
			.clickClose();
			
			
			
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().clickClose();
			
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
					.verifyAmazonHeading(data.get("amazonGift"));
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
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseWithDrawPaymentMethod();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseWithdrawBankAccount();
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
	public void testWithdrawTokenWithInstantPay(String strParams) {
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
	public void testWithdrawTokenWithSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickSignetAccount();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdraMethodHeading(data.get("withdrawMethod"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseSignetAccount();
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
	public void testWithdrawTokenWithBankAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().clickWithdrawTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("selectWithdrawMethodHeading"));
			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickChooseWithDrawPaymentMethod();
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