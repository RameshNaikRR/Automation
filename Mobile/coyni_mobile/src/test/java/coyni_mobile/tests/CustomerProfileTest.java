package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.AgreementPage;
import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.DashboardPage;
import coyni_mobile.pages.EnableFaceOrTouchIDpage;
import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.LoginPage;
import coyni_mobile.pages.PreferencesPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class CustomerProfileTest {

	CustomerProfilePage customerProfilePage;
	DashboardPage dashboardPage;
	PreferencesPage preferencesPage;
	MobileFunctions mobileFunctions;
	EnableFaceOrTouchIDpage enableFaceOrTouchIDpage;
	LoginPage loginPage;

	@BeforeTest
	public void init() {
		preferencesPage = new PreferencesPage();
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
			customerProfilePage.profilePage().verifyProfileView();
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
			customerProfilePage.profilePage().verifyProfileView();
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
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickEditEmail();
			customerProfilePage.profilePage().editProfilePage().verifyEmailHeading();
			customerProfilePage.profilePage().editProfilePage().verifyCurrentEmailHeading();
			customerProfilePage.profilePage().editProfilePage().verifyExistEmail(data.get("email"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditEmailHeading(data.get("editEmailHeading"));
			customerProfilePage.profilePage().editProfilePage().verifycurrentEmail(data.get("email"));
			customerProfilePage.profilePage().editProfilePage().fillNewEmail(data.get("newEmail"));
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentEmailVerificationHeading(data.get("currentEmailVerification"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentEmailVerificationText(data.get("currEmailVerifiDesc"), data.get("email"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewEmailVerificationHeading(data.get("newEmailVerification"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewEmailVerificationText(data.get("newEmailVerifiDesc"), data.get("newEmail"));
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

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickEditEmail();
			customerProfilePage.profilePage().editProfilePage().verifyEmailHeading();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditEmailHeading(data.get("editEmailHeading"));
			customerProfilePage.profilePage().editProfilePage().fillNewEmail(data.get("newEmail"));
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentEmailVerificationHeading(data.get("currentEmailVerification"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewEmailVerificationHeading(data.get("newEmailVerification"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().clickResend();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.viewNewCodeSentMsg();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("invalidCode"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyInvalidCode(data.get("invalidCodeMsg"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyEditEmailHeading(data.get("editEmailHeading"));
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentEmailVerificationHeading(data.get("currentEmailVerification"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().clickResend();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.viewNewCodeSentMsg();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("invalidCode"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyInvalidCode(data.get("invalidCodeMsg"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyDontHaveAccess();
			customerProfilePage.profilePage().editProfilePage().verifyNeedHelpView();
			customerProfilePage.profilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentEmailVerificationHeading(data.get("currentEmailVerification"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyEditEmailHeading(data.get("editEmailHeading"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyEmailHeading();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().clickForgotPin();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyForgotPINHeading(data.get("fogtPINHeadi"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyForgotPINDesc(data.get("fogtPINDesc"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillEmail(data.get("email"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().clickNext();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyForgotPINHeading(data.get("fogtPINHeadi"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyEmailHeading();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().verifyEmailHeading();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.viewAccountID();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickBack();
			customerProfilePage.viewAccountID();
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
	public void testEditEmailInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickEditEmail();
			customerProfilePage.profilePage().editProfilePage().verifyEmailHeading();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().clickForgotPin();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyForgotPINHeading(data.get("fogtPINHeadi"));
			String[] frgtEmail = data.get("fieldEmail").split(",");
			customerProfilePage.fieldValidationsComponent().validateEmailField(frgtEmail[0], frgtEmail[1],
					frgtEmail[2]);
//			String[] validateEmail = data.get("validateEmail").split(",");
//			for (int j = 0; j < 4; j++) {
//				if (j < 3) {
//					customerProfilePage.profilePage().editProfilePage().choosePinComponent()
//							.fillEmail(data.get(validateEmail[j]));
//					customerProfilePage.profilePage().editProfilePage().choosePinComponent().validateNext();
//				} else {
//					customerProfilePage.profilePage().editProfilePage().choosePinComponent()
//							.fillEmail(data.get(validateEmail[3]));
//					customerProfilePage.profilePage().editProfilePage().choosePinComponent().validateNext();
//					new CommonFunctions().validateFormErrorMessage(data.get("emailErrMsg"), "Email");
//				}
//			}
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditEmailHeading(data.get("editEmailHeading"));
			String[] email = data.get("fieldEmail").split(",");
			customerProfilePage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2]);
			String[] newEmail = data.get("newEmail").split(",");
			for (int i = 0; i < 4; i++) {
				if (i < 3) {
					customerProfilePage.profilePage().editProfilePage().fillNewEmail(newEmail[i]);
					customerProfilePage.profilePage().editProfilePage().verifyContinue();
				} else {
					customerProfilePage.profilePage().editProfilePage().fillNewEmail(newEmail[i]);
					customerProfilePage.profilePage().editProfilePage().clickContinue();
					String[] emailErrMsg = data.get("emailErrMsg").split(",");
					new CommonFunctions().validateFormErrorMessage(emailErrMsg[i - 3], "Email");
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Email Invalid data failed due to Exception " + e);
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
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickEditPhoneNumber();
			customerProfilePage.profilePage().editProfilePage().verifyPhoneNumberHdg(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().verifyCurrentPhoneNumberhdg(data.get("subHeading"));
			customerProfilePage.profilePage().editProfilePage()
					.verifyExistingPhoneNUmber(data.get("existingPhoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditPhoneNUmber(data.get("editPhoneHeading"));
			customerProfilePage.profilePage().editProfilePage()
					.verifyCurrentPhoneNUmber(data.get("existingPhoneNumber"));
			customerProfilePage.profilePage().editProfilePage().selectCountry(data.get("country"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentPhoneVerificationHeading(data.get("currPhVerifiHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentPhoneVerificationText(data.get("verificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewPhoneVerificationHdg(data.get("newPhoneVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewPhoneVerificationText(data.get("newVerificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().toastComponent().verifyToastMsg(data.get("toastMsg"));
			customerProfilePage.profilePage().verifyProfileView();
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
	public void testEditPhoneNumberInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickEditPhoneNumber();
			customerProfilePage.profilePage().editProfilePage().verifyPhoneNumberHdg(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().clickForgotPin();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyForgotPINHeading(data.get("fogtPINHeadi"));
			String[] email = data.get("fieldEmail").split(",");
			customerProfilePage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2]);
//			String[] validateEmail = data.get("validateEmail").split(",");
//			for (int j = 0; j < 4; j++) {
//				if (j < 3) {
//					customerProfilePage.profilePage().editProfilePage().choosePinComponent()
//							.fillEmail(data.get(validateEmail[j]));
//					customerProfilePage.profilePage().editProfilePage().choosePinComponent().validateNext();
//				} else {
//					customerProfilePage.profilePage().editProfilePage().choosePinComponent()
//							.fillEmail(data.get(validateEmail[3]));
//					customerProfilePage.profilePage().editProfilePage().choosePinComponent().validateNext();
//					new CommonFunctions().validateFormErrorMessage(data.get("emailErrMsg"), "Email");
//				}
//			}

			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditPhoneNUmber(data.get("editPhoneHeading"));
			customerProfilePage.profilePage().editProfilePage().selectCountry(data.get("country"));
			String[] phoneNumber = data.get("fieldPhoneNumber").split(",");
			customerProfilePage.fieldValidationsComponent().validatePhoneNumberField(phoneNumber[0], phoneNumber[1],
					phoneNumber[2]);
			String[] phNum = data.get("phoneNumber").split(",");
			for (int i = 0; i < 5; i++) {
				if (i < 3) {
					customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(phNum[i]);
					customerProfilePage.profilePage().editProfilePage().verifyContinue();
				} else {
					customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(phNum[i]);
					customerProfilePage.profilePage().editProfilePage().clickContinue();
					String[] phNumErrMsg = data.get("phNumErrMsg").split(",");
					new CommonFunctions().validateFormErrorMessage(phNumErrMsg[i - 3], "Phone Number");
				}

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Phone Number failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumberNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickEditPhoneNumber();
			customerProfilePage.profilePage().editProfilePage().verifyPhoneNumberHdg(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditPhoneNUmber(data.get("editPhoneHeading"));
			customerProfilePage.profilePage().editProfilePage().selectCountry(data.get("country"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentPhoneVerificationHeading(data.get("currPhVerifiHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyNewPhoneVerificationHdg(data.get("newPhoneVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().clickResend();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.viewNewCodeSentMsg();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("invalidCode"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyInvalidCode(data.get("invalidCodeMsg"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyEditPhoneNUmber(data.get("editPhoneHeading"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentPhoneVerificationHeading(data.get("currPhVerifiHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().clickResend();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.viewNewCodeSentMsg();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.fillOtp(data.get("invalidCode"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyInvalidCode(data.get("invalidCodeMsg"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyDontHaveAccess();
			customerProfilePage.profilePage().editProfilePage().verifyNeedHelpView();
			customerProfilePage.profilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent()
					.verifyCurrentPhoneVerificationHeading(data.get("currPhVerifiHeading"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyEditPhoneNUmber(data.get("editPhoneHeading"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyPhoneNumberHdg(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().clickForgotPin();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyForgotPINHeading(data.get("fogtPINHeadi"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyForgotPINDesc(data.get("fogtPINDesc"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillEmail(data.get("email"));
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().clickNext();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent()
					.verifyForgotPINHeading(data.get("fogtPINHeadi"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyPhoneNumberHdg(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().verifyPhoneNumberHdg(data.get("heading"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.viewAccountID();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickBack();
			customerProfilePage.viewAccountID();
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
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickEditAddress();
			customerProfilePage.profilePage().editProfilePage().verifyAddressheading(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().verifyCurrentAddres(data.get("subHeading"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().verifyEditAddres(data.get("editAddressHeading"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickCountryDropdown();
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.selectCountry(data.get("country"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.fillAddLine1(data.get("addLine1"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.fillAddLine2(data.get("addLine2"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillState(data.get("state"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickAddAddress();
			customerProfilePage.profilePage().editProfilePage().toastComponent().verifyToastMsg(data.get("toastMsg"));
			customerProfilePage.profilePage().verifyProfileView();

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
	public void testEditAddressFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.profilePage().verifyProfileView();
			customerProfilePage.profilePage().clickEditAddress();
			customerProfilePage.profilePage().editProfilePage().verifyAddressheading(data.get("heading"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().verifyEditAddres(data.get("editAddressHeading"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickCountryDropdown();
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
					.selectCountry(data.get("country"));
			for (int i = 0; i < 1; i++) {
				customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clearAddLine1();
				customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickCity();
				new CommonFunctions().validateFormErrorMessage(data.get("addLine1ErrMsg"), "Address Line 1");
				String[] addLine1 = data.get("addLine1").split(",");
				customerProfilePage.fieldValidationsComponent().validateAddressLine1Field(addLine1[0], addLine1[1],
						addLine1[2]);
			}
			String[] addLine2 = data.get("addLine2").split(",");
			customerProfilePage.fieldValidationsComponent().validateAddressLine2Field(addLine2[0], addLine2[1],
					addLine2[2]);
			for (int i = 0; i < 1; i++) {
				customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clearCity();
				customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickAddLine1();
				new CommonFunctions().validateFormErrorMessage(data.get("cityErrMsg"), "City");
				String[] city = data.get("city").split(",");
				customerProfilePage.fieldValidationsComponent().validateCityField(city[0], city[1], city[2]);
			}
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillState(data.get("state"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickZipCode();
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().scrollToZipCode();
			String[] zipCode = data.get("zipCode").split(",");
			customerProfilePage.fieldValidationsComponent().validateZipCodeField(zipCode[0], zipCode[1], zipCode[2]);
			for (int i = 3; i < 5; i++) {
				customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillZipCode(zipCode[i]);
				customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickCity();
				DriverFactory.getDriver().hideKeyboard();
				String[] zipCodeErrMsg = data.get("zipCodeErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(zipCodeErrMsg[i - 3], "Zip Code");
			}
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().verifyAddressheading(data.get("heading"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.viewAccountID();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Address failed due to Exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testEditAddressFieldvalidations(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			dashboardPage.clickProfile();
//			customerProfilePage.clickProfile();
//			customerProfilePage.profilePage().verifyProfileView();
//			customerProfilePage.profilePage().clickEditAddress();
//			customerProfilePage.profilePage().navigationComponent().clickBack();
//			customerProfilePage.clickProfile();
//			customerProfilePage.profilePage().clickEditAddress();
//			customerProfilePage.profilePage().editProfilePage().clickChange();
//			customerProfilePage.profilePage().navigationComponent().clickBack();
//			customerProfilePage.profilePage().editProfilePage().clickChange();
//			customerProfilePage.profilePage().editProfilePage().verifyEditAddres(data.get("editAddressHeading"));
//			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().clickCountryDropdown();
//			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
//					.selectCountry(data.get("fillCountry"));
////			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
////					.validateAddline1(data.get("addline1"));
////			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
////					.validateAddline2(data.get("addline2"));
//			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
//					.validateCity(data.get("city"));
//			// customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillState(data.get("state"));
//			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent()
//					.validateZipCode(data.get("zipCode"));
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Edit Address Fieldvalidations failed due to Exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testPrefernces(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPreferences();
			customerProfilePage.preferencesPage().verifyPreferencesHeading(data.get("subHeading"));
			String[] timeZone = data.get("timeZones").split(",");
			for (int i = 0; i < timeZone.length; i++) {
				preferencesPage.selectTimeZone(timeZone[i]);
				preferencesPage.toastComponent().verifyToastMsg(data.get("toastMsg"));
				customerProfilePage.preferencesPage().verifyPreferencesHeading(data.get("subHeading"));
				preferencesPage.verifyTimeZone(timeZone[i]);
			}
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.viewAccountID();
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
			customerProfilePage.agreementPage().verifyAgreements(data.get("agreementsHeading"));
			customerProfilePage.agreementPage().clickPrivacyPolicy();
			customerProfilePage.agreementPage().verifyPrivacyAgreement(data.get("privacyHeading"));
			customerProfilePage.agreementPage().verifyActiveAgreement();
			customerProfilePage.agreementPage().clickActiveAgreement();
			customerProfilePage.agreementPage().verifyDocAgreeHeading(data.get("agreeDocHeading"));
			customerProfilePage.agreementPage().navigationComponent().clickClose();
			customerProfilePage.agreementPage().verifyPrivacyAgreement(data.get("privacyHeading"));
			customerProfilePage.agreementPage().verifyPastAgreement();
			customerProfilePage.agreementPage().clickPastAgreement();
			customerProfilePage.agreementPage().verifyDocAgreeHeading(data.get("agreeDocHeading"));
			customerProfilePage.agreementPage().navigationComponent().clickClose();
			customerProfilePage.agreementPage().verifyPrivacyAgreement(data.get("privacyHeading"));
			customerProfilePage.agreementPage().navigationComponent().clickBack();
			customerProfilePage.viewAccountID();
			customerProfilePage.clickAgreements();
			customerProfilePage.agreementPage().verifyAgreements(data.get("agreementsHeading"));
			customerProfilePage.agreementPage().clickTermsOfService();
			customerProfilePage.agreementPage().verifyTermsAgreement(data.get("termsHeading"));
			customerProfilePage.agreementPage().verifyActiveAgreement();
			customerProfilePage.agreementPage().clickActiveAgreement();
			customerProfilePage.agreementPage().verifyDocAgreeHeading(data.get("agreeDocHeading"));
			customerProfilePage.agreementPage().navigationComponent().clickClose();
			customerProfilePage.agreementPage().verifyPastAgreement();
			customerProfilePage.agreementPage().clickPastAgreement();
			customerProfilePage.agreementPage().verifyDocAgreeHeading(data.get("agreeDocHeading"));
			customerProfilePage.agreementPage().navigationComponent().clickClose();
			customerProfilePage.agreementPage().verifyTermsAgreement(data.get("termsHeading"));
			customerProfilePage.agreementPage().navigationComponent().clickBack();
			customerProfilePage.viewAccountID();
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
			customerProfilePage.accountLimitsPage().verifyAccountLimitsHeading(data.get("subHeading"));
			customerProfilePage.accountLimitsPage().verifySendRequestHeading(data.get("sendReqHeading"));
			customerProfilePage.accountLimitsPage().verifySendRequest();
			customerProfilePage.accountLimitsPage().verifyBuyToken(data.get("buyTokenHeading"));
			customerProfilePage.accountLimitsPage().verifyBankAccountView();
			customerProfilePage.accountLimitsPage().verifyDebitCredView();
			customerProfilePage.accountLimitsPage().verifyWithdraw(data.get("withdrawTokenHeading"));
			customerProfilePage.accountLimitsPage().verfiyWithdrawBankView();
			customerProfilePage.accountLimitsPage().verfiyWithdrawInstantView();
			customerProfilePage.accountLimitsPage().verfiyWithdrawGiftCardView();
			customerProfilePage.navigationComponent().clickBack();

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
			customerProfilePage.walletsFeesPage().verifyWalletFees(data.get("subHeading"));
			customerProfilePage.walletsFeesPage().verifyBuyToken(data.get("buyTokenHeading"));
			customerProfilePage.walletsFeesPage().verifyBuyTokenBankAccountFee();
			customerProfilePage.walletsFeesPage().verifyBuyTokenCreditCardFee();
			customerProfilePage.walletsFeesPage().verifyBuyTokenDebitCardFee();
			customerProfilePage.walletsFeesPage().verifyWithdraw(data.get("withdrawTokenHeading"));
			customerProfilePage.walletsFeesPage().verifyWithdrawTokenBankAccountFee();
			customerProfilePage.walletsFeesPage().verifyWithdrawTokenInstantFee();
			customerProfilePage.walletsFeesPage().verifyWithdrawTokenGiftCard();
			customerProfilePage.walletsFeesPage().verifyWithdrawTokenFailedBank();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.viewAccountID();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Wallet Fees  failed due to Exception " + e);
		}
	}

	/**
	 * testLogOut script to test the logout feature.
	 */
	@Test
	public void testLogout() {
		try {
			dashboardPage.clickProfile();
			customerProfilePage.verifyUserNAmeandStatus();
			customerProfilePage.clickLogout();
			customerProfilePage.landingPage().verifyCoyniView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Logout failed due to Exception " + e);
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
			for (int i = 1; i < 3; i++) {
				customerProfilePage.clickResetPinCode();
				customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
				customerProfilePage.choosePinComponent().verifyForgotPinView();
				customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
				customerProfilePage.choosePinComponent().verifyChooseYourPinView(data.get("choosePinHeading"));
				customerProfilePage.choosePinComponent().verifyChooseYouPinDes(data.get("choosePinDesc"));
				customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
				customerProfilePage.choosePinComponent().verifyConfirmYourPin(data.get("confirmPinHeading"));
				if (i == 1) {
					customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
					customerProfilePage.choosePinComponent().toastComponent().verifyToastMsg(data.get("toastMsg"));
					customerProfilePage.viewAccountID();
				} else {
					customerProfilePage.navigationComponent().clickBack();
					customerProfilePage.choosePinComponent().verifyChooseYourPinView(data.get("choosePinHeading"));
					customerProfilePage.navigationComponent().clickBack();
					customerProfilePage.viewAccountID();
					customerProfilePage.clickResetPinCode();
					customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
					customerProfilePage.choosePinComponent().clickForgotPin();
					customerProfilePage.choosePinComponent().verifyForgotPINHeading(data.get("fogtPINHeadi"));
					customerProfilePage.choosePinComponent().verifyForgotPINDesc(data.get("fogtPINDesc"));
					customerProfilePage.choosePinComponent().fillEmail(data.get("email"));
					customerProfilePage.choosePinComponent().clickNext();
					customerProfilePage.navigationComponent().clickBack();
					customerProfilePage.choosePinComponent().verifyForgotPINHeading(data.get("fogtPINHeadi"));
					customerProfilePage.navigationComponent().clickBack();
					customerProfilePage.clickResetPinCode();
					customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
					customerProfilePage.navigationComponent().clickClose();
					customerProfilePage.viewAccountID();
				}
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
					.verifyCurrentPassword(data.get("currPwdHeading"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyCurrentPasswordDesc(data.get("currPwdDescription"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.fillCurrentPassword(data.get("password"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickCurrentPassIconEye();
			customerProfilePage.choosePinComponent().createPasswordComponent().clickNext();
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyNewPasswordHeading(data.get("subHeading"));
			customerProfilePage.choosePinComponent().createPasswordComponent().fillNewPassword(data.get("newPassword"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickNewPassIconEye();
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.fillConfirmPassword(data.get("confirmPassword"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyNewPasswordDesc(data.get("description"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickConfirmPassIconEye();
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
			customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyCurrentPassword(data.get("currPwdHeading"));
			for (int i = 0; i < 1; i++) {
				customerProfilePage.choosePinComponent().createPasswordComponent()
						.fillCurrentPassword(data.get("fieldCurrntPwd"));
				customerProfilePage.choosePinComponent().createPasswordComponent().clickNext();
				new CommonFunctions().validateFormErrorMessage(data.get("currntPwdErrMsg"), "Current Password");
			}
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.fillCurrentPassword(data.get("password"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickCurrentPassIconEye();
			customerProfilePage.choosePinComponent().createPasswordComponent().clickNext();
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyNewPasswordHeading(data.get("subHeading"));
			for (int i = 0; i < 6; i++) {
				String[] fieldPassword = data.get("fieldPassword").split(",");
				customerProfilePage.choosePinComponent().createPasswordComponent().verifyDisableStateSave();
				customerProfilePage.choosePinComponent().createPasswordComponent().fillNewPassword(fieldPassword[i]);
				customerProfilePage.choosePinComponent().createPasswordComponent().clickConfirmPassword();
				String[] newPwdErrMsg = data.get("pwdErrorMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(newPwdErrMsg[i], "New Password Field");
				customerProfilePage.choosePinComponent().createPasswordComponent().verifyDisableStateSave();
			}
			customerProfilePage.choosePinComponent().createPasswordComponent().fillNewPassword(data.get("password"));
			for (int i = 0; i < 2; i++) {
				String[] fieldConfPwd = data.get("fieldConfPwd").split(",");
				customerProfilePage.choosePinComponent().createPasswordComponent().fillConfirmPassword(fieldConfPwd[i]);
				customerProfilePage.choosePinComponent().createPasswordComponent().clickNewPassword();
				DriverFactory.getDriver().hideKeyboard();
				String[] conPwdErrMsg = data.get("confPwdErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(conPwdErrMsg[i], "Confirm Password Field");
				customerProfilePage.choosePinComponent().createPasswordComponent().verifyDisableStateSave();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" Change Password failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickChangePassword();
			customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyCurrentPassword(data.get("currPwdHeading"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.fillCurrentPassword(data.get("password"));
			customerProfilePage.choosePinComponent().createPasswordComponent().clickCurrentPassIconEye();
			customerProfilePage.choosePinComponent().createPasswordComponent().clickNext();
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyNewPasswordHeading(data.get("subHeading"));
			String[] password = data.get("fieldPassword").split(",");
			customerProfilePage.choosePinComponent().createPasswordComponent().fieldValidationsComponent()
					.validateNewPasswordField(password[0], password[1], password[2]);
			customerProfilePage.choosePinComponent().createPasswordComponent().fieldValidationsComponent()
					.validateConfirmPasswordField(password[0], password[1], password[2]);
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.clickChangePassword();
			customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.choosePinComponent().createPasswordComponent()
					.verifyCurrentPassword(data.get("currPwdHeading"));
			String[] currntPassword = data.get("fieldPassword").split(",");
			loginPage.fieldValidationsComponent().validatePasswordField(currntPassword[0], currntPassword[1],
					currntPassword[2]);
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.clickChangePassword();
			customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.choosePinComponent().clickForgotPin();
			customerProfilePage.choosePinComponent().verifyForgotPINHeading(data.get("fogtPINHeadi"));
			customerProfilePage.choosePinComponent().verifyForgotPINDesc(data.get("fogtPINDesc"));
			customerProfilePage.choosePinComponent().fillEmail(data.get("email"));
			customerProfilePage.choosePinComponent().clickNext();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.choosePinComponent().verifyForgotPINHeading(data.get("fogtPINHeadi"));
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.viewAccountID();
			customerProfilePage.clickChangePassword();
			customerProfilePage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.viewAccountID();
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
			customerProfilePage.logInSessionsPage().viewLogInSessHeader(data.get("logInSessionHeading"));
			if (data.get("validateChangePassword").equalsIgnoreCase("button")) {
				customerProfilePage.logInSessionsPage().verifyDeviceStatus(data.get("deviceStatus"));
				customerProfilePage.logInSessionsPage().verifyDeviceDetails();
				customerProfilePage.logInSessionsPage().viewInactiveStatus();
				customerProfilePage.logInSessionsPage().clickEndAllSessions();
				customerProfilePage.logInSessionsPage().verifyEndSessionsHeading(data.get("endSessnHeading"));
				customerProfilePage.logInSessionsPage().viewEndSessionsDesc();
				Thread.sleep(2000);
				customerProfilePage.logInSessionsPage().clickChangePassword();
				validateChangePassword(strParams);
			} else if (data.get("validateChangePassword").equalsIgnoreCase("link")) {
				customerProfilePage.logInSessionsPage().clickLnkChangePassword();
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

	public void testAddCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			if (customerProfilePage.addNewPaymentComponent().verifyAddNewPaymentPlusIcon() == 1) {
				customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
				customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
			}
			int numOfDebit = customerProfilePage.addNewPaymentComponent().getPresentDebitCards();
			int numOfCredit = customerProfilePage.addNewPaymentComponent().getPresentCreditCards();
			if (data.get("cardHeading").equals("Add New Debit Card")
					|| data.get("cardHeading").equals("Add Debit Card")) {
				customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
				if (numOfDebit <= 3) {
					if (!(data.get("numOfPaymentMethods").isEmpty())) {
						customerProfilePage.addNewPaymentComponent().verifyDebitCards(data.get("numOfPaymentMethods"));
					}
					customerProfilePage.addNewPaymentComponent().clickDebitCard();
				}
			} else {
				if (numOfCredit <= 3) {
					if (!(data.get("numOfPaymentMethods").isEmpty())) {
						customerProfilePage.addNewPaymentComponent().verifyCreditCards(data.get("numOfPaymentMethods"));
					}
					customerProfilePage.addNewPaymentComponent().clickCreditCard();
				}
			}
			if (!(numOfDebit == 4 || numOfCredit == 4)) {
				customerProfilePage.addNewPaymentComponent().addCardComponent()
						.verifyAddDebitorCredHeading(data.get("cardHeading"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().viewAddcardDesc();
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardNumber(data.get("cardNumber"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardExp(data.get("cardExp"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCVVorCVC(data.get("cvv"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().clickNext();
				customerProfilePage.addNewPaymentComponent().addCardComponent()
						.verifyAddDebitorCredHeading(data.get("cardHeading"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.clickCountryDropdown();
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.selectCountry(data.get("country"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillAddLine1(data.get("addLine1"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillAddLine2(data.get("addLine2"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillCity(data.get("city"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillState(data.get("state"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.fillZipCode(data.get("zipCode"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.clickAddAddress();
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.preAuthorizationComponent().verifyHeading(data.get("preAuthHeading"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.preAuthorizationComponent().fillAmount(data.get("preAuthiAmount"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.preAuthorizationComponent().clickVerify();
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.preAuthorizationComponent().successFailureComponent()
						.verifyAllDone(data.get("cardSuccessHeading"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.preAuthorizationComponent().successFailureComponent()
						.verifyCardSucessDesc(data.get("cardSuccessDescription"));
				customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
						.preAuthorizationComponent().successFailureComponent().clickDone();
			} else {
				if (data.get("cardHeading").equals("Add New Debit Card")
						|| data.get("cardHeading").equals("Add Debit Card")) {
					customerProfilePage.addNewPaymentComponent().verifyDebitCards(data.get("numOfPaymentMethods"));
				} else {
					customerProfilePage.addNewPaymentComponent().verifyCreditCards(data.get("numOfPaymentMethods"));
				}
				customerProfilePage.addNewPaymentComponent().verifyErrMsg(data.get("payMethodMaxRechdErrMsg"));
				customerProfilePage.navigationComponent().clickBack();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("AddAddress is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			int previousDebitCards = customerProfilePage.paymentMethodsPage().verifyNumOfDebitCard();
			System.out.println(previousDebitCards);
			int previousCreditCards = customerProfilePage.paymentMethodsPage().verifyNumOfCreditCard();
			System.out.println(previousCreditCards);
			testAddCard(strParams);
			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
			int includedAddedDebit = customerProfilePage.paymentMethodsPage().verifyNumOfDebitCard();
			int includedAddedCredit = customerProfilePage.paymentMethodsPage().verifyNumOfCreditCard();

			if (includedAddedCredit == 4 || (includedAddedDebit == 4)) {

			} else if (data.get("cardHeading").equals("Add New Debit Card")
					|| data.get("cardHeading").equals("Add Debit Card")) {
				if (previousDebitCards + 1 == includedAddedDebit) {
					ExtentTestManager
							.setPassMessageInReport("Debit Card Added and Reflected in Payment Methods Screen");
				} else {
					ExtentTestManager
							.setWarningMessageInReport("Debit Card Added but not Reflected in Payment Methods Screen");
				}
			} else {
				if (previousCreditCards + 1 == includedAddedCredit) {
					ExtentTestManager
							.setPassMessageInReport("Credit Card Added and Reflected in Payment Methods Screen");
				} else {
					ExtentTestManager
							.setWarningMessageInReport("Credit Card Added but not Reflected in Payment Methods Screen");
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("AddAddress is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			if (customerProfilePage.addNewPaymentComponent().verifyAddNewPaymentPlusIcon() == 1) {
				customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
				customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
			}
			customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
			if (data.get("cardHeading").equals("Add Debit Card")) {
				customerProfilePage.addNewPaymentComponent().clickDebitCard();
			} else {
				customerProfilePage.addNewPaymentComponent().clickCreditCard();
			}
			customerProfilePage.addNewPaymentComponent().addCardComponent()
					.verifyAddDebitorCredHeading(data.get("cardHeading"));
			String[] fieldNameOnCard = data.get("fieldNameOnCard").split(",");
			for (int i = 0; i <= 1; i++) {
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillNameOnCard(fieldNameOnCard[i]);
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardNumber(data.get("cardNumber"));
				String[] nameOnCardErrMsg = data.get("nameOnCardErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(nameOnCardErrMsg[i], "Name on card");
			}
			customerProfilePage.fieldValidationsComponent().validateNameOnCardField(fieldNameOnCard[2],
					fieldNameOnCard[3], fieldNameOnCard[4], fieldNameOnCard[5], data.get("keyBoardType"));
			String[] fieldCardNumber = data.get("fieldCardNumber").split(",");
			for (int j = 0; j <= 2; j++) {
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardNumber(fieldCardNumber[j]);
				customerProfilePage.addNewPaymentComponent().addCardComponent().clickNameOnCard();
				String[] cardNumberErrMsg = data.get("cardNumberErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(cardNumberErrMsg[j], "Card Number");
			}
			customerProfilePage.fieldValidationsComponent().validateCardNumberField(fieldCardNumber[3],
					fieldCardNumber[4], fieldCardNumber[5]);
			String[] fieldExpiryDate = data.get("fieldExpiryDate").split(",");
			for (int k = 0; k <= 3; k++) {
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardExp((fieldExpiryDate[k]));
				customerProfilePage.addNewPaymentComponent().addCardComponent().clickNameOnCard();
				String[] expiryDateErrMsg = data.get("expiryDateErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(expiryDateErrMsg[k], "Expiry Date");
			}
			customerProfilePage.fieldValidationsComponent().validateCardExpField(fieldExpiryDate[4], fieldExpiryDate[5],
					fieldExpiryDate[6]);
			String[] fieldCvv = data.get("fieldCvv").split(",");
			for (int l = 0; l <= 2; l++) {
				customerProfilePage.addNewPaymentComponent().addCardComponent().fillCVVorCVC((fieldCvv[l]));
				customerProfilePage.addNewPaymentComponent().addCardComponent().clickNameOnCard();
				String[] cvvErrMsg = data.get("cvvErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(cvvErrMsg[l], "CVVorCVC");
			}
			customerProfilePage.fieldValidationsComponent().validateCvvField(fieldCvv[3], fieldCvv[4], fieldCvv[5]);
			customerProfilePage.addNewPaymentComponent().addCardComponent().clickNext();
			customerProfilePage.addNewPaymentComponent().addCardComponent().verifyInvalidPopupmsg(data.get("errMsg"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().clickOk();
			customerProfilePage.addNewPaymentComponent().addCardComponent()
					.verifyAddDebitorCredHeading(data.get("cardHeading"));
			customerProfilePage.addNewPaymentComponent().addCardComponent().validateInvalidTypeCard();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("AddAddress is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			testDeleteDebitCards(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	public void testDeleteDebitCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
			int addedDebit = customerProfilePage.paymentMethodsPage().verifyNumOfDebitCard();
			int addedCredit = customerProfilePage.paymentMethodsPage().verifyNumOfCreditCard();
			if (data.get("cardHeading").equals("Add New Debit Card")
					|| data.get("cardHeading").equals("Add Debit Card")) {
				for (int i = 1; i <= addedDebit; i++) {
					customerProfilePage.paymentMethodsPage().clickDebitCard();
					customerProfilePage.paymentMethodsPage().editCardComponent().clickEditPaymentMethod();
					customerProfilePage.paymentMethodsPage().editCardComponent().clickRemove();
					customerProfilePage.paymentMethodsPage().editCardComponent()
							.verifyRemovingHdg(data.get("removePopUpHeading"));
					customerProfilePage.paymentMethodsPage().editCardComponent().clickYes();
					customerProfilePage.paymentMethodsPage().toastComponent().verifyToastMsg(data.get("toastMsg"));
					if (!(addedDebit == i) || !(addedCredit == 0)) {
						customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
						customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
					}
					int presentDebitCards = customerProfilePage.addNewPaymentComponent().getPresentDebitCards();
					if (addedDebit - i == presentDebitCards) {
						ExtentTestManager.setPassMessageInReport(
								"After deleting the cards count is reducing : " + presentDebitCards);
					} else {
						ExtentTestManager.setFailMessageInReport(
								"After deleting the cards count is not reducing : " + presentDebitCards);
					}
					customerProfilePage.navigationComponent().clickBack();
				}
			} else {
				for (int i = 1; i <= addedCredit; i++) {
					customerProfilePage.paymentMethodsPage().clickCreditCard();
					customerProfilePage.paymentMethodsPage().editCardComponent().clickEditPaymentMethod();
					customerProfilePage.paymentMethodsPage().editCardComponent().clickRemove();
					customerProfilePage.paymentMethodsPage().editCardComponent()
							.verifyRemovingHdg(data.get("removePopUpHeading"));
					customerProfilePage.paymentMethodsPage().editCardComponent().clickYes();
					customerProfilePage.paymentMethodsPage().toastComponent().verifyToastMsg(data.get("toastMsg"));
					if (!(addedCredit == i) || !(addedDebit == 0)) {
						customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
						customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
					}
					int presentCreditCards = customerProfilePage.addNewPaymentComponent().getPresentCreditCards();
					if (addedCredit - i == presentCreditCards) {
						ExtentTestManager.setPassMessageInReport(
								"After deleting the cards count is reducing : " + presentCreditCards);
					} else {
						ExtentTestManager.setFailMessageInReport(
								"After deleting the cards count is not reducing : " + presentCreditCards);
					}
					customerProfilePage.navigationComponent().clickBack();
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

//	public void testDeleteDebitCards(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
//			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
//			int numOfDebit = customerProfilePage.paymentMethodsPage().verifyNumOfDebitCard();
//			int numOfCredit = customerProfilePage.paymentMethodsPage().verifyNumOfCreditCard();
//			if (data.get("cardHeading").equals("Add New Debit Card")
//					|| data.get("cardHeading").equals("Add Debit Card")) {
//				for (int i = 1; i <= numOfDebit; i++) {
//					customerProfilePage.paymentMethodsPage().clickDebitCard();
//					String cardDetlsHeadi = customerProfilePage.paymentMethodsPage().editCardComponent()
//							.verifyCardNumHeading();
//					customerProfilePage.paymentMethodsPage().editCardComponent().clickEditPaymentMethod();
//					String editCardHeadi = customerProfilePage.paymentMethodsPage().editCardComponent()
//							.verifyEditCardHeading();
//					if (editCardHeadi.equals(cardDetlsHeadi)) {
//						ExtentTestManager
//								.setPassMessageInReport("Edit Card Heading and Card details screen heading are same");
//					} else {
//						ExtentTestManager.setFailMessageInReport(
//								"Edit Card Heading and Card details screen heading are not same");
//					}
//					customerProfilePage.paymentMethodsPage().editCardComponent().clickRemove();
//					customerProfilePage.paymentMethodsPage().editCardComponent()
//							.verifyRemovingHdg(data.get("removePopUpHeading"));
//					customerProfilePage.paymentMethodsPage().editCardComponent().clickYes();
//					customerProfilePage.paymentMethodsPage().toastComponent().verifyToastMsg(data.get("toastMsg"));
//				}
//			} else {
//				for (int i = 1; i <= numOfCredit; i++) {
//					customerProfilePage.paymentMethodsPage().clickCreditCard();
//					String cardDetlsHeadi = customerProfilePage.paymentMethodsPage().editCardComponent()
//							.verifyCardNumHeading();
//					customerProfilePage.paymentMethodsPage().editCardComponent().clickEditPaymentMethod();
//					String editCardHeadi = customerProfilePage.paymentMethodsPage().editCardComponent()
//							.verifyEditCardHeading();
//					if (editCardHeadi.equals(cardDetlsHeadi)) {
//						ExtentTestManager
//								.setPassMessageInReport("Edit Card Heading and Card details screen heading are same");
//					} else {
//						ExtentTestManager.setFailMessageInReport(
//								"Edit Card Heading and Card details screen heading are not same");
//					}
//					customerProfilePage.paymentMethodsPage().editCardComponent().clickRemove();
//					customerProfilePage.paymentMethodsPage().editCardComponent()
//							.verifyRemovingHdg(data.get("removePopUpHeading"));
//					customerProfilePage.paymentMethodsPage().editCardComponent().clickYes();
//					customerProfilePage.paymentMethodsPage().toastComponent().verifyToastMsg(data.get("toastMsg"));
//				}
//			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//
//	}

	@Test
	@Parameters({ "strParams" })
	public void testVerifyDeleteDebitCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
			int addedDebit = customerProfilePage.paymentMethodsPage().verifyNumOfDebitCard();
			int addedCredit = customerProfilePage.paymentMethodsPage().verifyNumOfCreditCard();
			if (data.get("cardHeading").equals("Add New Debit Card")
					|| data.get("cardHeading").equals("Add Debit Card")) {
				for (int i = 1; i <= addedDebit; i++) {
					customerProfilePage.paymentMethodsPage().clickDebitCard();
					customerProfilePage.paymentMethodsPage().editCardComponent().clickEditPaymentMethod();
					customerProfilePage.paymentMethodsPage().editCardComponent().clickRemove();
					customerProfilePage.paymentMethodsPage().editCardComponent()
							.verifyRemovingHdg(data.get("removePopUpHeading"));
					customerProfilePage.paymentMethodsPage().editCardComponent().clickYes();
					customerProfilePage.paymentMethodsPage().toastComponent().verifyToastMsg(data.get("toastMsg"));
					if (!(addedDebit == i)) {
						customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
						customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
					}
					int presentDebitCards = customerProfilePage.addNewPaymentComponent().getPresentDebitCards();
					if (addedDebit - i == presentDebitCards) {
						ExtentTestManager.setPassMessageInReport(
								"After deleting the cards count is reducing : " + presentDebitCards);
					} else {
						ExtentTestManager.setFailMessageInReport(
								"After deleting the cards count is not reducing : " + presentDebitCards);
					}
					customerProfilePage.navigationComponent().clickBack();
				}
			} else {
				for (int i = 1; i <= addedCredit; i++) {
					customerProfilePage.paymentMethodsPage().clickCreditCard();
					customerProfilePage.paymentMethodsPage().editCardComponent().clickEditPaymentMethod();
					customerProfilePage.paymentMethodsPage().editCardComponent().clickRemove();
					customerProfilePage.paymentMethodsPage().editCardComponent()
							.verifyRemovingHdg(data.get("removePopUpHeading"));
					customerProfilePage.paymentMethodsPage().editCardComponent().clickYes();
					customerProfilePage.paymentMethodsPage().toastComponent().verifyToastMsg(data.get("toastMsg"));
					if (!(addedCredit == i)) {
						customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
						customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
					}
					int presentCreditCards = customerProfilePage.addNewPaymentComponent().getPresentCreditCards();
					int addedCreditCards = customerProfilePage.addNewPaymentComponent().getAddedCreditCards();
					if (addedCreditCards - i == presentCreditCards) {
						ExtentTestManager.setPassMessageInReport(
								"After deleting the cards count is reducing : " + presentCreditCards);
					} else {
						ExtentTestManager.setFailMessageInReport(
								"After deleting the cards count is not reducing : " + presentCreditCards);
					}

					customerProfilePage.navigationComponent().clickBack();
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			testAddBankAccount(strParams);
//			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
//			int includedAddedBank = customerProfilePage.paymentMethodsPage().verifyNumOfBanks();
//			if (previousBanks + 1 == includedAddedBank) {
//				ExtentTestManager.setPassMessageInReport("MX Bank Added and Reflected in Payment Methods Screen");
//			} else {
//				ExtentTestManager.setFailMessageInReport("MX Bank Added but not Reflected in Payment Methods Screen");
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBankAccount failed due to this Exception" + e);
		}
	}

	public void testAddBankAccount(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			if (customerProfilePage.addNewPaymentComponent().verifyAddNewPaymentPlusIcon() == 1) {
				customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
				customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
			}
			customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
			customerProfilePage.addNewPaymentComponent().clickBankAcount();
			customerProfilePage.addNewPaymentComponent().mxBankComponent().addBank(data.get("mxAddBankHeading"),
					data.get("mxAddBankDescription"), data.get("mxAddBankChkBxDescription"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent()
					.verifySelectYourInstitution(data.get("heading"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().clickMoreInstitutions();
			if (customerProfilePage.addNewPaymentComponent().mxBankComponent()
					.MXConfirmationScreen(data.get("mxConfirmationHeading")) == 1) {
				customerProfilePage.addNewPaymentComponent().mxBankComponent().verifyMXConfirmationScreen(
						data.get("mxConfirmationHeading"), data.get("mxConfirmationDescription"));
				customerProfilePage.addNewPaymentComponent().mxBankComponent().clickMXContinue();
			}
			customerProfilePage.addNewPaymentComponent().mxBankComponent().clickMXBank();
			customerProfilePage.addNewPaymentComponent().mxBankComponent()
					.verifyCredentialsHeading(data.get("credentialsHeading"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().fillUserName(data.get("mxUsername"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().fillPassword(data.get("mxPassword"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().clickContinue();
			customerProfilePage.addNewPaymentComponent().mxBankComponent().VerifySelectAccountHeading();
			if (data.get("accountType").equalsIgnoreCase("checking")) {
				customerProfilePage.addNewPaymentComponent().mxBankComponent().clickChecking();
			} else {
				customerProfilePage.addNewPaymentComponent().mxBankComponent().clickSavings();
			}
			customerProfilePage.addNewPaymentComponent().mxBankComponent().clickContinue();
			customerProfilePage.addNewPaymentComponent().mxBankComponent().successFailureComponent()
					.verifyBankSucessHeading(data.get("cardSuccessHeading"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().successFailureComponent()
					.verifyAddedBankDescription(data.get("cardSuccessDescription"));
			customerProfilePage.addNewPaymentComponent().mxBankComponent().successFailureComponent().clickDone();
			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Add Bank Account failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBank(String strPrams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strPrams);
			testDeleteBanks(strPrams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	public void testDeleteBanks(String strPrams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strPrams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
			int numOfBank = customerProfilePage.paymentMethodsPage().verifyNumOfBanks();
			for (int i = 1; i <= numOfBank; i++) {
				customerProfilePage.paymentMethodsPage().clickBankAccount();
				customerProfilePage.paymentMethodsPage().editCardComponent().verifyRemoveBankAccount();
				customerProfilePage.paymentMethodsPage().editCardComponent().clickRemoveAccount();
				customerProfilePage.paymentMethodsPage().editCardComponent()
						.verifyRemovingHdg(data.get("removePopUpHeading"));
				customerProfilePage.paymentMethodsPage().editCardComponent().clickYes();
				customerProfilePage.paymentMethodsPage().toastComponent().verifyToastMsg(data.get("toastMsg"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	@Test
	public void testEnableTouchOrFaceID() {
		try {
			dashboardPage.clickProfile();
			customerProfilePage.clickFaceIDTouchID();
			customerProfilePage.enableFaceOrTouchIDpage().clickTouchIDNotNow();
			customerProfilePage.viewAccountID();
			customerProfilePage.verifyUserNAmeandStatus();
			customerProfilePage.clickFaceIDTouchID();
			new CommonFunctions().clickBack();
			customerProfilePage.viewAccountID();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("AddDebitCardINwithdrawToUSd failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickGetHelp();
			customerProfilePage.enableFaceOrTouchIDpage().verifyGetHelp(data.get("getHelpHeading"));
			customerProfilePage.enableFaceOrTouchIDpage().verifyGetHelpDesc(data.get("getHelpDesc"));
			customerProfilePage.enableFaceOrTouchIDpage().verifyGetHelpView();
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.viewAccountID();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Get Help failed due to Exception " + e);
		}
	}

//	public void testAddCard(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
//			if (customerProfilePage.addNewPaymentComponent().verifyAddNewPaymentPlusIcon() == 1) {
//				customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
//				customerProfilePage.addNewPaymentComponent().clickAddNewPaymentPlusIcon();
//			}
//			if (data.get("cardHeading").equals("Add New Debit Card")
//					|| data.get("cardHeading").equals("Add Debit Card")) {
//				customerProfilePage.addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
//				customerProfilePage.addNewPaymentComponent().clickDebitCard();
//			} else {
//				customerProfilePage.addNewPaymentComponent().clickCreditCard();
//			}
//			customerProfilePage.addNewPaymentComponent().addCardComponent()
//					.verifyAddDebitorCredHeading(data.get("cardHeading"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().viewAddcardDesc();
//			customerProfilePage.addNewPaymentComponent().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardNumber(data.get("cardNumber"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().fillCardExp(data.get("cardExp"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().fillCVVorCVC(data.get("cvv"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().clickNext();
//			customerProfilePage.addNewPaymentComponent().addCardComponent()
//					.verifyAddDebitorCredHeading(data.get("cardHeading"));
////			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
////					.clickCountryDropdown();
////			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
////					.selectCountry(data.get("country"));
////			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
////					.fillAddLine1(data.get("addLine1"));
////			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
////					.fillAddLine2(data.get("addLine2"));
////			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
////					.fillCity(data.get("city"));
////			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
////					.fillState(data.get("state"));
////			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
////					.fillZipCode(data.get("zipCode"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent().clickAddAddress();
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.preAuthorizationComponent().verifyHeading(data.get("preAuthHeading"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.preAuthorizationComponent().fillAmount(data.get("preAuthiAmount"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.preAuthorizationComponent().clickVerify();
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.preAuthorizationComponent().successFailureComponent()
//					.verifyAllDone(data.get("cardSuccessHeading"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.preAuthorizationComponent().successFailureComponent()
//					.verifyCardSucessDesc(data.get("cardSuccessDescription"));
//			customerProfilePage.addNewPaymentComponent().addCardComponent().mailingAddressComponent()
//					.preAuthorizationComponent().successFailureComponent().clickDone();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("AddAddress is failed due to Exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddCards(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			dashboardPage.clickProfile();
//			customerProfilePage.clickPaymentMethods();
//			int previousDebitCards = customerProfilePage.paymentMethodsPage().verifyNumOfDebitCard();
//			int previousCreditCards = customerProfilePage.paymentMethodsPage().verifyNumOfCreditCard();
//			testAddCard(strParams);
//			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
//			int includedAddedDebit = customerProfilePage.paymentMethodsPage().verifyNumOfDebitCard();
//			int includedAddedCredit = customerProfilePage.paymentMethodsPage().verifyNumOfCreditCard();
//			if (data.get("cardHeading").equals("Add New Debit Card")
//					|| data.get("cardHeading").equals("Add Debit Card")) {
//				if (previousDebitCards + 1 == includedAddedDebit) {
//					ExtentTestManager
//							.setPassMessageInReport("Debit Card Added and Reflected in Payment Methods Screen");
//				} else {
//					ExtentTestManager
//							.setWarningMessageInReport("Debit Card Added but not Reflected in Payment Methods Screen");
//				}
//			} else {
//				if (previousCreditCards + 1 == includedAddedCredit) {
//					ExtentTestManager
//							.setPassMessageInReport("Credit Card Added and Reflected in Payment Methods Screen");
//				} else {
//					ExtentTestManager
//							.setFailMessageInReport("Credit Card Added but not Reflected in Payment Methods Screen");
//				}
//			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("AddAddress is failed due to Exception " + e);
//		}
//	}

}
