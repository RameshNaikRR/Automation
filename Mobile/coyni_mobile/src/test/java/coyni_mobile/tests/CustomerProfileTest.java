package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.AgreementPage;
import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.DashboardPage;
import coyni_mobile.pages.EnableFaceOrTouchIDpage;
import coyni_mobile.pages.LoginPage;
import coyni_mobile.pages.PreferencesPage;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class CustomerProfileTest {

	CustomerProfilePage customerProfilePage;
	DashboardPage dashboardPage;
	AgreementPage agreementsPage;
	PreferencesPage preferencesPage;
	MobileFunctions mobileFunctions;
	EnableFaceOrTouchIDpage enableFaceOrTouchIDpage;
	LoginPage loginPage;

	@BeforeTest
	public void init() {
		preferencesPage = new PreferencesPage();
		agreementsPage = new AgreementPage();
		customerProfilePage = new CustomerProfilePage();
		dashboardPage = new DashboardPage();
		mobileFunctions = new MobileFunctions();
		enableFaceOrTouchIDpage = new EnableFaceOrTouchIDpage();
		loginPage = new LoginPage();
	}

	/**
	 * testProfileView Script is to test the Edit the profile photo
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testProfileView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView(data.get("expHeading"));
			customerProfilePage.profilePage().verifyUserNameView(data.get("userName"));
			customerProfilePage.profilePage().verifyEmailview(data.get("existingEmail"));
			customerProfilePage.profilePage().verifyPhoneNumberView(data.get("existingPhoneNumber"));
			customerProfilePage.profilePage().verifyAddressView(data.get("existingAddress"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Profile Edit Emage due to Exception " + e);
		}
	}

	/**
	 * testProfileEditEmage Script is to test the Edit the profile photo
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testProfileEditEmage(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView(data.get("expHeading"));
			customerProfilePage.profilePage().clickEditUserImage();
			customerProfilePage.profilePage().editProfilePage().verifyTakeaPhotView();
			customerProfilePage.profilePage().editProfilePage().clickChooseFromLibrary();
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().clickEditUserImage();
			customerProfilePage.profilePage().editProfilePage().clickChooseFromLibrary();
			customerProfilePage.profilePage().editProfilePage().clickPhoto();
			customerProfilePage.profilePage().editProfilePage().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Profile Edit Emage due to Exception " + e);
		}
	}

	/**
	 * testEditEmail Script is to Edit the Email
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testEditEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView(data.get("expHeading"));
			customerProfilePage.profilePage().clickEditEmail();
			customerProfilePage.profilePage().editProfilePage().verifyEmailHeading(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().verifyCurrentEmailHeading(data.get("expSubHeading"));
			customerProfilePage.profilePage().editProfilePage().verifyExistEmail(data.get("existingEmail"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().verifyEnterYourPinView();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditEmailHeading(data.get("EditEmail"));
			customerProfilePage.profilePage().editProfilePage().verifycurrentEmail(data.get("existingEmail"));
			customerProfilePage.profilePage().editProfilePage().fillNewEmail(data.get("newEmail"));
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentEmailVerificationHeading(data.get("emailVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentEmailVerificationText(data.get("verificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyResendView();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyDontHaveAccess();
			customerProfilePage.profilePage().editProfilePage().verifyNeedHelpView();
			customerProfilePage.profilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewEmailVerificationHeading(data.get("newEmailVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewEmailVerificationText(data.get("newVerificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyResendView();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().successFailureComponent()
					.verifyEmailSucess(data.get("sucessHeading"));
			customerProfilePage.profilePage().editProfilePage().successFailureComponent()
					.verifyChangeEmailDesc(data.get("sucessDesc"));
			customerProfilePage.profilePage().editProfilePage().successFailureComponent().clickLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit  Email failed due to Exception " + e);
		}
	}

	/**
	 * testEditEmailFieldValidations Script is to Edit the Email navigations and
	 * text field validations
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testEditEmailFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView(data.get("expHeading"));
			customerProfilePage.profilePage().clickEditEmail();
			customerProfilePage.profilePage().navigationComponent().clickBack();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().clickEditEmail();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().verifyEnterYourPinView();
			customerProfilePage.profilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().validateEmail(data.get("email"));
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewEmailVerificationHeading(data.get("newEmailVerificationHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Email field validations Failed due to Exception " + e);
		}
	}

	/**
	 * testEditPhoneNumber Script is to Edit the Phone Number
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView(data.get("expHeading"));
			customerProfilePage.profilePage().clickEditPhoneNumber();
			customerProfilePage.profilePage().editProfilePage().verifyPhoneNumberHdg(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().verifyCurrentPhoneNumberhdg(data.get("subHeading"));
			customerProfilePage.profilePage().editProfilePage()
					.verifyExistingPhoneNUmber(data.get("existingPhoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().verifyEnterYourPinView();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditPhoneNUmber(data.get("editPhoneHeading"));
			customerProfilePage.profilePage().editProfilePage()
					.verifyCurrentPhoneNUmber(data.get("existingPhoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickArrow(data.get("fillCountry"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentPhoneVerificationHeading(data.get("phoneVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentPhoneVerificationText(data.get("verificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyResendView();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyDontHaveAccess();
			customerProfilePage.profilePage().editProfilePage().verifyNeedHelpView();
			customerProfilePage.profilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewPhoneVerificationHdg(data.get("newPhoneVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewPhoneVerificationText(data.get("newVerificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Phone Number failed due to Exception " + e);
		}
	}

	/**
	 * testEditEmailFieldValidations Script is to Edit the Email navigations and
	 * text field validations
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumberFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView(data.get("expHeading"));
			customerProfilePage.profilePage().clickEditPhoneNumber();
			customerProfilePage.profilePage().navigationComponent().clickBack();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().clickEditPhoneNumber();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().verifyEnterYourPinView();
			customerProfilePage.profilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().clickArrow(data.get("fillCountry"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickArrow(data.get("fillCountry"));
			customerProfilePage.profilePage().editProfilePage().validatePhoneNumber(data.get("phoneNumbers"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickArrow(data.get("fillCountry"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewPhoneVerificationHdg(data.get("newPhoneVerificationHeading"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Edit Phone Number Field Validations failed due to Exception " + e);
		}
	}

	/**
	 * testEditAddress Script is to Edit the Phone Number
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testEditAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView(data.get("expHeading"));
			customerProfilePage.profilePage().clickEditAddress();
			customerProfilePage.profilePage().editProfilePage().verifyAddressheading(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().verifyCurrentAddres(data.get("subHeading"));
			customerProfilePage.profilePage().editProfilePage().verifyExistingAddres(data.get("existingAddress"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().verifyEditAddres(data.get("editAddressHeading"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickCountryDropdown();
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.selectCountry(data.get("fillCountry"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.fillAddLine1(data.get("addline1"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.fillAddLine2(data.get("addline2"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillState(data.get("state"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.fillZipCode(data.get("zipcode"));
			customerProfilePage.profilePage().editProfilePage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Address failed due to Exception " + e);
		}
	}

	/**
	 * testEditAddress Script is to Edit the Phone Number
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testEditAddressFieldvalidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView(data.get("expHeading"));
			customerProfilePage.profilePage().clickEditAddress();
			customerProfilePage.profilePage().navigationComponent().clickBack();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().clickEditAddress();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().verifyEditAddres(data.get("editAddressHeading"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickCountryDropdown();
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.selectCountry(data.get("fillCountry"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.validateAddline1(data.get("addline1"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.validateAddline2(data.get("addline2"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.validateCity(data.get("city"));
			// customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillState(data.get("state"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.validateZipCode(data.get("zipCode"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Address Fieldvalidations failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testPrefernces(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPreferences();
			preferencesPage.verifyPreferencesHeading(data.get("preferencesHeading"));
			String[] timeZone = data.get("timeZones").split(",");
			for (int i = 0; i <= timeZone.length; i++) {
				preferencesPage.selectTimeZone(timeZone[i]);
				preferencesPage.toastComponent().verifyToastMsg(data.get("preferencesToastMsg"));
				preferencesPage.verifyTimeZone(timeZone[i]);
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Preferences failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickAgreements();
			agreementsPage.clickPrivacyPolicy();
			agreementsPage.clickPrivacyActiveAgreement();
			agreementsPage.verifyDocAgreeHeading(data.get("AgreeDocHeading"));
			agreementsPage.navigationComponent().clickClose();
			agreementsPage.clickPrivacyPastAgreement();
			agreementsPage.verifyDocAgreeHeading(data.get("AgreeDocHeading"));
			agreementsPage.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Agreements failed due to Exception " + e);
		}
	}

	/**
	 * testAccountLimits Script is to test Account Limits
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickAccountLimits();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.clickAccountLimits();
			customerProfilePage.accountLimitsPage().verifyAccountLimitsHeading(data.get("expHeading"));
			customerProfilePage.accountLimitsPage().verifySendRequestHeading(data.get("sendReqHeading"));
			customerProfilePage.accountLimitsPage().verifySendRequest();
			customerProfilePage.accountLimitsPage().verifyBuyToken(data.get("buyTokenHeading"));
			customerProfilePage.accountLimitsPage().verifyBankAccountView();
			customerProfilePage.accountLimitsPage().verifyDebitCredView();
			customerProfilePage.accountLimitsPage().verifyWithdraw(data.get("WithdrawTokenHeading"));
			customerProfilePage.accountLimitsPage().verfiyWithdrawBankView();
			customerProfilePage.accountLimitsPage().verfiyWithdrawInstantView();
			customerProfilePage.accountLimitsPage().verfiyWithdrawGiftCardView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Account Limits failed due to Exception " + e);
		}
	}

	/**
	 * testAccountLimits Script is to test Account Limits
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testWalletFees(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickWalletFees();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.clickWalletFees();
			customerProfilePage.walletsFeesPage().verifyWalletFees(data.get("expHeading"));
			customerProfilePage.walletsFeesPage().verifyBuyToken(data.get("buyTokenHeading"));
			customerProfilePage.walletsFeesPage().verifyBankAccount();
			customerProfilePage.walletsFeesPage().verifyCreditCard();
			customerProfilePage.walletsFeesPage().verifyDebitCard();
			customerProfilePage.walletsFeesPage().verifyWithdraw(data.get("WithdrawTokenHeading"));
			customerProfilePage.walletsFeesPage().verifyWithdrawBankAccount();
			customerProfilePage.walletsFeesPage().verifyWithdrawInstantPay();
			customerProfilePage.walletsFeesPage().verifyWithdrawGiftCard();
			customerProfilePage.walletsFeesPage().verifyFailedBankWithdraw();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Wallet Fees  failed due to Exception " + e);
		}
	}

	/**
	 * testLogOut script to test the logout feature.
	 */
	@Test
	public void testLogOut() {
		try {
			dashboardPage.clickProfile();
			customerProfilePage.clickLogout();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLogOut failed due to exception " + e);
		}
	}

	/**
	 * testResetPincode Script is to test by resetting pin from previous to new
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testResetPincode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.choosePinComponent().verifyForgotPinView();
			customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.choosePinComponent().verifyChooseYouPinDes(data.get("description"));
			customerProfilePage.choosePinComponent().verifyChooseYourPin(data.get("choosePinHeading"));
			customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.choosePinComponent().verifyConfirmYourPin(data.get("confirmPinHeading"));
			if (data.get("validateNavigation").equalsIgnoreCase("Yes")) {
				customerProfilePage.navigationComponent().clickBack();
				customerProfilePage.choosePinComponent().verifyChooseYourPinView();
				customerProfilePage.navigationComponent().clickBack();
				customerProfilePage.choosePinComponent().verifyEnterYourPinView();
				customerProfilePage.choosePinComponent().clickForgotPin();
				customerProfilePage.choosePinComponent().verifyForgotPinView();
				customerProfilePage.navigationComponent().clickBack();
				customerProfilePage.navigationComponent().clickClose();
			}
			if (data.get("validateConfirmPin").equalsIgnoreCase("Yes")) {
				customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
				customerProfilePage.choosePinComponent().verifyToastMessage(data.get("toastMsg"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" Reset Pincode failed due to Exception " + e);
		}
	}

	/**
	 * testChangePassword Script is to test by Changing Password from previous to
	 * new
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickChangePassword();
			validateChangePassword(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" Change Password failed due to Exception " + e);
		}
	}

	public void validateChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.choosePinComponent().verifyForgotPinView();
			customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyCurrentPassword(data.get("expHeading"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyCurrentPasswordDesc(data.get("description"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.fillCurrentPassword(data.get("password"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickEye();
			customerProfilePage.choosePinComponent().createPasswordComponent().clickNext();
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyNewPasswordHeading(data.get("subHeading"));
			customerProfilePage.choosePinComponent().createPasswordComponent().fillNewPassword(data.get("newPassword"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickEye();
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.fillConfirmPassword(data.get("ConfirmPassword"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyNewPasswordDesc(data.get("description"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickEye();
			customerProfilePage.choosePinComponent().createPasswordComponent().clickSave();
			customerProfilePage.choosePinComponent().createPasswordComponent().successFailureComponent()
					.verifyPasswordChanged(data.get("sucessHeading"));
			customerProfilePage.choosePinComponent().createPasswordComponent().successFailureComponent()
					.verifyPasswordChangedDesc(data.get("sucessDesc"));
			customerProfilePage.choosePinComponent().createPasswordComponent().successFailureComponent().clickLogin();
			loginPage.verifyImageCoyniView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" Change Password failed due to Exception " + e);
		}
	}

	/**
	 * testChangePassword Script is to test by Changing Password from previous to
	 * new
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickChangePassword();
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.choosePinComponent().clickForgotPin();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.validateCurrentPasswordfield(data.get("validateCurrentPasswords"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickEye();
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.clickChangePassword();
			customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.fillCurrentPassword(data.get("password"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickNext();
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.validateNewPasswordfield(data.get("newPassword"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickEye();
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.validateConfirmPasswordfield(data.get("ConfirmPassword"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickEye();
			customerProfilePage.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" Change Password failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLogInSessions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickLoginSessions();
			customerProfilePage.logInSessionsPage().viewLogInSessHeader();
			if (data.get("validateChangePassword").equalsIgnoreCase("button")) {
				customerProfilePage.logInSessionsPage().clickEndAllSessions();
				customerProfilePage.logInSessionsPage().clickChangePassword();
				validateChangePassword(strParams);
			} else if (data.get("validateChangePassword").equalsIgnoreCase("link")) {
				customerProfilePage.logInSessionsPage().clickChangePassword();
				validateChangePassword(strParams);
			} else {
				customerProfilePage.logInSessionsPage().clickEndAllSessions();
				customerProfilePage.logInSessionsPage().clickEndAllSessions();
				customerProfilePage.logInSessionsPage().successFailureComponent()
						.verifyEndAllSessions(data.get("endSessnSucessHeading"));
				customerProfilePage.logInSessionsPage().successFailureComponent().clickLogin();
				loginPage.verifyImageCoyniView();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" Change Password failed due to Exception " + e);
		}
	}

	/**
	 * testAddCreditCardInPaymentMethods script is to test payment method via adding
	 * Credit card by giving valid card details.
	 * 
	 * @param strParams
	 * @throws InterruptedException
	 */
	@Test
	@Parameters({ "strParams" })
	public void testAddCreditCardInPaymentMethods(String strParams) throws InterruptedException {
		dashboardPage.clickProfile();
		customerProfilePage.clickPaymentMethods();
		Thread.sleep(1000);
		customerProfilePage.addNewPaymentComponent().getPaymentPage();
		testAddCard(strParams, "credit");
	}

	/**
	 * testAddDebitCardInPaymentMethods script is to test payment method via adding
	 * Debit card by giving valid card details.
	 * 
	 * @param strParams
	 * @throws InterruptedException
	 */

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardInPaymentMethods(String strParams) throws InterruptedException {
		dashboardPage.clickProfile();
		customerProfilePage.clickPaymentMethods();
		Thread.sleep(1000);
		customerProfilePage.addNewPaymentComponent().getPaymentPage();
		testAddCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCreditCardInBuyTokenss(String strParams) throws InterruptedException {
		dashboardPage.clickBuyTokens();
		testAddCard(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardInBuyTokens(String strParams) throws InterruptedException {
		dashboardPage.clickBuyTokens();
		testAddCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardINwithdrawToUSd(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickWithdraw();
			dashboardPage.selectWithdrawMethodPage().verifyDebitCardHeading(data.get("addInstantPayHeading"));
			dashboardPage.selectWithdrawMethodPage().verifyDebitCardDesc(data.get("instantPayDescription"));
			dashboardPage.selectWithdrawMethodPage().clickDebitCard(data.get("instantPayText"));
			testAddCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("AddDebitCardINwithdrawToUSd failed due to Exception " + e);
		}
	}

	/**
	 * testAddCard Script is to test by Adding a card
	 * 
	 * @param strParams
	 */
	public void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.addNewPaymentComponent().verifyCreditContent(data.get("content"));
				customerProfilePage.addNewPaymentComponent().clickCreditCard();
			} else {
				Thread.sleep(2000);
				customerProfilePage.addNewPaymentComponent().verifyDebitContent(data.get("content"));
				customerProfilePage.addNewPaymentComponent().clickDebitCard();
			}
			if (data.get("validateCard").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardNumber(data.get("cardNumber1"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().verifyError(data.get("error"));
			}
			if (data.get("validateAddress").equalsIgnoreCase("Yes")) {
				testAddCardDetails(strParams);
			}
			if (data.get("validateCardNums").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().getPaymentPage();
				Thread.sleep(3000);
				if (card.equalsIgnoreCase("credit")) {
					customerProfilePage.addNewPaymentComponent().verifyCreditCardNums(data.get("cardNumbers"));
				} else {
					customerProfilePage.addNewPaymentComponent().verifyCardNums(data.get("cardNumbers"));
				}
			}
			if (data.get("ValidateFifthCard").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().verifyMaxlimit(data.get("errMsg"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Add Card failed due to Exception " + e);
		}
	}

	public void testAddCardDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			customerProfilePage.addNewPaymentComponent().addCardComponent()
					.verifyAddDebitorCredHeadingView(data.get("AddCardHeading"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().verifyAddcardDesc(data.get("description"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardNumber(data.get("cardNumber"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardExp(data.get("cardExp"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().fillCVVorCVC(data.get("cvvCVC"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().clickNext();
			customerProfilePage.addNewPaymentComponent().addCardComponent()
					.verifyAddDebitorCredHeadingView(data.get("AddCardHeading"));
			customerProfilePage.addNewPaymentComponent().addCardComponent()
					.verifyPlsConfirmBillingAdd(data.get("billingAddressDesc"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.clickCountryDropdown();
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.selectCountry(data.get("Country"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillAddLine1(data.get("addLine1"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillAddLine2(data.get("addLine2"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillCity(data.get("city"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillState(data.get("state"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillZipCode(data.get("zipcode"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent().clickAddCard();
			if (data.get("validateExistingCard").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().verifyErrorView();
				customerProfilePage.addNewPaymentComponent().verifyErrorMessage(data.get("toastMessage"));
				customerProfilePage.addNewPaymentComponent().clickOk();
			}
			if (data.get("validateAuthorization").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().addCardComponent().preAuthorizationComponent()
						.verifyHeading(data.get("preAuthHeading"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().preAuthorizationComponent()
						.verifyPageDes(data.get("preAuthDescription"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().preAuthorizationComponent()
						.fillAmount(data.get("amount"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().preAuthorizationComponent()
						.clickVerify();
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.successFailureComponent().verifyAllDone(data.get("sucessHeading"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.successFailureComponent().verifyCardSucessDesc(data.get("sucessDescription"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.successFailureComponent().clickDone();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Add Card failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExpiredCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			if (data.get("validateBuyTokens").equalsIgnoreCase("Yes")) {
				dashboardPage.clickProfile();
				customerProfilePage.clickPaymentMethods();
				customerProfilePage.addNewPaymentComponent().verifyCreditCardExpiry();
				customerProfilePage.addNewPaymentComponent().verifyDebitCardExpiry();
				customerProfilePage.navigationComponent().clickBack();
				customerProfilePage.navigationComponent().clickBack();
				dashboardPage.clickBuyTokens();
				Thread.sleep(1000);
				customerProfilePage.addNewPaymentComponent().verifyCreditCardExpiry();
				customerProfilePage.addNewPaymentComponent().verifyEditAndDeleteCreditCard();
				customerProfilePage.addNewPaymentComponent().verifyCreditOOPSCondition();
				customerProfilePage.addNewPaymentComponent().verifyDebitCardExpiry();
				customerProfilePage.addNewPaymentComponent().verifyEditAndDeleteDebitCard();
				customerProfilePage.addNewPaymentComponent().verifyDebitOOPSCondition();
				customerProfilePage.addNewPaymentComponent().navigationComponent().clickClose();
				dashboardPage.clickWithdraw();
				customerProfilePage.addNewPaymentComponent().verifyCreditCardExpiry();
				Thread.sleep(1000);
				customerProfilePage.addNewPaymentComponent().verifyCreditOOPSCondition();
				customerProfilePage.addNewPaymentComponent().verifyDebitCardExpiry();
				customerProfilePage.addNewPaymentComponent().verifyDebitOOPSCondition();
				customerProfilePage.addNewPaymentComponent().verifyNotOken();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickDebitCard(data.get("last4Digits"));
				dashboardPage.cvvPopup().choosePinComponent().validateCVVorCVC(data.get("cvvCVC1"));
				dashboardPage.cvvPopup().fillCvv(data.get("cvvCVC"));
				dashboardPage.cvvPopup().clickOk();
				dashboardPage.buyTokenComponent().clickArrow();
				customerProfilePage.addNewPaymentComponent().verifyCreditCardExpiry();
				Thread.sleep(1000);
				customerProfilePage.addNewPaymentComponent().verifyCreditOOPSCondition();
				customerProfilePage.addNewPaymentComponent().verifyDebitCardExpiry();
				customerProfilePage.addNewPaymentComponent().verifyDebitOOPSCondition();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickDebitCard(data.get("last4Digits"));
				dashboardPage.cvvPopup().fillCvv(data.get("cvvCVC"));
				dashboardPage.cvvPopup().clickOk();
				Thread.sleep(1000);
				customerProfilePage.navigationComponent().clickClose();
				customerProfilePage.navigationComponent().clickClose();
			}
			if (data.get("validateWithdrawToken").equalsIgnoreCase("Yes")) {
				dashboardPage.clickWithdraw();
				dashboardPage.selectWithdrawMethodPage().clickInstantPay();
				customerProfilePage.addNewPaymentComponent().verifyDebitCardExpiry();
				customerProfilePage.addNewPaymentComponent().verifyDebitOOPSCondition();
				// customerProfilePage.paymentMethodsPage().clickDebitCard(data.get("last4Digits"));
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickDebitCard(data.get("last4Digits"));
				Thread.sleep(1000);
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickArrow();
				// customerProfilePage.paymentMethodsPage().verifyDebitCardExpiry();
				customerProfilePage.addNewPaymentComponent().verifyWithdrawDebitOOPSCondition();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickDebitCard(data.get("last4Digits"));
				customerProfilePage.navigationComponent().clickBack();
				customerProfilePage.navigationComponent().clickClose();
			}
			// customerProfilePage.paymentMethodsPage().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditCard failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditDebitCardInPaymentMethods(String strParams) throws InterruptedException {
		customerProfilePage.clickPaymentMethods();
		customerProfilePage.navigationComponent().clickBack();
		customerProfilePage.clickPaymentMethods();
		testEditCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditCreditCardInPaymentMethods(String strParams) throws InterruptedException {
		customerProfilePage.clickPaymentMethods();
		customerProfilePage.navigationComponent().clickBack();
		customerProfilePage.clickPaymentMethods();
		testEditCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCreditCardInPaymentMethods(String strParams) throws InterruptedException {
		customerProfilePage.clickPaymentMethods();
		testDeleteCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteDebitCardInPaymentMethods(String strParams) throws InterruptedException {
		customerProfilePage.clickPaymentMethods();
		testDeleteCard(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankInPaymentMethods(String strParams) throws InterruptedException {
		customerProfilePage.clickPaymentMethods();
		customerProfilePage.navigationComponent().clickBack();
		customerProfilePage.clickPaymentMethods();
		testDeleteCard(strParams, "debit");
	}

	/**
	 * testEditCardandDelete Script is to test Edit a card and Delete a card
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testEditCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("expHeading"));
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.addNewPaymentComponent().clickCreditCard(data.get("last4Digits"));
			} else if (card.equalsIgnoreCase("debit")) {
				customerProfilePage.addNewPaymentComponent().clickDebitCard(data.get("last4Digits"));
			} else {
				customerProfilePage.addNewPaymentComponent().clickBankAccount(data.get("last4Digits"));
			}
			if (data.get("validateAddress").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().editCardComponent().verifyCardNumHeading();
				customerProfilePage.addNewPaymentComponent().editCardComponent()
						.verifyNameonCard(data.get("existCardName"));
				customerProfilePage.addNewPaymentComponent().editCardComponent()
						.verifyCardNum(data.get("existCardNumber"));
				customerProfilePage.addNewPaymentComponent().editCardComponent().verifyCardExp(data.get("expCardExp"));
				customerProfilePage.addNewPaymentComponent().editCardComponent()
						.verifyBillingAddress(data.get("existAddress"));
				customerProfilePage.addNewPaymentComponent().editCardComponent().clickEditPaymentMethod();
				customerProfilePage.addNewPaymentComponent().editCardComponent().verifyCardNumHeading();
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardExp(data.get("cardExp"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCVVorCVC(data.get("cvvCVC"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().clickNext();
				customerProfilePage.addNewPaymentComponent().addCardComponent()
						.verifyAddDebitorCredHeadingView(data.get("AddCardHeading"));
				customerProfilePage.addNewPaymentComponent().addCardComponent()
						.verifyPlsConfirmBillingAdd(data.get("billingAddressDesc"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.clickCountryDropdown();
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.selectCountry(data.get("Country"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.fillAddLine1(data.get("addLine1"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.fillAddLine2(data.get("addLine2"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.fillCity(data.get("city"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.fillState(data.get("state"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.fillZipCode(data.get("zipcode"));
				customerProfilePage.addNewPaymentComponent().editCardComponent().clickSave();
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.verifyAddressUpdatedMsg(data.get("toastMessage"));
			}
			if (data.get("validateNavigation").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().editCardComponent().clickEditPaymentMethod();
				customerProfilePage.navigationComponent().clickBack();
				customerProfilePage.navigationComponent().clickBack();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("EditCard and Delete card failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("expHeading"));
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.addNewPaymentComponent().clickCreditCard(data.get("last4Digits"));
			} else if (card.equalsIgnoreCase("debit")) {
				customerProfilePage.addNewPaymentComponent().clickDebitCard(data.get("last4Digits"));
			} else {
				customerProfilePage.addNewPaymentComponent().clickBankAccount(data.get("last4Digits"));
			}
			if (data.get("validateCardDelete").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().editCardComponent().clickEditPaymentMethod();
				customerProfilePage.addNewPaymentComponent().editCardComponent().clickRemove();
				customerProfilePage.addNewPaymentComponent().editCardComponent().verifyRemovingHdg(data.get("heading"));
				if (data.get("validateNo").equalsIgnoreCase("Yes")) {
					customerProfilePage.addNewPaymentComponent().editCardComponent().clickNo();
				}
				if (data.get("validateYes").equalsIgnoreCase("Yes")) {
					customerProfilePage.addNewPaymentComponent().editCardComponent().clickYes();
					if (data.get("validateAddNewPayment").contentEquals("Yes")) {
						customerProfilePage.addNewPaymentComponent().getPaymentPages();
					}
					Thread.sleep(2000);
					if (card.equalsIgnoreCase("credit")) {
						Thread.sleep(2000);
						customerProfilePage.addNewPaymentComponent().verifyCreditCardNums(data.get("cardNumbers"));
					} else if (card.equalsIgnoreCase("debit")) {
						customerProfilePage.addNewPaymentComponent().verifyCardNums(data.get("cardNumbers"));
					} else {
						customerProfilePage.addNewPaymentComponent().verifyBankNums();
					}
				}
			}
			if (data.get("validateBankDelete").equalsIgnoreCase("Yes")) {
				customerProfilePage.addNewPaymentComponent().editCardComponent().clickRemoveAccount();
				customerProfilePage.addNewPaymentComponent().editCardComponent().verifyRemovingHdg(data.get("heading"));
				if (data.get("validateNo").equalsIgnoreCase("Yes")) {
					customerProfilePage.addNewPaymentComponent().editCardComponent().clickNo();
				}
				if (data.get("validateYes").equalsIgnoreCase("Yes")) {
					customerProfilePage.addNewPaymentComponent().editCardComponent().clickYes();
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("EditCard and Delete card failed due to Exception " + e);
		}
	}

	/**
	 * testAddDebitCardFieldValidation script is to test field Validations for text
	 * fields Debit card by giving valid card details.
	 * 
	 * @param strParams
	 * @throws InterruptedException
	 */

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardFieldValidation(String strParams) throws InterruptedException {
		dashboardPage.clickProfile();
		customerProfilePage.clickPaymentMethods();
		customerProfilePage.navigationComponent().clickBack();
		customerProfilePage.clickPaymentMethods();
		Thread.sleep(1000);
		customerProfilePage.addNewPaymentComponent().getPaymentPage();
		testAddCardFieldValidations(strParams, "debit");
	}

	/**
	 * testAddCreditCardFieldValidation script is to test field Validations for text
	 * fields Debit card by giving valid card details.
	 * 
	 * @param strParams
	 * @throws InterruptedException
	 */

	@Test
	@Parameters({ "strParams" })
	public void testAddCreditCardFieldValidation(String strParams) throws InterruptedException {
		dashboardPage.clickProfile();
		customerProfilePage.clickPaymentMethods();
		customerProfilePage.navigationComponent().clickBack();
		customerProfilePage.clickPaymentMethods();
		Thread.sleep(1000);
		customerProfilePage.addNewPaymentComponent().getPaymentPage();
		testAddCardFieldValidations(strParams, "debit");
	}

	/**
	 * testAddCardFieldValidations Script is to test Edit a card and Delete a card
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testAddCardFieldValidations(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.addNewPaymentComponent().addCardComponent().validateNameOnCard(data.get("nameOnCard"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().validateCardNumber(data.get("cardNumber"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().validateCardExp(data.get("cardExp"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().validateCVVorCVC(data.get("cvvCVC"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().clickNext();
			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
					.clickCountryDropdown();
			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
					.selectCountry(data.get("Country"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
					.validateAddline1(data.get("addLine1"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
					.validateAddline2(data.get("addLine2"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
					.validateCity(data.get("city"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
					.fillState(data.get("state"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
					.validateZipCode(data.get("zipcode"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.navigationComponent().clickBack();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Add Card failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void verifyEnableTouchOrFaceID(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		dashboardPage.clickProfile();
		customerProfilePage.enableFaceOrTouchIDpage().clickEnable();
		customerProfilePage.enableFaceOrTouchIDpage().navigationComponent().clickBack();
		customerProfilePage.enableFaceOrTouchIDpage().clickEnable();
		customerProfilePage.enableFaceOrTouchIDpage().clickNotNow();

	}

	@Test
	@Parameters({ "strParams" })
	public void verifyGetHelp(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		customerProfilePage.clickGetHelp();
		customerProfilePage.enableFaceOrTouchIDpage().verifyGetHelp(data.get("getHelpHeading"));
		customerProfilePage.enableFaceOrTouchIDpage().verifyGetHelpDesc(data.get("getHelpDesc"));
		customerProfilePage.enableFaceOrTouchIDpage().verifyGetHelpview();
		customerProfilePage.enableFaceOrTouchIDpage().navigationComponent().clickBack();
	}

	@Test
	@Parameters({ "strParams" })
	public void testBankAccountINwithdrawToBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickWithdraw();
			dashboardPage.selectWithdrawMethodPage().verifyBankAccountHeading(data.get("addBankHeading"));
			dashboardPage.selectWithdrawMethodPage().verifyBankAccountDesc(data.get("bankDescription"));
			dashboardPage.selectWithdrawMethodPage().clickBankAccount(data.get("bankText"));
			testAddBankAccount(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("AddDebitCardINwithdrawToUSd failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccountInBuyTokens(String strParams) throws InterruptedException {
		dashboardPage.clickBuyTokens();
		testAddBankAccount(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccount(String strParams, String card) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
			customerProfilePage.addNewPaymentComponent().clickBankAcount();
			customerProfilePage.addNewPaymentComponent().mxBankComponent().addBank(data.get("expHeading"),
					data.get("description"), data.get("mxAddBankChkBxDescription"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent()
					.verifySelectYourInstitution(data.get("heading"));
			if (customerProfilePage.addNewPaymentComponent().mxBankComponent()
					.MXConfirmationScreen(data.get("mxConfirmationHeading")) == 1) {
				customerProfilePage.addNewPaymentComponent().mxBankComponent().verifyMXConfirmationScreen(
						data.get("mxConfirmationHeading"), data.get("mxConfirmationDescription"));
				customerProfilePage.addNewPaymentComponent().mxBankComponent().clickMXContinue();
			}
			customerProfilePage.addNewPaymentComponent().mxBankComponent()
					.verifyCredentialsHeading(data.get("credentialsHeading"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().fillUserName(data.get("mxUsername"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().fillPassword(data.get("mxPassword"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().clickContinue();
//			customerProfilePage.addNewPaymentComponent().mxBankComponent()
//					.VerifyIdentityHeading(data.get("identityHeading"));
			if (data.get("accountType").equalsIgnoreCase("checking")) {
				customerProfilePage.addNewPaymentComponent().mxBankComponent().clickChecking();
			} else {
				customerProfilePage.addNewPaymentComponent().mxBankComponent().clickSavings();
			}
			customerProfilePage.addNewPaymentComponent().mxBankComponent().clickContinue();
			customerProfilePage.addNewPaymentComponent().mxBankComponent().successFailureComponent()
					.verifyBankSucessHeading(data.get("sucessHeading"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().successFailureComponent()
					.verifyAddedBankDescription(data.get("sucessDescription"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Add Bank Account failed due to Exception " + e);
		}
	}

}
