package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.AgreementPage;
import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.DashboardPage;
import coyni_mobile.pages.PreferencesPage;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class CustomerProfileTest  {
	
	CustomerProfilePage customerProfilePage;
	DashboardPage dashboardPage;
	AgreementPage agreementsPage;
	PreferencesPage preferencesPage;
	MobileFunctions mobileFunctions;
	
	@BeforeTest
	public void init() {
		preferencesPage = new PreferencesPage();
		agreementsPage = new AgreementPage();
		customerProfilePage = new CustomerProfilePage();
		dashboardPage = new DashboardPage();
		mobileFunctions = new MobileFunctions();	
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
	 * testEditEmail Script is to  Edit the Email
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
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyCurrentEmailVerificationHeading(data.get("emailVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyCurrentEmailVerificationText(data.get("verificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyResendView();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyDontHaveAccess();
			customerProfilePage.profilePage().editProfilePage().verifyNeedHelpView();
		    customerProfilePage.profilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyNewEmailVerificationHeading(data.get("newEmailVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyNewEmailVerificationText(data.get("newVerificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyResendView();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().successFailureComponent().verifyEmailSucess(data.get("sucessHeading"));
			customerProfilePage.profilePage().editProfilePage().successFailureComponent().verifyChangeEmailDesc(data.get("changeEmaildesc"));
			customerProfilePage.profilePage().editProfilePage().successFailureComponent().clickLogin();	
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit  Email failed due to Exception " + e);
		}
	}
	
	/**
	 * testEditEmailFieldValidations Script is to  Edit the Email navigations and text field validations
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
			customerProfilePage.profilePage().editProfilePage().validateEmail(data.get("newEmail"));
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickSave();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
		    customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyNewEmailVerificationHeading(data.get("newEmailVerificationHeading"));
		
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Email field validations Failed due to Exception " + e);
		}
	}
	
	/**
	 * testEditPhoneNumber Script is to  Edit the Phone Number 
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
			customerProfilePage.profilePage().editProfilePage().verifyExistingPhoneNUmber(data.get("existPhoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickChange();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().verifyEnterYourPinView();
			customerProfilePage.profilePage().editProfilePage().choosePinComponent().fillPin(data.get("pin"));
			customerProfilePage.profilePage().editProfilePage().verifyEditPhoneNUmber(data.get("editPhoneHeading"));
			customerProfilePage.profilePage().editProfilePage().verifyCurrentPhoneNUmber(data.get("existPhoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickArrow(data.get("fillCountry"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyCurrentPhoneVerificationHeading(data.get("phoneVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyCurrentPhoneVerificationText(data.get("verificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyResendView();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyDontHaveAccess();
			customerProfilePage.profilePage().editProfilePage().verifyNeedHelpView();
		    customerProfilePage.profilePage().navigationComponent().clickClose();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyNewPhoneVerificationHdg(data.get("newPhoneVerificationHeading"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyNewPhoneVerificationText(data.get("newVerificationText"));
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Phone Number failed due to Exception " + e);
		}
	}
	/**
	 * testEditEmailFieldValidations Script is to  Edit the Email navigations and text field validations
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
			customerProfilePage.profilePage().editProfilePage().validatePhoneNumber(data.get("phoneNumbers"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().clickArrow(data.get("fillCountry"));
			customerProfilePage.profilePage().editProfilePage().fillPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.profilePage().editProfilePage().clickContinue();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			customerProfilePage.profilePage().editProfilePage().navigationComponent().clickBack();
			customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
		    customerProfilePage.profilePage().editProfilePage().phoneAndEmailVerificationComponent().verifyNewEmailVerificationHeading(data.get("newEmailVerificationHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Phone Number Field Validations failed due to Exception " + e);
		}
	}
	/**
	 * testEditAddress Script is to  Edit the Phone Number 
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
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().selectCountry(data.get("country"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillAddLine1(data.get("addline1"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillAddLine2(data.get("addline2"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillState(data.get("state"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillZipCode(data.get("zipcode"));
			customerProfilePage.profilePage().editProfilePage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Address failed due to Exception " + e);
		}
	}
	
	/**
	 * testEditAddress Script is to  Edit the Phone Number 
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
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().selectCountry(data.get("country"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().validateAddline1(data.get("addline1"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().validateAddline2(data.get("addline2"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().validateCity(data.get("city"));
		//	customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().fillState(data.get("state"));
			customerProfilePage.profilePage().editProfilePage().mailingAddressComponent().validateZipCode(data.get("zipCode"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Edit Address Fieldvalidations failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void VerifyPrefernces(String strParams) {
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
	}

	@Test
	@Parameters({ "strParams" })
	public void VerifyAgreements(String strParams) {
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

	}

	@Test
	@Parameters({ "strParams" })
	public void VerifyAccountLimitsView(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		dashboardPage.clickProfile();
		customerProfilePage.clickAccountLimits();
		customerProfilePage.accountLimitsPage().verifyAccLimitsHeading(data.get("AccLimitsHeader"));
		customerProfilePage.accountLimitsPage().viewSendRequestLimit();
		customerProfilePage.accountLimitsPage().viewBuyTokenLimit();
		customerProfilePage.accountLimitsPage().viewWithdrawLimits();
	}

	@Test
	@Parameters({ "strParams" })
	public void VerifyWalletFeesView(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		dashboardPage.clickProfile();
		customerProfilePage.clickWalletFees();
		customerProfilePage.walletFeesPage().verifyWalletFeesHeading(data.get("WalletFeesHeader"));
		customerProfilePage.walletFeesPage().viewBuyTokenFees();
		customerProfilePage.walletFeesPage().viewWithdrawFees();
	}
	
	
	
	}


