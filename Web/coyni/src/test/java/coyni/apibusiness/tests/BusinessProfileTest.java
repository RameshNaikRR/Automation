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
import coyni.apibusiness.components.TransactionListComponent;
import coyni.apibusiness.components.UserDetailsComponent;
import coyni.apibusiness.pages.BusinessProfilePage;
import coyni.apibusiness.pages.ExportFilesPage;
import coyni.apibusiness.pages.HomePage;
import coyni.apibusiness.pages.TokenWalletPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessProfileTest {
	PhoneEmailVerificationComponent phoneEmailVerificationComponent;
	TokenWalletPage tokenWalletPage;
	TopBarComponent topBarComponent;
	TransactionListComponent transactionListComponent;
	ExportFilesPage exportFilesPage;
	UserDetailsComponent userDetailsComponent;
	BusinessProfilePage apiBusinessProfilePage;
	HomePage homePage;
	BusinessSettingsSideBarMenuComponent businessSettingsMenuComponent;

	@BeforeTest
	public void init() {
		userDetailsComponent = new UserDetailsComponent();
		topBarComponent = new TopBarComponent();
		exportFilesPage = new ExportFilesPage();
		tokenWalletPage = new TokenWalletPage();
		transactionListComponent = new TransactionListComponent();
		phoneEmailVerificationComponent = new PhoneEmailVerificationComponent();
		apiBusinessProfilePage = new BusinessProfilePage();
		homePage = new HomePage();
		businessSettingsMenuComponent = new BusinessSettingsSideBarMenuComponent();
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
			Thread.sleep(7000);
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
			Thread.sleep(3000);
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
			Thread.sleep(2000);
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
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.verifyNewPassword(data.get("newPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconNewPassowrd();
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickSave();
			Thread.sleep(4000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test change password failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(4000);
			// APIAdminMenuComponent.clickUserName();
			tokenWalletPage.topBarComponent().clickUserName();
			tokenWalletPage.topBarComponent().clickChangePassword();
			Thread.sleep(4000);

			tokenWalletPage.topBarComponent().authyComponent().verifyYourIdentityHeading(data.get("identityHeading"));
			tokenWalletPage.topBarComponent().authyComponent().fillInput(data.get("code"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.verifyPageHeading(data.get("changePasswordHeading"));
			Thread.sleep(4000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillCurrentPassword(data.get("currentPassword"));
			Thread.sleep(2000);
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
			Thread.sleep(2000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.fillNewPassword(data.get("newPassword"));
			Thread.sleep(2000);
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
			Thread.sleep(1000);
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyConfirmPasswordMaskedView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordView failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testAddDebitCard(String strParams) {
//		tokenWalletPage.topBarComponent().clickUserName();
//		tokenWalletPage.topBarComponent().userDetailsComponent().clickPaymentMethods();
//		apiAdminProfilePage.paymentMethodComponent().clickAddNewPayment();
//		testAddExternalBankAccount(strParams);
//
//		testAddCard(strParams, "debit");
//	}
	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickPaymentMethods();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.clickDeleteBankAccount(data.get("bankNumber"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().clickOnRemove();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent()
					.verifyPaymnetRemovedSuccessfulHeading(data.get("removeHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().paymentMethodComponent()
					.removePaymentMethodPopup().successFailureComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotifications(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.topBarComponent().VerifyTitle(data.get("heading"));
			Thread.sleep(2000);
			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsBellIconView();
			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsCount();
			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsTextColor();
			Thread.sleep(2000);
			if (apiBusinessProfilePage.userDetailsComponent().notificationsComponent().viewTodayNotifications() == 1) {
				ExtentTestManager.setInfoMessageInReport("Today Notifications are Displayed");
			}
			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().viewYesterdayNotifications();
			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().viewOlderNotifications();
			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().verifyDateFormatInNotifications();
//			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().verifyMoveToCrossbtn();
//			apiBusinessProfilePage.userDetailsComponent().notificationsComponent()
//					.verifyReminderfirstMsg(data.get("initialMsg"));
//			Thread.sleep(1000);
//			 apiBusinessProfilePage.userDetailsComponent().notificationsComponent().verifyCancelBorderColor(data.get("CssProp"),
//			 data.get("CssValue"), data.get("Color"));
//			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().clickCancel();
//			apiBusinessProfilePage.userDetailsComponent().notificationsComponent()
//					.verifyCancelMsg(data.get("finalMsg"));
//			apiBusinessProfilePage.userDetailsComponent().notificationsComponent().verifyAllNotifications();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Notifications is failed due to Exception " + e);
		}
	}
}
