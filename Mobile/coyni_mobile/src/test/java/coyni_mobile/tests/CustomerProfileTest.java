package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.pages.TokenAccountPage;
import coyni_mobile.pages.UserDetailsPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class CustomerProfileTest {

	CustomerProfilePage customerProfilePage;
	UserDetailsPage userDetailsPage;
	TokenAccountPage tokenAccountPage;
	NavigationComponent navigationComponent;

	@BeforeTest
	public void init() {
		customerProfilePage = new CustomerProfilePage();
		userDetailsPage = new UserDetailsPage();
		tokenAccountPage = new TokenAccountPage();
		navigationComponent = new NavigationComponent();
		// DriverFactory.getDriver().resetApp();
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfile(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyProfilePageView();
			customerProfilePage.verifyAccountIDView();
			customerProfilePage.verifyAccountStatusView();
			customerProfilePage.verifyQRImageView();
			customerProfilePage.verifyAccountID(data.get("accountID"));
			customerProfilePage.verifyAccountStatus(data.get("accountStatus"));
			customerProfilePage.verifyUserName(data.get("profileUser"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileView failed due to exception " + e);
		}
	}

	////////// 2.3 ////////////
	@Test
	@Parameters({ "strParams" })
	public void testAddAddressFromDashboard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.mailingAddressComponent().tokenAccountPage().addNewPaymentComponent()
					.verifyPaymentHeading() == 1) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().tokenAccountPage().addNewPaymentComponent().verifyAddPaymentView();
			} else {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().tokenAccountPage().clickAddAddress();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine2(data.get("addreddLine2"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillCity(data.get("city"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().selectState(data.get("state"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
				Thread.sleep(2000);
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.verifyCountryName(data.get("countryName"));
				// add address button
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickAddAddress();
				// verify address
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().verifyAddressAdded(data.get("addressAddedPage"));
				// click done button
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickDone();
				customerProfilePage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().tokenAccountPage().verifyBuyTokenView();

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddAddress failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddAddressFromUserDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
//					.verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addressLine1"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addreddLine2"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.selectState(data.get("state"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.verifyCountryName(data.get("countryName"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().clickSave();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().verifySuccess(data.get("successHeading"), data.get("successContent"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.verifyAddressAdded(data.get("addressAddedPage"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickDone();
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddAddress failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyUserDetailsView();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyUserName(data.get("userNameText"));
			customerProfilePage.userDetailsPage().verifyExistingEmail(data.get("existingEmail"));
			customerProfilePage.userDetailsPage().verifyExistingPhoneNumber(data.get("existingPhone"));
			customerProfilePage.userDetailsPage().verifyAddress(data.get("existingAddress"));
			customerProfilePage.userDetailsPage().navigationComponent().clickClose();
			customerProfilePage.clickLogOut();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test user details failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetailsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyUserNameView();
			customerProfilePage.verifyAccountIDView();
			customerProfilePage.verifyAccountStatusView();
			customerProfilePage.verifyUserDetailsView();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().verifyEditUserImageView();
			customerProfilePage.userDetailsPage().navigationComponent().verifyBackView();
			customerProfilePage.userDetailsPage().navigationComponent().clickBack();
			customerProfilePage.verifyProfilePageView();
			// customerProfilePage.clickLogOut();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test user details view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditImageView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditUserImage();
			customerProfilePage.userDetailsPage().editUserImagePopup().verifyChooseFromLibraryView();
			customerProfilePage.userDetailsPage().editUserImagePopup().verifyTakeAPhotoView();
			customerProfilePage.userDetailsPage().editUserImagePopup().clickChooseFromLibrary();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testEditImageView failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));

			// Navigation User Details-Enter Your Pin
			customerProfilePage.userDetailsPage().clickEditEmail();
			// customerProfilePage.userDetailsPage().verifyCurrentEmailHeading(data.get(""));
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().clickBack();
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();

			// Navigation user Details -Verify New Email
			customerProfilePage.userDetailsPage().clickEditEmail();
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyCurrentEmail(data.get("email"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyCurrentEmailHeading(data.get("currentEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyCurrentEmail(data.get("currEmailText"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyResendView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyGetCodeLabelView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyDontHaveAccessView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyContactUsView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickContactUs(data.get("contactUs"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyNewEmailHeading(data.get("newEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyNewEmail(data.get("newEmailText"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyResendView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyGetCodeLabelView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.navigationComponent().verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEditEmailPageView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().navigationComponent()
					.verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().navigationComponent()
					.clickBack();
			customerProfilePage.userDetailsPage().verifyCurrentEmailHeading(data.get("currEmailHeading"));
			customerProfilePage.userDetailsPage().clickBack();
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Email view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditEmail();
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyCurrentEmail(data.get("email"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyDontHaveAccessView();
			// customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyContactUsView();
			 customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickContactUs(data.get("contactUs"));
			 customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().navigationComponent()
			 .clickBack();
			Thread.sleep(2000);
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyNewEmailHeading(data.get("newEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.successFailureComponent().verifyEmailSuccessHeading(data.get("emailContent"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.successFailureComponent().clickLogOut();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Email failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditEmail();
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyCurrentEmail(data.get("email"));
			String[] newEmail = data.get("newEmail").split(",");
			customerProfilePage.fieldValidationsComponent().validateEmailField(newEmail[0], newEmail[1], newEmail[2]);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Email failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditEmail();
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			// customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickOk();
			if (!data.get("popUpMsg").isEmpty()) {
				// loginPage.ViewCoyni();
				customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
						.verifyPopupMsg(data.get("popUpMsg"));
				Thread.sleep(1000);
				customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickOk();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Email with invalid data failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumberView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyPhoneNumberTitleView();
			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
//			.verifyHeading(data.get("editphoneHeading"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
//					.verifyCurrentPhoneNumber(data.get("phoneNumber"));		
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.fillNewPhoneNumber(data.get("newPhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhoneHeading(data.get("currentPhoneHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhone(data.get("currPhoneContent"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyResendView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyDontHaveAccessView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyContactUsView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent()
					.verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent()
					.clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyEditPhonePageView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent()
					.verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent()
					.clickBack();
//			customerProfilePage.userDetailsPage().verifyCurrentPhoneNumHeading(data.get("currentPhoneHeading"));
			customerProfilePage.userDetailsPage().clickBack();
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();

//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
//					.fillNewPhoneNumber(data.get("newPhoneNumber"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
//					.navigationComponent().clickBack();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
//					.verifyCurrentPhoneHeading(data.get("currentPhoneHeading"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
//					.verifyCurrentPhone(data.get("PhoneNumber"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit PhoneNumber view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.fillNewPhoneNumber(data.get("newPhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickContactUs(data.get("contactUs"));
			 customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().navigationComponent()
			 .clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhoneHeading(data.get("currentPhoneHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhone(data.get("currPhoneContent"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyNewPhoneHeading(data.get("newPhoneHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyNewPhone(data.get("newPhoneContent"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.toastComponent().verifyToastMsg(data.get("toastMsg"));
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit PhoneNumber view failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testEditPhoneNumberSaveDisabled(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickProfile();
//			customerProfilePage.clickUserDetails();
//			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
//			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
//			customerProfilePage.userDetailsPage().clickChange();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
//					.fillNewPhoneNumber(data.get("newPhoneNumber"));
//			
//			
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Test Edit PhoneNumber view failed due to exception " + e);
//		}
//	}
	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumberFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			String[] newPhoneNumber = data.get("newPhoneNumber").split(",");
			customerProfilePage.fieldValidationsComponent().validatePhoneNumberField(newPhoneNumber[0],
					newPhoneNumber[1], newPhoneNumber[2]);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit PhoneNumber validation failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditAddressView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyAddressTitleView();
			customerProfilePage.userDetailsPage().verifyExistingAddressView();
			customerProfilePage.userDetailsPage().verifyEditAddressArrowView();
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
					.verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyAddressLine1View();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyAddressLine2View();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyCityView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyStateView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyZipCodeView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().navigationComponent()
					.clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Address view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
					.verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addLine1"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addline2"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.selectState(data.get("state"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillZipCode(data.get("zipcode"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().clickSave();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().verifySuccess(data.get("successHeading"), data.get("successContent"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().toastComponent()
					.verifyToastMsg(data.get("toastMsg"));
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Address failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditAddressWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			Thread.sleep(2000);
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
					.verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addLine1"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addline2"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillZipCode(data.get("zipcode"));
			if (!data.get("errMessage").isEmpty()) {

				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Test Edit Address with invalid data failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditAddressWithFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			Thread.sleep(2000);
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
					.verifyHeading(data.get("editAddrHeading"));
			String[] addLine1 = data.get("addLine1").split(",");
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fieldValidationsComponent().validateAddressLine1Field(addLine1[0], addLine1[1], addLine1[2]);
			String[] addline2 = data.get("addline2").split(",");
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fieldValidationsComponent().validateAddressLine1Field(addline2[0], addline2[1], addline2[2]);
			String[] city = data.get("city").split(",");
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fieldValidationsComponent().validateCityField(city[0], city[1], city[2]);
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.selectState(data.get("state"));
			String[] zipcode = data.get("zipcode").split(",");
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fieldValidationsComponent().validateZipCodeField(zipcode[0], zipcode[1], zipcode[2]);
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" testEditAddressWithFieldValidation failed due to exception " + e);
		}
	}

	// added
	@Test
	@Parameters({ "strParams" })
	public void testCustomerProfileView(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyImageUserView();
			customerProfilePage.verifyUserNameView();
			customerProfilePage.verifyAccountIDView();
			customerProfilePage.verifyAccountStatusView();
			customerProfilePage.clickQRImage();
			customerProfilePage.verifyMyQRCodeHeading(data.get("qrHeading"));
			customerProfilePage.verifyFirstAndLastName(data.get("expHeading"));
			customerProfilePage.verifyLabelMyQRCodeView();
			customerProfilePage.clickOnCopy();
			Thread.sleep(1000);
			customerProfilePage.clickShare();
//			Thread.sleep(1000);
//			customerProfilePage.verifyPopUp();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("TestCustomerProfileView failed due to exception " + e);
		}

	}

	// Ios M
	@Test
	@Parameters({ "strParams" })
	public void testDashboard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.verifyUserName(data.get("userName"));
			customerProfilePage.verifyAvaliableBlc(data.get("avaliableBalance"));
			customerProfilePage.verifyRecentTransaction(data.get("recentHeading"));
			customerProfilePage.clickImg();
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.verifyFirstAndLastName(data.get("firstAndLastName"));
			customerProfilePage.viewDashboard();
			customerProfilePage.viewIssueCard();
			customerProfilePage.viewProfile();
			customerProfilePage.clickCrypto();
			customerProfilePage.clickViewMore();
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.clickTokenMenu();
			customerProfilePage.viewScan();
			customerProfilePage.viewPayRequest();
			customerProfilePage.viewBuyToken();
			customerProfilePage.viewWithdrawnToUSD();
			customerProfilePage.minimizePopupBySwipeDown();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Verify DashBoard Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddPaymentMethodTwoDotThree(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// customerProfilePage.tokenAccountPage()

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Verify DashBoard Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDashboardTabBarMenu(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.viewDashboard();
			customerProfilePage.viewProfile();
			customerProfilePage.clickProfile();
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.verifyAvailableBalance();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDashboardTabBarMenu Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFaceIDSettings(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.viewDashboard();
			customerProfilePage.clickProfile();
			customerProfilePage.clickTogggle();
			customerProfilePage.setUpTouchIDPopup().verifyHeading(data.get("expHeading"));
			customerProfilePage.setUpTouchIDPopup().verifyDescription(data.get("popUpDescription"));
			customerProfilePage.setUpTouchIDPopup().clickSetUpTouchID();
			customerProfilePage.setUpTouchIDPopup().clickBackButton();
			customerProfilePage.clickTogggle();
			customerProfilePage.setUpTouchIDPopup().clickNotNow();
			customerProfilePage.clickLogOut();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFaceIDSettings Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyPreferencesView();
			customerProfilePage.clickPreferences();
			customerProfilePage.preferencesComponent().verifyPreferencesHeading(data.get("heading"));
			// for (int i = 0; i <= 5; i++) {
			customerProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone1"));
			// }
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyAccountLimitsView();
			customerProfilePage.clickAccountLimits();
			customerProfilePage.accountLimitsComponent().verifyHeading(data.get("expHeading"));
			customerProfilePage.accountLimitsComponent().verifyPayRequestLabel(data.get("expPayRequestHeading"));
			customerProfilePage.accountLimitsComponent().verifyBuyTokensLabel(data.get("expBuyTokenHeading"));
			customerProfilePage.accountLimitsComponent().VerifyWithdrawLabel(data.get("expWithdrawHeading"));
			customerProfilePage.accountLimitsComponent().getPayRequestLimit();
			customerProfilePage.accountLimitsComponent().getBuyTokenBankLimit();
			customerProfilePage.accountLimitsComponent().getCardsLimit();
			customerProfilePage.accountLimitsComponent().getWithdrawBankLimit();
			customerProfilePage.accountLimitsComponent().getInstantPayLimit();
			customerProfilePage.accountLimitsComponent().getGiftCardLimit();
			customerProfilePage.accountLimitsComponent().navigationComponent().verifyBackView();
			customerProfilePage.accountLimitsComponent().navigationComponent().clickBack();
			customerProfilePage.verifyProfilePageView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimits Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyAgreementsView();
			customerProfilePage.clickAgreements();
			customerProfilePage.agreementComponent().verifyHeading(data.get("agreeHeading"));
			customerProfilePage.agreementComponent().verifyActiveAgreementsHeading(data.get("activeAgree"));
			customerProfilePage.agreementComponent().verifyPastAgreementsHeading(data.get("pastAgree"));
			customerProfilePage.agreementComponent().verifyPrivacyPolicyView();
			customerProfilePage.agreementComponent().verifyTermsOfServiceView();
			customerProfilePage.agreementComponent().clickBack();
			customerProfilePage.verifyProfilePageView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAgreements Failed due to exception " + e);

		}
	}

	@Test
	public void testLogOut() {
		try {
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyLogOut();
			Thread.sleep(2000);
			customerProfilePage.clickLogOut();
			customerProfilePage.signUpPage().verifyGetStarted();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLogOut failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBankAccoun(String strParams) {
		try {
			testAddBankAccoun(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddExternalBankAccount  failed due to exception " + e);
		}

	}

	public void testAddBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			// if(data.get("validateAddbank").equalsIgnoreCase("Yes")) {
			customerProfilePage.paymentMethodsPage().verifyPaymentHeading(data.get("paymentHeading"));
			customerProfilePage.paymentMethodsPage().verifyDescription(data.get("description"));
			customerProfilePage.paymentMethodsPage().verifyBankDescription(data.get("bankDescription"));
			// verify 0/4 before adding bank account
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickExternalBankAcount();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.verifyHeading(data.get("bankHeading"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.verifyAccountDescription(data.get("accountDescription"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.verifyCheckBoxDescription(data.get("checkBoxDescription"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.clickCheckBx();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.clickStart();
			// customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().clickSearchInstitution();
			// customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().fillBankName(data.get("bankName"));
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.clickMxOauth();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.verifyMxOauth(data.get("mxOauth"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.clickContinueTesting();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.verifyIdentity(data.get("identity"));
			if (data.get("mxChecking").equalsIgnoreCase("Yes")) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
						.clickMxChecking();
			}
			if (data.get("mxSavings").equalsIgnoreCase("Yes")) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
						.clickMxSavings();
			}
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.clickContinue();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.verifyAccountAdded(data.get("successHeading"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.verifyAccountAddedDes(data.get("successDescription"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.clickDone();
			customerProfilePage.paymentMethodsPage().verifyPayment(data.get("paymentMethod"));
			customerProfilePage.paymentMethodsPage().verifyBankAccount(data.get("account"));

			// customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddExternalBankAccount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			testAddBankAccount(strParams);
		} catch (Exception e) {

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			if (tokenAccountPage.verifyProfile() == 1) {
				tokenAccountPage.clickProfileforPayments();
				customerProfilePage.clickPaymentMethods();
			}
			int numOfBankAccs = customerProfilePage.paymentMethodsPage().verifyNumOfBanks();
			for (int i = 1; i <= numOfBankAccs; i++) {
				customerProfilePage.paymentMethodsPage().verifyPaymentHeading(data.get("paymentHeading"));
				customerProfilePage.paymentMethodsPage().selectBank();
				customerProfilePage.paymentMethodsPage().removingPopup().verifyHeading();
				customerProfilePage.paymentMethodsPage().removingPopup().clickYes();
				customerProfilePage.paymentMethodsPage().removingPopup().toastComponent()
						.verifyToastMsg(data.get("bankDeleteToastMsg"));
			}
//			customerProfilePage.paymentMethodsPage().verifyBankAccounts();

		} catch (Exception e) {

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickChangePassword();
			customerProfilePage.changePasswordPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().clickNext();
			customerProfilePage.changePasswordPage().verifyHeadingChangePassword(data.get("expChangePasswordHeading"));
			customerProfilePage.changePasswordPage().verifyChangePasswordContent(data.get("expChangePasswordContent"));
			customerProfilePage.changePasswordPage().fillNewPassword(data.get("newPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().fillConfirmPassword(data.get("confirmPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().verifyPassword();
			DriverFactory.getDriver().hideKeyboard();
			customerProfilePage.changePasswordPage().clickSave();
			customerProfilePage.changePasswordPage().verifySuccessFailureMessage(data.get("message"));
			customerProfilePage.changePasswordPage().clickLogout();
			tokenAccountPage.signUpPage().verifyGetStarted();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePassword Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickChangePassword();
//			customerProfilePage.navigationComponent().clickBack();
//			customerProfilePage.clickChangePassword();
			customerProfilePage.changePasswordPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.changePasswordPage().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangePasswordWithNavigationOptions Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithInvalidCurrentPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickProfile();
			customerProfilePage.clickChangePassword();
			customerProfilePage.changePasswordPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}
			customerProfilePage.changePasswordPage().navigationComponent().clickClose();
			customerProfilePage.changePasswordPage().clickLogout();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordWithInvalid Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickProfile();
			customerProfilePage.clickChangePassword();
			customerProfilePage.changePasswordPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().clickNext();
			customerProfilePage.changePasswordPage().verifyHeadingChangePassword(data.get("expChangePasswordHeading"));
			customerProfilePage.changePasswordPage().verifyChangePasswordContent(data.get("expChangePasswordContent"));
			String[] newPassword = data.get("newPassword").split(",");
			customerProfilePage.changePasswordPage().fieldValidationsComponent().validateNewPasswordField(
					newPassword[0], newPassword[1], newPassword[2], newPassword[3], newPassword[4], newPassword[5],
					newPassword[6], newPassword[7], newPassword[8], newPassword[9], newPassword[10], newPassword[11]);
			String[] confirmPassword = data.get("confirmPassword").split(",");
			customerProfilePage.changePasswordPage().fieldValidationsComponent()
					.validateConfirmPasswordField(confirmPassword[0], confirmPassword[1], confirmPassword[2]);
//			customerProfilePage.changePasswordPage().clickIconViewPassword();
//			customerProfilePage.changePasswordPage().verifyPassword();
//			DriverFactory.getDriver().hideKeyboard();
//			customerProfilePage.changePasswordPage().clickSave();
//			
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangePasswordWithFieldValidation Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetPinCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyResetPinCodeView();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(3000);
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));
			customerProfilePage.toastComponent().verifyToastMsg(data.get("toastMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Reset Pin Code failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetPinCodeViewFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyResetPinCodeView();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.enterYourPINComponent().navigationComponent().verifyCloseView();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickClose();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().clickForgotPin();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickClose();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().verifyChooseYourPinView();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().verifyConfirmYourPinView();
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test ResetPinCodeView Flow failed due to Exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			if (data.get("validateCredit").equalsIgnoreCase("Yes")) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCreditCard();
			} else
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCVVorCVC(data.get("cvvOrCVC"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addressLine1"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addreddLine2"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickAddCard();
//			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//					.preAuthorizationPage().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.preAuthorizationPage().navigationComponent().clickClose();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.navigationComponent().clickClose();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().navigationComponent()
					.clickClose();
			customerProfilePage.paymentMethodsPage().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test ResetPinCodeView Flow failed due to Exception " + e);

		}
	}

	public void testAddCardWithExsistingCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();

			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCVVorCVC(data.get("cvvOrCVC"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addressLine1"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addreddLine2"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickAddCard();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.preAuthorizationPage().fillAmount(data.get("amount"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.preAuthorizationPage().clickVerify();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.preAuthorizationPage().allDonePage().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
	public void testAddCardWithNoCards(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();

			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsPage().verifyCreditCount(data.get("count"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsPage().verifyDebitCount(data.get("count"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			}
			// customerProfilePage.paymentMethodsPage().verifyLimitError(data.get("limitError"));
			if (data.get("validateAddress").equalsIgnoreCase("Yes")) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillNameOnCard(data.get("nameOnCard"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillCardNumber(data.get("cardNumber"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillCardExp(data.get("cardExp"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.fillCVVorCVC(data.get("cvvOrCVC"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine2(data.get("addreddLine2"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillCity(data.get("city"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().selectState(data.get("state"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
				Thread.sleep(1000);
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickAddCard();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().fillAmount(data.get("preAuthiAmount"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().clickVerify();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().allDonePage()
						.verifyAllDoneHeading(data.get("successHeading"), data.get("successDescription"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().allDonePage().clickDone();
			}
			if (data.get("validateError").equalsIgnoreCase("Yes")) {
				customerProfilePage.paymentMethodsPage().verifyLimitError(data.get("limitError"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDebitCardDashboard(String strParams) throws InterruptedException {
		tokenAccountPage.btnHome();
		tokenAccountPage.tokenHomePopUp().clickBuyTokens();
		Thread.sleep(1000);
		testAddCardWithNoCards(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenCreditCardDashboard(String strParams) throws InterruptedException {
		tokenAccountPage.btnHome();
		tokenAccountPage.tokenHomePopUp().clickBuyTokens();
		Thread.sleep(1000);
		testAddCardWithNoCards(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) throws InterruptedException {
		tokenAccountPage.clickProfile();
		customerProfilePage.clickPaymentMethods();
//		customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
		testAddCardWithNoCards(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCreditCard(String strParams) throws InterruptedException {
		tokenAccountPage.clickProfile();
		customerProfilePage.clickPaymentMethods();
//		customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
		testAddCardWithNoCards(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardInstantPay(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		tokenAccountPage.btnHome();
		tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
		tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
				.fillNameOnCard(data.get("nameOnCard"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
				.fillCardNumber(data.get("cardNumber"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
				.fillCardExp(data.get("cardExp"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
				.fillCVVorCVC(data.get("cvvOrCVC"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.fillAddressLine1(data.get("addressLine1"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.fillAddressLine2(data.get("addreddLine2"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.fillCity(data.get("city"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.selectState(data.get("state"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.fillZipCode(data.get("zipCode"));
		Thread.sleep(1000);
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.clickAddCard();
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.preAuthorizationPage().fillAmount(data.get("preAuthiAmount"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.preAuthorizationPage().clickVerify();
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.preAuthorizationPage().allDonePage()
				.verifyAllDoneHeading(data.get("successHeading"), data.get("successDescription"));
		customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
				.preAuthorizationPage().allDonePage().clickDone();
//		testAddCardWithNoCards(strParams, "debit");
	}

//	@Test
//	@Parameters("strParams")
	public void testEditCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsPage().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsPage().clickDebitCard();
			}
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addressLine1"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addreddLine2"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditDebitCard(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testEditCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditCreditCard(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testEditCard(strParams, "credit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardFieldValidation(String strParams, String card) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsPage().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsPage().clickDebitCard();
			}
			String[] nameOnCard = data.get("nameOnCard").split(",");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateNameOnCardField(nameOnCard[0], nameOnCard[1], nameOnCard[2]);
			String[] cardNumber = data.get("cardNumber").split(",");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateCardNumberField(cardNumber[0], cardNumber[1], cardNumber[2]);
			String[] cardExp = data.get("cardExp").split(",");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateCardExpField(cardExp[0], cardExp[1], cardExp[2]);
			String[] cvvOrCVC = data.get("cvvOrCVC").split(",");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateCardCVVField(cvvOrCVC[0], cvvOrCVC[1], cvvOrCVC[2]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddCardFieldValidation Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardFieldValidation(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testAddCardFieldValidation(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testAddDebitCardFieldValidation Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCreditCardFieldValidation(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testAddCardFieldValidation(strParams, "credit");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testAddCreditCardFieldValidation Failed due to this Exception" + e);
		}
	}

	public void testAddAddressFieldValidation(String strParams, String card) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsPage().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsPage().clickDebitCard();
			}
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillNameOnCard(data.get("nameOnCard"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCVVorCVC(data.get("cvvOrCVC"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
			String[] addressLine1 = data.get("addressLine1").split(",");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateAddressLine1Field(addressLine1[0], addressLine1[1], addressLine1[2]);
//			String[] addressLine2 = data.get("addressLine2").split(",");
//			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
//					.validateAddressLine2Field(addressLine2[0], addressLine2[1], addressLine2[2]);	
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addreddLine2"));
			String[] city = data.get("city").split(",");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateCityField(city[0], city[1], city[2]);
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.selectState(data.get("state"));
			String[] zipCode = data.get("zipCode").split(",");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fieldValidationsComponent()
					.validateZipCodeField(zipCode[0], zipCode[1], zipCode[2]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddAddressDebitCardFieldValidation(String strParams) throws InterruptedException {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			testAddAddressFieldValidation(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddAddressCreditCardFieldValidation(String strParams) throws InterruptedException {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			testAddAddressFieldValidation(strParams, "credit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (tokenAccountPage.verifyProfile() == 1) {
				tokenAccountPage.clickProfileforPayments();
				customerProfilePage.clickPaymentMethods();
			}
			Thread.sleep(1000);
			int numOfDebitcards = customerProfilePage.paymentMethodsPage().verifyNumOfDebitCards();
			for (int i = 1; i <= numOfDebitcards; i++) {
				customerProfilePage.paymentMethodsPage().verifyPaymentHeading(data.get("paymentHeading"));
				customerProfilePage.paymentMethodsPage().clickDebitCard();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickRemove();
//				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//						.mailingAddressComponent().clickNo();
//				customerProfilePage.paymentMethodsPage().clickDebitCard();
//				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//						.mailingAddressComponent().clickRemove();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickYes();
				customerProfilePage.paymentMethodsPage().removingPopup().toastComponent()
						.verifyToastMsg(data.get("debitDeleteToastMsg"));

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteDebitCard Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (tokenAccountPage.verifyProfile() == 1) {
				tokenAccountPage.clickProfileforPayments();
				customerProfilePage.clickPaymentMethods();
			}
			Thread.sleep(2000);
			int numOfCreditCards = customerProfilePage.paymentMethodsPage().verifyNumOfCreditCards();
			for (int i = 1; i <= numOfCreditCards; i++) {
				customerProfilePage.paymentMethodsPage().verifyPaymentHeading(data.get("paymentHeading"));
				customerProfilePage.paymentMethodsPage().clickCreditCard();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickRemove();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickNo();
				customerProfilePage.paymentMethodsPage().clickCreditCard();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickRemove();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickYes();
				customerProfilePage.paymentMethodsPage().removingPopup().toastComponent()
						.verifyToastMsg(data.get("creditDeleteToastMsg"));
			}
//			customerProfilePage.paymentMethodsPage().verifyCreditCards();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardWithInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickProfile();
//			customerProfilePage.clickPaymentMethods();
			customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			}
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillNameOnCard(data.get("nameOnCard"));
			DriverFactory.getDriver().hideKeyboard();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCVVorCVC(data.get("cvvOrCVC"));
			if (data.get("validateAddress").equalsIgnoreCase("yes")) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine1(data.get("addressLine1"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillAddressLine2(data.get("addreddLine2"));
				DriverFactory.getDriver().hideKeyboard();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillCity(data.get("city"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().selectState(data.get("state"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			}
			if (!data.get("errMsg").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("elementName"));
			}
			if (data.get("validatePreAuthy").equalsIgnoreCase("yes")) {

				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickAddCard();

//				String[] msg = data.get("errMsg").split(",");
//				for (int i = 0; i <3; i++) {
//					System.out.println(msg[i]);
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().fillAmount(data.get("amount"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().clickVerify();
				// new CommonFunctions().validateFormErrorMessage(msg[i], "pre-Authorization");
				// }
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().fillAmount(data.get("amount"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().clickVerify();
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().fillAmount(data.get("amount"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().clickVerify();
				Thread.sleep(2000);
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().preAuthorizationFailedPage()
						.verifyHeading(data.get("statusHeading"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().preAuthorizationFailedPage()
						.verifyPreAuthDescription(data.get("preAuthContent"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().preAuthorizationFailedPage().clickOk();
			}

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testAddCardWithInvalidData(String strParams, String card) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			String[] details = data.get("details").split("-");
//			for (int i = 0; i < details.length; i++) {
//				String[] individualDetails = details[i].split(",");
//				//tokenAccountPage.clickProfile();
//			//	customerProfilePage.clickPaymentMethods();
//			//	customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
//				if (card.equalsIgnoreCase("credit")) {
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCreditCard();
//				} else {
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
//				}
//				if (individualDetails[0].equalsIgnoreCase("Yes")) {
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.fillNameOnCard(individualDetails[1]);
//					DriverFactory.getDriver().hideKeyboard();
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.fillCardNumber(individualDetails[2]);
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.fillCardExp(individualDetails[3]);
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.fillCVVorCVC(individualDetails[4]);
//				}
//				if (individualDetails[5].equalsIgnoreCase("yes")) {
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.mailingAddressComponent().fillAddressLine1(individualDetails[6]);
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.mailingAddressComponent().fillAddressLine2(individualDetails[7]);
//					DriverFactory.getDriver().hideKeyboard();
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.mailingAddressComponent().fillCity(individualDetails[8]);
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.mailingAddressComponent().selectState(individualDetails[9]);
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.mailingAddressComponent().fillZipCode(individualDetails[10]);
//				}
//				if (!individualDetails[11].isEmpty()) {
//					new CommonFunctions().validateFormErrorMessage(individualDetails[11], individualDetails[12]);
//				}
//				if(individualDetails[13].equalsIgnoreCase("Yes")) {
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().navigationComponent()
//							.clickBack();
//					}
//				if (individualDetails[14].equalsIgnoreCase("Yes")) {
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.navigationComponent().clickClose();
//					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
//							.navigationComponent().clickBack();
//				}
//			}
//		} catch (Exception e) {
//
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCardWithInvalidData(String strParams) {
		try {
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			testAddCardWithInvalidData(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddDebitCardWithInvalidData failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCreditCardWithInvalidData(String strParams) {
		try {
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			testAddCardWithInvalidData(strParams, "credit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddDebitCardWithInvalidData failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExpiredCreditAndDebit(String strParams) {
		try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			customerProfilePage.paymentMethodsPage().verifyExpiredDebit();
			customerProfilePage.paymentMethodsPage().verifyExpiredCredit();
			customerProfilePage.paymentMethodsPage().navigationComponent().clickBack();
			customerProfilePage.navigationComponent().clickBack();
			tokenAccountPage.btnHome();
			//Buy Tokens Flow//
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			customerProfilePage.paymentMethodsPage().verifyExpiredDebit();
			customerProfilePage.paymentMethodsPage().verifyExpiredCredit();
			customerProfilePage.paymentMethodsPage().clickCreditEditAndDelete();
			customerProfilePage.paymentMethodsPage().clickDebitEditAndDelete();
			customerProfilePage.paymentMethodsPage().verifyCreditOopsCondition();
			customerProfilePage.paymentMethodsPage().verifyDebitOopsCondition();
			customerProfilePage.paymentMethodsPage().clickCloseSelectPayments();
			//Withdraw To USD Flow//
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			customerProfilePage.paymentMethodsPage().verifyExpiredDebit();
			customerProfilePage.paymentMethodsPage().verifyExpiredCredit();
			customerProfilePage.paymentMethodsPage().verifyCreditOopsCondition();
			customerProfilePage.paymentMethodsPage().verifyDebitOopsCondition();
			//click last 4 digits//
			customerProfilePage.tokenAccountPage().withdrawMenuComponent().clickExistingCardInNoTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().fillCvv(data.get("cvvOrCVC"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().clickOk();
			//Buy Tokens Screen//
			customerProfilePage.tokenAccountPage().buyTokenComponent().clickArrow();
			customerProfilePage.paymentMethodsPage().verifyExpiredDebit();
			customerProfilePage.paymentMethodsPage().verifyExpiredCredit();
			customerProfilePage.paymentMethodsPage().verifyCreditOopsCondition();
			customerProfilePage.tokenAccountPage().buyTokenComponent().clickArrow();
			customerProfilePage.paymentMethodsPage().verifyDebitOopsCondition();
			customerProfilePage.paymentMethodsPage().navigationComponent().clickClose();
			customerProfilePage.paymentMethodsPage().navigationComponent().clickClose();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExpiredCreditAndDebit failed due to " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testExpiredCardsNewUser(String strParams) {
		try {
		//	 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 tokenAccountPage.btnHome();
			 tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			 tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickInstantPay();
			 tokenAccountPage.paymentMethodsPage().verifyDebitOopsCondition();
			 tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickInstantPay();
//			 tokenAccountPage.paymentMethodsPage().withdrawMenuComponent().clickExistingCard();
			 tokenAccountPage.paymentMethodsPage().withdrawMenuComponent().clickWithdrawTokens();
			 tokenAccountPage.paymentMethodsPage().verifyDebitOopsCondition();
			 customerProfilePage.paymentMethodsPage().navigationComponent().clickClose();
			 customerProfilePage.paymentMethodsPage().navigationComponent().clickClose();
			 
				
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExpiredCreditAndDebit failed due to " + e);
		}
	}
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddBank(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickProfile();
//			customerProfilePage.clickPaymentMethods();
//			customerProfilePage.paymentMethodsPage().clickExternalBankAccount();
//			customerProfilePage.paymentMethodsPage().verifyHeadingAddExternalBankAccount();
//			customerProfilePage.paymentMethodsPage().clickNext();
//			Thread.sleep(15000);
//			customerProfilePage.paymentMethodsPage().verifyHeadingAddAccount();
//			customerProfilePage.paymentMethodsPage().enterBankName();
//			customerProfilePage.paymentMethodsPage().selectBank();
//			customerProfilePage.paymentMethodsPage().fillUserName();
//			customerProfilePage.paymentMethodsPage().fillPassword();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testAddBank failed due to this Exception" + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickGetHelp();
			customerProfilePage.getHelpPage().verifyHeading(data.get("getHelpHeading"));
			customerProfilePage.getHelpPage().getHelpDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAllLinksInProfile(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyUserProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();
			customerProfilePage.userDetailsPage().navigationComponent().clickBack();
			customerProfilePage.clickPaymentMethods();
			customerProfilePage.paymentMethodsPage().navigationComponent().clickClose();
			customerProfilePage.clickPreferences();
			customerProfilePage.preferencesComponent().verifyPreferencesHeading();
			customerProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone1"));
			customerProfilePage.preferencesComponent().clickBackArrow();
			customerProfilePage.clickAccountLimits();
			customerProfilePage.accountLimitsComponent().verifyHeading();
			customerProfilePage.accountLimitsComponent().navigationComponent().clickBack();
			customerProfilePage.clickAgreements();
			customerProfilePage.agreementComponent().verifyHeading();
			customerProfilePage.agreementComponent().clickBack();
			customerProfilePage.clickGetHelp();
			customerProfilePage.getHelpPage().verifyGetHelp();
			customerProfilePage.getHelpPage().clickBack();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickClose();
			customerProfilePage.clickTogggle();
			customerProfilePage.setUpTouchIDPopup().verifyHeading();
			customerProfilePage.setUpTouchIDPopup().clickNotNow();
			customerProfilePage.clickChangePassword();
			customerProfilePage.changePasswordPage().enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.changePasswordPage().enterYourPINComponent().navigationComponent().clickClose();
			customerProfilePage.clickLogOut();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

}
