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

public class DashBoardTest {
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
	public void testBottomMenuBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessTransactionsPage().verifyPageHeading(data.get("tokenAccountHeading"));
			businessTokenAccountPage.businessTransactionsPage()
					.verifyPageDescription(data.get("tokenAccountDescription"));
			businessTokenAccountPage.clickProfile();
			businessTokenAccountPage.merchantProfilePage().getAccountDetails();
			businessTokenAccountPage.merchantProfilePage().getAccountId();
			businessTokenAccountPage.merchantProfilePage().clickBack();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickTransactions();
			businessTokenAccountPage.merchantTransactionsPage().verifyHeading(data.get("merchantHeading"));
			businessTokenAccountPage.merchantTransactionsPage().clickClose();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickDashBoard();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.dashBoardPage().getDashBoardHeading();
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().viewScan();
			businessTokenAccountPage.tokenMenuIconPopUp().viewReceivePayment();
			businessTokenAccountPage.tokenMenuIconPopUp().viewBuyTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().viewWithdrawTokens();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}

	}

}
