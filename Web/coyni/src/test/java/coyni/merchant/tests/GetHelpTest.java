package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.pages.GetHelpPage;
import coyni.merchant.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class GetHelpTest {

	HomePage homePage;
	GetHelpPage getHelpPage;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		getHelpPage = new GetHelpPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			getHelpPage.clickGetHelp();
			Thread.sleep(3000);
			getHelpPage.fillFullName(data.get("fullName"));
			getHelpPage.fillEmail(data.get("email"));
			getHelpPage.fillFeedBackIssue(data.get("issue"));
			getHelpPage.fillIosOrAndroid(data.get("ios"));
			getHelpPage.selectInquiryType(data.get("inquiryType"));
			getHelpPage.fillAccountIDNumber(data.get("accountID"));
			getHelpPage.selectCountry(data.get("country"));
			Thread.sleep(2000);
			getHelpPage.fillPhoneNumber(data.get("phoneNumber"));
			getHelpPage.clickOnSubmit();
			// getHelpPage.verifyMessage(data.get("getHelpmessage"));
			getHelpPage.clickOnSubmitAgain();
//			getHelpPage.verifyHeading(data.get("expHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testGetHelp is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelpWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			getHelpPage.clickGetHelp();
			// getHelpPage.view();
			getHelpPage.fillFullName(data.get("fullName"));
			getHelpPage.fillAccountIDNumber(data.get("accountID"));
			getHelpPage.fillFeedBackIssue(data.get("issue"));
			getHelpPage.selectInquiryType(data.get("inquiryType"));
			getHelpPage.clickOnSubmit();
			getHelpPage.verifyErrorMessage(data.get("errMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testGetHelpWithInvalidData is failed due to exception " + e);
		}

	}

}