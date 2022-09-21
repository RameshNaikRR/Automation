package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.pages.CustomerProfilePage;
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
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyProfilePageView();
			customerProfilePage.verifyUserNameView();
			customerProfilePage.verifyAccountIDView();
			customerProfilePage.verifyAccountStatusView();
			customerProfilePage.verifyQRImageView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileView failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetailsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
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
			Thread.sleep(5000);
//			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().verifyLibraryView();
//			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().navigationComponent()
//					.verifyCloseView();
//			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().verifyDoneView();
//			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().clickImage();
//			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().clickDone();
//			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
//			// Navigation userDetailsPage - ChooseFromLibraryPopup
//			customerProfilePage.userDetailsPage().clickEditUserImage();
//			customerProfilePage.userDetailsPage().editUserImagePopup().clickChooseFromLibrary();
//			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().navigationComponent()
//					.clickClose();
//			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));

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
//			customerProfilePage.userDetailsPage().verifyEmailTitleView();
//			customerProfilePage.userDetailsPage().verifyExistingEmailView();
//			customerProfilePage.userDetailsPage().verifyEditEmailArrowView();

			// Navigation User Details-Enter Your Pin
			customerProfilePage.userDetailsPage().clickEditEmail();
			// customerProfilePage.userDetailsPage().verifyCurrentEmailHeading(data.get("currEmailHeading"));
			// customerProfilePage.userDetailsPage().verifyCurrentEmail(data.get("currEmail"));
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			// customerProfilePage.userDetailsPage().verifyCurrentEmailHeading(data.get("currEmailHeading"));
			customerProfilePage.userDetailsPage().clickBack();
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();

			// Navigation user Details -Verify New Email
			customerProfilePage.userDetailsPage().clickEditEmail();
			// customerProfilePage.userDetailsPage().verifyCurrentEmailHeading(data.get("currEmailHeading"));
			// customerProfilePage.userDetailsPage().verifyCurrentEmail(data.get("currEmail"));
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyCurrentEmail(data.get("email"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyDontHaveAccessView();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyContactUsView();
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
			// customerProfilePage.userDetailsPage().verifyCurrentEmailHeading(data.get("currEmailHeading"));
			// customerProfilePage.userDetailsPage().verifyCurrentEmail(data.get("currEmail"));
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
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
//					.verifyCurrentEmailHeading(data.get("currentEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyNewEmailHeading(data.get("newEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.successFailureComponent().viewEmailSuccessHeading();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.successFailureComponent().clickLogOut();
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
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			if (!data.get("errMessage").isEmpty()) {

				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "New Email");
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
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyPhoneNumberTitleView();
			// customerProfilePage.userDetailsPage().verifyExistingPhoneNumberView();
			// customerProfilePage.userDetailsPage().verifyEditPhoneNumberArrowView();
			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
			// customerProfilePage.userDetailsPage().enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyHeading(data.get("editphoneNumberHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyCurrentPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyDontHaveAccessView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyContactUsView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent()
					.verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent()
					.clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.fillNewPhoneNumber(data.get("newPhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhoneHeading(data.get("currentPhoneNumberHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhone(data.get("PhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyResendView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyHeading(data.get("editphoneNumberHeading"));

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
			// customerProfilePage.userDetailsPage().verifyCurrentPhoneNumHeading(data.get("currentPhoneNumHeading"));
			// customerProfilePage.userDetailsPage().verifyCurrentPhoneNum(data.get("currentPhoneNum"));
			customerProfilePage.userDetailsPage().clickChange();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
//					.verifyHeading(data.get("editPhoneHeading"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
//					.verifyCurrentPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.fillNewPhoneNumber(data.get("newPhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhoneHeading(data.get("currentPhoneHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyNewPhoneHeading(data.get("newPhoneHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit PhoneNumber view failed due to exception " + e);
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
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
//					.verifyCountry(data.get("country"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().clickSave();
			// Toast Message
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();
			// customerProfilePage.userDetailsPage().verifyAddress(data.get("expAddress"));
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
			Thread.sleep(10000);
			if (!data.get("errMessage").isEmpty()) {

				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Test Edit Address with invalid data failed due to exception " + e);
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
			// customerProfilePage.navigationComponent().clickClose();
			// customerProfilePage.clickQRImage();
			customerProfilePage.verifyMyQRCodeHeading(data.get("qrHeading"));
			customerProfilePage.verifyFirstAndLastName(data.get("expHeading"));
			customerProfilePage.verifyLabelMyQRCodeView();
			customerProfilePage.clickOnCopy();
			customerProfilePage.clickShare();
			customerProfilePage.verifyPopUp();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("TestCustomerProfileView failed due to exception " + e);
		}

	}

//
//	// Ios M
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddExternalBankAccountWithNavigateOption(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			customerProfilePage.clickPaymentMethods();
//			customerProfilePage.navigationComponent().clickClose();
//			customerProfilePage.clickPaymentMethods();
//			customerProfilePage.externalBankAccountPage().verifyHeading(data.get("addBankHeading"));
//			customerProfilePage.externalBankAccountPage().navigationComponent().clickBack();
//			customerProfilePage.externalBankAccountPage().clickLearnMore();
//			customerProfilePage.externalBankAccountPage().navigationComponent().clickClose();
//			customerProfilePage.externalBankAccountPage().clickNext();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Add External Bank Account Failed due to exception " + e);
//		}
//	}
//
//	// Ios M
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddExternalBankAccountWithUserHavePaymentMethods(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			customerProfilePage.externalBankAccountPage().clickNext();
//			customerProfilePage.externalBankAccountPage().verifyHeading(data.get("addBankHeading"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Add External Bank Account Failed due to exception " + e);
//		}
//	}

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
//			customerProfilePage.clickPayRequest();
//			customerProfilePage.verifyContactContent(data.get("conntactHeading"));
//			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.viewDashboard();
			// customerProfilePage.viewCrypto();
			customerProfilePage.viewIssueCard();
			customerProfilePage.viewProfile();
			customerProfilePage.clickCrypto();
//			customerProfilePage.verifyAssets(data.get("CryptoHeading"));
			// customerProfilePage.navigationComponent().clickClose();
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
	public void testDashboardTabBarMenu(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			customerProfilePage.viewDashboard();
//			customerProfilePage.viewCrypto();
//			customerProfilePage.viewIssueCard();
			customerProfilePage.viewProfile();
			// customerProfilePage.clickCrypto();
//			customerProfilePage.verifyAssets(data.get("cryptoHeading"));
//			customerProfilePage.navigationComponent().clickClose();
//			customerProfilePage.clickIssueCard();
//			customerProfilePage.verifyIssueCardHeading(data.get("issueHeading"));
//			customerProfilePage.navigationComponent().clickClose();
//			customerProfilePage.clickTokenMenu();
//			customerProfilePage.viewScan();
//			customerProfilePage.viewPayRequest();
//			customerProfilePage.viewBuyToken();
//			customerProfilePage.viewWithdrawnToUSD();
//			customerProfilePage.clickOutside();
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
			customerProfilePage.setUpTouchIDPopup().clickSetUpTouchID();
			customerProfilePage.setUpTouchIDPopup().verifyHeading(data.get("expHeading"));
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
			customerProfilePage.preferencesComponent().selectTimeZone(data.get("timeZone"));

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
//			customerProfilePage.agreementComponent().verifyActiveAgreementsView();
//			customerProfilePage.agreementComponent().verifyPastAgreementsView();
//			customerProfilePage.agreementComponent().verifyActiveAgreementsHeading(data.get("ActiveHeading"));
//			customerProfilePage.agreementComponent().verifyPastAgreementsHeading(data.get("pastHeading"));
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
	public void testAddBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			Thread.sleep(2000);
//			customerProfilePage.paymentMethodsPage().addNewPaymentComponent()
//					.verifyHeading(data.get("addPaymentHeading"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickExternalBankAcount();
//			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
//					.verifyHeading("addBankHeading");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.clickNext();
//			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
//					.addAccountsComponent().verifyHeadingAddAccount();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.addAccountsComponent().enterBankName(data.get("expBankName"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.addAccountsComponent().selectBank();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.addAccountsComponent().fillUserName(data.get("expUserName"));
			DriverFactory.getDriver().hideKeyboard();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.addAccountsComponent().fillPassword(data.get("expPassword"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.addAccountsComponent().clickNext();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.addAccountsComponent().unSelectBank1();
//			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
//					.addAccountsComponent().unSelectBank2();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.addAccountsComponent().clickNext();
//			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
//					.addAccountsComponent().verifyDoneHeading(data.get("expDoneHeading"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent()
					.addAccountsComponent().clickDone();
			// customerProfilePage.paymentMethodsPage().navigationComponent().clickClose();

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
			// customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
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
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
			customerProfilePage.paymentMethodsPage().selectBank();
			customerProfilePage.paymentMethodsPage().removingPopup().verifyHeading();
			customerProfilePage.paymentMethodsPage().removingPopup().clickYes();
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
			customerProfilePage.navigationComponent().clickBack();
			customerProfilePage.clickChangePassword();
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
			// customerProfilePage.enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.enterYourPINComponent().clickForgotPin();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			// customerProfilePage.enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickClose();
			Thread.sleep(2000);
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(1000);
			customerProfilePage.enterYourPINComponent().choosePinComponent().verifyChooseYourPinView();
			// customerProfilePage.enterYourPINComponent().navigationComponent().verifyBackView();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().verifyConfirmYourPinView();
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			// customerProfilePage.enterYourPINComponent().navigationComponent().verifyBackView();
			customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			Thread.sleep(2000);
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			Thread.sleep(5000);
			customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			Thread.sleep(5000);
//			customerProfilePage.enterYourPINComponent().verifyEnterYourPinView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test ResetPinCodeView Flow failed due to Exception " + e);

		}
	}

	public void testAddCardWithExsistingCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();

			Thread.sleep(2000);
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
			Thread.sleep(2000);
			CustomerProfilePage customerProfilePage = new CustomerProfilePage();
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			}
			Thread.sleep(2000);
			// customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
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

	@Test
	@Parameters({ "strParams" })
	public void testAddDebitCard(String strParams) {
		tokenAccountPage.clickProfile();
		customerProfilePage.clickPaymentMethods();
		customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
		testAddCardWithNoCards(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCreditCard(String strParams) {
		tokenAccountPage.clickProfile();
		customerProfilePage.clickPaymentMethods();
		customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
		testAddCardWithNoCards(strParams, "credit");
	}

	@Test
	@Parameters("strParams")
	public void testEditDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().clickDebitCard(data.get("cardNumber"));
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			// customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().fillCVVorCVC(data.get("cvvOrCVC"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addressLine1"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addreddLine2"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			Thread.sleep(2000);
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
	public void testDeleteDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().clickDebitCard(data.get("cardNumber"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickRemove();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickYes();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().clickCreditCard(data.get("cardNumber"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickRemove();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
					.clickYes();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddCardWithInvalidData(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			Thread.sleep(3000);
			customerProfilePage.paymentMethodsPage().clickAddNewPaymentMethod();
			Thread.sleep(3000);
			if (card.equalsIgnoreCase("credit")) {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickCreditCard();
			} else {
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			}
			Thread.sleep(2000);
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillNameOnCard(data.get("nameOnCard"));
			DriverFactory.getDriver().hideKeyboard();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardNumber(data.get("cardNumber"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCardExp(data.get("cardExp"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
					.fillCVVorCVC(data.get("cvvOrCVC"));
			Thread.sleep(2000);
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
			Thread.sleep(2000);
			if (data.get("validatePreAuthy").equalsIgnoreCase("yes")) {

				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().clickAddCard();

				String[] msg = data.get("errMsg").split(",");
				for (int i = 0; i < 2; i++) {
					System.out.println(msg[i]);
					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
							.mailingAddressComponent().preAuthorizationPage().fillAmount(data.get("amount"));
					customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
							.mailingAddressComponent().preAuthorizationPage().clickVerify();
					new CommonFunctions().validateFormErrorMessage(msg[i], "pre-Authorization");
				}
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().fillAmount(data.get("amount"));
				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().clickVerify();

				customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
						.mailingAddressComponent().preAuthorizationPage().preAuthorizationFailedPage()
						.verifyHeading(data.get("statusHeading"));

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
	public void testAddDebitCardWithInvalidData(String strParams) {
		try {
			testAddCardWithInvalidData(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddDebitCardWithInvalidData failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			customerProfilePage.paymentMethodsPage().clickExternalBankAccount();
			customerProfilePage.paymentMethodsPage().verifyHeadingAddExternalBankAccount();
			customerProfilePage.paymentMethodsPage().clickNext();
			Thread.sleep(15000);
			customerProfilePage.paymentMethodsPage().verifyHeadingAddAccount();
			customerProfilePage.paymentMethodsPage().enterBankName();
			customerProfilePage.paymentMethodsPage().selectBank();
			customerProfilePage.paymentMethodsPage().fillUserName();
			customerProfilePage.paymentMethodsPage().fillPassword();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddBank failed due to this Exception" + e);
		}
	}
}
