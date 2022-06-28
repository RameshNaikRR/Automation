package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.GetHelpPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class GetHelpTest {

	SideBarMenuComponent sideBarMenuComponent;
	GetHelpPage getHelpPage;

	@BeforeMethod
	public void init() {
		getHelpPage = new GetHelpPage();
		sideBarMenuComponent = new SideBarMenuComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickGetHelp();
			// getHelpPage.view();
			Thread.sleep(3000);
			// getHelpPage.fillFullName(data.get("fullName"));
			getHelpPage.fillAccountIDNumber(data.get("accountID"));
			getHelpPage.fillEmail(data.get("email"));
			getHelpPage.selectCountry(data.get("country"));
			getHelpPage.fillPhoneNumber(data.get("phoneNumber"));
			getHelpPage.selectInquiryType(data.get("inquiryType"));
			getHelpPage.selectdrpDwnCustomertopics(data.get("customerTopics"));
			getHelpPage.fillDetails(data.get("details"));
			// getHelpPage.clickOnFiles();
			getHelpPage.clickOnSubmit();
			getHelpPage.verifyMessage(data.get("getHelpmessage"));
			getHelpPage.clickOnSubmitAgain();
			getHelpPage.verifyHeading(data.get("expHeading"));

		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testGetHelp is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelpWithInvalidData(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		sideBarMenuComponent.clickGetHelp();
		getHelpPage.clickGetHelp();
		// getHelpPage.view();
		getHelpPage.fillFullName(data.get("fullName"));
		getHelpPage.fillAccountIDNumber(data.get("accountID"));
		getHelpPage.fillEmail(data.get("email"));
		getHelpPage.selectCountry(data.get("country"));
		getHelpPage.fillPhoneNumber(data.get("phoneNumber"));
		getHelpPage.selectInquiryType(data.get("inquiryType"));
		getHelpPage.selectdrpDwnCustomertopics(data.get("customerTopics"));
		getHelpPage.fillDetails(data.get("details"));
		// getHelpPage.clickOnFiles();
		getHelpPage.clickOnSubmit();
		getHelpPage.verifyErrorMessage(data.get("errMessage"));
	}
}