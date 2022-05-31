package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class MerchantAccountTest {

	MerchantProfilePage merchantProfilePage;

	@BeforeTest
	public void init() {
		merchantProfilePage = new MerchantProfilePage();

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
			merchantProfilePage.clickHome();
			merchantProfilePage.tokenHomePopUp().clickScan();
			merchantProfilePage.tokenHomePopUp().scanPage().clickOnWhileUsingApp();
			merchantProfilePage.tokenHomePopUp().scanPage().scanCodePage().clickFlashLight();
			merchantProfilePage.tokenHomePopUp().scanPage().navigationComponent().clickClose();

			merchantProfilePage.clickHome();
			merchantProfilePage.tokenHomePopUp().clickScan();
			merchantProfilePage.tokenHomePopUp().scanPage().scanCodePage().clickOnAlbum();
			Thread.sleep(2000);
			merchantProfilePage.tokenHomePopUp().scanPage().scanCodePage().clickAllow();
			merchantProfilePage.tokenHomePopUp().scanPage().scanCodePage().verifySelectPhoto(data.get("label"));
			merchantProfilePage.tokenHomePopUp().scanPage().scanCodePage().clickPhoto();
			merchantProfilePage.tokenHomePopUp().scanPage().scanCodePage().clickOnCancel();

			merchantProfilePage.tokenHomePopUp().scanPage().scanCodePage().clickOnAlbum();
			merchantProfilePage.tokenHomePopUp().scanPage().scanCodePage().clickDeny();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}

	}

}