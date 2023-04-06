package coyni.merchant.tests;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.MerchantMenuComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.components.TopBarComponent;
import coyni.merchant.pages.ChangePasswordPage;
import coyni.merchant.pages.HomePage;
import coyni.merchant.pages.LoginPage;
import coyni.merchant.pages.MerchantProfilePage;
import coyni.merchant.pages.SignupPage;
import coyni.merchant.pages.TokenAccountPage;
import coyni.merchant.popups.EditEmailAddressPopup;
import coyni.merchant.popups.EditPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantProfileTest {
	MerchantProfilePage merchantProfilePage;
	SideMenuBarComponent sideMenuBarComponent;
	SignupPage signupPage;
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
		sideMenuBarComponent = new SideMenuBarComponent();
		signupPage = new SignupPage();
		topBarComponent = new TopBarComponent();
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
	public void testUserDetailsLinks(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			topBarComponent.userNameDropDownComponent().clickMerchantAccounts();
			merchantProfilePage.merchantAccountsPage().verifyHeading(data.get("heading"));
			topBarComponent.userNameDropDownComponent().clickPreferences();
			merchantProfilePage.preferencesPage().verifyHeading(data.get("preferencesHeading"));
			topBarComponent.userNameDropDownComponent().clickAgreements();
			merchantProfilePage.agreementsPage().verifyHeading(data.get("agreementsHeading"));
			topBarComponent.userNameDropDownComponent().clickChangePassword();
			merchantProfilePage.changePasswordPage().verifyHeading(data.get("changePasswordHeading"));
			topBarComponent.userNameDropDownComponent().clickTwoStepAuthentication();
			merchantProfilePage.twoStepAuthenticationPage().verifyHeading(data.get("twoStepAuthenticationHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testUserDetailsLinks failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetailsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().verifyEditImageView();
			merchantProfilePage.userDetailsComponent().verifyUserNameView();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
			merchantProfilePage.userDetailsComponent().verifyEditImageView();
			merchantProfilePage.userDetailsComponent().verifyAccountIdView();
			merchantProfilePage.userDetailsComponent().verifyAccountStatusView();
			merchantProfilePage.userDetailsComponent().verifyAccountStatus(data.get("status"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test User Details view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditImageView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().verifyEditImageView();
			merchantProfilePage.userDetailsComponent().clickEditUserImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().verifyUploadImageView();
//			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().navigationComponent()
//					.verifyCloseView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().navigationComponent().clickClose();
//			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
			// RemoveProfile-Back and Close Navigation
			merchantProfilePage.userDetailsComponent().clickEditUserImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().clickRemove();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.verifyHeading(data.get("removeProfileHeading"));
//			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
//					.verifyRemoveView();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().removeProfileImagePopup()
					.navigationComponent().clickBack();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
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
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
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
			Thread.sleep(5000);

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("testUserDetailsAddImage failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetailsAddImageMore(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			Thread.sleep(2000);
			merchantProfilePage.userDetailsComponent().clickEditUserImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup()
					.verifyHeading(data.get("accountProfileHeading"));
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().clickUploadNewImage();
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.verifyHeading(data.get("cropYourImageHeading"));
			
			merchantProfilePage.userDetailsComponent().accountProfileImagePopup().cropYourImagePopup()
					.uploadSelectImage(data.get("folderName"), data.get("fileName"));
			
			
			if (!data.get("toastMessage").isEmpty()) {
				merchantProfilePage.toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
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
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
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
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSendCode();
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
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			if (!data.get("code").isEmpty()) {
				merchantProfilePage.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
			}
			if (!data.get("errorMessage").isEmpty()) {
				Thread.sleep(4000);
				merchantProfilePage.authyComponent().verifyMessage(data.get("errorMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testEditPhoneNumberWithValidData is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumberWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
			Thread.sleep(2000);
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			if (!data.get("errorMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

			}
			new CommonFunctions().validateFormErrorMessage(data.get("errorMessage"), data.get("colour"),
					data.get("elementName"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testEditPhoneNumberWithInvalidCode is failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })

	public void testEditPhoneNumberWithBackNavigation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup()
					.verifyAuthyEditPhoneHeading(data.get("authyEditPhoneHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSendCode();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.navigationComponent().clickBack();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSendCode();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().authyComponent()
					.fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().fillNewNumber(data.get("expNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSendCode();
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyCurrentPhoneNumberHeading(data.get("headingCurrentPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.authyComponent().fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().verifyNewPhoneNumberScreen(data.get("headingNewPhoneNumber"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().verifyCurrentPhoneNumberPopup()
					.verifyNewPhoneNumberPopup().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testEditPhoneNumberVerificationCodeWithInvalidCode is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumberWithResendVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberIconView();
			merchantProfilePage.userDetailsComponent().verifyEditPhoneNumberScreen(data.get("authyEditPhoneHeading"));
			merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().clickSMSCode();
			for (int i = 0; i <= 4; i++) {
				Thread.sleep(3000);
				merchantProfilePage.userDetailsComponent().editPhoneNumberPopup().phoneVerificationComponent()
						.clickOnResendCode();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
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
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().navigationComponent().verifyCloseView();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().navigationComponent().clickClose();
			merchantProfilePage.userDetailsComponent().verifyUserDetailsView();
			// Current Email Address-Back Navigation Back
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().authyComponent().fillInput(data.get("code"));
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
					.authyComponent().fillInput(data.get("code"));
			Thread.sleep(2000);
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().verifyNewEmailAddress(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().authyComponent().fillInput(data.get("code"));

			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().navigationComponent().verifyBackView();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().navigationComponent().clickBack();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.authyComponent().fillInput(data.get("code"));
			Thread.sleep(3000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			Thread.sleep(5000);
			merchantProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().verifyEditEmailAddressAuthentication(data.get("authiHeading"));
			merchantProfilePage.changePasswordPage().authyComponent().fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
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
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().verifyNewEmailAddress(data.get("newEmailHeading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().verifyNewEmail(data.get("newEmail"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
					.verifyNewEmailAddressPopUp().authyComponent().fillInput(data.get("fillPinNewEmail"));
//			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().verifyCurrentEmailAddressPopup()
//					.verifyNewEmailAddressPopUp().authyComponent().verifyMessage(data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailWithResendVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickSMSCode();
			for (int i = 0; i <= 4; i++) {
				Thread.sleep(3000);
				merchantProfilePage.userDetailsComponent().editEmailAddressPopup().phoneVerificationComponent()
						.clickOnResendCode();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			merchantProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
			merchantProfilePage.changePasswordPage().authyComponent().fillInput(data.get("code"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.verifyEditEmailAddress(data.get("heading"));
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup()
					.fillNewEmailAddress(data.get("newEmailAddress"));
			Thread.sleep(2000);
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickTab();
			merchantProfilePage.userDetailsComponent().editEmailAddressPopup().clickSendCode();

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
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickUserDetails();
			Thread.sleep(5000);
			merchantProfilePage.userDetailsComponent().verifyEmail(data.get("verifyEmail"));
			merchantProfilePage.userDetailsComponent().clickIconEditEmail();
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
	public void testLogout(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().verifyUserDetails();
			topBarComponent.userNameDropDownComponent().clickSignOut();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLogout is failed due to Exception " + e);
		}
	}

	@Test
	// @Parameters({ "strParams" })
	public void testNotifications() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			merchantProfilePage.userDetailsComponent().notificationsComponent().verifyDateFormatInNotifications();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Notifications is failed due to Exception " + e);
		}
	}

	@Test
	public void testNotificationsDelete() {
		try {
			Thread.sleep(4000);
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			// merchantProfilePage.userDetailsComponent().notificationsComponent().verifyCursorNotifications();
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickDelete();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationsDelete is failed due to Exception " + e);
		}

	}

	@Test
	public void testClearAllNotifications() {
		try {
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			merchantProfilePage.userDetailsComponent().notificationsComponent().clickClearAll();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationsDelete is failed due to Exception " + e);
		}

	}

	@Test // added
	@Parameters({ "strParams" })
	public void testMerchantAccounts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickMerchantAccounts();
			merchantProfilePage.merchantAccountsPage().verifyHeading(data.get("heading"));
			merchantProfilePage.merchantAccountsPage().clickSettings();
			merchantProfilePage.merchantSettingsPage().merchantSettingsSideBarMenuComponent().companyInformationPage()
					.verifyCompanyInformationLbl();
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickMerchantAccounts();
			merchantProfilePage.merchantAccountsPage().clickGoToMerchant();
			sideMenuBarComponent.clickMerchantdrpdwn();
			sideMenuBarComponent.clickMerchantAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantAccounts is failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testLeaveAccounts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickMerchantAccounts();
			merchantProfilePage.merchantAccountsPage().clickDelete();
			merchantProfilePage.merchantAccountsPage().leaveMerchantAccountPopup().verifyHeading(data.get("heading"));
			merchantProfilePage.merchantAccountsPage().leaveMerchantAccountPopup().clickNoGoBack();
			merchantProfilePage.merchantAccountsPage().clickDelete();
			merchantProfilePage.merchantAccountsPage().leaveMerchantAccountPopup().clickLeaveAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantAccounts is failed due to Exception " + e);
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
			ExtentTestManager.setFailMessageInReport("testAgreements is failed due to Exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickPreferences();
			Thread.sleep(3000);
//			merchantProfilePage.preferencesPage().selectDefaultAccount(data.get("defaultAccount"));

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
			topBarComponent.userNameDropDownComponent().clickPreferences();
			merchantProfilePage.preferencesPage().selectDefaultAccount(data.get("defaultAccount"));
			sideMenuBarComponent.clickUserdrpdwn();
			sideMenuBarComponent.clickPersonalAccount();
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickPreferences();
			merchantProfilePage.preferencesPage().selectDefaultAccount(data.get("defaultAccount1"));
			sideMenuBarComponent.clickMerchantdrpdwn();
			sideMenuBarComponent.clickMerchantAccount();
			Thread.sleep(3000);
			signupPage.tokenAccountPage().clickTokenAccount();
			signupPage.tokenAccountPage().verifyHeading(data.get("heading"));

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
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test change password failed due to exception " + e);
		}
	}

	@Test
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
			merchantProfilePage.changePasswordPage().authyComponent().fillInput(data.get("code"));
			merchantProfilePage.changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			merchantProfilePage.changePasswordPage().clickIcon();
			merchantProfilePage.changePasswordPage().viewCurrentPassword();
			merchantProfilePage.changePasswordPage().fillNewPassword(data.get("newPassword"));
			merchantProfilePage.changePasswordPage().fillConfirmNewPassword(data.get("confirmPassword"));
			merchantProfilePage.changePasswordPage().clickTab();
			Thread.sleep(3000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
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
	public void testTwoStepAuthentication(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(4000);
			topBarComponent.clickUserNameDrpDwn();
			topBarComponent.userNameDropDownComponent().clickTwoStepAuthentication();
			merchantProfilePage.twoStepAuthenticationPage().clickReconfigure();
			merchantProfilePage.twoStepAuthenticationPage().phoneVerificationComponent().fillpin(data.get("code"));
			merchantProfilePage.twoStepAuthenticationPage().reConfigturationTwoStepAuthenticationPage()
					.clickManualEntry();
			merchantProfilePage.twoStepAuthenticationPage().reConfigturationTwoStepAuthenticationPage()
					.fillpin(data.get("code1"));
			merchantProfilePage.twoStepAuthenticationPage().getMessage();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTwoStepAuthentication failed due to exception " + e);
		}
	}

}
