package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.LandingPage;
import coyni_mobile_merchant.pages.RegistrationDBAPage;
import coyni_mobile_merchant.pages.RegistrationProcessPage;
import coyni_mobile_merchant.pages.SignUpPage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;
	LandingPage landingPage;
	RegistrationProcessPage registrationProcessPage;
	RegistrationDBAPage registrationDBAPage;

	@BeforeMethod
	public void init() {
		signUpPage = new SignUpPage();
		landingPage = new LandingPage();
		registrationProcessPage = new RegistrationProcessPage();
		registrationDBAPage = new RegistrationDBAPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUp(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
//			signUpPage.clickCrossMark();
//			signUpPage.clickGetStarted();
			signUpPage.clickBusinessAccount();
//			signUpPage.clickCrossMark();
//			signUpPage.clickGetStarted();
//			signUpPage.clickPersonalAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			// DriverFactory.getDriver().hideKeyboard();
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickAgreeCheckBox();
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			Thread.sleep(4000);
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
					.verifyHeading(data.get("secureYourAccountHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickNext();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.verifyHeading(data.get("enableFaceIdHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.clickNotNow();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.accountCreatedPage().verifyHeading(data.get("createAccountHeading"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.accountCreatedPage().clickSkip();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.tokenAccountPage().verifyRegistration();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUp Failed due to this Exception" + e);
		}

	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testSignUpWithInvalidData(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			landingPage.clickGetStarted();
//			signUpPage.clickPersonalAccount();
//			signUpPage.verifyCreateAccount(data.get("createAccount"));
//			signUpPage.fillFirstName(data.get("firstName"));
//			signUpPage.fillLastName(data.get("lastName"));
//			signUpPage.fillEmail(data.get("email"));
//			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
//			signUpPage.fillPassword(data.get("password"));
//			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
//			signUpPage.clickNext();
//			if (!data.get("errMessage").isEmpty()) {
//				if (new CommonFunctions().isPlatformiOS()) {
//					new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
//				} else {
//					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
//				}
//			}
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testSignUpWithInvalidData Failed due to this Exception" + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testCreateAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickBusinessAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			signUpPage.fillPassword(data.get("password"));
			if (signUpPage.fieldBarCount() == 3) {
				ExtentTestManager.setPassMessageInReport("Password is valid");
			} else {
				ExtentTestManager.setPassMessageInReport("password is invalid");
			}
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.scrollUpToFirstName();
//			signUpPage.clickNext();
			if (!data.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
				} else {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
				}
			}
//			if (!data.get("errorMessage").isEmpty()) {
//				// Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.SECONDS);
//				new CommonFunctions().validateFormErrorMessage(data.get("errorMessage"), data.get("elementName"));
//
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testFieldValidationCreateAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickPersonalAccount();
			signUpPage.fillFirstName(data.get("firstName"));
			new CommonFunctions().clickEnter();
			Thread.sleep(10000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRegistration(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			registrationProcessPage.clickGetStarted();
//			Thread.sleep(2000);
//          registrationProcessPage.clickCompanyInfo();
//			registrationProcessPage.registrationCompanyInfoPage().AddCompanyInfo(data.get("companyInfoHeading"),data.get("compName"),data.get("compEmail"),data.get("compPhNum"),data.get("compSSN"),data.get("compAddress1"),data.get("compAddress2"),data.get("compCity"),data.get("compState"),data.get("compZipCode"));
//			registrationProcessPage.clickDBAInfo();
//			registrationProcessPage.registrationDBAPage().AddDBAInfo(data.get("dbaHeading"),
//					data.get("dbaName"), data.get("dbaEmail"), data.get("dbaPhNum"), data.get("dbaBusinessType"), data.get("dbaWebsite"), data.get("dbaVolume"), data.get("dbaHighTicket"),data.get("dbaAverageTicket"),
//					data.get("dbaAddress1"), data.get("dbaAddress2"), data.get("dbaCity"), data.get("dbaState"),data.get("dbaZipCode"));
//			registrationProcessPage.clickBeneficialOwners();
//		    registrationProcessPage.registrationBeneficialOwnerPage().AddEditBeneficialOwner(data.get("beneficialHeading"),
//					data.get("firstName"), data.get("lastName"), data.get("ssn"), data.get("ownership"),
//					data.get("address1"), data.get("address2"), data.get("city"), data.get("zipCode"),data.get("state"));
//			registrationProcessPage.clickAddBank();
//			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
//			merchantProfileTest.testAddBankAccount(strParams);
//			registrationProcessPage.clickMerchantAgreement();
//			registrationProcessPage.registrationMerchantAgreementsPage().AcceptMerchantAgreement();
//			registrationProcessPage.clickReviewApplication();
//			registrationProcessPage.reviewApplicationPage().verifyReviewApplication(data.get("reviewHeading"), data.get("companyInfoHeading"), data.get("dbaHeading"), data.get("beneficialHeading"), data.get("agreeHeading"));
			
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}
	
	
	@Test
	@Parameters({ "strParams" })
	public void testRegistrationCompanyInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			registrationProcessPage.clickGetStarted();
//			Thread.sleep(2000);
            registrationProcessPage.clickCompanyInfo();
			registrationProcessPage.registrationCompanyInfoPage().AddCompanyInfo(data.get("companyInfoHeading"),data.get("compName"),data.get("compEmail"),data.get("compPhNum"),data.get("compSSN"),data.get("compAddress1"),data.get("compAddress2"),data.get("compCity"),data.get("compState"),data.get("compZipCode"));
//			registrationProcessPage.clickDBAInfo();
//			registrationProcessPage.registrationDBAPage().AddDBAInfo(data.get("dbaHeading"),
//					data.get("dbaName"), data.get("dbaEmail"), data.get("dbaPhNum"), data.get("dbaBusinessType"), data.get("dbaWebsite"), data.get("dbaVolume"), data.get("dbaHighTicket"),data.get("dbaAverageTicket"),
//					data.get("dbaAddress1"), data.get("dbaAddress2"), data.get("dbaCity"), data.get("dbaState"),data.get("dbaZipCode"));
//			registrationProcessPage.clickBeneficialOwners();
//		    registrationProcessPage.registrationBeneficialOwnerPage().AddEditBeneficialOwner(data.get("beneficialHeading"),
//					data.get("firstName"), data.get("lastName"), data.get("ssn"), data.get("ownership"),
//					data.get("address1"), data.get("address2"), data.get("city"), data.get("zipCode"),data.get("state"));
//			registrationProcessPage.clickAddBank();
//			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
//			merchantProfileTest.testAddBankAccount(strParams);
//			registrationProcessPage.clickMerchantAgreement();
//			registrationProcessPage.registrationMerchantAgreementsPage().AcceptMerchantAgreement();
//			registrationProcessPage.clickReviewApplication();
//			registrationProcessPage.reviewApplicationPage().verifyReviewApplication(data.get("reviewHeading"), data.get("companyInfoHeading"), data.get("dbaHeading"), data.get("beneficialHeading"), data.get("agreeHeading"));
			
			
			
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
//			registrationProcessPage.clickGetStarted();
//			Thread.sleep(2000);
//          registrationProcessPage.clickCompanyInfo();
//			registrationProcessPage.registrationCompanyInfoPage().AddCompanyInfo(data.get("companyInfoHeading"),data.get("compName"),data.get("compEmail"),data.get("compPhNum"),data.get("compSSN"),data.get("compAddress1"),data.get("compAddress2"),data.get("compCity"),data.get("compState"),data.get("compZipCode"));
			registrationProcessPage.clickDBAInfo();
			registrationProcessPage.registrationDBAPage().AddDBAInfo(data.get("dbaHeading"),
					data.get("dbaName"), data.get("dbaEmail"), data.get("dbaPhNum"), data.get("dbaBusinessType"), data.get("dbaWebsite"), data.get("dbaVolume"), data.get("dbaHighTicket"),data.get("dbaAverageTicket"),
					data.get("dbaAddress1"), data.get("dbaAddress2"), data.get("dbaCity"), data.get("dbaState"),data.get("dbaZipCode"));
//			registrationProcessPage.clickBeneficialOwners();
//		    registrationProcessPage.registrationBeneficialOwnerPage().AddEditBeneficialOwner(data.get("beneficialHeading"),
//					data.get("firstName"), data.get("lastName"), data.get("ssn"), data.get("ownership"),
//					data.get("address1"), data.get("address2"), data.get("city"), data.get("zipCode"),data.get("state"));
//			registrationProcessPage.clickAddBank();
//			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
//			merchantProfileTest.testAddBankAccount(strParams);
//			registrationProcessPage.clickMerchantAgreement();
//			registrationProcessPage.registrationMerchantAgreementsPage().AcceptMerchantAgreement();
//			registrationProcessPage.clickReviewApplication();
//			registrationProcessPage.reviewApplicationPage().verifyReviewApplication(data.get("reviewHeading"), data.get("companyInfoHeading"), data.get("dbaHeading"), data.get("beneficialHeading"), data.get("agreeHeading"));
			
			
			
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
//			registrationProcessPage.clickGetStarted();
//			Thread.sleep(2000);
//          registrationProcessPage.clickCompanyInfo();
//			registrationProcessPage.registrationCompanyInfoPage().AddCompanyInfo(data.get("companyInfoHeading"),data.get("compName"),data.get("compEmail"),data.get("compPhNum"),data.get("compSSN"),data.get("compAddress1"),data.get("compAddress2"),data.get("compCity"),data.get("compState"),data.get("compZipCode"));
//			registrationProcessPage.clickDBAInfo();
//			registrationProcessPage.registrationDBAPage().AddDBAInfo(data.get("dbaHeading"),
//					data.get("dbaName"), data.get("dbaEmail"), data.get("dbaPhNum"), data.get("dbaBusinessType"), data.get("dbaWebsite"), data.get("dbaVolume"), data.get("dbaHighTicket"),data.get("dbaAverageTicket"),
//					data.get("dbaAddress1"), data.get("dbaAddress2"), data.get("dbaCity"), data.get("dbaState"),data.get("dbaZipCode"));
			registrationProcessPage.clickBeneficialOwners();
		    registrationProcessPage.registrationBeneficialOwnerPage().AddEditBeneficialOwner(data.get("beneficialHeading"),
					data.get("firstName"), data.get("lastName"), data.get("ssn"), data.get("ownership"),
					data.get("address1"), data.get("address2"), data.get("city"), data.get("zipCode"),data.get("state"));
//			registrationProcessPage.clickAddBank();
//			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
//			merchantProfileTest.testAddBankAccount(strParams);
//			registrationProcessPage.clickMerchantAgreement();
//			registrationProcessPage.registrationMerchantAgreementsPage().AcceptMerchantAgreement();
//			registrationProcessPage.clickReviewApplication();
//			registrationProcessPage.reviewApplicationPage().verifyReviewApplication(data.get("reviewHeading"), data.get("companyInfoHeading"), data.get("dbaHeading"), data.get("beneficialHeading"), data.get("agreeHeading"));
//			
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}
	@Test
	@Parameters({ "strParams" })
	public void testRegistrationADDBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
//			registrationProcessPage.clickGetStarted();
//			Thread.sleep(2000);
//          registrationProcessPage.clickCompanyInfo();
//			registrationProcessPage.registrationCompanyInfoPage().AddCompanyInfo(data.get("companyInfoHeading"),data.get("compName"),data.get("compEmail"),data.get("compPhNum"),data.get("compSSN"),data.get("compAddress1"),data.get("compAddress2"),data.get("compCity"),data.get("compState"),data.get("compZipCode"));
//			registrationProcessPage.clickDBAInfo();
//			registrationProcessPage.registrationDBAPage().AddDBAInfo(data.get("dbaHeading"),
//					data.get("dbaName"), data.get("dbaEmail"), data.get("dbaPhNum"), data.get("dbaBusinessType"), data.get("dbaWebsite"), data.get("dbaVolume"), data.get("dbaHighTicket"),data.get("dbaAverageTicket"),
//					data.get("dbaAddress1"), data.get("dbaAddress2"), data.get("dbaCity"), data.get("dbaState"),data.get("dbaZipCode"));
//			registrationProcessPage.clickBeneficialOwners();
//		    registrationProcessPage.registrationBeneficialOwnerPage().AddEditBeneficialOwner(data.get("beneficialHeading"),
//					data.get("firstName"), data.get("lastName"), data.get("ssn"), data.get("ownership"),
//					data.get("address1"), data.get("address2"), data.get("city"), data.get("zipCode"),data.get("state"));
			registrationProcessPage.clickAddBank();
			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
			merchantProfileTest.testAddBankAccount(strParams);
//			registrationProcessPage.clickMerchantAgreement();
//			registrationProcessPage.registrationMerchantAgreementsPage().AcceptMerchantAgreement();
//			registrationProcessPage.clickReviewApplication();
//			registrationProcessPage.reviewApplicationPage().verifyReviewApplication(data.get("reviewHeading"), data.get("companyInfoHeading"), data.get("dbaHeading"), data.get("beneficialHeading"), data.get("agreeHeading"));
//			
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}
	
	@Test
	@Parameters({ "strParams" })
	public void testRegistrationMerchantAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
//			registrationProcessPage.clickGetStarted();
//			Thread.sleep(2000);
//          registrationProcessPage.clickCompanyInfo();
//			registrationProcessPage.registrationCompanyInfoPage().AddCompanyInfo(data.get("companyInfoHeading"),data.get("compName"),data.get("compEmail"),data.get("compPhNum"),data.get("compSSN"),data.get("compAddress1"),data.get("compAddress2"),data.get("compCity"),data.get("compState"),data.get("compZipCode"));
//			registrationProcessPage.clickDBAInfo();
//			registrationProcessPage.registrationDBAPage().AddDBAInfo(data.get("dbaHeading"),
//					data.get("dbaName"), data.get("dbaEmail"), data.get("dbaPhNum"), data.get("dbaBusinessType"), data.get("dbaWebsite"), data.get("dbaVolume"), data.get("dbaHighTicket"),data.get("dbaAverageTicket"),
//					data.get("dbaAddress1"), data.get("dbaAddress2"), data.get("dbaCity"), data.get("dbaState"),data.get("dbaZipCode"));
//			registrationProcessPage.clickBeneficialOwners();
//		    registrationProcessPage.registrationBeneficialOwnerPage().AddEditBeneficialOwner(data.get("beneficialHeading"),
//					data.get("firstName"), data.get("lastName"), data.get("ssn"), data.get("ownership"),
//					data.get("address1"), data.get("address2"), data.get("city"), data.get("zipCode"),data.get("state"));
//			registrationProcessPage.clickAddBank();
//			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
//			merchantProfileTest.testAddBankAccount(strParams);
			registrationProcessPage.clickMerchantAgreement();
			registrationProcessPage.registrationMerchantAgreementsPage().AcceptMerchantAgreement();
//			registrationProcessPage.clickReviewApplication();
//			registrationProcessPage.reviewApplicationPage().verifyReviewApplication(data.get("reviewHeading"), data.get("companyInfoHeading"), data.get("dbaHeading"), data.get("beneficialHeading"), data.get("agreeHeading"));
			
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}
	@Test
	@Parameters({ "strParams" })
	public void testRegistrationReviewApplication(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
//			registrationProcessPage.clickGetStarted();
//			Thread.sleep(2000);
//          registrationProcessPage.clickCompanyInfo();
//			registrationProcessPage.registrationCompanyInfoPage().AddCompanyInfo(data.get("companyInfoHeading"),data.get("compName"),data.get("compEmail"),data.get("compPhNum"),data.get("compSSN"),data.get("compAddress1"),data.get("compAddress2"),data.get("compCity"),data.get("compState"),data.get("compZipCode"));
//			registrationProcessPage.clickDBAInfo();
//			registrationProcessPage.registrationDBAPage().AddDBAInfo(data.get("dbaHeading"),
//					data.get("dbaName"), data.get("dbaEmail"), data.get("dbaPhNum"), data.get("dbaBusinessType"), data.get("dbaWebsite"), data.get("dbaVolume"), data.get("dbaHighTicket"),data.get("dbaAverageTicket"),
//					data.get("dbaAddress1"), data.get("dbaAddress2"), data.get("dbaCity"), data.get("dbaState"),data.get("dbaZipCode"));
//			registrationProcessPage.clickBeneficialOwners();
//		    registrationProcessPage.registrationBeneficialOwnerPage().AddEditBeneficialOwner(data.get("beneficialHeading"),
//					data.get("firstName"), data.get("lastName"), data.get("ssn"), data.get("ownership"),
//					data.get("address1"), data.get("address2"), data.get("city"), data.get("zipCode"),data.get("state"));
//			registrationProcessPage.clickAddBank();
//			MerchantProfileTest merchantProfileTest = new MerchantProfileTest();
//			merchantProfileTest.testAddBankAccount(strParams);
//			registrationProcessPage.clickMerchantAgreement();
//			registrationProcessPage.registrationMerchantAgreementsPage().AcceptMerchantAgreement();
//			registrationProcessPage.clickReviewApplication();
//			registrationProcessPage.reviewApplicationPage().verifyReviewApplication(data.get("reviewHeading"), data.get("companyInfoHeading"), data.get("dbaHeading"), data.get("beneficialHeading"), data.get("agreeHeading"));
			
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testRegistrationDBA(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			
//			registrationCompanyInfoPage.clickGetStarted();
//			registrationDBAPage.clickDBAInfo();
//			DriverFactory.getDriver().hideKeyboard();
//			registrationCompanyInfoPage.clickNext();
//			DriverFactory.getDriver().hideKeyboard();
//			registrationCompanyInfoPage.clickNext();
//			registrationCompanyInfoPage.clickArticles();
//			registrationCompanyInfoPage.clickTakePhoto();
//			registrationCompanyInfoPage.clickCapture();
//			registrationCompanyInfoPage.clickSave();
//			
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//
//	}

}
