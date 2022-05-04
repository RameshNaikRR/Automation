package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class MerchantProfileTest {

	MerchantProfilePage merchantProfilePage;

	@BeforeTest
	public void init() {
		merchantProfilePage = new MerchantProfilePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantProfilePage.clickProfile();
			merchantProfilePage.verifyPreferencesView();
			merchantProfilePage.clickPreferences();
			merchantProfilePage.preferencesComponent().verifyPreferencesHeading(data.get("heading"));
			merchantProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// tokenAccountPage.clickProfile();
			merchantProfilePage.verifyAccountLimitsView();
			merchantProfilePage.clickAccountLimits();
			merchantProfilePage.accountLimitsComponent().verifyHeading(data.get("expHeading"));
			merchantProfilePage.accountLimitsComponent().verifyPayRequestLabel(data.get("expPayRequestHeading"));
			merchantProfilePage.accountLimitsComponent().verifyBuyTokensLabel(data.get("expBuyTokenHeading"));
			merchantProfilePage.accountLimitsComponent().VerifyWithdrawLabel(data.get("expWithdrawHeading"));
			merchantProfilePage.accountLimitsComponent().getPayRequestLimit();
			merchantProfilePage.accountLimitsComponent().getBuyTokenBankLimit();
			merchantProfilePage.accountLimitsComponent().getCardsLimit();
			merchantProfilePage.accountLimitsComponent().getWithdrawBankLimit();
			merchantProfilePage.accountLimitsComponent().getInstantPayLimit();
			merchantProfilePage.accountLimitsComponent().getGiftCardLimit();
			merchantProfilePage.accountLimitsComponent().navigationComponent().verifyBackView();
			merchantProfilePage.accountLimitsComponent().navigationComponent().clickBack();
			merchantProfilePage.verifyProfilePageView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimits Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// tokenAccountPage.clickProfile();
			merchantProfilePage.verifyAgreementsView();
			merchantProfilePage.clickAgreements();
			merchantProfilePage.agreementComponent().verifyHeading(data.get("agreeHeading"));
//			customerProfilePage.agreementComponent().verifyActiveAgreementsView();
//			customerProfilePage.agreementComponent().verifyPastAgreementsView();
//			customerProfilePage.agreementComponent().verifyActiveAgreementsHeading(data.get("ActiveHeading"));
//			customerProfilePage.agreementComponent().verifyPastAgreementsHeading(data.get("pastHeading"));
			merchantProfilePage.agreementComponent().verifyPrivacyPolicyView();
			merchantProfilePage.agreementComponent().verifyTermsOfServiceView();
			merchantProfilePage.agreementComponent().clickBack();
			merchantProfilePage.verifyProfilePageView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAgreements Failed due to exception " + e);

		}
	}

	@Test
	public void testLogOut() {
		try {
			// tokenAccountPage.clickProfile();
			merchantProfilePage.verifyLogOut();
			merchantProfilePage.clickLogOut();
			// merchantProfilePage.signUpPage().verifyGetStarted();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLogOut failed due to exception " + e);
		}
	}

}