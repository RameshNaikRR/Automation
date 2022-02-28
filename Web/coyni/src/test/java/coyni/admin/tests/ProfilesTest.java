package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ProfilesTest {

	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualSideBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyUserName(data.get("expUserName"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyAccountID(data.get("expAccountID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().clickWebIcon();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().getWebLastSeen();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().clickMobileIcon();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().getMobileLastSeen();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyUserDetailsView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyPaymentMethodsView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyTokenAccountView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyPreferencesControlView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyAgreementsView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyAccountLimitsView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyActivityLogView();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualSideBarView Failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testIndividualUserDetailsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().clickUserDetails();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().UserDetailsComponent().verifyHeading(data.get("expHeading"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().UserDetailsComponent().verifyUserName(data.get("userName"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().UserDetailsComponent().verifyAccountID(data.get("expAccountID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().UserDetailsComponent().verifyAccountStatus(data.get("expAccountStatus"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().UserDetailsComponent().getPhoneNumber();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().UserDetailsComponent().getEmail();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().UserDetailsComponent().getAddress();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualUserDetailsView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualPaymentMethodView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().clickPaymentMethods();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().PaymentMethodsComponent().verifyHeading(data.get("expHeading"));
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualUserDetailsView Failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testIndividualsActivityLogView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().clickActivityLog();
		//	homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().A
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}
}
