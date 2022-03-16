package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.HomePage;
import coyni.customer.pages.LoginPage;
import coyni.customer.pages.NavigationMenuPage;
import coyni.customer.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class NavigationMenuTest {
	NavigationMenuPage navigationMenuPage;
	TokenAccountPage tokenAccountPage;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeTest
	public void init() {
		navigationMenuPage = new NavigationMenuPage();
		tokenAccountPage = new TokenAccountPage();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSideBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			Thread.sleep(2000);
			navigationMenuPage.verifyAccountHolderNameView();
			navigationMenuPage.clickAccountDropdwn();
			navigationMenuPage.verifyPersonalAccountView();
			navigationMenuPage.verifyAccountIDView();
			navigationMenuPage.verifyAccountID(data.get("AccountID"));
			navigationMenuPage.verifyUserImageView();//
			navigationMenuPage.verifyQRCodeView();
			navigationMenuPage.verifyTokenAccountView();
			navigationMenuPage.verifyExportFilesView();
			navigationMenuPage.verifyGetHelpView();
			// navigationMenuPage.clickExportFilesMenu();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Side Bar view is failed  due to exception " + e);
		}
	}

	public void testMyQRCode(String strParams, String textBox) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			navigationMenuPage.clickQRcode();
			navigationMenuPage.myQRCodeComponent().verifyCopy(); // data.get("copy")
			Thread.sleep(1000);
			navigationMenuPage.myQRCodeComponent().verifytxtCopyToClipBoard(data.get("copyToClipBoard"));
			navigationMenuPage.myQRCodeComponent().clickShare();

			if (textBox.equalsIgnoreCase("email")) {
				navigationMenuPage.myQRCodeComponent().pasteOptionEmail(data.get("email"));
				navigationMenuPage.myQRCodeComponent().fillTextEmail(data.get("email"));
				// navigationMenuPage.myQRCodeComponent().fillPhoneNumber(data.get("phoneNumber"));
			} else {
				navigationMenuPage.myQRCodeComponent().pasteOption(data.get("phoneNumber"));
				navigationMenuPage.myQRCodeComponent().fillPhoneNumber(data.get("phoneNumber"));
				// navigationMenuPage.myQRCodeComponent().fillTextEmail(data.get("email"));
			}
			navigationMenuPage.myQRCodeComponent().fillTextMessage(data.get("containt"));
			navigationMenuPage.myQRCodeComponent().clickShareButton();
			navigationMenuPage.myQRCodeComponent().successFailurePopupCardComponent().clickDone();

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
			tokenAccountPage.clickTokenAccount();
			navigationMenuPage.clickQRcode();
			navigationMenuPage.myQRCodeComponent().verifyCopy(); // data.get("copy")
			Thread.sleep(1000);
			navigationMenuPage.myQRCodeComponent().verifytxtCopyToClipBoard(data.get("copyToClipBoard"));
			navigationMenuPage.myQRCodeComponent().clickShare();
			navigationMenuPage.myQRCodeComponent().fillTextEmail(data.get("email1"));
			// Thread.sleep(3000);
			navigationMenuPage.myQRCodeComponent().fillPhoneNumber(data.get("phoneNumber"));
			navigationMenuPage.myQRCodeComponent().clickTab();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Test My QR code is failed  due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMyQRCodeWithNavigationOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			navigationMenuPage.clickQRcode();
			navigationMenuPage.myQRCodeComponent().clickDone();
			navigationMenuPage.clickQRcode();
			navigationMenuPage.myQRCodeComponent().navigationComponent().clickClose();
			navigationMenuPage.clickQRcode();
			navigationMenuPage.myQRCodeComponent().clickShare();
			navigationMenuPage.myQRCodeComponent().navigationComponent().clickBack();
			navigationMenuPage.myQRCodeComponent().clickShare();
			navigationMenuPage.myQRCodeComponent().fillPhoneNumber(data.get("phoneNumber"));
			navigationMenuPage.myQRCodeComponent().fillTextMessage(data.get("containt"));
			navigationMenuPage.myQRCodeComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Test My QR code is failed  due to navigation option exception " + e);
		}
	}

	@Test
	// @Parameters({ "strParams" })
	public void testAccountDropdownView() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			Thread.sleep(5000);
			navigationMenuPage.verifyAccountHolderNameView();
			navigationMenuPage.clickUserNameHead();
			// navigationMenuPage.verifyBusinessAccountView();
			navigationMenuPage.verifyPersonalAccountView();
			navigationMenuPage.verifyAddNewBusinessAccountView();
			// navigationMenuPage.verifyAddNewBusinessAccountLabel(data.get("message"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Account Drop down view is failed  due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSideBarRouting(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			navigationMenuPage.verifyTokenAccountHeadingView();
			navigationMenuPage.clickExportFilesMenu();
			navigationMenuPage.verifyExportFilesHeadingView();
			navigationMenuPage.clickGetHelpMenu();
			navigationMenuPage.verifyGetHelpHeadingView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Routing is failed  due to exception " + e);
		}

	}

	@Test
	// @Parameters({ "strParams" })
	public void testProgressBar() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			navigationMenuPage.verifyLabelMessage();
			// navigationMenuPage.verifyProfileInformation();
			// navigationMenuPage.userNameDropDownComponent().cursorhoverUserName();
			navigationMenuPage.userNameDropDownComponent().verifyUserDetailsNameHeading();
			navigationMenuPage.userNameDropDownComponent().clickUserName();
			navigationMenuPage.userNameDropDownComponent().verifyDropDownElements();
			navigationMenuPage.userNameDropDownComponent().verifyRequestDot();
			// navigationMenuPage.verifyNotificationsIcon();
			navigationMenuPage.userNameDropDownComponent().clickSignOut();
			homePage.clickPersonalAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Progress Bar is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testFloatingIcon(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			navigationMenuPage.verifyLabelMessage();
			// navigationMenuPage.verifyProfileInformation();
			// navigationMenuPage.userNameDropDownComponent().cursorhoverUserName();
			// navigationMenuPage.userNameDropDownComponent().verifyUserDetailsNameHeading();
			navigationMenuPage.userNameDropDownComponent().clickUserName();
			navigationMenuPage.userNameDropDownComponent().verifyDropDownElements();
			// navigationMenuPage.userNameDropDownComponent().verifyRequestDot();
			navigationMenuPage.userNameDropDownComponent().clickRequest();
			//navigationMenuPage.userNameDropDownComponent().notificationsComponent().clickRequests();
			navigationMenuPage.userNameDropDownComponent().notificationsComponent().clickCloseIcon();

			// navigationMenuPage.userNameDropDownComponent().clickUserName();
			navigationMenuPage.userNameDropDownComponent().clickUserDetails();
			navigationMenuPage.userNameDropDownComponent().clickPaymentMethods();
			navigationMenuPage.userNameDropDownComponent().clickPreferences();
			navigationMenuPage.userNameDropDownComponent().clickAccountLimits();
			navigationMenuPage.userNameDropDownComponent().clickAgreements();
			navigationMenuPage.userNameDropDownComponent().clickChangePassword();
			navigationMenuPage.verifyAccountHolderNameView();
			navigationMenuPage.clickOnRefresh();
			//navigationMenuPage.verifyAccountHolderNameView();
			//navigationMenuPage.userNameDropDownComponent().clickUserName();
			//navigationMenuPage.userNameDropDownComponent().clickSignOut();
			loginPage.verifyHeading(data.get("loginHeading"));

			// navigationMenuPage.verifyNotificationsIcon();
			// navigationMenuPage.userNameDropDownComponent().clickSignOut();
			// homePage.clickPersonalAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Progress Bar is failed due to exception " + e);
		}

	}
}
