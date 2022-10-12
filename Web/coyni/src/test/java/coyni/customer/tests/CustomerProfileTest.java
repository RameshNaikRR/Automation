package coyni.customer.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.ChangePasswordComponent;
import coyni.customer.components.CustomerMenuComponent;
import coyni.customer.components.NavigationComponent;
import coyni.customer.pages.CustomerProfilePage;
import coyni.customer.pages.HomePage;
import coyni.customer.pages.LoginPage;
import coyni.customer.pages.NavigationMenuPage;
import coyni.customer.pages.TokenAccountPage;
import coyni.customer.popups.EditEmailAddressPopup;
import coyni.customer.popups.EditPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class CustomerProfileTest {
	CustomerProfilePage customerProfilePage;
	NavigationMenuPage navigationMenuPage;
	EditPhoneNumberPopup editPhoneNumberPopup;
	EditEmailAddressPopup editEmailAddressPopup;
	CustomerMenuComponent customerMenuComponent;
	AuthyComponent authyComponent;
	ChangePasswordComponent changePasswordComponent;
	TokenAccountPage tokenAccountPage;
	NavigationComponent navigationComponent;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeTest
	public void init() {

		customerProfilePage = new CustomerProfilePage();
		navigationMenuPage = new NavigationMenuPage();
		editPhoneNumberPopup = new EditPhoneNumberPopup();
		editEmailAddressPopup = new EditEmailAddressPopup();
		customerMenuComponent = new CustomerMenuComponent();
		authyComponent = new AuthyComponent();
		changePasswordComponent = new ChangePasswordComponent();
		tokenAccountPage = new TokenAccountPage();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetailsView(String strParams) {
		try {
//			customerProfilePage.customerMenuComponent().clickUserDetails();
//			customerProfilePage.userDetailsComponent().verifyUserDetailsView();
//			customerProfilePage.userDetailsComponent().verifyUserNameView();
//			customerProfilePage.userDetailsComponent().verifyAccountStatusView();
//			customerProfilePage.userDetailsComponent().verifyAccountIDView();
//			customerProfilePage.userDetailsComponent().verifyPhoneNumberView();
//			customerProfilePage.userDetailsComponent().verifyEmailView();
//			customerProfilePage.userDetailsComponent().verifyAddressView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test User Details view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditImageView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			customerProfilePage.userDetailsComponent().verifyEditImageView();
			// customerProfilePage.userDetailsComponent().verifyEditImageToolTip(data.get("toolTip"));
			customerProfilePage.userDetailsComponent().clickEditUserImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().verifyUploadImageView();
			// AccountProfile-Close Navigation
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().navigationComponent()
					.verifyCloseView();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().navigationComponent().clickClose();
			customerProfilePage.userDetailsComponent().verifyUserDetailsView();
			// RemoveProfile-Back and Close Navigation
			customerProfilePage.userDetailsComponent().clickEditUserImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().clickRemove();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.verifyHeading(data.get("removeProfileHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.verifyRemoveView();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().verifyBackView();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().verifyCloseView();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().clickBack();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().clickRemove();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().clickClose();
			customerProfilePage.userDetailsComponent().verifyUserDetailsView();
			// Crop Image -Navigation
			customerProfilePage.userDetailsComponent().clickEditUserImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().clickUploadNewImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.verifyHeading(data.get("cropYourImageHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup().verifySaveView();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.navigationComponent().verifyBackView();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.navigationComponent().verifyCloseView();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.navigationComponent().clickBack();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().clickUploadNewImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.navigationComponent().clickClose();
			customerProfilePage.userDetailsComponent().verifyUserDetailsView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Edit Image view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetailsAddImage(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			Thread.sleep(2000);
			customerProfilePage.userDetailsComponent().clickEditUserImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().clickUploadNewImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.verifyHeading(data.get("cropYourImageHeading"));
			//customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup().clickSelectImage();
			//Thread.sleep(3000);
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.uploadSelectImage(data.get("folderName"), data.get("fileName"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup().clickSave();
			Thread.sleep(500);
			if (!data.get("toastMessage").isEmpty()) {
				// customerProfilePage.toastComponent().verifyToast(data.get("toastTitle"),
				// data.get("toastMessage"));
			}
			Thread.sleep(2000);

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("testUserDetailsAddImage failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetailsImageRemove(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			Thread.sleep(4000);
			customerProfilePage.userDetailsComponent().clickEditUserImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().clickRemove();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.verifyHeading(data.get("removeProfileHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.clickRemoveImage();
			Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
			customerProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testUserDetailsImageRemove failed due to exception " + e);

		}
	}

	@Test // added
	@Parameters({ "strParams" })

	public void testEditPhoneNumberWithValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.userNameDropDownComponent().clickUserName();
			navigationMenuPage.customerMenuComponent().clickUserDetails();

			customerProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			;
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
//			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent().fillAuthyInput(data.get("securityKey"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expEditPhoneNumberHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSend();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput(data.get("code"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen(data.get("headingNewPhoneNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().authyComponent().fillInput(data.get("code"));
			Thread.sleep(3000);
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().authyComponent().fillInput(data.get("code"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().authyComponent().successFailurePopupCardComponent()
					.navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testEditPhoneNumberWithValidData is failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })

	public void testEditPhoneNumberWithInvalidAuthy(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.userNameDropDownComponent().clickUserName();
			navigationMenuPage.customerMenuComponent().clickUserDetails();

			customerProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			;
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
//			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent().fillAuthyInput(data.get("securityKey"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expEditPhoneNumberHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSend();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput(data.get("code"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen(data.get("headingNewPhoneNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().authyComponent().fillInput(data.get("code1"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testEditPhoneNumberWithValidData is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumberWithInvalidCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.userNameDropDownComponent().clickUserName();
			navigationMenuPage.customerMenuComponent().clickUserDetails();
			customerProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.validateAuthyField(data.get("code"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyNewPhoneField(data.get("expNewPhoneNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("number"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifySendCodeButtonEnabled();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSend();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("expHeadingCurrentNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyMultipleResend();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput("code");
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen("expNewPhoneNumberHeading");
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().clickMultipleResend();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testEditPhoneNumberWithValidCode is failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })

	public void testEditPhoneNumberWithBackNavigation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.userNameDropDownComponent().clickUserName();
			navigationMenuPage.customerMenuComponent().clickUserDetails();
			customerProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();

			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().navigationComponent().clickClose();
			customerProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().navigationComponent().clickClose();
			customerProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.navigationComponent().clickBack();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.navigationComponent().clickClose();
			customerProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput(data.get("code"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen(data.get("expNewPhoneNumberHeading"));
			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testEditPhoneNumberVerificationCodeWithInvalidCode is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			Thread.sleep(5000);
			customerProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			// Authentication
			customerProfilePage.userDetailsComponent().clickIconEditEmail();
			customerProfilePage.userDetailsComponent().verifyEditEmailAddressAuthentication(data.get("authiHeading"));
			// Edit Email Address Authentication-Close Navigation
			customerProfilePage.userDetailsComponent().navigationComponent().verifyCloseView();
			customerProfilePage.userDetailsComponent().navigationComponent().clickClose();
			customerProfilePage.userDetailsComponent().verifyUserDetailsView();
			// Edit Email Address -Close Navigation
			customerProfilePage.userDetailsComponent().clickIconEditEmail();
			customerProfilePage.userDetailsComponent().authyComponent().fillInput(data.get("code"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().navigationComponent().verifyCloseView();
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().navigationComponent().clickClose();
			customerProfilePage.userDetailsComponent().verifyUserDetailsView();
			// Current Email Address-Back Navigation Back
			customerProfilePage.userDetailsComponent().clickIconEditEmail();
			customerProfilePage.userDetailsComponent().authyComponent().fillInput(data.get("code"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup()
//					.fillNewEmailAddress(data.get("newEmailAddress"));
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.verifyCurrentEmailAddressHeading(data.get("currentEmailHeading"));
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.navigationComponent().verifyBackView();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.navigationComponent().clickBack();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.navigationComponent().clickClose();
//			customerProfilePage.userDetailsComponent().verifyUserDetailsView();
//			// Verify New Email Address -Navigation back
//			customerProfilePage.userDetailsComponent().clickIconEditEmail();
//			Thread.sleep(10000);
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.authyComponent().fillInput(data.get("fillPinEmail"));
//			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
////			// Thread.sleep(3000);
////			customerProfilePage.userDetailsComponent().editEmailAddressPopup().fillNewEmailAddress(data.get("newEmailAddress"));
////			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
////			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
////			Thread.sleep(3000);
////			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().verifyCurrentEmailAddressHeading(data.get("currentEmailHeading"));
////		    customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().authyComponent().fillInput(data.get("fillPinEmail"));
//			Thread.sleep(2000);
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.verifyNewEmailAddressPopUp().verifyNewEmailAddress(data.get("newEmailHeading"));
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.verifyNewEmailAddressPopUp().authyComponent().fillInput(data.get("fillPinNewEmail"));
//
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.verifyNewEmailAddressPopUp().navigationComponent().verifyBackView();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.verifyNewEmailAddressPopUp().navigationComponent().clickBack();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.authyComponent().fillInput(data.get("fillPinEmail"));
//			Thread.sleep(3000);
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.verifyNewEmailAddressPopUp().navigationComponent().verifyCloseView();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.verifyNewEmailAddressPopUp().navigationComponent().clickClose();
//			customerProfilePage.userDetailsComponent().verifyUserDetailsView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			Thread.sleep(5000);
			customerProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			customerProfilePage.userDetailsComponent().clickIconEditEmail();
			customerProfilePage.userDetailsComponent().verifyEditEmailAddressAuthentication(data.get("authiHeading"));
			customerProfilePage.changePasswordComponent().authyComponent().fillInput(data.get("code"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			// customerProfilePage.userDetailsComponent().authyComponent().verifyMessage(data.get("message"));

			customerProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
			// customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyOldEmailAddress();
			customerProfilePage.userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyCurrentEmailAddressHeading(data.get("currentEmailHeading"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyCurrentEmail(data.get("currentEmail"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.authyComponent().fillInput(data.get("fillPinEmail"));
			// customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().authyComponent().verifyMessage(data.get("message"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().verifyNewEmailAddress(data.get("newEmailHeading"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().verifyNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().authyComponent().fillInput(data.get("fillPinNewEmail"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().authyComponent().verifyMessage(data.get("message"));
			// customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
			// .verifyNewEmailAddressPopUp().successFailurePopupCardComponent()
			// .verifyEmailAddressChanged(data.get("emailAddressChanged"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmaiWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			customerProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			customerProfilePage.userDetailsComponent().clickIconEditEmail();
			customerProfilePage.userDetailsComponent().verifyEditEmailAddress(data.get("heading"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			customerProfilePage.changePasswordComponent().authyComponent().fillInput(data.get("code"));
			customerProfilePage.userDetailsComponent().verifyEditEmailAddress(data.get("heading"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyOldEmailAddress();
			customerProfilePage.userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
			// customerProfilePage.userDetailsComponent().editEmailAddressPopup().fillNewEmailAddress(data.get("newEmailAddress"));

			if (!data.get("errorMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

			}
			new CommonFunctions().validateFormErrorMessage(data.get("errorMessage"), data.get("colour"),
					data.get("elementName"));

			Thread.sleep(5000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailAddressWithInvalidAuthy(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickUserDetails();
			Thread.sleep(5000);
			customerProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			customerProfilePage.userDetailsComponent().clickIconEditEmail();
			customerProfilePage.userDetailsComponent().verifyEditEmailAddress(data.get("heading"));
			if (!data.get("code").isEmpty()) {
				customerProfilePage.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
			}
			if (!data.get("errorMessage").isEmpty()) {
				Thread.sleep(4000);
				customerProfilePage.authyComponent().verifyMessage(data.get("errorMessage"));
			}
			Thread.sleep(2000);
			customerProfilePage.authyComponent().verifyLoginWithInvalidPin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void editAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().clickIconEditAddress();
			customerProfilePage.userDetailsComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			customerProfilePage.userDetailsComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			customerProfilePage.userDetailsComponent().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.userDetailsComponent().mailingAddressComponent().selectState(data.get("state"));
			customerProfilePage.userDetailsComponent().mailingAddressComponent().fillZipCode(data.get("zipcode"));
			customerProfilePage.userDetailsComponent().mailingAddressComponent().verifyCountry("");
			customerProfilePage.userDetailsComponent().mailingAddressComponent().clickSave();
			customerProfilePage.toastComponent().verifyToast("", "");
		} catch (Exception e) {

		}

	}

	@Test
	public void testLogout() {
		try {
			loginPage.userNameDropDownComponent().clickUserName();
			loginPage.userNameDropDownComponent().clickSignOut();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLogout is failed due to Exception " + e);
		}
	}

	@Test
	// @Parameters({ "strParams" })

	public void testNotifications() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			// customerProfilePage.userDetailsComponent().notificationsComponent()
			// .verifyBellIconMouseHoverAction(data.get("background"), strParams);
			Thread.sleep(2000);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyCursorNotification();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			Thread.sleep(2000);
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyAllNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyDateFormatInNotifications();
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsCount();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Notifications is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginwithNewAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

		//	homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email1"));
			loginPage.fillPassword(data.get("password1"));
			loginPage.clickNext();
			// loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
			Thread.sleep(1000);
			// loginPage.authyComponent().fillAuthyInput(data.get("securityKey1"));
			Thread.sleep(2000);
			loginPage.authyComponent().fillInput(data.get("code"));
			// loginPage.authyComponent().verifyMessage(data.get("message"));
			// loginPage.authyComponent().verifyLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationsPayInsufficientfunds(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsIconView();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyMoveToCrossbtn();
			// customerProfilePage.userDetailsComponent().notificationsComponent().VerifyMousehoverNotificationscolor(data.get("CssProp"),
			// data.get("CssValue"), data.get("Color"));
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsbtnView();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyInitialMsg(data.get("initialMsg"));
			customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyPaybtnView();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyFinalMsg(data.get("finalMsg"));
//			customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();
//			customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent().verifyHeading(data.get("authyHeading"));
//			customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent()
//					.fillAuthyInput(data.get("securityKey"));
//			customerProfilePage.userDetailsComponent().notificationsComponent().verifyLastMsg(data.get("lastMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testPay is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationsPaywithAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			// customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyRecievedMsg(data.get("recievedMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Notifications Pay with funds failed due to Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationsPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsCount();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyInitialMsg(data.get("initialMsg"));
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyDenybtnView();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyFinalMsg(data.get("finalMsg"));
			customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();
			customerProfilePage.userDetailsComponent().notificationsComponent().payingAccountHolderNamePopup()
					.verifyHeading(data.get("authyPayHeading"));
			// customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent()
			// .fillAuthyInput(data.get("securityKey1"));
			customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent()
					.fillInput(data.get("code"));
			Thread.sleep(1000);
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyLastMsg(data.get("lastMsg"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationsPay is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationsDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyInitialMsg(data.get("initialMsg"));
			customerProfilePage.userDetailsComponent().notificationsComponent().clickDeny();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyLastMsg(data.get("lastMsg"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testDeny is failed due to Exception " + e);
		}
	}

	@Test
	// @Parameters({ "strParams" })
	public void testClearAllNotifications() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyClearallBtnView();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickClearAll();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Clear all Notifications failed due to Exception " + e);
		}
	}

	// added
	@Test
	public void testNotificationsDelete() {
		try {
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			// customerProfilePage.userDetailsComponent().notificationsComponent().clickReminder();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickDelete();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testRemove is failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationsCount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			System.out.println("id:" + navigationMenuPage.getCustId());
			String dbCount = DBConnection.getDbCon()
					.getColumnData(String.format(data.get("query"), navigationMenuPage.getCustId()));
			System.out.println(dbCount);
			String uiCount = customerProfilePage.userDetailsComponent().notificationsComponent().getUiCount();
			if (uiCount.equals(dbCount)) {
				ExtentTestManager.setPassMessageInReport("Count is verified");
			} else {
				ExtentTestManager.setFailMessageInReport("Count is not verified");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotifications count failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestAmountPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyInitialMsg(data.get("initialMsg"));
			customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyFinalMsg(data.get("finalMsg"));
			customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();
			customerProfilePage.userDetailsComponent().notificationsComponent().payingAccountHolderNamePopup()
					.verifyHeading(data.get("authyPayHeading"));
			// customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent()
			// .fillAuthyInput(data.get("securityKey1"));
			customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent()
					.fillInput(data.get("code"));
			Thread.sleep(1000);
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyLastMsg(data.get("lastMsg"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Request Amount Pay is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestPayInsufficientfunds(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyRequestbtnView();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyInitialMsg(data.get("initialMsg"));
			customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyFinalMsg(data.get("finalMsg"));
			// customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();

//          customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent().verifyHeading(data.get("authyHeading"));
//			customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent()
//					.fillAuthyInput(data.get("securityKey"));
//			customerProfilePage.userDetailsComponent().notificationsComponent().verifyLastMsg(data.get("lastMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testPay is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReminderNotification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifybtnReminderView();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyReminderfirstMsg(data.get("initialMsg"));
			customerProfilePage.userDetailsComponent().notificationsComponent().clickReminder();
			// customerProfilePage.userDetailsComponent().notificationsComponent()
			// .verifyReminderLastMsg(data.get("finalMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Reminder Notifications failed due to Exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCancelNotifications(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifybtnCancelView();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyReminderfirstMsg(data.get("initialMsg"));
			Thread.sleep(1000);
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyCancelBorderColor(data.get("CssProp"),
			// data.get("CssValue"), data.get("Color"));
			customerProfilePage.userDetailsComponent().notificationsComponent().clickCancel();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyCancelMsg(data.get("finalMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Cancel notifications failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			customerProfilePage.userDetailsComponent().notificationsComponent()
					.verifyInitialMsg(data.get("initialMsg"));
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyDenyBordercolor(data.get("CssProp"),
			// data.get("CssValue"), data.get("Color"));
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyDenybtnView();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickDeny();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyLastMsg(data.get("lastMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testDeny is failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })

	public void testPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPreferences();
			customerProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));
			customerProfilePage.preferencesComponent().selectDefaultAccount(data.get("defaultAccount"));
			// customerProfilePage.preferencesComponent().verifyDefaultAccountBackGroundColor(data.get(""),
			// strParams);
			Thread.sleep(3000);
			customerProfilePage.preferencesComponent().clickSave();
			// customerProfilePage.preferencesComponent().verifyLocalCurrency("Local
			// Currency");

			customerProfilePage.preferencesComponent().verifyLabelSuccessMessage();
			customerProfilePage.preferencesComponent().verifyLabelPreferences(data.get("expHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPreferences is failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testPreferencesDisplayed(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPreferences();
			customerProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));
			customerProfilePage.preferencesComponent().verifyTimeZoneView();
			customerProfilePage.preferencesComponent().verifyPSTTickMark();
			// customerProfilePage.preferencesComponent().selectDefaultAccount("defaultAccount");
			// customerProfilePage.preferencesComponent().verifyDefaultAccountBackGroundColor(data.get("expColor"),
			// data.get("expCssProp"));

			// customerProfilePage.preferencesComponent().verifyDefautAccountTickMark();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testPreferencesDisplayed is failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			CustomerMenuComponent customerMenuComponent = new CustomerMenuComponent();
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			customerMenuComponent.clickUserName();
			Thread.sleep(2000);
			customerMenuComponent.clickChangePassword();
			Thread.sleep(2000);
			// customerProfilePage.changePasswordComponent().verifyAuthyHeading(data.get("heading"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			// customerProfilePage.changePasswordComponent().verifyHeading("heading1");
			// customerProfilePage.changePasswordComponent().verifyContent(data.get("content"));
			customerProfilePage.changePasswordComponent().authyComponent().fillInput(data.get("code"));
			customerProfilePage.changePasswordComponent().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordComponent().fillNewPassword(data.get("newPassword"));
			customerProfilePage.changePasswordComponent().clickIcon();
			customerProfilePage.changePasswordComponent().fillConfirmNewPassword(data.get("confirmPassword"));
			customerProfilePage.changePasswordComponent().clickSave();
			Thread.sleep(3000);
			// customerProfilePage.changePasswordComponent().verifyContaint(data.get("successContent"));
			// homePage.verifyLandingPageHeading(data.get("createHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test change password failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerMenuComponent customerMenuComponent = new CustomerMenuComponent();
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			customerMenuComponent.clickUserName();
			// customerMenuComponent.clickUserDetails();
			Thread.sleep(2000);
			customerMenuComponent.clickChangePassword();
			Thread.sleep(1000);
			// customerProfilePage.changePasswordComponent().verifyAuthyHeading(data.get("heading"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			customerProfilePage.changePasswordComponent().authyComponent().fillInput(data.get("code"));
			customerProfilePage.changePasswordComponent().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordComponent().clickIcon();
			customerProfilePage.changePasswordComponent().viewCurrentPassword();
			customerProfilePage.changePasswordComponent().fillNewPassword(data.get("newPassword"));
			customerProfilePage.changePasswordComponent().fillConfirmNewPassword(data.get("confirmPassword"));
			customerProfilePage.changePasswordComponent().clickTab();
			// customerProfilePage.changePasswordComponent().clickSave();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
//						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test change password with invalis  credentials failed due to exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testPreferencesSelectTimeZone(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPreferences();
			// customerProfilePage.preferencesComponent().verifyPreferencesBackGroundColor(data.get("cssProp"),
			// data.get("expValue"), data.get("expColor"));
			customerProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testPreferencesSelectTimeZone is failed due to Exception " + e);
		}

	}

	@Test // added
	@Parameters({ "strParams" })
	public void testChangePasswordInvalidAuthyCredentials(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);

			Thread.sleep(1000);
			customerMenuComponent.clickUserName();
			Thread.sleep(1000);
			customerMenuComponent.clickChangePassword();
			customerProfilePage.changePasswordComponent().verifyAuthyHeading(data.get("heading"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillpin(data.get("code"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test change password with invalis Authy credentials failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickAccountLimits();
			ExtentTestManager.setInfoMessageInReport(
					"Pay and Request" + customerProfilePage.accountLimitsComponent().getPayAndRequest());
			ExtentTestManager
					.setInfoMessageInReport("Send Token" + customerProfilePage.accountLimitsComponent().getSendToken());
			ExtentTestManager
					.setInfoMessageInReport("Buy Tokens" + customerProfilePage.accountLimitsComponent().getBuyTokens());
			ExtentTestManager.setInfoMessageInReport(
					"Bank Account" + customerProfilePage.accountLimitsComponent().getBankAccount());
			ExtentTestManager.setInfoMessageInReport(
					"Bank Account Wallet" + customerProfilePage.accountLimitsComponent().getBankAccountWallet());
			ExtentTestManager.setInfoMessageInReport(
					"Debit Card" + customerProfilePage.accountLimitsComponent().getDebitAndCard());
			ExtentTestManager.setInfoMessageInReport(
					"Debit and Credit Wallet" + customerProfilePage.accountLimitsComponent().getDebitAndCreditWallet());
			ExtentTestManager.setInfoMessageInReport(
					"Withdraw To USD" + customerProfilePage.accountLimitsComponent().getWithdrawtoUSD());
			ExtentTestManager.setInfoMessageInReport(
					"Bank Account Withdarw" + customerProfilePage.accountLimitsComponent().getBankAccountWithdraw());
			ExtentTestManager.setInfoMessageInReport(
					"Instant Pay" + customerProfilePage.accountLimitsComponent().getInstantPay());
			ExtentTestManager
					.setInfoMessageInReport("Gift Card" + customerProfilePage.accountLimitsComponent().getGiftCard());
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

}
