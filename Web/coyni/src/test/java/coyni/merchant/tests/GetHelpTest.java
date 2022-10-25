package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.components.MerchantActivityComponent;
import coyni.merchant.pages.GetHelpPage;
import coyni.merchant.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class GetHelpTest {

	HomePage homePage;
	GetHelpPage getHelpPage;
	MerchantActivityComponent merchantActivityComponent;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		getHelpPage = new GetHelpPage();
		merchantActivityComponent = new MerchantActivityComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			getHelpPage.verifyHeading(data.get("heading"));
			getHelpPage.clickGetHelp();
			Thread.sleep(3000);
			getHelpPage.getContent();
			getHelpPage.getContentHelp();
			getHelpPage.getMessage();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testGetHelp is failed due to exception " + e);
		}

	}

}