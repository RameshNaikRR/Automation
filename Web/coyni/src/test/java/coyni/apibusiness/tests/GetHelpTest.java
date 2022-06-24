package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.apibusiness.components.SideBarMenuComponent;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class GetHelpTest {

	SideBarMenuComponent sideBarMenuComponent;

	@BeforeMethod
	public void init() {

		sideBarMenuComponent = new SideBarMenuComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickGetHelp();
			sideBarMenuComponent.getHelpPage().verifyHeading(data.get("heading"));
			sideBarMenuComponent.getHelpPage().enterName(data.get("name"));
			sideBarMenuComponent.getHelpPage().enterEmail(data.get("email"));
			sideBarMenuComponent.getHelpPage().enterFeedBack(data.get("feedBack"));
			sideBarMenuComponent.getHelpPage().enterModel(data.get("model"));
			sideBarMenuComponent.getHelpPage().enterAccountId(data.get("accountId"));
			sideBarMenuComponent.getHelpPage().selectDropDown(data.get("inquiry"));
			sideBarMenuComponent.getHelpPage().dropDownPhone(data.get("phone"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testGetHelp exception happend due to this " + e);
		}
	}
}