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
import coyni.customer.pages.CustomerProfilePage;
import coyni.customer.pages.NavigationMenuPage;
import coyni.customer.pages.TokenAccountPage;
import coyni.customer.popups.EditEmailAddressPopup;
import coyni.customer.popups.EditPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CustomerProfileTest {
	CustomerProfilePage customerProfilePage;
	NavigationMenuPage navigationMenuPage;
	EditPhoneNumberPopup editPhoneNumberPopup;
	EditEmailAddressPopup editEmailAddressPopup;
	CustomerMenuComponent customerMenuComponent;
	AuthyComponent authyComponent;
	ChangePasswordComponent changePasswordComponent;
	TokenAccountPage tokenAccountPage;

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
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().verifyRemoveImageView();
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
			customerProfilePage.userDetailsComponent().clickEditUserImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().clickUploadNewImage();
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.verifyHeading(data.get("cropYourImageHeading"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.uploadSelectImage(data.get("folderName"), data.get("fileName"));
			customerProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup().clickSave();
			Thread.sleep(500);
			if (!data.get("toastMessage").isEmpty()) {
				customerProfilePage.toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}

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

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.userDetailsComponent().clickIconEditPhNum();
			String securityKey = data.get("securityKey");
			customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(securityKey);
			String newNumber = data.get("newNumber");
			editPhoneNumberPopup.fillNewNumber(newNumber);
			editPhoneNumberPopup.clickSendCode();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Edit Phone Number failed due to Exception" + e);

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
			customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			//customerProfilePage.userDetailsComponent().authyComponent().verifyMessage(data.get("message"));
	        customerProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyOldEmailAddress();
			customerProfilePage.userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
		    customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyCurrentEmailAddressHeading(data.get("currentEmailHeading"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyCurrentEmail(data.get("currentEmail"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().authyComponent().fillInput(data.get("fillPinEmail"));
			//customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().authyComponent().verifyMessage(data.get("message"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().verifyNewEmailAddressPopUp().verifyNewEmailAddress(data.get("newEmailHeading"));
			 customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().verifyNewEmailAddressPopUp().verifyNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().verifyNewEmailAddressPopUp().authyComponent().fillInput(data.get("fillPinNewEmail"));
			customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().verifyNewEmailAddressPopUp().authyComponent().verifyMessage(data.get("message"));
            customerProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup().verifyNewEmailAddressPopUp().successFailurePopupCardComponent().verifyEmailAddressChanged(data.get("emailAddressChanged"));

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
			customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
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
	// @Parameters({ "strParams" })

	public void testNotifications() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			// customerProfilePage.userDetailsComponent().notificationsComponent()
			// .verifyBellIconMouseHoverAction(data.get("background"), strParams);
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			// customerProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsCount();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Notifications is failed due to Exception " + e);
		}
	}

	// added p
//	@Test
//	public void testNotificationsViewPayAndDeny() {
//
//		try {
//			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
//			customerProfilePage.userDetailsComponent().notificationsComponent().verifyPay();
//			customerProfilePage.userDetailsComponent().notificationsComponent().verifyDeny();
//
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport(" testNotificationsViewPayAndDeny is failed due to Exception " + e);
//		}
//
//	}

	// added p
	@Test
	public void testNotificationsPay() {
		try {
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickPay();
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyLabelPayMessage();
			customerProfilePage.userDetailsComponent().notificationsComponent().authyComponent()
					.fillAuthyInput("securityKey");
			customerProfilePage.userDetailsComponent().notificationsComponent().verifyDeny();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testPay is failed due to Exception " + e);
		}
	}

//added
	@Test
	public void testNotificationsDeny() {
		try {
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickDeny();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testDeny is failed due to Exception " + e);
		}

	}

//added
	@Test
	public void testNotificationsReminder() {
		try {
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			// customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickReminder();
			// customerProfilePage.userDetailsComponent().notificationsComponent().clickDelete();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testRemove is failed due to Exception " + e);
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
	public void testNotificationsClearAll() {
		try {
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			customerProfilePage.userDetailsComponent().notificationsComponent().clickClearAll();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testRemove is failed due to Exception " + e);
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

	@Test // added
	@Parameters({ "strParams" })
	public void testPreferencesSelectTimeZone(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.userNameDropDownComponent().clickUserName();
			tokenAccountPage.userNameDropDownComponent().clickPreferences();
			customerProfilePage.preferencesComponent().verifyPreferencesBackGroundColor(data.get("cssProp"),
					data.get("expValue"), data.get("expColor"));
			customerProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testPreferencesSelectTimeZone is failed due to Exception " + e);
		}

	}

	@Test // added M
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerMenuComponent.clickUserName();
			Thread.sleep(1000);
			customerMenuComponent.clickChangePassword();
			customerProfilePage.changePasswordComponent().verifyAuthyHeading(data.get("heading"));
			customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			// customerProfilePage.changePasswordComponent().verifyHeading("heading1");
			customerProfilePage.changePasswordComponent().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordComponent().fillNewPassword(data.get("newPassword"));
			customerProfilePage.changePasswordComponent().clickIcon();
			customerProfilePage.changePasswordComponent().fillConfirmNewPassword(data.get("confirmPassword"));
			customerProfilePage.changePasswordComponent().clickSave();
//			if (!data.get("successMsg").isEmpty()) {
//				customerProfilePage.changePasswordComponent().verifyUpdatePassword(data.get("successMsg"));
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test change password failed due to exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testChangePasswordInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerMenuComponent.clickUserName();
			Thread.sleep(1000);
			customerMenuComponent.clickChangePassword();
			customerProfilePage.changePasswordComponent().verifyAuthyHeading(data.get("heading"));
			customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			customerProfilePage.changePasswordComponent().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordComponent().fillNewPassword(data.get("newPassword"));
			customerProfilePage.changePasswordComponent().fillConfirmNewPassword(data.get("confirmPassword"));
			customerProfilePage.changePasswordComponent().clickTab();

			// customerProfilePage.changePasswordComponent().clickSave();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test change password with invalis  credentials failed due to exception " + e);
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
			//customerProfilePage.changePasswordComponent().authyComponent().fillpin(data.get("code"));
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
