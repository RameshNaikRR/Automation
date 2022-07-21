package coyni.merchant.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.pages.NavigationMenuPage;
import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.MerchantMenuComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.TopBarComponent;
import coyni.merchant.pages.ChangePasswordPage;
import coyni.merchant.pages.HomePage;
import coyni.merchant.pages.LoginPage;
import coyni.merchant.pages.MerchantProfilePage;
import coyni.merchant.pages.TokenAccountPage;
import coyni.merchant.popups.EditEmailAddressPopup;
import coyni.merchant.popups.EditPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class MerchantProfileTest {
	MerchantProfilePage merchantProfilePage;
	NavigationMenuPage navigationMenuPage;
	EditPhoneNumberPopup editPhoneNumberPopup;
	EditEmailAddressPopup editEmailAddressPopup;
	MerchantMenuComponent merchantMenuComponent;
	AuthyComponent authyComponent;
	ChangePasswordPage changePasswordPage;
	TokenAccountPage tokenAccountPage;
	TopBarComponent topBarComponent;
	NavigationComponent navigationComponent;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeTest
	public void init() {

		merchantProfilePage = new MerchantProfilePage();
		topBarComponent = new TopBarComponent();
		navigationMenuPage = new NavigationMenuPage();
		editPhoneNumberPopup = new EditPhoneNumberPopup();
		editEmailAddressPopup = new EditEmailAddressPopup();
		merchantMenuComponent = new MerchantMenuComponent();
		authyComponent = new AuthyComponent();
		changePasswordPage = new ChangePasswordPage();
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
			merchantProfilePage.userDetailsComponent().verifyEditImageView();
			// customerProfilePage.userDetailsComponent().verifyEditImageToolTip(data.get("toolTip"));
			merchantProfilePage.userDetailsComponent().clickEditUserImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().verifyUploadImageView();
			// AccountProfile-Close Navigation
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().navigationComponent()
					.verifyCloseView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
			// RemoveProfile-Back and Close Navigation
			merchantProfilePage.userDetailsComponent().clickEditUserImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().clickRemove();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.verifyHeading(data.get("removeProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.verifyRemoveView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().verifyBackView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().verifyCloseView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().clickBack();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().clickRemove();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
			// Crop Image -Navigation
			merchantProfilePage.userDetailsComponent().clickEditUserImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().clickUploadNewImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.verifyHeading(data.get("cropYourImageHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup().verifySaveView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.navigationComponent().verifyBackView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.navigationComponent().verifyCloseView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.navigationComponent().clickBack();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().clickUploadNewImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
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
			merchantProfilePage.userDetailsComponent().clickEditUserImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().clickUploadNewImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.verifyHeading(data.get("cropYourImageHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.uploadSelectImage(data.get("folderName"), data.get("fileName"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup().clickSave();
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
			merchantProfilePage.userDetailsComponent().clickEditUserImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().clickRemove();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.verifyHeading(data.get("removeProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.clickRemoveImage();
			Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
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
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			;
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
//			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent().fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expEditPhoneNumberHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSend();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen(data.get("headingNewPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().authyComponent().fillInput(data.get("code"));
			Thread.sleep(3000);
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().authyComponent().fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
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

			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			;
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
//			customerProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent().fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expEditPhoneNumberHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSend();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen(data.get("headingNewPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
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
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.validateAuthyField(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyNewPhoneField(data.get("expNewPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("number"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifySendCodeButtonEnabled();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSend();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("expHeadingCurrentNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyMultipleResend();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput("code");
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen("expNewPhoneNumberHeading");
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
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
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();

			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.navigationComponent().clickBack();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyPageHeadingWithValidCode(data.get("expHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen(data.get("expNewPhoneNumberHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
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
			merchantProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			// Authentication
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().verifyEditEmailAddressAuthentication(data.get("authiHeading"));
			// Edit Email Address Authentication-Close Navigation
			merchantProfilePage.userDetailsComponent().navigationComponent().verifyCloseView();
			merchantProfilePage.userDetailsComponent().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
			// Edit Email Address -Close Navigation
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().authyComponent().fillInput(data.get("code"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().navigationComponent().verifyCloseView();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
			// Current Email Address-Back Navigation Back
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().authyComponent().fillInput(data.get("code"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyCurrentEmailAddressHeading(data.get("currentEmailHeading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.navigationComponent().verifyBackView();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.navigationComponent().clickBack();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
			// Verify New Email Address -Navigation back
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			Thread.sleep(10000);
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.authyComponent().fillInput(data.get("fillPinEmail"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
//			// Thread.sleep(3000);
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().fillNewEmailAddress(data.get("newEmailAddress"));
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
//			Thread.sleep(3000);
//			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().verifyCurrentEmailAddressHeading(data.get("currentEmailHeading"));
//		    customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().authyComponent().fillInput(data.get("fillPinEmail"));
			Thread.sleep(2000);
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().verifyNewEmailAddress(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().authyComponent().fillInput(data.get("fillPinNewEmail"));

			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().navigationComponent().verifyBackView();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().navigationComponent().clickBack();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.authyComponent().fillInput(data.get("fillPinEmail"));
			Thread.sleep(3000);
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().navigationComponent().verifyCloseView();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();

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
			merchantProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().verifyEditEmailAddressAuthentication(data.get("authiHeading"));
			merchantProfilePage.changePasswordPage().authyComponent().fillInput(data.get("code"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			// customerProfilePage.userDetailsComponent().authyComponent().verifyMessage(data.get("message"));

			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
			// customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyOldEmailAddress();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyCurrentEmailAddressHeading(data.get("currentEmailHeading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyCurrentEmail(data.get("currentEmail"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.authyComponent().fillInput(data.get("fillPinEmail"));
			// customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().authyComponent().verifyMessage(data.get("message"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().verifyNewEmailAddress(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().verifyNewEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().authyComponent().fillInput(data.get("fillPinNewEmail"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
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
			merchantProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().verifyEditEmailAddress(data.get("heading"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.changePasswordPage().authyComponent().fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().verifyEditEmailAddress(data.get("heading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyOldEmailAddress();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
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
			merchantProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().verifyEditEmailAddress(data.get("heading"));
			if (!data.get("code").isEmpty()) {
				merchantProfilePage.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
			}
			if (!data.get("errorMessage").isEmpty()) {
				Thread.sleep(4000);
				merchantProfilePage.authyComponent().verifyMessage(data.get("errorMessage"));
			}
			Thread.sleep(2000);
			merchantProfilePage.authyComponent().verifyLoginWithInvalidPin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void editAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantProfilePage.userDetailsComponent().clickIconEditAddress();
			merchantProfilePage.userDetailsComponent().mailingAddressComponent().fillAddress1(data.get("address1"));
			merchantProfilePage.userDetailsComponent().mailingAddressComponent().fillAddress2(data.get("address2"));
			merchantProfilePage.userDetailsComponent().mailingAddressComponent().fillCity(data.get("city"));
			merchantProfilePage.userDetailsComponent().mailingAddressComponent().selectState(data.get("state"));
			merchantProfilePage.userDetailsComponent().mailingAddressComponent().fillZipCode(data.get("zipcode"));
			merchantProfilePage.userDetailsComponent().mailingAddressComponent().verifyCountry("");
			merchantProfilePage.userDetailsComponent().mailingAddressComponent().clickSave();
			merchantProfilePage.toastComponent().verifyToast("", "");
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
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			Thread.sleep(2000);
			merchantProfilePage.userDetailsComponent().notificationsComponent().verifyDateFormatInNotifications();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Notifications is failed due to Exception " + e);
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
			String uiCount = merchantProfilePage.userDetailsComponent().notificationsComponent().getUiCount();
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
	public void testNotificationsDelete() {
		try {
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			merchantProfilePage.userDetailsComponent().notificationsComponent().verifyCursorNotifications();
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickDelete();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationsDelete is failed due to Exception " + e);
		}

	}

	@Test
	// @Parameters({ "strParams" })
	public void testClearAllNotifications() {
		try {
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickClearAll();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Clear all Notifications failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			// topBarComponent.userNameDropDownComponent().clickDropDown();
			topBarComponent.userNameDropDownComponent().clickAgreements();
			merchantProfilePage.agreementsPage().verifyHeading(data.get("heading"));
//			merchantProfilePage.agreementsPage().clickTermsOfServices();
//			merchantProfilePage.agreementsPage().getTermsOfService();
//			merchantProfilePage.agreementsPage().verifyDownloadPDFlnk();
//			merchantProfilePage.agreementsPage().clickOnAgreements();
//			merchantProfilePage.agreementsPage().clickPrivacyPolicy();
//			merchantProfilePage.agreementsPage().getPrivacyPolicy();
//			merchantProfilePage.agreementsPage().verifyDownloadPDFlnk();
//			merchantProfilePage.agreementsPage().clickOnAgreements();
			Thread.sleep(3000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPreferences is failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			// topBarComponent.userNameDropDownComponent().clickDropDown();
			topBarComponent.userNameDropDownComponent().clickPreferences();
			// merchantProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));
			Thread.sleep(3000);
//			merchantProfilePage.preferencesPage().selectDefaultAccount(data.get("defaultAccount"));
//
//			merchantProfilePage.preferencesPage().clickSave();
//			merchantProfilePage.preferencesPage().verifyLabelSuccessMessage();

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
			topBarComponent.clickUserNameDrpDwn();
			// topBarComponent.userNameDropDownComponent().clickUserName();
			topBarComponent.userNameDropDownComponent().clickPreferences();
			// merchantProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));
			// merchantProfilePage.preferencesComponent().verifyTimeZoneView();
			// merchantProfilePage.preferencesComponent().verifyPSTTickMark();
			// data.get("expCssProp"));

			// customerProfilePage.preferencesComponent().verifyDefautAccountTickMark();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testPreferencesDisplayed is failed due to Exception " + e);
		}

	}

	@Test // added M
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			topBarComponent.clickUserNameDrpDwn();
			Thread.sleep(2000);
			topBarComponent.userNameDropDownComponent().clickChangePassword();
			Thread.sleep(2000);
			merchantProfilePage.changePasswordPage().authyComponent().fillInput(data.get("code"));
			merchantProfilePage.changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			merchantProfilePage.changePasswordPage().fillNewPassword(data.get("newPassword"));
			merchantProfilePage.changePasswordPage().clickIcon();
			merchantProfilePage.changePasswordPage().fillConfirmNewPassword(data.get("confirmPassword"));
			merchantProfilePage.changePasswordPage().clickSave();
			Thread.sleep(3000);
			// customerProfilePage.changePasswordComponent().verifyContaint(data.get("successContent"));
			// homePage.verifyLandingPageHeading(data.get("createHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test change password failed due to exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testChangePasswordInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantMenuComponent.clickUserName();
			merchantMenuComponent.clickUserDetails();
			Thread.sleep(1000);
			merchantMenuComponent.clickChangePassword();
			Thread.sleep(1000);
			merchantProfilePage.changePasswordPage().verifyAuthyHeading(data.get("heading"));
			// customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			merchantProfilePage.changePasswordPage().authyComponent().fillInput(data.get("code"));
			merchantProfilePage.changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			merchantProfilePage.changePasswordPage().clickIcon();
			merchantProfilePage.changePasswordPage().viewCurrentPassword();
			merchantProfilePage.changePasswordPage().fillNewPassword(data.get("newPassword"));
			merchantProfilePage.changePasswordPage().fillConfirmNewPassword(data.get("confirmPassword"));
			merchantProfilePage.changePasswordPage().clickTab();
			// customerProfilePage.changePasswordComponent().clickSave();
			Thread.sleep(3000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
//						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test change password with invalid  credentials failed due to exception " + e);
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
//			merchantProfilePage.preferencesPage().selectTimeZone(data.get("timeZone"));

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
			merchantMenuComponent.clickUserName();
			Thread.sleep(1000);
			merchantMenuComponent.clickChangePassword();
			merchantProfilePage.changePasswordPage().verifyAuthyHeading(data.get("heading"));
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

}
