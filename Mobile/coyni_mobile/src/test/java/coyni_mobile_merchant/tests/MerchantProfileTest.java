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

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickUserDetails();
			merchantProfilePage.userDetailsPage().verifyPageHeading(data.get("userDetailsHeading"));
			merchantProfilePage.userDetailsPage().getUserDetails();
			merchantProfilePage.userDetailsPage().changeDefaultAccount(data.get("defaultAccount"),
					data.get("defaultAccToastMsg"));

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
			// merchantProfilePage.getAccountDetails();
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
					.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			Thread.sleep(2000);
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("verifyNewEmailHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getEmailText();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.successFailureComponent().verifyPageHeading(data.get("changeEmailSuccessHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.successFailureComponent().verifyPageDescription(data.get("changeEmailSuccessDescription"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.successFailureComponent().clickLogout();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.successFailureComponent().landingPage().verifyLandingPage();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.successFailureComponent().landingPage().verifyLoginbtnView();
			LoginTest loginTest = new LoginTest();
			loginTest.testLoginFor(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangeEmailWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeEmailFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
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
			String[] newEmail = data.get("newEmail").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fieldValidationsComponent().validateNewEmailField(newEmail[0], newEmail[1], newEmail[2]);

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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
					.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
					.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			Thread.sleep(3000);
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("verifyNewPhoneNumberVerificationHeading"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().getPhoneDescription();
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyToastMsg(data.get("toastMsg"));
			Thread.sleep(1000);
			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));

			merchantProfilePage.userDetailsPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			String actPhoneNumber = merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			actPhoneNumber = actPhoneNumber.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
			if (data.get("newPhoneNumber").equalsIgnoreCase(actPhoneNumber)) {
				merchantProfilePage.userDetailsPage().currentDetailsComponent().getCurrentDetails();
			} else {
				ExtentTestManager.setFailMessageInReport("Phonumer is not updated");
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangePhoneNumberWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePhoneNumberFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
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
			String[] newPhoneNumber = data.get("newPhoneNumber").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fieldValidationsComponent()
					.validatePhoneNumberField(newPhoneNumber[0], newPhoneNumber[1], newPhoneNumber[2]);
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangePhoneNumberFieldValidations failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePhoneNumberWithInValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
					.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.verifyToastMsg(data.get("toastMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangeAddressWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangeAddressFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
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

			String[] address = data.get("address").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fieldValidationsComponent().validateAddressLine1Field(address[0], address[1], address[2]);
			String[] city = data.get("city").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fieldValidationsComponent().validateCityField(city[0], city[1], city[2]);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			String[] zipCode = data.get("zipCode").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editAddressPage()
					.fieldValidationsComponent().validateZipCodeField(zipCode[0], zipCode[1], zipCode[2]);
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
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
			merchantProfilePage.confirmPasswordPage().changePasswordPage().successFailureComponent().landingPage()
					.verifyLandingPage();
			merchantProfilePage.confirmPasswordPage().changePasswordPage().successFailureComponent().landingPage()
					.verifyLoginbtnView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordWithValidDetails failed due to Exception " + e);
		}
	}

//	String[] newPassword = data.get("newPassword").split(",");
//	loginPage.forgotPasswordPage().fieldValidationsComponent().validateNewPasswordField(newPassword[0],
//			newPassword[1], newPassword[2]);
//	String[] confirmPassword = data.get("newPassword").split(",");
//	loginPage.forgotPasswordPage().fieldValidationsComponent().validateConfirmPasswordField(confirmPassword[0],
//			confirmPassword[1], confirmPassword[2]);

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickChangePassword();
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			merchantProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			merchantProfilePage.confirmPasswordPage().verifyPageHeading(data.get("confirmPasswordHeading"));
			merchantProfilePage.confirmPasswordPage().verifyPageDescription(data.get("confirmPasswordDescription"));
			String[] currentPassword = data.get("currentPassword").split(",");
			merchantProfilePage.confirmPasswordPage().fieldValidationsComponent().validatePasswordField(
					currentPassword[0], currentPassword[1], currentPassword[2], currentPassword[3]);
			merchantProfilePage.confirmPasswordPage().clickNext();
			merchantProfilePage.confirmPasswordPage().changePasswordPage()
					.verifyPageHeading(data.get("changePwdHeading"));
			merchantProfilePage.confirmPasswordPage().changePasswordPage()
					.verifyPageDescription(data.get("changePwdDescription"));
			String[] newPassword = data.get("newPassword").split(",");
			merchantProfilePage.confirmPasswordPage().changePasswordPage().fieldValidationsComponent()
					.validateNewPasswordField(newPassword[0], newPassword[1], newPassword[2]);
			String[] confirmPassword = data.get("confirmPassword").split(",");
			merchantProfilePage.confirmPasswordPage().changePasswordPage().fieldValidationsComponent()
					.validateConfirmPasswordField(confirmPassword[0], confirmPassword[1], confirmPassword[2]);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordFieldValidations failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
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
				merchantProfilePage.confirmPasswordPage().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
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
			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			merchantProfilePage.enterYourPINComponent().choosePinComponent().toastComponent()
					.verifyToastMsg(data.get("toastMsg"));

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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickResetPINCode();
			Thread.sleep(2000);
			merchantProfilePage.enterYourPINComponent().verifyHeading(data.get("enterPinHeading"));
			navigationComponent.clickClose();
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
	public void testUploadDBAProfile(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().getDescription();
			merchantProfilePage.dbaInformationPage().uploadDBAProfile(data.get("profileToastMsg"),
					data.get("dbaPageHeading"));

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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
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
					.verifyToastMsg(data.get("toastMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAEditEmailWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
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
			String[] newEmail = data.get("newEmail").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fieldValidationsComponent().validateNewEmailField(newEmail[0], newEmail[1], newEmail[2]);
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent().clickBack();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickBack();
			merchantProfilePage.dbaInformationPage().clickPhoneNumber();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.dbaInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			String[] newPhoneNumber = data.get("newPhoneNumber").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fieldValidationsComponent()
					.validatePhoneNumberField(newPhoneNumber[0], newPhoneNumber[1], newPhoneNumber[2]);
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyEmail();
			merchantProfilePage.dbaInformationPage().getCurrentEmail();
			Thread.sleep(5000);
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyEmail();
			merchantProfilePage.dbaInformationPage().getCurrentEmail();
			Thread.sleep(5000);
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
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
					.verifyToastMsg(data.get("toastMsg"));

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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyPhoneNumber();
			merchantProfilePage.dbaInformationPage().getCurrentPhoneNumber();
			Thread.sleep(5000);
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickDBAInformation();
			merchantProfilePage.dbaInformationPage().verifyPageHeading(data.get("dbaPageHeading"));
			merchantProfilePage.dbaInformationPage().getCompanyName();
			merchantProfilePage.dbaInformationPage().verifyCustomerService(data.get("dbaPageDescription"));
			merchantProfilePage.dbaInformationPage().verifyPhoneNumber();
			merchantProfilePage.dbaInformationPage().getCurrentPhoneNumber();
			Thread.sleep(5000);
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.verifyInformation();
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyEmail();
			merchantProfilePage.companyInformationPage().getCurrentEmail();
			Thread.sleep(2000);
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
					.verifyToastMsg(data.get("toastMsg"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testComapanyInfoEditEmailWithValidDetails failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testComapanyInformationFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
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
			String[] newEmail = data.get("newEmail").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fieldValidationsComponent().validateNewEmailField(newEmail[0], newEmail[1], newEmail[2]);
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent().clickBack();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentEmailHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickBack();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().clickPhoneNumber();
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageHeading(data.get("currentPhoneNumberHeading"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent()
					.verifyPageDescription(data.get("currentPhoneNumberDescription"));
			merchantProfilePage.companyInformationPage().currentDetailsComponent().getCurrentDetails();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().clickChange();
			merchantProfilePage.companyInformationPage().currentDetailsComponent().editDetailsComponent()
					.verifyEmailHeading(data.get("newPhoneNumberHeading"));
			String[] newPhoneNumber = data.get("newPhoneNumber").split(",");
			merchantProfilePage.userDetailsPage().currentDetailsComponent().editDetailsComponent()
					.fieldValidationsComponent()
					.validatePhoneNumberField(newPhoneNumber[0], newPhoneNumber[1], newPhoneNumber[2]);

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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyEmail();
			merchantProfilePage.companyInformationPage().getCurrentEmail();
			Thread.sleep(2000);
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyEmail();
			merchantProfilePage.companyInformationPage().getCurrentEmail();
			Thread.sleep(2000);
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyPhoneNumber();
			merchantProfilePage.companyInformationPage().getCurrentPhoneNumber();
			Thread.sleep(2000);
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
					.verifyToastMsg(data.get("toastMsg"));

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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyPhoneNumber();
			merchantProfilePage.companyInformationPage().getCurrentPhoneNumber();
			Thread.sleep(2000);
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickCompanyInformation();
			merchantProfilePage.companyInformationPage().verifyPageHeading(data.get("companyInfoPageHeading"));
			merchantProfilePage.companyInformationPage().getCompanyName();
			merchantProfilePage.companyInformationPage().getDescription();
			merchantProfilePage.companyInformationPage().verifyCustomerService(data.get("companyInfoPageDescription"));
			merchantProfilePage.companyInformationPage().verifyPhoneNumber();
			merchantProfilePage.companyInformationPage().getCurrentPhoneNumber();
			Thread.sleep(2000);
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			merchantProfilePage.teamPage().addNewTeamMemberPage().toastComponent().verifyToastMsg(data.get("toastMsg"));
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			String team = merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			String firstName = team.split(" ")[0];
			String lastName = team.split(" ")[1];
			if (data.get("firstName").equalsIgnoreCase(firstName) && data.get("lastName").equalsIgnoreCase(lastName)) {
				ExtentTestManager.setInfoMessageInReport("Team Member is added");
				merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
				merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberDesc();
				merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberStatus();
			} else {
				ExtentTestManager.setFailMessageInReport("Team Member not Added");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddTeamMember Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTeamMemberFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickProfile();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickTeam();
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			merchantProfilePage.teamPage().verifyDescription(data.get("teamPageDescription"));
			String[] search = data.get("search").split(",");
			merchantProfilePage.teamPage().addNewTeamMemberPage().fieldValidationsComponent()
					.validateSearchField(search[0], search[1], search[2]);
			merchantProfilePage.teamPage().clickAddTeamMember();
			merchantProfilePage.teamPage().addNewTeamMemberPage().verifyPageHeading(data.get("newTeamMemberHeading"));
			merchantProfilePage.teamPage().addNewTeamMemberPage()
					.verifyDescription(data.get("newTeamMemberDescription"));
			merchantProfilePage.teamPage().addNewTeamMemberPage().getAdministratorDesc();
			String[] firstName = data.get("firstName").split(",");
			merchantProfilePage.teamPage().addNewTeamMemberPage().fieldValidationsComponent()
					.validateFirstNameField(firstName[0], firstName[1], firstName[2]);
			String[] lastName = data.get("lastName").split(",");
			merchantProfilePage.teamPage().addNewTeamMemberPage().fieldValidationsComponent()
					.validateLastNameField(lastName[0], lastName[1], lastName[2]);
			String[] teamEmail = data.get("teamEmail").split(",");
			merchantProfilePage.teamPage().addNewTeamMemberPage().fieldValidationsComponent()
					.validateEmailField(teamEmail[0], teamEmail[1], teamEmail[2]);
			String[] phoneNumber = data.get("phoneNumber").split(",");
			merchantProfilePage.teamPage().addNewTeamMemberPage().fieldValidationsComponent()
					.validatePhoneNumberField(phoneNumber[0], phoneNumber[1], phoneNumber[2]);
			
//			merchantProfilePage.teamPage().addNewTeamMemberPage().fillFirstName(data.get("firstName"));
//			merchantProfilePage.teamPage().addNewTeamMemberPage().fillLastName(data.get("lastName"));
//			merchantProfilePage.teamPage().addNewTeamMemberPage().fillEmail(data.get("teamEmail"));
//			merchantProfilePage.teamPage().addNewTeamMemberPage().fillPhoneNumber(data.get("phoneNumber"));
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			merchantProfilePage.teamPage().teamMemberDetailsPage().editTeamMemberPage().toastComponent()
					.verifyToastMsg(data.get("toastMsg"));
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));
			String phoneNumber = merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			phoneNumber = phoneNumber.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
			String email = merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
			String team = merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
			String firstName = team.split(" ")[0];
			String lastName = team.split(" ")[1];
			if (data.get("firstName").equalsIgnoreCase(firstName) && data.get("lastName").equalsIgnoreCase(lastName)
					&& data.get("teamEmail").equalsIgnoreCase(email)
					&& data.get("phoneNumber").equalsIgnoreCase(phoneNumber)) {
				ExtentTestManager.setInfoMessageInReport("Team Member details are updated");
				merchantProfilePage.teamPage().teamMemberDetailsPage().getTeamMemberName();
				merchantProfilePage.teamPage().teamMemberDetailsPage().getEmail();
				merchantProfilePage.teamPage().teamMemberDetailsPage().getPhoneNumber();
			} else {
				ExtentTestManager.setFailMessageInReport("Team Member Details Not Updated");
			}

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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			merchantProfilePage.teamPage().teamMemberDetailsPage().toastComponent()
					.verifyToastMsg(data.get("toastMsg"));
			merchantProfilePage.teamPage().verifyPageHeading(data.get("teamPageHeading"));

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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			merchantProfilePage.teamPage().teamMemberDetailsPage()
					.verifyRemoveMemberPopupDescription(data.get("popUpDescription"));
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickPreferences();
			merchantProfilePage.preferencesComponent().verifyPreferencesHeading(data.get("heading"));
			merchantProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));
			merchantProfilePage.preferencesComponent().toastComponent().verifyToastMsg(data.get("toastMsg"));
			merchantProfilePage.preferencesComponent().getTimeZone();
			merchantProfilePage.preferencesComponent().getDecscription();
			merchantProfilePage.preferencesComponent().getLocalCurrency();
			navigationComponent.clickBack();
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickBack();
			businessTokenAccountPage.dashBoardPage().getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testPreferences(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			businessTokenAccountPage.clickProfile();
//			// merchantProfilePage.getAccountDetails();
//			merchantProfilePage.getAccountId();
//			merchantProfilePage.clickPreferences();
//			merchantProfilePage.preferencesComponent().verifyPreferencesHeading(data.get("heading"));
//			String[] prefernceType = data.get("prefernceType").split(",");
//		for (int i = 0; i < 7; i++) {
//				merchantProfilePage.preferencesComponent().selectTimeZone(prefernceType["+ i +");
//				merchantProfilePage.preferencesComponent().getTimeZone();
//				merchantProfilePage.preferencesComponent().getDecscription();
//				merchantProfilePage.preferencesComponent().getLocalCurrency();
//		}
//			navigationComponent.clickBack();
//			merchantProfilePage.getAccountDetails();
//			merchantProfilePage.getAccountId();
//			merchantProfilePage.clickBack();
//			businessTokenAccountPage.dashBoardPage().getUserName();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.clickAccountLimits();
			merchantProfilePage.accountLimitsComponent().verifyHeading(data.get("accLimitsHeading"));
			merchantProfilePage.accountLimitsComponent().verifyMerchantProcessingHeading(data.get("processingHeading"));
			merchantProfilePage.accountLimitsComponent().getProcessingVolume();
			merchantProfilePage.accountLimitsComponent().getTicketLimit();
			merchantProfilePage.accountLimitsComponent().verifyBuyTokensHeading(data.get("buyTokensHeading"));
			merchantProfilePage.accountLimitsComponent().getBuyBankAcc();
			merchantProfilePage.accountLimitsComponent().verifyWithdrawHeading(data.get("withdrawHeading"));
			merchantProfilePage.accountLimitsComponent().getWithdrawBankAcc();
			merchantProfilePage.accountLimitsComponent().getWithdrawInstantPay();
			merchantProfilePage.accountLimitsComponent().getWithdrawGiftcard();
			merchantProfilePage.accountLimitsComponent().getWithdrawCogentAcc();
			merchantProfilePage.accountLimitsComponent().navigationComponent().clickBack();
			// merchantProfilePage.getAccountDetails();
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
//			 merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
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
			merchantProfilePage.feesComponent().getWithdrawsCogentAccount();
			merchantProfilePage.feesComponent().getWithdrawGiftCardLabel();
			merchantProfilePage.feesComponent().getWithdrawFailedBankAccountLabel();
			merchantProfilePage.feesComponent().verifyHeadingBuyToken(data.get("buyTokensHeading"));
			merchantProfilePage.feesComponent().getBuyTokenExternalBankAccount();
			merchantProfilePage.feesComponent().verifyOtherFees(data.get("otherFeesHeading"));
			merchantProfilePage.feesComponent().getMonthlyFee();
			merchantProfilePage.feesComponent().clickBack();
			// merchantProfilePage.getAccountDetails();
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
			// merchantProfilePage.getAccountDetails();
			merchantProfilePage.getAccountId();
			merchantProfilePage.verifyLogOut();
			merchantProfilePage.clickLogOut();
			merchantProfilePage.landingPage().verifyLandingPage();
			merchantProfilePage.landingPage().verifyLoginbtnView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLogOut failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			Thread.sleep(1000);
			merchantProfilePage.clickPaymentMethods();
			merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
			Thread.sleep(1000);
			AddDebitCar(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

//	public void AddDebitCard(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
//			if (merchantProfilePage.paymentMethodsPage().verifyPaymentMethodHeading() == 1) {
//				merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
//				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
//			}
//			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
//				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
//						.verifyHeading(data.get("addPaymentHeading"));
//				Thread.sleep(1000);
//				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
//			}
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//					.fillNameOnCard(data.get("nameOnCard"));
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//					.fillCardNumber(data.get("cardNumber"));
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//					.fillCardExp(data.get("cardExp"));
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
//			Thread.sleep(2000);
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.fillAddressLine1(data.get("addressLine1"));
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.fillAddressLine2(data.get("addressLine2"));
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.fillCity(data.get("city"));
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.selectState(data.get("state"));
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.fillZipCode(data.get("zipCode"));
//			Thread.sleep(5000);
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.clickAddCard();
//			Thread.sleep(8000);
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.allDonePage().verifyAllDone(data.get("doneHeading"));
//			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.allDonePage().clickDone();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//	}

	public void AddDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyHeading(data.get("addPaymentHeading"));
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifywithdrawAddInstantHeading(data.get("withdrawInstantHeading"));

//			if (merchantProfilePage.paymentMethodsPage().verifyPaymentMethodHeading() == 1) {
//				merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
//				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
//			}
//			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
//				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
//						.verifyHeading(data.get("addPaymentHeading"));
//			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyNumberOfDebitCards() > 0) {
				Thread.sleep(1000);
				int presentCard = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.getPresentDebitCards();
				int maxLimit = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.getMaxDebitCardsLimit();
				if (presentCard <= maxLimit) {
					merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
							.verifyDebitCards(data.get("presentDebitCardNumber"));
				}
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyErrorMessageDebitCard() == 0) {
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillNameOnCard(data.get("nameOnCard"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillCardNumber(data.get("cardNumber"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillCardExp(data.get("cardExp"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
				Thread.sleep(2000);
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
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickAddCard();
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().allDonePage().verifyAllDone(data.get("doneHeading"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().allDonePage().clickDone();
			} else {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyErrorMessageOfDebitCard(data.get("maxDebitCardErrMsg"));
			}

//				} else {
//					ExtentTestManager.setFailMessageInReport("Debit Cards Added More Then Max Limit");
//				}

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("AddDebitCar Failed due to this Exception" + e);
		}
	}

	public void AddDebitCar(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyHeading(data.get("addPaymentHeading"));
				Thread.sleep(1000);
//				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifywithdrawAddInstantHeading(data.get("withdrawInstantHeading"));

			if (data.get("validateNumberOfCards").equalsIgnoreCase("yes")) {
				Thread.sleep(1000);
				int presentCard = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.getPresentDebitCards();
				int maxLimit = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.getMaxDebitCardsLimit();
				if (presentCard <= maxLimit) {
					merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
							.verifyDebitCards(data.get("presentDebitCardNumber"));
				}
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyErrorMessageDebitCard() == 0) {
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillNameOnCard(data.get("nameOnCard"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillCardNumber(data.get("cardNumber"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillCardExp(data.get("cardExp"));
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
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickAddCard();
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().allDonePage().verifyAllDone(data.get("doneHeading"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().allDonePage().clickDone();
			} else {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyErrorMessageOfDebitCard(data.get("maxDebitCardErrMsg"));
			}

//				} else {
//					ExtentTestManager.setFailMessageInReport("Debit Cards Added More Then Max Limit");
//				}

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("AddDebitCar Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testDebitCardFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickPaymentMethods();
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyHeading(data.get("addPaymentHeading"));
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			String[] nameOncard = data.get("nameOnCard").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateNameOnCardField(nameOncard[0], nameOncard[1], nameOncard[2]);
			String[] cardNumber = data.get("cardNumber").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateCardNumberField(cardNumber[0], cardNumber[1], cardNumber[2]);
			String[] cardExp = data.get("cardExp").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateCardExpField(cardExp[0], cardExp[1], cardExp[2]);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
			String[] addressLine1 = data.get("addressLine1").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateAddressLine1Field(addressLine1[0], addressLine1[1], addressLine1[2]);
			String[] addressLine2 = data.get("addressLine2").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateAddressLine2Field(addressLine2[0], addressLine2[1], addressLine2[2]);
			String[] city = data.get("city").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateCityField(city[0], city[1], city[2]);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			String[] zipCode = data.get("zipCode").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateZipCodeField(zipCode[0], zipCode[1], zipCode[2]);
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("DebitCardFieldValidations Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testEditDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (businessTokenAccountPage.verifyProfile() == 1) {
				businessTokenAccountPage.clickProfile();
				merchantProfilePage.clickPaymentMethods();
			}
			Thread.sleep(2000);
			merchantProfilePage.paymentMethodsPage().clickDebitCard();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
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
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickSave();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.toastComponent().verifyToastMsg(data.get("debitEditToastMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testVerifyAllStates(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickPaymentMethods();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillNameOnCard(data.get("nameOnCard"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardNumber(data.get("cardNumber"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addressLine1"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addressLine2"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.validateAllStates();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			if (businessTokenAccountPage.verifyProfile() == 1) {
				businessTokenAccountPage.clickProfile();
				merchantProfilePage.clickPaymentMethods();
			}
			int numOfCards = merchantProfilePage.paymentMethodsPage().verifyNumOfCard();
			for (int i = 1; i <= numOfCards; i++) {
//				int a=merchantProfilePage.paymentMethodsPage().verifyNumOfCard();

				merchantProfilePage.paymentMethodsPage().clickDebitCard();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickRemove();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickYes();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().toastComponent().verifyToastMsg(data.get("debitDeleteToastMsg"));

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testDebitCardWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			Thread.sleep(2000);
			merchantProfilePage.clickPaymentMethods();
			Thread.sleep(3000);
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
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
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickAddCard();
			}

			if (!data.get("errMsg").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("elementName"));
			}
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickPaymentMethods();
			AddCogentAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	public void AddCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyHeading(data.get("addPaymentHeading"));
			}

			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifywithdrawAddCogentHeading(data.get("withdrawSignetHeading"));

			if (data.get("validateNumberOfCogentAccounts").equalsIgnoreCase("yes")) {
				int presentCogentAccount = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.getPresentCogentAccounts();
				int maxCogentAccount = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.getMaxCogentAccounts();
				if (presentCogentAccount <= maxCogentAccount) {
					merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
							.verifyCogentAccounts(data.get("presentSignetAccountNumber"));
				}

			}

			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifyErrorMessageSignetAccount() == 0) {
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCogentAccount();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillNameOnCard(data.get("nameOnCard"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillSignetWalletId(data.get("signetWalletID"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine2(data.get("addressLine2"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillCity(data.get("city"));
				Thread.sleep(2000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().selectState(data.get("state"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickAddCard();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().allDonePage().verifyAllDone(data.get("doneHeading"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().allDonePage().clickDone();
			} else {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyErrorMessageOfSignetAccount(data.get("maxSignetErrMsg"));
			}
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Add Cogent Account failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void CogentAccountFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickPaymentMethods();
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyHeading(data.get("addPaymentHeading"));
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCogentAccount();
			String[] nameOnCard = data.get("nameOnCard").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateNameOnCardField(nameOnCard[0], nameOnCard[1], nameOnCard[2]);
			String[] signetWalletID = data.get("signetWalletID").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validatetCogentWalletIdField(signetWalletID[0], signetWalletID[1], signetWalletID[2]);
			String[] addressLine1 = data.get("addressLine1").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateAddressLine1Field(addressLine1[0], addressLine1[1], addressLine1[2]);
			String[] addressLine2 = data.get("addressLine2").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateAddressLine2Field(addressLine2[0], addressLine2[1], addressLine2[2]);
			String[] city = data.get("city").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateCityField(city[0], city[1], city[2]);
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			String[] zipCode = data.get("zipCode").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateZipCodeField(zipCode[0], zipCode[1], zipCode[2]);
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("CogentAccountFieldValidation failed due to this Exception" + e);
		}
	}

//	public void AddSignetAccoun(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
//			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
//				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
//			}
//			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
//				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
//						.verifyHeading(data.get("addPaymentHeading"));
//				Thread.sleep(1000);
//				int presentSignetAccount = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
//						.getPresentCogentAccounts();
//				int maxSignetAccount = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
//						.getMaxCogentAccounts();
//				if (presentSignetAccount <= maxSignetAccount) {
//					merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
//							.verifyCogentAccounts(data.get("presentSignetAccountNumber"));
//					if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
//							.verifyErrorMessageSignetAccount() == 0) {
//						Thread.sleep(1000);
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCogentAccount();
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.fillNameOnCard(data.get("nameOnCard"));
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.fillSignetWalletId(data.get("signetWalletID"));
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.mailingAddressComponent().fillAddressLine2(data.get("addressLine2"));
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.mailingAddressComponent().fillCity(data.get("city"));
//						Thread.sleep(2000);
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.mailingAddressComponent().selectState(data.get("state"));
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.mailingAddressComponent().fillZipCode(data.get("zipCode"));
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.mailingAddressComponent().clickAddCard();
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.mailingAddressComponent().allDonePage().verifyAllDone(data.get("doneHeading"));
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//								.mailingAddressComponent().allDonePage().clickDone();
//					} else {
//						merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
//								.verifyErrorMessageOfSignetAccount(data.get("maxSignetErrMsg"));
//					}
//				} else {
//					ExtentTestManager.setFailMessageInReport("Signet Accounts Added More Then Max Limit");
//				}
//			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Add Signet Accoun failed due to this Exception" + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			if (businessTokenAccountPage.verifyProfile() == 1) {
				businessTokenAccountPage.clickProfile();
				merchantProfilePage.clickPaymentMethods();
				Thread.sleep(1000);
			}
			int numOfCogentAccounts = merchantProfilePage.paymentMethodsPage().verifyNumOfCogentAccounts();
			for (int i = 1; i <= numOfCogentAccounts; i++) {
				merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
				merchantProfilePage.paymentMethodsPage().clickDeleteCogentAccount();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickYes();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().toastComponent().verifyToastMsg(data.get("signetDeleteToastMsg"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCogentAccountWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			Thread.sleep(2000);
			merchantProfilePage.clickPaymentMethods();
			merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifyHeading(data.get("addPaymentHeading"));
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCogentAccount();

			if (data.get("validateNameErrMsg").equalsIgnoreCase("yes")) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillNameOnCard(data.get("nameOnCard"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillSignetWalletId(data.get("signetWalletID"));

			} else if (data.get("validateCogentErrMsg").equalsIgnoreCase("yes")) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillNameOnCard(data.get("nameOnCard"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillSignetWalletId(data.get("signetWalletID"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillNameOnCard(data.get("nameOnCard"));
			} else {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine2(data.get("addressLine2"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillCity(data.get("city"));
				Thread.sleep(2000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().selectState(data.get("state"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			}

			if (!data.get("errMsg").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("elementName"));
			}
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickPaymentMethods();
			testAddBankAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	public void testAddBankAccount(String strPrams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strPrams);
			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
			Thread.sleep(2000);
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyHeading(data.get("addPaymentHeading"));
				Thread.sleep(1000);
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickBankAcount();
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifywithdrawAddBankHeading(data.get("withdrawAddBank"));

			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent().addBank(
					data.get("addExternalBankHeading"), data.get("nameOnBank"), data.get("routingNum"),
					data.get("confirmRoutingNum"), data.get("accountNum"), data.get("confirmAccNum"));
			Thread.sleep(2000);
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
					.bankAccountAddedPage().verifyBankSucessHeading() == 1) {

				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
						.bankAccountAddedPage().verifyHeading(data.get("bankAddedHeading"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
						.bankAccountAddedPage().verifyStatus(data.get("bankStatus"));
				String nameOnBank = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.addBankAccountComponent().bankAccountAddedPage().getNameOnAccount();
				String routingNum = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.addBankAccountComponent().bankAccountAddedPage().getRoutingNum();
				String accNum = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.addBankAccountComponent().bankAccountAddedPage().getAccNum();
				if (data.get("nameOnBank").equalsIgnoreCase(nameOnBank)
						&& data.get("routingNum").equalsIgnoreCase(routingNum)
						&& data.get("accountNum").contains(accNum)) {
					merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
							.bankAccountAddedPage().getBankDetails();
				} else {
					ExtentTestManager.setFailMessageInReport("Bank Account Details are Wrong");
				}
//

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testAddBankAccount failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccoun(String strPrams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strPrams);
			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickPaymentMethods();
			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyHeading(data.get("addPaymentHeading"));
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifywithdrawAddBankHeading(data.get("withdrawBankHeading"));

			if (data.get("validateNumberOfBankAccounts").equalsIgnoreCase("yes")) {
				int presentBankAccount = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.getPresentBankAccounts();
				int maxBankAccount = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.getMaxBankAccounts();
				if (presentBankAccount <= maxBankAccount) {
					merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
							.verifyBankAccounts(data.get("presentBankAccountNumber"));
				}

			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
					.verifyErrorMessageBankAccount() == 0) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickBankAcount();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent().addBank(
						data.get("addExternalBankHeading"), data.get("nameOnBank"), data.get("routingNum"),
						data.get("confirmRoutingNum"), data.get("accountNum"), data.get("confirmAccNum"));
				Thread.sleep(2000);
//				if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
//						.bankAccountAddedPage().verifyBankSucessHeading() == 1) {

				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
						.bankAccountAddedPage().verifyHeading(data.get("bankAddedHeading"));
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
						.bankAccountAddedPage().verifyStatus(data.get("bankStatus"));
				String nameOnBank = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.addBankAccountComponent().bankAccountAddedPage().getNameOnAccount();
				String routingNum = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.addBankAccountComponent().bankAccountAddedPage().getRoutingNum();
				String accNum = merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.addBankAccountComponent().bankAccountAddedPage().getAccNum();
				if (data.get("nameOnBank").equalsIgnoreCase(nameOnBank)
						&& data.get("routingNum").equalsIgnoreCase(routingNum)
						&& data.get("accountNum").contains(accNum)) {
					merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
							.bankAccountAddedPage().getBankDetails();
				} else {
					ExtentTestManager.setFailMessageInReport("Bank Account Details are Wrong");
				}
				// }
			} else {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyErrorMessageOfSignetAccount(data.get("maxBankErrMsg"));
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBankAccountFieldValidations(String strPrams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strPrams);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickPaymentMethods();
			MerchantProfilePage merchantProfilePage = new MerchantProfilePage();
			Thread.sleep(2000);

			if (merchantProfilePage.paymentMethodsPage().verifyAddNewPaymentMethod() == 1) {
				merchantProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			}
			if (merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyAddNewPaymentHeading() == 1) {
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent()
						.verifyHeading(data.get("addPaymentHeading"));
			}
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().clickBankAcount();
			String[] nameOnBank = data.get("nameOnBank").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
					.fieldValidationsComponent().validateNameOnBankField(nameOnBank[0], nameOnBank[1], nameOnBank[2]);
			String[] routingNum = data.get("routingNum").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
					.fieldValidationsComponent().validateRoutingNumField(routingNum[0], routingNum[1], routingNum[2]);
			String[] confirmRoutingNum = data.get("confirmRoutingNum").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
					.fieldValidationsComponent()
					.validateConfirmRoutingField(confirmRoutingNum[0], confirmRoutingNum[1], confirmRoutingNum[2]);
			String[] accountNum = data.get("accountNum").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
					.fieldValidationsComponent()
					.validateConfirmAccountNumField(accountNum[0], accountNum[1], accountNum[2]);
			String[] confirmAccNum = data.get("confirmAccNum").split(",");
			merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addBankAccountComponent()
					.fieldValidationsComponent()
					.validateConfirmAccountNumField(confirmAccNum[0], confirmAccNum[1], confirmAccNum[2]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testAddBankAccount failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBank(String strPrams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strPrams);
			Thread.sleep(2000);
			if (businessTokenAccountPage.verifyProfile() == 1) {
				businessTokenAccountPage.clickProfile();
				merchantProfilePage.clickPaymentMethods();
			}
			int numOfBankAccs = merchantProfilePage.paymentMethodsPage().verifyNumOfBanks();
			for (int i = 1; i <= numOfBankAccs; i++) {
				merchantProfilePage.paymentMethodsPage().verifyHeading(data.get("heading"));
				merchantProfilePage.paymentMethodsPage().clickBankAccount();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickYes();
				merchantProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().toastComponent().verifyToastMsg(data.get("bankDeleteToastMsg"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelp(String strPrams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strPrams);
			Thread.sleep(2000);
			businessTokenAccountPage.clickProfile();
			merchantProfilePage.clickGetHelp();
			merchantProfilePage.getHelpPage().verifyHeading(data.get("getHelpHeading"));
			merchantProfilePage.getHelpPage().getHelpDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

}