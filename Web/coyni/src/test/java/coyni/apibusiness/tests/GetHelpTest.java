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
			getHelpPage.verifyHeading(data.get("heading"));
			getHelpPage.verifyCaption(data.get("caption"));
			getHelpPage.verifyDescription();
			getHelpPage.verifySupportHyperLink();
			getHelpPage.verifyHelpElements();
			getHelpPage.verifyGetHelpElements();
		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testGetHelp is failed due to exception " + e);
		}

	}

}