package coyni.merchant.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.pages.CustomerProfilePage;
import coyni.merchant.components.MerchantActivityComponent;
import coyni.merchant.components.PhoneVerificationComponent;
import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.components.TopBarComponent;
import coyni.merchant.pages.LoginPage;
import coyni.merchant.pages.MerchantProfilePage;
import coyni.merchant.pages.SignupPage;
import coyni.merchant.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class SignupTest {
	LoginPage loginPage;
	SignupPage signupPage;
	SideMenuBarComponent sideMenuBarComponent;
	PhoneVerificationComponent phoneVerificationComponent;
	MerchantActivityComponent merchantActivityComponent;
	TokenAccountPage tokenAccountPage;
	TopBarComponent topBarComponent;
	CustomerProfilePage customerProfilePage;
	MerchantProfilePage merchantProfilePage;

	@BeforeMethod
	public void init() {
		loginPage = new LoginPage();
		signupPage = new SignupPage();
		sideMenuBarComponent = new SideMenuBarComponent();
		phoneVerificationComponent = new PhoneVerificationComponent();
		tokenAccountPage = new TokenAccountPage();
		customerProfilePage = new CustomerProfilePage();
		topBarComponent = new TopBarComponent();
		merchantProfilePage = new MerchantProfilePage();
		merchantActivityComponent = new MerchantActivityComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testcreateAccount(String strParams) {
		try {
			WebDriver driver = DriverFactory.getDriver();
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// loginPage.clickSignUp();
			// signupPage.clickMerchantAccount();
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.clickeyeIcon();
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
			signupPage.phoneVerificationComponent().verifyPhoneNumber();
			signupPage.phoneVerificationComponent().fillpin(data.get("code"));
			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyEmailHeading(data.get("emailHeading"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().fillpin(data.get("code"));

			signupPage.scrollDownTermsOfService();
			signupPage.clickOnCheckBox();
			signupPage.clickNext();
			signupPage.scrollDownPrivacyPolicy();
			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyAccountCreated(data.get("createdAccountHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testcreateAccountThroughAdmin(String strParams) {
		try {
			WebDriver driver = DriverFactory.getDriver();
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// loginPage.clickSignUp();
			// signupPage.clickMerchantAccount();
			// new CommonFunctions().switchTodWindow();
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("merchantEmail"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.clickeyeIcon();
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
			signupPage.phoneVerificationComponent().verifyPhoneNumber();
			signupPage.phoneVerificationComponent().fillpin(data.get("code"));
			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyEmailHeading(data.get("emailHeading"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().fillpin(data.get("code"));

			signupPage.scrollDownTermsOfService();
			signupPage.clickOnCheckBox();
			signupPage.clickNext();
			signupPage.scrollDownPrivacyPolicy();
			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyAccountCreated(data.get("createdAccountHeading"));
			signupPage.verifyTwoStepDescription();
			signupPage.clickTwostepAuthy();
			signupPage.verifyTwoStepHeading();
			signupPage.phoneVerificationComponent().fillpin(data.get("code"));
			signupPage.verifyTwoStepSucess();
			signupPage.clickDone();
			// new CommonFunctions().closeCurrentWindow();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testcreateAccountWithNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickSignUp();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.clickMerchantAccount();
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().clickButtonGoBack();
			Thread.sleep(2000);
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().fillpin(data.get("code"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().clickButtonGoBack();
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().fillpin(data.get("code"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().fillpin(data.get("code"));

			signupPage.scrollDownTermsOfService();
			signupPage.clickOnCheckBox();
			signupPage.clickNext();
			signupPage.scrollDownPrivacyPolicy();

			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyAccountCreated(data.get("createdAccountHeading"));

		}

		catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testcreateAccountWithNavigationOptions Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testcreateAccountWithPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickSignUp();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.clickMerchantAccount();
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
			signupPage.phoneVerificationComponent().clickButtonGoBack();
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().fillpin(data.get("code"));
			signupPage.phoneVerificationComponent().clickLogin();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccountWithPhoneNumber Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testcreateAccountWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickSignUp();
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			signupPage.fillCreatePassword1(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			new CommonFunctions().clickOutSideElement();
			signupPage.clickNext();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			} else if (!data.get("toastMessage").isEmpty()) {
				signupPage.toastComponent().verifyToastSignup(data.get("toastTitle"), data.get("toastMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccountWithInvalidData Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testcreateAccountPhoneVerification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickSignUp();
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickCheckBox();
			signupPage.clickNext();
			Thread.sleep(3000);
			signupPage.phoneVerificationComponent().verifyPhoneVerificationHeading();
			signupPage.phoneVerificationComponent().verifPhoneVericationDescription();
			signupPage.phoneVerificationComponent().verifyPhoneVerificationNumber(data.get("PhoneVerificationNumber"));
			signupPage.phoneVerificationComponent().verifyVerificationCodeBoxAutoFocused();
			signupPage.phoneVerificationComponent().authyComponent().validateAuthyField(data.get("code"));
			signupPage.phoneVerificationComponent().authyComponent().fillAuthyInputInvalid(data.get("expCode"),
					data.get("Character"));
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
			signupPage.phoneVerificationComponent().clickResend();
			Thread.sleep(3000);
			signupPage.phoneVerificationComponent().verifyResendDescrp();
			for (int i = 0; i <= 5; i++) {
				signupPage.phoneVerificationComponent().clickResend();
			}

			signupPage.phoneVerificationComponent().verifyResendError();
			signupPage.phoneVerificationComponent().clickButtonGoBack();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.getPreviousData(data.get("firstName"), data.get("lastName"), data.get("phoneNumber"),
					data.get("email"), data.get("createPassword"), data.get("confirmPassword"));
			signupPage.verifyClearAndUpdateAllFileds(data.get("firstName"), data.get("lastName"),
					data.get("newPhoneNumber"), data.get("newEmail"), data.get("createPassword"),
					data.get("confirmPassword"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccountPhoneVerification Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testcreateAccountEmailVerification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickSignUp();
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickCheckBox();
			signupPage.clickNext();
			Thread.sleep(3000);
			signupPage.phoneVerificationComponent().verifyPhoneVerificationHeading();
			signupPage.phoneVerificationComponent().verifPhoneVericationDescription();
			signupPage.phoneVerificationComponent().verifyVerificationCodeBoxAutoFocused();
			signupPage.phoneVerificationComponent().authyComponent().fillInput(data.get("pin"));
			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyEmailHeading(data.get("emailHeading"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyEmailDescription();
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyEmail(data.get("emailDescrp"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyfirstCodeBoxAutoFocused();
			signupPage.phoneVerificationComponent().emailVerificationComponent().authyComponent()
					.validateAuthyField(data.get("code"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().authyComponent()
					.fillAuthyInputInvalid(data.get("expCode"), data.get("Character"));
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
			signupPage.phoneVerificationComponent().emailVerificationComponent().clickResendVerificationCode();
			Thread.sleep(3000);
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyResendDescription();
			for (int i = 0; i <= 5; i++) {
				signupPage.phoneVerificationComponent().emailVerificationComponent().clickResendVerificationCode();
			}

			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyResendError();
			signupPage.phoneVerificationComponent().emailVerificationComponent().clickGoBack();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.getPreviousData(data.get("firstName"), data.get("lastName"), data.get("phoneNumber"),
					data.get("email"), data.get("createPassword"), data.get("confirmPassword"));
			signupPage.verifyClearAndUpdateAllFileds(data.get("firstName"), data.get("lastName"),
					data.get("newPhoneNumber"), data.get("newEmail"), data.get("createPassword"),
					data.get("confirmPassword"));
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccountEmailVerification Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpWithInvalidPhoneOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickSignUp();
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
			signupPage.phoneVerificationComponent().verifyPhoneNumber();
			String[] msg = data.get("errMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				signupPage.phoneVerificationComponent().fillpin(data.get("code"));
				signupPage.phoneVerificationComponent().verifyMessage(msg[i]);
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpWithInvalidPhoneOTP Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testCreateAccountView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			signupPage.verifyBusinessAccountView();
			signupPage.verifyLoginView();
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.verifyFirstNameAutoFocus();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCreateAccountView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testValidateCreateAccountFields(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.validateFirstNameField(data.get("firstName"));
			signupPage.validateLastNameField(data.get("lastName"));
			signupPage.validatePhoneNumber(data.get("phoneNumber"));
			signupPage.validateEmailField(data.get("email"));
			signupPage.validatePassword(data.get("createPassword"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateCreateAccountFields Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpBusinessViaIndividual(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickPersonalAccount();
			signupPage.createPersonalAccountPage().verifyHeading(data.get("heading"));
			signupPage.createPersonalAccountPage().clickCreatePersonalAccount();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpBusinessViaIndividual Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpIndividualViaBusiness(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickOnPersonalAccount();
			// sideMenuBarComponent.verifyColor();
			sideMenuBarComponent.clickOnPersonalAccountDropDown();
			tokenAccountPage.userNameDropDownComponent().clickDropDown();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			customerProfilePage.userDetailsComponent().verifyAccountIdView();
			customerProfilePage.userDetailsComponent().verifyAccountStatusView();
			Thread.sleep(1000);
			sideMenuBarComponent.clickMerchantdrpdwn();
			sideMenuBarComponent.clickOnMerchantdrpdwn();
			sideMenuBarComponent.clickMerchantAccount();
			Thread.sleep(2000);
			signupPage.tokenAccountPage().clickTokenAccount();
			signupPage.tokenAccountPage().verifyHeading(data.get("heading"));
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			topBarComponent.userDetailsComponent().verifyAccountIdView();
			topBarComponent.userDetailsComponent().verifyAccountStatus();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpIndividualViaBusiness Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpBusinessViaCustomer(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickOnPersonalAccount();
			sideMenuBarComponent.clickOnPersonalAccountDropDown();
			// topBarComponent.clickUserNameDrpDwn();
			tokenAccountPage.userNameDropDownComponent().clickDropDown();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			customerProfilePage.userDetailsComponent().verifyAccountIdView();
			customerProfilePage.userDetailsComponent().verifyAccountStatusView();
			signupPage.tokenAccountPage().verifyHeading(data.get("heading"));
			signupPage.sideMenuBarComponent().clickQRCode();
			// signupPage.sideMenuBarComponent().myQRCodeComponent().verifyQRCodeDisplayed();
			signupPage.sideMenuBarComponent().myQRCodeComponent().getWalletAddress();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpIndividualViaBusiness Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpBusinessViaShared(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickSharedDropDown();
			sideMenuBarComponent.clickOnDBARecord();
			signupPage.registrationStartPage().verifyMerchantApplicationView();
			signupPage.tokenAccountPage().verifyHeading(data.get("heading"));
			signupPage.tokenAccountPage().clickTokenAccount();
			signupPage.tokenAccountPage().verifyAmount();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpBusinessViaShared Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpIndividualViaShared(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickOnPersonalAccount();
			sideMenuBarComponent.clickOnPersonalAccountDropDown();
			sideMenuBarComponent.clickSharedAccount();
			sideMenuBarComponent.clickOnDBARecord();
			signupPage.registrationStartPage().verifyMerchantApplicationView();
			signupPage.tokenAccountPage().verifyHeading(data.get("heading"));
			signupPage.tokenAccountPage().clickTokenAccount();
			signupPage.tokenAccountPage().verifyAmount();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpIndividualViaShared Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSwitchingAccounts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickSharedAccount();
			sideMenuBarComponent.clickOnDBARecord();
			signupPage.registrationStartPage().verifyMerchantApplicationView();
			sideMenuBarComponent.clickOnNewDBAAccount();
			sideMenuBarComponent.clickOnPersonalAccount();
			sideMenuBarComponent.clickOnPersonalAccountDropDown();
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickPreferences();
			customerProfilePage.preferencesComponent().selectDefaultAccount(data.get("defaultAccount"));
			customerProfilePage.preferencesComponent().clickSave();
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			topBarComponent.userDetailsComponent().verifyAccountIdView();
			topBarComponent.userDetailsComponent().verifyAccountStatus();
			// tokenAccountPage.verifyAmount();
			sideMenuBarComponent.clickMerchantdrpdwn();
			sideMenuBarComponent.clickOnMerchantdrpdwn();
			sideMenuBarComponent.clickMerchantAccount();
			Thread.sleep(2000);
			signupPage.tokenAccountPage().clickTokenAccount();
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickPreferences();
			merchantProfilePage.preferencesPage().selectDefaultAccount(data.get("defaultAccount1"));
//			sideMenuBarComponent.clickUserdrpdwn();
//			sideMenuBarComponent.clickSharedDropDown();
//			sideMenuBarComponent.clickSharedAccount();
			signupPage.tokenAccountPage().verifyHeading(data.get("heading"));

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSwitchingAccounts Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAUnderBusinessAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickAddDBA();
			sideMenuBarComponent.addDBABusinessPopup().clickNewCompany();
			// sideMenuBarComponent.addDBABusinessPopup().navigationComponent().clickBack();
			// sideMenuBarComponent.addDBABusinessPopup().clickNewCompany();
			sideMenuBarComponent.addDBABusinessPopup().addDBAUnderNewCompanyPopup().verifyHeading(data.get("heading"));
			sideMenuBarComponent.addDBABusinessPopup().addDBAUnderNewCompanyPopup().clickAddDBA();
			signupPage.registrationStartPage().getStatus();
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAUnderBusinessAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAUnderBusiness(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickAddDBA();
			sideMenuBarComponent.addDBABusinessPopup().clickNewMerchantDBA();
			// sideMenuBarComponent.addDBABusinessPopup().addNewDBAPopup().navigationComponent().clickBack();
			// sideMenuBarComponent.addDBABusinessPopup().clickNewMerchantDBA();
			// sideMenuBarComponent.addDBABusinessPopup().addNewDBAPopup().verifyHeading(data.get("heading"));
			sideMenuBarComponent.addDBABusinessPopup().addNewDBAPopup().selectCompany(data.get("dba"));
			sideMenuBarComponent.addDBABusinessPopup().addNewDBAPopup().clickDBA();
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAUnderBusinessAccount Failed due to Exception " + e);
		}
	}
}
