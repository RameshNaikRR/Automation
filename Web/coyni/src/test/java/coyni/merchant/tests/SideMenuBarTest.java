package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.components.SideMenuBarComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class SideMenuBarTest {
	SideMenuBarComponent sideMenuBarComponent;

	@BeforeTest
	public void init() {
		sideMenuBarComponent = new SideMenuBarComponent();
	}

	@Test
	public void testSideMenuBar() {
		try {
			sideMenuBarComponent.verifyUserName();
//			sideMenuBarComponent.verifyLblMerchnatApplicationTracker();
//			sideMenuBarComponent.verifyMerchnatTracker();
			sideMenuBarComponent.verifyMerchantActivityDrpDwn();
			sideMenuBarComponent.verifyTokenAccountPushBtn();
			sideMenuBarComponent.verifyExportFilesPushBtn();
			sideMenuBarComponent.verifyMerchnatSettingsPushBtn();
			sideMenuBarComponent.verifyGetHelpPushBtn();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSideMenuBar failed due to " + e);
		}
	}

	@Test
	public void testMerchantActivityDrpDwn() {
		try {
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.verifyDashboard();
			sideMenuBarComponent.verifyTransactions();
			sideMenuBarComponent.verifyPayoutHistory();
			sideMenuBarComponent.verifyReserveHistory();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantActivityDrpDwn failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantActivityDrpDwnBtns(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			Thread.sleep(2000);
			sideMenuBarComponent.clickDashboard();
			sideMenuBarComponent.dashBoardPage().verifyHeading(data.get("dashboardHeading"));
			sideMenuBarComponent.clickTransactions();
			sideMenuBarComponent.transactionsPage().verifyHeading(data.get("transactionsHeading"));
			sideMenuBarComponent.clickPayoutHistory();
			sideMenuBarComponent.payOutHistoryPage().verifyHeading(data.get("payOutHistoryHeading"));
			sideMenuBarComponent.clickReserveHistory();
			sideMenuBarComponent.reserveHistoryPage().verifyHeading(data.get("reserveHistoryHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantActivityDrpDwnBtns failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSideMenuBarBtns(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			sideMenuBarComponent.tokenAccountPage().verifyHeading(data.get("tokenAccountHeading"));
			sideMenuBarComponent.clickExportFiles();
			sideMenuBarComponent.exportfilesPage().verifyHeading(data.get("exportFilesHeading"));
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("merchantSettingsHeading"));
			sideMenuBarComponent.clickGetHelp();
			sideMenuBarComponent.getHelpPage().verifyHeading(data.get("getHelpHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSideMenuBarBtns failed due to " + e);
		}
	}

	public void testMyQRCode(String strParams, String textBox) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideMenuBarComponent.clickTokenAccount();
			sideMenuBarComponent.clickQRCode();
			sideMenuBarComponent.myQRCodeComponent().verifyCopy(); // data.get("copy")
			Thread.sleep(1000);
			sideMenuBarComponent.myQRCodeComponent().verifytxtCopyToClipBoard(data.get("copyToClipBoard"));
			sideMenuBarComponent.myQRCodeComponent().clickShare();

			if (textBox.equalsIgnoreCase("email")) {
				sideMenuBarComponent.myQRCodeComponent().pasteOptionEmail(data.get("email"));
				sideMenuBarComponent.myQRCodeComponent().fillTextEmail(data.get("email"));
			} else {
				sideMenuBarComponent.myQRCodeComponent().pasteOption(data.get("phoneNumber"));
				sideMenuBarComponent.myQRCodeComponent().fillPhoneNumber(data.get("phoneNumber"));
			}
			sideMenuBarComponent.myQRCodeComponent().fillTextMessage(data.get("containt"));
			sideMenuBarComponent.myQRCodeComponent().clickShareButton();
			sideMenuBarComponent.myQRCodeComponent().successFailurePopupCardComponent().clickDone();

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Test My QR code is failed  due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testShareQRCodeWithEmail(String strParams) {
		testMyQRCode(strParams, "email");
	}

	@Test
	@Parameters({ "strParams" })
	public void testShareQRCodeWithPhoneNumber(String strParams) {
		testMyQRCode(strParams, "phoneNumber");
	}

	@Test
	@Parameters({ "strParams" })
	public void testShareQRCodeWithNagativeOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			sideMenuBarComponent.clickQRCode();
			sideMenuBarComponent.myQRCodeComponent().verifyCopy(); // data.get("copy")
			Thread.sleep(1000);
			sideMenuBarComponent.myQRCodeComponent().verifytxtCopyToClipBoard(data.get("copyToClipBoard"));
			sideMenuBarComponent.myQRCodeComponent().clickShare();
			sideMenuBarComponent.myQRCodeComponent().fillTextEmail(data.get("email1"));
			sideMenuBarComponent.myQRCodeComponent().fillPhoneNumber(data.get("phoneNumber"));
			sideMenuBarComponent.myQRCodeComponent().clickTab();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("testShareQRCodeWithNagativeOption due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMyQRCodeWithNavigationOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			sideMenuBarComponent.clickQRCode();
			sideMenuBarComponent.myQRCodeComponent().clickDone();
			sideMenuBarComponent.clickQRCode();
			sideMenuBarComponent.myQRCodeComponent().navigationComponent().clickClose();
			sideMenuBarComponent.clickQRCode();
			sideMenuBarComponent.myQRCodeComponent().clickShare();
			sideMenuBarComponent.myQRCodeComponent().navigationComponent().clickBack();
			sideMenuBarComponent.myQRCodeComponent().clickShare();
			sideMenuBarComponent.myQRCodeComponent().fillPhoneNumber(data.get("phoneNumber"));
			sideMenuBarComponent.myQRCodeComponent().fillTextMessage(data.get("containt"));
			sideMenuBarComponent.myQRCodeComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMyQRCodeWithNavigationOption " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMyQRCodeGeneratePrintable(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideMenuBarComponent.clickTokenAccount();
			sideMenuBarComponent.clickQRCode();
			sideMenuBarComponent.myQRCodeComponent().clickGeneratePrintableQRCode();
			sideMenuBarComponent.myQRCodeComponent().generatePrintableQRCodePopup().verifyHeading(data.get("heading"));
			sideMenuBarComponent.myQRCodeComponent().generatePrintableQRCodePopup().clickCheckBoxes();
			sideMenuBarComponent.myQRCodeComponent().generatePrintableQRCodePopup().clickBoxes();
			sideMenuBarComponent.myQRCodeComponent().generatePrintableQRCodePopup().clickGenerate();
			sideMenuBarComponent.myQRCodeComponent().generatePrintableQRCodePopup().viewGeneratePDF();
			sideMenuBarComponent.myQRCodeComponent().generatePrintableQRCodePopup().getName();
			sideMenuBarComponent.myQRCodeComponent().generatePrintableQRCodePopup().getScanQRCode();

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("testMyQRCodeGeneratePrintable failed  due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMyQRCodeWithOutGeneratePrintable(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideMenuBarComponent.clickTokenAccount();
			sideMenuBarComponent.clickQRCode();
			sideMenuBarComponent.completeVerificationPopup().verifyHeading(data.get("heading"));
			sideMenuBarComponent.completeVerificationPopup().verifyDescription();
			sideMenuBarComponent.completeVerificationPopup().clickAccountVerification();

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("testMyQRCodeGeneratePrintable failed  due to exception " + e);
		}
	}
}
