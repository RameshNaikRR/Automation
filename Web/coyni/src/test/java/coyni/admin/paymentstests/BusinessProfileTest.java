package coyni.admin.paymentstests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import coyni.admin.pages.LoginPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessProfileTest {

	HomePage homePage;
	// CommissionAccountPage commissionAccountPage;
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

			Thread.sleep(8000);
			/*
			 * if (!data.get("toastMerchantInvitation").isEmpty()) {
			 * loginPage.toastComponent().verifyToast(data.get("toastTitle1"),
			 * data.get("toastMerchantInvitation")); } Thread.sleep(2000);
			 */
			url = homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().getUrl();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().navigateUrl(url);
			Thread.sleep(2000);
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent()
					.verifyInviteHeading(data.get("inviteHeading"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().clickNewAccount();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent()
					.verifyCreateAccountHeading(data.get("CreateAccountHeading"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.fillFirstName(data.get("firstName"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.fillLastName(data.get("lastName"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.fillEmail1(mail);
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.fillPhoneNumber();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.fillCreatePassword();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.fillConfirmPassword();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.clickNext();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.phoneEmailVerificationComponent().verifyPhoneHeading(data.get("phoneHeading"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.phoneEmailVerificationComponent().fillpin(data.get("code"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.phoneEmailVerificationComponent().verifyPageHeading(data.get("emailHeading"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.phoneEmailVerificationComponent().fillpin(data.get("code"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.phoneEmailVerificationComponent().scrollToTermsAgree();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().activateAccountComponent()
					.phoneEmailVerificationComponent().scrollToPrivacyAgree();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddToExistingAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			System.out.println(data);
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

			Thread.sleep(8000);
			/*
			 * if (!data.get("toastMerchantInvitation").isEmpty()) {
			 * loginPage.toastComponent().verifyToast(data.get("toastTitle1"),
			 * data.get("toastMerchantInvitation")); } Thread.sleep(2000);
			 */
			url = homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().getUrl();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().navigateUrl(url);
			Thread.sleep(2000);
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent()
					.verifyInviteHeading(data.get("inviteHeading"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().clickAddToExistingAccount();
//			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().verifyPageHeading(data.get("loginHeading"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().fillEmail(data.get("businessEmail"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().fillPassword(data.get("businessPassword"));
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().clickExistingAccountCheckBox();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().clickNext();
			homePage.sideBarComponent().addBusinessComponent().businessInviteComponent().clickOnAccount();
			Thread.sleep(2000);
			if (data.get("securityKey").equalsIgnoreCase("123456")) {
				loginPage.authyComponent().fillInput(data.get("securityKey"));
			} else {
				loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
				ExtentTestManager.setInfoMessageInReport("ok ");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}
}
