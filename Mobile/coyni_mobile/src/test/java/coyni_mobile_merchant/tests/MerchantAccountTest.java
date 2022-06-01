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
			businessTokenAccountPage.tokenMenuIconPopUp().clickScan();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().clickOnWhileUsingApp();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().clickFlashLight();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().navigationComponent().clickClose();
			businessTokenAccountPage.clickHome();
			businessTokenAccountPage.tokenMenuIconPopUp().clickScan();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().clickOnAlbum();
			Thread.sleep(2000);
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().clickAllow();
			businessTokenAccountPage.tokenMenuIconPopUp().scanPage().scanCodePage().verifySelectPhoto(data.get("label"));
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
			businessTokenAccountPage.clickHome();
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
			ExtentTestManager.setFailMessageInReport("testReceivePayment  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testReceivePaymentWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickHome();
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
			ExtentTestManager.setFailMessageInReport("testReceivePayment  failed due to exception " + e);
		}

	}

}