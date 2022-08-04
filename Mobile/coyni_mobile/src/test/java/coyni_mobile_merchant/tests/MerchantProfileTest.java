package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class MerchantProfileTest {

	MerchantProfilePage merchantProfilePage;
	BusinessTokenAccountPage businessTokenAccountPage;
	EnterYourPINComponent enterYourPINComponent;
	NavigationComponent navigationComponent;

	@BeforeTest
	public void init() {
		merchantProfilePage = new MerchantProfilePage();
		businessTokenAccountPage = new BusinessTokenAccountPage();
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
	public void testDefaultAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
////			businessTokenAccountPage.clickProfile();
////			merchantProfilePage.getAccountDetails();
////			merchantProfilePage.getAccountId();
////			merchantProfilePage.clickUserDetails();
////			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
////			merchantProfilePage.userDetailsPage().getUserDetails();
////			merchantProfilePage.userDetailsPage().verifyDefaultAccount(data.get("defaultAccount"));
////			merchantProfilePage.userDetailsPage().clickDefaultAccount();
////			if (merchantProfilePage.userDetailsPage().getDefaultAccountName() == 0) {
////				
////			}else {
////			merchantProfilePage.userDetailsPage().clickSelectAccount2();
////			merchantProfilePage.userDetailsPage().clickChildAccount2();
////			merchantProfilePage.userDetailsPage().clickSave();
//			
//			}
			
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDefaultAccount failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeEmailWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("verifyCurrentEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			Thread.sleep(2000);
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("verifyNewEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangeEmailWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeEmailWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickTab();
			if (data.get("validateEmail").equalsIgnoreCase("yes")) {
				merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
				merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
						.verifyErrorMsgHeading(data.get("errMessageHeading"));
				merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
						.verifyErrorMsg(data.get("existingErrMessage"));
				merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickOk();
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangeEmailWithInValidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeEmailWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("verifyCurrentEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			Thread.sleep(2000);
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("verifyNewEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().clickCloseIcon();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("verifyCurrentEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().clickCloseIcon();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickBack();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().verifyEmail();
			merchantProfilePage.userDetailsPage().getCurrentEmail();
			merchantProfilePage.userDetailsPage().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangeEmailWithNavigationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePhoneNumberWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
					.verifyPhoneHeading(data.get("verifyCurrentPhoneNumberVerificationHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			Thread.sleep(3000);
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("verifyNewPhoneNumberVerificationHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangePhoneNumberWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePhoneNumberWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
					.verifyErrorMsgHeading(data.get("errMessageHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsg(data.get("errMessage"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent().clickOk();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangePhoneNumberWithInValidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePhoneNumberWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
					.verifyPhoneHeading(data.get("verifyCurrentPhoneNumberVerificationHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			Thread.sleep(2000);
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("verifyNewPhoneNumberVerificationHeading"));
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
					.verifyPhoneHeading(data.get("verifyCurrentPhoneNumberVerificationHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
			merchantProfilePage.userDetailsPage().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangePhoneNumberWithNavigationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeAddressWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().mailingAddressComponent()
					.selectState(data.get("state"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fillZipCode(data.get("zipCode"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().getDefaultCountry();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangeAddressWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeAddressWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage().mailingAddressComponent()
					.selectState(data.get("state"));
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
			ExtentTestManager.setFailMessageInReport("testChangeAddressWithInValidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeAddressWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
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
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentAddressDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickChange();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().enterYourPINComponent()
					.navigationComponent().clickClose();
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentAddressHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentAddressDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().clickBack();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

			
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangeAddressWithNavigationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			
			businessTokenAccountPage.clickProfile();
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
			ExtentTestManager.setFailMessageInReport("testChangePasswordWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			
			businessTokenAccountPage.clickProfile();
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
			if (data.get("validateCurrentPassword").equalsIgnoreCase("no")) {
				merchantProfilePage.confirmPasswordPage().errorMessagePopupComponent().verifyPopUpMsg(data.get("errPopUpMsg"));
				merchantProfilePage.confirmPasswordPage().errorMessagePopupComponent().clickOk();	
			}
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

			Thread.sleep(1000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordWithInvalidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithNavigation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			
			businessTokenAccountPage.clickProfile();
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
			merchantProfilePage.navigationComponent().clickClose();
			merchantProfilePage.confirmPasswordPage().verifyPageHeading(data.get("confirmPasswordHeading"));
			merchantProfilePage.confirmPasswordPage().verifyPageDescription(data.get("confirmPasswordDescription"));
			merchantProfilePage.navigationComponent().clickClose();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordWithNavigation failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetPinCodeWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickResetPINCode();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testResetPinCodeWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetPinCodeWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickResetPINCode();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			merchantProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			navigationComponent.clickBack();
			Thread.sleep(2000);
			merchantProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			navigationComponent.clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickResetPINCode();
			Thread.sleep(2000);
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			navigationComponent.clickClose();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testResetPinCodeWithNavigationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().getDescription();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyEmail();
			merchantProfilePage.dbaInformationPage().getCurrentEmail();
			merchantProfilePage.dbaInformationPage().verifyPhoneNumber();
			merchantProfilePage.dbaInformationPage().getCurrentPhoneNumber();
			merchantProfilePage.dbaInformationPage().verifyAddress();
			merchantProfilePage.dbaInformationPage().getCurrentAddress();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInformationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAEditEmailWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().getDescription();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyEmail();
			merchantProfilePage.dbaInformationPage().getCurrentEmail();
			merchantProfilePage.dbaInformationPage().clickEmail();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAEditEmailWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAEditEmailWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().getDescription();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyEmail();
			merchantProfilePage.dbaInformationPage().getCurrentEmail();
			merchantProfilePage.dbaInformationPage().clickEmail();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsgHeading(data.get("errMessageHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsg(data.get("errMessage"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent().clickOk();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAEditEmailWithInValidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAEditEmailWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().getDescription();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyEmail();
			merchantProfilePage.dbaInformationPage().getCurrentEmail();
			merchantProfilePage.dbaInformationPage().clickEmail();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent().clickBack();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickBack();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAEditEmailWithNavigationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAEditPhoneNumberWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().getDescription();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyPhoneNumber();
			merchantProfilePage.dbaInformationPage().getCurrentPhoneNumber();
			merchantProfilePage.dbaInformationPage().clickPhoneNumber();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.fillPhoneNumber(data.get("newPhoneNumber"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent().clickSave();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testDBAEditPhoneNumberWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAEditPhoneNumberWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().getDescription();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyPhoneNumber();
			merchantProfilePage.dbaInformationPage().getCurrentPhoneNumber();
			merchantProfilePage.dbaInformationPage().clickPhoneNumber();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.fillPhoneNumber(data.get("newPhoneNumber"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsgHeading(data.get("errMessageHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsg(data.get("errMessage"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent().clickOk();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testDBAEditPhoneNumberWithInValidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAEditPhoneNumberWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().getDescription();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyPhoneNumber();
			merchantProfilePage.dbaInformationPage().getCurrentPhoneNumber();
			merchantProfilePage.dbaInformationPage().clickPhoneNumber();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testDBAEditPhoneNumberWithNavigationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testComapanyInfoView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyEmail();
			merchantProfilePage.companyInformationPage().getCurrentEmail();
			merchantProfilePage.companyInformationPage().verifyPhoneNumber();
			merchantProfilePage.companyInformationPage().getCurrentPhoneNumber();
			merchantProfilePage.companyInformationPage().verifyAddress();
			merchantProfilePage.companyInformationPage().getCurrentAddress();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testComapanyInfoView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testComapanyInfoEditEmailWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyEmail();
			merchantProfilePage.companyInformationPage().getCurrentEmail();
			merchantProfilePage.companyInformationPage().clickEmail();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent().clickSave();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testComapanyInfoEditEmailWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testComapanyInfoEditEmailWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyEmail();
			merchantProfilePage.companyInformationPage().getCurrentEmail();
			merchantProfilePage.companyInformationPage().clickEmail();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.fillEmail(data.get("newEmail"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsgHeading(data.get("errMessageHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsg(data.get("errMessage"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent().clickOk();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testComapanyInfoEditEmailWithInValidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testComapanyInfoEditEmailWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyEmail();
			merchantProfilePage.companyInformationPage().getCurrentEmail();
			merchantProfilePage.companyInformationPage().clickEmail();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentEmailDescription"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newEmailHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent().clickBack();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickBack();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testComapanyInfoEditEmailWithNavigationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testComapanyInfoEditPhoneNumberWithValidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyPhoneNumber();
			merchantProfilePage.companyInformationPage().getCurrentPhoneNumber();
			merchantProfilePage.companyInformationPage().clickPhoneNumber();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.fillPhoneNumber(data.get("newPhoneNumber"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testComapanyInfoEditPhoneNumberWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testComapanyInfoEditPhoneNumberWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyPhoneNumber();
			merchantProfilePage.companyInformationPage().getCurrentPhoneNumber();
			merchantProfilePage.companyInformationPage().clickPhoneNumber();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.fillPhoneNumber(data.get("newPhoneNumber"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent().clickSave();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsgHeading(data.get("errMessageHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyErrorMsg(data.get("errMessage"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent().clickOk();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testComapanyInfoEditPhoneNumberWithInValidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testComapanyInfoEditPhoneNumberWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyPhoneNumber();
			merchantProfilePage.companyInformationPage().getCurrentPhoneNumber();
			merchantProfilePage.companyInformationPage().clickPhoneNumber();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testComapanyInfoEditPhoneNumberWithNavigationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBenificialOwnersView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBeneficialOwners();
			merchantProfilePage.benificialOwnersPage().verifyPageHeading(data.get("benificialHeading"));
			merchantProfilePage.benificialOwnersPage().getOwnerName();
			merchantProfilePage.benificialOwnersPage().getOwnerShipPercentage();
			merchantProfilePage.benificialOwnersPage().clickOwner();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage()
					.verifyPageHeading(data.get("benificialHeading"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getOwnerName();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getOwnerType();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getOwnerShipPercentage();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getOwnerShip();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage()
					.verifyOwnerDetails(data.get("benificialDetails"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage()
					.verifyDOB(data.get("dateOfBirthHeading"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getDOBDetails();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage()
					.verifyMailingAddress(data.get("mailingAddressHeading"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getMailingAddressDetails();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().verifySSN(data.get("ssnHeading"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getSSNDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBenificialOwners Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBenificialOwnersNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBeneficialOwners();
			merchantProfilePage.benificialOwnersPage().verifyPageHeading(data.get("benificialHeading"));
			merchantProfilePage.benificialOwnersPage().getOwnerName();
			merchantProfilePage.benificialOwnersPage().getOwnerShipPercentage();
			merchantProfilePage.benificialOwnersPage().clickOwner();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage()
					.verifyPageHeading(data.get("benificialHeading"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getOwnerName();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getOwnerType();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getOwnerShipPercentage();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getOwnerShip();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage()
					.verifyOwnerDetails(data.get("benificialDetails"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage()
					.verifyDOB(data.get("dateOfBirthHeading"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getDOBDetails();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage()
					.verifyMailingAddress(data.get("mailingAddressHeading"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getMailingAddressDetails();
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().verifySSN(data.get("ssnHeading"));
			merchantProfilePage.benificialOwnersPage().benificialOwnersDetailsPage().getSSNDetails();
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.benificialOwnersPage().verifyPageHeading(data.get("benificialHeading"));
			merchantProfilePage.benificialOwnersPage().getOwnerName();
			merchantProfilePage.benificialOwnersPage().getOwnerShipPercentage();
			merchantProfilePage.navigationComponent().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBenificialOwnersNavigationView Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickAddTeamMember();
			merchantProfilePage.teamPage().addNewTeamMemberPage().verifyPageHeading(data.get("newTeamMemberHeading"));
			merchantProfilePage.teamPage().addNewTeamMemberPage()
					.verifyDescription(data.get("newTeamMemberDescription"));
			merchantProfilePage.teamPage().addNewTeamMemberPage().getAdministratorDesc();
			merchantProfilePage.teamPage().addNewTeamMemberPage().fillFirstName(data.get("firstName"));
			merchantProfilePage.teamPage().addNewTeamMemberPage().fillLastName(data.get("lastName"));
			merchantProfilePage.teamPage().addNewTeamMemberPage().fillEmail(data.get("teamEmail"));
			merchantProfilePage.teamPage().addNewTeamMemberPage().fillPhoneNumber(data.get("phoneNumber"));
			merchantProfilePage.teamPage().addNewTeamMemberPage().getNoteMsg();
			merchantProfilePage.teamPage().addNewTeamMemberPage().clickSend();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddTeamMember Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddTeamMemberWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickAddTeamMember();
			merchantProfilePage.teamPage().addNewTeamMemberPage().verifyPageHeading(data.get("newTeamMemberHeading"));
			merchantProfilePage.teamPage().addNewTeamMemberPage()
					.verifyDescription(data.get("newTeamMemberDescription"));
			merchantProfilePage.teamPage().addNewTeamMemberPage().getAdministratorDesc();
			if (!data.get("errMessage").isEmpty()) {
				if (data.get("validatePhoneNumber").equalsIgnoreCase("yes")) {
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillFirstName(data.get("firstName"));
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillLastName(data.get("lastName"));
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillEmail(data.get("teamEmail"));
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillPhoneNumber(data.get("phoneNumber"));
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillFirstName(data.get("firstName"));
				}
				if (data.get("validatePhoneNumber").equalsIgnoreCase("no")) {
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillFirstName(data.get("firstName"));
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillLastName(data.get("lastName"));
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillEmail(data.get("teamEmail"));
					merchantProfilePage.teamPage().addNewTeamMemberPage().fillPhoneNumber(data.get("phoneNumber"));
				}
			}
			if (!data.get("popUpMsg").isEmpty()) {
				merchantProfilePage.teamPage().addNewTeamMemberPage().fillFirstName(data.get("firstName"));
				merchantProfilePage.teamPage().addNewTeamMemberPage().fillLastName(data.get("lastName"));
				merchantProfilePage.teamPage().addNewTeamMemberPage().fillEmail(data.get("teamEmail"));
				merchantProfilePage.teamPage().addNewTeamMemberPage().fillPhoneNumber(data.get("phoneNumber"));
				merchantProfilePage.teamPage().addNewTeamMemberPage().clickSend();
				merchantProfilePage.teamPage().addNewTeamMemberPage().verifyPopUpMsg(data.get("popUpMsg"));
				merchantProfilePage.teamPage().addNewTeamMemberPage().clickOk();

			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddTeamMember Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddTeamMemberNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickAddTeamMember();
			merchantProfilePage.teamPage().addNewTeamMemberPage().verifyPageHeading(data.get("newTeamMemberHeading"));
			merchantProfilePage.teamPage().addNewTeamMemberPage()
					.verifyDescription(data.get("newTeamMemberDescription"));
			merchantProfilePage.teamPage().addNewTeamMemberPage().getAdministratorDesc();
			merchantProfilePage.teamPage().addNewTeamMemberPage().clickBack();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddTeamMember Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickPendingStatusTeamMember();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyPageHeading(data.get("teamMemberDetailsHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyDescription(data.get("teamMemberDetailsDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickEdit();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.verifyPageHeading(data.get("editTeamMemberHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.verifyDescription(data.get("editTeamMemberDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().getAdministratorDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.fillFirstName(data.get("firstName"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.fillLastName(data.get("lastName"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.fillEmail(data.get("teamEmail"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().getNoteMsg();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().clickSend();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditTeamMember Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditTeamMemberWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickPendingStatusTeamMember();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyPageHeading(data.get("teamMemberDetailsHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyDescription(data.get("teamMemberDetailsDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickEdit();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.verifyPageHeading(data.get("editTeamMemberHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.verifyDescription(data.get("editTeamMemberDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().getAdministratorDesc();
			if (!data.get("errMessage").isEmpty()) {
				if (data.get("validatePhoneNumber").equalsIgnoreCase("yes")) {
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillFirstName(data.get("firstName"));
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillLastName(data.get("lastName"));
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillEmail(data.get("teamEmail"));
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillPhoneNumber(data.get("phoneNumber"));
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillFirstName(data.get("firstName"));
				}
				if (data.get("validatePhoneNumber").equalsIgnoreCase("no")) {
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillFirstName(data.get("firstName"));
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillLastName(data.get("lastName"));
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillEmail(data.get("teamEmail"));
					merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
							.fillPhoneNumber(data.get("phoneNumber"));
				}
			}

			if (!data.get("popUpMsg").isEmpty()) {
				merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
						.fillFirstName(data.get("firstName"));
				merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
						.fillLastName(data.get("lastName"));
				merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
						.fillEmail(data.get("teamEmail"));
				merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
						.fillPhoneNumber(data.get("phoneNumber"));
				merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().clickSend();
				merchantProfilePage.teamPage().addNewTeamMemberPage().verifyPopUpMsg(data.get("popUpMsg"));
				merchantProfilePage.teamPage().addNewTeamMemberPage().clickOk();

			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditTeamMemberWithInvalidData Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditTeamMemberNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickPendingStatusTeamMember();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyPageHeading(data.get("teamMemberDetailsHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyDescription(data.get("teamMemberDetailsDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickEdit();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.verifyPageHeading(data.get("editTeamMemberHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.verifyDescription(data.get("editTeamMemberDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().getAdministratorDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().clickBack();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyPageHeading(data.get("teamMemberDetailsHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyDescription(data.get("teamMemberDetailsDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickBack();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditTeamMemberNavigationView Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCancelTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickPendingStatusTeamMember();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyPageHeading(data.get("teamMemberDetailsHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyDescription(data.get("teamMemberDetailsDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickCancel();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCancelTeamMember Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResendInvitationTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickResendInvitationStatusTeamMember();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyPageHeading(data.get("teamMemberDetailsHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyDescription(data.get("teamMemberDetailsDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickResendInvitation();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.verifyPageHeading(data.get("editTeamMemberHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.verifyDescription(data.get("editTeamMemberDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().getAdministratorDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.fillFirstName(data.get("firstName"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.fillLastName(data.get("lastName"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.fillEmail(data.get("teamEmail"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().getNoteMsg();
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().clickSend();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testResendInvitationTeamMember Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRemoveTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			merchantProfilePage.teamPage().clickResendInvitationStatusTeamMember();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyPageHeading(data.get("teamMemberDetailsHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyDescription(data.get("teamMemberDetailsDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickbtnRemoveMember();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyRemoveMemberPopupHeading(data.get("popUpHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().verifyRemoveMemberPopupDescription(data.get("popUpDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickNo();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyPageHeading(data.get("teamMemberDetailsHeading"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyDescription(data.get("teamMemberDetailsDescription"));
			merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickbtnRemoveMember();
			
			merchantProfilePage.teamPage().teamMemberDetailsPage().clickYes();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRemoveTeamMember Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickPreferences();
			merchantProfilePage.preferencesComponent().verifyPreferencesHeading(data.get("heading"));
			merchantProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));
			merchantProfilePage.preferencesComponent().getTimeZone();
			merchantProfilePage.preferencesComponent().getDecscription();
			merchantProfilePage.preferencesComponent().getLocalCurrency();
			navigationComponent.clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickAccountLimits();
			merchantProfilePage.accountLimitsComponent().verifyHeading(data.get("accLimitsHeading"));
			merchantProfilePage.accountLimitsComponent().verifyMerchantProcessingHeading(data.get("processingHeading"));
			merchantProfilePage.accountLimitsComponent().getProcessingVolume();
			merchantProfilePage.accountLimitsComponent().getTicketLimit();
			merchantProfilePage.accountLimitsComponent().verifyBuyTokensHeading(data.get("buyTokensHeading"));
			merchantProfilePage.accountLimitsComponent().getBuyBankAcc();
			merchantProfilePage.accountLimitsComponent().getBuySignetAcc();
			merchantProfilePage.accountLimitsComponent().verifyWithdrawHeading(data.get("withdrawHeading"));
			merchantProfilePage.accountLimitsComponent().getWithdrawBankAcc();
			merchantProfilePage.accountLimitsComponent().getWithdrawInstantPay();
			merchantProfilePage.accountLimitsComponent().getWithdrawGiftcard();
//			merchantProfilePage.accountLimitsComponent().getWithdrawSignetAcc();
			merchantProfilePage.accountLimitsComponent().navigationComponent().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimits Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAgreementsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickAgreements();
			merchantProfilePage.agreementComponent().verifyHeading(data.get("agreeHeading"));
			merchantProfilePage.agreementComponent().verifyPrivacyPolicyView();
			merchantProfilePage.agreementComponent().clickClose();
			merchantProfilePage.agreementComponent().verifyTermsOfServiceView();
			merchantProfilePage.agreementComponent().clickClose();
			merchantProfilePage.agreementComponent().verifyMerchantAgreementView();
			merchantProfilePage.agreementComponent().clickClose();
			merchantProfilePage.agreementComponent().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAgreements Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFeesView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickFees();
			merchantProfilePage.feesComponent().verifyHeading(data.get("heading"));
			merchantProfilePage.feesComponent().verifyHeadingTransactionsLabel(data.get("transactionHeading"));
			merchantProfilePage.feesComponent().getSaleOrder();
			merchantProfilePage.feesComponent().getRefund();
			merchantProfilePage.feesComponent().verifyHeadingTokenAccount(data.get("tokenAccountHeading"));
			merchantProfilePage.feesComponent().verifyHeadingWithdraw(data.get("withdrawHeading"));
			merchantProfilePage.feesComponent().getWithdrawsExternalBankAccount();
			merchantProfilePage.feesComponent().getWithdrawInstantPayLabel();
			merchantProfilePage.feesComponent().getWithdrawsSignetAccount();
			merchantProfilePage.feesComponent().getWithdrawGiftCardLabel();
			merchantProfilePage.feesComponent().getWithdrawFailedBankAccountLabel();
			merchantProfilePage.feesComponent().verifyHeadingBuyToken(data.get("buyTokensHeading"));
			merchantProfilePage.feesComponent().getBuyTokenExternalBankAccount();
			merchantProfilePage.feesComponent().getBuyTokenSignetAccount();
			merchantProfilePage.feesComponent().verifyOtherFees(data.get("otherFeesHeading"));
			merchantProfilePage.feesComponent().getMonthlyFee();
			merchantProfilePage.feesComponent().clickBack();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFeesWithNavigationOptions Failed due to this Exception" + e);
		}
	}

	@Test
	public void testLogOut() {
		try {
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.verifyLogOut();
			merchantProfilePage.clickLogOut();
			merchantProfilePage.landingPage().verifyLandingPage();
			merchantProfilePage.landingPage().verifyLoginbtnView();
			// merchantProfilePage.signUpPage().verifyGetStarted();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLogOut failed due to exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			businessTokenAccountPage.clickProfile();
			Thread.sleep(1000);
			merchantProfilePage.clickPaymentMethods();
			merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
			Thread.sleep(1000);
			if(merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
			merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifyHeading(data.get("addPaymentHeading"));
			Thread.sleep(1000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			Thread.sleep(2000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillNameOnCard(data.get("nameOnCard"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardNumber(data.get("cardNumber"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
			Thread.sleep(2000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addressLine1"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addressLine2"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			Thread.sleep(5000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickAddCard();
			Thread.sleep(8000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.allDonePage().verifyAllDone(data.get("doneHeading"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.allDonePage().clickDone();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testEditDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickPaymentMethods();
			Thread.sleep(2000);
			merchantProfilePage.paymentMethodsPage().clickDebitCard(data.get("cardNumber"));
			Thread.sleep(2000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			// customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fillCVVorCVC(data.get("cvvOrCVC"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addressLine1"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addressLine2"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			Thread.sleep(2000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			Thread.sleep(2000);
			merchantProfilePage.clickPaymentMethods();
			merchantProfilePage.paymentMethodsPage().clickDebitCard(data.get("cardNumber"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickRemove();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickYes();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
		
	}
    @Test
	@Parameters({"strParams"})
	public void testDebitCardWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			Thread.sleep(2000);
			merchantProfilePage.clickPaymentMethods();
			Thread.sleep(3000);
			merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillNameOnCard(data.get("nameOnCard"));
			DriverFactory.getDriver().hideKeyboard();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardNumber(data.get("cardNumber"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			if (data.get("validateAddress").equalsIgnoreCase("yes")) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine2(data.get("addressLine2"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillCity(data.get("city"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().selectState(data.get("state"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().clickAddCard();
			}

			if (!data.get("errMsg").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("elementName"));
			}
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}
    @Test
    @Parameters({"strParams"})
    public void testAddSignetAccount(String strParams) {
    	try {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		businessTokenAccountPage.clickProfile();
		Thread.sleep(2000);
		merchantProfilePage.clickPaymentMethods();
		merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
		Thread.sleep(3000);
		merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
		merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickSignetAccount();
		merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fillNameOnCard(data.get("nameOnCard"));
		merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fillSignetWalletId(data.get("signetWalletID"));
		merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().fillAddressLine2(data.get("addressLine2"));
        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().fillCity(data.get("city"));
        Thread.sleep(2000);
        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().selectState(data.get("state"));
        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().fillZipCode(data.get("zipCode"));
        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().clickAddCard();
        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().allDonePage().verifyAllDone(data.get("doneHeading"));  
        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().allDonePage().clickDone();
		} catch (Exception e) {
		    ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
    }
    @Test
    @Parameters({"strParams"})
    public void testDeleteSignetAccount(String strParams) {
    	try {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		businessTokenAccountPage.clickProfile();
	    merchantProfilePage.clickPaymentMethods();
	    merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
	    merchantProfilePage.paymentMethodsPage().clickSignetAccount(data.get("cardNumber"));
	    merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().clickYes();
		
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
    }
    @Test
   	@Parameters({"strParams"})
   	public void testSignetAccountWithInvalidData(String strParams) {
   		try {
   			Map<String, String> data = Runner.getKeywordParameters(strParams);
   			businessTokenAccountPage.clickProfile();
   			Thread.sleep(2000);
   			merchantProfilePage.clickPaymentMethods();
   			merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
   			Thread.sleep(3000);
   			merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
   			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickSignetAccount();
   			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fillNameOnCard(data.get("nameOnCard"));
   			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().scrollUpToNameOnCard();
   	        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fillSignetWalletId(data.get("signetWalletID"));
   			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
   	        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().fillAddressLine2(data.get("addressLine2"));
   	        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().fillCity(data.get("city"));
   	        Thread.sleep(2000);
   	        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().selectState(data.get("state"));
 	        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().fillZipCode(data.get("zipCode"));
// 	        merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().clickAddCard();

            if (!data.get("errMsg").isEmpty()) {
   				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("elementName"));
   			}
   		} catch (Exception e) {

   			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
   		}
   	}
    @Test
    @Parameters({"strParams"})
    public void testBankAccount(String strParams) {
    	try {
    		Map<String, String> data = Runner.getKeywordParameters(strParams);
    		Thread.sleep(1000);
			businessTokenAccountPage.clickProfile();
			Thread.sleep(1000);
			merchantProfilePage.clickPaymentMethods();
			merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
			Thread.sleep(1000);
			merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
			Thread.sleep(1000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickExternalBankAcount();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().verifyHeading(data.get("addExternalBankHeading"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().clickBankNext();
			Thread.sleep(2000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().fillBankName(data.get("bankName"));
			Thread.sleep(1000);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().ScrollToBank();
		    merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().selectBank();
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().clickBank();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().fillUserName(data.get("userName"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().fillPassword(data.get("bankPassword"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().clickNext();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().clickCheckBox();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().clickNext();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().allDonePage().verifyAllDone(data.get("doneHeading"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().allDonePage().clickDone();
    		
		} catch (Exception e) {
			 ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
    }
    @Test
    @Parameters({"strParams"})
    public void testDeleteBank(String strPrams) {
    	try { 
    		Map<String, String> data = Runner.getKeywordParameters(strPrams);
    		businessTokenAccountPage.clickProfile();
		    merchantProfilePage.clickPaymentMethods();
		    merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
			merchantProfilePage.paymentMethodsPage().clickBankAccount();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent().clickYes();
		} catch (Exception e) {
			 ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
    }

	
}