package coyni.business.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.business.components.TopBarComponent;
import coyni.business.pages.ProfilePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ProfileTest {
	TopBarComponent topBarComponent;
	ProfilePage profilepage;

	@BeforeTest
	public void init() {
		topBarComponent = new TopBarComponent();
		profilepage = new ProfilePage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileTwoStepReconfiguration(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickDropDownUserName();
			topBarComponent.userDetailsComponent().profilePage().clickReconfigure();
			topBarComponent.userDetailsComponent().profilePage().phoneVerificationComponent().fillpin(data.get("code"));
			topBarComponent.userDetailsComponent().profilePage().recongAuthenticationPoup().clickClickHere();
			topBarComponent.userDetailsComponent().profilePage().recongAuthenticationPoup().clickGoBack();
			topBarComponent.userDetailsComponent().profilePage().recongAuthenticationPoup().fillPin(data.get("code"));
			topBarComponent.userDetailsComponent().profilePage().recongAuthenticationPoup().clickCrossClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileTwoStepReconfiguration is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileEditPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickDropDownUserName();
			topBarComponent.userDetailsComponent().clickProfile();
			topBarComponent.userDetailsComponent().profilePage().verifyProfile();
			topBarComponent.userDetailsComponent().profilePage().verifyAccountID();
			topBarComponent.userDetailsComponent().profilePage().verifyCustomerName();
			topBarComponent.userDetailsComponent().profilePage().verifyPermissionRole();
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.verifyEditPhoneNumberHeading(data.get("phoneHeading"));
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.verifyEditPhoneNumberDescription(data.get("phoneNumberDescription"));
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.fillNewPhoneNumber(data.get("newPhoneNumber"));
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup().clickSendCode();
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.currentPhoneNumberVerificationPopup().fillPin(data.get("code"));
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.currentPhoneNumberVerificationPopup().newPhoneVerificationPopup()
					.verifyNewPhoneVerificationHeading(data.get("phoneVerificationHeading"));
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.currentPhoneNumberVerificationPopup().newPhoneVerificationPopup()
					.verifyNewPhoneVerificationDescription(data.get("PhoneVerificationDescription"));
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.currentPhoneNumberVerificationPopup().newPhoneVerificationPopup().fillPin(data.get("code"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileEditPhoneNumber is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileEditPhoneNumberInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickDropDownUserName();
			topBarComponent.userDetailsComponent().clickProfile();
			topBarComponent.userDetailsComponent().profilePage().verifyProfile();
			topBarComponent.userDetailsComponent().profilePage().verifyAccountID();
			topBarComponent.userDetailsComponent().profilePage().verifyCustomerName();
			topBarComponent.userDetailsComponent().profilePage().verifyPermissionRole();
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.verifyEditPhoneNumberHeading(data.get("phoneHeading"));
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.verifyEditPhoneNumberDescription(data.get("phoneNumberDescription"));
			topBarComponent.userDetailsComponent().profilePage().editPhoneNumberPopup()
					.fillNewPhoneNumber(data.get("newPhoneNumber"));
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileEditPhoneNumberInvalidData is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileEditEmailAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickDropDownUserName();
			topBarComponent.userDetailsComponent().clickProfile();
			topBarComponent.userDetailsComponent().profilePage().verifyProfile();
			topBarComponent.userDetailsComponent().profilePage().verifyAccountID();
			topBarComponent.userDetailsComponent().profilePage().verifyCustomerName();
			topBarComponent.userDetailsComponent().profilePage().verifyPermissionRole();
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup()
					.verifyEditEmailHeading(data.get("emailHeading"));
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup()
					.verifyEditEmailDescription(data.get("emailDescription"));
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup().verifyCurrentEmailAddress();
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup().clickSendCode();
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup().currentEmailVerificationPopup()
					.fillPin(data.get("code"));
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup().currentEmailVerificationPopup()
					.newEmailVerificationPopup()
					.verifyNewEmailVerificationHeading(data.get("newEmailVerificationHeading"));
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup().currentEmailVerificationPopup()
					.newEmailVerificationPopup()
					.verifyNewEmailVerificationDescription(data.get("newEmailVerificationDescription"));
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup().currentEmailVerificationPopup()
					.newEmailVerificationPopup().fillPin(data.get("code"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileEditEmailAddress is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileEditEmailAddressInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickDropDownUserName();
			topBarComponent.userDetailsComponent().clickProfile();
			topBarComponent.userDetailsComponent().profilePage().verifyProfile();
			topBarComponent.userDetailsComponent().profilePage().verifyAccountID();
			topBarComponent.userDetailsComponent().profilePage().verifyCustomerName();
			topBarComponent.userDetailsComponent().profilePage().verifyPermissionRole();
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup()
					.verifyEditEmailHeading(data.get("emailHeading"));
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup()
					.verifyEditEmailDescription(data.get("emailDescription"));
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup().verifyCurrentEmailAddress();
			topBarComponent.userDetailsComponent().profilePage().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileEditEmailAddressInvalidData is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			topBarComponent.clickDropDownUserName();
			topBarComponent.clickChangePassword();
			topBarComponent.authyComponent().verifyYourIdentityHeading(data.get("identityHeading"));
			topBarComponent.authyComponent().verifyYourIdentityDescription(data.get("identityDescription"));
			topBarComponent.authyComponent().fillInput(data.get("code"));
			topBarComponent.authyComponent().changePasswordPage().verifyPageHeading(data.get("changePasswordHeading"));
			topBarComponent.authyComponent().changePasswordPage()
					.VerifyPageDescription(data.get("changePasswordDescription"));
			topBarComponent.authyComponent().changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconCurrentPassword();
			Thread.sleep(1000);
			topBarComponent.authyComponent().changePasswordPage().verifyNewPassword(data.get("newPassword"));
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconNewPassowrd();
			Thread.sleep(1000);
			topBarComponent.authyComponent().changePasswordPage().fillConfirmPassword(data.get("confirmPassword"));
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			topBarComponent.authyComponent().changePasswordPage().clickSave();
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

			topBarComponent.clickDropDownUserName();
			topBarComponent.clickChangePassword();
			Thread.sleep(4000);

			topBarComponent.authyComponent().verifyYourIdentityHeading(data.get("identityHeading"));
			topBarComponent.authyComponent().fillInput(data.get("code"));
			topBarComponent.authyComponent().changePasswordPage().verifyPageHeading(data.get("changePasswordHeading"));
			Thread.sleep(4000);
			topBarComponent.authyComponent().changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			Thread.sleep(2000);
			topBarComponent.authyComponent().changePasswordPage().fillNewPassword(data.get("newPassword"));
			topBarComponent.authyComponent().changePasswordPage().fillConfirmPassword(data.get("confirmPassword"));
			topBarComponent.authyComponent().changePasswordPage().clickOutSide();

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
	public void testprofilePreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickDropDownUserName();
			topBarComponent.userDetailsComponent().clickPreferences();
			Thread.sleep(2000);
			topBarComponent.userDetailsComponent().profilePage().preferencespage().dropDownIcon();
			Thread.sleep(2000);
			topBarComponent.userDetailsComponent().profilePage().preferencespage().selectBusiness(data.get("business"));
			Thread.sleep(1000);
			topBarComponent.userDetailsComponent().profilePage().preferencespage().defaultBusiness();
			Thread.sleep(2000);
			topBarComponent.userDetailsComponent().profilePage().preferencespage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Preferences failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickDropDownUserName();
			topBarComponent.userDetailsComponent().clickAgreements();
//			topBarComponent.userDetailsComponent().profilePage().verifyAgreementsView();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().termsOfService();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().privacyPolicy();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().clickTermsOfServices();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().getAllVersionAgreements();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().clickDownloadPDF();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().clickLinkAgreements();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent()
					.clickiconDownloadTermsOfService();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().clickPrivacyPolicy();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().clickDownloadPDF();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().clickLinkAgreements();
			topBarComponent.userDetailsComponent().profilePage().agreementsComponent().clickiconDownloadPrivacyPolicy();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business profile Agreements failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			topBarComponent.clickDropDownUserName();
			topBarComponent.clickChangePassword();
			topBarComponent.authyComponent().verifyYourIdentityHeading(data.get("identityHeading"));
			topBarComponent.authyComponent().fillInput(data.get("code"));
			topBarComponent.authyComponent().changePasswordPage().verifyPageHeading(data.get("changePasswordHeading"));
			topBarComponent.authyComponent().changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconCurrentPassword();
			Thread.sleep(1000);
			topBarComponent.authyComponent().changePasswordPage().verifyCurrentPasswordMaskedView();
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconCurrentPassword();
			Thread.sleep(1000);
			topBarComponent.authyComponent().changePasswordPage().verifyCurrentPasswordMaskedView();
			Thread.sleep(2000);
			topBarComponent.authyComponent().changePasswordPage().fillNewPassword(data.get("newPassword"));
			Thread.sleep(2000);
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconNewPassowrd();
			Thread.sleep(1000);
			topBarComponent.authyComponent().changePasswordPage().verifyNewPasswordMaskedView();
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconNewPassowrd();
			Thread.sleep(1000);
			topBarComponent.authyComponent().changePasswordPage().verifyNewPasswordMaskedView();
			topBarComponent.authyComponent().changePasswordPage().fillConfirmPassword(data.get("confirmPassword"));
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			Thread.sleep(1000);
			topBarComponent.authyComponent().changePasswordPage().verifyConfirmPasswordMaskedView();
			Thread.sleep(1000);
			topBarComponent.authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			topBarComponent.authyComponent().changePasswordPage().verifyConfirmPasswordMaskedView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordView failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileLoginSessions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickDropDownUserName();
			topBarComponent.userDetailsComponent().clickLoginSessions();
			topBarComponent.userDetailsComponent().loginSessionPage().verifyLoginSessions(data.get("sessionHeading"));
			topBarComponent.userDetailsComponent().loginSessionPage()
					.verifyLoginSessionsDescription(data.get("sessionDescription"));
//			topBarComponent.userDetailsComponent().loginSessionPage().

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordView failed due to exception " + e);
		}
	}
}
