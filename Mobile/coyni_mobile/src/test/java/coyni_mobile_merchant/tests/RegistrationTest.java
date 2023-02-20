package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile_merchant.components.AgreementComponent;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import coyni_mobile_merchant.pages.DashBoardPage;
import coyni_mobile_merchant.pages.RegistrationDBAPage;
import coyni_mobile_merchant.pages.RegistrationProcessPage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class RegistrationTest {
	RegistrationProcessPage registrationProcessPage;
	RegistrationDBAPage registrationDBAPage;
	BusinessTokenAccountPage businessTokenAccountPage;
	AgreementComponent agreementComponent;

	@BeforeMethod
	public void init() {
		registrationProcessPage = new RegistrationProcessPage();
		registrationDBAPage = new RegistrationDBAPage();
		businessTokenAccountPage = new BusinessTokenAccountPage();
		agreementComponent = new AgreementComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testRegistrationCompanyInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationProcessPage.clickGetStarted();
			Thread.sleep(1000);
			registrationProcessPage.clickCompanyInfo();
			registrationProcessPage.registrationCompanyInfoPage().AddCompanyInfo(data.get("companyInfoHeading"),
					data.get("compName"), data.get("compEmail"), data.get("compPhNum"), data.get("compSSN"),
					data.get("compAddress1"), data.get("compAddress2"), data.get("compCity"), data.get("compState"),
					data.get("compZipCode"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRegistrationDBAInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			registrationProcessPage.clickDBAInfo();
			registrationProcessPage.registrationDBAPage().AddDBAInfo(data.get("dbaHeading"), data.get("dbaName"),
					data.get("dbaEmail"), data.get("dbaPhNum"), data.get("dbaBusinessType"), data.get("dbaWebsite"),
					data.get("dbaVolume"), data.get("dbaHighTicket"), data.get("dbaAverageTicket"),
					data.get("dbaAddress1"), data.get("dbaAddress2"), data.get("dbaCity"), data.get("dbaState"),
					data.get("dbaZipCode"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRegistrationBeneficialOwners(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			registrationProcessPage.clickBeneficialOwners();
			registrationProcessPage.registrationBeneficialOwnerPage().AddEditBeneficialOwner(
					data.get("beneficialHeading"), data.get("beneFirstName"), data.get("beneLastName"),
					data.get("beneSSN"), data.get("beneOwnership"), data.get("beneAddress1"), data.get("beneAddress2"),
					data.get("beneCity"), data.get("beneZipCode"), data.get("beneState"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRegistrationADDBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationProcessPage.clickAddBank();
			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
			merchantProfileTest.testAddBankAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}
//	
//	@Test
//	@Parameters({ "strParams" })
//	public void testRegistrationMerchantAgreements(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			Thread.sleep(1000);
//			registrationProcessPage.clickMerchantAgreement();
//			registrationProcessPage.registrationMerchantAgreementsPage().AcceptMerchantAgreement();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//
//	}

	@Test
	@Parameters({ "strParams" })
	public void testRegistrationReviewApplication(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationProcessPage.clickMerchantAgreement();
			registrationProcessPage.registrationMerchantAgreementsPage().VerifyAgreementsTerms();
			agreementComponent.verifyTermsOfServiceUpdateForSignUp(data.get("termsOfServiceHeading"));
			registrationProcessPage.registrationMerchantAgreementsPage().VerifyAgreementsPrivacyPolicy();
			agreementComponent.verifyPrivacyPolicyHeadingForSignUp(data.get("privacyPolicyHeading"));
			registrationProcessPage.registrationMerchantAgreementsPage().clickAgreementsDone();
			registrationProcessPage.clickReviewApplication();
			registrationProcessPage.reviewApplicationPage().verifyReviewApplication(data.get("reviewHeading"),
					data.get("reviewCompanyInfoHeading"), data.get("reviewDBAHeading"),
					data.get("reviewBeneficialHeading"), data.get("reviewAgreeHeading"));
			registrationProcessPage.registrationMerchantAgreementsPage().VerifyApplicationDisclosure();
			businessTokenAccountPage.dashBoardPage().VerifyUser();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	public void testAddDBA() {
		try {
			businessTokenAccountPage.clickChooseUser();
			businessTokenAccountPage.clickSelectAccount();
			businessTokenAccountPage.clickAddDBA();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testAddDBA Failed due to this Exception" + e);
		}
	}

	@Test
	public void testAddNewCompanyInBusinessAccount() {
		try {
			businessTokenAccountPage.clickChooseUser();
			Thread.sleep(3000);
			businessTokenAccountPage.clickOpenNewAccount();
			businessTokenAccountPage.clickBusinessAccount();
			businessTokenAccountPage.clickNewCompany();
//			businessTokenAccountPage.clickEnabledAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testAddDBA Failed due to this Exception" + e);
		}
	}

	@Test
	public void testOpenNewAccountWithNewDBA() {
		try {
			businessTokenAccountPage.clickChooseUser();
			Thread.sleep(3000);
			businessTokenAccountPage.clickOpenNewAccount();
			businessTokenAccountPage.clickBusinessAccount();
			businessTokenAccountPage.clickNewDBA();
			businessTokenAccountPage.clickEnabledAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testAddDBA Failed due to this Exception" + e);
		}
	}

	@Test
	public void testAddPersonalAccount() {
		try {
			businessTokenAccountPage.clickChooseUser();
			Thread.sleep(3000);
			businessTokenAccountPage.clickOpenNewAccount();
			businessTokenAccountPage.clickPersonalAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testAddDBA Failed due to this Exception" + e);
		}
	}

}
