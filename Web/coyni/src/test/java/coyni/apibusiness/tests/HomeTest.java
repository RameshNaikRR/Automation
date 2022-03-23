package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coyni.apibusiness.components.UserDetailsComponent;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class HomeTest {
	UserDetailsComponent userDetailsComponent;

	@BeforeTest
	public void init() {
		userDetailsComponent = new UserDetailsComponent();
	}

	@Test
	public void testClickUserNameOnHomePage() {
		try {
			Map<String, String> data = Runner.getKeywordParameters(null);
//			adminComponent.clickUserName();
//			adminComponent.clickUserDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners flow failed due to Exception " + e);
		}

	}

	@Test
	public void testClickUserDetailsComponent() {
		try {
			Map<String, String> data = Runner.getKeywordParameters(null);
			userDetailsComponent.verifyUserNameView();
			userDetailsComponent.verifyUserDetailsView();
			userDetailsComponent.verifyUserName(data.get("UserName"));
			userDetailsComponent.verifyAccountStatus(data.get("accountStatus"));
			userDetailsComponent.verifyAccountStatusView();
//      userDetailsComponent.verifyEditImageToolTip();

			userDetailsComponent.verifyEditEmailAddress(data.get("emailAddress"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners flow failed due to Exception " + e);
		}
	}
}
