package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.NavigationMenuPage;
import coyni.customer.pages.TokenAccountPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class NavigationMenuTest {
	NavigationMenuPage navigationMenuPage;
	TokenAccountPage tokenAccountPage;

	@BeforeTest
	public void init() {
		navigationMenuPage = new NavigationMenuPage();
		tokenAccountPage = new TokenAccountPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSideBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			Thread.sleep(2000);
			navigationMenuPage.verifyAccountHolderNameView();
			navigationMenuPage.verifyAccountIDView();
			navigationMenuPage.verifyAccountID(data.get("AccountID"));
			navigationMenuPage.verifyUserImageView();//
			navigationMenuPage.verifyQRCodeView();
			navigationMenuPage.verifyTokenAccountView();
			navigationMenuPage.verifyExportFilesView();
			navigationMenuPage.verifyGetHelpView();
			navigationMenuPage.clickExportFilesMenu();
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Test Side Bar view is failed  due to exception " + e);
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

	// added
	@Test
	// @Parameters({ "strParams" })
	public void testProgressBar() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccount();
			navigationMenuPage.verifyLabelMessage();
			// navigationMenuPage.verifyProfileInformation();
			navigationMenuPage.userNameDropDownComponent().clickUserName();
			navigationMenuPage.userNameDropDownComponent().verifyUserDetails();
			navigationMenuPage.verifyNotificationsIcon();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Progress Bar is failed  due to exception " + e);
		}

	}

}
