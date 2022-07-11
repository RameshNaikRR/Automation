package coyni.merchant.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.GetHelpPage;
import coyni.merchant.pages.HomePage;

public class GetHelpTest {

	HomePage homePage;
	GetHelpPage getHelpPage;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		getHelpPage = new GetHelpPage();
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testGetHelp(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			Thread.sleep(2000);
//			// tokenAccountPage.clickTokenAccount();
//			getHelpPage.clickGetHelp();
//			// getHelpPage.view();
//			Thread.sleep(3000);
//			// getHelpPage.fillFullName(data.get("fullName"));
//			getHelpPage.fillAccountIDNumber(data.get("accountID"));
//			getHelpPage.fillEmail(data.get("email"));
//			getHelpPage.selectCountry(data.get("country"));
//			getHelpPage.fillPhoneNumber(data.get("phoneNumber"));
//			getHelpPage.selectInquiryType(data.get("inquiryType"));
//			getHelpPage.selectdrpDwnCustomertopics(data.get("customerTopics"));
//			getHelpPage.fillDetails(data.get("details"));
//			// getHelpPage.clickOnFiles();
//			getHelpPage.clickOnSubmit();
//			getHelpPage.verifyMessage(data.get("getHelpmessage"));
//			getHelpPage.clickOnSubmitAgain();
//			getHelpPage.verifyHeading(data.get("expHeading"));
//
//		} catch (InterruptedException e) {
//			ExtentTestManager.setFailMessageInReport("testGetHelp is failed due to exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testGetHelpWithInvalidData(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickTokenAccount();
//			getHelpPage.clickGetHelp();
//			// getHelpPage.view();
//			getHelpPage.fillFullName(data.get("fullName"));
//			getHelpPage.fillAccountIDNumber(data.get("accountID"));
//			getHelpPage.fillEmail(data.get("email"));
//			getHelpPage.selectCountry(data.get("country"));
//			getHelpPage.fillPhoneNumber(data.get("phoneNumber"));
//			getHelpPage.selectInquiryType(data.get("inquiryType"));
//			getHelpPage.selectdrpDwnCustomertopics(data.get("customerTopics"));
//			getHelpPage.fillDetails(data.get("details"));
//			// getHelpPage.clickOnFiles();
//			getHelpPage.clickOnSubmit();
//			getHelpPage.verifyErrorMessage(data.get("errMessage"));
//		} catch (InterruptedException e) {
//			ExtentTestManager.setFailMessageInReport("testGetHelpWithInvalidData is failed due to exception " + e);
//		}
//
//	}

}