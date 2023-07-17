package coyni.admin.paymentstests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.Paymentpages.CommissionAccountPage;
import coyni.admin.Paymentpages.HomePage;
import coyni.business.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessProfileTest {

	HomePage homePage;
	CommissionAccountPage commissionAccountPage;
	LoginPage loginPage;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

	static String mail;
	static String url;

	
	@Test
	@Parameters({ "strParams" })
	public void testAddMerchantUser(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickMerchantService();
			homePage.sideBarComponent().clickPayments();
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().addBusinessComponent().clickAddNewBusiness();
			homePage.sideBarComponent().addBusinessComponent().verifyMerchantHeading();
			homePage.sideBarComponent().addBusinessComponent().fillFirstName(data.get("firstName"));
			homePage.sideBarComponent().addBusinessComponent().fillLastName(data.get("lastName"));
			mail = homePage.sideBarComponent().addBusinessComponent().getEmail();
			homePage.sideBarComponent().addBusinessComponent().fillEmail(mail);// this line used for static email (Next
																				// time we can change the class name)
			homePage.sideBarComponent().addBusinessComponent().clickNext();
			homePage.sideBarComponent().addBusinessComponent().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().addBusinessComponent().clickUSCountry();
			homePage.sideBarComponent().addBusinessComponent().clickBusiness();
			homePage.sideBarComponent().addBusinessComponent().clickBusinessVerticalContent();
			homePage.sideBarComponent().addBusinessComponent().clickNext();
			homePage.sideBarComponent().addBusinessComponent().clickNext();
			homePage.sideBarComponent().addBusinessComponent().clickNext();
			homePage.sideBarComponent().addBusinessComponent().clickSend();
			homePage.sideBarComponent().addBusinessComponent().switchToYopmailWindow();
//			url = homePage.sideBarComponent().addBusinessComponent().getUrl();
//			homePage.sideBarComponent().addBusinessComponent().navigateUrl(url);
//			// new CommonFunctions().swtichToNewtabUrl(data.get("merchUrl"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	
}
