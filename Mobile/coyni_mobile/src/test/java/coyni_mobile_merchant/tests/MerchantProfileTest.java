package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.pages.HomePage;
import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class MerchantProfileTest {

	MerchantProfilePage merchantProfilePage;
	HomePage homePage;
	EnterYourPINComponent enterYourPINComponent;
	NavigationComponent navigationComponent;

	@BeforeTest
	public void init() {
		merchantProfilePage = new MerchantProfilePage();
		homePage = new HomePage();
		navigationComponent = new NavigationComponent();
		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@AfterTest
	public void hideKeyBoard() {
		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeEmailWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyEmail();
			merchantProfilePage.userDetailsPage().getCurrentEmail();
			merchantProfilePage.userDetailsPage().clickEmail();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading("newEmailHeading");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("getCurrentDetailsHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("verifyNewEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeEmailWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyEmail();
			merchantProfilePage.userDetailsPage().getCurrentEmail();
			merchantProfilePage.userDetailsPage().clickEmail();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading("newEmailHeading");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsgHeading(data.get("errMessageHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsg(data.get("errMessage"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickOk();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeEmailWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyEmail();
			merchantProfilePage.userDetailsPage().getCurrentEmail();
			merchantProfilePage.userDetailsPage().clickEmail();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading("newEmailHeading");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("getCurrentDetailsHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("verifyNewEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().clickCloseIcon();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading("newEmailHeading");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("getCurrentDetailsHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().clickCloseIcon();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading("newEmailHeading");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickBack();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyEmail();
			merchantProfilePage.userDetailsPage().getCurrentEmail();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePhoneNumberWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyPhoneNumber();
			merchantProfilePage.userDetailsPage().getCurrentPhoneNumber();
			merchantProfilePage.userDetailsPage().clickPhoneNumber();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillPhoneNumber(data.get("newPhoneNumber"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("verifyCurrentPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("verifyNewPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePhoneNumberWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyPhoneNumber();
			merchantProfilePage.userDetailsPage().getCurrentPhoneNumber();
			merchantProfilePage.userDetailsPage().clickPhoneNumber();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillPhoneNumber(data.get("newPhoneNumber"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsgHeading(data.get("errMessageHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsg(data.get("errMessage"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickOk();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePhoneNumberWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyPhoneNumber();
			merchantProfilePage.userDetailsPage().getCurrentPhoneNumber();
			merchantProfilePage.userDetailsPage().clickPhoneNumber();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillPhoneNumber(data.get("newPhoneNumber"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("verifyCurrentPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("verifyNewPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillPhoneNumber(data.get("newPhoneNumber"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("verifyCurrentPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("verifyCurrentPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeAddressWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyAddress();
			merchantProfilePage.userDetailsPage().getCurrentAddress();
			merchantProfilePage.userDetailsPage().clickAddress();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentAddressDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.verifyPageHeading(data.get("editAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fillAddress(data.get("address"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fillCity(data.get("city"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fillState(data.get("state"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fillZipCode(data.get("zipCode"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().getDefaultCountry();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeAddressWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyAddress();
			merchantProfilePage.userDetailsPage().getCurrentAddress();
			merchantProfilePage.userDetailsPage().clickAddress();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentAddressDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.verifyPageHeading(data.get("editAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fillAddress(data.get("address"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fillCity(data.get("city"));
//			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
//					.fillState(data.get("state"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fillZipCode(data.get("zipCode"));
			if (data.get("validateZipCode").contains("yes")) {
				merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
						.fillAddress(data.get("address"));
				merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
						.fillCity(data.get("city"));
				merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
						.fillZipCode(data.get("zipCode"));
				merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().clickCity();

			}

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeAddressWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyAddress();
			merchantProfilePage.userDetailsPage().getCurrentAddress();
			merchantProfilePage.userDetailsPage().clickAddress();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentAddressDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.verifyPageHeading(data.get("editAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.navigationComponent().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentAddressDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickBack();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("heading"));
			merchantProfilePage.userDetailsPage().getUserDetails();

//			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
//					.fillAddress(data.get("address"));
//			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
//					.fillCity(data.get("city"));
//			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
//					.fillState(data.get("state"));
//			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
//					.fillZipCode(data.get("zipCode"));
//			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().getDefaultCountry();
////			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			
			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickChangePassword();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			merchantProfilePage.confirmPasswordPage().verifyPageHeading(data.get("confirmPasswordHeading"));
			merchantProfilePage.confirmPasswordPage().verifyPageDescription(data.get("confirmPasswordDescription"));
			Thread.sleep(1000);
			merchantProfilePage.confirmPasswordPage().fillCurrentPassword(data.get("currentPassword"));
			merchantProfilePage.confirmPasswordPage().clickEyeIcon();
			merchantProfilePage.confirmPasswordPage().clickNext();
			merchantProfilePage.confirmPasswordPage().changePasswordPage()
					.verifyPageHeading(data.get("changePwdHeading"));
			merchantProfilePage.confirmPasswordPage().changePasswordPage()
					.verifyPageDescription(data.get("changePwdDescription"));
			merchantProfilePage.confirmPasswordPage().changePasswordPage().fillNewPassword(data.get("newPassword"));
			merchantProfilePage.confirmPasswordPage().changePasswordPage().clickNewPwdEyeIcon();
			merchantProfilePage.confirmPasswordPage().changePasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			merchantProfilePage.confirmPasswordPage().changePasswordPage().clickConfirmPwdEyeIcon();
			merchantProfilePage.confirmPasswordPage().changePasswordPage().clickSave();
			merchantProfilePage.confirmPasswordPage().changePasswordPage().successFailureComponent()
					.verifyPageHeading(data.get("changePwdSuccessHeading"));
			merchantProfilePage.confirmPasswordPage().changePasswordPage().successFailureComponent()
					.verifyPageDescription(data.get("changePwdSuccessDescription"));
			merchantProfilePage.confirmPasswordPage().changePasswordPage().successFailureComponent().clickLogout();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			
			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickChangePassword();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			merchantProfilePage.confirmPasswordPage().verifyPageHeading(data.get("confirmPasswordHeading"));
			merchantProfilePage.confirmPasswordPage().verifyPageDescription(data.get("confirmPasswordDescription"));
			merchantProfilePage.confirmPasswordPage().fillCurrentPassword(data.get("currentPassword"));
			merchantProfilePage.confirmPasswordPage().clickEyeIcon();
			merchantProfilePage.confirmPasswordPage().clickNext();
			if (data.get("validateCurrentPassword").equalsIgnoreCase("yes")) {
				merchantProfilePage.confirmPasswordPage().changePasswordPage()
						.verifyPageHeading(data.get("changePwdHeading"));
				merchantProfilePage.confirmPasswordPage().changePasswordPage()
						.verifyPageDescription(data.get("changePwdDescription"));
				if (data.get("validateConfirmPassword").equalsIgnoreCase("yes")) {
					merchantProfilePage.confirmPasswordPage().changePasswordPage()
							.fillNewPassword(data.get("newPassword"));
					merchantProfilePage.confirmPasswordPage().changePasswordPage()
							.fillConfirmPassword(data.get("confirmPassword"));
				}
				if (data.get("confirmPassword").equalsIgnoreCase("")) {
					merchantProfilePage.confirmPasswordPage().changePasswordPage()
							.fillNewPassword(data.get("newPassword"));
					merchantProfilePage.confirmPasswordPage().changePasswordPage()
							.fillConfirmPassword(data.get("confirmPassword"));
					merchantProfilePage.confirmPasswordPage().changePasswordPage().clickNewPassword();
				}

			}
			Thread.sleep(1000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithNavigation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			
			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickChangePassword();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			merchantProfilePage.confirmPasswordPage().verifyPageHeading(data.get("confirmPasswordHeading"));
			merchantProfilePage.confirmPasswordPage().verifyPageDescription(data.get("confirmPasswordDescription"));
			merchantProfilePage.confirmPasswordPage().fillCurrentPassword(data.get("currentPassword"));
			merchantProfilePage.confirmPasswordPage().clickEyeIcon();
			merchantProfilePage.confirmPasswordPage().clickNext();
			merchantProfilePage.confirmPasswordPage().changePasswordPage()
					.verifyPageHeading(data.get("changePwdHeading"));
			merchantProfilePage.confirmPasswordPage().changePasswordPage()
					.verifyPageDescription(data.get("changePwdDescription"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetPinCodeWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickResetPINCode();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("pin"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetPinCodeWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickResetPINCode();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("pin"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			navigationComponent.clickBack();
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			navigationComponent.clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickResetPINCode();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			navigationComponent.clickClose();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
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
			merchantProfilePage.preferencesComponent().getLocalCurrency();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantProfilePage.clickProfile();
			merchantProfilePage.verifyAccountLimitsView();
			merchantProfilePage.clickAccountLimits();
			merchantProfilePage.accountLimitsComponent().verifyHeading(data.get("expHeading"));
			merchantProfilePage.accountLimitsComponent()
					.verifyLabelMonthlyProcessingVolume(data.get("monthlyProcessingLabel"));
			merchantProfilePage.accountLimitsComponent().verifyHighTicketLabel(data.get("highTicketLabel"));
			merchantProfilePage.accountLimitsComponent().getMonthlyProcessingVolumeLimit();
			merchantProfilePage.accountLimitsComponent().getHighTicketLimit();
			merchantProfilePage.accountLimitsComponent().verifyBuyTokenHeading(data.get("buyTokenHeading"));
			merchantProfilePage.accountLimitsComponent().getBuyTokenBankAccount();
			merchantProfilePage.accountLimitsComponent().getWithdrawBankAccount();
			merchantProfilePage.accountLimitsComponent().getInstantPayLimit();
			merchantProfilePage.accountLimitsComponent().getGiftCardLimit();
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
			merchantProfilePage.clickProfile();
			merchantProfilePage.verifyAgreementsView();
			merchantProfilePage.clickAgreements();
			merchantProfilePage.agreementComponent().verifyHeading(data.get("agreeHeading"));
			merchantProfilePage.agreementComponent().verifyActiveAgreementsView();
			merchantProfilePage.agreementComponent().verifyPastAgreementsView();
			merchantProfilePage.agreementComponent().verifyActiveAgreementsHeading(data.get("ActiveHeading"));
			merchantProfilePage.agreementComponent().verifyPastAgreementsHeading(data.get("pastHeading"));
			merchantProfilePage.verifyProfilePageView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAgreements Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAgreementsWithNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantProfilePage.clickProfile();
			merchantProfilePage.verifyAgreementsView();
			merchantProfilePage.clickAgreements();
			merchantProfilePage.agreementComponent().verifyHeading(data.get("agreeHeading"));
			merchantProfilePage.agreementComponent().verifyActiveAgreementsView();
			merchantProfilePage.agreementComponent().verifyPastAgreementsView();
			merchantProfilePage.agreementComponent().verifyActiveAgreementsHeading(data.get("ActiveHeading"));
			merchantProfilePage.agreementComponent().verifyPastAgreementsHeading(data.get("pastHeading"));
			merchantProfilePage.agreementComponent().navigationComponent().clickBack();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAgreements Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFees(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantProfilePage.clickProfile();
			merchantProfilePage.feesComponent().verifyHeading(data.get("label"));
			merchantProfilePage.feesComponent().verifyHeadingTransactionsLabel("transactionHeading");
			merchantProfilePage.feesComponent().verifySaleOrderLabel("saleOrderlable");
			merchantProfilePage.feesComponent().verifyRefundLabel(data.get("refundLabel"));
			merchantProfilePage.feesComponent().verifyHeadingTokenAccount(data.get("TokenAccountHeading"));
			merchantProfilePage.feesComponent().verifyHeadingWithdraw(data.get("withdrawHeading"));
			merchantProfilePage.feesComponent().getWithdrawsExternalBankAccount();
			merchantProfilePage.feesComponent().getBuyTokenExternalBankAccount();
			merchantProfilePage.feesComponent().verifyWithdrawInstantPayLabel(data.get("instantPayLabel"));
			merchantProfilePage.feesComponent().verifyWithdrawGiftCardLabel(data.get("giftCardLabel"));
			merchantProfilePage.feesComponent()
					.verifyWithdrawFailedBankAccountLabel(data.get("failedBankAccountLabel"));
			merchantProfilePage.feesComponent().getWithdrawsSignetAccount();
			merchantProfilePage.feesComponent().getBuyTokenSignetAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFees Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFeesWithNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantProfilePage.clickProfile();
			merchantProfilePage.feesComponent().verifyHeading(data.get("label"));
			merchantProfilePage.feesComponent().verifyHeadingTransactionsLabel("transactionHeading");
			merchantProfilePage.feesComponent().verifySaleOrderLabel("saleOrderlable");
			merchantProfilePage.feesComponent().verifyRefundLabel(data.get("refundLabel"));
			merchantProfilePage.feesComponent().verifyHeadingTokenAccount(data.get("TokenAccountHeading"));
			merchantProfilePage.feesComponent().verifyHeadingWithdraw(data.get("withdrawHeading"));
			merchantProfilePage.feesComponent().getWithdrawsExternalBankAccount();
			merchantProfilePage.feesComponent().getBuyTokenExternalBankAccount();
			merchantProfilePage.feesComponent().verifyWithdrawInstantPayLabel(data.get("instantPayLabel"));
			merchantProfilePage.feesComponent().verifyWithdrawGiftCardLabel(data.get("giftCardLabel"));
			merchantProfilePage.feesComponent()
					.verifyWithdrawFailedBankAccountLabel(data.get("failedBankAccountLabel"));
			merchantProfilePage.feesComponent().getWithdrawsSignetAccount();
			merchantProfilePage.feesComponent().getBuyTokenSignetAccount();
			merchantProfilePage.feesComponent().navigationComponent().clickBack();
			merchantProfilePage.clickProfile();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFeesWithNavigationOptions Failed due to this Exception" + e);
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