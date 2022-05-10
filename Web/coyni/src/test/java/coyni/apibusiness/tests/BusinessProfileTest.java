package coyni.apibusiness.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.apibusiness.components.BusinessSettingsSideBarMenuComponent;
import coyni.apibusiness.components.PhoneEmailVerificationComponent;
import coyni.apibusiness.components.TopBarComponent;
import coyni.apibusiness.components.UserDetailsComponent;
import coyni.apibusiness.pages.APIAdminProfilePage;
import coyni.apibusiness.pages.HomePage;
import coyni.apibusiness.pages.TokenWalletPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessProfileTest {
	PhoneEmailVerificationComponent phoneEmailVerificationComponent;
	TokenWalletPage tokenWalletPage;
	TopBarComponent topBarComponent;
	UserDetailsComponent userDetailsComponent;
	APIAdminProfilePage apiAdminProfilePage;
	HomePage homePage;
	BusinessSettingsSideBarMenuComponent businessSettingsMenuComponent;

	@BeforeTest
	public void init() {
		userDetailsComponent = new UserDetailsComponent();
		topBarComponent = new TopBarComponent();
		tokenWalletPage = new TokenWalletPage();
		phoneEmailVerificationComponent = new PhoneEmailVerificationComponent();
		apiAdminProfilePage = new APIAdminProfilePage();
		homePage = new HomePage();
		businessSettingsMenuComponent = new BusinessSettingsSideBarMenuComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);

			tokenWalletPage.topBarComponent().clickUserName();
			tokenWalletPage.topBarComponent().clickChangePassword();
			tokenWalletPage.topBarComponent().authyComponent().verifyYourIdentityHeading(data.get("identityHeading"));
			tokenWalletPage.topBarComponent().authyComponent()
					.verifyYourIdentityDescription(data.get("identityDescription"));
			tokenWalletPage.topBarComponent().authyComponent().fillInput(data.get("code"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.verifyPageHeading(data.get("changePasswordHeading"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.VerifyPageDescription(data.get("changePasswordDescription"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillCurrentPassword(data.get("currentPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconCurrentPassword();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.verifyNewPassword(data.get("newPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconNewPassowrd();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test change password failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			// APIAdminMenuComponent.clickUserName();
			tokenWalletPage.topBarComponent().clickUserName();
			tokenWalletPage.topBarComponent().clickChangePassword();
			tokenWalletPage.topBarComponent().authyComponent().verifyYourIdentityHeading(data.get("identityHeading"));
			tokenWalletPage.topBarComponent().authyComponent().fillInput(data.get("code"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.verifyPageHeading(data.get("changePasswordHeading"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillCurrentPassword(data.get("currentPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillNewPassword(data.get("newPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickOutSide();

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordWithInvalidData failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenWalletPage.topBarComponent().clickUserName();
			tokenWalletPage.topBarComponent().clickChangePassword();
			tokenWalletPage.topBarComponent().authyComponent().verifyYourIdentityHeading(data.get("identityHeading"));
			tokenWalletPage.topBarComponent().authyComponent().fillInput(data.get("code"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.verifyPageHeading(data.get("changePasswordHeading"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillCurrentPassword(data.get("currentPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconCurrentPassword();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyCurrentPasswordMaskedView();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconCurrentPassword();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyCurrentPasswordMaskedView();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillNewPassword(data.get("newPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconNewPassowrd();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyNewPasswordMaskedView();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconNewPassowrd();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyNewPasswordMaskedView();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyConfirmPasswordMaskedView();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyConfirmPasswordMaskedView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordView failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailAddressNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().clickUserName();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().clickUserDetails();
			// UserDetails-- Edit Email Authentication
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading1(data.get("emailHeading1"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading2(data.get("emailHeading2"));
//			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
//					.verifyEmailAddressDescHeading(data.get("emailAddressAuthDesc"));
			// UserDetails --- Edit Email Authentication close navigation
			tokenWalletPage.userDetailsComponent().navigationComponent().clickClose();
			tokenWalletPage.userDetailsComponent().verifyUserDetailsView();
			// UserDetails--Edit Email Address close navigation
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading1(data.get("emailHeading1"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading2(data.get("emailHeading2"));
//			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
//					.verifyEmailAddressDescHeading(data.get("emailAddressAuthDesc"));
			tokenWalletPage.userDetailsComponent().emailAddressAuthenticationPopup().authyComponent()
					.fillInput(data.get("code"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddressHeading(data.get("emailAddressHeading"));
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup().navigationComponent()
					.clickClose();
			tokenWalletPage.userDetailsComponent().verifyUserDetailsView();
//			UserDetails---- Current Email Address close navigation
			// Current Email Address-Back Navigation Back
			tokenWalletPage.userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.userDetailsComponent().authyComponent().fillInput(data.get("code"));
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().fillNewEmailText(data.get("newEmail"));
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().clickOutside();
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().clickEmailSendCode();
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().currentEmailAddressPopup()
					.verifyCurrentEmailAddressHeading(data.get("emailHeading"));
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().currentEmailAddressPopup().authyComponent()
					.fillInput(data.get("code"));
			Thread.sleep(1000);
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().currentEmailAddressPopup()
					.navigationComponent().clickClose();
			tokenWalletPage.userDetailsComponent().verifyUserDetailsView();
//			UserDetails --- New Email Address close navigation
			tokenWalletPage.userDetailsComponent().clickIconEditEmail();
			Thread.sleep(10000);
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().currentEmailAddressPopup().authyComponent()
					.fillInput(data.get("code"));
			Thread.sleep(1000);
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().currentEmailAddressPopup()
					.newEmailAddressPopup().verifyNewEmailAddressHeading(data.get("newEmailPopUp"));
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().currentEmailAddressPopup()
					.newEmailAddressPopup().authyComponent().fillInput(data.get("code"));
			tokenWalletPage.userDetailsComponent().editEmailAddressPopup().currentEmailAddressPopup()
					.newEmailAddressPopup().navigationComponent().clickClose();
			tokenWalletPage.userDetailsComponent().verifyUserDetailsView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("	Exception happened due to this " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.topBarComponent().clickUserName();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().clickUserDetails();
			tokenWalletPage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading1(data.get("emailHeading1"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading2(data.get("emailHeading2"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup().authyComponent()
					.fillInput((data.get("code")));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddressHeading(data.get("emailAddressHeading"));
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailText(data.get("newEmail"));
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup().clickOutside();
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup().clickEmailSendCode();
			tokenWalletPage.topBarComponent().userDetailsComponent().currentEmailAddressPopup()
					.verifyCurrentEmailAddressHeading(data.get("emailHeading"));
			Thread.sleep(2000);
			tokenWalletPage.topBarComponent().userDetailsComponent().currentEmailAddressPopup().authyComponent()
					.fillInput(data.get("code"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().currentEmailAddressPopup().authyComponent()
					.verifyMessage(data.get("message"));
			Thread.sleep(2000);
			tokenWalletPage.topBarComponent().userDetailsComponent().newEmailAddressPopup()
					.verifyNewEmailAddressHeading((data.get("newEmailPopUp")));
			tokenWalletPage.topBarComponent().userDetailsComponent().newEmailAddressPopup()
					.phoneEmailVerificationComponent().authyComponent().fillInput(data.get("code"));

			tokenWalletPage.topBarComponent().userDetailsComponent().newEmailAddressPopup()
					.phoneEmailVerificationComponent().authyComponent().verifyMessage(data.get("message"));
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happened due to this " + e);
		}
	}

	@Test()
	@Parameters({ "strParams" })
	public void testEditEmailAddressInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.topBarComponent().clickUserName();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().clickUserDetails();
			tokenWalletPage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup().authyComponent()
					.fillInput(data.get("code"));
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddressHeading(data.get("emailAddressHeading"));
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailText(data.get("newEmail"));
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup().clickOutside();
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup().clickEmailSendCode();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

			}
			new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
					data.get("elementName"));

			Thread.sleep(5000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"Test UserDetails Email Address  Authentication Valid data failed  due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailAddressWithInvalidAuthy(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.topBarComponent().clickUserName();
			tokenWalletPage.topBarComponent().clickUserDetails();
			Thread.sleep(5000);
			tokenWalletPage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading1(data.get("emailHeading1"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading2(data.get("emailHeading2"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup().authyComponent()
					.fillInput(data.get("pin"));
			if (!data.get("pin").isEmpty()) {
				tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
						.authyComponent().fillAuthyInputInvalid(data.get("pin"), data.get("char"));
			}
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(1000);
				tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
						.authyComponent().verifyMessage(data.get("errMessage"));
				Thread.sleep(3000);
			}
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.navigationComponent().clickClose();
			tokenWalletPage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup().authyComponent()
					.fillInput(data.get("validPin"));
			Thread.sleep(5000);
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.editEmailAddressPopup().verifyEditEmailAddressHeading(data.get("emailAddressHeading"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.editEmailAddressPopup().fillNewEmailText(data.get("newEmail"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.editEmailAddressPopup().clickOutside();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.editEmailAddressPopup().clickEmailSendCode();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.editEmailAddressPopup().currentEmailAddressPopup()
					.verifyCurrentEmailAddressHeading(data.get("emailHeading"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.editEmailAddressPopup().currentEmailAddressPopup().authyComponent().fillInput(data.get("pin"));
			if (!data.get("pin").isEmpty()) {
				tokenWalletPage.topBarComponent().userDetailsComponent().currentEmailAddressPopup().authyComponent()
						.fillAuthyInputInvalid(data.get("pin"), data.get("char"));
			}
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(1000);
				tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
						.editEmailAddressPopup().currentEmailAddressPopup().authyComponent()
						.verifyMessage(data.get("errMessage"));
				Thread.sleep(3000);
			}
			tokenWalletPage.topBarComponent().userDetailsComponent().currentEmailAddressPopup().navigationComponent()
					.clickClose();
			tokenWalletPage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup().authyComponent()
					.fillInput(data.get("validPin"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.editEmailAddressPopup().fillNewEmailText(data.get("newEmail"));
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup().clickOutside();
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup().clickEmailSendCode();
			tokenWalletPage.topBarComponent().userDetailsComponent().editEmailAddressPopup().currentEmailAddressPopup()
					.authyComponent().fillInput(data.get("validPin"));
//			tokenWalletPage.topBarComponent().userDetailsComponent().newEmailAddressPopup()
//					.verifyNewEmailAddressHeading(data.get("newEmailPopUp"));
			tokenWalletPage.topBarComponent().userDetailsComponent().newEmailAddressPopup().authyComponent()
					.fillInput(data.get("pin"));
			if (!data.get("pin").isEmpty()) {
				tokenWalletPage.topBarComponent().userDetailsComponent().newEmailAddressPopup().authyComponent()
						.fillAuthyInputInvalid(data.get("pin"), data.get("char"));
			}
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(1000);
				tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
						.editEmailAddressPopup().currentEmailAddressPopup().newEmailAddressPopup().authyComponent()
						.verifyMessage(data.get("errMessage"));
				Thread.sleep(3000);
			}
			tokenWalletPage.topBarComponent().userDetailsComponent().newEmailAddressPopup().navigationComponent()
					.clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test()
	@Parameters({ "strParams" })
	public void testGetSmsCodeVerificationEmailAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.topBarComponent().clickUserName();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().clickUserDetails();
			tokenWalletPage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading1(data.get("emailHeading1"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading2(data.get("emailHeading2"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup().smsCode();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().verifyHeading(data.get("heading"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().verifySmsVerificationCode(data.get("resend"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().authyComponent().fillInput(data.get("input"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().toastComponent().verifyToast(data.get("title"), data.get("msg"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().navigationComponent().verifyCloseView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" data failed  due to this " + e);
		}
	}

	@Test()
	@Parameters({ "strParams" })
	public void testResendVerificationCodeEmailAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.topBarComponent().clickUserName();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().clickUserDetails();
			tokenWalletPage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading1(data.get("emailHeading1"));
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.verifyEmailAddressAuthHeading2(data.get("emailHeading2"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup().smsCode();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().verifyHeading(data.get("heading"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().resendCode();
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" data failed  due to this " + e);
		}

	}

	@Test()
	@Parameters({ "strParams" })
	public void testPhoneVerificationInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.topBarComponent().clickUserName();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().clickUserDetails();
			tokenWalletPage.topBarComponent().userDetailsComponent().verifyEditAccountEmail(data.get("email"));
			tokenWalletPage.topBarComponent().userDetailsComponent().clickIconEditEmail();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup().smsCode();
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().verifyHeading(data.get("heading"));
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().userDetailsComponent().emailAddressAuthenticationPopup()
					.phoneVerificationPopup().authyComponent().fillInput(data.get("fillPin"));
			if (!data.get("fillPin").isEmpty()) {
				tokenWalletPage.userDetailsComponent().currentEmailAddressPopup().authyComponent()
						.fillAuthyInputInvalid(data.get("fillPin"), data.get("charact"));
			}
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				tokenWalletPage.userDetailsComponent().emailAddressAuthenticationPopup().phoneVerificationPopup()
						.authyComponent().verifyMessage(data.get("errMessage"));
			}
			Thread.sleep(2000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" data failed  due to this " + e);
		}
	}

	public void testAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			APIAdminProfilePage apiAdminProfilePage = new APIAdminProfilePage();

			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().clickBankAccount();
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.clickIamReady();
			Thread.sleep(8000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.switchToWindow();
			Thread.sleep(5000);
//			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
//					.verifyNewHeading(strParams);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.enterBankName(data.get("expBankName"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.clickOnBankName();
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.enterUserName(data.get("expUserName"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.enterPassword(data.get("expPassword"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup().clickNext();
			Thread.sleep(5000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.clickUncheckBank();
			Thread.sleep(5000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.switchToWindow();
			Thread.sleep(5000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addBankAccountPopup()
					.successFailureComponent().verifyBankAddSuccesfulHeaading();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test ExternalMethod failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccountWithOutPaymentMethod(String strParams) {
		tokenWalletPage.topBarComponent().clickUserName();
		;
		tokenWalletPage.topBarComponent().userDetailsComponent().clickPaymentMethods();
		apiAdminProfilePage.paymentMethodComponent().clickAddNewPayment();
		testAddExternalBankAccount(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenWalletPage.topBarComponent().clickUserName();
			;
			tokenWalletPage.topBarComponent().userDetailsComponent().clickPaymentMethods();
			apiAdminProfilePage.paymentMethodComponent().clickDeleteBank();
			apiAdminProfilePage.paymentMethodComponent().removePaymentMethodPopup().clickOnRemove();
			apiAdminProfilePage.paymentMethodComponent().removePaymentMethodPopup().successFailureComponent()
					.verifyPaymnetRemovedSuccessfulHeading(data.get(""));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	public void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			APIAdminProfilePage apiAdminProfilePage = new APIAdminProfilePage();
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().clickDebit();

			Thread.sleep(3000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardBrand(data.get("cardType"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCVVorCVC(data.get("cvvNumber"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			Thread.sleep(4000);
			Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
//			Thread.sleep(3000);
//			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent().switchToWindow();
			apiAdminProfilePage.paymentMethodComponent().preAuthorizationPopup().verifyHeading();
			apiAdminProfilePage.paymentMethodComponent().preAuthorizationPopup().fillAmount(data.get("amount"));
			apiAdminProfilePage.paymentMethodComponent().preAuthorizationPopup().clickOnVerify();
			apiAdminProfilePage.paymentMethodComponent().preAuthorizationPopup().successFailureComponent()
					.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		tokenWalletPage.topBarComponent().clickUserName();
		;
		tokenWalletPage.topBarComponent().userDetailsComponent().clickPaymentMethods();
		apiAdminProfilePage.paymentMethodComponent().clickAddNewPayment();
		testAddExternalBankAccount(strParams);

		testAddCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddExternalBank(String strParams) {
		homePage.sideBarComponent().clickBusinessSettings();
		homePage.sideBarComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
		homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
				.clickAddNewPayment();
		testAddExternalBankAccount(strParams);
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddDebitCard(String strParams) {
		homePage.sideBarComponent().clickBusinessSettings();
		homePage.sideBarComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
		homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
				.clickAddNewPayment();
		testAddCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessSettings();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().elementScroll();
			Thread.sleep(1000);
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().clickDeleteCard();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().verifyRemoveHeading(data.get("heading"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().clickOnRemove();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent()
					.verifyPaymnetRemovedSuccessfulHeading(data.get("successHeading"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Test Business Settings Delete Debit card  failed  due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickDeleteBank();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().clickOnRemove();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent()
					.verifyPaymnetRemovedSuccessfulHeading(data.get(""));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinenssSettingsSignetAccount(String strParams) {
		try {
			Thread.sleep(1000);
			homePage.sideBarComponent().clickBusinessSettings();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickAddNewPayment();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().clickSignetAccount();
			testSignetAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
//			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
//					.addNewPaymentMethodPopup().addNewSignetAccountPopup().verifyPageHeading(data.get("heading"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().fillName(data.get("newSignetAccount"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().fillSignetWalletId(data.get("walletID"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().mailingAddressComponent()
					.fillAddress1(data.get("address1"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().mailingAddressComponent()
					.fillAddress2(data.get("address2"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().mailingAddressComponent()
					.fillCity(data.get("city"));
			Thread.sleep(500);
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().mailingAddressComponent()
					.selectState(data.get("state"));
			Thread.sleep(1000);
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().clickSave();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().successFailureComponent()
					.verifySignetSucessfulHeading(data.get("heading1"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().successFailureComponent()
					.verifySignetSucessfulHeading2(data.get("heading2"));
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().addNewSignetAccountPopup().successFailureComponent()
					.navigationComponent().clickClose();
		} catch (

		Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddDebitCardWithOutPaymentMethod(String strParams) {
		try {
			homePage.sideBarComponent().clickBusinessSettings();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickAddNewPayment();
			Thread.sleep(1000);
			homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.addNewPaymentMethodPopup().clickDebit();
			testAddCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddBankAccountWithoutPaymentMethod is failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsEditDebitCard(String strParams) {
		homePage.sideBarComponent().clickBusinessSettings();
		homePage.sideBarComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
		homePage.sideBarComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent().clickEdit();
		testEditCard(strParams, "debit");
	}

	private void testEditCard(String strParams, String string) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			APIAdminProfilePage apiAdminProfilePage = new APIAdminProfilePage();

			Thread.sleep(3000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillNameOnCard(data.get("nameOnCard"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.validateCardBrand(data.get("cardType"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.fillCardExpiry(data.get("cardExpiry"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress1(data.get("address1"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillAddress2(data.get("address2"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillCity(data.get("city"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().selectState(data.get("state"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().verifyCountry(data.get("country"));
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.mailingAddressComponent().clickSave();
			apiAdminProfilePage.paymentMethodComponent().addNewPaymentMethodPopup().addCardComponent()
					.successFailureComponent().verifyPaymentEditSuccess(data.get("successHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test AddDebitCard failed due to Exception " + e);
		}

	}
}
