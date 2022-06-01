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
			businessTokenAccountPage.clickHome();
			businessTokenAccountPage.tokenHomePopUp().clickScan();
			businessTokenAccountPage.tokenHomePopUp().scanPage().clickOnWhileUsingApp();
			businessTokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickFlashLight();
			businessTokenAccountPage.tokenHomePopUp().scanPage().navigationComponent().clickClose();

			businessTokenAccountPage.clickHome();
			businessTokenAccountPage.tokenHomePopUp().clickScan();
			businessTokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickOnAlbum();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickAllow();
			businessTokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().verifySelectPhoto(data.get("label"));
			businessTokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickPhoto();
			businessTokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickOnCancel();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testReceivePaymentView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickHome();
			businessTokenAccountPage.tokenHomePopUp().clickReceivePayment();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().verifyPageHeading(data.get("heading"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getUserLogoText();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getUserNameText();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage()
					.verifyPageDescription(data.get("description"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickSetAmount();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage()
					.verifyAmountPageHeading(data.get("amountHeading"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickOk();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getRequestedAmount();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickSaveAlbum();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickAllow();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickClearAmount();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getReceiptentAddress();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickCopy();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickShare();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage()
					.verifySharePageHeading(data.get("sharePageHeading"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getShareDescription();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getShareReceiptentAddress();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickShareCopy();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().verifyPageHeading(data.get("heading"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getUserLogoText();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getUserNameText();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickClose();
			businessTokenAccountPage.getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReceivePayment  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testReceivePaymentWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickHome();
			businessTokenAccountPage.tokenHomePopUp().clickReceivePayment();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().verifyPageHeading(data.get("heading"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getUserLogoText();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().getUserNameText();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage()
					.verifyPageDescription(data.get("description"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickSetAmount();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage()
					.verifyAmountPageHeading(data.get("amountHeading"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().fillAmount(data.get("amount"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().clickOk();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().errorMessagePopupComponent()
					.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().errorMessagePopupComponent()
					.verifyPopUpMsg(data.get("errPopUpMsg"));
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage().errorMessagePopupComponent().clickOk();
			businessTokenAccountPage.tokenHomePopUp().receivePaymentPage()
					.verifyAmountPageHeading(data.get("amountHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReceivePayment  failed due to exception " + e);
		}

	}

}