package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class MerchantAccountTest {

	BusinessTokenAccountPage businessTokenAccountPage;

	@BeforeTest
	public void init() {
		businessTokenAccountPage = new BusinessTokenAccountPage();

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
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getUserLogoText();
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
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getUserLogoText();
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
			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage().getUserLogoText();
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
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().getCurrency();
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
			businessTokenAccountPage.tokenMenuIconPopUp().selectPaymentmethod().buyTokenBankAccountPaymentMethodPage()
					.orderPreviewPopup().transactionSucessFailurePendingComponent().getPageHeading();
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

}