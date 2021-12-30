package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.GetStartedPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class GetStartedTest {
	GetStartedPage getStartedPage;

	@BeforeMethod
	public void init() {
		getStartedPage =new GetStartedPage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testGetstarted(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			getStartedPage.clickTwoStepAuthentication();
			getStartedPage.verifyHeading(data.get("twoStepHeading"));
			getStartedPage.clickManualEntry();
			getStartedPage.clickCopy();
			getStartedPage.fillAuthyInput();
			getStartedPage.verifySucessHeading(data.get("sucessHeading"));
			getStartedPage.clickVerifyIdentity();
			getStartedPage.verifyYourIdentityPage().verifyHeading(data.get("identityHeading"));
			getStartedPage.verifyYourIdentityPage().mailingAddressComponent().fillAddress1(data.get("addline1"));
			getStartedPage.verifyYourIdentityPage().mailingAddressComponent().fillAddress2(data.get("addline2"));
			getStartedPage.verifyYourIdentityPage().mailingAddressComponent().fillCity(data.get("city"));
			getStartedPage.verifyYourIdentityPage().mailingAddressComponent().selectState(data.get("state"));
			getStartedPage.verifyYourIdentityPage().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testGetstarted failed due to exception " + e);
		}
	}

}
