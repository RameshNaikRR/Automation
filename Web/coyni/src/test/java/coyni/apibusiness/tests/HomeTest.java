package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.apibusiness.components.PhoneEmailVerificationComponent;
import coyni.apibusiness.components.TopBarComponent;
import coyni.apibusiness.components.UserDetailsComponent;
import coyni.apibusiness.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class HomeTest {
	PhoneEmailVerificationComponent phoneEmailVerificationComponent;
	HomePage homePage;
	TopBarComponent topBarComponent;
	UserDetailsComponent userDetailsComponent;

	@BeforeTest
	public void init() {
		userDetailsComponent = new UserDetailsComponent();
		topBarComponent = new TopBarComponent();
		homePage = new HomePage();
		phoneEmailVerificationComponent = new PhoneEmailVerificationComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testClickUserNameView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			homePage.topBarComponent().clickUserName();
			Thread.sleep(1000);
			homePage.topBarComponent().clickUserDetails();
			homePage.topBarComponent().userDetailsComponent().verifyUserNameView();
			homePage.topBarComponent().userDetailsComponent().verifyUserDetailsView();
			homePage.topBarComponent().userDetailsComponent().verifyAccountIdView();
			homePage.topBarComponent().userDetailsComponent().verifyAccountStatusView();
//			homePage.topBarComponent().userDetailsComponent().verifyEmailAddressView();
			homePage.topBarComponent().userDetailsComponent().verifyEditAccountPhone(data.get("phoneNumber"));
//			homePage.topBarComponent().userDetailsComponent().clickIconEditPhNum();
			homePage.topBarComponent().userDetailsComponent().clickEditUserImage();
			homePage.topBarComponent().userDetailsComponent().clickCrossButton();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("	Exception happened due to this " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.topBarComponent().clickUserName();
			Thread.sleep(1000);
			homePage.topBarComponent().clickUserDetails();
			homePage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			homePage.topBarComponent().userDetailsComponent().clickIconEditEmail();
//			homePage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
//					.verifyEmailAddressAuthHeading(data.get("emailAddAuth"));
			homePage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressDescHeading(data.get("emailAddressAuthDesc"));
			homePage.topBarComponent().userDetailsComponent().phoneEmailVerificationComponent().authyComponent()
					.fillAuthyInput((data.get("code")));
			homePage.topBarComponent().userDetailsComponent().phoneEmailVerificationComponent().authyComponent()
					.verifyMessage(data.get("message"));
			homePage.topBarComponent().userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddressHeading(data.get("emailAddressHeading"));
			homePage.topBarComponent().userDetailsComponent().editEmailAddressPopup()
					.verifyEmailAddressDescHeading(data.get("emailAddressDesc"));
			homePage.topBarComponent().userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailText(data.get("newEmail"));
			homePage.topBarComponent().userDetailsComponent().clickOutside();
			homePage.topBarComponent().userDetailsComponent().editEmailAddressPopup().clickEmailSendCode();
			homePage.topBarComponent().userDetailsComponent().currentEmailAddressPopup()
					.verifyCurrentEmailAddressHeading(data.get("emailHeading"));
			homePage.topBarComponent().userDetailsComponent().currentEmailAddressPopup()
					.verifyCurrentEmailAddressDescHeading(data.get("emailAddDesc"));
			homePage.topBarComponent().userDetailsComponent().phoneEmailVerificationComponent()
					.fillpin(data.get("code"));
			homePage.topBarComponent().userDetailsComponent().phoneEmailVerificationComponent()
					.verifyMessage(data.get("message"));
			Thread.sleep(2000);
			homePage.topBarComponent().userDetailsComponent().newEmailAddressPopup()
					.verifyNewEmailAddressHeading((data.get("newEmailPopUp")));
			homePage.topBarComponent().userDetailsComponent().newEmailAddressPopup()
					.verifyNewEmailAddressDescHeading(data.get("newEmailDesc"));
			homePage.topBarComponent().userDetailsComponent().phoneEmailVerificationComponent()
					.fillpin(data.get("code"));
			homePage.topBarComponent().userDetailsComponent().phoneEmailVerificationComponent()
					.verifyMessage(data.get("message"));
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happened due to this " + e);
		}
	}
}
